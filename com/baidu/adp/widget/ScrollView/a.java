package com.baidu.adp.widget.ScrollView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
/* loaded from: classes.dex */
public class a extends LinearLayout implements c {
    private TextView a;
    private ProgressBar b;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate(context, com.baidu.adp.f.adp_detault_footer_layout, this);
        this.a = (TextView) findViewById(com.baidu.adp.e.foot_layout_text);
        this.b = (ProgressBar) findViewById(com.baidu.adp.e.foot_layout_progress);
    }

    @Override // com.baidu.adp.widget.ScrollView.c
    public void a() {
        this.a.setText(getResources().getString(com.baidu.adp.g.adp_pull_up_to_get_more));
    }

    @Override // com.baidu.adp.widget.ScrollView.c
    public void b() {
        this.a.setText(getResources().getString(com.baidu.adp.g.adp_release_to_get_more));
    }

    @Override // com.baidu.adp.widget.ScrollView.c
    public void c() {
        this.a.setText(getResources().getString(com.baidu.adp.g.adp_refreshing));
        this.b.setVisibility(0);
    }

    @Override // com.baidu.adp.widget.ScrollView.c
    public void d() {
        this.a.setText(getResources().getString(com.baidu.adp.g.adp_pull_up_to_get_more));
        this.b.setVisibility(8);
    }

    public LinearLayout getRealView() {
        return this;
    }
}
