package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ad extends aa {
    protected boolean afW;
    private CustomMessageListener afX;
    private CustomMessageListener afY;
    protected boolean isDone;

    public ad(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.afX = new ae(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.afY = new af(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.aa, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.afH.setBackgroundDrawable(null);
        super.S(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.aa, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        super.R(z);
        this.isDone = false;
        if (!this.afW) {
            dl(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.aa, com.baidu.adp.widget.ListView.d
    public void ki() {
        super.ki();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.aa
    public void dl(int i) {
        super.dl(i);
        if (this.afG != null && this.afH != null) {
            this.afW = false;
            if (!uX()) {
                this.afL = com.baidu.tbadk.core.util.ah.uP().cI(i);
                if (this.afL != null) {
                    this.afW = true;
                } else {
                    this.afL = new AnimationDrawable();
                }
                this.afG.setBackgroundColor(com.baidu.tbadk.core.util.ah.uP().cK(i));
                if (!this.afW) {
                    this.afL = com.baidu.tbadk.core.util.ah.uP().cJ(i);
                }
                this.afL.setOneShot(false);
                this.afH.setBackgroundDrawable(this.afL);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.aa, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        super.T(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(r.f.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.afX.setTag(tbPageContext.getUniqueId());
        this.afY.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.afX);
        tbPageContext.registerListener(this.afY);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.afX != null) {
            this.afX.setTag(bdUniqueId);
        }
        if (this.afY != null) {
            this.afY.setTag(bdUniqueId);
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.afX);
        MessageManager.getInstance().unRegisterListener(this.afY);
    }
}
