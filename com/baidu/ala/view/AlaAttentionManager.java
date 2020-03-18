package com.baidu.ala.view;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.AlaAttentionData;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.messageCenter.d;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaAttentionManager {
    private static final int ALA_LIVE_PUSH_REMIND_TIME_INTERVAL = 86400000;
    private static final int ATTENTION_REQUEST_MAP_MAX_SIZE = 3;
    private static AlaAttentionManager sInstance;
    private HashMap<String, LinkedList<AlaAttentionData>> mUserAttentionRequestMap = new HashMap<>();
    private HashMap<String, AttentionAsyncTask> mAttentionTaskMap = new HashMap<>();

    private AlaAttentionManager() {
    }

    public static AlaAttentionManager getInstance() {
        if (sInstance == null) {
            synchronized (AlaAttentionManager.class) {
                if (sInstance == null) {
                    sInstance = new AlaAttentionManager();
                }
            }
        }
        return sInstance;
    }

    public void updateAttention(String str, AlaAttentionData alaAttentionData) {
        if (!StringUtils.isNull(str) && alaAttentionData != null && alaAttentionData.getPortrait() != null) {
            LinkedList<AlaAttentionData> linkedList = this.mUserAttentionRequestMap.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.mUserAttentionRequestMap.put(str, linkedList);
            }
            dealAttentionUpdateData(linkedList, alaAttentionData);
            executeAttentionTask(str);
        }
    }

    private void dealAttentionUpdateData(LinkedList<AlaAttentionData> linkedList, AlaAttentionData alaAttentionData) {
        if (linkedList.size() < 1) {
            addAttentionReqeustList(linkedList, alaAttentionData);
            return;
        }
        AlaAttentionData last = linkedList.getLast();
        if (last.getPortrait().equals(alaAttentionData.getPortrait()) && last.isAttention() == alaAttentionData.isAttention()) {
            if (BdLog.isDebugMode()) {
                throw new IllegalArgumentException("new attention data is the same as the nearest attention data");
            }
        } else if (linkedList.size() < 3) {
            addAttentionReqeustList(linkedList, alaAttentionData);
        } else if (linkedList.get(1).equals(alaAttentionData)) {
            linkedList.removeLast();
        }
    }

    private void addAttentionReqeustList(LinkedList<AlaAttentionData> linkedList, AlaAttentionData alaAttentionData) {
        if (alaAttentionData != null) {
            linkedList.add(alaAttentionData.m17clone());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeAttentionTask(String str) {
        LinkedList<AlaAttentionData> linkedList;
        if (!StringUtils.isNull(str) && this.mAttentionTaskMap.get(str) == null && (linkedList = this.mUserAttentionRequestMap.get(str)) != null && linkedList.size() > 0) {
            AttentionAsyncTask attentionAsyncTask = new AttentionAsyncTask();
            this.mAttentionTaskMap.put(str, attentionAsyncTask);
            attentionAsyncTask.setPriority(2);
            attentionAsyncTask.setAlaAttentionData(linkedList.getFirst());
            attentionAsyncTask.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class AttentionAsyncTask extends BdAsyncTask<Integer, Integer, String> {
        private String forumId;
        private String from;
        private String inLive;
        private boolean isAttention;
        private boolean isGod;
        private x mNetwork;
        private BdUniqueId pageId;
        private String portrait;
        private boolean showToastAfterAttentionSuc;
        private String toUid;

        private AttentionAsyncTask() {
            this.mNetwork = null;
            this.isGod = false;
            this.from = "0";
            this.inLive = "0";
            this.forumId = null;
            this.showToastAfterAttentionSuc = false;
        }

        public void setAlaAttentionData(AlaAttentionData alaAttentionData) {
            this.isAttention = alaAttentionData.isAttention();
            this.toUid = alaAttentionData.getUserId();
            this.portrait = alaAttentionData.getPortrait();
            this.inLive = alaAttentionData.getInLive();
            this.pageId = alaAttentionData.getPageId();
            this.from = alaAttentionData.getFrom();
            this.forumId = alaAttentionData.getForumId();
            this.isGod = alaAttentionData.isGod();
            if (this.forumId != null) {
                this.showToastAfterAttentionSuc = true;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                if (this.portrait != null) {
                    this.mNetwork = new x();
                    if (this.isAttention) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/c/user/follow");
                        this.mNetwork.fL(true);
                    } else {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/c/user/unfollow");
                    }
                    this.mNetwork.addPostData("portrait", this.portrait);
                    if (!StringUtils.isNull(this.from)) {
                        this.mNetwork.addPostData("from_type", this.from);
                    }
                    if (!StringUtils.isNull(this.forumId)) {
                        this.mNetwork.addPostData("forum_id", this.forumId);
                    }
                    this.mNetwork.addPostData("in_live", this.inLive);
                    this.mNetwork.aGk().aGL().mIsNeedTbs = true;
                    return this.mNetwork.postNetData();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((AttentionAsyncTask) str);
            if (this.mNetwork != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.isSucc = this.mNetwork.aGk().aGM().isRequestSuccess();
                aVar.errorString = this.mNetwork.getErrorString();
                aVar.isAttention = this.isAttention;
                aVar.toUid = this.toUid;
                aVar.isGod = this.isGod;
                aVar.parserJson(str, this.showToastAfterAttentionSuc);
                aVar.daY = this.mNetwork.aGk().aGM();
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                updateAttentionMessage.setOrginalMessage(new CustomMessage((int) MessageConfig.BASE_CUSTOM_CMD, this.pageId));
                MessageManager.getInstance().dispatchResponsedMessage(updateAttentionMessage);
            }
            AlaAttentionManager.this.mAttentionTaskMap.remove(this.toUid);
            if (AlaAttentionManager.this.mUserAttentionRequestMap.containsKey(this.toUid)) {
                AlaAttentionManager.this.removeRequestListFirstByUid(this.toUid);
                AlaAttentionManager.this.executeAttentionTask(this.toUid);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
        }
    }

    public void cancelAllTask() {
        for (AttentionAsyncTask attentionAsyncTask : this.mAttentionTaskMap.values()) {
            if (attentionAsyncTask != null) {
                attentionAsyncTask.cancel();
            }
        }
        this.mAttentionTaskMap.clear();
    }

    public void cancelTaskByToUid(String str) {
        AttentionAsyncTask attentionAsyncTask = this.mAttentionTaskMap.get(str);
        if (attentionAsyncTask != null) {
            attentionAsyncTask.cancel();
        }
        this.mAttentionTaskMap.remove(str);
    }

    public void removeRequestListFirstByUid(String str) {
        LinkedList<AlaAttentionData> linkedList = this.mUserAttentionRequestMap.get(str);
        if (linkedList != null && linkedList.size() > 0) {
            try {
                linkedList.removeFirst();
            } catch (Exception e) {
            }
        }
    }

    public void removeRequestListByUid(String str) {
        this.mUserAttentionRequestMap.get(str).clear();
        this.mUserAttentionRequestMap.remove(str);
    }

    public void removeRequestListAll() {
        for (LinkedList<AlaAttentionData> linkedList : this.mUserAttentionRequestMap.values()) {
            if (linkedList != null) {
                linkedList.clear();
            }
        }
        this.mUserAttentionRequestMap.clear();
    }

    private void saveLastShowTime() {
        b.aFH().putLong(SharedPrefConfig.ALA_LIVE_PUSH_REMIND_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return b.aFH().getLong(SharedPrefConfig.ALA_LIVE_PUSH_REMIND_SHOWTIME + getUserId(), 0L);
    }

    private String getUserId() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            String id = currentAccountInfo.getID();
            if (!TextUtils.isEmpty(id)) {
                return id;
            }
        }
        return "";
    }

    public void showAttentionSuccessTipAndLivePushDialog(TbPageContext tbPageContext, boolean z) {
        if (System.currentTimeMillis() - getLastShowTime() < 86400000 || d.aLq().aLs()) {
            if (z) {
                showAttentionSucceedTip(tbPageContext);
                return;
            }
            return;
        }
        showLivePushRemindDialog(tbPageContext, z);
    }

    public void showLivePushRemindDialog(TbPageContext tbPageContext, boolean z) {
        if (!d.aLq().aLs()) {
            new AlaLivePushRemindDialog(tbPageContext).showDialog(z);
            saveLastShowTime();
        }
    }

    public void showAttentionSucceedTip(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            tbPageContext.showToast((int) R.string.ala_attention_success_toast);
        }
    }

    public boolean checkIsForbidden(UpdateAttentionMessage.a aVar, final e<?> eVar, boolean z) {
        if (aVar == null || aVar.resultJson == null || aVar.daY == null || eVar == null || eVar.getPageActivity() == null) {
            return false;
        }
        int i = aVar.daY.mServerErrorCode;
        if (i == 3250001 || i == 3250002 || i == 3250003 || i == 3250004) {
            if (aVar.hasShownForbiddenAlert) {
                return true;
            }
            JSONObject optJSONObject = aVar.resultJson.optJSONObject("info");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("block_content");
                final String optString2 = optJSONObject.optString("block_dealurl");
                String optString3 = optJSONObject.optString("block_confirm");
                String optString4 = optJSONObject.optString("block_cancel");
                if (optString == null || optString2 == null || optString3 == null || optString4 == null) {
                    return false;
                }
                aVar.hasShownForbiddenAlert = true;
                a aVar2 = new a(eVar.getPageActivity());
                aVar2.setAutoNight(z);
                aVar2.sR(optString);
                aVar2.a(optString3, new a.b() { // from class: com.baidu.ala.view.AlaAttentionManager.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(a aVar3) {
                        com.baidu.tbadk.browser.a.startWebActivity(eVar.getPageActivity(), optString2);
                        aVar3.dismiss();
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
                    }
                });
                aVar2.b(optString4, new a.b() { // from class: com.baidu.ala.view.AlaAttentionManager.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(a aVar3) {
                        aVar3.dismiss();
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
                    }
                });
                aVar2.b(eVar).aEG();
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
                return true;
            }
            return false;
        }
        return false;
    }
}
