package com.baidu.searchbox.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.searchbox.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes4.dex */
public class FooterLoadingLayout extends LoadingLayout {
    public TextView mHintView;
    public LoadingAnimView mLoadingView;

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
    }

    public FooterLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mLoadingView = (LoadingAnimView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091df1);
        TextView textView = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091df0);
        this.mHintView = textView;
        textView.setTextColor(getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f060954));
        setState(ILoadingLayout.State.RESET);
    }

    public void showTopDivider(boolean z) {
        int i;
        View findViewById = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092663);
        if (findViewById != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            findViewById.setVisibility(i);
        }
    }

    public FooterLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onStateChanged(ILoadingLayout.State state, ILoadingLayout.State state2) {
        this.mLoadingView.setVisibility(8);
        this.mLoadingView.stopAnim();
        this.mHintView.setVisibility(4);
        super.onStateChanged(state, state2);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public View createLoadingView(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0840, viewGroup, false);
        inflate.setBackgroundColor(context.getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f06096e));
        return inflate;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout, com.baidu.searchbox.ui.pullrefresh.ILoadingLayout
    public int getContentSize() {
        View findViewById = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091def);
        if (findViewById != null) {
            return findViewById.getHeight();
        }
        return (int) getResources().getDimension(com.baidu.tieba.R.dimen.obfuscated_res_0x7f07077b);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onNoMoreData() {
        this.mHintView.setVisibility(0);
        this.mHintView.setText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f11a0);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onPullToRefresh() {
        this.mHintView.setVisibility(0);
        this.mHintView.setText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f119d);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onRefreshing() {
        this.mLoadingView.setVisibility(0);
        this.mLoadingView.startAnim();
        this.mHintView.setVisibility(0);
        this.mHintView.setText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f119c);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onReleaseToRefresh() {
        this.mHintView.setVisibility(0);
        this.mHintView.setText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f119e);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onReset() {
        this.mHintView.setText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f119c);
    }
}
