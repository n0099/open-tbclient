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
/* loaded from: classes2.dex */
public class am {
    private com.baidu.tbadk.core.dialog.a aaB;
    private TbPageContext efn;
    private com.baidu.tbadk.coreExtra.model.a ekD;
    private AttentionHostData ekE;
    private int ekF;
    private a ekG;
    private CustomMessageListener ekH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.am.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (am.this.ekE != null && !StringUtils.isNull(am.this.ekE.uid) && data != null && am.this.ekE.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(am.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(am.this.efn.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).bhm();
                        } else {
                            AntiHelper.a(am.this.efn.getPageActivity(), data.eCa);
                        }
                    }
                    if (data.isSucc) {
                        am.this.ekE.likeStatus = data.status;
                        am.this.ekE.isAttention = data.isAttention;
                    }
                    if (z && am.this.ekG != null) {
                        am.this.ekG.q(data.isSucc, am.this.ekF);
                    }
                }
            }
        }
    };
    private BdUniqueId mId = BdUniqueId.gen();
    public static int eky = 0;
    public static int ekz = 1;
    public static int ekA = 2;
    public static int ekB = 2;
    public static int ekC = 3;

    /* loaded from: classes2.dex */
    public interface a {
        void q(boolean z, int i);
    }

    public am(TbPageContext tbPageContext) {
        this.efn = tbPageContext;
        this.ekH.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.ekH);
    }

    public boolean nP(int i) {
        if (i == ekC) {
            com.baidu.adp.lib.util.l.showToast(this.efn.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean aN(int i, int i2) {
        this.ekF = i2;
        if (i == ekB) {
            if (this.ekE == null || this.ekE.isAttention) {
                return true;
            }
            bjf();
            return false;
        } else if (i == ekC) {
            com.baidu.adp.lib.util.l.showToast(this.efn.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public boolean nQ(int i) {
        if (i == ekB) {
            if (this.ekE == null || this.ekE.isAttention) {
                return true;
            }
            com.baidu.adp.lib.util.l.showToast(this.efn.getPageActivity(), R.string.message_privacy_fans_can_reply);
            return false;
        } else if (i == ekC) {
            com.baidu.adp.lib.util.l.showToast(this.efn.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.ekE = attentionHostData;
    }

    private void bjf() {
        if (this.aaB == null) {
            this.aaB = new com.baidu.tbadk.core.dialog.a(this.efn.getPageActivity());
            this.aaB.nt(R.string.message_privacy_fans_can_reply);
            this.aaB.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.am.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.bjg();
                    am.this.aaB.dismiss();
                }
            });
            this.aaB.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.am.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.aaB.dismiss();
                }
            });
            this.aaB.setAutoNight(true);
            this.aaB.b(this.efn);
        }
        this.aaB.bhg();
    }

    public void a(bp bpVar) {
        if (bpVar != null && !StringUtils.isNull(bpVar.title) && !StringUtils.isNull(bpVar.eai) && !StringUtils.isNull(bpVar.eaj)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efn.getPageActivity());
            aVar.zz(bpVar.title);
            aVar.a(bpVar.eaj, new a.b() { // from class: com.baidu.tbadk.core.util.am.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    am.this.bjg();
                    aVar2.dismiss();
                }
            });
            aVar.b(bpVar.eai, new a.b() { // from class: com.baidu.tbadk.core.util.am.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.efn);
            aVar.bhg();
            return;
        }
        bjf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjg() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.efn.showToast(R.string.network_ungeilivable);
        } else if (this.ekE != null && bg.checkUpIsLogin(this.efn.getPageActivity())) {
            if (this.ekD == null) {
                this.ekD = new com.baidu.tbadk.coreExtra.model.a(this.efn);
            }
            this.ekD.a(true, this.ekE.portrait, this.ekE.uid, this.ekE.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.ekG = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.aaB != null) {
            this.aaB.dismiss();
        }
        if (this.ekD != null) {
            this.ekD.cancel();
        }
    }
}
