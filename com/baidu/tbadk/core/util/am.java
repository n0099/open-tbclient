package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class am {
    private com.baidu.tbadk.core.dialog.a acq;
    private TbPageContext eNx;
    private com.baidu.tbadk.coreExtra.model.a eTC;
    private AttentionHostData eTD;
    private int eTE;
    private a eTF;
    private CustomMessageListener eTG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.am.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (am.this.eTD != null && !StringUtils.isNull(am.this.eTD.uid) && data != null && am.this.eTD.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(am.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(am.this.eNx.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).brB();
                        } else {
                            AntiHelper.a(am.this.eNx.getPageActivity(), data.flk);
                        }
                    }
                    if (data.isSucc) {
                        am.this.eTD.likeStatus = data.status;
                        am.this.eTD.isAttention = data.isAttention;
                    }
                    if (z && am.this.eTF != null) {
                        am.this.eTF.r(data.isSucc, am.this.eTE);
                    }
                }
            }
        }
    };
    private BdUniqueId mId = BdUniqueId.gen();
    public static int eTx = 0;
    public static int eTy = 1;
    public static int eTz = 2;
    public static int eTA = 2;
    public static int eTB = 3;

    /* loaded from: classes.dex */
    public interface a {
        void r(boolean z, int i);
    }

    public am(TbPageContext tbPageContext) {
        this.eNx = tbPageContext;
        this.eTG.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.eTG);
    }

    public boolean pP(int i) {
        if (i == eTB) {
            com.baidu.adp.lib.util.l.showToast(this.eNx.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean aQ(int i, int i2) {
        this.eTE = i2;
        if (i == eTA) {
            if (this.eTD == null || this.eTD.isAttention) {
                return true;
            }
            btK();
            return false;
        } else if (i == eTB) {
            com.baidu.adp.lib.util.l.showToast(this.eNx.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public boolean pQ(int i) {
        if (i == eTA) {
            if (this.eTD == null || this.eTD.isAttention) {
                return true;
            }
            com.baidu.adp.lib.util.l.showToast(this.eNx.getPageActivity(), R.string.message_privacy_fans_can_reply);
            return false;
        } else if (i == eTB) {
            com.baidu.adp.lib.util.l.showToast(this.eNx.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.eTD = attentionHostData;
    }

    private void btK() {
        if (this.acq == null) {
            this.acq = new com.baidu.tbadk.core.dialog.a(this.eNx.getPageActivity());
            this.acq.oQ(R.string.message_privacy_fans_can_reply);
            this.acq.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.am.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.btL();
                    am.this.acq.dismiss();
                }
            });
            this.acq.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.am.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.acq.dismiss();
                }
            });
            this.acq.setAutoNight(true);
            this.acq.b(this.eNx);
        }
        this.acq.brv();
    }

    public void a(br brVar) {
        if (brVar != null && !StringUtils.isNull(brVar.title) && !StringUtils.isNull(brVar.eIh) && !StringUtils.isNull(brVar.eIi)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eNx.getPageActivity());
            aVar.Bq(brVar.title);
            aVar.a(brVar.eIi, new a.b() { // from class: com.baidu.tbadk.core.util.am.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    am.this.btL();
                    aVar2.dismiss();
                }
            });
            aVar.b(brVar.eIh, new a.b() { // from class: com.baidu.tbadk.core.util.am.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.eNx);
            aVar.brv();
            return;
        }
        btK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btL() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.eNx.showToast(R.string.network_ungeilivable);
        } else if (this.eTD != null && bh.checkUpIsLogin(this.eNx.getPageActivity())) {
            if (this.eTC == null) {
                this.eTC = new com.baidu.tbadk.coreExtra.model.a(this.eNx);
            }
            this.eTC.a(true, this.eTD.portrait, this.eTD.uid, this.eTD.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.eTF = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.acq != null) {
            this.acq.dismiss();
        }
        if (this.eTC != null) {
            this.eTC.cancel();
        }
    }
}
