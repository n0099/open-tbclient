package com.baidu.adp.widget.ScrollView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public final class a extends RelativeLayout implements b {
    private TextView a;
    private ProgressBar b;

    public a(Context context) {
        this(context, null);
    }

    private a(Context context, AttributeSet attributeSet) {
        super(context, null);
        inflate(context, com.baidu.adp.e.adp_detault_footer_layout, this);
        this.a = (TextView) findViewById(com.baidu.adp.d.foot_layout_text);
        this.b = (ProgressBar) findViewById(com.baidu.adp.d.foot_layout_progress);
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public final void a_() {
        this.a.setText(getResources().getString(com.baidu.adp.f.adp_pull_up_to_get_more));
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public final void e() {
        this.a.setText(getResources().getString(com.baidu.adp.f.adp_release_to_get_more));
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public final void f() {
        this.a.setText(getResources().getString(com.baidu.adp.f.adp_refreshing));
        this.b.setVisibility(0);
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public final void b_() {
        this.a.setText(getResources().getString(com.baidu.adp.f.adp_pull_up_to_get_more));
        this.b.setVisibility(8);
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public final View getRealView() {
        return this;
    }
}
