package com.baidu.swan.apps.core.container;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import d.a.l0.a.k;
import d.a.l0.o.a.d.f;
/* loaded from: classes2.dex */
public class PullToRefreshBaseWebView<T extends View> extends PullToRefreshBase<T> {
    public static final boolean C = k.f43199a;
    public a A;
    public boolean B;

    /* loaded from: classes2.dex */
    public interface a {
        void b(int i2, int i3, int i4, int i5);
    }

    public PullToRefreshBaseWebView(Context context, d.a.l0.a.z1.a.d.a<T> aVar, PullToRefreshBase.HEADERTYPE headertype) {
        super(context, aVar, headertype);
        this.B = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            this.B = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public T j(Context context, AttributeSet attributeSet) {
        return getRefreshableFactory().T(context);
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a aVar = this.A;
        if (aVar != null) {
            aVar.b(i2, i3, i4, i5);
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setIsPreventPullToRefresh(boolean z) {
        this.B = z;
    }

    public void setOnPullToRefreshScrollChangeListener(a aVar) {
        this.A = aVar;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public boolean t() {
        if (this.t == null) {
            return false;
        }
        if (getScrollYValue() == 0 && this.B) {
            return false;
        }
        boolean a2 = f.a(this.t, -1);
        if (C) {
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
        this.B = false;
    }
}
