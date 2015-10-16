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
    private boolean aeD;
    private boolean aeE;
    private CustomMessageListener aeF;
    private CustomMessageListener aeG;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.aeE = true;
        this.aeF = new s(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.aeG = new t(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.aey.setBackgroundDrawable(null);
        super.S(z);
        this.aeE = true;
    }

    @Override // com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        super.R(z);
        this.aeE = false;
        if (!this.aeD) {
            cN(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void nq() {
        super.nq();
        this.aeE = false;
    }

    public void cN(int i) {
        if (this.aex != null && this.aey != null) {
            this.aeD = false;
            this.aeB = af.ut().cp(i);
            if (this.aeB != null) {
                this.aeD = true;
            } else {
                this.aeB = new AnimationDrawable();
            }
            this.aex.setBackgroundColor(af.ut().cr(i));
            if (!this.aeD) {
                this.aeB = af.ut().cq(i);
            }
            this.aeB.setOneShot(false);
            this.aey.setBackgroundDrawable(this.aeB);
        }
    }

    @Override // com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        super.T(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(i.d.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.aeF.setTag(tbPageContext.getUniqueId());
        this.aeG.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.aeF);
        tbPageContext.registerListener(this.aeG);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.aeF != null) {
            this.aeF.setTag(bdUniqueId);
        }
        if (this.aeG != null) {
            this.aeG.setTag(bdUniqueId);
        }
    }
}
