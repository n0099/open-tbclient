package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class aj {
    public static int aqv = 0;
    public static int aqw = 1;
    public static int aqx = 2;
    public static int aqy = 2;
    public static int aqz = 3;
    private com.baidu.tbadk.core.dialog.a Qk;
    private com.baidu.tbadk.coreExtra.model.a aqA;
    private AttentionHostData aqB;
    private int aqC;
    private a aqD;
    private TbPageContext mContext;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.aqB != null && !StringUtils.isNull(aj.this.aqB.uid) && data != null && aj.this.aqB.uid.equals(data.toUid)) {
                    boolean z = false;
                    if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = true;
                    }
                    if (data.Gp) {
                        aj.this.aqB.likeStatus = data.status;
                        aj.this.aqB.isAttention = data.isAttention;
                    }
                    if (z && aj.this.aqD != null) {
                        aj.this.aqD.c(data.Gp, aj.this.aqC);
                    }
                }
            }
        }
    };
    private BdUniqueId mId = BdUniqueId.gen();

    /* loaded from: classes.dex */
    public interface a {
        void c(boolean z, int i);
    }

    public aj(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.mAttentionListener.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
    }

    public boolean cM(int i) {
        if (i == aqz) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.k.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean u(int i, int i2) {
        this.aqC = i2;
        if (i == aqy) {
            if (this.aqB == null || this.aqB.isAttention) {
                return true;
            }
            zi();
            return false;
        } else if (i == aqz) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.k.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.aqB = attentionHostData;
    }

    private void zi() {
        if (this.Qk == null) {
            this.Qk = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            this.Qk.cc(d.k.message_privacy_fans_can_reply);
            this.Qk.a(d.k.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.zj();
                    aj.this.Qk.dismiss();
                }
            });
            this.Qk.b(d.k.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.Qk.dismiss();
                }
            });
            this.Qk.setAutoNight(true);
            this.Qk.b(this.mContext);
        }
        this.Qk.xa();
    }

    public void a(com.baidu.tbadk.core.data.ax axVar) {
        if (axVar != null && !StringUtils.isNull(axVar.title) && !StringUtils.isNull(axVar.ahu) && !StringUtils.isNull(axVar.ahv)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.dB(axVar.title);
            aVar.a(axVar.ahv, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.zj();
                    aVar2.dismiss();
                }
            });
            aVar.b(axVar.ahu, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.mContext);
            aVar.xa();
            return;
        }
        zi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj() {
        if (!com.baidu.adp.lib.util.j.jr()) {
            this.mContext.showToast(d.k.network_ungeilivable);
        } else if (this.aqB != null && ba.aU(this.mContext.getPageActivity())) {
            if (this.aqA == null) {
                this.aqA = new com.baidu.tbadk.coreExtra.model.a(this.mContext);
            }
            this.aqA.a(true, this.aqB.portrait, this.aqB.uid, this.aqB.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.aqD = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.Qk != null) {
            this.Qk.dismiss();
        }
        if (this.aqA != null) {
            this.aqA.cancel();
        }
    }
}
