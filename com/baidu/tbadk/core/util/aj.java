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
    public static int dak = 0;
    public static int dal = 1;
    public static int dam = 2;
    public static int dan = 2;
    public static int dao = 3;
    private com.baidu.tbadk.core.dialog.a FR;
    private TbPageContext cVv;
    private com.baidu.tbadk.coreExtra.model.a dap;
    private AttentionHostData daq;
    private int dar;
    private a das;
    private CustomMessageListener dat = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tbadk.core.util.aj.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (aj.this.daq != null && !StringUtils.isNull(aj.this.daq.uid) && data != null && aj.this.daq.uid.equals(data.toUid)) {
                    if (updateAttentionMessage.getOrginalMessage() == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(aj.this.mId)) {
                        z = false;
                    } else {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.a(aj.this.cVv.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).aEL();
                        } else {
                            AntiHelper.a(aj.this.cVv.getPageActivity(), data.dow);
                        }
                    }
                    if (data.isSucc) {
                        aj.this.daq.likeStatus = data.status;
                        aj.this.daq.isAttention = data.isAttention;
                    }
                    if (z && aj.this.das != null) {
                        aj.this.das.l(data.isSucc, aj.this.dar);
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
        this.cVv = tbPageContext;
        this.dat.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.dat);
    }

    public boolean ks(int i) {
        if (i == dao) {
            com.baidu.adp.lib.util.l.showToast(this.cVv.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        }
        return true;
    }

    public boolean ax(int i, int i2) {
        this.dar = i2;
        if (i == dan) {
            if (this.daq == null || this.daq.isAttention) {
                return true;
            }
            aGw();
            return false;
        } else if (i == dao) {
            com.baidu.adp.lib.util.l.showToast(this.cVv.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
            return false;
        } else {
            return true;
        }
    }

    public void a(AttentionHostData attentionHostData) {
        this.daq = attentionHostData;
    }

    private void aGw() {
        if (this.FR == null) {
            this.FR = new com.baidu.tbadk.core.dialog.a(this.cVv.getPageActivity());
            this.FR.jW(R.string.message_privacy_fans_can_reply);
            this.FR.a(R.string.attention_and_reply, new a.b() { // from class: com.baidu.tbadk.core.util.aj.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aj.this.aGx();
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
            this.FR.b(this.cVv);
        }
        this.FR.aEG();
    }

    public void a(bd bdVar) {
        if (bdVar != null && !StringUtils.isNull(bdVar.title) && !StringUtils.isNull(bdVar.cQT) && !StringUtils.isNull(bdVar.cQU)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVv.getPageActivity());
            aVar.sR(bdVar.title);
            aVar.a(bdVar.cQU, new a.b() { // from class: com.baidu.tbadk.core.util.aj.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aj.this.aGx();
                    aVar2.dismiss();
                }
            });
            aVar.b(bdVar.cQT, new a.b() { // from class: com.baidu.tbadk.core.util.aj.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.setAutoNight(true);
            aVar.b(this.cVv);
            aVar.aEG();
            return;
        }
        aGw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGx() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.cVv.showToast(R.string.network_ungeilivable);
        } else if (this.daq != null && bc.checkUpIsLogin(this.cVv.getPageActivity())) {
            if (this.dap == null) {
                this.dap = new com.baidu.tbadk.coreExtra.model.a(this.cVv);
            }
            this.dap.a(true, this.daq.portrait, this.daq.uid, this.daq.isGod, "0", this.mId, null, "0");
        }
    }

    public void a(a aVar) {
        this.das = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
        if (this.FR != null) {
            this.FR.dismiss();
        }
        if (this.dap != null) {
            this.dap.cancel();
        }
    }
}
