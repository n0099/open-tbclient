package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class c extends f {
    @SuppressLint({"SimpleDateFormat"})
    private static SimpleDateFormat l = new SimpleDateFormat("MM-dd HH:mm");
    protected ImageView a;
    protected ProgressBar b;
    protected TextView c;
    protected TextView d;
    private View e;
    private RotateAnimation f;
    private RotateAnimation g;
    private d h;
    private String i;
    private String j;
    private String k;

    public c(Context context) {
        super(context);
        this.e = null;
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.f = null;
        this.g = null;
        this.h = null;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public View a() {
        Context h = h();
        return a(h.getString(com.baidu.adp.f.adp_pull_to_refresh), h.getString(com.baidu.adp.f.adp_release_to_refresh), h.getString(com.baidu.adp.f.adp_loading));
    }

    public View a(String str, String str2, String str3) {
        Context h = h();
        if (str == null) {
            str = h.getString(com.baidu.adp.f.adp_pull_to_refresh);
        }
        this.i = str;
        if (str2 == null) {
            str2 = h.getString(com.baidu.adp.f.adp_release_to_refresh);
        }
        this.j = str2;
        if (str3 == null) {
            str3 = h.getString(com.baidu.adp.f.adp_loading);
        }
        this.k = str3;
        this.e = LayoutInflater.from(h()).inflate(com.baidu.adp.e.pull_view, (ViewGroup) null);
        this.a = (ImageView) this.e.findViewById(com.baidu.adp.d.pull_arrow);
        this.b = (ProgressBar) this.e.findViewById(com.baidu.adp.d.pull_progress);
        this.c = (TextView) this.e.findViewById(com.baidu.adp.d.pull_text);
        this.d = (TextView) this.e.findViewById(com.baidu.adp.d.pull_time);
        a(g());
        this.f = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.f.setInterpolator(new LinearInterpolator());
        this.f.setDuration(250L);
        this.f.setFillAfter(true);
        this.g = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.g.setInterpolator(new LinearInterpolator());
        this.g.setDuration(200L);
        this.g.setFillAfter(true);
        return this.e;
    }

    public View b() {
        if (this.e == null) {
            this.e = a();
        }
        return this.e;
    }

    public TextView c() {
        return this.d;
    }

    public TextView d() {
        return this.c;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void e() {
        this.a.setVisibility(0);
        this.b.setVisibility(4);
        this.c.setVisibility(0);
        this.d.setVisibility(0);
        this.a.clearAnimation();
        this.a.startAnimation(this.f);
        this.c.setText(this.j);
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void a(boolean z) {
        this.b.setVisibility(4);
        this.c.setVisibility(0);
        this.d.setVisibility(0);
        this.a.setVisibility(0);
        this.a.clearAnimation();
        if (z) {
            this.a.startAnimation(this.g);
        }
        this.c.setText(this.i);
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void f() {
        this.b.setVisibility(0);
        this.a.clearAnimation();
        this.a.setVisibility(4);
        this.c.setText(this.k);
        this.d.setVisibility(0);
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void b(boolean z) {
        this.b.setVisibility(4);
        this.a.clearAnimation();
        this.a.setImageResource(com.baidu.adp.c.pull_icon);
        this.c.setText(this.i);
        this.d.setVisibility(0);
        if (z) {
            a(g());
        }
    }

    public static String g() {
        String format;
        synchronized (l) {
            format = l.format(new Date());
        }
        return format;
    }

    public void a(String str) {
        this.d.setText(String.valueOf(h().getString(com.baidu.adp.f.adp_pull_view_date_tip)) + str);
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void c(boolean z) {
        if (this.h != null) {
            this.h.a(z);
        }
    }

    public void a(d dVar) {
        this.h = dVar;
    }
}
