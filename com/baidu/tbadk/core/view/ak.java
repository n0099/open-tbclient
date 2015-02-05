package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.widget.ListView.e {
    private boolean NR;
    private boolean NS;
    private CustomMessageListener NT;

    public ak(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.NS = true;
        this.NT = new al(this, 2016203);
        b(tbPageContext);
    }

    @Override // com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public void R(boolean z) {
        super.R(z);
        this.NS = true;
        this.wv.setBackgroundDrawable(null);
    }

    @Override // com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public void Q(boolean z) {
        super.Q(z);
        this.NS = false;
        if (!this.NR) {
            cs(TbadkCoreApplication.m255getInst().getSkinType());
        }
    }

    @Override // com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public void jt() {
        super.jt();
        this.NS = false;
    }

    @Override // com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public int ju() {
        return -getContext().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds46);
    }

    public void cs(int i) {
        if (this.wu != null && this.wv != null) {
            this.NR = false;
            this.wy = com.baidu.tbadk.core.util.av.po().bZ(i);
            if (this.wy != null) {
                this.NR = true;
            } else {
                this.wy = new AnimationDrawable();
            }
            if (i == 1) {
                this.wu.setBackgroundColor(getContext().getResources().getColor(com.baidu.tieba.t.cp_bg_line_c_1));
                if (!this.NR) {
                    Drawable drawable = getContext().getResources().getDrawable(com.baidu.tieba.v.listview_pull_refresh02_1);
                    if (drawable != null) {
                        this.wy.addFrame(drawable, 100);
                    }
                    Drawable drawable2 = getContext().getResources().getDrawable(com.baidu.tieba.v.listview_pull_refresh01_1);
                    if (drawable2 != null) {
                        this.wy.addFrame(drawable2, 100);
                    }
                }
            } else {
                this.wu.setBackgroundColor(getContext().getResources().getColor(com.baidu.tieba.t.cp_bg_line_c));
                if (!this.NR) {
                    Drawable drawable3 = getContext().getResources().getDrawable(com.baidu.tieba.v.listview_pull_refresh02);
                    if (drawable3 != null) {
                        this.wy.addFrame(drawable3, 100);
                    }
                    Drawable drawable4 = getContext().getResources().getDrawable(com.baidu.tieba.v.listview_pull_refresh01);
                    if (drawable4 != null) {
                        this.wy.addFrame(drawable4, 100);
                    }
                }
            }
            this.wy.setOneShot(false);
            this.wv.setBackgroundDrawable(this.wy);
        }
    }

    private void b(TbPageContext<?> tbPageContext) {
        tbPageContext.registerListener(this.NT);
    }
}
