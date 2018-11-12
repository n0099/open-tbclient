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
    private com.baidu.tbadk.core.dialog.a Td;
    private com.baidu.tbadk.coreExtra.model.a ayB;
    private AttentionHostData ayC;
    private int ayD;
    private a ayE;
    private TbPageContext mContext;
    public static int ayw = 0;
    public static int ayx = 1;
    public static int ayy = 2;
    public static int ayz = 2;
    public static int ayA = 3;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.ayC != null && !StringUtils.isNull(aj.this.ayC.uid) && data != null && aj.this.ayC.uid.equals(data.toUid)) {
                    boolean z = false;
                    if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(aj.this.mContext.getPageActivity(), updateAttentionMessage.getErrorString(), e.f.icon_toast_game_error, 3000).AJ();
                        } else {
                            AntiHelper.a(aj.this.mContext.getPageActivity(), data.aLS);
                        }
                    }
                    if (data.Jr) {
                        aj.this.ayC.likeStatus = data.status;
                        aj.this.ayC.isAttention = data.isAttention;
                    }
                    if (z && aj.this.ayE != null) {
                        aj.this.ayE.c(data.Jr, aj.this.ayD);
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

    public boolean dw(int i) {
        if (i == ayA) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean w(int i, int i2) {
        this.ayD = i2;
        if (i == ayz) {
            if (this.ayC == null || this.ayC.isAttention) {
                return true;
            }
            CF();
            return false;
        } else if (i == ayA) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.ayC = attentionHostData;
    }

    private void CF() {
        if (this.Td == null) {
            this.Td = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            this.Td.cN(e.j.message_privacy_fans_can_reply);
            this.Td.a(e.j.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.CG();
                    aj.this.Td.dismiss();
                }
            });
            this.Td.b(e.j.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.Td.dismiss();
                }
            });
            this.Td.setAutoNight(true);
            this.Td.b(this.mContext);
        }
        this.Td.AB();
    }

    public void a(com.baidu.tbadk.core.data.aw awVar) {
        if (awVar != null && !StringUtils.isNull(awVar.title) && !StringUtils.isNull(awVar.apq) && !StringUtils.isNull(awVar.apr)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.ej(awVar.title);
            aVar.a(awVar.apr, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.CG();
                    aVar2.dismiss();
                }
            });
            aVar.b(awVar.apq, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.mContext);
            aVar.AB();
            return;
        }
        CF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CG() {
        if (!com.baidu.adp.lib.util.j.kK()) {
            this.mContext.showToast(e.j.network_ungeilivable);
        } else if (this.ayC != null && ba.bG(this.mContext.getPageActivity())) {
            if (this.ayB == null) {
                this.ayB = new com.baidu.tbadk.coreExtra.model.a(this.mContext);
            }
            this.ayB.a(true, this.ayC.portrait, this.ayC.uid, this.ayC.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.ayE = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.Td != null) {
            this.Td.dismiss();
        }
        if (this.ayB != null) {
            this.ayB.cancel();
        }
    }
}
