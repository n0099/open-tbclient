package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
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
    private static SimpleDateFormat i = new SimpleDateFormat("MM-dd HH:mm");

    /* renamed from: a  reason: collision with root package name */
    private View f562a;
    private ImageView b;
    private ProgressBar c;
    private TextView d;
    private TextView e;
    private RotateAnimation f;
    private RotateAnimation g;
    private b h;

    @Override // com.baidu.adp.widget.ListView.d
    public View a() {
        this.f562a = LayoutInflater.from(e()).inflate(com.baidu.adp.f.pull_view, (ViewGroup) null);
        this.b = (ImageView) this.f562a.findViewById(com.baidu.adp.e.pull_arrow);
        this.c = (ProgressBar) this.f562a.findViewById(com.baidu.adp.e.pull_progress);
        this.d = (TextView) this.f562a.findViewById(com.baidu.adp.e.pull_text);
        this.e = (TextView) this.f562a.findViewById(com.baidu.adp.e.pull_time);
        a(d());
        this.f = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.f.setInterpolator(new LinearInterpolator());
        this.f.setDuration(250L);
        this.f.setFillAfter(true);
        this.g = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.g.setInterpolator(new LinearInterpolator());
        this.g.setDuration(200L);
        this.g.setFillAfter(true);
        return this.f562a;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void b() {
        this.b.setVisibility(0);
        this.c.setVisibility(4);
        this.d.setVisibility(0);
        this.e.setVisibility(0);
        this.b.clearAnimation();
        this.b.startAnimation(this.f);
        this.d.setText("释放刷新");
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        this.c.setVisibility(4);
        this.d.setVisibility(0);
        this.e.setVisibility(0);
        this.b.clearAnimation();
        this.b.setVisibility(0);
        if (z) {
            this.b.clearAnimation();
            this.b.startAnimation(this.g);
            this.d.setText("下拉刷新");
            return;
        }
        this.d.setText("下拉刷新");
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void c() {
        this.c.setVisibility(0);
        this.b.clearAnimation();
        this.b.setVisibility(4);
        this.d.setText("正在加载");
        this.e.setVisibility(0);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void b(boolean z) {
        this.c.setVisibility(4);
        this.b.clearAnimation();
        this.b.setImageResource(com.baidu.adp.d.pull_icon);
        this.d.setText("下拉刷新");
        this.e.setVisibility(0);
        if (z) {
            a(d());
        }
    }

    public static String d() {
        String format;
        synchronized (i) {
            format = i.format(new Date());
        }
        return format;
    }

    public void a(String str) {
        this.e.setText("最后更新：" + str);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void c(boolean z) {
        if (this.h != null) {
            this.h.a(z);
        }
    }
}
