package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class w extends t {
    protected boolean ags;
    private CustomMessageListener agt;
    private CustomMessageListener agu;
    protected boolean isDone;

    public w(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.agt = new x(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.agu = new y(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.agc.setBackgroundDrawable(null);
        super.S(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        super.R(z);
        this.isDone = false;
        if (!this.ags) {
            dh(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void km() {
        super.km();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.t
    public void dh(int i) {
        super.dh(i);
        if (this.agb != null && this.agc != null) {
            this.ags = false;
            if (!va()) {
                this.agh = com.baidu.tbadk.core.util.am.uS().cG(i);
                if (this.agh != null) {
                    this.ags = true;
                } else {
                    this.agh = new AnimationDrawable();
                }
                this.agb.setBackgroundColor(com.baidu.tbadk.core.util.am.uS().cI(i));
                if (!this.ags) {
                    this.agh = com.baidu.tbadk.core.util.am.uS().cH(i);
                }
                this.agh.setOneShot(false);
                this.agc.setBackgroundDrawable(this.agh);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        super.T(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(t.e.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.agt.setTag(tbPageContext.getUniqueId());
        this.agu.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.agt);
        tbPageContext.registerListener(this.agu);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.agt != null) {
            this.agt.setTag(bdUniqueId);
        }
        if (this.agu != null) {
            this.agu.setTag(bdUniqueId);
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.agt);
        MessageManager.getInstance().unRegisterListener(this.agu);
    }
}
