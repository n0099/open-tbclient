package com.baidu.swan.apps.res.ui.pullrefresh;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.baidu.tieba.xo3;
/* loaded from: classes4.dex */
public class CommonHeaderLoadingLayout extends LoadingLayout {
    public int e;
    public int f;
    public int g;
    public int h;
    public View i;
    public RefreshingAnimView j;
    public HeaderRefreshIndicator k;

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CommonHeaderLoadingLayout.this.k.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        public final /* synthetic */ Runnable a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        public b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            CommonHeaderLoadingLayout.this.postDelayed(this.a, 800L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            CommonHeaderLoadingLayout.this.k.setTranslationY(0.0f);
            CommonHeaderLoadingLayout.this.k.setVisibility(0);
        }
    }

    public CommonHeaderLoadingLayout(Context context) {
        super(context);
        this.e = 0;
        this.j = (RefreshingAnimView) findViewById(R.id.obfuscated_res_0x7f091eb0);
        int f = xo3.f(getContext(), 29.0f);
        this.e = f;
        this.f = (int) (f * 2.4f);
        int i = (int) (f * 1.5f);
        this.h = i;
        this.g = i;
        HeaderRefreshIndicator headerRefreshIndicator = (HeaderRefreshIndicator) findViewById(R.id.obfuscated_res_0x7f091ead);
        this.k = headerRefreshIndicator;
        headerRefreshIndicator.i();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void e(int i) {
        if (getState() == ILoadingLayout$State.PULL_TO_REFRESH) {
            this.j.setAnimPercent(o(i));
        }
        int i2 = this.g;
        if (i > i2) {
            setTranslationY((i2 - i) / 2);
        }
    }

    public float o(int i) {
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

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setHeaderBackgroundResource(int i) {
        super.setHeaderBackgroundResource(i);
        this.k.j();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00a6, viewGroup, false);
        this.i = inflate;
        return inflate;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void f(boolean z, String str, Runnable runnable) {
        if (z) {
            this.j.setAlpha(0.0f);
            if (TextUtils.isEmpty(str)) {
                this.k.setText(getResources().getText(R.string.obfuscated_res_0x7f0f01dc));
            } else {
                this.k.setText(str);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(this.k.getHeight(), 0);
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
        this.j.setAlpha(1.0f);
        this.j.t();
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
        return xo3.f(getContext(), 50.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        return this.h;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void h() {
        this.j.r();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void i() {
        this.j.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        this.j.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        setTranslationY(0.0f);
        this.j.setAlpha(1.0f);
        this.j.t();
        this.k.setVisibility(4);
    }
}
