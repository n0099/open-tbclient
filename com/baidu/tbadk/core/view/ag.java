package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class ag extends ac {
    private boolean Zb;
    private boolean Zc;
    private CustomMessageListener Zd;
    private CustomMessageListener Ze;

    public ag(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.Zc = true;
        this.Zd = new ah(this, 2016203);
        this.Ze = new ai(this, 2016204);
        e(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.ac, com.baidu.adp.widget.ListView.f
    public void P(boolean z) {
        this.YW.setBackgroundDrawable(null);
        super.P(z);
        this.Zc = true;
    }

    @Override // com.baidu.tbadk.core.view.ac, com.baidu.adp.widget.ListView.f
    public void O(boolean z) {
        super.O(z);
        this.Zc = false;
        if (!this.Zb) {
            ct(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.ac, com.baidu.adp.widget.ListView.f
    public void mP() {
        super.mP();
        this.Zc = false;
    }

    public void ct(int i) {
        if (this.YV != null && this.YW != null) {
            this.Zb = false;
            this.YZ = com.baidu.tbadk.core.util.at.sL().ca(i);
            if (this.YZ != null) {
                this.Zb = true;
            } else {
                this.YZ = new AnimationDrawable();
            }
            this.YV.setBackgroundColor(com.baidu.tbadk.core.util.at.sL().cb(i));
            if (!this.Zb) {
                Drawable drawable = ba.getDrawable(com.baidu.tieba.u.listview_pull_refresh02);
                if (drawable != null) {
                    this.YZ.addFrame(drawable, 100);
                }
                Drawable drawable2 = ba.getDrawable(com.baidu.tieba.u.listview_pull_refresh01);
                if (drawable2 != null) {
                    this.YZ.addFrame(drawable2, 100);
                }
            }
            this.YZ.setOneShot(false);
            this.YW.setBackgroundDrawable(this.YZ);
        }
    }

    @Override // com.baidu.tbadk.core.view.ac, com.baidu.adp.widget.ListView.f
    public void Q(boolean z) {
        super.Q(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds46), 0, 0);
    }

    private void e(TbPageContext<?> tbPageContext) {
        tbPageContext.registerListener(this.Zd);
        tbPageContext.registerListener(this.Ze);
    }
}
