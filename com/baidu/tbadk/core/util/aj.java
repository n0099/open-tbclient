package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class aj {
    public static int aBW = 0;
    public static int aBX = 1;
    public static int aBY = 2;
    public static int aBZ = 2;
    public static int aCa = 3;
    private com.baidu.tbadk.core.dialog.a Td;
    private com.baidu.tbadk.coreExtra.model.a aCb;
    private AttentionHostData aCc;
    private int aCd;
    private a aCe;
    private TbPageContext mContext;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.aCc != null && !StringUtils.isNull(aj.this.aCc.uid) && data != null && aj.this.aCc.uid.equals(data.toUid)) {
                    boolean z = false;
                    if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(aj.this.mContext.getPageActivity(), updateAttentionMessage.getErrorString(), e.f.icon_toast_game_error, 3000).BN();
                        } else {
                            AntiHelper.a(aj.this.mContext.getPageActivity(), data.aPr);
                        }
                    }
                    if (data.Jr) {
                        aj.this.aCc.likeStatus = data.status;
                        aj.this.aCc.isAttention = data.isAttention;
                    }
                    if (z && aj.this.aCe != null) {
                        aj.this.aCe.c(data.Jr, aj.this.aCd);
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

    public boolean dK(int i) {
        if (i == aCa) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean x(int i, int i2) {
        this.aCd = i2;
        if (i == aBZ) {
            if (this.aCc == null || this.aCc.isAttention) {
                return true;
            }
            DJ();
            return false;
        } else if (i == aCa) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.aCc = attentionHostData;
    }

    private void DJ() {
        if (this.Td == null) {
            this.Td = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            this.Td.db(e.j.message_privacy_fans_can_reply);
            this.Td.a(e.j.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.DK();
                    aj.this.Td.dismiss();
                }
            });
            this.Td.b(e.j.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.Td.dismiss();
                }
            });
            this.Td.setAutoNight(true);
            this.Td.b(this.mContext);
        }
        this.Td.BF();
    }

    public void a(com.baidu.tbadk.core.data.aw awVar) {
        if (awVar != null && !StringUtils.isNull(awVar.title) && !StringUtils.isNull(awVar.asQ) && !StringUtils.isNull(awVar.asR)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.eB(awVar.title);
            aVar.a(awVar.asR, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.DK();
                    aVar2.dismiss();
                }
            });
            aVar.b(awVar.asQ, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.mContext);
            aVar.BF();
            return;
        }
        DJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DK() {
        if (!com.baidu.adp.lib.util.j.kK()) {
            this.mContext.showToast(e.j.network_ungeilivable);
        } else if (this.aCc != null && ba.bJ(this.mContext.getPageActivity())) {
            if (this.aCb == null) {
                this.aCb = new com.baidu.tbadk.coreExtra.model.a(this.mContext);
            }
            this.aCb.a(true, this.aCc.portrait, this.aCc.uid, this.aCc.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.aCe = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.Td != null) {
            this.Td.dismiss();
        }
        if (this.aCb != null) {
            this.aCb.cancel();
        }
    }
}
