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
    public static int eNm = 0;
    public static int eNn = 1;
    public static int eNo = 2;
    public static int eNp = 2;
    public static int eNq = 3;
    private com.baidu.tbadk.core.dialog.a abn;
    private TbPageContext eIc;
    private com.baidu.tbadk.coreExtra.model.a eNr;
    private AttentionHostData eNs;
    private int eNt;
    private a eNu;
    private CustomMessageListener eNv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.am.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (am.this.eNs != null && !StringUtils.isNull(am.this.eNs.uid) && data != null && am.this.eNs.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(am.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(am.this.eIc.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).bpi();
                        } else {
                            AntiHelper.a(am.this.eIc.getPageActivity(), data.feD);
                        }
                    }
                    if (data.isSucc) {
                        am.this.eNs.likeStatus = data.status;
                        am.this.eNs.isAttention = data.isAttention;
                    }
                    if (z && am.this.eNu != null) {
                        am.this.eNu.r(data.isSucc, am.this.eNt);
                    }
                }
            }
        }
    };
    private BdUniqueId mId = BdUniqueId.gen();

    /* loaded from: classes.dex */
    public interface a {
        void r(boolean z, int i);
    }

    public am(TbPageContext tbPageContext) {
        this.eIc = tbPageContext;
        this.eNv.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.eNv);
    }

    public boolean oT(int i) {
        if (i == eNq) {
            com.baidu.adp.lib.util.l.showToast(this.eIc.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean aN(int i, int i2) {
        this.eNt = i2;
        if (i == eNp) {
            if (this.eNs == null || this.eNs.isAttention) {
                return true;
            }
            brc();
            return false;
        } else if (i == eNq) {
            com.baidu.adp.lib.util.l.showToast(this.eIc.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public boolean oU(int i) {
        if (i == eNp) {
            if (this.eNs == null || this.eNs.isAttention) {
                return true;
            }
            com.baidu.adp.lib.util.l.showToast(this.eIc.getPageActivity(), R.string.message_privacy_fans_can_reply);
            return false;
        } else if (i == eNq) {
            com.baidu.adp.lib.util.l.showToast(this.eIc.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.eNs = attentionHostData;
    }

    private void brc() {
        if (this.abn == null) {
            this.abn = new com.baidu.tbadk.core.dialog.a(this.eIc.getPageActivity());
            this.abn.ow(R.string.message_privacy_fans_can_reply);
            this.abn.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.am.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.brd();
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
            this.abn.b(this.eIc);
        }
        this.abn.bpc();
    }

    public void a(bp bpVar) {
        if (bpVar != null && !StringUtils.isNull(bpVar.title) && !StringUtils.isNull(bpVar.eCQ) && !StringUtils.isNull(bpVar.eCR)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIc.getPageActivity());
            aVar.Bo(bpVar.title);
            aVar.a(bpVar.eCR, new a.b() { // from class: com.baidu.tbadk.core.util.am.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    am.this.brd();
                    aVar2.dismiss();
                }
            });
            aVar.b(bpVar.eCQ, new a.b() { // from class: com.baidu.tbadk.core.util.am.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.eIc);
            aVar.bpc();
            return;
        }
        brc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brd() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.eIc.showToast(R.string.network_ungeilivable);
        } else if (this.eNs != null && bg.checkUpIsLogin(this.eIc.getPageActivity())) {
            if (this.eNr == null) {
                this.eNr = new com.baidu.tbadk.coreExtra.model.a(this.eIc);
            }
            this.eNr.a(true, this.eNs.portrait, this.eNs.uid, this.eNs.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.eNu = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.abn != null) {
            this.abn.dismiss();
        }
        if (this.eNr != null) {
            this.eNr.cancel();
        }
    }
}
