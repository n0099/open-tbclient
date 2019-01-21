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
    private com.baidu.tbadk.core.dialog.a Tm;
    private com.baidu.tbadk.coreExtra.model.a aCE;
    private AttentionHostData aCF;
    private int aCG;
    private a aCH;
    private TbPageContext mContext;
    public static int aCz = 0;
    public static int aCA = 1;
    public static int aCB = 2;
    public static int aCC = 2;
    public static int aCD = 3;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.aCF != null && !StringUtils.isNull(aj.this.aCF.uid) && data != null && aj.this.aCF.uid.equals(data.toUid)) {
                    boolean z = false;
                    if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(aj.this.mContext.getPageActivity(), updateAttentionMessage.getErrorString(), e.f.icon_toast_game_error, 3000).Ca();
                        } else {
                            AntiHelper.a(aj.this.mContext.getPageActivity(), data.aPY);
                        }
                    }
                    if (data.Jr) {
                        aj.this.aCF.likeStatus = data.status;
                        aj.this.aCF.isAttention = data.isAttention;
                    }
                    if (z && aj.this.aCH != null) {
                        aj.this.aCH.c(data.Jr, aj.this.aCG);
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
        if (i == aCD) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean x(int i, int i2) {
        this.aCG = i2;
        if (i == aCC) {
            if (this.aCF == null || this.aCF.isAttention) {
                return true;
            }
            DW();
            return false;
        } else if (i == aCD) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.aCF = attentionHostData;
    }

    private void DW() {
        if (this.Tm == null) {
            this.Tm = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            this.Tm.db(e.j.message_privacy_fans_can_reply);
            this.Tm.a(e.j.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.DX();
                    aj.this.Tm.dismiss();
                }
            });
            this.Tm.b(e.j.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.Tm.dismiss();
                }
            });
            this.Tm.setAutoNight(true);
            this.Tm.b(this.mContext);
        }
        this.Tm.BS();
    }

    public void a(com.baidu.tbadk.core.data.aw awVar) {
        if (awVar != null && !StringUtils.isNull(awVar.title) && !StringUtils.isNull(awVar.att) && !StringUtils.isNull(awVar.atu)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.eK(awVar.title);
            aVar.a(awVar.atu, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.DX();
                    aVar2.dismiss();
                }
            });
            aVar.b(awVar.att, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.mContext);
            aVar.BS();
            return;
        }
        DW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DX() {
        if (!com.baidu.adp.lib.util.j.kK()) {
            this.mContext.showToast(e.j.network_ungeilivable);
        } else if (this.aCF != null && ba.bJ(this.mContext.getPageActivity())) {
            if (this.aCE == null) {
                this.aCE = new com.baidu.tbadk.coreExtra.model.a(this.mContext);
            }
            this.aCE.a(true, this.aCF.portrait, this.aCF.uid, this.aCF.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.aCH = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.Tm != null) {
            this.Tm.dismiss();
        }
        if (this.aCE != null) {
            this.aCE.cancel();
        }
    }
}
