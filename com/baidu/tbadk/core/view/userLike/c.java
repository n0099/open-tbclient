package com.baidu.tbadk.core.view.userLike;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private TbPageContext ajP;
    protected a anP;
    private b anQ;
    private BdUniqueId anT;
    private com.baidu.tbadk.d.a anU;
    private String anS = "0";
    private CustomMessageListener anV = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private com.baidu.tbadk.coreExtra.c.a anR = new com.baidu.tbadk.coreExtra.c.a(null);

    public c(TbPageContext tbPageContext) {
        this.ajP = tbPageContext;
        tbPageContext.registerListener(this.anV);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.ajP = tbPageContext;
        tbPageContext.registerListener(this.anV);
        a(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.anT = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.anV);
            this.anV.setTag(this.anT);
            MessageManager.getInstance().registerListener(this.anV);
        }
    }

    public void a(b bVar) {
        this.anQ = bVar;
        if (this.anQ != null) {
            this.anQ.g(this);
        }
    }

    public void a(a aVar) {
        this.anP = aVar;
        if (this.anQ != null && this.anP != null) {
            this.anQ.aP(aVar.getIsLike());
            this.anQ.dr(aVar.getFansNum());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.anU == null || !this.anU.s(view)) {
            if (!i.gX()) {
                this.ajP.showToast(w.l.network_ungeilivable);
            }
            if (this.anQ != null) {
                this.anQ.C(view);
            }
            if (bl.aN(this.ajP.getPageActivity()) && this.anP != null) {
                if (this.anT == null) {
                    this.anR.a(this.anP.getIsLike() ? false : true, this.anP.getPortrait(), this.anP.getUserId(), this.anP.isGod(), this.ajP.getUniqueId());
                } else {
                    this.anR.a(this.anP.getIsLike() ? false : true, this.anP.getPortrait(), this.anP.getUserId(), this.anP.isGod(), this.anT);
                }
            }
        }
    }
}
