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
    private boolean afp;
    private boolean afq;
    private CustomMessageListener afr;
    private CustomMessageListener afs;

    public z(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.afq = true;
        this.afr = new aa(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.afs = new ab(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.x, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.afk.setBackgroundDrawable(null);
        super.S(z);
        this.afq = true;
    }

    @Override // com.baidu.tbadk.core.view.x, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        super.R(z);
        this.afq = false;
        if (!this.afp) {
            cM(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.x, com.baidu.adp.widget.ListView.d
    public void np() {
        super.np();
        this.afq = false;
    }

    public void cM(int i) {
        if (this.afj != null && this.afk != null) {
            this.afp = false;
            this.afn = com.baidu.tbadk.core.util.ae.uv().cn(i);
            if (this.afn != null) {
                this.afp = true;
            } else {
                this.afn = new AnimationDrawable();
            }
            this.afj.setBackgroundColor(com.baidu.tbadk.core.util.ae.uv().cp(i));
            if (!this.afp) {
                this.afn = com.baidu.tbadk.core.util.ae.uv().co(i);
            }
            this.afn.setOneShot(false);
            this.afk.setBackgroundDrawable(this.afn);
        }
    }

    @Override // com.baidu.tbadk.core.view.x, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        super.T(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(i.d.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.afr.setTag(tbPageContext.getUniqueId());
        this.afs.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.afr);
        tbPageContext.registerListener(this.afs);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.afr != null) {
            this.afr.setTag(bdUniqueId);
        }
        if (this.afs != null) {
            this.afs.setTag(bdUniqueId);
        }
    }
}
