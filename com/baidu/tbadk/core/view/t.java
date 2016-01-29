package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class t extends r {
    private boolean ahg;
    private boolean ahh;
    private CustomMessageListener ahi;
    private CustomMessageListener ahj;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.ahh = true;
        this.ahi = new u(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.ahj = new v(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.r, com.baidu.adp.widget.ListView.d
    public void P(boolean z) {
        this.ahb.setBackgroundDrawable(null);
        super.P(z);
        this.ahh = true;
    }

    @Override // com.baidu.tbadk.core.view.r, com.baidu.adp.widget.ListView.d
    public void O(boolean z) {
        super.O(z);
        this.ahh = false;
        if (!this.ahg) {
            dg(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.r, com.baidu.adp.widget.ListView.d
    public void nk() {
        super.nk();
        this.ahh = false;
    }

    public void dg(int i) {
        if (this.aha != null && this.ahb != null) {
            this.ahg = false;
            this.ahe = aj.vO().cH(i);
            if (this.ahe != null) {
                this.ahg = true;
            } else {
                this.ahe = new AnimationDrawable();
            }
            this.aha.setBackgroundColor(aj.vO().cJ(i));
            if (!this.ahg) {
                this.ahe = aj.vO().cI(i);
            }
            this.ahe.setOneShot(false);
            this.ahb.setBackgroundDrawable(this.ahe);
        }
    }

    @Override // com.baidu.tbadk.core.view.r, com.baidu.adp.widget.ListView.d
    public void Q(boolean z) {
        super.Q(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(t.e.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.ahi.setTag(tbPageContext.getUniqueId());
        this.ahj.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.ahi);
        tbPageContext.registerListener(this.ahj);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.ahi != null) {
            this.ahi.setTag(bdUniqueId);
        }
        if (this.ahj != null) {
            this.ahj.setTag(bdUniqueId);
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.ahi);
        MessageManager.getInstance().unRegisterListener(this.ahj);
    }
}
