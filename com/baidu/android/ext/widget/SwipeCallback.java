package com.baidu.android.ext.widget;

import android.view.View;
/* loaded from: classes.dex */
public interface SwipeCallback {

    /* loaded from: classes.dex */
    public interface SwipeScrollListener {
        void computeScroll();

        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    View getContentView();

    SwipeAdapter getSwipeAdapter();

    View getSwipeChildAt(int i);

    View getSwipeChildAtPosition(int i, int i2);

    int getSwipeChildCount();

    int getSwipeChildIndex(View view2);

    int getSwipeChildLeftAt(int i);

    int getSwipeChildTopAt(int i);

    int getSwipeFirstVisiblePosition();

    int getSwipeLastVisiblePosition();

    void onBeginDrag(View view2);

    void onChildDismissed(View view2);

    void onDragCancelled(View view2);

    void setSwipeAdapter(SwipeAdapter swipeAdapter);

    void setSwipeScrollListener(SwipeScrollListener swipeScrollListener);
}
