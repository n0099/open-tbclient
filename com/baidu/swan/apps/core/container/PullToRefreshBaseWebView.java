package com.baidu.swan.apps.core.container;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import d.b.g0.a.k;
import d.b.g0.m.a.d.f;
/* loaded from: classes2.dex */
public class PullToRefreshBaseWebView<T extends View> extends PullToRefreshBase<T> {
    public static final boolean B = k.f45051a;
    public boolean A;
    public a z;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, int i2, int i3, int i4);
    }

    public PullToRefreshBaseWebView(Context context, d.b.g0.a.q1.a.e.a<T> aVar, PullToRefreshBase.HEADERTYPE headertype) {
        super(context, aVar, headertype);
        this.A = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            this.A = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public T j(Context context, AttributeSet attributeSet) {
        return getRefreshableFactory().G(context);
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        a aVar = this.z;
        if (aVar != null) {
            aVar.a(i, i2, i3, i4);
        }
    }

    public void setIsPreventPullToRefresh(boolean z) {
        this.A = z;
    }

    public void setOnPullToRefreshScrollChangeListener(a aVar) {
        this.z = aVar;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public boolean t() {
        if (this.t == null) {
            return false;
        }
        if (getScrollYValue() == 0 && this.A) {
            return false;
        }
        boolean a2 = f.a(this.t, -1);
        if (B) {
            Log.d("PullToRefreshWebView", "isReadyForPullDown result: " + a2);
        }
        return !a2;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public boolean u() {
        return false;
    }

    public PullToRefreshBaseWebView(Context context) {
        this(context, null);
    }

    public PullToRefreshBaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A = false;
    }
}
