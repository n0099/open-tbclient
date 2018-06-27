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
public class ak {
    public static int aqY = 0;
    public static int aqZ = 1;
    public static int ara = 2;
    public static int arb = 2;
    public static int arc = 3;
    private com.baidu.tbadk.core.dialog.a Qm;
    private com.baidu.tbadk.coreExtra.model.a ard;
    private AttentionHostData are;
    private int arf;
    private a arg;
    private TbPageContext mContext;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.util.ak.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (ak.this.are != null && !StringUtils.isNull(ak.this.are.uid) && data != null && ak.this.are.uid.equals(data.toUid)) {
                    boolean z = false;
                    if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(ak.this.mId)) {
                        z = true;
                    }
                    if (data.Gr) {
                        ak.this.are.likeStatus = data.status;
                        ak.this.are.isAttention = data.isAttention;
                    }
                    if (z && ak.this.arg != null) {
                        ak.this.arg.c(data.Gr, ak.this.arf);
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

    public ak(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.mAttentionListener.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
    }

    public boolean cN(int i) {
        if (i == arc) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.k.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean u(int i, int i2) {
        this.arf = i2;
        if (i == arb) {
            if (this.are == null || this.are.isAttention) {
                return true;
            }
            zx();
            return false;
        } else if (i == arc) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.k.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.are = attentionHostData;
    }

    private void zx() {
        if (this.Qm == null) {
            this.Qm = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            this.Qm.cd(d.k.message_privacy_fans_can_reply);
            this.Qm.a(d.k.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.ak.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ak.this.zy();
                    ak.this.Qm.dismiss();
                }
            });
            this.Qm.b(d.k.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.ak.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ak.this.Qm.dismiss();
                }
            });
            this.Qm.setAutoNight(true);
            this.Qm.b(this.mContext);
        }
        this.Qm.xn();
    }

    public void a(com.baidu.tbadk.core.data.ax axVar) {
        if (axVar != null && !StringUtils.isNull(axVar.title) && !StringUtils.isNull(axVar.ahN) && !StringUtils.isNull(axVar.ahO)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.dE(axVar.title);
            aVar.a(axVar.ahO, new a.b() { // from class: com.baidu.tbadk.core.util.ak.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    ak.this.zy();
                    aVar2.dismiss();
                }
            });
            aVar.b(axVar.ahN, new a.b() { // from class: com.baidu.tbadk.core.util.ak.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.mContext);
            aVar.xn();
            return;
        }
        zx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zy() {
        if (!com.baidu.adp.lib.util.j.jr()) {
            this.mContext.showToast(d.k.network_ungeilivable);
        } else if (this.are != null && bb.aU(this.mContext.getPageActivity())) {
            if (this.ard == null) {
                this.ard = new com.baidu.tbadk.coreExtra.model.a(this.mContext);
            }
            this.ard.a(true, this.are.portrait, this.are.uid, this.are.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.arg = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.Qm != null) {
            this.Qm.dismiss();
        }
        if (this.ard != null) {
            this.ard.cancel();
        }
    }
}
