package com.baidu.live.view;

import android.app.Dialog;
import android.text.TextUtils;
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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.NetWork;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static volatile a bSx;
    private String mUserId;
    private HashMap<String, LinkedList<com.baidu.live.data.f>> mUserAttentionRequestMap = new HashMap<>();
    private HashMap<String, C0229a> mAttentionTaskMap = new HashMap<>();

    private a() {
    }

    public static a Xo() {
        if (bSx == null) {
            synchronized (a.class) {
                if (bSx == null) {
                    bSx = new a();
                }
            }
        }
        return bSx;
    }

    public void a(String str, com.baidu.live.data.f fVar) {
        if (!StringUtils.isNull(str) && fVar != null && fVar.getPortrait() != null) {
            LinkedList<com.baidu.live.data.f> linkedList = this.mUserAttentionRequestMap.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.mUserAttentionRequestMap.put(str, linkedList);
            }
            a(linkedList, fVar);
            executeAttentionTask(str);
        }
    }

    public void b(String str, com.baidu.live.data.f fVar) {
        if (!StringUtils.isNull(str) && fVar != null) {
            LinkedList<com.baidu.live.data.f> linkedList = this.mUserAttentionRequestMap.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.mUserAttentionRequestMap.put(str, linkedList);
            }
            a(linkedList, fVar);
            executeAttentionTask(str);
        }
    }

    private void a(LinkedList<com.baidu.live.data.f> linkedList, com.baidu.live.data.f fVar) {
        if (linkedList.size() < 1) {
            b(linkedList, fVar);
            return;
        }
        com.baidu.live.data.f last = linkedList.getLast();
        if (last.getPortrait().equals(fVar.getPortrait()) && last.isAttention() == fVar.isAttention()) {
            if (BdLog.isDebugMode()) {
                try {
                    throw new IllegalArgumentException("new attention data is the same as the nearest attention data");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (linkedList.size() < 3) {
            b(linkedList, fVar);
        } else if (linkedList.get(1).equals(fVar)) {
            linkedList.removeLast();
        }
    }

    private void b(LinkedList<com.baidu.live.data.f> linkedList, com.baidu.live.data.f fVar) {
        if (fVar != null) {
            linkedList.add(fVar.clone());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeAttentionTask(String str) {
        LinkedList<com.baidu.live.data.f> linkedList;
        if (!StringUtils.isNull(str) && this.mAttentionTaskMap.get(str) == null && (linkedList = this.mUserAttentionRequestMap.get(str)) != null && linkedList.size() > 0) {
            C0229a c0229a = new C0229a();
            this.mAttentionTaskMap.put(str, c0229a);
            c0229a.setPriority(2);
            c0229a.a(linkedList.getFirst());
            c0229a.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0229a extends BdAsyncTask<Integer, Integer, String> {
        private BdUniqueId bSB;
        private String forumId;
        private String from;
        private String inLive;
        private boolean isAttention;
        private boolean isGod;
        private NetWork mNetwork;
        private String metaKey;
        private boolean showToastAfterAttentionSuc;
        private String toUid;

        private C0229a() {
            this.mNetwork = null;
            this.metaKey = "";
            this.isGod = false;
            this.from = "";
            this.inLive = "0";
            this.forumId = null;
            this.showToastAfterAttentionSuc = false;
        }

        public void a(com.baidu.live.data.f fVar) {
            this.isAttention = fVar.isAttention();
            this.toUid = fVar.getUserId();
            this.inLive = fVar.getInLive();
            this.bSB = fVar.Bk();
            this.from = fVar.getFrom();
            this.metaKey = fVar.Bl();
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
                this.mNetwork.addPostData(HttpRequest.LIVE_SCENE, TbConfig.liveScene + "");
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
            super.onPostExecute((C0229a) str);
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
                if (updateAttentionData.isSucc) {
                    updateAttentionData.isSucc = updateAttentionData.errno == 0;
                }
                if (!TextUtils.isEmpty(updateAttentionData.usermsg)) {
                    updateAttentionData.errorString = updateAttentionData.usermsg;
                } else if (!TextUtils.isEmpty(updateAttentionData.errmsg)) {
                    updateAttentionData.errorString = updateAttentionData.errmsg;
                }
                if (TextUtils.isEmpty(updateAttentionData.errorString)) {
                    updateAttentionData.errorString = TbadkCoreApplication.getInst().getResources().getString(a.h.sdk_op_failed_toast);
                }
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(updateAttentionData);
                updateAttentionMessage.setOrginalMessage(new CustomMessage((int) MessageConfig.BASE_CUSTOM_CMD, this.bSB));
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
        LinkedList<com.baidu.live.data.f> linkedList = this.mUserAttentionRequestMap.get(str);
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
                tbPageContext.showToast(a.h.sdk_attention_success_toast);
                return;
            }
            final Dialog dialog = new Dialog(tbPageContext.getPageActivity(), a.i.sdk_ActionSheetDialogStyle);
            dialog.setContentView(a.g.sdk_attention_tip_layout);
            Window window = dialog.getWindow();
            ((TextView) window.findViewById(a.f.ala_attention_tip_content_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ShowUtil.dismissDialog(dialog, tbPageContext.getPageActivity());
                }
            });
            window.findViewById(a.f.ala_attention_tip_root).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.a.2
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
        JSONObject optJSONObject;
        if (updateAttentionData == null || updateAttentionData.resultJson == null || updateAttentionData.response == null || bdPageContext == null || bdPageContext.getPageActivity() == null) {
            return false;
        }
        int i = updateAttentionData.response.mServerErrorCode;
        if (!(i == 3250001 || i == 3250002 || i == 3250003 || i == 3250004) || updateAttentionData.hasShownForbiddenAlert || (optJSONObject = updateAttentionData.resultJson.optJSONObject("info")) == null) {
            return false;
        }
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

    public void o(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] != null && !com.baidu.live.utils.f.isNumeric(strArr[i])) {
                strArr[i] = ExtraParamsManager.getDecryptUserId(strArr[i]);
            }
            if (Xp() != null && Xp().equals(strArr[i])) {
                UpdateAttentionMessage.UpdateAttentionData updateAttentionData = new UpdateAttentionMessage.UpdateAttentionData();
                updateAttentionData.isSucc = true;
                updateAttentionData.errorString = null;
                updateAttentionData.isAttention = true;
                updateAttentionData.toUid = Xp();
                updateAttentionData.isGod = false;
                updateAttentionData.isShowMessage = false;
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(updateAttentionData);
                updateAttentionMessage.setOrginalMessage(new CustomMessage((int) MessageConfig.BASE_CUSTOM_CMD, BdUniqueId.gen()));
                MessageManager.getInstance().dispatchResponsedMessage(updateAttentionMessage);
                return;
            }
        }
    }

    public String Xp() {
        return this.mUserId;
    }

    public void ik(String str) {
        this.mUserId = str;
    }
}
