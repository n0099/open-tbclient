package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class al {
    public static int eYl = 0;
    public static int eYm = 1;
    public static int eYn = 2;
    public static int eYo = 2;
    public static int eYp = 3;
    private com.baidu.tbadk.core.dialog.a ada;
    private TbPageContext eSJ;
    private com.baidu.tbadk.coreExtra.model.a eYq;
    private AttentionHostData eYr;
    private int eYs;
    private a eYt;
    private CustomMessageListener eYu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.al.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (al.this.eYr != null && !StringUtils.isNull(al.this.eYr.uid) && data != null && al.this.eYr.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(al.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(al.this.eSJ.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).bqk();
                        } else {
                            AntiHelper.a(al.this.eSJ.getPageActivity(), data.fqk);
                        }
                    }
                    if (data.isSucc) {
                        al.this.eYr.likeStatus = data.status;
                        al.this.eYr.isAttention = data.isAttention;
                    }
                    if (z && al.this.eYt != null) {
                        al.this.eYt.q(data.isSucc, al.this.eYs);
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
        this.eSJ = tbPageContext;
        this.eYu.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.eYu);
    }

    public boolean os(int i) {
        if (i == eYp) {
            com.baidu.adp.lib.util.l.showToast(this.eSJ.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean aN(int i, int i2) {
        this.eYs = i2;
        if (i == eYo) {
            if (this.eYr == null || this.eYr.isAttention) {
                return true;
            }
            bsl();
            return false;
        } else if (i == eYp) {
            com.baidu.adp.lib.util.l.showToast(this.eSJ.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public boolean ot(int i) {
        if (i == eYo) {
            if (this.eYr == null || this.eYr.isAttention) {
                return true;
            }
            com.baidu.adp.lib.util.l.showToast(this.eSJ.getPageActivity(), R.string.message_privacy_fans_can_reply);
            return false;
        } else if (i == eYp) {
            com.baidu.adp.lib.util.l.showToast(this.eSJ.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.eYr = attentionHostData;
    }

    private void bsl() {
        if (this.ada == null) {
            this.ada = new com.baidu.tbadk.core.dialog.a(this.eSJ.getPageActivity());
            this.ada.nu(R.string.message_privacy_fans_can_reply);
            this.ada.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.al.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    al.this.bsm();
                    al.this.ada.dismiss();
                }
            });
            this.ada.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.al.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    al.this.ada.dismiss();
                }
            });
            this.ada.setAutoNight(true);
            this.ada.b(this.eSJ);
        }
        this.ada.bqe();
    }

    public void a(bs bsVar) {
        if (bsVar != null && !StringUtils.isNull(bsVar.title) && !StringUtils.isNull(bsVar.eNo) && !StringUtils.isNull(bsVar.eNp)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eSJ.getPageActivity());
            aVar.Ad(bsVar.title);
            aVar.a(bsVar.eNp, new a.b() { // from class: com.baidu.tbadk.core.util.al.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    al.this.bsm();
                    aVar2.dismiss();
                }
            });
            aVar.b(bsVar.eNo, new a.b() { // from class: com.baidu.tbadk.core.util.al.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.eSJ);
            aVar.bqe();
            return;
        }
        bsl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsm() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.eSJ.showToast(R.string.network_ungeilivable);
        } else if (this.eYr != null && bg.checkUpIsLogin(this.eSJ.getPageActivity())) {
            if (this.eYq == null) {
                this.eYq = new com.baidu.tbadk.coreExtra.model.a(this.eSJ);
            }
            this.eYq.a(true, this.eYr.portrait, this.eYr.uid, this.eYr.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.eYt = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.ada != null) {
            this.ada.dismiss();
        }
        if (this.eYq != null) {
            this.eYq.cancel();
        }
    }
}
