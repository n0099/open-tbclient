package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class al extends ah {
    private boolean aae;
    private boolean aaf;
    private CustomMessageListener aag;
    private CustomMessageListener aah;

    public al(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.aaf = true;
        this.aag = new am(this, 2016203);
        this.aah = new an(this, 2016204);
        c(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.ah, com.baidu.adp.widget.ListView.f
    public void R(boolean z) {
        this.ZZ.setBackgroundDrawable(null);
        super.R(z);
        this.aaf = true;
    }

    @Override // com.baidu.tbadk.core.view.ah, com.baidu.adp.widget.ListView.f
    public void Q(boolean z) {
        super.Q(z);
        this.aaf = false;
        if (!this.aae) {
            cy(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.ah, com.baidu.adp.widget.ListView.f
    public void ni() {
        super.ni();
        this.aaf = false;
    }

    public void cy(int i) {
        if (this.ZY != null && this.ZZ != null) {
            this.aae = false;
            this.aac = com.baidu.tbadk.core.util.aq.to().cd(i);
            if (this.aac != null) {
                this.aae = true;
            } else {
                this.aac = new AnimationDrawable();
            }
            this.ZY.setBackgroundColor(com.baidu.tbadk.core.util.aq.to().cf(i));
            if (!this.aae) {
                this.aac = com.baidu.tbadk.core.util.aq.to().ce(i);
            }
            this.aac.setOneShot(false);
            this.ZZ.setBackgroundDrawable(this.aac);
        }
    }

    @Override // com.baidu.tbadk.core.view.ah, com.baidu.adp.widget.ListView.f
    public void S(boolean z) {
        super.S(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds46), 0, 0);
    }

    private void c(TbPageContext<?> tbPageContext) {
        this.aag.setTag(tbPageContext.getUniqueId());
        this.aah.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.aag);
        tbPageContext.registerListener(this.aah);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.aag != null) {
            this.aag.setTag(bdUniqueId);
        }
        if (this.aah != null) {
            this.aah.setTag(bdUniqueId);
        }
    }
}
