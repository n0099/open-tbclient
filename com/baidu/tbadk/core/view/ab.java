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
public class ab extends y {
    protected boolean agR;
    private CustomMessageListener agS;
    private CustomMessageListener agT;
    protected boolean isDone;

    public ab(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.agS = new ac(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.agT = new ad(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.y, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.agC.setBackgroundDrawable(null);
        super.S(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.y, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        super.R(z);
        this.isDone = false;
        if (!this.agR) {
            dh(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.y, com.baidu.adp.widget.ListView.d
    public void km() {
        super.km();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.y
    public void dh(int i) {
        super.dh(i);
        if (this.agB != null && this.agC != null) {
            this.agR = false;
            if (!vp()) {
                this.agG = com.baidu.tbadk.core.util.am.vh().cG(i);
                if (this.agG != null) {
                    this.agR = true;
                } else {
                    this.agG = new AnimationDrawable();
                }
                this.agB.setBackgroundColor(com.baidu.tbadk.core.util.am.vh().cI(i));
                if (!this.agR) {
                    this.agG = com.baidu.tbadk.core.util.am.vh().cH(i);
                }
                this.agG.setOneShot(false);
                this.agC.setBackgroundDrawable(this.agG);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.y, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        super.T(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(r.e.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.agS.setTag(tbPageContext.getUniqueId());
        this.agT.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.agS);
        tbPageContext.registerListener(this.agT);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.agS != null) {
            this.agS.setTag(bdUniqueId);
        }
        if (this.agT != null) {
            this.agT.setTag(bdUniqueId);
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.agS);
        MessageManager.getInstance().unRegisterListener(this.agT);
    }
}
