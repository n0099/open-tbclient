package com.baidu.tbadk.core.view.userLike;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private TbPageContext FY;
    protected a ahe;
    private b ahf;
    private BdUniqueId ahi;
    private com.baidu.tbadk.c.a ahj;
    private String ahh = "0";
    private CustomMessageListener ahk = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private com.baidu.tbadk.coreExtra.d.a ahg = new com.baidu.tbadk.coreExtra.d.a(null);

    public c(TbPageContext tbPageContext) {
        this.FY = tbPageContext;
        tbPageContext.registerListener(this.ahk);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.FY = tbPageContext;
        tbPageContext.registerListener(this.ahk);
        a(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ahi = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.ahk);
            this.ahk.setTag(this.ahi);
            MessageManager.getInstance().registerListener(this.ahk);
        }
    }

    public void a(b bVar) {
        this.ahf = bVar;
        if (this.ahf != null) {
            this.ahf.g(this);
        }
    }

    public void a(a aVar) {
        this.ahe = aVar;
        if (this.ahf != null && this.ahe != null) {
            this.ahf.aP(aVar.getIsLike());
            this.ahf.dr(aVar.getFansNum());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahj == null || !this.ahj.u(view)) {
            if (!i.fX()) {
                this.FY.showToast(r.l.network_ungeilivable);
            }
            if (this.ahf != null) {
                this.ahf.E(view);
            }
            if (bf.ak(this.FY.getPageActivity()) && this.ahe != null) {
                if (this.ahi == null) {
                    this.ahg.a(this.ahe.getIsLike() ? false : true, this.ahe.getPortrait(), this.ahe.getUserId(), this.ahe.isGod(), this.FY.getUniqueId());
                } else {
                    this.ahg.a(this.ahe.getIsLike() ? false : true, this.ahe.getPortrait(), this.ahe.getUserId(), this.ahe.isGod(), this.ahi);
                }
            }
        }
    }
}
