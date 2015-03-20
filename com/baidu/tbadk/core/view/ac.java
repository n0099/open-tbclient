package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.widget.ListView.f {
    private View YU;
    protected LinearLayout YV;
    protected ImageView YW;
    private ae YX;
    private af YY;
    protected AnimationDrawable YZ;

    public ac(Context context) {
        super(context);
        this.YU = null;
        this.YV = null;
        this.YW = null;
        this.YX = null;
        this.YY = null;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public View mN() {
        Context context = getContext();
        this.YU = com.baidu.adp.lib.g.b.hH().inflate(getContext(), com.baidu.tieba.w.tb_pull_view, null);
        this.YV = (LinearLayout) this.YU.findViewById(com.baidu.tieba.v.pull_root);
        this.YW = (ImageView) this.YU.findViewById(com.baidu.tieba.v.pull_image);
        this.YZ = new AnimationDrawable();
        Drawable drawable = context.getResources().getDrawable(com.baidu.tieba.u.listview_pull_refresh02);
        if (drawable != null) {
            this.YZ.addFrame(drawable, 100);
        }
        Drawable drawable2 = context.getResources().getDrawable(com.baidu.tieba.u.listview_pull_refresh01);
        if (drawable2 != null) {
            this.YZ.addFrame(drawable2, 100);
        }
        this.YZ.setOneShot(false);
        this.YW.setBackgroundDrawable(this.YZ);
        return this.YU;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void mO() {
        this.YZ.stop();
        this.YW.setBackgroundDrawable(this.YZ.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void O(boolean z) {
        this.YZ.stop();
        this.YW.setBackgroundDrawable(this.YZ.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void mP() {
        this.YZ.stop();
        this.YW.setBackgroundDrawable(this.YZ);
        this.YW.post(new ad(this));
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void P(boolean z) {
        this.YZ.stop();
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void Q(boolean z) {
        if (this.YX != null) {
            this.YX.onListPullRefresh(z);
        }
        if (this.YY != null) {
            this.YY.a(this.YU, z);
        }
    }

    public void a(ae aeVar) {
        this.YX = aeVar;
    }

    public void a(af afVar) {
        this.YY = afVar;
    }
}
