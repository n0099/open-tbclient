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
public class ac extends z {
    protected boolean agK;
    private CustomMessageListener agL;
    private CustomMessageListener agM;
    protected boolean isDone;

    public ac(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.agL = new ad(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.agM = new ae(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.z, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.agv.setBackgroundDrawable(null);
        super.S(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.z, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        super.R(z);
        this.isDone = false;
        if (!this.agK) {
            dk(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.z, com.baidu.adp.widget.ListView.d
    public void km() {
        super.km();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.z
    public void dk(int i) {
        super.dk(i);
        if (this.agu != null && this.agv != null) {
            this.agK = false;
            if (!vd()) {
                this.agz = com.baidu.tbadk.core.util.aj.uV().cJ(i);
                if (this.agz != null) {
                    this.agK = true;
                } else {
                    this.agz = new AnimationDrawable();
                }
                this.agu.setBackgroundColor(com.baidu.tbadk.core.util.aj.uV().cL(i));
                if (!this.agK) {
                    this.agz = com.baidu.tbadk.core.util.aj.uV().cK(i);
                }
                this.agz.setOneShot(false);
                this.agv.setBackgroundDrawable(this.agz);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.z, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        super.T(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(r.e.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.agL.setTag(tbPageContext.getUniqueId());
        this.agM.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.agL);
        tbPageContext.registerListener(this.agM);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.agL != null) {
            this.agL.setTag(bdUniqueId);
        }
        if (this.agM != null) {
            this.agM.setTag(bdUniqueId);
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.agL);
        MessageManager.getInstance().unRegisterListener(this.agM);
    }
}
