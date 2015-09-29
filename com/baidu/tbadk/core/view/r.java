package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.af;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class r extends p {
    private boolean aeC;
    private boolean aeD;
    private CustomMessageListener aeE;
    private CustomMessageListener aeF;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.aeD = true;
        this.aeE = new s(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.aeF = new t(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.aex.setBackgroundDrawable(null);
        super.S(z);
        this.aeD = true;
    }

    @Override // com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        super.R(z);
        this.aeD = false;
        if (!this.aeC) {
            cN(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void nq() {
        super.nq();
        this.aeD = false;
    }

    public void cN(int i) {
        if (this.aew != null && this.aex != null) {
            this.aeC = false;
            this.aeA = af.ut().cp(i);
            if (this.aeA != null) {
                this.aeC = true;
            } else {
                this.aeA = new AnimationDrawable();
            }
            this.aew.setBackgroundColor(af.ut().cr(i));
            if (!this.aeC) {
                this.aeA = af.ut().cq(i);
            }
            this.aeA.setOneShot(false);
            this.aex.setBackgroundDrawable(this.aeA);
        }
    }

    @Override // com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        super.T(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(i.d.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.aeE.setTag(tbPageContext.getUniqueId());
        this.aeF.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.aeE);
        tbPageContext.registerListener(this.aeF);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.aeE != null) {
            this.aeE.setTag(bdUniqueId);
        }
        if (this.aeF != null) {
            this.aeF.setTag(bdUniqueId);
        }
    }
}
