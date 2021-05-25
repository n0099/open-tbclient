package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import d.a.l0.a.c;
import d.a.l0.a.d;
import d.a.l0.a.f;
import d.a.l0.a.g;
import d.a.l0.a.h;
import d.a.l0.a.r1.n.a;
/* loaded from: classes3.dex */
public class FooterLoadingLayout extends LoadingLayout {

    /* renamed from: i  reason: collision with root package name */
    public LoadingAnimView f11143i;
    public TextView j;

    public FooterLoadingLayout(Context context) {
        super(context);
        n(context);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        View b2 = a.a().b(g.aiapps_pull_to_load_footer, viewGroup, false);
        b2.setBackgroundColor(context.getResources().getColor(c.aiapps_pull_loading_bg));
        return b2;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void c() {
        this.j.setVisibility(0);
        this.j.setText(h.aiapps_pull_to_refresh_header_no_more_msg);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        this.j.setVisibility(0);
        this.j.setText(h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        View findViewById = findViewById(f.pull_to_load_footer_content);
        if (findViewById != null) {
            return findViewById.getHeight();
        }
        return (int) getResources().getDimension(d.aiapps_picture_pull_to_refresh_footer_height);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void h() {
        this.f11143i.setVisibility(0);
        this.f11143i.d();
        this.j.setVisibility(0);
        this.j.setText(h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        this.j.setVisibility(0);
        this.j.setText(h.aiapps_pull_to_refresh_header_hint_ready);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        this.j.setText(h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void l(ILoadingLayout$State iLoadingLayout$State, ILoadingLayout$State iLoadingLayout$State2) {
        this.f11143i.setVisibility(8);
        this.f11143i.e();
        this.j.setVisibility(4);
        super.l(iLoadingLayout$State, iLoadingLayout$State2);
    }

    public final void n(Context context) {
        this.f11143i = (LoadingAnimView) findViewById(f.pull_to_load_footer_progressbar);
        TextView textView = (TextView) findViewById(f.pull_to_load_footer_hint_textview);
        this.j = textView;
        textView.setTextColor(getResources().getColor(c.aiapps_picture_loading_text_color));
        setState(ILoadingLayout$State.RESET);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
    }

    public FooterLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n(context);
    }
}
