package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class al {
    public static int fcU = 0;
    public static int fcV = 1;
    public static int fcW = 2;
    public static int fcX = 2;
    public static int fcY = 3;
    private com.baidu.tbadk.core.dialog.a adc;
    private TbPageContext eXu;
    private com.baidu.tbadk.coreExtra.model.a fcZ;
    private AttentionHostData fda;
    private int fdb;
    private a fdc;
    private CustomMessageListener fdd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.al.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (al.this.fda != null && !StringUtils.isNull(al.this.fda.uid) && data != null && al.this.fda.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(al.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(al.this.eXu.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).bud();
                        } else {
                            AntiHelper.a(al.this.eXu.getPageActivity(), data.fuV);
                        }
                    }
                    if (data.isSucc) {
                        al.this.fda.likeStatus = data.status;
                        al.this.fda.isAttention = data.isAttention;
                    }
                    if (z && al.this.fdc != null) {
                        al.this.fdc.q(data.isSucc, al.this.fdb);
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

    public al(TbPageContext tbPageContext) {
        this.eXu = tbPageContext;
        this.fdd.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.fdd);
    }

    public boolean pZ(int i) {
        if (i == fcY) {
            com.baidu.adp.lib.util.l.showToast(this.eXu.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean aN(int i, int i2) {
        this.fdb = i2;
        if (i == fcX) {
            if (this.fda == null || this.fda.isAttention) {
                return true;
            }
            bwe();
            return false;
        } else if (i == fcY) {
            com.baidu.adp.lib.util.l.showToast(this.eXu.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public boolean qa(int i) {
        if (i == fcX) {
            if (this.fda == null || this.fda.isAttention) {
                return true;
            }
            com.baidu.adp.lib.util.l.showToast(this.eXu.getPageActivity(), R.string.message_privacy_fans_can_reply);
            return false;
        } else if (i == fcY) {
            com.baidu.adp.lib.util.l.showToast(this.eXu.getPageActivity(), R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.fda = attentionHostData;
    }

    private void bwe() {
        if (this.adc == null) {
            this.adc = new com.baidu.tbadk.core.dialog.a(this.eXu.getPageActivity());
            this.adc.pa(R.string.message_privacy_fans_can_reply);
            this.adc.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.al.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    al.this.bwf();
                    al.this.adc.dismiss();
                }
            });
            this.adc.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.al.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    al.this.adc.dismiss();
                }
            });
            this.adc.setAutoNight(true);
            this.adc.b(this.eXu);
        }
        this.adc.btX();
    }

    public void a(bs bsVar) {
        if (bsVar != null && !StringUtils.isNull(bsVar.title) && !StringUtils.isNull(bsVar.eRZ) && !StringUtils.isNull(bsVar.eSa)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eXu.getPageActivity());
            aVar.Bp(bsVar.title);
            aVar.a(bsVar.eSa, new a.b() { // from class: com.baidu.tbadk.core.util.al.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    al.this.bwf();
                    aVar2.dismiss();
                }
            });
            aVar.b(bsVar.eRZ, new a.b() { // from class: com.baidu.tbadk.core.util.al.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.eXu);
            aVar.btX();
            return;
        }
        bwe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwf() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.eXu.showToast(R.string.network_ungeilivable);
        } else if (this.fda != null && bg.checkUpIsLogin(this.eXu.getPageActivity())) {
            if (this.fcZ == null) {
                this.fcZ = new com.baidu.tbadk.coreExtra.model.a(this.eXu);
            }
            this.fcZ.a(true, this.fda.portrait, this.fda.uid, this.fda.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.fdc = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.adc != null) {
            this.adc.dismiss();
        }
        if (this.fcZ != null) {
            this.fcZ.cancel();
        }
    }
}
