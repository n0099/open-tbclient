package com.baidu.live.view;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.NetWork;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private static volatile a bsK;
    private HashMap<String, LinkedList<com.baidu.live.data.d>> mUserAttentionRequestMap = new HashMap<>();
    private HashMap<String, C0198a> mAttentionTaskMap = new HashMap<>();

    private a() {
    }

    public static a Qx() {
        if (bsK == null) {
            synchronized (a.class) {
                if (bsK == null) {
                    bsK = new a();
                }
            }
        }
        return bsK;
    }

    public void a(String str, com.baidu.live.data.d dVar) {
        if (!StringUtils.isNull(str) && dVar != null && dVar.getPortrait() != null) {
            LinkedList<com.baidu.live.data.d> linkedList = this.mUserAttentionRequestMap.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.mUserAttentionRequestMap.put(str, linkedList);
            }
            a(linkedList, dVar);
            executeAttentionTask(str);
        }
    }

    private void a(LinkedList<com.baidu.live.data.d> linkedList, com.baidu.live.data.d dVar) {
        if (linkedList.size() < 1) {
            b(linkedList, dVar);
            return;
        }
        com.baidu.live.data.d last = linkedList.getLast();
        if (last.getPortrait().equals(dVar.getPortrait()) && last.isAttention() == dVar.isAttention()) {
            if (BdLog.isDebugMode()) {
                try {
                    throw new IllegalArgumentException("new attention data is the same as the nearest attention data");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (linkedList.size() < 3) {
            b(linkedList, dVar);
        } else if (linkedList.get(1).equals(dVar)) {
            linkedList.removeLast();
        }
    }

    private void b(LinkedList<com.baidu.live.data.d> linkedList, com.baidu.live.data.d dVar) {
        if (dVar != null) {
            linkedList.add(dVar.clone());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeAttentionTask(String str) {
        LinkedList<com.baidu.live.data.d> linkedList;
        if (!StringUtils.isNull(str) && this.mAttentionTaskMap.get(str) == null && (linkedList = this.mUserAttentionRequestMap.get(str)) != null && linkedList.size() > 0) {
            C0198a c0198a = new C0198a();
            this.mAttentionTaskMap.put(str, c0198a);
            c0198a.setPriority(2);
            c0198a.a(linkedList.getFirst());
            c0198a.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0198a extends BdAsyncTask<Integer, Integer, String> {
        private BdUniqueId bsP;
        private String forumId;
        private String from;
        private String inLive;
        private boolean isAttention;
        private boolean isGod;
        private NetWork mNetwork;
        private String metaKey;
        private boolean showToastAfterAttentionSuc;
        private String toUid;

        private C0198a() {
            this.mNetwork = null;
            this.metaKey = "";
            this.isGod = false;
            this.from = "";
            this.inLive = "0";
            this.forumId = null;
            this.showToastAfterAttentionSuc = false;
        }

        public void a(com.baidu.live.data.d dVar) {
            this.isAttention = dVar.isAttention();
            this.toUid = dVar.getUserId();
            this.inLive = dVar.getInLive();
            this.bsP = dVar.Cs();
            this.from = dVar.getFrom();
            this.metaKey = dVar.Ct();
            if (this.forumId != null) {
                this.showToastAfterAttentionSuc = true;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                this.mNetwork = new NetWork();
                if (this.isAttention) {
                    this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "ala/user/follow");
                } else {
                    this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "ala/user/unfollow");
                }
                if (!StringUtils.isNull(this.toUid)) {
                    this.mNetwork.addPostData("follow_user_id", this.toUid);
                }
                this.mNetwork.addPostData("meta_key", this.metaKey);
                if (!StringUtils.isNull(this.forumId)) {
                    this.mNetwork.addPostData("forum_id", this.forumId);
                }
                this.mNetwork.addPostData("in_live", this.inLive);
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
            super.onPostExecute((C0198a) str);
            if (this.mNetwork != null) {
                UpdateAttentionMessage.UpdateAttentionData updateAttentionData = new UpdateAttentionMessage.UpdateAttentionData();
                updateAttentionData.isSucc = this.mNetwork.isRequestSuccess();
                updateAttentionData.errorString = this.mNetwork.getErrorString();
                updateAttentionData.isAttention = this.isAttention;
                updateAttentionData.toUid = this.toUid;
                updateAttentionData.isGod = this.isGod;
                updateAttentionData.parserJson(str, this.showToastAfterAttentionSuc);
                updateAttentionData.response = this.mNetwork.getHttpResponse();
                updateAttentionData.response.mServerErrorCode = updateAttentionData.errorCode;
                if (updateAttentionData.isSucc) {
                    updateAttentionData.isSucc = updateAttentionData.response.mServerErrorCode == 0;
                }
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(updateAttentionData);
                updateAttentionMessage.setOrginalMessage(new CustomMessage((int) MessageConfig.BASE_CUSTOM_CMD, this.bsP));
                MessageManager.getInstance().dispatchResponsedMessage(updateAttentionMessage);
                a.this.a(updateAttentionData, this.from);
            }
            a.this.mAttentionTaskMap.remove(this.toUid);
            if (a.this.mUserAttentionRequestMap.containsKey(this.toUid)) {
                a.this.removeRequestListFirstByUid(this.toUid);
                a.this.executeAttentionTask(this.toUid);
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
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "follow").setContentExt(str2, null, null));
        }
    }

    public void removeRequestListFirstByUid(String str) {
        LinkedList<com.baidu.live.data.d> linkedList = this.mUserAttentionRequestMap.get(str);
        if (linkedList != null && linkedList.size() > 0) {
            try {
                linkedList.removeFirst();
            } catch (Exception e) {
            }
        }
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        if (z) {
            e(tbPageContext);
        }
    }

    public void e(final TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (UtilHelper.getRealScreenOrientation(tbPageContext.getPageActivity()) == 2) {
                tbPageContext.showToast(a.i.sdk_attention_success_toast);
                return;
            }
            final Dialog dialog = new Dialog(tbPageContext.getPageActivity(), a.j.sdk_ActionSheetDialogStyle);
            dialog.setContentView(a.h.sdk_attention_tip_layout);
            Window window = dialog.getWindow();
            ((TextView) window.findViewById(a.g.ala_attention_tip_content_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ShowUtil.dismissDialog(dialog, tbPageContext.getPageActivity());
                }
            });
            window.findViewById(a.g.ala_attention_tip_root).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ShowUtil.dismissDialog(dialog, tbPageContext.getPageActivity());
                }
            });
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            ShowUtil.showDialog(dialog, tbPageContext.getPageActivity());
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
                bdAlertDialog.setPositiveButton(optString3, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.view.a.3
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        BrowserHelper.startWebActivity(bdPageContext.getPageActivity(), optString2);
                        bdAlertDialog2.dismiss();
                        TiebaInitialize.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                });
                bdAlertDialog.setNegativeButton(optString4, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.view.a.4
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
