package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import d.a.m0.a.f;
import d.a.m0.a.g;
import d.a.m0.a.k;
import d.a.m0.a.v2.n0;
/* loaded from: classes3.dex */
public class NeutralHeaderLoadingLayout extends LoadingLayout {
    public static final boolean o = k.f46983a;

    /* renamed from: i  reason: collision with root package name */
    public int f11300i;
    public int j;
    public int k;
    public int l;
    public View m;
    public NeutralRefreshAnimView n;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f11301e;

        public a(Runnable runnable) {
            this.f11301e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11301e.run();
        }
    }

    public NeutralHeaderLoadingLayout(Context context) {
        super(context);
        this.f11300i = 0;
        o();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(getContext()).inflate(g.aiapps_neutral_pull_to_refresh_header, viewGroup, false);
        this.m = inflate;
        return inflate;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void e(int i2) {
        if (o) {
            Log.e("NeutralLoadingLayout", "pullLength = " + i2);
        }
        if (getState() == ILoadingLayout$State.PULL_TO_REFRESH) {
            this.n.setAnimPercent(n(i2));
        }
        int i3 = this.k;
        if (i2 > i3) {
            setTranslationY((i3 - i2) / 2);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void f(boolean z, String str, Runnable runnable) {
        if (o) {
            Log.e("NeutralLoadingLayout", "onPullRefreshComplete");
        }
        this.n.A();
        if (o) {
            Log.e("NeutralLoadingLayout", "current thread name:" + Thread.currentThread().getName());
        }
        this.n.q();
        post(new a(runnable));
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        if (o) {
            Log.e("NeutralLoadingLayout", "onPullToRefresh");
        }
        this.n.setAlpha(1.0f);
        this.n.A();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        return this.j;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        View view = this.m;
        if (view != null) {
            return view.getHeight();
        }
        return n0.f(getContext(), 50.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        return this.l;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void h() {
        if (o) {
            Log.e("NeutralLoadingLayout", "onRefreshing");
        }
        this.n.r();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void i() {
        if (o) {
            Log.e("NeutralLoadingLayout", "onReleaseToLongRefresh");
        }
        this.n.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        if (o) {
            Log.e("NeutralLoadingLayout", "onReleaseToRefresh");
        }
        this.n.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        if (o) {
            Log.e("NeutralLoadingLayout", "onReset");
        }
        this.n.A();
        this.n.setAlpha(1.0f);
        setTranslationY(0.0f);
    }

    public float n(int i2) {
        float f2;
        int i3 = this.j;
        if (i2 < i3) {
            int i4 = this.f11300i;
            f2 = i2 < i4 ? 0.0f : (i2 - i4) / (i3 - i4);
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
        this.n = (NeutralRefreshAnimView) findViewById(f.neutral_refresh_anim_view);
        int f2 = n0.f(getContext(), 29.0f);
        this.f11300i = f2;
        this.j = (int) (f2 * 2.4f);
        int i2 = (int) (f2 * 1.5f);
        this.l = i2;
        this.k = i2;
        if (o) {
            Log.e("NeutralLoadingLayout", "mRefreshingViewSizeInPixel" + this.f11300i);
            Log.e("NeutralLoadingLayout", "mTriggerRefreshLength" + this.j);
            Log.e("NeutralLoadingLayout", "mRefreshingHeight" + this.l);
            Log.e("NeutralLoadingLayout", "mScrollStartLength" + this.k);
        }
    }

    public boolean p(int i2) {
        NeutralRefreshAnimView neutralRefreshAnimView = this.n;
        if (neutralRefreshAnimView == null) {
            return false;
        }
        neutralRefreshAnimView.z(i2);
        return true;
    }
}
