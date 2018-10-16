package com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes2.dex */
public class FooterLoadingLayout extends LoadingLayout {
    private TextView mHintView;
    private LoadingAnimView mLoadingView;

    public FooterLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public FooterLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.mLoadingView = (LoadingAnimView) findViewById(R.id.pull_to_load_footer_progressbar);
        this.mHintView = (TextView) findViewById(R.id.pull_to_load_footer_hint_textview);
        this.mHintView.setTextColor(getResources().getColor(R.color.aiapps_picture_loading_text_color));
        setState(ILoadingLayout.State.RESET);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected View createLoadingView(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.aiapps_pull_to_load_footer, viewGroup, false);
        inflate.setBackgroundColor(context.getResources().getColor(R.color.aiapps_pull_loading_bg));
        return inflate;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout, com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.ILoadingLayout
    public int getContentSize() {
        View findViewById = findViewById(R.id.pull_to_load_footer_content);
        return findViewById != null ? findViewById.getHeight() : (int) getResources().getDimension(R.dimen.aiapps_picture_pull_to_refresh_footer_height);
    }

    public void showTopDivider(boolean z) {
        View findViewById = findViewById(R.id.top_divider);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    public void onStateChanged(ILoadingLayout.State state, ILoadingLayout.State state2) {
        this.mLoadingView.setVisibility(8);
        this.mLoadingView.stopAnim();
        this.mHintView.setVisibility(4);
        super.onStateChanged(state, state2);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        this.mHintView.setText(R.string.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.mHintView.setVisibility(0);
        this.mHintView.setText(R.string.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.mHintView.setVisibility(0);
        this.mHintView.setText(R.string.aiapps_pull_to_refresh_header_hint_ready);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        this.mLoadingView.setVisibility(0);
        this.mLoadingView.startAnim();
        this.mHintView.setVisibility(0);
        this.mHintView.setText(R.string.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected void onNoMoreData() {
        this.mHintView.setVisibility(0);
        this.mHintView.setText(R.string.aiapps_pull_to_refresh_header_no_more_msg);
    }
}
