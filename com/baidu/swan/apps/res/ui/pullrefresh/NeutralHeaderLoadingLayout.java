package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.baidu.tieba.dn3;
import com.baidu.tieba.wp1;
/* loaded from: classes3.dex */
public class NeutralHeaderLoadingLayout extends LoadingLayout {
    public static final boolean k = wp1.a;
    public int e;
    public int f;
    public int g;
    public int h;
    public View i;
    public NeutralRefreshAnimView j;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.run();
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        if (k) {
            Log.e("NeutralLoadingLayout", "onPullToRefresh");
        }
        this.j.setAlpha(1.0f);
        this.j.A();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        return this.f;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        View view2 = this.i;
        if (view2 != null) {
            return view2.getHeight();
        }
        return dn3.f(getContext(), 50.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        return this.h;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void h() {
        if (k) {
            Log.e("NeutralLoadingLayout", "onRefreshing");
        }
        this.j.r();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void i() {
        if (k) {
            Log.e("NeutralLoadingLayout", "onReleaseToLongRefresh");
        }
        this.j.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        if (k) {
            Log.e("NeutralLoadingLayout", "onReleaseToRefresh");
        }
        this.j.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        if (k) {
            Log.e("NeutralLoadingLayout", "onReset");
        }
        this.j.A();
        this.j.setAlpha(1.0f);
        setTranslationY(0.0f);
    }

    public NeutralHeaderLoadingLayout(Context context) {
        super(context);
        this.e = 0;
        o();
    }

    public float n(int i) {
        float f;
        int i2 = this.f;
        float f2 = 0.0f;
        if (i < i2) {
            int i3 = this.e;
            if (i < i3) {
                f = 0.0f;
            } else {
                f = (i - i3) / (i2 - i3);
            }
        } else {
            f = 1.0f;
        }
        if (f >= 0.0f) {
            f2 = f;
        }
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    public boolean p(int i) {
        NeutralRefreshAnimView neutralRefreshAnimView = this.j;
        if (neutralRefreshAnimView == null) {
            return false;
        }
        neutralRefreshAnimView.z(i);
        return true;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d00bf, viewGroup, false);
        this.i = inflate;
        return inflate;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void e(int i) {
        if (k) {
            Log.e("NeutralLoadingLayout", "pullLength = " + i);
        }
        if (getState() == ILoadingLayout$State.PULL_TO_REFRESH) {
            this.j.setAnimPercent(n(i));
        }
        int i2 = this.g;
        if (i > i2) {
            setTranslationY((i2 - i) / 2);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void f(boolean z, String str, Runnable runnable) {
        if (k) {
            Log.e("NeutralLoadingLayout", "onPullRefreshComplete");
        }
        this.j.A();
        if (k) {
            Log.e("NeutralLoadingLayout", "current thread name:" + Thread.currentThread().getName());
        }
        this.j.q();
        post(new a(runnable));
    }

    public final void o() {
        this.j = (NeutralRefreshAnimView) findViewById(R.id.obfuscated_res_0x7f0917cd);
        int f = dn3.f(getContext(), 29.0f);
        this.e = f;
        this.f = (int) (f * 2.4f);
        int i = (int) (f * 1.5f);
        this.h = i;
        this.g = i;
        if (k) {
            Log.e("NeutralLoadingLayout", "mRefreshingViewSizeInPixel" + this.e);
            Log.e("NeutralLoadingLayout", "mTriggerRefreshLength" + this.f);
            Log.e("NeutralLoadingLayout", "mRefreshingHeight" + this.h);
            Log.e("NeutralLoadingLayout", "mScrollStartLength" + this.g);
        }
    }
}
