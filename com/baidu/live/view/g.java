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
import com.baidu.live.data.cu;
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
public class g {
    private static volatile g bMU;
    private HashMap<String, LinkedList<cu>> mUserAttentionRequestMap = new HashMap<>();
    private HashMap<String, a> mAttentionTaskMap = new HashMap<>();

    private g() {
    }

    public static g WP() {
        if (bMU == null) {
            synchronized (g.class) {
                if (bMU == null) {
                    bMU = new g();
                }
            }
        }
        return bMU;
    }

    public void a(String str, cu cuVar) {
        if (!StringUtils.isNull(str) && cuVar != null) {
            LinkedList<cu> linkedList = this.mUserAttentionRequestMap.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.mUserAttentionRequestMap.put(str, linkedList);
            }
            a(linkedList, cuVar);
            executeAttentionTask(str);
        }
    }

    private void a(LinkedList<cu> linkedList, cu cuVar) {
        if (linkedList.size() < 1) {
            b(linkedList, cuVar);
        } else if (linkedList.getLast().Fe().equals(cuVar.Fe())) {
            if (BdLog.isDebugMode()) {
                try {
                    throw new IllegalArgumentException("new attention data is the same as the nearest attention data");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (linkedList.size() < 3) {
            b(linkedList, cuVar);
        } else if (linkedList.get(1).equals(cuVar)) {
            linkedList.removeLast();
        }
    }

    private void b(LinkedList<cu> linkedList, cu cuVar) {
        if (cuVar != null) {
            linkedList.add(cuVar.clone());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeAttentionTask(String str) {
        LinkedList<cu> linkedList;
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
        private BdUniqueId bLl;
        private String bMW;
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

        /* synthetic */ a(g gVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a(cu cuVar) {
            this.bMW = cuVar.Fe();
            this.liveId = cuVar.getLiveId();
            this.roomId = cuVar.getRoomId();
            this.isAttention = cuVar.isAttention();
            this.bLl = cuVar.Fc();
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
                if (!StringUtils.isNull(this.bMW)) {
                    this.mNetwork.addPostData("follow_user_uk", this.bMW);
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
                updateAttentionData.toUid = this.bMW;
                updateAttentionData.isGod = this.isGod;
                updateAttentionData.parserJson(str, true);
                updateAttentionData.response = this.mNetwork.getHttpResponse();
                updateAttentionData.response.mServerErrorCode = updateAttentionData.errorCode;
                if (updateAttentionData.isSucc) {
                    updateAttentionData.isSucc = updateAttentionData.response.mServerErrorCode == 0;
                }
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(updateAttentionData);
                updateAttentionMessage.setOrginalMessage(new CustomMessage((int) MessageConfig.BASE_CUSTOM_CMD, this.bLl));
                MessageManager.getInstance().dispatchResponsedMessage(updateAttentionMessage);
                g.this.a(updateAttentionData, this.from);
            }
            g.this.mAttentionTaskMap.remove(this.bMW);
            if (g.this.mUserAttentionRequestMap.containsKey(this.bMW)) {
                g.this.removeRequestListFirstByUid(this.bMW);
                g.this.executeAttentionTask(this.bMW);
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
        LinkedList<cu> linkedList = this.mUserAttentionRequestMap.get(str);
        if (linkedList != null && linkedList.size() > 0) {
            try {
                linkedList.removeFirst();
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.view.g$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ Dialog bLh;
        final /* synthetic */ TbPageContext bLi;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShowUtil.dismissDialog(this.bLh, this.bLi.getPageActivity());
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
                bdAlertDialog.setPositiveButton(optString3, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.view.g.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        BrowserHelper.startWebActivity(bdPageContext.getPageActivity(), optString2);
                        bdAlertDialog2.dismiss();
                        TiebaInitialize.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                });
                bdAlertDialog.setNegativeButton(optString4, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.view.g.3
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
