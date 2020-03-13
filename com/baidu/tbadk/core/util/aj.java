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
    public static int cZX = 0;
    public static int cZY = 1;
    public static int cZZ = 2;
    public static int daa = 2;
    public static int dab = 3;
    private com.baidu.tbadk.core.dialog.a FR;
    private TbPageContext cVi;
    private com.baidu.tbadk.coreExtra.model.a dac;
    private AttentionHostData dad;
    private int dae;
    private a daf;
    private CustomMessageListener dag = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.dad != null && !StringUtils.isNull(aj.this.dad.uid) && data != null && aj.this.dad.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(aj.this.cVi.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).aEH();
                        } else {
                            AntiHelper.a(aj.this.cVi.getPageActivity(), data.doi);
                        }
                    }
                    if (data.isSucc) {
                        aj.this.dad.likeStatus = data.status;
                        aj.this.dad.isAttention = data.isAttention;
                    }
                    if (z && aj.this.daf != null) {
                        aj.this.daf.l(data.isSucc, aj.this.dae);
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
        this.cVi = tbPageContext;
        this.dag.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.dag);
    }

    public boolean ks(int i) {
        if (i == dab) {
            com.baidu.adp.lib.util.l.showToast(this.cVi.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean ax(int i, int i2) {
        this.dae = i2;
        if (i == daa) {
            if (this.dad == null || this.dad.isAttention) {
                return true;
            }
            aGs();
            return false;
        } else if (i == dab) {
            com.baidu.adp.lib.util.l.showToast(this.cVi.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.dad = attentionHostData;
    }

    private void aGs() {
        if (this.FR == null) {
            this.FR = new com.baidu.tbadk.core.dialog.a(this.cVi.getPageActivity());
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
            this.FR.b(this.cVi);
        }
        this.FR.aEC();
    }

    public void a(bd bdVar) {
        if (bdVar != null && !StringUtils.isNull(bdVar.title) && !StringUtils.isNull(bdVar.cQG) && !StringUtils.isNull(bdVar.cQH)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVi.getPageActivity());
            aVar.sS(bdVar.title);
            aVar.a(bdVar.cQH, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.aGt();
                    aVar2.dismiss();
                }
            });
            aVar.b(bdVar.cQG, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.cVi);
            aVar.aEC();
            return;
        }
        aGs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGt() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.cVi.showToast(R.string.network_ungeilivable);
        } else if (this.dad != null && bc.checkUpIsLogin(this.cVi.getPageActivity())) {
            if (this.dac == null) {
                this.dac = new com.baidu.tbadk.coreExtra.model.a(this.cVi);
            }
            this.dac.a(true, this.dad.portrait, this.dad.uid, this.dad.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.daf = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.FR != null) {
            this.FR.dismiss();
        }
        if (this.dac != null) {
            this.dac.cancel();
        }
    }
}
