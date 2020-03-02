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
    public static int cZW = 0;
    public static int cZX = 1;
    public static int cZY = 2;
    public static int cZZ = 2;
    public static int daa = 3;
    private com.baidu.tbadk.core.dialog.a FR;
    private TbPageContext cVh;
    private com.baidu.tbadk.coreExtra.model.a dab;
    private AttentionHostData dac;
    private int dad;
    private a dae;
    private CustomMessageListener daf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.dac != null && !StringUtils.isNull(aj.this.dac.uid) && data != null && aj.this.dac.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(aj.this.cVh.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).aEH();
                        } else {
                            AntiHelper.a(aj.this.cVh.getPageActivity(), data.dnU);
                        }
                    }
                    if (data.isSucc) {
                        aj.this.dac.likeStatus = data.status;
                        aj.this.dac.isAttention = data.isAttention;
                    }
                    if (z && aj.this.dae != null) {
                        aj.this.dae.l(data.isSucc, aj.this.dad);
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
        this.cVh = tbPageContext;
        this.daf.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.daf);
    }

    public boolean ks(int i) {
        if (i == daa) {
            com.baidu.adp.lib.util.l.showToast(this.cVh.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean ax(int i, int i2) {
        this.dad = i2;
        if (i == cZZ) {
            if (this.dac == null || this.dac.isAttention) {
                return true;
            }
            aGs();
            return false;
        } else if (i == daa) {
            com.baidu.adp.lib.util.l.showToast(this.cVh.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.dac = attentionHostData;
    }

    private void aGs() {
        if (this.FR == null) {
            this.FR = new com.baidu.tbadk.core.dialog.a(this.cVh.getPageActivity());
            this.FR.jW(R.string.message_privacy_fans_can_reply);
            this.FR.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.aGt();
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
            this.FR.b(this.cVh);
        }
        this.FR.aEC();
    }

    public void a(bd bdVar) {
        if (bdVar != null && !StringUtils.isNull(bdVar.title) && !StringUtils.isNull(bdVar.cQF) && !StringUtils.isNull(bdVar.cQG)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVh.getPageActivity());
            aVar.sS(bdVar.title);
            aVar.a(bdVar.cQG, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.aGt();
                    aVar2.dismiss();
                }
            });
            aVar.b(bdVar.cQF, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.cVh);
            aVar.aEC();
            return;
        }
        aGs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGt() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.cVh.showToast(R.string.network_ungeilivable);
        } else if (this.dac != null && bc.checkUpIsLogin(this.cVh.getPageActivity())) {
            if (this.dab == null) {
                this.dab = new com.baidu.tbadk.coreExtra.model.a(this.cVh);
            }
            this.dab.a(true, this.dac.portrait, this.dac.uid, this.dac.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.dae = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.FR != null) {
            this.FR.dismiss();
        }
        if (this.dab != null) {
            this.dab.cancel();
        }
    }
}
