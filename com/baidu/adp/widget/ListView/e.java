package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class e extends j {
    private h wA;
    protected AnimationDrawable wB;
    private View ww;
    protected LinearLayout wx;
    protected ImageView wy;
    private g wz;

    public e(Context context) {
        super(context);
        this.ww = null;
        this.wx = null;
        this.wy = null;
        this.wz = null;
        this.wA = null;
    }

    @Override // com.baidu.adp.widget.ListView.j
    public View jy() {
        Context context = getContext();
        this.ww = com.baidu.adp.lib.g.b.ei().inflate(getContext(), R.layout.pull_simple_view, null);
        this.wx = (LinearLayout) this.ww.findViewById(R.id.pull_root);
        this.wy = (ImageView) this.ww.findViewById(R.id.pull_image);
        this.wB = new AnimationDrawable();
        Drawable drawable = context.getResources().getDrawable(R.drawable.listview_pull_refresh02);
        if (drawable != null) {
            this.wB.addFrame(drawable, 100);
        }
        Drawable drawable2 = context.getResources().getDrawable(R.drawable.listview_pull_refresh01);
        if (drawable2 != null) {
            this.wB.addFrame(drawable2, 100);
        }
        this.wB.setOneShot(false);
        this.wy.setBackgroundDrawable(this.wB);
        return this.ww;
    }

    @Override // com.baidu.adp.widget.ListView.j
    public void jz() {
        this.wB.stop();
        this.wy.setBackgroundDrawable(this.wB.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.j
    public void Q(boolean z) {
        this.wB.stop();
        this.wy.setBackgroundDrawable(this.wB.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.j
    public void jA() {
        this.wB.stop();
        this.wy.setBackgroundDrawable(this.wB);
        this.wy.post(new f(this));
    }

    @Override // com.baidu.adp.widget.ListView.j
    public void R(boolean z) {
        this.wB.stop();
    }

    @Override // com.baidu.adp.widget.ListView.j
    public void S(boolean z) {
        if (this.wz != null) {
            this.wz.onListPullRefresh(z);
        }
        if (this.wA != null) {
            this.wA.a(this.ww, z);
        }
    }

    public void a(g gVar) {
        this.wz = gVar;
    }

    public void a(h hVar) {
        this.wA = hVar;
    }

    @Override // com.baidu.adp.widget.ListView.j
    public int jB() {
        return 0;
    }
}
