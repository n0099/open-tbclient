package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class ag extends ac {
    private boolean Zd;
    private boolean Ze;
    private CustomMessageListener Zf;
    private CustomMessageListener Zg;

    public ag(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.Ze = true;
        this.Zf = new ah(this, 2016203);
        this.Zg = new ai(this, 2016204);
        e(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.ac, com.baidu.adp.widget.ListView.f
    public void P(boolean z) {
        this.YY.setBackgroundDrawable(null);
        super.P(z);
        this.Ze = true;
    }

    @Override // com.baidu.tbadk.core.view.ac, com.baidu.adp.widget.ListView.f
    public void O(boolean z) {
        super.O(z);
        this.Ze = false;
        if (!this.Zd) {
            ct(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.ac, com.baidu.adp.widget.ListView.f
    public void mP() {
        super.mP();
        this.Ze = false;
    }

    public void ct(int i) {
        if (this.YX != null && this.YY != null) {
            this.Zd = false;
            this.Zb = com.baidu.tbadk.core.util.at.sL().ca(i);
            if (this.Zb != null) {
                this.Zd = true;
            } else {
                this.Zb = new AnimationDrawable();
            }
            this.YX.setBackgroundColor(com.baidu.tbadk.core.util.at.sL().cb(i));
            if (!this.Zd) {
                Drawable drawable = ba.getDrawable(com.baidu.tieba.u.listview_pull_refresh02);
                if (drawable != null) {
                    this.Zb.addFrame(drawable, 100);
                }
                Drawable drawable2 = ba.getDrawable(com.baidu.tieba.u.listview_pull_refresh01);
                if (drawable2 != null) {
                    this.Zb.addFrame(drawable2, 100);
                }
            }
            this.Zb.setOneShot(false);
            this.YY.setBackgroundDrawable(this.Zb);
        }
    }

    @Override // com.baidu.tbadk.core.view.ac, com.baidu.adp.widget.ListView.f
    public void Q(boolean z) {
        super.Q(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds46), 0, 0);
    }

    private void e(TbPageContext<?> tbPageContext) {
        tbPageContext.registerListener(this.Zf);
        tbPageContext.registerListener(this.Zg);
    }
}
