package com.baidu.tbadk.core.view.userLike;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private TbPageContext GO;
    private a aip;
    private b aiq;
    private BdUniqueId ait;
    private com.baidu.tbadk.c.a aiu;
    private String ais = "0";
    private CustomMessageListener aiv = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private com.baidu.tbadk.coreExtra.d.a air = new com.baidu.tbadk.coreExtra.d.a(null);

    public void setOnInterceptClickEventListener(com.baidu.tbadk.c.a aVar) {
        this.aiu = aVar;
    }

    public c(TbPageContext tbPageContext) {
        this.GO = tbPageContext;
        tbPageContext.registerListener(this.aiv);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.GO = tbPageContext;
        tbPageContext.registerListener(this.aiv);
        a(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ait = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.aiv);
            this.aiv.setTag(this.ait);
            MessageManager.getInstance().registerListener(this.aiv);
        }
    }

    public void a(b bVar) {
        this.aiq = bVar;
        if (this.aiq != null) {
            this.aiq.g(this);
        }
    }

    public void a(a aVar) {
        this.aip = aVar;
        if (this.aiq != null && this.aip != null) {
            this.aiq.aO(aVar.getIsLike());
            this.aiq.mo12do(aVar.getFansNum());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aiu == null || !this.aiu.w(view)) {
            if (!i.fZ()) {
                this.GO.showToast(r.j.network_ungeilivable);
            }
            if (this.aiq != null) {
                this.aiq.G(view);
            }
            if (bk.ak(this.GO.getPageActivity()) && this.aip != null) {
                if (this.ait == null) {
                    this.air.a(this.aip.getIsLike() ? false : true, this.aip.getPortrait(), this.aip.getUserId(), this.aip.isGod(), this.GO.getUniqueId());
                } else {
                    this.air.a(this.aip.getIsLike() ? false : true, this.aip.getPortrait(), this.aip.getUserId(), this.aip.isGod(), this.ait);
                }
            }
        }
    }
}
