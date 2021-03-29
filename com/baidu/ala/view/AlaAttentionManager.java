package com.baidu.ala.view;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.AlaAttentionData;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import d.b.b.a.f;
import d.b.h0.r.d0.b;
import d.b.h0.r.s.a;
import d.b.h0.s.d.d;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AlaAttentionManager {
    public static final int ALA_LIVE_PUSH_REMIND_TIME_INTERVAL = 86400000;
    public static final int ATTENTION_REQUEST_MAP_MAX_SIZE = 3;
    public static AlaAttentionManager sInstance;
    public HashMap<String, LinkedList<AlaAttentionData>> mUserAttentionRequestMap = new HashMap<>();
    public HashMap<String, AttentionAsyncTask> mAttentionTaskMap = new HashMap<>();

    /* loaded from: classes.dex */
    public class AttentionAsyncTask extends BdAsyncTask<Integer, Integer, String> {
        public String forumId;
        public String from;
        public String inLive;
        public boolean isAttention;
        public boolean isGod;
        public NetWork mNetwork;
        public BdUniqueId pageId;
        public String portrait;
        public boolean showToastAfterAttentionSuc;
        public String toUid;

        public AttentionAsyncTask() {
            this.mNetwork = null;
            this.isGod = false;
            this.from = "0";
            this.inLive = "0";
            this.forumId = null;
            this.showToastAfterAttentionSuc = false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.mNetwork;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.mNetwork = null;
            }
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
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                if (this.portrait != null) {
                    NetWork netWork = new NetWork();
                    this.mNetwork = netWork;
                    if (this.isAttention) {
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ADDRESS);
                        this.mNetwork.setNeedSig(true);
                    } else {
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.mNetwork.addPostData("portrait", this.portrait);
                    if (!StringUtils.isNull(this.from)) {
                        this.mNetwork.addPostData("from_type", this.from);
                    }
                    if (!StringUtils.isNull(this.forumId)) {
                        this.mNetwork.addPostData("forum_id", this.forumId);
                    }
                    this.mNetwork.addPostData("in_live", this.inLive);
                    this.mNetwork.getNetContext().getRequest().mIsNeedTbs = true;
                    return this.mNetwork.postNetData();
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((AttentionAsyncTask) str);
            if (this.mNetwork != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.f13693a = this.mNetwork.getNetContext().getResponse().isRequestSuccess();
                aVar.f13694b = this.mNetwork.getErrorString();
                aVar.f13696d = this.isAttention;
                aVar.f13695c = this.toUid;
                aVar.f13697e = this.isGod;
                aVar.b(str, this.showToastAfterAttentionSuc);
                aVar.f13698f = this.mNetwork.getNetContext().getResponse();
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.pageId));
                MessageManager.getInstance().dispatchResponsedMessage(updateAttentionMessage);
            }
            AlaAttentionManager.this.mAttentionTaskMap.remove(this.toUid);
            if (AlaAttentionManager.this.mUserAttentionRequestMap.containsKey(this.toUid)) {
                AlaAttentionManager.this.removeRequestListFirstByUid(this.toUid);
                AlaAttentionManager.this.executeAttentionTask(this.toUid);
            }
        }
    }

    private void addAttentionReqeustList(LinkedList<AlaAttentionData> linkedList, AlaAttentionData alaAttentionData) {
        if (alaAttentionData == null) {
            return;
        }
        linkedList.add(alaAttentionData.m10clone());
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

    private long getLastShowTime() {
        b i = b.i();
        return i.k("ala_live_push_remind_showtime" + getUserId(), 0L);
    }

    private String getUserId() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            String id = currentAccountInfo.getID();
            return !TextUtils.isEmpty(id) ? id : "";
        }
        return "";
    }

    private void saveLastShowTime() {
        long currentTimeMillis = System.currentTimeMillis();
        b i = b.i();
        i.v("ala_live_push_remind_showtime" + getUserId(), currentTimeMillis);
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

    public boolean checkIsForbidden(UpdateAttentionMessage.a aVar, final f<?> fVar, boolean z) {
        if (aVar != null && aVar.f13699g != null && aVar.f13698f != null && fVar != null && fVar.getPageActivity() != null) {
            int i = aVar.f13698f.mServerErrorCode;
            if (!(i == 3250001 || i == 3250002 || i == 3250003 || i == 3250004)) {
                return false;
            }
            if (aVar.f13700h) {
                return true;
            }
            JSONObject optJSONObject = aVar.f13699g.optJSONObject("info");
            if (optJSONObject == null) {
                return false;
            }
            String optString = optJSONObject.optString("block_content");
            final String optString2 = optJSONObject.optString("block_dealurl");
            String optString3 = optJSONObject.optString("block_confirm");
            String optString4 = optJSONObject.optString("block_cancel");
            if (optString != null && optString2 != null && optString3 != null && optString4 != null) {
                aVar.f13700h = true;
                a aVar2 = new a(fVar.getPageActivity());
                aVar2.setAutoNight(z);
                aVar2.setMessage(optString);
                aVar2.setPositiveButton(optString3, new a.e() { // from class: com.baidu.ala.view.AlaAttentionManager.1
                    @Override // d.b.h0.r.s.a.e
                    public void onClick(a aVar3) {
                        d.b.h0.l.a.l(fVar.getPageActivity(), optString2);
                        aVar3.dismiss();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                });
                aVar2.setNegativeButton(optString4, new a.e() { // from class: com.baidu.ala.view.AlaAttentionManager.2
                    @Override // d.b.h0.r.s.a.e
                    public void onClick(a aVar3) {
                        aVar3.dismiss();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                });
                aVar2.create(fVar).show();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                return true;
            }
        }
        return false;
    }

    public void removeRequestListAll() {
        for (LinkedList<AlaAttentionData> linkedList : this.mUserAttentionRequestMap.values()) {
            if (linkedList != null) {
                linkedList.clear();
            }
        }
        this.mUserAttentionRequestMap.clear();
    }

    public void removeRequestListByUid(String str) {
        this.mUserAttentionRequestMap.get(str).clear();
        this.mUserAttentionRequestMap.remove(str);
    }

    public void removeRequestListFirstByUid(String str) {
        LinkedList<AlaAttentionData> linkedList = this.mUserAttentionRequestMap.get(str);
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        try {
            linkedList.removeFirst();
        } catch (Exception unused) {
        }
    }

    public void showAttentionSucceedTip(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return;
        }
        tbPageContext.showToast(R.string.ala_attention_success_toast);
    }

    public void showAttentionSuccessTipAndLivePushDialog(TbPageContext tbPageContext, boolean z) {
        if (System.currentTimeMillis() - getLastShowTime() >= 86400000 && !d.d().s()) {
            showLivePushRemindDialog(tbPageContext, z);
        } else if (z) {
            showAttentionSucceedTip(tbPageContext);
        }
    }

    public void showLivePushRemindDialog(TbPageContext tbPageContext, boolean z) {
        if (d.d().s()) {
            return;
        }
        new AlaLivePushRemindDialog(tbPageContext).showDialog(z);
        saveLastShowTime();
    }

    public void updateAttention(String str, AlaAttentionData alaAttentionData) {
        if (StringUtils.isNull(str) || alaAttentionData == null || alaAttentionData.getPortrait() == null) {
            return;
        }
        LinkedList<AlaAttentionData> linkedList = this.mUserAttentionRequestMap.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.mUserAttentionRequestMap.put(str, linkedList);
        }
        dealAttentionUpdateData(linkedList, alaAttentionData);
        executeAttentionTask(str);
    }
}
