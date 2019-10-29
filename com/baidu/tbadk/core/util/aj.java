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
    public static int cjQ = 0;
    public static int cjR = 1;
    public static int cjS = 2;
    public static int cjT = 2;
    public static int cjU = 3;
    private com.baidu.tbadk.core.dialog.a Do;
    private TbPageContext cfl;
    private com.baidu.tbadk.coreExtra.model.a cjV;
    private AttentionHostData cjW;
    private int cjX;
    private a cjY;
    private CustomMessageListener cjZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.cjW != null && !StringUtils.isNull(aj.this.cjW.uid) && data != null && aj.this.cjW.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(aj.this.cfl.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake_n_svg, 3000, false).akT();
                        } else {
                            AntiHelper.a(aj.this.cfl.getPageActivity(), data.cwD);
                        }
                    }
                    if (data.isSucc) {
                        aj.this.cjW.likeStatus = data.status;
                        aj.this.cjW.isAttention = data.isAttention;
                    }
                    if (z && aj.this.cjY != null) {
                        aj.this.cjY.f(data.isSucc, aj.this.cjX);
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
        this.cfl = tbPageContext;
        this.cjZ.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.cjZ);
    }

    public boolean iq(int i) {
        if (i == cjU) {
            com.baidu.adp.lib.util.l.showToast(this.cfl.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean aa(int i, int i2) {
        this.cjX = i2;
        if (i == cjT) {
            if (this.cjW == null || this.cjW.isAttention) {
                return true;
            }
            amD();
            return false;
        } else if (i == cjU) {
            com.baidu.adp.lib.util.l.showToast(this.cfl.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.cjW = attentionHostData;
    }

    private void amD() {
        if (this.Do == null) {
            this.Do = new com.baidu.tbadk.core.dialog.a(this.cfl.getPageActivity());
            this.Do.hU(R.string.message_privacy_fans_can_reply);
            this.Do.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.amE();
                    aj.this.Do.dismiss();
                }
            });
            this.Do.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.aj.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.Do.dismiss();
                }
            });
            this.Do.setAutoNight(true);
            this.Do.b(this.cfl);
        }
        this.Do.akO();
    }

    public void a(com.baidu.tbadk.core.data.bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(bbVar.title) && !StringUtils.isNull(bbVar.caR) && !StringUtils.isNull(bbVar.caS)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cfl.getPageActivity());
            aVar.nn(bbVar.title);
            aVar.a(bbVar.caS, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.amE();
                    aVar2.dismiss();
                }
            });
            aVar.b(bbVar.caR, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.cfl);
            aVar.akO();
            return;
        }
        amD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amE() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.cfl.showToast(R.string.network_ungeilivable);
        } else if (this.cjW != null && bc.checkUpIsLogin(this.cfl.getPageActivity())) {
            if (this.cjV == null) {
                this.cjV = new com.baidu.tbadk.coreExtra.model.a(this.cfl);
            }
            this.cjV.a(true, this.cjW.portrait, this.cjW.uid, this.cjW.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.cjY = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.Do != null) {
            this.Do.dismiss();
        }
        if (this.cjV != null) {
            this.cjV.cancel();
        }
    }
}
