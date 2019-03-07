package com.baidu.swan.apps.core.container;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
/* loaded from: classes2.dex */
public class PullToRefreshBaseWebView<T extends View> extends PullToRefreshBase<T> {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private a apw;
    private boolean apx;

    /* loaded from: classes2.dex */
    public interface a {
        void e(int i, int i2, int i3, int i4);
    }

    public PullToRefreshBaseWebView(Context context, com.baidu.swan.apps.res.ui.pullrefresh.a<T> aVar, PullToRefreshBase.HEADERTYPE headertype) {
        super(context, aVar, headertype);
        this.apx = false;
    }

    public PullToRefreshBaseWebView(Context context) {
        this(context, null);
    }

    public PullToRefreshBaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apx = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                this.apx = false;
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    protected T createRefreshableView(Context context, AttributeSet attributeSet) {
        return getRefreshableFactory().bz(context);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    protected boolean isReadyForPullDown() {
        if (this.aJa == null) {
            return false;
        }
        if (getScrollYValue() == 0 && this.apx) {
            return false;
        }
        boolean canScrollVertically = ViewCompat.canScrollVertically(this.aJa, -1);
        if (DEBUG) {
            Log.d("PullToRefreshWebView", "isReadyForPullDown result: " + canScrollVertically);
        }
        return !canScrollVertically;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    protected boolean isReadyForPullUp() {
        return false;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.apw != null) {
            this.apw.e(i, i2, i3, i4);
        }
    }

    public void setOnPullToRefreshScrollChangeListener(a aVar) {
        this.apw = aVar;
    }

    public void setIsPreventPullToRefresh(boolean z) {
        this.apx = z;
    }
}
