package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import d.b.h0.a.f;
import d.b.h0.a.g;
import d.b.h0.a.i2.h0;
import d.b.h0.a.k;
/* loaded from: classes3.dex */
public class NeutralHeaderLoadingLayout extends LoadingLayout {
    public static final boolean n = k.f45772a;

    /* renamed from: h  reason: collision with root package name */
    public int f12204h;
    public int i;
    public int j;
    public int k;
    public View l;
    public NeutralRefreshAnimView m;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f12205e;

        public a(Runnable runnable) {
            this.f12205e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12205e.run();
        }
    }

    public NeutralHeaderLoadingLayout(Context context) {
        super(context);
        this.f12204h = 0;
        o();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(getContext()).inflate(g.aiapps_neutral_pull_to_refresh_header, viewGroup, false);
        this.l = inflate;
        return inflate;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void e(int i) {
        if (n) {
            Log.e("NeutralLoadingLayout", "pullLength = " + i);
        }
        if (getState() == ILoadingLayout$State.PULL_TO_REFRESH) {
            this.m.setAnimPercent(n(i));
        }
        int i2 = this.j;
        if (i > i2) {
            setTranslationY((i2 - i) / 2);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void f(boolean z, String str, Runnable runnable) {
        if (n) {
            Log.e("NeutralLoadingLayout", "onPullRefreshComplete");
        }
        this.m.A();
        if (n) {
            Log.e("NeutralLoadingLayout", "current thread name:" + Thread.currentThread().getName());
        }
        this.m.q();
        post(new a(runnable));
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        if (n) {
            Log.e("NeutralLoadingLayout", "onPullToRefresh");
        }
        this.m.setAlpha(1.0f);
        this.m.A();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        return this.i;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        View view = this.l;
        if (view != null) {
            return view.getHeight();
        }
        return h0.e(getContext(), 50.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        return this.k;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void h() {
        if (n) {
            Log.e("NeutralLoadingLayout", "onRefreshing");
        }
        this.m.r();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void i() {
        if (n) {
            Log.e("NeutralLoadingLayout", "onReleaseToLongRefresh");
        }
        this.m.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        if (n) {
            Log.e("NeutralLoadingLayout", "onReleaseToRefresh");
        }
        this.m.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        if (n) {
            Log.e("NeutralLoadingLayout", "onReset");
        }
        this.m.A();
        this.m.setAlpha(1.0f);
        setTranslationY(0.0f);
    }

    public float n(int i) {
        float f2;
        int i2 = this.i;
        if (i < i2) {
            int i3 = this.f12204h;
            f2 = i < i3 ? 0.0f : (i - i3) / (i2 - i3);
        } else {
            f2 = 1.0f;
        }
        float f3 = f2 >= 0.0f ? f2 : 0.0f;
        if (f3 > 1.0f) {
            return 1.0f;
        }
        return f3;
    }

    public final void o() {
        this.m = (NeutralRefreshAnimView) findViewById(f.neutral_refresh_anim_view);
        int e2 = h0.e(getContext(), 29.0f);
        this.f12204h = e2;
        this.i = (int) (e2 * 2.4f);
        int i = (int) (e2 * 1.5f);
        this.k = i;
        this.j = i;
        if (n) {
            Log.e("NeutralLoadingLayout", "mRefreshingViewSizeInPixel" + this.f12204h);
            Log.e("NeutralLoadingLayout", "mTriggerRefreshLength" + this.i);
            Log.e("NeutralLoadingLayout", "mRefreshingHeight" + this.k);
            Log.e("NeutralLoadingLayout", "mScrollStartLength" + this.j);
        }
    }

    public boolean p(int i) {
        NeutralRefreshAnimView neutralRefreshAnimView = this.m;
        if (neutralRefreshAnimView == null) {
            return false;
        }
        neutralRefreshAnimView.z(i);
        return true;
    }
}
