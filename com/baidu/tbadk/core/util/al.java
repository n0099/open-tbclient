package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class al {
    public static int eaP = 0;
    public static int eaQ = 1;
    public static int eaR = 2;
    public static int eaS = 2;
    public static int eaT = 3;
    private com.baidu.tbadk.core.dialog.a ZV;
    private TbPageContext dVN;
    private com.baidu.tbadk.coreExtra.model.a eaU;
    private AttentionHostData eaV;
    private int eaW;
    private a eaX;
    private CustomMessageListener eaY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.al.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (al.this.eaV != null && !StringUtils.isNull(al.this.eaV.uid) && data != null && al.this.eaV.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(al.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(al.this.dVN.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).aYR();
                        } else {
                            AntiHelper.a(al.this.dVN.getPageActivity(), data.erH);
                        }
                    }
                    if (data.isSucc) {
                        al.this.eaV.likeStatus = data.status;
                        al.this.eaV.isAttention = data.isAttention;
                    }
                    if (z && al.this.eaX != null) {
                        al.this.eaX.q(data.isSucc, al.this.eaW);
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

    public al(TbPageContext tbPageContext) {
        this.dVN = tbPageContext;
        this.eaY.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.eaY);
    }

    public boolean lJ(int i) {
        if (i == eaT) {
            com.baidu.adp.lib.util.l.showToast(this.dVN.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean aG(int i, int i2) {
        this.eaW = i2;
        if (i == eaS) {
            if (this.eaV == null || this.eaV.isAttention) {
                return true;
            }
            baH();
            return false;
        } else if (i == eaT) {
            com.baidu.adp.lib.util.l.showToast(this.dVN.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.eaV = attentionHostData;
    }

    private void baH() {
        if (this.ZV == null) {
            this.ZV = new com.baidu.tbadk.core.dialog.a(this.dVN.getPageActivity());
            this.ZV.ln(R.string.message_privacy_fans_can_reply);
            this.ZV.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.al.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    al.this.baI();
                    al.this.ZV.dismiss();
                }
            });
            this.ZV.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.al.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    al.this.ZV.dismiss();
                }
            });
            this.ZV.setAutoNight(true);
            this.ZV.b(this.dVN);
        }
        this.ZV.aYL();
    }

    public void a(bo boVar) {
        if (boVar != null && !StringUtils.isNull(boVar.title) && !StringUtils.isNull(boVar.dQO) && !StringUtils.isNull(boVar.dQP)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dVN.getPageActivity());
            aVar.xl(boVar.title);
            aVar.a(boVar.dQP, new a.b() { // from class: com.baidu.tbadk.core.util.al.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    al.this.baI();
                    aVar2.dismiss();
                }
            });
            aVar.b(boVar.dQO, new a.b() { // from class: com.baidu.tbadk.core.util.al.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.dVN);
            aVar.aYL();
            return;
        }
        baH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baI() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.dVN.showToast(R.string.network_ungeilivable);
        } else if (this.eaV != null && bf.checkUpIsLogin(this.dVN.getPageActivity())) {
            if (this.eaU == null) {
                this.eaU = new com.baidu.tbadk.coreExtra.model.a(this.dVN);
            }
            this.eaU.a(true, this.eaV.portrait, this.eaV.uid, this.eaV.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.eaX = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.ZV != null) {
            this.ZV.dismiss();
        }
        if (this.eaU != null) {
            this.eaU.cancel();
        }
    }
}
