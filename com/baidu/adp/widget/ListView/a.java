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
public class a extends d {
    @SuppressLint({"SimpleDateFormat"})
    private static SimpleDateFormat l = new SimpleDateFormat("MM-dd HH:mm");

    /* renamed from: a  reason: collision with root package name */
    private View f564a;
    private ImageView b;
    private ProgressBar c;
    private TextView d;
    private TextView e;
    private RotateAnimation f;
    private RotateAnimation g;
    private b h;
    private String i;
    private String j;
    private String k;

    public a(Context context) {
        super(context);
        this.f564a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
    }

    @Override // com.baidu.adp.widget.ListView.d
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
        this.f564a = LayoutInflater.from(h()).inflate(com.baidu.adp.e.pull_view, (ViewGroup) null);
        this.b = (ImageView) this.f564a.findViewById(com.baidu.adp.d.pull_arrow);
        this.c = (ProgressBar) this.f564a.findViewById(com.baidu.adp.d.pull_progress);
        this.d = (TextView) this.f564a.findViewById(com.baidu.adp.d.pull_text);
        this.e = (TextView) this.f564a.findViewById(com.baidu.adp.d.pull_time);
        a(g());
        this.f = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.f.setInterpolator(new LinearInterpolator());
        this.f.setDuration(250L);
        this.f.setFillAfter(true);
        this.g = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.g.setInterpolator(new LinearInterpolator());
        this.g.setDuration(200L);
        this.g.setFillAfter(true);
        return this.f564a;
    }

    public View b() {
        if (this.f564a == null) {
            this.f564a = a();
        }
        return this.f564a;
    }

    public TextView c() {
        return this.e;
    }

    public TextView d() {
        return this.d;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void e() {
        this.b.setVisibility(0);
        this.c.setVisibility(4);
        this.d.setVisibility(0);
        this.e.setVisibility(0);
        this.b.clearAnimation();
        this.b.startAnimation(this.f);
        this.d.setText(this.j);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        this.c.setVisibility(4);
        this.d.setVisibility(0);
        this.e.setVisibility(0);
        this.b.setVisibility(0);
        this.b.clearAnimation();
        if (z) {
            this.b.startAnimation(this.g);
        }
        this.d.setText(this.i);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void f() {
        this.c.setVisibility(0);
        this.b.clearAnimation();
        this.b.setVisibility(4);
        this.d.setText(this.k);
        this.e.setVisibility(0);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void b(boolean z) {
        this.c.setVisibility(4);
        this.b.clearAnimation();
        this.b.setImageResource(com.baidu.adp.c.pull_icon);
        this.d.setText(this.i);
        this.e.setVisibility(0);
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
        this.e.setText(h().getString(com.baidu.adp.f.adp_pull_view_date_tip) + str);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void c(boolean z) {
        if (this.h != null) {
            this.h.a(z);
        }
    }

    public void a(b bVar) {
        this.h = bVar;
    }
}
