package com.baidu.tbadk.core.view.userLike;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private TbPageContext GO;
    private a ahQ;
    private b ahR;
    private BdUniqueId ahU;
    private com.baidu.tbadk.c.a ahV;
    private String ahT = "0";
    private CustomMessageListener ahW = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private com.baidu.tbadk.coreExtra.d.a ahS = new com.baidu.tbadk.coreExtra.d.a(null);

    public void setOnInterceptClickEventListener(com.baidu.tbadk.c.a aVar) {
        this.ahV = aVar;
    }

    public c(TbPageContext tbPageContext) {
        this.GO = tbPageContext;
        tbPageContext.registerListener(this.ahW);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.GO = tbPageContext;
        tbPageContext.registerListener(this.ahW);
        a(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ahU = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.ahW);
            this.ahW.setTag(this.ahU);
            MessageManager.getInstance().registerListener(this.ahW);
        }
    }

    public void a(b bVar) {
        this.ahR = bVar;
        if (this.ahR != null) {
            this.ahR.g(this);
        }
    }

    public void a(a aVar) {
        this.ahQ = aVar;
        if (this.ahR != null && this.ahQ != null) {
            this.ahR.aP(aVar.getIsLike());
            this.ahR.dq(aVar.getFansNum());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahV == null || !this.ahV.w(view)) {
            if (!i.fZ()) {
                this.GO.showToast(r.j.network_ungeilivable);
            }
            if (this.ahR != null) {
                this.ahR.G(view);
            }
            if (bh.ai(this.GO.getPageActivity()) && this.ahQ != null) {
                if (this.ahU == null) {
                    this.ahS.a(this.ahQ.getIsLike() ? false : true, this.ahQ.getPortrait(), this.ahQ.getUserId(), this.ahQ.isGod(), this.GO.getUniqueId());
                } else {
                    this.ahS.a(this.ahQ.getIsLike() ? false : true, this.ahQ.getPortrait(), this.ahQ.getUserId(), this.ahQ.isGod(), this.ahU);
                }
            }
        }
    }
}
