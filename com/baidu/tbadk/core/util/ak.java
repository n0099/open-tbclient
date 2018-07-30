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
public class ak {
    private com.baidu.tbadk.core.dialog.a Qj;
    private com.baidu.tbadk.coreExtra.model.a aqE;
    private AttentionHostData aqF;
    private int aqG;
    private a aqH;
    private TbPageContext mContext;
    public static int aqz = 0;
    public static int aqA = 1;
    public static int aqB = 2;
    public static int aqC = 2;
    public static int aqD = 3;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.util.ak.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (ak.this.aqF != null && !StringUtils.isNull(ak.this.aqF.uid) && data != null && ak.this.aqF.uid.equals(data.toUid)) {
                    boolean z = false;
                    if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(ak.this.mId)) {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(ak.this.mContext.getPageActivity(), updateAttentionMessage.getErrorString(), d.f.icon_toast_game_error, 3000).xn();
                        } else {
                            AntiHelper.a(ak.this.mContext.getPageActivity(), data.aDu);
                        }
                    }
                    if (data.Gp) {
                        ak.this.aqF.likeStatus = data.status;
                        ak.this.aqF.isAttention = data.isAttention;
                    }
                    if (z && ak.this.aqH != null) {
                        ak.this.aqH.c(data.Gp, ak.this.aqG);
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

    public boolean cP(int i) {
        if (i == aqD) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean u(int i, int i2) {
        this.aqG = i2;
        if (i == aqC) {
            if (this.aqF == null || this.aqF.isAttention) {
                return true;
            }
            zo();
            return false;
        } else if (i == aqD) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.aqF = attentionHostData;
    }

    private void zo() {
        if (this.Qj == null) {
            this.Qj = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            this.Qj.cf(d.j.message_privacy_fans_can_reply);
            this.Qj.a(d.j.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.ak.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ak.this.zp();
                    ak.this.Qj.dismiss();
                }
            });
            this.Qj.b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.ak.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ak.this.Qj.dismiss();
                }
            });
            this.Qj.setAutoNight(true);
            this.Qj.b(this.mContext);
        }
        this.Qj.xf();
    }

    public void a(com.baidu.tbadk.core.data.aw awVar) {
        if (awVar != null && !StringUtils.isNull(awVar.title) && !StringUtils.isNull(awVar.ahh) && !StringUtils.isNull(awVar.ahi)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.dB(awVar.title);
            aVar.a(awVar.ahi, new a.b() { // from class: com.baidu.tbadk.core.util.ak.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    ak.this.zp();
                    aVar2.dismiss();
                }
            });
            aVar.b(awVar.ahh, new a.b() { // from class: com.baidu.tbadk.core.util.ak.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.mContext);
            aVar.xf();
            return;
        }
        zo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zp() {
        if (!com.baidu.adp.lib.util.j.js()) {
            this.mContext.showToast(d.j.network_ungeilivable);
        } else if (this.aqF != null && ba.aV(this.mContext.getPageActivity())) {
            if (this.aqE == null) {
                this.aqE = new com.baidu.tbadk.coreExtra.model.a(this.mContext);
            }
            this.aqE.a(true, this.aqF.portrait, this.aqF.uid, this.aqF.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.aqH = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.Qj != null) {
            this.Qj.dismiss();
        }
        if (this.aqE != null) {
            this.aqE.cancel();
        }
    }
}
