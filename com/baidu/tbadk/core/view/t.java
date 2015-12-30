package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class t extends r {
    private boolean ags;
    private boolean agt;
    private CustomMessageListener agu;
    private CustomMessageListener agv;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.agt = true;
        this.agu = new u(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.agv = new v(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.r, com.baidu.adp.widget.ListView.d
    public void P(boolean z) {
        this.agn.setBackgroundDrawable(null);
        super.P(z);
        this.agt = true;
    }

    @Override // com.baidu.tbadk.core.view.r, com.baidu.adp.widget.ListView.d
    public void O(boolean z) {
        super.O(z);
        this.agt = false;
        if (!this.ags) {
            cP(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.r, com.baidu.adp.widget.ListView.d
    public void mV() {
        super.mV();
        this.agt = false;
    }

    public void cP(int i) {
        if (this.agm != null && this.agn != null) {
            this.ags = false;
            this.agq = ak.uJ().cq(i);
            if (this.agq != null) {
                this.ags = true;
            } else {
                this.agq = new AnimationDrawable();
            }
            this.agm.setBackgroundColor(ak.uJ().cs(i));
            if (!this.ags) {
                this.agq = ak.uJ().cr(i);
            }
            this.agq.setOneShot(false);
            this.agn.setBackgroundDrawable(this.agq);
        }
    }

    @Override // com.baidu.tbadk.core.view.r, com.baidu.adp.widget.ListView.d
    public void Q(boolean z) {
        super.Q(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(n.e.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.agu.setTag(tbPageContext.getUniqueId());
        this.agv.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.agu);
        tbPageContext.registerListener(this.agv);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.agu != null) {
            this.agu.setTag(bdUniqueId);
        }
        if (this.agv != null) {
            this.agv.setTag(bdUniqueId);
        }
    }
}
