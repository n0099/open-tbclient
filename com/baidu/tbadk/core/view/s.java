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
public class s extends q {
    private boolean afF;
    private boolean afG;
    private CustomMessageListener afH;
    private CustomMessageListener afI;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.afG = true;
        this.afH = new t(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.afI = new u(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.q, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.afA.setBackgroundDrawable(null);
        super.S(z);
        this.afG = true;
    }

    @Override // com.baidu.tbadk.core.view.q, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        super.R(z);
        this.afG = false;
        if (!this.afF) {
            cV(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.q, com.baidu.adp.widget.ListView.d
    public void nx() {
        super.nx();
        this.afG = false;
    }

    public void cV(int i) {
        if (this.afz != null && this.afA != null) {
            this.afF = false;
            this.afD = ak.uZ().cx(i);
            if (this.afD != null) {
                this.afF = true;
            } else {
                this.afD = new AnimationDrawable();
            }
            this.afz.setBackgroundColor(ak.uZ().cz(i));
            if (!this.afF) {
                this.afD = ak.uZ().cy(i);
            }
            this.afD.setOneShot(false);
            this.afA.setBackgroundDrawable(this.afD);
        }
    }

    @Override // com.baidu.tbadk.core.view.q, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        super.T(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(n.d.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.afH.setTag(tbPageContext.getUniqueId());
        this.afI.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.afH);
        tbPageContext.registerListener(this.afI);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.afH != null) {
            this.afH.setTag(bdUniqueId);
        }
        if (this.afI != null) {
            this.afI.setTag(bdUniqueId);
        }
    }
}
