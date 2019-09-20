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
    public static int bTO = 0;
    public static int bTP = 1;
    public static int bTQ = 2;
    public static int bTR = 2;
    public static int bTS = 3;
    private com.baidu.tbadk.core.dialog.a TW;
    private com.baidu.tbadk.coreExtra.model.a bTT;
    private AttentionHostData bTU;
    private int bTV;
    private a bTW;
    private TbPageContext mContext;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.bTU != null && !StringUtils.isNull(aj.this.bTU.uid) && data != null && aj.this.bTU.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(aj.this.mContext.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake_n_svg, 3000, false).agW();
                        } else {
                            AntiHelper.a(aj.this.mContext.getPageActivity(), data.ciI);
                        }
                    }
                    if (data.Hs) {
                        aj.this.bTU.likeStatus = data.status;
                        aj.this.bTU.isAttention = data.isAttention;
                    }
                    if (z && aj.this.bTW != null) {
                        aj.this.bTW.e(data.Hs, aj.this.bTV);
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
        if (i == bTS) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean U(int i, int i2) {
        this.bTV = i2;
        if (i == bTR) {
            if (this.bTU == null || this.bTU.isAttention) {
                return true;
            }
            ajk();
            return false;
        } else if (i == bTS) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.bTU = attentionHostData;
    }

    private void ajk() {
        if (this.TW == null) {
            this.TW = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            this.TW.hv(R.string.message_privacy_fans_can_reply);
            this.TW.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.ajl();
                    aj.this.TW.dismiss();
                }
            });
            this.TW.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.TW.dismiss();
                }
            });
            this.TW.setAutoNight(true);
            this.TW.b(this.mContext);
        }
        this.TW.agO();
    }

    public void a(com.baidu.tbadk.core.data.bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(bbVar.title) && !StringUtils.isNull(bbVar.bJk) && !StringUtils.isNull(bbVar.bJl)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.mQ(bbVar.title);
            aVar.a(bbVar.bJl, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.ajl();
                    aVar2.dismiss();
                }
            });
            aVar.b(bbVar.bJk, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.mContext);
            aVar.agO();
            return;
        }
        ajk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajl() {
        if (!com.baidu.adp.lib.util.j.jQ()) {
            this.mContext.showToast(R.string.network_ungeilivable);
        } else if (this.bTU != null && bc.cF(this.mContext.getPageActivity())) {
            if (this.bTT == null) {
                this.bTT = new com.baidu.tbadk.coreExtra.model.a(this.mContext);
            }
            this.bTT.a(true, this.bTU.portrait, this.bTU.uid, this.bTU.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.bTW = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.TW != null) {
            this.TW.dismiss();
        }
        if (this.bTT != null) {
            this.bTT.cancel();
        }
    }
}
