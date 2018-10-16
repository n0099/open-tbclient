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
    public static int axJ = 0;
    public static int axK = 1;
    public static int axL = 2;
    public static int axM = 2;
    public static int axN = 3;
    private com.baidu.tbadk.core.dialog.a Tb;
    private com.baidu.tbadk.coreExtra.model.a axO;
    private AttentionHostData axP;
    private int axQ;
    private a axR;
    private TbPageContext mContext;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.axP != null && !StringUtils.isNull(aj.this.axP.uid) && data != null && aj.this.axP.uid.equals(data.toUid)) {
                    boolean z = false;
                    if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(aj.this.mContext.getPageActivity(), updateAttentionMessage.getErrorString(), e.f.icon_toast_game_error, 3000).AC();
                        } else {
                            AntiHelper.a(aj.this.mContext.getPageActivity(), data.aLc);
                        }
                    }
                    if (data.Jo) {
                        aj.this.axP.likeStatus = data.status;
                        aj.this.axP.isAttention = data.isAttention;
                    }
                    if (z && aj.this.axR != null) {
                        aj.this.axR.c(data.Jo, aj.this.axQ);
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

    public boolean di(int i) {
        if (i == axN) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean w(int i, int i2) {
        this.axQ = i2;
        if (i == axM) {
            if (this.axP == null || this.axP.isAttention) {
                return true;
            }
            Cy();
            return false;
        } else if (i == axN) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.axP = attentionHostData;
    }

    private void Cy() {
        if (this.Tb == null) {
            this.Tb = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            this.Tb.cz(e.j.message_privacy_fans_can_reply);
            this.Tb.a(e.j.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.Cz();
                    aj.this.Tb.dismiss();
                }
            });
            this.Tb.b(e.j.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.Tb.dismiss();
                }
            });
            this.Tb.setAutoNight(true);
            this.Tb.b(this.mContext);
        }
        this.Tb.Au();
    }

    public void a(com.baidu.tbadk.core.data.aw awVar) {
        if (awVar != null && !StringUtils.isNull(awVar.title) && !StringUtils.isNull(awVar.aoC) && !StringUtils.isNull(awVar.aoD)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.ej(awVar.title);
            aVar.a(awVar.aoD, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.Cz();
                    aVar2.dismiss();
                }
            });
            aVar.b(awVar.aoC, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.mContext);
            aVar.Au();
            return;
        }
        Cy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cz() {
        if (!com.baidu.adp.lib.util.j.kM()) {
            this.mContext.showToast(e.j.network_ungeilivable);
        } else if (this.axP != null && ba.bI(this.mContext.getPageActivity())) {
            if (this.axO == null) {
                this.axO = new com.baidu.tbadk.coreExtra.model.a(this.mContext);
            }
            this.axO.a(true, this.axP.portrait, this.axP.uid, this.axP.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.axR = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.Tb != null) {
            this.Tb.dismiss();
        }
        if (this.axO != null) {
            this.axO.cancel();
        }
    }
}
