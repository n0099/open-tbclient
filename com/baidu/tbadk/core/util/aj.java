package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class aj {
    public static int ciZ = 0;
    public static int cja = 1;
    public static int cjb = 2;
    public static int cjc = 2;
    public static int cjd = 3;
    private com.baidu.tbadk.core.dialog.a CM;
    private TbPageContext ceu;
    private com.baidu.tbadk.coreExtra.model.a cje;
    private AttentionHostData cjf;
    private int cjg;
    private a cjh;
    private CustomMessageListener cji = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.cjf != null && !StringUtils.isNull(aj.this.cjf.uid) && data != null && aj.this.cjf.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(aj.this.ceu.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake_n_svg, 3000, false).akR();
                        } else {
                            AntiHelper.a(aj.this.ceu.getPageActivity(), data.cvM);
                        }
                    }
                    if (data.isSucc) {
                        aj.this.cjf.likeStatus = data.status;
                        aj.this.cjf.isAttention = data.isAttention;
                    }
                    if (z && aj.this.cjh != null) {
                        aj.this.cjh.f(data.isSucc, aj.this.cjg);
                    }
                }
            }
        }
    };
    private BdUniqueId mId = BdUniqueId.gen();

    /* loaded from: classes.dex */
    public interface a {
        void f(boolean z, int i);
    }

    public aj(TbPageContext tbPageContext) {
        this.ceu = tbPageContext;
        this.cji.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.cji);
    }

    public boolean ip(int i) {
        if (i == cjd) {
            com.baidu.adp.lib.util.l.showToast(this.ceu.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean Y(int i, int i2) {
        this.cjg = i2;
        if (i == cjc) {
            if (this.cjf == null || this.cjf.isAttention) {
                return true;
            }
            amB();
            return false;
        } else if (i == cjd) {
            com.baidu.adp.lib.util.l.showToast(this.ceu.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.cjf = attentionHostData;
    }

    private void amB() {
        if (this.CM == null) {
            this.CM = new com.baidu.tbadk.core.dialog.a(this.ceu.getPageActivity());
            this.CM.hT(R.string.message_privacy_fans_can_reply);
            this.CM.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.amC();
                    aj.this.CM.dismiss();
                }
            });
            this.CM.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.CM.dismiss();
                }
            });
            this.CM.setAutoNight(true);
            this.CM.b(this.ceu);
        }
        this.CM.akM();
    }

    public void a(com.baidu.tbadk.core.data.bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(bbVar.title) && !StringUtils.isNull(bbVar.caa) && !StringUtils.isNull(bbVar.cab)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ceu.getPageActivity());
            aVar.nn(bbVar.title);
            aVar.a(bbVar.cab, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.amC();
                    aVar2.dismiss();
                }
            });
            aVar.b(bbVar.caa, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.ceu);
            aVar.akM();
            return;
        }
        amB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amC() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.ceu.showToast(R.string.network_ungeilivable);
        } else if (this.cjf != null && bc.checkUpIsLogin(this.ceu.getPageActivity())) {
            if (this.cje == null) {
                this.cje = new com.baidu.tbadk.coreExtra.model.a(this.ceu);
            }
            this.cje.a(true, this.cjf.portrait, this.cjf.uid, this.cjf.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.cjh = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.CM != null) {
            this.CM.dismiss();
        }
        if (this.cje != null) {
            this.cje.cancel();
        }
    }
}
