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
    public static int fbZ = 0;
    public static int fca = 1;
    public static int fcb = 2;
    public static int fcc = 2;
    public static int fcd = 3;
    private com.baidu.tbadk.core.dialog.a aeo;
    private TbPageContext eWx;
    private com.baidu.tbadk.coreExtra.model.a fce;
    private AttentionHostData fcf;
    private int fcg;
    private a fch;
    private CustomMessageListener fci = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.am.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (am.this.fcf != null && !StringUtils.isNull(am.this.fcf.uid) && data != null && am.this.fcf.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(am.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(am.this.eWx.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).bqF();
                        } else {
                            AntiHelper.a(am.this.eWx.getPageActivity(), data.fud);
                        }
                    }
                    if (data.isSucc) {
                        am.this.fcf.likeStatus = data.status;
                        am.this.fcf.isAttention = data.isAttention;
                    }
                    if (z && am.this.fch != null) {
                        am.this.fch.q(data.isSucc, am.this.fcg);
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
        this.eWx = tbPageContext;
        this.fci.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.fci);
    }

    public boolean oy(int i) {
        if (i == fcd) {
            com.baidu.adp.lib.util.l.showToast(this.eWx.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean aK(int i, int i2) {
        this.fcg = i2;
        if (i == fcc) {
            if (this.fcf == null || this.fcf.isAttention) {
                return true;
            }
            bsI();
            return false;
        } else if (i == fcd) {
            com.baidu.adp.lib.util.l.showToast(this.eWx.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public boolean oz(int i) {
        if (i == fcc) {
            if (this.fcf == null || this.fcf.isAttention) {
                return true;
            }
            com.baidu.adp.lib.util.l.showToast(this.eWx.getPageActivity(), R.string.message_privacy_fans_can_reply);
            return false;
        } else if (i == fcd) {
            com.baidu.adp.lib.util.l.showToast(this.eWx.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.fcf = attentionHostData;
    }

    private void bsI() {
        if (this.aeo == null) {
            this.aeo = new com.baidu.tbadk.core.dialog.a(this.eWx.getPageActivity());
            this.aeo.ny(R.string.message_privacy_fans_can_reply);
            this.aeo.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.am.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.bsJ();
                    am.this.aeo.dismiss();
                }
            });
            this.aeo.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.am.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.aeo.dismiss();
                }
            });
            this.aeo.setAutoNight(true);
            this.aeo.b(this.eWx);
        }
        this.aeo.bqz();
    }

    public void a(bu buVar) {
        if (buVar != null && !StringUtils.isNull(buVar.title) && !StringUtils.isNull(buVar.eRb) && !StringUtils.isNull(buVar.eRc)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eWx.getPageActivity());
            aVar.AB(buVar.title);
            aVar.a(buVar.eRc, new a.b() { // from class: com.baidu.tbadk.core.util.am.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    am.this.bsJ();
                    aVar2.dismiss();
                }
            });
            aVar.b(buVar.eRb, new a.b() { // from class: com.baidu.tbadk.core.util.am.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.eWx);
            aVar.bqz();
            return;
        }
        bsI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsJ() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.eWx.showToast(R.string.network_ungeilivable);
        } else if (this.fcf != null && bh.checkUpIsLogin(this.eWx.getPageActivity())) {
            if (this.fce == null) {
                this.fce = new com.baidu.tbadk.coreExtra.model.a(this.eWx);
            }
            this.fce.a(true, this.fcf.portrait, this.fcf.uid, this.fcf.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.fch = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.aeo != null) {
            this.aeo.dismiss();
        }
        if (this.fce != null) {
            this.fce.cancel();
        }
    }
}
