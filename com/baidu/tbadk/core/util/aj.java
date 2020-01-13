package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class aj {
    public static int cVT = 0;
    public static int cVU = 1;
    public static int cVV = 2;
    public static int cVW = 2;
    public static int cVX = 3;
    private com.baidu.tbadk.core.dialog.a Fy;
    private TbPageContext cRe;
    private com.baidu.tbadk.coreExtra.model.a cVY;
    private AttentionHostData cVZ;
    private int cWa;
    private a cWb;
    private CustomMessageListener cWc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.cVZ != null && !StringUtils.isNull(aj.this.cVZ.uid) && data != null && aj.this.cVZ.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(aj.this.cRe.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).aCu();
                        } else {
                            AntiHelper.a(aj.this.cRe.getPageActivity(), data.djO);
                        }
                    }
                    if (data.isSucc) {
                        aj.this.cVZ.likeStatus = data.status;
                        aj.this.cVZ.isAttention = data.isAttention;
                    }
                    if (z && aj.this.cWb != null) {
                        aj.this.cWb.k(data.isSucc, aj.this.cWa);
                    }
                }
            }
        }
    };
    private BdUniqueId mId = BdUniqueId.gen();

    /* loaded from: classes.dex */
    public interface a {
        void k(boolean z, int i);
    }

    public aj(TbPageContext tbPageContext) {
        this.cRe = tbPageContext;
        this.cWc.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.cWc);
    }

    public boolean kb(int i) {
        if (i == cVX) {
            com.baidu.adp.lib.util.l.showToast(this.cRe.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean ax(int i, int i2) {
        this.cWa = i2;
        if (i == cVW) {
            if (this.cVZ == null || this.cVZ.isAttention) {
                return true;
            }
            aEg();
            return false;
        } else if (i == cVX) {
            com.baidu.adp.lib.util.l.showToast(this.cRe.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.cVZ = attentionHostData;
    }

    private void aEg() {
        if (this.Fy == null) {
            this.Fy = new com.baidu.tbadk.core.dialog.a(this.cRe.getPageActivity());
            this.Fy.jF(R.string.message_privacy_fans_can_reply);
            this.Fy.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.aEh();
                    aj.this.Fy.dismiss();
                }
            });
            this.Fy.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.Fy.dismiss();
                }
            });
            this.Fy.setAutoNight(true);
            this.Fy.b(this.cRe);
        }
        this.Fy.aCp();
    }

    public void a(bd bdVar) {
        if (bdVar != null && !StringUtils.isNull(bdVar.title) && !StringUtils.isNull(bdVar.cMB) && !StringUtils.isNull(bdVar.cMC)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cRe.getPageActivity());
            aVar.sC(bdVar.title);
            aVar.a(bdVar.cMC, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.aEh();
                    aVar2.dismiss();
                }
            });
            aVar.b(bdVar.cMB, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.cRe);
            aVar.aCp();
            return;
        }
        aEg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEh() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.cRe.showToast(R.string.network_ungeilivable);
        } else if (this.cVZ != null && bc.checkUpIsLogin(this.cRe.getPageActivity())) {
            if (this.cVY == null) {
                this.cVY = new com.baidu.tbadk.coreExtra.model.a(this.cRe);
            }
            this.cVY.a(true, this.cVZ.portrait, this.cVZ.uid, this.cVZ.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.cWb = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.Fy != null) {
            this.Fy.dismiss();
        }
        if (this.cVY != null) {
            this.cVY.cancel();
        }
    }
}
