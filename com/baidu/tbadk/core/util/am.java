package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class am {
    private com.baidu.tbadk.core.dialog.a abn;
    private TbPageContext eCn;
    private com.baidu.tbadk.coreExtra.model.a eHC;
    private AttentionHostData eHD;
    private int eHE;
    private a eHF;
    private CustomMessageListener eHG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.am.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (am.this.eHD != null && !StringUtils.isNull(am.this.eHD.uid) && data != null && am.this.eHD.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(am.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(am.this.eCn.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).bmI();
                        } else {
                            AntiHelper.a(am.this.eCn.getPageActivity(), data.eYM);
                        }
                    }
                    if (data.isSucc) {
                        am.this.eHD.likeStatus = data.status;
                        am.this.eHD.isAttention = data.isAttention;
                    }
                    if (z && am.this.eHF != null) {
                        am.this.eHF.r(data.isSucc, am.this.eHE);
                    }
                }
            }
        }
    };
    private BdUniqueId mId = BdUniqueId.gen();
    public static int eHx = 0;
    public static int eHy = 1;
    public static int eHz = 2;
    public static int eHA = 2;
    public static int eHB = 3;

    /* loaded from: classes.dex */
    public interface a {
        void r(boolean z, int i);
    }

    public am(TbPageContext tbPageContext) {
        this.eCn = tbPageContext;
        this.eHG.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.eHG);
    }

    public boolean oJ(int i) {
        if (i == eHB) {
            com.baidu.adp.lib.util.l.showToast(this.eCn.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean aN(int i, int i2) {
        this.eHE = i2;
        if (i == eHA) {
            if (this.eHD == null || this.eHD.isAttention) {
                return true;
            }
            boC();
            return false;
        } else if (i == eHB) {
            com.baidu.adp.lib.util.l.showToast(this.eCn.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public boolean oK(int i) {
        if (i == eHA) {
            if (this.eHD == null || this.eHD.isAttention) {
                return true;
            }
            com.baidu.adp.lib.util.l.showToast(this.eCn.getPageActivity(), R.string.message_privacy_fans_can_reply);
            return false;
        } else if (i == eHB) {
            com.baidu.adp.lib.util.l.showToast(this.eCn.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.eHD = attentionHostData;
    }

    private void boC() {
        if (this.abn == null) {
            this.abn = new com.baidu.tbadk.core.dialog.a(this.eCn.getPageActivity());
            this.abn.om(R.string.message_privacy_fans_can_reply);
            this.abn.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.am.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.boD();
                    am.this.abn.dismiss();
                }
            });
            this.abn.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.am.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.abn.dismiss();
                }
            });
            this.abn.setAutoNight(true);
            this.abn.b(this.eCn);
        }
        this.abn.bmC();
    }

    public void a(bp bpVar) {
        if (bpVar != null && !StringUtils.isNull(bpVar.title) && !StringUtils.isNull(bpVar.ewY) && !StringUtils.isNull(bpVar.ewZ)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCn.getPageActivity());
            aVar.Ba(bpVar.title);
            aVar.a(bpVar.ewZ, new a.b() { // from class: com.baidu.tbadk.core.util.am.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    am.this.boD();
                    aVar2.dismiss();
                }
            });
            aVar.b(bpVar.ewY, new a.b() { // from class: com.baidu.tbadk.core.util.am.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.eCn);
            aVar.bmC();
            return;
        }
        boC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boD() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.eCn.showToast(R.string.network_ungeilivable);
        } else if (this.eHD != null && bg.checkUpIsLogin(this.eCn.getPageActivity())) {
            if (this.eHC == null) {
                this.eHC = new com.baidu.tbadk.coreExtra.model.a(this.eCn);
            }
            this.eHC.a(true, this.eHD.portrait, this.eHD.uid, this.eHD.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.eHF = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.abn != null) {
            this.abn.dismiss();
        }
        if (this.eHC != null) {
            this.eHC.cancel();
        }
    }
}
