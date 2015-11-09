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
    private boolean aeI;
    private boolean aeJ;
    private CustomMessageListener aeK;
    private CustomMessageListener aeL;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.aeJ = true;
        this.aeK = new s(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.aeL = new t(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.aeD.setBackgroundDrawable(null);
        super.S(z);
        this.aeJ = true;
    }

    @Override // com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        super.R(z);
        this.aeJ = false;
        if (!this.aeI) {
            cN(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void nr() {
        super.nr();
        this.aeJ = false;
    }

    public void cN(int i) {
        if (this.aeC != null && this.aeD != null) {
            this.aeI = false;
            this.aeG = af.ut().cp(i);
            if (this.aeG != null) {
                this.aeI = true;
            } else {
                this.aeG = new AnimationDrawable();
            }
            this.aeC.setBackgroundColor(af.ut().cr(i));
            if (!this.aeI) {
                this.aeG = af.ut().cq(i);
            }
            this.aeG.setOneShot(false);
            this.aeD.setBackgroundDrawable(this.aeG);
        }
    }

    @Override // com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        super.T(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(i.d.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.aeK.setTag(tbPageContext.getUniqueId());
        this.aeL.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.aeK);
        tbPageContext.registerListener(this.aeL);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.aeK != null) {
            this.aeK.setTag(bdUniqueId);
        }
        if (this.aeL != null) {
            this.aeL.setTag(bdUniqueId);
        }
    }
}
