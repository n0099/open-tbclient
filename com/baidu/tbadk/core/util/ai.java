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
public class ai {
    public static int aio = 0;
    public static int aip = 1;
    public static int aiq = 2;
    public static int air = 2;
    public static int ais = 3;
    private com.baidu.tbadk.core.dialog.a JR;
    private com.baidu.tbadk.coreExtra.model.a ait;
    private AttentionHostData aiu;
    private int aiv;
    private a aiw;
    private TbPageContext mContext;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.util.ai.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (ai.this.aiu != null && !StringUtils.isNull(ai.this.aiu.uid) && data != null && ai.this.aiu.uid.equals(data.toUid)) {
                    boolean z = false;
                    if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(ai.this.mId)) {
                        z = true;
                    }
                    if (data.Ai) {
                        ai.this.aiu.likeStatus = data.status;
                        ai.this.aiu.isAttention = data.isAttention;
                    }
                    if (z && ai.this.aiw != null) {
                        ai.this.aiw.c(data.Ai, ai.this.aiv);
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

    public ai(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.mAttentionListener.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
    }

    public boolean cK(int i) {
        if (i == ais) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.k.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean t(int i, int i2) {
        this.aiv = i2;
        if (i == air) {
            if (this.aiu == null || this.aiu.isAttention) {
                return true;
            }
            vH();
            return false;
        } else if (i == ais) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.k.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.aiu = attentionHostData;
    }

    private void vH() {
        if (this.JR == null) {
            this.JR = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            this.JR.ca(d.k.message_privacy_fans_can_reply);
            this.JR.a(d.k.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.ai.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ai.this.vI();
                    ai.this.JR.dismiss();
                }
            });
            this.JR.b(d.k.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.ai.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ai.this.JR.dismiss();
                }
            });
            this.JR.setAutoNight(true);
            this.JR.b(this.mContext);
        }
        this.JR.tC();
    }

    public void a(com.baidu.tbadk.core.data.ax axVar) {
        if (axVar != null && !StringUtils.isNull(axVar.title) && !StringUtils.isNull(axVar.Zs) && !StringUtils.isNull(axVar.Zt)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.dc(axVar.title);
            aVar.a(axVar.Zt, new a.b() { // from class: com.baidu.tbadk.core.util.ai.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    ai.this.vI();
                    aVar2.dismiss();
                }
            });
            aVar.b(axVar.Zs, new a.b() { // from class: com.baidu.tbadk.core.util.ai.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.mContext);
            aVar.tC();
            return;
        }
        vH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vI() {
        if (!com.baidu.adp.lib.util.j.gD()) {
            this.mContext.showToast(d.k.network_ungeilivable);
        } else if (this.aiu != null && az.aK(this.mContext.getPageActivity())) {
            if (this.ait == null) {
                this.ait = new com.baidu.tbadk.coreExtra.model.a(this.mContext);
            }
            this.ait.a(true, this.aiu.portrait, this.aiu.uid, this.aiu.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.aiw = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.JR != null) {
            this.JR.dismiss();
        }
        if (this.ait != null) {
            this.ait.cancel();
        }
    }
}
