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
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class ak {
    public static int aqA = 0;
    public static int aqB = 1;
    public static int aqC = 2;
    public static int aqD = 2;
    public static int aqE = 3;
    private com.baidu.tbadk.core.dialog.a Qj;
    private com.baidu.tbadk.coreExtra.model.a aqF;
    private AttentionHostData aqG;
    private int aqH;
    private a aqI;
    private TbPageContext mContext;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.util.ak.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (ak.this.aqG != null && !StringUtils.isNull(ak.this.aqG.uid) && data != null && ak.this.aqG.uid.equals(data.toUid)) {
                    boolean z = false;
                    if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(ak.this.mId)) {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(ak.this.mContext.getPageActivity(), updateAttentionMessage.getErrorString(), f.C0146f.icon_toast_game_error, 3000).xm();
                        } else {
                            AntiHelper.a(ak.this.mContext.getPageActivity(), data.aDt);
                        }
                    }
                    if (data.Gp) {
                        ak.this.aqG.likeStatus = data.status;
                        ak.this.aqG.isAttention = data.isAttention;
                    }
                    if (z && ak.this.aqI != null) {
                        ak.this.aqI.c(data.Gp, ak.this.aqH);
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
        if (i == aqE) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), f.j.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean u(int i, int i2) {
        this.aqH = i2;
        if (i == aqD) {
            if (this.aqG == null || this.aqG.isAttention) {
                return true;
            }
            zm();
            return false;
        } else if (i == aqE) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), f.j.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.aqG = attentionHostData;
    }

    private void zm() {
        if (this.Qj == null) {
            this.Qj = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            this.Qj.cf(f.j.message_privacy_fans_can_reply);
            this.Qj.a(f.j.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.ak.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ak.this.zn();
                    ak.this.Qj.dismiss();
                }
            });
            this.Qj.b(f.j.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.ak.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ak.this.Qj.dismiss();
                }
            });
            this.Qj.setAutoNight(true);
            this.Qj.b(this.mContext);
        }
        this.Qj.xe();
    }

    public void a(com.baidu.tbadk.core.data.aw awVar) {
        if (awVar != null && !StringUtils.isNull(awVar.title) && !StringUtils.isNull(awVar.ahh) && !StringUtils.isNull(awVar.ahi)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.dB(awVar.title);
            aVar.a(awVar.ahi, new a.b() { // from class: com.baidu.tbadk.core.util.ak.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    ak.this.zn();
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
            aVar.xe();
            return;
        }
        zm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zn() {
        if (!com.baidu.adp.lib.util.j.js()) {
            this.mContext.showToast(f.j.network_ungeilivable);
        } else if (this.aqG != null && bb.aU(this.mContext.getPageActivity())) {
            if (this.aqF == null) {
                this.aqF = new com.baidu.tbadk.coreExtra.model.a(this.mContext);
            }
            this.aqF.a(true, this.aqG.portrait, this.aqG.uid, this.aqG.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.aqI = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.Qj != null) {
            this.Qj.dismiss();
        }
        if (this.aqF != null) {
            this.aqF.cancel();
        }
    }
}
