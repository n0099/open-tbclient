package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class w extends t {
    protected boolean acS;
    private CustomMessageListener acT;
    private CustomMessageListener acU;
    protected boolean isDone;

    public w(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.acT = new x(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.acU = new y(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void O(boolean z) {
        this.acC.setBackgroundDrawable(null);
        super.O(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void N(boolean z) {
        super.N(z);
        this.isDone = false;
        if (!this.acS) {
            cT(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void js() {
        super.js();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.t
    public void cT(int i) {
        super.cT(i);
        if (this.acB != null && this.acC != null) {
            this.acS = false;
            if (!tV()) {
                this.acH = com.baidu.tbadk.core.util.am.tN().ct(i);
                if (this.acH != null) {
                    this.acS = true;
                } else {
                    this.acH = new AnimationDrawable();
                }
                this.acB.setBackgroundColor(com.baidu.tbadk.core.util.am.tN().cv(i));
                if (!this.acS) {
                    this.acH = com.baidu.tbadk.core.util.am.tN().cu(i);
                }
                this.acH.setOneShot(false);
                this.acC.setBackgroundDrawable(this.acH);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void P(boolean z) {
        super.P(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(u.e.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.acT.setTag(tbPageContext.getUniqueId());
        this.acU.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.acT);
        tbPageContext.registerListener(this.acU);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.acT != null) {
            this.acT.setTag(bdUniqueId);
        }
        if (this.acU != null) {
            this.acU.setTag(bdUniqueId);
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.acT);
        MessageManager.getInstance().unRegisterListener(this.acU);
    }
}
