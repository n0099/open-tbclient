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
    public static int bSh = 0;
    public static int bSi = 1;
    public static int bSj = 2;
    public static int bSk = 2;
    public static int bSl = 3;
    private com.baidu.tbadk.core.dialog.a TD;
    private com.baidu.tbadk.coreExtra.model.a bSm;
    private AttentionHostData bSn;
    private int bSo;
    private a bSp;
    private TbPageContext mContext;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.bSn != null && !StringUtils.isNull(aj.this.bSn.uid) && data != null && aj.this.bSn.uid.equals(data.toUid)) {
                    boolean z = false;
                    if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.b(aj.this.mContext.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_toast_game_error, 3000).afO();
                        } else {
                            AntiHelper.a(aj.this.mContext.getPageActivity(), data.cgA);
                        }
                    }
                    if (data.Hh) {
                        aj.this.bSn.likeStatus = data.status;
                        aj.this.bSn.isAttention = data.isAttention;
                    }
                    if (z && aj.this.bSp != null) {
                        aj.this.bSp.e(data.Hh, aj.this.bSo);
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

    public boolean hZ(int i) {
        if (i == bSl) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean R(int i, int i2) {
        this.bSo = i2;
        if (i == bSk) {
            if (this.bSn == null || this.bSn.isAttention) {
                return true;
            }
            aic();
            return false;
        } else if (i == bSl) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.bSn = attentionHostData;
    }

    private void aic() {
        if (this.TD == null) {
            this.TD = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            this.TD.ho(R.string.message_privacy_fans_can_reply);
            this.TD.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.aid();
                    aj.this.TD.dismiss();
                }
            });
            this.TD.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.TD.dismiss();
                }
            });
            this.TD.setAutoNight(true);
            this.TD.b(this.mContext);
        }
        this.TD.afG();
    }

    public void a(com.baidu.tbadk.core.data.ba baVar) {
        if (baVar != null && !StringUtils.isNull(baVar.title) && !StringUtils.isNull(baVar.bHH) && !StringUtils.isNull(baVar.bHI)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.mD(baVar.title);
            aVar.a(baVar.bHI, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.aid();
                    aVar2.dismiss();
                }
            });
            aVar.b(baVar.bHH, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.mContext);
            aVar.afG();
            return;
        }
        aic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aid() {
        if (!com.baidu.adp.lib.util.j.jG()) {
            this.mContext.showToast(R.string.network_ungeilivable);
        } else if (this.bSn != null && bc.cE(this.mContext.getPageActivity())) {
            if (this.bSm == null) {
                this.bSm = new com.baidu.tbadk.coreExtra.model.a(this.mContext);
            }
            this.bSm.a(true, this.bSn.portrait, this.bSn.uid, this.bSn.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.bSp = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.TD != null) {
            this.TD.dismiss();
        }
        if (this.bSm != null) {
            this.bSm.cancel();
        }
    }
}
