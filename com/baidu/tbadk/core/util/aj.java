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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class aj {
    public static int bKt = 0;
    public static int bKu = 1;
    public static int bKv = 2;
    public static int bKw = 2;
    public static int bKx = 3;
    private com.baidu.tbadk.core.dialog.a VQ;
    private int bKA;
    private a bKB;
    private com.baidu.tbadk.coreExtra.model.a bKy;
    private AttentionHostData bKz;
    private TbPageContext mContext;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.bKz != null && !StringUtils.isNull(aj.this.bKz.uid) && data != null && aj.this.bKz.uid.equals(data.toUid)) {
                    boolean z = false;
                    if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.b(aj.this.mContext.getPageActivity(), updateAttentionMessage.getErrorString(), d.f.icon_toast_game_error, 3000).abh();
                        } else {
                            AntiHelper.a(aj.this.mContext.getPageActivity(), data.bYz);
                        }
                    }
                    if (data.Jy) {
                        aj.this.bKz.likeStatus = data.status;
                        aj.this.bKz.isAttention = data.isAttention;
                    }
                    if (z && aj.this.bKB != null) {
                        aj.this.bKB.e(data.Jy, aj.this.bKA);
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

    public boolean hm(int i) {
        if (i == bKx) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean S(int i, int i2) {
        this.bKA = i2;
        if (i == bKw) {
            if (this.bKz == null || this.bKz.isAttention) {
                return true;
            }
            adh();
            return false;
        } else if (i == bKx) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.bKz = attentionHostData;
    }

    private void adh() {
        if (this.VQ == null) {
            this.VQ = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            this.VQ.gD(d.j.message_privacy_fans_can_reply);
            this.VQ.a(d.j.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.adi();
                    aj.this.VQ.dismiss();
                }
            });
            this.VQ.b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.VQ.dismiss();
                }
            });
            this.VQ.setAutoNight(true);
            this.VQ.b(this.mContext);
        }
        this.VQ.aaZ();
    }

    public void a(com.baidu.tbadk.core.data.ba baVar) {
        if (baVar != null && !StringUtils.isNull(baVar.title) && !StringUtils.isNull(baVar.bAq) && !StringUtils.isNull(baVar.bAr)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.ly(baVar.title);
            aVar.a(baVar.bAr, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.adi();
                    aVar2.dismiss();
                }
            });
            aVar.b(baVar.bAq, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.mContext);
            aVar.aaZ();
            return;
        }
        adh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adi() {
        if (!com.baidu.adp.lib.util.j.kM()) {
            this.mContext.showToast(d.j.network_ungeilivable);
        } else if (this.bKz != null && bc.cZ(this.mContext.getPageActivity())) {
            if (this.bKy == null) {
                this.bKy = new com.baidu.tbadk.coreExtra.model.a(this.mContext);
            }
            this.bKy.a(true, this.bKz.portrait, this.bKz.uid, this.bKz.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.bKB = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.VQ != null) {
            this.VQ.dismiss();
        }
        if (this.bKy != null) {
            this.bKy.cancel();
        }
    }
}
