package com.baidu.swan.apps.core.container;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.swan.support.v4.c.f;
/* loaded from: classes10.dex */
public class PullToRefreshBaseWebView<T extends View> extends PullToRefreshBase<T> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a cJh;
    private boolean cJi;

    /* loaded from: classes10.dex */
    public interface a {
        void i(int i, int i2, int i3, int i4);
    }

    public PullToRefreshBaseWebView(Context context, com.baidu.swan.apps.res.ui.pullrefresh.a<T> aVar, PullToRefreshBase.HEADERTYPE headertype) {
        super(context, aVar, headertype);
        this.cJi = false;
    }

    public PullToRefreshBaseWebView(Context context) {
        this(context, null);
    }

    public PullToRefreshBaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cJi = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                this.cJi = false;
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    protected T createRefreshableView(Context context, AttributeSet attributeSet) {
        return getRefreshableFactory().bW(context);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    protected boolean isReadyForPullDown() {
        if (this.dqi == null) {
            return false;
        }
        if (getScrollYValue() == 0 && this.cJi) {
            return false;
        }
        boolean canScrollVertically = f.canScrollVertically(this.dqi, -1);
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
        if (this.cJh != null) {
            this.cJh.i(i, i2, i3, i4);
        }
    }

    public void setOnPullToRefreshScrollChangeListener(a aVar) {
        this.cJh = aVar;
    }

    public void setIsPreventPullToRefresh(boolean z) {
        this.cJi = z;
    }
}
