package com.baidu.tbadk.core.view.userLike;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private TbPageContext ajU;
    protected a amO;
    private b amP;
    private BdUniqueId amS;
    private com.baidu.tbadk.d.a amT;
    private String amR = "0";
    private CustomMessageListener amU = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private com.baidu.tbadk.coreExtra.c.a amQ = new com.baidu.tbadk.coreExtra.c.a(null);

    public c(TbPageContext tbPageContext) {
        this.ajU = tbPageContext;
        tbPageContext.registerListener(this.amU);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.ajU = tbPageContext;
        tbPageContext.registerListener(this.amU);
        a(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.amS = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.amU);
            this.amU.setTag(this.amS);
            MessageManager.getInstance().registerListener(this.amU);
        }
    }

    public void a(b bVar) {
        this.amP = bVar;
        if (this.amP != null) {
            this.amP.g(this);
        }
    }

    public void a(a aVar) {
        this.amO = aVar;
        if (this.amP != null && this.amO != null) {
            this.amP.aQ(aVar.getIsLike());
            this.amP.dq(aVar.getFansNum());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.amT == null || !this.amT.s(view)) {
            if (!i.gY()) {
                this.ajU.showToast(w.l.network_ungeilivable);
            }
            if (this.amP != null) {
                this.amP.C(view);
            }
            if (bg.aK(this.ajU.getPageActivity()) && this.amO != null) {
                if (this.amS == null) {
                    this.amQ.a(this.amO.getIsLike() ? false : true, this.amO.getPortrait(), this.amO.getUserId(), this.amO.isGod(), this.ajU.getUniqueId());
                } else {
                    this.amQ.a(this.amO.getIsLike() ? false : true, this.amO.getPortrait(), this.amO.getUserId(), this.amO.isGod(), this.amS);
                }
            }
        }
    }
}
