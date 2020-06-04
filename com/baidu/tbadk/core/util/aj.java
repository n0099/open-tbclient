package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class aj {
    public static int dNG = 0;
    public static int dNH = 1;
    public static int dNI = 2;
    public static int dNJ = 2;
    public static int dNK = 3;
    private com.baidu.tbadk.core.dialog.a Zw;
    private TbPageContext dIF;
    private com.baidu.tbadk.coreExtra.model.a dNL;
    private AttentionHostData dNM;
    private int dNN;
    private a dNO;
    private CustomMessageListener dNP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.dNM != null && !StringUtils.isNull(aj.this.dNM.uid) && data != null && aj.this.dNM.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(aj.this.dIF.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).aSY();
                        } else {
                            AntiHelper.a(aj.this.dIF.getPageActivity(), data.ecK);
                        }
                    }
                    if (data.isSucc) {
                        aj.this.dNM.likeStatus = data.status;
                        aj.this.dNM.isAttention = data.isAttention;
                    }
                    if (z && aj.this.dNO != null) {
                        aj.this.dNO.q(data.isSucc, aj.this.dNN);
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

    public aj(TbPageContext tbPageContext) {
        this.dIF = tbPageContext;
        this.dNP.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.dNP);
    }

    public boolean lb(int i) {
        if (i == dNK) {
            com.baidu.adp.lib.util.l.showToast(this.dIF.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean aD(int i, int i2) {
        this.dNN = i2;
        if (i == dNJ) {
            if (this.dNM == null || this.dNM.isAttention) {
                return true;
            }
            aUM();
            return false;
        } else if (i == dNK) {
            com.baidu.adp.lib.util.l.showToast(this.dIF.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.dNM = attentionHostData;
    }

    private void aUM() {
        if (this.Zw == null) {
            this.Zw = new com.baidu.tbadk.core.dialog.a(this.dIF.getPageActivity());
            this.Zw.kF(R.string.message_privacy_fans_can_reply);
            this.Zw.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.aUN();
                    aj.this.Zw.dismiss();
                }
            });
            this.Zw.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.Zw.dismiss();
                }
            });
            this.Zw.setAutoNight(true);
            this.Zw.b(this.dIF);
        }
        this.Zw.aST();
    }

    public void a(be beVar) {
        if (beVar != null && !StringUtils.isNull(beVar.title) && !StringUtils.isNull(beVar.dEa) && !StringUtils.isNull(beVar.dEb)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dIF.getPageActivity());
            aVar.vO(beVar.title);
            aVar.a(beVar.dEb, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.aUN();
                    aVar2.dismiss();
                }
            });
            aVar.b(beVar.dEa, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.dIF);
            aVar.aST();
            return;
        }
        aUM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUN() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.dIF.showToast(R.string.network_ungeilivable);
        } else if (this.dNM != null && bc.checkUpIsLogin(this.dIF.getPageActivity())) {
            if (this.dNL == null) {
                this.dNL = new com.baidu.tbadk.coreExtra.model.a(this.dIF);
            }
            this.dNL.a(true, this.dNM.portrait, this.dNM.uid, this.dNM.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.dNO = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.Zw != null) {
            this.Zw.dismiss();
        }
        if (this.dNL != null) {
            this.dNL.cancel();
        }
    }
}
