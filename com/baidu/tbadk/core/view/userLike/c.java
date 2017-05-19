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
    private TbPageContext ajr;
    protected a amT;
    private b amU;
    private BdUniqueId amX;
    private com.baidu.tbadk.d.a amY;
    private String amW = "0";
    private CustomMessageListener amZ = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private com.baidu.tbadk.coreExtra.c.a amV = new com.baidu.tbadk.coreExtra.c.a(null);

    public c(TbPageContext tbPageContext) {
        this.ajr = tbPageContext;
        tbPageContext.registerListener(this.amZ);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.ajr = tbPageContext;
        tbPageContext.registerListener(this.amZ);
        a(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.amX = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.amZ);
            this.amZ.setTag(this.amX);
            MessageManager.getInstance().registerListener(this.amZ);
        }
    }

    public void a(b bVar) {
        this.amU = bVar;
        if (this.amU != null) {
            this.amU.g(this);
        }
    }

    public void a(a aVar) {
        this.amT = aVar;
        if (this.amU != null && this.amT != null) {
            this.amU.aQ(aVar.getIsLike());
            this.amU.mo12do(aVar.getFansNum());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.amY == null || !this.amY.s(view)) {
            if (!i.gY()) {
                this.ajr.showToast(w.l.network_ungeilivable);
            }
            if (this.amU != null) {
                this.amU.B(view);
            }
            if (bg.aN(this.ajr.getPageActivity()) && this.amT != null) {
                if (this.amX == null) {
                    this.amV.a(this.amT.getIsLike() ? false : true, this.amT.getPortrait(), this.amT.getUserId(), this.amT.isGod(), this.ajr.getUniqueId());
                } else {
                    this.amV.a(this.amT.getIsLike() ? false : true, this.amT.getPortrait(), this.amT.getUserId(), this.amT.isGod(), this.amX);
                }
            }
        }
    }
}
