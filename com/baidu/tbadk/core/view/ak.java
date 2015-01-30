package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.widget.ListView.e {
    private boolean NU;
    private boolean NV;
    private CustomMessageListener NW;

    public ak(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.NV = true;
        this.NW = new al(this, 2016203);
        b(tbPageContext);
    }

    @Override // com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public void R(boolean z) {
        super.R(z);
        this.NV = true;
        this.wy.setBackgroundDrawable(null);
    }

    @Override // com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public void Q(boolean z) {
        super.Q(z);
        this.NV = false;
        if (!this.NU) {
            cs(TbadkCoreApplication.m255getInst().getSkinType());
        }
    }

    @Override // com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public void jA() {
        super.jA();
        this.NV = false;
    }

    @Override // com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public int jB() {
        return -getContext().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds46);
    }

    public void cs(int i) {
        if (this.wx != null && this.wy != null) {
            this.NU = false;
            this.wB = com.baidu.tbadk.core.util.av.pv().bZ(i);
            if (this.wB != null) {
                this.NU = true;
            } else {
                this.wB = new AnimationDrawable();
            }
            if (i == 1) {
                this.wx.setBackgroundColor(getContext().getResources().getColor(com.baidu.tieba.t.cp_bg_line_c_1));
                if (!this.NU) {
                    Drawable drawable = getContext().getResources().getDrawable(com.baidu.tieba.v.listview_pull_refresh02_1);
                    if (drawable != null) {
                        this.wB.addFrame(drawable, 100);
                    }
                    Drawable drawable2 = getContext().getResources().getDrawable(com.baidu.tieba.v.listview_pull_refresh01_1);
                    if (drawable2 != null) {
                        this.wB.addFrame(drawable2, 100);
                    }
                }
            } else {
                this.wx.setBackgroundColor(getContext().getResources().getColor(com.baidu.tieba.t.cp_bg_line_c));
                if (!this.NU) {
                    Drawable drawable3 = getContext().getResources().getDrawable(com.baidu.tieba.v.listview_pull_refresh02);
                    if (drawable3 != null) {
                        this.wB.addFrame(drawable3, 100);
                    }
                    Drawable drawable4 = getContext().getResources().getDrawable(com.baidu.tieba.v.listview_pull_refresh01);
                    if (drawable4 != null) {
                        this.wB.addFrame(drawable4, 100);
                    }
                }
            }
            this.wB.setOneShot(false);
            this.wy.setBackgroundDrawable(this.wB);
        }
    }

    private void b(TbPageContext<?> tbPageContext) {
        tbPageContext.registerListener(this.NW);
    }
}
