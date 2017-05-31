package com.baidu.tbadk.core.view.userLike;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    private TbPageContext ajh;
    protected a amP;
    private b amQ;
    private BdUniqueId amT;
    private com.baidu.tbadk.d.a amU;
    private String amS = "0";
    private CustomMessageListener amV = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private com.baidu.tbadk.coreExtra.c.a amR = new com.baidu.tbadk.coreExtra.c.a(null);

    public c(TbPageContext tbPageContext) {
        this.ajh = tbPageContext;
        tbPageContext.registerListener(this.amV);
    }

    public c(TbPageContext tbPageContext, b bVar) {
        this.ajh = tbPageContext;
        tbPageContext.registerListener(this.amV);
        a(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.amT = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(this.amV);
            this.amV.setTag(this.amT);
            MessageManager.getInstance().registerListener(this.amV);
        }
    }

    public void a(b bVar) {
        this.amQ = bVar;
        if (this.amQ != null) {
            this.amQ.g(this);
        }
    }

    public void a(a aVar) {
        this.amP = aVar;
        if (this.amQ != null && this.amP != null) {
            this.amQ.aO(aVar.getIsLike());
            this.amQ.dp(aVar.getFansNum());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.amU == null || !this.amU.s(view)) {
            if (!i.gY()) {
                this.ajh.showToast(w.l.network_ungeilivable);
            }
            if (this.amQ != null) {
                this.amQ.B(view);
            }
            if (bh.aN(this.ajh.getPageActivity()) && this.amP != null) {
                if (this.amT == null) {
                    this.amR.a(this.amP.getIsLike() ? false : true, this.amP.getPortrait(), this.amP.getUserId(), this.amP.isGod(), this.ajh.getUniqueId());
                } else {
                    this.amR.a(this.amP.getIsLike() ? false : true, this.amP.getPortrait(), this.amP.getUserId(), this.amP.isGod(), this.amT);
                }
            }
        }
    }
}
