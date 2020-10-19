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
    public static int ezb = 0;
    public static int ezc = 1;
    public static int ezd = 2;
    public static int eze = 2;
    public static int ezf = 3;
    private com.baidu.tbadk.core.dialog.a abm;
    private TbPageContext etO;
    private com.baidu.tbadk.coreExtra.model.a ezg;
    private AttentionHostData ezh;
    private int ezi;
    private a ezj;
    private CustomMessageListener ezk = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.am.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (am.this.ezh != null && !StringUtils.isNull(am.this.ezh.uid) && data != null && am.this.ezh.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(am.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(am.this.etO.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).bkP();
                        } else {
                            AntiHelper.a(am.this.etO.getPageActivity(), data.eQq);
                        }
                    }
                    if (data.isSucc) {
                        am.this.ezh.likeStatus = data.status;
                        am.this.ezh.isAttention = data.isAttention;
                    }
                    if (z && am.this.ezj != null) {
                        am.this.ezj.r(data.isSucc, am.this.ezi);
                    }
                }
            }
        }
    };
    private BdUniqueId mId = BdUniqueId.gen();

    /* loaded from: classes.dex */
    public interface a {
        void r(boolean z, int i);
    }

    public am(TbPageContext tbPageContext) {
        this.etO = tbPageContext;
        this.ezk.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.ezk);
    }

    public boolean oy(int i) {
        if (i == ezf) {
            com.baidu.adp.lib.util.l.showToast(this.etO.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean aM(int i, int i2) {
        this.ezi = i2;
        if (i == eze) {
            if (this.ezh == null || this.ezh.isAttention) {
                return true;
            }
            bmJ();
            return false;
        } else if (i == ezf) {
            com.baidu.adp.lib.util.l.showToast(this.etO.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public boolean oz(int i) {
        if (i == eze) {
            if (this.ezh == null || this.ezh.isAttention) {
                return true;
            }
            com.baidu.adp.lib.util.l.showToast(this.etO.getPageActivity(), R.string.message_privacy_fans_can_reply);
            return false;
        } else if (i == ezf) {
            com.baidu.adp.lib.util.l.showToast(this.etO.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.ezh = attentionHostData;
    }

    private void bmJ() {
        if (this.abm == null) {
            this.abm = new com.baidu.tbadk.core.dialog.a(this.etO.getPageActivity());
            this.abm.ob(R.string.message_privacy_fans_can_reply);
            this.abm.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.am.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.bmK();
                    am.this.abm.dismiss();
                }
            });
            this.abm.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.am.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    am.this.abm.dismiss();
                }
            });
            this.abm.setAutoNight(true);
            this.abm.b(this.etO);
        }
        this.abm.bkJ();
    }

    public void a(bp bpVar) {
        if (bpVar != null && !StringUtils.isNull(bpVar.title) && !StringUtils.isNull(bpVar.eoB) && !StringUtils.isNull(bpVar.eoC)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.etO.getPageActivity());
            aVar.AH(bpVar.title);
            aVar.a(bpVar.eoC, new a.b() { // from class: com.baidu.tbadk.core.util.am.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    am.this.bmK();
                    aVar2.dismiss();
                }
            });
            aVar.b(bpVar.eoB, new a.b() { // from class: com.baidu.tbadk.core.util.am.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.etO);
            aVar.bkJ();
            return;
        }
        bmJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmK() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.etO.showToast(R.string.network_ungeilivable);
        } else if (this.ezh != null && bg.checkUpIsLogin(this.etO.getPageActivity())) {
            if (this.ezg == null) {
                this.ezg = new com.baidu.tbadk.coreExtra.model.a(this.etO);
            }
            this.ezg.a(true, this.ezh.portrait, this.ezh.uid, this.ezh.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.ezj = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.abm != null) {
            this.abm.dismiss();
        }
        if (this.ezg != null) {
            this.ezg.cancel();
        }
    }
}
