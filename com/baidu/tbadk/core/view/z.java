package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class z extends x {
    private boolean aff;
    private boolean afg;
    private CustomMessageListener afh;
    private CustomMessageListener afi;

    public z(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.afg = true;
        this.afh = new aa(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.afi = new ab(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.x, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.afa.setBackgroundDrawable(null);
        super.S(z);
        this.afg = true;
    }

    @Override // com.baidu.tbadk.core.view.x, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        super.R(z);
        this.afg = false;
        if (!this.aff) {
            cG(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.x, com.baidu.adp.widget.ListView.d
    public void ns() {
        super.ns();
        this.afg = false;
    }

    public void cG(int i) {
        if (this.aeZ != null && this.afa != null) {
            this.aff = false;
            this.afd = com.baidu.tbadk.core.util.ae.uq().cj(i);
            if (this.afd != null) {
                this.aff = true;
            } else {
                this.afd = new AnimationDrawable();
            }
            this.aeZ.setBackgroundColor(com.baidu.tbadk.core.util.ae.uq().cl(i));
            if (!this.aff) {
                this.afd = com.baidu.tbadk.core.util.ae.uq().ck(i);
            }
            this.afd.setOneShot(false);
            this.afa.setBackgroundDrawable(this.afd);
        }
    }

    @Override // com.baidu.tbadk.core.view.x, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        super.T(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(i.d.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.afh.setTag(tbPageContext.getUniqueId());
        this.afi.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.afh);
        tbPageContext.registerListener(this.afi);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.afh != null) {
            this.afh.setTag(bdUniqueId);
        }
        if (this.afi != null) {
            this.afi.setTag(bdUniqueId);
        }
    }
}
