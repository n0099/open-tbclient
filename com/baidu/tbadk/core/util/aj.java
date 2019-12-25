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
    public static int cVJ = 0;
    public static int cVK = 1;
    public static int cVL = 2;
    public static int cVM = 2;
    public static int cVN = 3;
    private com.baidu.tbadk.core.dialog.a Ft;
    private TbPageContext cQU;
    private com.baidu.tbadk.coreExtra.model.a cVO;
    private AttentionHostData cVP;
    private int cVQ;
    private a cVR;
    private CustomMessageListener cVS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.cVP != null && !StringUtils.isNull(aj.this.cVP.uid) && data != null && aj.this.cVP.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(aj.this.cQU.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).aCb();
                        } else {
                            AntiHelper.a(aj.this.cQU.getPageActivity(), data.djy);
                        }
                    }
                    if (data.isSucc) {
                        aj.this.cVP.likeStatus = data.status;
                        aj.this.cVP.isAttention = data.isAttention;
                    }
                    if (z && aj.this.cVR != null) {
                        aj.this.cVR.j(data.isSucc, aj.this.cVQ);
                    }
                }
            }
        }
    };
    private BdUniqueId mId = BdUniqueId.gen();

    /* loaded from: classes.dex */
    public interface a {
        void j(boolean z, int i);
    }

    public aj(TbPageContext tbPageContext) {
        this.cQU = tbPageContext;
        this.cVS.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.cVS);
    }

    public boolean kb(int i) {
        if (i == cVN) {
            com.baidu.adp.lib.util.l.showToast(this.cQU.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean at(int i, int i2) {
        this.cVQ = i2;
        if (i == cVM) {
            if (this.cVP == null || this.cVP.isAttention) {
                return true;
            }
            aDN();
            return false;
        } else if (i == cVN) {
            com.baidu.adp.lib.util.l.showToast(this.cQU.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.cVP = attentionHostData;
    }

    private void aDN() {
        if (this.Ft == null) {
            this.Ft = new com.baidu.tbadk.core.dialog.a(this.cQU.getPageActivity());
            this.Ft.jF(R.string.message_privacy_fans_can_reply);
            this.Ft.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.aDO();
                    aj.this.Ft.dismiss();
                }
            });
            this.Ft.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.Ft.dismiss();
                }
            });
            this.Ft.setAutoNight(true);
            this.Ft.b(this.cQU);
        }
        this.Ft.aBW();
    }

    public void a(bd bdVar) {
        if (bdVar != null && !StringUtils.isNull(bdVar.title) && !StringUtils.isNull(bdVar.cMr) && !StringUtils.isNull(bdVar.cMs)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cQU.getPageActivity());
            aVar.sz(bdVar.title);
            aVar.a(bdVar.cMs, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.aDO();
                    aVar2.dismiss();
                }
            });
            aVar.b(bdVar.cMr, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.cQU);
            aVar.aBW();
            return;
        }
        aDN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDO() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.cQU.showToast(R.string.network_ungeilivable);
        } else if (this.cVP != null && bc.checkUpIsLogin(this.cQU.getPageActivity())) {
            if (this.cVO == null) {
                this.cVO = new com.baidu.tbadk.coreExtra.model.a(this.cQU);
            }
            this.cVO.a(true, this.cVP.portrait, this.cVP.uid, this.cVP.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.cVR = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.Ft != null) {
            this.Ft.dismiss();
        }
        if (this.cVO != null) {
            this.cVO.cancel();
        }
    }
}
