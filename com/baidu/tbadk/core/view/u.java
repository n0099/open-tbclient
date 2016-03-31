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
public class u extends s {
    private boolean agH;
    private boolean agI;
    private CustomMessageListener agJ;
    private CustomMessageListener agK;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.agI = true;
        this.agJ = new v(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.agK = new w(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.s, com.baidu.adp.widget.ListView.d
    public void O(boolean z) {
        this.agC.setBackgroundDrawable(null);
        super.O(z);
        this.agI = true;
    }

    @Override // com.baidu.tbadk.core.view.s, com.baidu.adp.widget.ListView.d
    public void N(boolean z) {
        super.N(z);
        this.agI = false;
        if (!this.agH) {
            dj(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.s, com.baidu.adp.widget.ListView.d
    public void nb() {
        super.nb();
        this.agI = false;
    }

    public void dj(int i) {
        if (this.agB != null && this.agC != null) {
            this.agH = false;
            this.agF = com.baidu.tbadk.core.util.al.wh().cK(i);
            if (this.agF != null) {
                this.agH = true;
            } else {
                this.agF = new AnimationDrawable();
            }
            this.agB.setBackgroundColor(com.baidu.tbadk.core.util.al.wh().cM(i));
            if (!this.agH) {
                this.agF = com.baidu.tbadk.core.util.al.wh().cL(i);
            }
            this.agF.setOneShot(false);
            this.agC.setBackgroundDrawable(this.agF);
        }
    }

    @Override // com.baidu.tbadk.core.view.s, com.baidu.adp.widget.ListView.d
    public void P(boolean z) {
        super.P(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(t.e.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.agJ.setTag(tbPageContext.getUniqueId());
        this.agK.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.agJ);
        tbPageContext.registerListener(this.agK);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.agJ != null) {
            this.agJ.setTag(bdUniqueId);
        }
        if (this.agK != null) {
            this.agK.setTag(bdUniqueId);
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.agJ);
        MessageManager.getInstance().unRegisterListener(this.agK);
    }
}
