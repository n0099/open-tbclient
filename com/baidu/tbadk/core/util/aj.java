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
    public static int cZV = 0;
    public static int cZW = 1;
    public static int cZX = 2;
    public static int cZY = 2;
    public static int cZZ = 3;
    private com.baidu.tbadk.core.dialog.a FR;
    private TbPageContext cVg;
    private com.baidu.tbadk.coreExtra.model.a daa;
    private AttentionHostData dab;
    private int dac;
    private a dad;
    private CustomMessageListener dae = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.dab != null && !StringUtils.isNull(aj.this.dab.uid) && data != null && aj.this.dab.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(aj.this.cVg.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).aEF();
                        } else {
                            AntiHelper.a(aj.this.cVg.getPageActivity(), data.dnT);
                        }
                    }
                    if (data.isSucc) {
                        aj.this.dab.likeStatus = data.status;
                        aj.this.dab.isAttention = data.isAttention;
                    }
                    if (z && aj.this.dad != null) {
                        aj.this.dad.l(data.isSucc, aj.this.dac);
                    }
                }
            }
        }
    };
    private BdUniqueId mId = BdUniqueId.gen();

    /* loaded from: classes.dex */
    public interface a {
        void l(boolean z, int i);
    }

    public aj(TbPageContext tbPageContext) {
        this.cVg = tbPageContext;
        this.dae.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.dae);
    }

    public boolean ks(int i) {
        if (i == cZZ) {
            com.baidu.adp.lib.util.l.showToast(this.cVg.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean ax(int i, int i2) {
        this.dac = i2;
        if (i == cZY) {
            if (this.dab == null || this.dab.isAttention) {
                return true;
            }
            aGq();
            return false;
        } else if (i == cZZ) {
            com.baidu.adp.lib.util.l.showToast(this.cVg.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.dab = attentionHostData;
    }

    private void aGq() {
        if (this.FR == null) {
            this.FR = new com.baidu.tbadk.core.dialog.a(this.cVg.getPageActivity());
            this.FR.jW(R.string.message_privacy_fans_can_reply);
            this.FR.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.aGr();
                    aj.this.FR.dismiss();
                }
            });
            this.FR.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.FR.dismiss();
                }
            });
            this.FR.setAutoNight(true);
            this.FR.b(this.cVg);
        }
        this.FR.aEA();
    }

    public void a(bd bdVar) {
        if (bdVar != null && !StringUtils.isNull(bdVar.title) && !StringUtils.isNull(bdVar.cQE) && !StringUtils.isNull(bdVar.cQF)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVg.getPageActivity());
            aVar.sS(bdVar.title);
            aVar.a(bdVar.cQF, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.aGr();
                    aVar2.dismiss();
                }
            });
            aVar.b(bdVar.cQE, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.cVg);
            aVar.aEA();
            return;
        }
        aGq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGr() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.cVg.showToast(R.string.network_ungeilivable);
        } else if (this.dab != null && bc.checkUpIsLogin(this.cVg.getPageActivity())) {
            if (this.daa == null) {
                this.daa = new com.baidu.tbadk.coreExtra.model.a(this.cVg);
            }
            this.daa.a(true, this.dab.portrait, this.dab.uid, this.dab.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.dad = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.FR != null) {
            this.FR.dismiss();
        }
        if (this.daa != null) {
            this.daa.cancel();
        }
    }
}
