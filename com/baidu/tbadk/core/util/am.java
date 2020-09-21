package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class am {
    public static int emR = 0;
    public static int emS = 1;
    public static int emT = 2;
    public static int emU = 2;
    public static int emV = 3;
    private com.baidu.tbadk.core.dialog.a aaV;
    private TbPageContext ehG;
    private com.baidu.tbadk.coreExtra.model.a emW;
    private AttentionHostData emX;
    private int emY;
    private a emZ;
    private CustomMessageListener ena = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.am.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (am.this.emX != null && !StringUtils.isNull(am.this.emX.uid) && data != null && am.this.emX.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(am.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(am.this.ehG.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).big();
                        } else {
                            AntiHelper.a(am.this.ehG.getPageActivity(), data.eEj);
                        }
                    }
                    if (data.isSucc) {
                        am.this.emX.likeStatus = data.status;
                        am.this.emX.isAttention = data.isAttention;
                    }
                    if (z && am.this.emZ != null) {
                        am.this.emZ.q(data.isSucc, am.this.emY);
                    }
                }
            }
        }
    };
    private BdUniqueId mId = BdUniqueId.gen();

    /* loaded from: classes.dex */
    public interface a {
        void q(boolean z, int i);
    }

    public am(TbPageContext tbPageContext) {
        this.ehG = tbPageContext;
        this.ena.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.ena);
    }

    public boolean ob(int i) {
        if (i == emV) {
            com.baidu.adp.lib.util.l.showToast(this.ehG.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean aN(int i, int i2) {
        this.emY = i2;
        if (i == emU) {
            if (this.emX == null || this.emX.isAttention) {
                return true;
            }
            bka();
            return false;
        } else if (i == emV) {
            com.baidu.adp.lib.util.l.showToast(this.ehG.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public boolean oc(int i) {
        if (i == emU) {
            if (this.emX == null || this.emX.isAttention) {
                return true;
            }
            com.baidu.adp.lib.util.l.showToast(this.ehG.getPageActivity(), R.string.message_privacy_fans_can_reply);
            return false;
        } else if (i == emV) {
            com.baidu.adp.lib.util.l.showToast(this.ehG.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.emX = attentionHostData;
    }

    private void bka() {
        if (this.aaV == null) {
            this.aaV = new com.baidu.tbadk.core.dialog.a(this.ehG.getPageActivity());
            this.aaV.nE(R.string.message_privacy_fans_can_reply);
            this.aaV.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.am.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.bkb();
                    am.this.aaV.dismiss();
                }
            });
            this.aaV.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.am.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.aaV.dismiss();
                }
            });
            this.aaV.setAutoNight(true);
            this.aaV.b(this.ehG);
        }
        this.aaV.bia();
    }

    public void a(bp bpVar) {
        if (bpVar != null && !StringUtils.isNull(bpVar.title) && !StringUtils.isNull(bpVar.ecw) && !StringUtils.isNull(bpVar.ecx)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ehG.getPageActivity());
            aVar.zV(bpVar.title);
            aVar.a(bpVar.ecx, new a.b() { // from class: com.baidu.tbadk.core.util.am.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    am.this.bkb();
                    aVar2.dismiss();
                }
            });
            aVar.b(bpVar.ecw, new a.b() { // from class: com.baidu.tbadk.core.util.am.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.ehG);
            aVar.bia();
            return;
        }
        bka();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkb() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.ehG.showToast(R.string.network_ungeilivable);
        } else if (this.emX != null && bg.checkUpIsLogin(this.ehG.getPageActivity())) {
            if (this.emW == null) {
                this.emW = new com.baidu.tbadk.coreExtra.model.a(this.ehG);
            }
            this.emW.a(true, this.emX.portrait, this.emX.uid, this.emX.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.emZ = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.aaV != null) {
            this.aaV.dismiss();
        }
        if (this.emW != null) {
            this.emW.cancel();
        }
    }
}
