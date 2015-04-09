package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.widget.ListView.f {
    private View YW;
    protected LinearLayout YX;
    protected ImageView YY;
    private ae YZ;
    private af Za;
    protected AnimationDrawable Zb;

    public ac(Context context) {
        super(context);
        this.YW = null;
        this.YX = null;
        this.YY = null;
        this.YZ = null;
        this.Za = null;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public View mN() {
        Context context = getContext();
        this.YW = com.baidu.adp.lib.g.b.hH().inflate(getContext(), com.baidu.tieba.w.tb_pull_view, null);
        this.YX = (LinearLayout) this.YW.findViewById(com.baidu.tieba.v.pull_root);
        this.YY = (ImageView) this.YW.findViewById(com.baidu.tieba.v.pull_image);
        this.Zb = new AnimationDrawable();
        Drawable drawable = context.getResources().getDrawable(com.baidu.tieba.u.listview_pull_refresh02);
        if (drawable != null) {
            this.Zb.addFrame(drawable, 100);
        }
        Drawable drawable2 = context.getResources().getDrawable(com.baidu.tieba.u.listview_pull_refresh01);
        if (drawable2 != null) {
            this.Zb.addFrame(drawable2, 100);
        }
        this.Zb.setOneShot(false);
        this.YY.setBackgroundDrawable(this.Zb);
        return this.YW;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void mO() {
        this.Zb.stop();
        this.YY.setBackgroundDrawable(this.Zb.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void O(boolean z) {
        this.Zb.stop();
        this.YY.setBackgroundDrawable(this.Zb.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void mP() {
        this.Zb.stop();
        this.YY.setBackgroundDrawable(this.Zb);
        this.YY.post(new ad(this));
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void P(boolean z) {
        this.Zb.stop();
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void Q(boolean z) {
        if (this.YZ != null) {
            this.YZ.onListPullRefresh(z);
        }
        if (this.Za != null) {
            this.Za.a(this.YW, z);
        }
    }

    public void a(ae aeVar) {
        this.YZ = aeVar;
    }

    public void a(af afVar) {
        this.Za = afVar;
    }
}
