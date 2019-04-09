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
    private com.baidu.tbadk.core.dialog.a VR;
    private com.baidu.tbadk.coreExtra.model.a bKB;
    private AttentionHostData bKC;
    private int bKD;
    private a bKE;
    private TbPageContext mContext;
    public static int bKw = 0;
    public static int bKx = 1;
    public static int bKy = 2;
    public static int bKz = 2;
    public static int bKA = 3;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.bKC != null && !StringUtils.isNull(aj.this.bKC.uid) && data != null && aj.this.bKC.uid.equals(data.toUid)) {
                    boolean z = false;
                    if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.b(aj.this.mContext.getPageActivity(), updateAttentionMessage.getErrorString(), d.f.icon_toast_game_error, 3000).abe();
                        } else {
                            AntiHelper.a(aj.this.mContext.getPageActivity(), data.bYC);
                        }
                    }
                    if (data.Jy) {
                        aj.this.bKC.likeStatus = data.status;
                        aj.this.bKC.isAttention = data.isAttention;
                    }
                    if (z && aj.this.bKE != null) {
                        aj.this.bKE.e(data.Jy, aj.this.bKD);
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

    public boolean hl(int i) {
        if (i == bKA) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean S(int i, int i2) {
        this.bKD = i2;
        if (i == bKz) {
            if (this.bKC == null || this.bKC.isAttention) {
                return true;
            }
            ade();
            return false;
        } else if (i == bKA) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.bKC = attentionHostData;
    }

    private void ade() {
        if (this.VR == null) {
            this.VR = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            this.VR.gC(d.j.message_privacy_fans_can_reply);
            this.VR.a(d.j.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.adf();
                    aj.this.VR.dismiss();
                }
            });
            this.VR.b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.VR.dismiss();
                }
            });
            this.VR.setAutoNight(true);
            this.VR.b(this.mContext);
        }
        this.VR.aaW();
    }

    public void a(com.baidu.tbadk.core.data.ba baVar) {
        if (baVar != null && !StringUtils.isNull(baVar.title) && !StringUtils.isNull(baVar.bAu) && !StringUtils.isNull(baVar.bAv)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.lz(baVar.title);
            aVar.a(baVar.bAv, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.adf();
                    aVar2.dismiss();
                }
            });
            aVar.b(baVar.bAu, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.mContext);
            aVar.aaW();
            return;
        }
        ade();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adf() {
        if (!com.baidu.adp.lib.util.j.kM()) {
            this.mContext.showToast(d.j.network_ungeilivable);
        } else if (this.bKC != null && bc.cZ(this.mContext.getPageActivity())) {
            if (this.bKB == null) {
                this.bKB = new com.baidu.tbadk.coreExtra.model.a(this.mContext);
            }
            this.bKB.a(true, this.bKC.portrait, this.bKC.uid, this.bKC.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.bKE = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.VR != null) {
            this.VR.dismiss();
        }
        if (this.bKB != null) {
            this.bKB.cancel();
        }
    }
}
