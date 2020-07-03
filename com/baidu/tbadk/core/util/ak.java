package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class ak {
    private com.baidu.tbadk.core.dialog.a aaa;
    private TbPageContext dPv;
    private com.baidu.tbadk.coreExtra.model.a dUB;
    private AttentionHostData dUC;
    private int dUD;
    private a dUE;
    private CustomMessageListener dUF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.ak.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (ak.this.dUC != null && !StringUtils.isNull(ak.this.dUC.uid) && data != null && ak.this.dUC.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(ak.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(ak.this.dPv.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).aUS();
                        } else {
                            AntiHelper.a(ak.this.dPv.getPageActivity(), data.els);
                        }
                    }
                    if (data.isSucc) {
                        ak.this.dUC.likeStatus = data.status;
                        ak.this.dUC.isAttention = data.isAttention;
                    }
                    if (z && ak.this.dUE != null) {
                        ak.this.dUE.q(data.isSucc, ak.this.dUD);
                    }
                }
            }
        }
    };
    private BdUniqueId mId = BdUniqueId.gen();
    public static int dUw = 0;
    public static int dUx = 1;
    public static int dUy = 2;
    public static int dUz = 2;
    public static int dUA = 3;

    /* loaded from: classes.dex */
    public interface a {
        void q(boolean z, int i);
    }

    public ak(TbPageContext tbPageContext) {
        this.dPv = tbPageContext;
        this.dUF.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.dUF);
    }

    public boolean lp(int i) {
        if (i == dUA) {
            com.baidu.adp.lib.util.l.showToast(this.dPv.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean aF(int i, int i2) {
        this.dUD = i2;
        if (i == dUz) {
            if (this.dUC == null || this.dUC.isAttention) {
                return true;
            }
            aWG();
            return false;
        } else if (i == dUA) {
            com.baidu.adp.lib.util.l.showToast(this.dPv.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.dUC = attentionHostData;
    }

    private void aWG() {
        if (this.aaa == null) {
            this.aaa = new com.baidu.tbadk.core.dialog.a(this.dPv.getPageActivity());
            this.aaa.kT(R.string.message_privacy_fans_can_reply);
            this.aaa.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.ak.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ak.this.aWH();
                    ak.this.aaa.dismiss();
                }
            });
            this.aaa.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.ak.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ak.this.aaa.dismiss();
                }
            });
            this.aaa.setAutoNight(true);
            this.aaa.b(this.dPv);
        }
        this.aaa.aUN();
    }

    public void a(bn bnVar) {
        if (bnVar != null && !StringUtils.isNull(bnVar.title) && !StringUtils.isNull(bnVar.dKC) && !StringUtils.isNull(bnVar.dKD)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPv.getPageActivity());
            aVar.we(bnVar.title);
            aVar.a(bnVar.dKD, new a.b() { // from class: com.baidu.tbadk.core.util.ak.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    ak.this.aWH();
                    aVar2.dismiss();
                }
            });
            aVar.b(bnVar.dKC, new a.b() { // from class: com.baidu.tbadk.core.util.ak.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.dPv);
            aVar.aUN();
            return;
        }
        aWG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWH() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.dPv.showToast(R.string.network_ungeilivable);
        } else if (this.dUC != null && be.checkUpIsLogin(this.dPv.getPageActivity())) {
            if (this.dUB == null) {
                this.dUB = new com.baidu.tbadk.coreExtra.model.a(this.dPv);
            }
            this.dUB.a(true, this.dUC.portrait, this.dUC.uid, this.dUC.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.dUE = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.aaa != null) {
            this.aaa.dismiss();
        }
        if (this.dUB != null) {
            this.dUB.cancel();
        }
    }
}
