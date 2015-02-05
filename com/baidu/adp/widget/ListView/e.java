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
    private View wt;
    protected LinearLayout wu;
    protected ImageView wv;
    private g ww;
    private h wx;
    protected AnimationDrawable wy;

    public e(Context context) {
        super(context);
        this.wt = null;
        this.wu = null;
        this.wv = null;
        this.ww = null;
        this.wx = null;
    }

    @Override // com.baidu.adp.widget.ListView.j
    public View jr() {
        Context context = getContext();
        this.wt = com.baidu.adp.lib.g.b.ei().inflate(getContext(), R.layout.pull_simple_view, null);
        this.wu = (LinearLayout) this.wt.findViewById(R.id.pull_root);
        this.wv = (ImageView) this.wt.findViewById(R.id.pull_image);
        this.wy = new AnimationDrawable();
        Drawable drawable = context.getResources().getDrawable(R.drawable.listview_pull_refresh02);
        if (drawable != null) {
            this.wy.addFrame(drawable, 100);
        }
        Drawable drawable2 = context.getResources().getDrawable(R.drawable.listview_pull_refresh01);
        if (drawable2 != null) {
            this.wy.addFrame(drawable2, 100);
        }
        this.wy.setOneShot(false);
        this.wv.setBackgroundDrawable(this.wy);
        return this.wt;
    }

    @Override // com.baidu.adp.widget.ListView.j
    public void js() {
        this.wy.stop();
        this.wv.setBackgroundDrawable(this.wy.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.j
    public void Q(boolean z) {
        this.wy.stop();
        this.wv.setBackgroundDrawable(this.wy.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.j
    public void jt() {
        this.wy.stop();
        this.wv.setBackgroundDrawable(this.wy);
        this.wv.post(new f(this));
    }

    @Override // com.baidu.adp.widget.ListView.j
    public void R(boolean z) {
        this.wy.stop();
    }

    @Override // com.baidu.adp.widget.ListView.j
    public void S(boolean z) {
        if (this.ww != null) {
            this.ww.onListPullRefresh(z);
        }
        if (this.wx != null) {
            this.wx.a(this.wt, z);
        }
    }

    public void a(g gVar) {
        this.ww = gVar;
    }

    public void a(h hVar) {
        this.wx = hVar;
    }

    @Override // com.baidu.adp.widget.ListView.j
    public int ju() {
        return 0;
    }
}
