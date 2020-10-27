package com.baidu.live.view;

import android.app.Dialog;
import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.cq;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.NetWork;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private static volatile h bHp;
    private HashMap<String, LinkedList<cq>> mUserAttentionRequestMap = new HashMap<>();
    private HashMap<String, a> mAttentionTaskMap = new HashMap<>();

    private h() {
    }

    public static h Up() {
        if (bHp == null) {
            synchronized (h.class) {
                if (bHp == null) {
                    bHp = new h();
                }
            }
        }
        return bHp;
    }

    public void a(String str, cq cqVar) {
        if (!StringUtils.isNull(str) && cqVar != null) {
            LinkedList<cq> linkedList = this.mUserAttentionRequestMap.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.mUserAttentionRequestMap.put(str, linkedList);
            }
            a(linkedList, cqVar);
            executeAttentionTask(str);
        }
    }

    private void a(LinkedList<cq> linkedList, cq cqVar) {
        if (linkedList.size() < 1) {
            b(linkedList, cqVar);
        } else if (linkedList.getLast().ED().equals(cqVar.ED())) {
            if (BdLog.isDebugMode()) {
                try {
                    throw new IllegalArgumentException("new attention data is the same as the nearest attention data");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (linkedList.size() < 3) {
            b(linkedList, cqVar);
        } else if (linkedList.get(1).equals(cqVar)) {
            linkedList.removeLast();
        }
    }

    private void b(LinkedList<cq> linkedList, cq cqVar) {
        if (cqVar != null) {
            linkedList.add(cqVar.clone());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeAttentionTask(String str) {
        LinkedList<cq> linkedList;
        if (!StringUtils.isNull(str) && this.mAttentionTaskMap.get(str) == null && (linkedList = this.mUserAttentionRequestMap.get(str)) != null && linkedList.size() > 0) {
            a aVar = new a(this, null);
            this.mAttentionTaskMap.put(str, aVar);
            aVar.setPriority(2);
            aVar.a(linkedList.getFirst());
            aVar.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Integer, Integer, String> {
        private BdUniqueId bFF;
        private String bHr;
        private String from;
        private boolean isAttention;
        private boolean isGod;
        private String liveId;
        private NetWork mNetwork;
        private String roomId;

        private a() {
            this.mNetwork = null;
            this.isGod = false;
            this.from = "";
        }

        /* synthetic */ a(h hVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a(cq cqVar) {
            this.bHr = cqVar.ED();
            this.liveId = cqVar.getLiveId();
            this.roomId = cqVar.getRoomId();
            this.isAttention = cqVar.isAttention();
            this.bFF = cqVar.EB();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                this.mNetwork = new NetWork();
                if (this.isAttention) {
                    this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "ala/audio/user/follow");
                } else {
                    this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "ala/audio/user/unfollow");
                }
                if (!StringUtils.isNull(this.bHr)) {
                    this.mNetwork.addPostData("follow_user_uk", this.bHr);
                    this.mNetwork.addPostData("live_id", this.liveId);
                    this.mNetwork.addPostData("room_id", this.roomId);
                }
                this.mNetwork.isNeedTbs = true;
                return this.mNetwork.postNetData();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            if (this.mNetwork != null) {
                UpdateAttentionMessage.UpdateAttentionData updateAttentionData = new UpdateAttentionMessage.UpdateAttentionData();
                updateAttentionData.isSucc = this.mNetwork.isRequestSuccess();
                updateAttentionData.errorString = this.mNetwork.getErrorString();
                updateAttentionData.isAttention = this.isAttention;
                updateAttentionData.toUid = this.bHr;
                updateAttentionData.isGod = this.isGod;
                updateAttentionData.parserJson(str, true);
                updateAttentionData.response = this.mNetwork.getHttpResponse();
                updateAttentionData.response.mServerErrorCode = updateAttentionData.errorCode;
                if (updateAttentionData.isSucc) {
                    updateAttentionData.isSucc = updateAttentionData.response.mServerErrorCode == 0;
                }
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(updateAttentionData);
                updateAttentionMessage.setOrginalMessage(new CustomMessage((int) MessageConfig.BASE_CUSTOM_CMD, this.bFF));
                MessageManager.getInstance().dispatchResponsedMessage(updateAttentionMessage);
                h.this.a(updateAttentionData, this.from);
            }
            h.this.mAttentionTaskMap.remove(this.bHr);
            if (h.this.mUserAttentionRequestMap.containsKey(this.bHr)) {
                h.this.removeRequestListFirstByUid(this.bHr);
                h.this.executeAttentionTask(this.bHr);
            }
        }

        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage.UpdateAttentionData updateAttentionData, String str) {
        if (updateAttentionData != null && updateAttentionData.isSucc && updateAttentionData.isAttention) {
            String str2 = "other";
            if ("source_host_header".equals(str)) {
                str2 = "lefthead";
            } else if ("source_person_card".equals(str)) {
                str2 = "authorfloat";
            } else if ("source_guide_pop".equals(str)) {
                str2 = "barguide";
            } else if ("source_guide_pop_2".equals(str)) {
                str2 = "leaveguide";
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "follow").setContentExt(str2, null, null));
        }
    }

    public void removeRequestListFirstByUid(String str) {
        LinkedList<cq> linkedList = this.mUserAttentionRequestMap.get(str);
        if (linkedList != null && linkedList.size() > 0) {
            try {
                linkedList.removeFirst();
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.view.h$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ Dialog bFB;
        final /* synthetic */ TbPageContext bFC;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShowUtil.dismissDialog(this.bFB, this.bFC.getPageActivity());
        }
    }

    public boolean a(UpdateAttentionMessage.UpdateAttentionData updateAttentionData, final BdPageContext<?> bdPageContext, boolean z) {
        if (updateAttentionData == null || updateAttentionData.resultJson == null || updateAttentionData.response == null || bdPageContext == null || bdPageContext.getPageActivity() == null) {
            return false;
        }
        int i = updateAttentionData.response.mServerErrorCode;
        if (i == 3250001 || i == 3250002 || i == 3250003 || i == 3250004) {
            if (updateAttentionData.hasShownForbiddenAlert) {
                return true;
            }
            JSONObject optJSONObject = updateAttentionData.resultJson.optJSONObject("info");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("block_content");
                final String optString2 = optJSONObject.optString("block_dealurl");
                String optString3 = optJSONObject.optString("block_confirm");
                String optString4 = optJSONObject.optString("block_cancel");
                if (optString == null || optString2 == null || optString3 == null || optString4 == null) {
                    return false;
                }
                updateAttentionData.hasShownForbiddenAlert = true;
                BdAlertDialog bdAlertDialog = new BdAlertDialog(bdPageContext.getPageActivity());
                bdAlertDialog.setAutoNight(z);
                bdAlertDialog.setMessage(optString);
                bdAlertDialog.setPositiveButton(optString3, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.view.h.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        BrowserHelper.startWebActivity(bdPageContext.getPageActivity(), optString2);
                        bdAlertDialog2.dismiss();
                        TiebaInitialize.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                });
                bdAlertDialog.setNegativeButton(optString4, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.view.h.3
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        bdAlertDialog2.dismiss();
                        TiebaInitialize.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                });
                bdAlertDialog.create(bdPageContext).show();
                TiebaInitialize.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                return true;
            }
            return false;
        }
        return false;
    }
}
