package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import d.a.h0.a.c;
import d.a.h0.a.d;
import d.a.h0.a.f;
import d.a.h0.a.g;
import d.a.h0.a.h;
/* loaded from: classes3.dex */
public class FooterLoadingLayout extends LoadingLayout {

    /* renamed from: h  reason: collision with root package name */
    public LoadingAnimView f12050h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12051i;

    public FooterLoadingLayout(Context context) {
        super(context);
        n(context);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(g.aiapps_pull_to_load_footer, viewGroup, false);
        inflate.setBackgroundColor(context.getResources().getColor(c.aiapps_pull_loading_bg));
        return inflate;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void c() {
        this.f12051i.setVisibility(0);
        this.f12051i.setText(h.aiapps_pull_to_refresh_header_no_more_msg);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        this.f12051i.setVisibility(0);
        this.f12051i.setText(h.aiapps_pull_to_refresh_header_hint_normal);
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
        this.f12050h.setVisibility(0);
        this.f12050h.d();
        this.f12051i.setVisibility(0);
        this.f12051i.setText(h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        this.f12051i.setVisibility(0);
        this.f12051i.setText(h.aiapps_pull_to_refresh_header_hint_ready);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        this.f12051i.setText(h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void l(ILoadingLayout$State iLoadingLayout$State, ILoadingLayout$State iLoadingLayout$State2) {
        this.f12050h.setVisibility(8);
        this.f12050h.e();
        this.f12051i.setVisibility(4);
        super.l(iLoadingLayout$State, iLoadingLayout$State2);
    }

    public final void n(Context context) {
        this.f12050h = (LoadingAnimView) findViewById(f.pull_to_load_footer_progressbar);
        TextView textView = (TextView) findViewById(f.pull_to_load_footer_hint_textview);
        this.f12051i = textView;
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
