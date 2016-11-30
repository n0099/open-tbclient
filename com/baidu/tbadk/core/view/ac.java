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
    protected boolean ahr;
    private CustomMessageListener ahs;
    private CustomMessageListener aht;
    protected boolean isDone;

    public ac(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.ahs = new ad(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.aht = new ae(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.z, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.ahc.setBackgroundDrawable(null);
        super.S(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.z, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        super.R(z);
        this.isDone = false;
        if (!this.ahr) {
            di(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.z, com.baidu.adp.widget.ListView.d
    public void km() {
        super.km();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.z
    public void di(int i) {
        super.di(i);
        if (this.ahb != null && this.ahc != null) {
            this.ahr = false;
            if (!vt()) {
                this.ahg = com.baidu.tbadk.core.util.ak.vl().cH(i);
                if (this.ahg != null) {
                    this.ahr = true;
                } else {
                    this.ahg = new AnimationDrawable();
                }
                this.ahb.setBackgroundColor(com.baidu.tbadk.core.util.ak.vl().cJ(i));
                if (!this.ahr) {
                    this.ahg = com.baidu.tbadk.core.util.ak.vl().cI(i);
                }
                this.ahg.setOneShot(false);
                this.ahc.setBackgroundDrawable(this.ahg);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.z, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        super.T(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(r.e.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.ahs.setTag(tbPageContext.getUniqueId());
        this.aht.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.ahs);
        tbPageContext.registerListener(this.aht);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.ahs != null) {
            this.ahs.setTag(bdUniqueId);
        }
        if (this.aht != null) {
            this.aht.setTag(bdUniqueId);
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.ahs);
        MessageManager.getInstance().unRegisterListener(this.aht);
    }
}
