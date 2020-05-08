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
    public static int dzC = 0;
    public static int dzD = 1;
    public static int dzE = 2;
    public static int dzF = 2;
    public static int dzG = 3;
    private com.baidu.tbadk.core.dialog.a Zg;
    private TbPageContext duK;
    private com.baidu.tbadk.coreExtra.model.a dzH;
    private AttentionHostData dzI;
    private int dzJ;
    private a dzK;
    private CustomMessageListener dzL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.dzI != null && !StringUtils.isNull(aj.this.dzI.uid) && data != null && aj.this.dzI.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(aj.this.duK.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).aMX();
                        } else {
                            AntiHelper.a(aj.this.duK.getPageActivity(), data.dOt);
                        }
                    }
                    if (data.isSucc) {
                        aj.this.dzI.likeStatus = data.status;
                        aj.this.dzI.isAttention = data.isAttention;
                    }
                    if (z && aj.this.dzK != null) {
                        aj.this.dzK.m(data.isSucc, aj.this.dzJ);
                    }
                }
            }
        }
    };
    private BdUniqueId mId = BdUniqueId.gen();

    /* loaded from: classes.dex */
    public interface a {
        void m(boolean z, int i);
    }

    public aj(TbPageContext tbPageContext) {
        this.duK = tbPageContext;
        this.dzL.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.dzL);
    }

    public boolean kz(int i) {
        if (i == dzG) {
            com.baidu.adp.lib.util.l.showToast(this.duK.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean aA(int i, int i2) {
        this.dzJ = i2;
        if (i == dzF) {
            if (this.dzI == null || this.dzI.isAttention) {
                return true;
            }
            aOI();
            return false;
        } else if (i == dzG) {
            com.baidu.adp.lib.util.l.showToast(this.duK.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.dzI = attentionHostData;
    }

    private void aOI() {
        if (this.Zg == null) {
            this.Zg = new com.baidu.tbadk.core.dialog.a(this.duK.getPageActivity());
            this.Zg.kd(R.string.message_privacy_fans_can_reply);
            this.Zg.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.aOJ();
                    aj.this.Zg.dismiss();
                }
            });
            this.Zg.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.Zg.dismiss();
                }
            });
            this.Zg.setAutoNight(true);
            this.Zg.b(this.duK);
        }
        this.Zg.aMS();
    }

    public void a(bd bdVar) {
        if (bdVar != null && !StringUtils.isNull(bdVar.title) && !StringUtils.isNull(bdVar.dqd) && !StringUtils.isNull(bdVar.dqe)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duK.getPageActivity());
            aVar.ui(bdVar.title);
            aVar.a(bdVar.dqe, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.aOJ();
                    aVar2.dismiss();
                }
            });
            aVar.b(bdVar.dqd, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.duK);
            aVar.aMS();
            return;
        }
        aOI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOJ() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.duK.showToast(R.string.network_ungeilivable);
        } else if (this.dzI != null && bc.checkUpIsLogin(this.duK.getPageActivity())) {
            if (this.dzH == null) {
                this.dzH = new com.baidu.tbadk.coreExtra.model.a(this.duK);
            }
            this.dzH.a(true, this.dzI.portrait, this.dzI.uid, this.dzI.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.dzK = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.Zg != null) {
            this.Zg.dismiss();
        }
        if (this.dzH != null) {
            this.dzH.cancel();
        }
    }
}
