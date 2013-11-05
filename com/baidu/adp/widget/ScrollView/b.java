package com.baidu.adp.widget.ScrollView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class b extends LinearLayout implements c {

    /* renamed from: a  reason: collision with root package name */
    private Animation f580a;
    private Animation b;
    private View c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private boolean g;

    public b(Context context) {
        this(context, null);
        this.f580a = AnimationUtils.loadAnimation(getContext(), com.baidu.adp.b.adp_down_to_up);
        this.b = AnimationUtils.loadAnimation(getContext(), com.baidu.adp.b.adp_up_to_down);
        this.f580a.setFillAfter(true);
        this.b.setFillAfter(true);
        LayoutInflater.from(context).inflate(com.baidu.adp.f.adp_default_header_layout, this);
        this.c = (ProgressBar) findViewById(com.baidu.adp.e.head_layout_left_progressbar);
        this.d = (ImageView) findViewById(com.baidu.adp.e.head_layout_left_arrow);
        this.e = (TextView) findViewById(com.baidu.adp.e.head_layout_title);
        this.f = (TextView) findViewById(com.baidu.adp.e.head_layout_refresh_time);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.adp.widget.ScrollView.c
    public void a() {
        if (this.g) {
            this.d.startAnimation(this.b);
            this.g = false;
        }
        this.e.setText(getResources().getString(com.baidu.adp.g.adp_pull_to_refresh));
    }

    @Override // com.baidu.adp.widget.ScrollView.c
    public void b() {
        this.d.startAnimation(this.f580a);
        this.g = true;
        this.e.setText(getResources().getString(com.baidu.adp.g.adp_release_to_refresh));
    }

    @Override // com.baidu.adp.widget.ScrollView.c
    public void c() {
        this.g = false;
        this.c.setVisibility(0);
        this.e.setText(getResources().getString(com.baidu.adp.g.adp_refreshing));
        this.d.clearAnimation();
        this.d.setVisibility(4);
    }

    @Override // com.baidu.adp.widget.ScrollView.c
    public void d() {
        this.g = false;
        this.d.setVisibility(0);
        this.c.setVisibility(8);
        this.e.setText(getResources().getString(com.baidu.adp.g.adp_pull_to_refresh));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        this.f.setVisibility(0);
        this.f.setText(getResources().getString(com.baidu.adp.g.adp_refreshed) + ":" + simpleDateFormat.format(date));
    }

    public LinearLayout getRealView() {
        return this;
    }
}
