package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class am {
    public static int faA = 0;
    public static int faB = 1;
    public static int faC = 2;
    public static int faD = 2;
    public static int faE = 3;
    private com.baidu.tbadk.core.dialog.a acU;
    private TbPageContext eUY;
    private com.baidu.tbadk.coreExtra.model.a faF;
    private AttentionHostData faG;
    private int faH;
    private a faI;
    private CustomMessageListener faJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.am.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (am.this.faG != null && !StringUtils.isNull(am.this.faG.uid) && data != null && am.this.faG.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(am.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(am.this.eUY.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).bqD();
                        } else {
                            AntiHelper.a(am.this.eUY.getPageActivity(), data.fsD);
                        }
                    }
                    if (data.isSucc) {
                        am.this.faG.likeStatus = data.status;
                        am.this.faG.isAttention = data.isAttention;
                    }
                    if (z && am.this.faI != null) {
                        am.this.faI.q(data.isSucc, am.this.faH);
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
        this.eUY = tbPageContext;
        this.faJ.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.faJ);
    }

    public boolean ox(int i) {
        if (i == faE) {
            com.baidu.adp.lib.util.l.showToast(this.eUY.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean aK(int i, int i2) {
        this.faH = i2;
        if (i == faD) {
            if (this.faG == null || this.faG.isAttention) {
                return true;
            }
            bsF();
            return false;
        } else if (i == faE) {
            com.baidu.adp.lib.util.l.showToast(this.eUY.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public boolean oy(int i) {
        if (i == faD) {
            if (this.faG == null || this.faG.isAttention) {
                return true;
            }
            com.baidu.adp.lib.util.l.showToast(this.eUY.getPageActivity(), R.string.message_privacy_fans_can_reply);
            return false;
        } else if (i == faE) {
            com.baidu.adp.lib.util.l.showToast(this.eUY.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.faG = attentionHostData;
    }

    private void bsF() {
        if (this.acU == null) {
            this.acU = new com.baidu.tbadk.core.dialog.a(this.eUY.getPageActivity());
            this.acU.nx(R.string.message_privacy_fans_can_reply);
            this.acU.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.am.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.bsG();
                    am.this.acU.dismiss();
                }
            });
            this.acU.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.am.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.acU.dismiss();
                }
            });
            this.acU.setAutoNight(true);
            this.acU.b(this.eUY);
        }
        this.acU.bqx();
    }

    public void a(bu buVar) {
        if (buVar != null && !StringUtils.isNull(buVar.title) && !StringUtils.isNull(buVar.ePA) && !StringUtils.isNull(buVar.ePB)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eUY.getPageActivity());
            aVar.Au(buVar.title);
            aVar.a(buVar.ePB, new a.b() { // from class: com.baidu.tbadk.core.util.am.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    am.this.bsG();
                    aVar2.dismiss();
                }
            });
            aVar.b(buVar.ePA, new a.b() { // from class: com.baidu.tbadk.core.util.am.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.eUY);
            aVar.bqx();
            return;
        }
        bsF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsG() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.eUY.showToast(R.string.network_ungeilivable);
        } else if (this.faG != null && bh.checkUpIsLogin(this.eUY.getPageActivity())) {
            if (this.faF == null) {
                this.faF = new com.baidu.tbadk.coreExtra.model.a(this.eUY);
            }
            this.faF.a(true, this.faG.portrait, this.faG.uid, this.faG.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.faI = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.acU != null) {
            this.acU.dismiss();
        }
        if (this.faF != null) {
            this.faF.cancel();
        }
    }
}
