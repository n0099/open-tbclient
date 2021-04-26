package com.baidu.swan.apps.res.ui.pullrefresh;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import d.a.h0.a.f;
import d.a.h0.a.g;
import d.a.h0.a.h;
import d.a.h0.a.i2.h0;
/* loaded from: classes3.dex */
public class CommonHeaderLoadingLayout extends LoadingLayout {

    /* renamed from: h  reason: collision with root package name */
    public int f12045h;

    /* renamed from: i  reason: collision with root package name */
    public int f12046i;
    public int j;
    public int k;
    public View l;
    public RefreshingAnimView m;
    public HeaderRefreshIndicator n;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CommonHeaderLoadingLayout.this.n.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f12048e;

        public b(Runnable runnable) {
            this.f12048e = runnable;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            CommonHeaderLoadingLayout.this.postDelayed(this.f12048e, 800L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            CommonHeaderLoadingLayout.this.n.setTranslationY(0.0f);
            CommonHeaderLoadingLayout.this.n.setVisibility(0);
        }
    }

    public CommonHeaderLoadingLayout(Context context) {
        super(context);
        this.f12045h = 0;
        this.m = (RefreshingAnimView) findViewById(f.refreshing_anim_view);
        int e2 = h0.e(getContext(), 29.0f);
        this.f12045h = e2;
        this.f12046i = (int) (e2 * 2.4f);
        int i2 = (int) (e2 * 1.5f);
        this.k = i2;
        this.j = i2;
        HeaderRefreshIndicator headerRefreshIndicator = (HeaderRefreshIndicator) findViewById(f.refresh_over_tip);
        this.n = headerRefreshIndicator;
        headerRefreshIndicator.i();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(g.aiapps_common_pull_to_refresh_header, viewGroup, false);
        this.l = inflate;
        return inflate;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void e(int i2) {
        if (getState() == ILoadingLayout$State.PULL_TO_REFRESH) {
            this.m.setAnimPercent(o(i2));
        }
        int i3 = this.j;
        if (i2 > i3) {
            setTranslationY((i3 - i2) / 2);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void f(boolean z, String str, Runnable runnable) {
        if (z) {
            this.m.setAlpha(0.0f);
            if (TextUtils.isEmpty(str)) {
                this.n.setText(getResources().getText(h.aiapps_pull_down_refresh_success));
            } else {
                this.n.setText(str);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(this.n.getHeight(), 0);
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
        this.m.setAlpha(1.0f);
        this.m.t();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        return this.f12046i;
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
        this.m.r();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void i() {
        this.m.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        this.m.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        setTranslationY(0.0f);
        this.m.setAlpha(1.0f);
        this.m.t();
        this.n.setVisibility(4);
    }

    public float o(int i2) {
        float f2;
        int i3 = this.f12046i;
        if (i2 < i3) {
            int i4 = this.f12045h;
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
        this.n.j();
    }
}
