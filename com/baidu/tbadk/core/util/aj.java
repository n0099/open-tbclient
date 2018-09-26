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
    public static int asY = 0;
    public static int asZ = 1;
    public static int ata = 2;
    public static int atb = 2;
    public static int atc = 3;
    private com.baidu.tbadk.core.dialog.a SK;
    private com.baidu.tbadk.coreExtra.model.a atd;
    private AttentionHostData ate;
    private int atf;
    private a atg;
    private TbPageContext mContext;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.ate != null && !StringUtils.isNull(aj.this.ate.uid) && data != null && aj.this.ate.uid.equals(data.toUid)) {
                    boolean z = false;
                    if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(aj.this.mContext.getPageActivity(), updateAttentionMessage.getErrorString(), e.f.icon_toast_game_error, 3000).yt();
                        } else {
                            AntiHelper.a(aj.this.mContext.getPageActivity(), data.aGz);
                        }
                    }
                    if (data.IM) {
                        aj.this.ate.likeStatus = data.status;
                        aj.this.ate.isAttention = data.isAttention;
                    }
                    if (z && aj.this.atg != null) {
                        aj.this.atg.c(data.IM, aj.this.atf);
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

    public boolean cY(int i) {
        if (i == atc) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean w(int i, int i2) {
        this.atf = i2;
        if (i == atb) {
            if (this.ate == null || this.ate.isAttention) {
                return true;
            }
            Ar();
            return false;
        } else if (i == atc) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.ate = attentionHostData;
    }

    private void Ar() {
        if (this.SK == null) {
            this.SK = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            this.SK.cp(e.j.message_privacy_fans_can_reply);
            this.SK.a(e.j.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.As();
                    aj.this.SK.dismiss();
                }
            });
            this.SK.b(e.j.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.SK.dismiss();
                }
            });
            this.SK.setAutoNight(true);
            this.SK.b(this.mContext);
        }
        this.SK.yl();
    }

    public void a(com.baidu.tbadk.core.data.aw awVar) {
        if (awVar != null && !StringUtils.isNull(awVar.title) && !StringUtils.isNull(awVar.ajH) && !StringUtils.isNull(awVar.ajI)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.dT(awVar.title);
            aVar.a(awVar.ajI, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.As();
                    aVar2.dismiss();
                }
            });
            aVar.b(awVar.ajH, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.mContext);
            aVar.yl();
            return;
        }
        Ar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void As() {
        if (!com.baidu.adp.lib.util.j.ky()) {
            this.mContext.showToast(e.j.network_ungeilivable);
        } else if (this.ate != null && ba.bA(this.mContext.getPageActivity())) {
            if (this.atd == null) {
                this.atd = new com.baidu.tbadk.coreExtra.model.a(this.mContext);
            }
            this.atd.a(true, this.ate.portrait, this.ate.uid, this.ate.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.atg = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.SK != null) {
            this.SK.dismiss();
        }
        if (this.atd != null) {
            this.atd.cancel();
        }
    }
}
