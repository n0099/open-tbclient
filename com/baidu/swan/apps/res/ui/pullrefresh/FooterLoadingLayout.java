package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes10.dex */
public class FooterLoadingLayout extends LoadingLayout {
    private LoadingAnimView dpl;
    private TextView mHintView;

    public FooterLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public FooterLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.dpl = (LoadingAnimView) findViewById(a.f.pull_to_load_footer_progressbar);
        this.mHintView = (TextView) findViewById(a.f.pull_to_load_footer_hint_textview);
        this.mHintView.setTextColor(getResources().getColor(a.c.aiapps_picture_loading_text_color));
        setState(ILoadingLayout.State.RESET);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_load_footer, viewGroup, false);
        inflate.setBackgroundColor(context.getResources().getColor(a.c.aiapps_pull_loading_bg));
        return inflate;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        View findViewById = findViewById(a.f.pull_to_load_footer_content);
        return findViewById != null ? findViewById.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_footer_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        this.dpl.setVisibility(8);
        this.dpl.stopAnim();
        this.mHintView.setVisibility(4);
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        this.mHintView.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.mHintView.setVisibility(0);
        this.mHintView.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.mHintView.setVisibility(0);
        this.mHintView.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        this.dpl.setVisibility(0);
        this.dpl.startAnim();
        this.mHintView.setVisibility(0);
        this.mHintView.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onNoMoreData() {
        this.mHintView.setVisibility(0);
        this.mHintView.setText(a.h.aiapps_pull_to_refresh_header_no_more_msg);
    }
}
