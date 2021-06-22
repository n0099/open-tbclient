package com.baidu.swan.apps.res.ui.pullrefresh;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import d.a.m0.a.f;
import d.a.m0.a.g;
import d.a.m0.a.h;
import d.a.m0.a.v2.n0;
/* loaded from: classes3.dex */
public class CommonHeaderLoadingLayout extends LoadingLayout {

    /* renamed from: i  reason: collision with root package name */
    public int f11283i;
    public int j;
    public int k;
    public int l;
    public View m;
    public RefreshingAnimView n;
    public HeaderRefreshIndicator o;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CommonHeaderLoadingLayout.this.o.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f11285e;

        public b(Runnable runnable) {
            this.f11285e = runnable;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            CommonHeaderLoadingLayout.this.postDelayed(this.f11285e, 800L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            CommonHeaderLoadingLayout.this.o.setTranslationY(0.0f);
            CommonHeaderLoadingLayout.this.o.setVisibility(0);
        }
    }

    public CommonHeaderLoadingLayout(Context context) {
        super(context);
        this.f11283i = 0;
        this.n = (RefreshingAnimView) findViewById(f.refreshing_anim_view);
        int f2 = n0.f(getContext(), 29.0f);
        this.f11283i = f2;
        this.j = (int) (f2 * 2.4f);
        int i2 = (int) (f2 * 1.5f);
        this.l = i2;
        this.k = i2;
        HeaderRefreshIndicator headerRefreshIndicator = (HeaderRefreshIndicator) findViewById(f.refresh_over_tip);
        this.o = headerRefreshIndicator;
        headerRefreshIndicator.i();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(g.aiapps_common_pull_to_refresh_header, viewGroup, false);
        this.m = inflate;
        return inflate;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void e(int i2) {
        if (getState() == ILoadingLayout$State.PULL_TO_REFRESH) {
            this.n.setAnimPercent(o(i2));
        }
        int i3 = this.k;
        if (i2 > i3) {
            setTranslationY((i3 - i2) / 2);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void f(boolean z, String str, Runnable runnable) {
        if (z) {
            this.n.setAlpha(0.0f);
            if (TextUtils.isEmpty(str)) {
                this.o.setText(getResources().getText(h.aiapps_pull_down_refresh_success));
            } else {
                this.o.setText(str);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(this.o.getHeight(), 0);
            ofInt.setDuration(150L);
            ofInt.addUpdateListener(new a());
            ofInt.addListener(new b(runnable));
            ofInt.start();
            return;
        }
        setState(ILoadingLayout$State.PULL_TO_REFRESH);
        runnable.run();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        this.n.setAlpha(1.0f);
        this.n.t();
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
        this.n.r();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void i() {
        this.n.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        this.n.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        setTranslationY(0.0f);
        this.n.setAlpha(1.0f);
        this.n.t();
        this.o.setVisibility(4);
    }

    public float o(int i2) {
        float f2;
        int i3 = this.j;
        if (i2 < i3) {
            int i4 = this.f11283i;
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

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setHeaderBackgroundResource(int i2) {
        super.setHeaderBackgroundResource(i2);
        this.o.j();
    }
}
