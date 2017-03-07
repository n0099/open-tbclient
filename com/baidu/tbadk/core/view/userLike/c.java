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
    private TbPageContext ajF;
    protected a amA;
    private b amB;
    private BdUniqueId amE;
    private com.baidu.tbadk.c.a amF;
    private String amD = "0";
    private CustomMessageListener amG = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private com.baidu.tbadk.coreExtra.c.a amC = new com.baidu.tbadk.coreExtra.c.a(null);

    public c(TbPageContext tbPageContext) {
        this.ajF = tbPageContext;
        tbPageContext.registerListener(this.amG);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.ajF = tbPageContext;
        tbPageContext.registerListener(this.amG);
        a(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.amE = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.amG);
            this.amG.setTag(this.amE);
            MessageManager.getInstance().registerListener(this.amG);
        }
    }

    public void a(b bVar) {
        this.amB = bVar;
        if (this.amB != null) {
            this.amB.g(this);
        }
    }

    public void a(a aVar) {
        this.amA = aVar;
        if (this.amB != null && this.amA != null) {
            this.amB.aO(aVar.getIsLike());
            this.amB.dn(aVar.getFansNum());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.amF == null || !this.amF.s(view)) {
            if (!i.gS()) {
                this.ajF.showToast(w.l.network_ungeilivable);
            }
            if (this.amB != null) {
                this.amB.C(view);
            }
            if (bg.aI(this.ajF.getPageActivity()) && this.amA != null) {
                if (this.amE == null) {
                    this.amC.a(this.amA.getIsLike() ? false : true, this.amA.getPortrait(), this.amA.getUserId(), this.amA.isGod(), this.ajF.getUniqueId());
                } else {
                    this.amC.a(this.amA.getIsLike() ? false : true, this.amA.getPortrait(), this.amA.getUserId(), this.amA.isGod(), this.amE);
                }
            }
        }
    }
}
