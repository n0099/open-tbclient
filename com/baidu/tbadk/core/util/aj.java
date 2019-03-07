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
    public static int bKs = 0;
    public static int bKt = 1;
    public static int bKu = 2;
    public static int bKv = 2;
    public static int bKw = 3;
    private com.baidu.tbadk.core.dialog.a VP;
    private a bKA;
    private com.baidu.tbadk.coreExtra.model.a bKx;
    private AttentionHostData bKy;
    private int bKz;
    private TbPageContext mContext;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.bKy != null && !StringUtils.isNull(aj.this.bKy.uid) && data != null && aj.this.bKy.uid.equals(data.toUid)) {
                    boolean z = false;
                    if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.b(aj.this.mContext.getPageActivity(), updateAttentionMessage.getErrorString(), d.f.icon_toast_game_error, 3000).abh();
                        } else {
                            AntiHelper.a(aj.this.mContext.getPageActivity(), data.bYy);
                        }
                    }
                    if (data.Jy) {
                        aj.this.bKy.likeStatus = data.status;
                        aj.this.bKy.isAttention = data.isAttention;
                    }
                    if (z && aj.this.bKA != null) {
                        aj.this.bKA.e(data.Jy, aj.this.bKz);
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
        if (i == bKw) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean S(int i, int i2) {
        this.bKz = i2;
        if (i == bKv) {
            if (this.bKy == null || this.bKy.isAttention) {
                return true;
            }
            adh();
            return false;
        } else if (i == bKw) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.bKy = attentionHostData;
    }

    private void adh() {
        if (this.VP == null) {
            this.VP = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            this.VP.gD(d.j.message_privacy_fans_can_reply);
            this.VP.a(d.j.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.adi();
                    aj.this.VP.dismiss();
                }
            });
            this.VP.b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.VP.dismiss();
                }
            });
            this.VP.setAutoNight(true);
            this.VP.b(this.mContext);
        }
        this.VP.aaZ();
    }

    public void a(com.baidu.tbadk.core.data.ba baVar) {
        if (baVar != null && !StringUtils.isNull(baVar.title) && !StringUtils.isNull(baVar.bAo) && !StringUtils.isNull(baVar.bAp)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.ly(baVar.title);
            aVar.a(baVar.bAp, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.adi();
                    aVar2.dismiss();
                }
            });
            aVar.b(baVar.bAo, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
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
        } else if (this.bKy != null && bc.cZ(this.mContext.getPageActivity())) {
            if (this.bKx == null) {
                this.bKx = new com.baidu.tbadk.coreExtra.model.a(this.mContext);
            }
            this.bKx.a(true, this.bKy.portrait, this.bKy.uid, this.bKy.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.bKA = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.VP != null) {
            this.VP.dismiss();
        }
        if (this.bKx != null) {
            this.bKx.cancel();
        }
    }
}
