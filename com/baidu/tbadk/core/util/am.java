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
    public static int ekC = 0;
    public static int ekD = 1;
    public static int ekE = 2;
    public static int ekF = 2;
    public static int ekG = 3;
    private com.baidu.tbadk.core.dialog.a aaD;
    private TbPageContext efr;
    private com.baidu.tbadk.coreExtra.model.a ekH;
    private AttentionHostData ekI;
    private int ekJ;
    private a ekK;
    private CustomMessageListener ekL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.am.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (am.this.ekI != null && !StringUtils.isNull(am.this.ekI.uid) && data != null && am.this.ekI.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(am.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(am.this.efr.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).bhm();
                        } else {
                            AntiHelper.a(am.this.efr.getPageActivity(), data.eCe);
                        }
                    }
                    if (data.isSucc) {
                        am.this.ekI.likeStatus = data.status;
                        am.this.ekI.isAttention = data.isAttention;
                    }
                    if (z && am.this.ekK != null) {
                        am.this.ekK.q(data.isSucc, am.this.ekJ);
                    }
                }
            }
        }
    };
    private BdUniqueId mId = BdUniqueId.gen();

    /* loaded from: classes.dex */
    public interface a {
        void q(boolean z, int i);
    }

    public am(TbPageContext tbPageContext) {
        this.efr = tbPageContext;
        this.ekL.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.ekL);
    }

    public boolean nP(int i) {
        if (i == ekG) {
            com.baidu.adp.lib.util.l.showToast(this.efr.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean aN(int i, int i2) {
        this.ekJ = i2;
        if (i == ekF) {
            if (this.ekI == null || this.ekI.isAttention) {
                return true;
            }
            bjf();
            return false;
        } else if (i == ekG) {
            com.baidu.adp.lib.util.l.showToast(this.efr.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public boolean nQ(int i) {
        if (i == ekF) {
            if (this.ekI == null || this.ekI.isAttention) {
                return true;
            }
            com.baidu.adp.lib.util.l.showToast(this.efr.getPageActivity(), R.string.message_privacy_fans_can_reply);
            return false;
        } else if (i == ekG) {
            com.baidu.adp.lib.util.l.showToast(this.efr.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.ekI = attentionHostData;
    }

    private void bjf() {
        if (this.aaD == null) {
            this.aaD = new com.baidu.tbadk.core.dialog.a(this.efr.getPageActivity());
            this.aaD.nt(R.string.message_privacy_fans_can_reply);
            this.aaD.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.am.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.bjg();
                    am.this.aaD.dismiss();
                }
            });
            this.aaD.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.am.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.aaD.dismiss();
                }
            });
            this.aaD.setAutoNight(true);
            this.aaD.b(this.efr);
        }
        this.aaD.bhg();
    }

    public void a(bp bpVar) {
        if (bpVar != null && !StringUtils.isNull(bpVar.title) && !StringUtils.isNull(bpVar.eam) && !StringUtils.isNull(bpVar.ean)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efr.getPageActivity());
            aVar.zA(bpVar.title);
            aVar.a(bpVar.ean, new a.b() { // from class: com.baidu.tbadk.core.util.am.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    am.this.bjg();
                    aVar2.dismiss();
                }
            });
            aVar.b(bpVar.eam, new a.b() { // from class: com.baidu.tbadk.core.util.am.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.efr);
            aVar.bhg();
            return;
        }
        bjf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjg() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.efr.showToast(R.string.network_ungeilivable);
        } else if (this.ekI != null && bg.checkUpIsLogin(this.efr.getPageActivity())) {
            if (this.ekH == null) {
                this.ekH = new com.baidu.tbadk.coreExtra.model.a(this.efr);
            }
            this.ekH.a(true, this.ekI.portrait, this.ekI.uid, this.ekI.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.ekK = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.aaD != null) {
            this.aaD.dismiss();
        }
        if (this.ekH != null) {
            this.ekH.cancel();
        }
    }
}
