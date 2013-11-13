package com.baidu.adp.widget.ScrollView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class a extends RelativeLayout implements b {

    /* renamed from: a  reason: collision with root package name */
    private TextView f585a;
    private ProgressBar b;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate(context, com.baidu.adp.e.adp_detault_footer_layout, this);
        this.f585a = (TextView) findViewById(com.baidu.adp.d.foot_layout_text);
        this.b = (ProgressBar) findViewById(com.baidu.adp.d.foot_layout_progress);
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public void a_() {
        this.f585a.setText(getResources().getString(com.baidu.adp.f.adp_pull_up_to_get_more));
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public void e() {
        this.f585a.setText(getResources().getString(com.baidu.adp.f.adp_release_to_get_more));
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public void f() {
        this.f585a.setText(getResources().getString(com.baidu.adp.f.adp_refreshing));
        this.b.setVisibility(0);
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public void b_() {
        this.f585a.setText(getResources().getString(com.baidu.adp.f.adp_pull_up_to_get_more));
        this.b.setVisibility(8);
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public View getRealView() {
        return this;
    }
}
