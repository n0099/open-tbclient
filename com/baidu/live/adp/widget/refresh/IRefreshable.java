package com.baidu.live.adp.widget.refresh;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes11.dex */
public interface IRefreshable {

    /* loaded from: classes11.dex */
    public interface OnRefreshListener {
        void onPreRefresh();

        void onRefreshData();

        void onRefreshUI();

        void onStateChanged(State state);
    }

    /* loaded from: classes11.dex */
    public enum State {
        idle,
        pulling_no_refresh,
        animating,
        pulling_refresh
    }

    View getEmptyView();

    View getRefresherContent();

    View getRefresherHeader();

    State getState();

    boolean isEnabled();

    void refresh();

    void refreshShowingHeader();

    void setEmptyView(View view);

    void setEnable(boolean z);

    void setOnRefreshListener(OnRefreshListener onRefreshListener);

    void setRefresherContent(ViewGroup viewGroup);

    void setRefresherHeader(View view);
}
