package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.R;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class e extends j {
    private static SimpleDateFormat wB = new SimpleDateFormat("HH:mm");
    protected AnimationDrawable wA;
    private View wq;
    protected LinearLayout wr;
    protected ImageView ws;
    protected TextView wt;
    protected TextView wu;
    private g wv;
    private h ww;
    private String wx;
    private String wy;
    private String wz;

    public e(Context context) {
        super(context);
        this.wq = null;
        this.wr = null;
        this.ws = null;
        this.wt = null;
        this.wu = null;
        this.wv = null;
        this.ww = null;
    }

    @Override // com.baidu.adp.widget.ListView.j
    public View jx() {
        Context context = getContext();
        return h(context.getString(R.string.adp_pull_to_refresh), context.getString(R.string.adp_release_to_refresh), context.getString(R.string.adp_loading));
    }

    public View h(String str, String str2, String str3) {
        Context context = getContext();
        if (str == null) {
            str = context.getString(R.string.adp_pull_to_refresh);
        }
        this.wx = str;
        if (str2 == null) {
            str2 = context.getString(R.string.adp_release_to_refresh);
        }
        this.wy = str2;
        if (str3 == null) {
            str3 = context.getString(R.string.adp_loading);
        }
        this.wz = str3;
        this.wq = com.baidu.adp.lib.g.b.ek().inflate(getContext(), R.layout.pull_view, null);
        this.wr = (LinearLayout) this.wq.findViewById(R.id.pull_root);
        this.ws = (ImageView) this.wq.findViewById(R.id.pull_image);
        this.wA = new AnimationDrawable();
        Drawable drawable = context.getResources().getDrawable(R.drawable.listview_pull_refresh02);
        if (drawable != null) {
            this.wA.addFrame(drawable, 100);
        }
        Drawable drawable2 = context.getResources().getDrawable(R.drawable.listview_pull_refresh01);
        if (drawable2 != null) {
            this.wA.addFrame(drawable2, 100);
        }
        this.wA.setOneShot(false);
        this.ws.setBackgroundDrawable(this.wA);
        this.wt = (TextView) this.wq.findViewById(R.id.pull_text);
        this.wu = (TextView) this.wq.findViewById(R.id.pull_time);
        bA(jC());
        return this.wq;
    }

    public TextView jy() {
        return this.wu;
    }

    public TextView jz() {
        return this.wt;
    }

    @Override // com.baidu.adp.widget.ListView.j
    public void jA() {
        this.wt.setVisibility(0);
        this.wu.setVisibility(0);
        this.wA.stop();
        this.ws.setBackgroundDrawable(this.wA.getFrame(1));
        this.wt.setText(this.wy);
    }

    @Override // com.baidu.adp.widget.ListView.j
    public void Q(boolean z) {
        this.wA.stop();
        this.ws.setBackgroundDrawable(this.wA.getFrame(0));
        this.wt.setVisibility(0);
        this.wu.setVisibility(0);
        this.wt.setText(this.wx);
    }

    @Override // com.baidu.adp.widget.ListView.j
    public void jB() {
        this.wA.stop();
        this.ws.setBackgroundDrawable(this.wA);
        this.ws.post(new f(this));
        this.wt.setText(this.wz);
        this.wu.setVisibility(0);
    }

    @Override // com.baidu.adp.widget.ListView.j
    public void R(boolean z) {
        this.wA.stop();
        this.wt.setText(this.wx);
        this.wu.setVisibility(0);
        if (z) {
            bA(jC());
        }
    }

    public static String jC() {
        String format;
        synchronized (wB) {
            format = wB.format(new Date());
        }
        return format;
    }

    public void bA(String str) {
        this.wu.setText(String.valueOf(getContext().getString(R.string.adp_pull_view_date_tip)) + str);
    }

    @Override // com.baidu.adp.widget.ListView.j
    public void S(boolean z) {
        if (this.wv != null) {
            this.wv.onListPullRefresh(z);
        }
        if (this.ww != null) {
            this.ww.a(this.wq, z);
        }
    }

    public void a(g gVar) {
        this.wv = gVar;
    }

    public void a(h hVar) {
        this.ww = hVar;
    }
}
