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
    protected boolean acx;
    private CustomMessageListener acy;
    private CustomMessageListener acz;
    protected boolean isDone;

    public w(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.acy = new x(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.acz = new y(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void O(boolean z) {
        this.aci.setBackgroundDrawable(null);
        super.O(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void N(boolean z) {
        super.N(z);
        this.isDone = false;
        if (!this.acx) {
            cR(TbadkCoreApplication.m11getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void jp() {
        super.jp();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.t
    public void cR(int i) {
        super.cR(i);
        if (this.ach != null && this.aci != null) {
            this.acx = false;
            this.acm = com.baidu.tbadk.core.util.al.tO().cs(i);
            if (this.acm != null) {
                this.acx = true;
            } else {
                this.acm = new AnimationDrawable();
            }
            this.ach.setBackgroundColor(com.baidu.tbadk.core.util.al.tO().cu(i));
            if (!this.acx) {
                this.acm = com.baidu.tbadk.core.util.al.tO().ct(i);
            }
            this.acm.setOneShot(false);
            this.aci.setBackgroundDrawable(this.acm);
        }
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void P(boolean z) {
        super.P(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(t.e.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.acy.setTag(tbPageContext.getUniqueId());
        this.acz.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.acy);
        tbPageContext.registerListener(this.acz);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.acy != null) {
            this.acy.setTag(bdUniqueId);
        }
        if (this.acz != null) {
            this.acz.setTag(bdUniqueId);
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.acy);
        MessageManager.getInstance().unRegisterListener(this.acz);
    }
}
