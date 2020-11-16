package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class am {
    public static int eMl = 0;
    public static int eMm = 1;
    public static int eMn = 2;
    public static int eMo = 2;
    public static int eMp = 3;
    private com.baidu.tbadk.core.dialog.a abt;
    private TbPageContext eGu;
    private com.baidu.tbadk.coreExtra.model.a eMq;
    private AttentionHostData eMr;
    private int eMs;
    private a eMt;
    private CustomMessageListener eMu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.am.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (am.this.eMr != null && !StringUtils.isNull(am.this.eMr.uid) && data != null && am.this.eMr.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(am.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(am.this.eGu.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).bom();
                        } else {
                            AntiHelper.a(am.this.eGu.getPageActivity(), data.fdL);
                        }
                    }
                    if (data.isSucc) {
                        am.this.eMr.likeStatus = data.status;
                        am.this.eMr.isAttention = data.isAttention;
                    }
                    if (z && am.this.eMt != null) {
                        am.this.eMt.r(data.isSucc, am.this.eMs);
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
        this.eGu = tbPageContext;
        this.eMu.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.eMu);
    }

    public boolean pp(int i) {
        if (i == eMp) {
            com.baidu.adp.lib.util.l.showToast(this.eGu.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean aO(int i, int i2) {
        this.eMs = i2;
        if (i == eMo) {
            if (this.eMr == null || this.eMr.isAttention) {
                return true;
            }
            bqp();
            return false;
        } else if (i == eMp) {
            com.baidu.adp.lib.util.l.showToast(this.eGu.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public boolean pq(int i) {
        if (i == eMo) {
            if (this.eMr == null || this.eMr.isAttention) {
                return true;
            }
            com.baidu.adp.lib.util.l.showToast(this.eGu.getPageActivity(), R.string.message_privacy_fans_can_reply);
            return false;
        } else if (i == eMp) {
            com.baidu.adp.lib.util.l.showToast(this.eGu.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.eMr = attentionHostData;
    }

    private void bqp() {
        if (this.abt == null) {
            this.abt = new com.baidu.tbadk.core.dialog.a(this.eGu.getPageActivity());
            this.abt.os(R.string.message_privacy_fans_can_reply);
            this.abt.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.am.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.bqq();
                    am.this.abt.dismiss();
                }
            });
            this.abt.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.am.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.abt.dismiss();
                }
            });
            this.abt.setAutoNight(true);
            this.abt.b(this.eGu);
        }
        this.abt.bog();
    }

    public void a(bq bqVar) {
        if (bqVar != null && !StringUtils.isNull(bqVar.title) && !StringUtils.isNull(bqVar.eBh) && !StringUtils.isNull(bqVar.eBi)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGu.getPageActivity());
            aVar.AJ(bqVar.title);
            aVar.a(bqVar.eBi, new a.b() { // from class: com.baidu.tbadk.core.util.am.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    am.this.bqq();
                    aVar2.dismiss();
                }
            });
            aVar.b(bqVar.eBh, new a.b() { // from class: com.baidu.tbadk.core.util.am.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.eGu);
            aVar.bog();
            return;
        }
        bqp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqq() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.eGu.showToast(R.string.network_ungeilivable);
        } else if (this.eMr != null && bh.checkUpIsLogin(this.eGu.getPageActivity())) {
            if (this.eMq == null) {
                this.eMq = new com.baidu.tbadk.coreExtra.model.a(this.eGu);
            }
            this.eMq.a(true, this.eMr.portrait, this.eMr.uid, this.eMr.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.eMt = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.abt != null) {
            this.abt.dismiss();
        }
        if (this.eMq != null) {
            this.eMq.cancel();
        }
    }
}
