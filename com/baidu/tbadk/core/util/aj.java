package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class aj {
    private com.baidu.tbadk.core.dialog.a Zd;
    private TbPageContext duG;
    private com.baidu.tbadk.coreExtra.model.a dzD;
    private AttentionHostData dzE;
    private int dzF;
    private a dzG;
    private CustomMessageListener dzH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.dzE != null && !StringUtils.isNull(aj.this.dzE.uid) && data != null && aj.this.dzE.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(aj.this.duG.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).aMZ();
                        } else {
                            AntiHelper.a(aj.this.duG.getPageActivity(), data.dOo);
                        }
                    }
                    if (data.isSucc) {
                        aj.this.dzE.likeStatus = data.status;
                        aj.this.dzE.isAttention = data.isAttention;
                    }
                    if (z && aj.this.dzG != null) {
                        aj.this.dzG.m(data.isSucc, aj.this.dzF);
                    }
                }
            }
        }
    };
    private BdUniqueId mId = BdUniqueId.gen();
    public static int dzy = 0;
    public static int dzz = 1;
    public static int dzA = 2;
    public static int dzB = 2;
    public static int dzC = 3;

    /* loaded from: classes.dex */
    public interface a {
        void m(boolean z, int i);
    }

    public aj(TbPageContext tbPageContext) {
        this.duG = tbPageContext;
        this.dzH.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.dzH);
    }

    public boolean kz(int i) {
        if (i == dzC) {
            com.baidu.adp.lib.util.l.showToast(this.duG.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean aA(int i, int i2) {
        this.dzF = i2;
        if (i == dzB) {
            if (this.dzE == null || this.dzE.isAttention) {
                return true;
            }
            aOK();
            return false;
        } else if (i == dzC) {
            com.baidu.adp.lib.util.l.showToast(this.duG.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.dzE = attentionHostData;
    }

    private void aOK() {
        if (this.Zd == null) {
            this.Zd = new com.baidu.tbadk.core.dialog.a(this.duG.getPageActivity());
            this.Zd.kd(R.string.message_privacy_fans_can_reply);
            this.Zd.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.aOL();
                    aj.this.Zd.dismiss();
                }
            });
            this.Zd.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.Zd.dismiss();
                }
            });
            this.Zd.setAutoNight(true);
            this.Zd.b(this.duG);
        }
        this.Zd.aMU();
    }

    public void a(bd bdVar) {
        if (bdVar != null && !StringUtils.isNull(bdVar.title) && !StringUtils.isNull(bdVar.dpZ) && !StringUtils.isNull(bdVar.dqa)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duG.getPageActivity());
            aVar.uf(bdVar.title);
            aVar.a(bdVar.dqa, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.aOL();
                    aVar2.dismiss();
                }
            });
            aVar.b(bdVar.dpZ, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.duG);
            aVar.aMU();
            return;
        }
        aOK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOL() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.duG.showToast(R.string.network_ungeilivable);
        } else if (this.dzE != null && bc.checkUpIsLogin(this.duG.getPageActivity())) {
            if (this.dzD == null) {
                this.dzD = new com.baidu.tbadk.coreExtra.model.a(this.duG);
            }
            this.dzD.a(true, this.dzE.portrait, this.dzE.uid, this.dzE.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.dzG = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.Zd != null) {
            this.Zd.dismiss();
        }
        if (this.dzD != null) {
            this.dzD.cancel();
        }
    }
}
