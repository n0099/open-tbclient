package com.baidu.swan.apps.core.container;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.tieba.am1;
import com.baidu.tieba.b43;
import com.baidu.tieba.hk4;
/* loaded from: classes4.dex */
public class PullToRefreshBaseWebView<T extends View> extends PullToRefreshBase<T> {
    public static final boolean y = am1.a;
    public a w;
    public boolean x;

    /* loaded from: classes4.dex */
    public interface a {
        void b(int i, int i2, int i3, int i4);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public boolean u() {
        return false;
    }

    public boolean N() {
        return this.x;
    }

    public PullToRefreshBaseWebView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            this.x = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setIsPreventPullToRefresh(boolean z) {
        this.x = z;
    }

    public void setOnPullToRefreshScrollChangeListener(a aVar) {
        this.w = aVar;
    }

    public PullToRefreshBaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = false;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public T j(Context context, AttributeSet attributeSet) {
        return getRefreshableFactory().createRefreshableView(context);
    }

    public PullToRefreshBaseWebView(Context context, b43<T> b43Var, PullToRefreshBase.HEADERTYPE headertype) {
        super(context, b43Var, headertype);
        this.x = false;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        a aVar = this.w;
        if (aVar != null) {
            aVar.b(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public boolean t() {
        if (this.p == null) {
            return false;
        }
        if (getScrollYValue() == 0 && this.x) {
            return false;
        }
        boolean a2 = hk4.a(this.p, -1);
        if (y) {
            Log.d("PullToRefreshWebView", "isReadyForPullDown result: " + a2);
        }
        return !a2;
    }
}
