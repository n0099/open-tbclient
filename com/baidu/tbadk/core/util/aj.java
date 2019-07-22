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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class aj {
    public static int bTh = 0;
    public static int bTi = 1;
    public static int bTj = 2;
    public static int bTk = 2;
    public static int bTl = 3;
    private com.baidu.tbadk.core.dialog.a TX;
    private com.baidu.tbadk.coreExtra.model.a bTm;
    private AttentionHostData bTn;
    private int bTo;
    private a bTp;
    private TbPageContext mContext;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.bTn != null && !StringUtils.isNull(aj.this.bTn.uid) && data != null && aj.this.bTn.uid.equals(data.toUid)) {
                    boolean z = false;
                    if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.b(aj.this.mContext.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_toast_game_error, 3000).agQ();
                        } else {
                            AntiHelper.a(aj.this.mContext.getPageActivity(), data.chF);
                        }
                    }
                    if (data.Hs) {
                        aj.this.bTn.likeStatus = data.status;
                        aj.this.bTn.isAttention = data.isAttention;
                    }
                    if (z && aj.this.bTp != null) {
                        aj.this.bTp.e(data.Hs, aj.this.bTo);
                    }
                }
            }
        }
    };
    private BdUniqueId mId = BdUniqueId.gen();

    /* loaded from: classes.dex */
    public interface a {
        void e(boolean z, int i);
    }

    public aj(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.mAttentionListener.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m19if(int i) {
        if (i == bTl) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean U(int i, int i2) {
        this.bTo = i2;
        if (i == bTk) {
            if (this.bTn == null || this.bTn.isAttention) {
                return true;
            }
            aje();
            return false;
        } else if (i == bTl) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.bTn = attentionHostData;
    }

    private void aje() {
        if (this.TX == null) {
            this.TX = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            this.TX.hu(R.string.message_privacy_fans_can_reply);
            this.TX.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.ajf();
                    aj.this.TX.dismiss();
                }
            });
            this.TX.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.TX.dismiss();
                }
            });
            this.TX.setAutoNight(true);
            this.TX.b(this.mContext);
        }
        this.TX.agI();
    }

    public void a(com.baidu.tbadk.core.data.ba baVar) {
        if (baVar != null && !StringUtils.isNull(baVar.title) && !StringUtils.isNull(baVar.bIH) && !StringUtils.isNull(baVar.bII)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.mO(baVar.title);
            aVar.a(baVar.bII, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.ajf();
                    aVar2.dismiss();
                }
            });
            aVar.b(baVar.bIH, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.mContext);
            aVar.agI();
            return;
        }
        aje();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajf() {
        if (!com.baidu.adp.lib.util.j.jQ()) {
            this.mContext.showToast(R.string.network_ungeilivable);
        } else if (this.bTn != null && bd.cF(this.mContext.getPageActivity())) {
            if (this.bTm == null) {
                this.bTm = new com.baidu.tbadk.coreExtra.model.a(this.mContext);
            }
            this.bTm.a(true, this.bTn.portrait, this.bTn.uid, this.bTn.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.bTp = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.TX != null) {
            this.TX.dismiss();
        }
        if (this.bTm != null) {
            this.bTm.cancel();
        }
    }
}
