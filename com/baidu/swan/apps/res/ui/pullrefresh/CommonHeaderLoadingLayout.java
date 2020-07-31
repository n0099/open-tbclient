package com.baidu.swan.apps.res.ui.pullrefresh;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes7.dex */
public class CommonHeaderLoadingLayout extends LoadingLayout {
    private int cDA;
    private int cDB;
    private View cDC;
    private RefreshingAnimView cDD;
    private HeaderRefreshIndicator cDE;
    private int cDy;
    private int cDz;

    public CommonHeaderLoadingLayout(Context context) {
        super(context);
        this.cDy = 0;
        this.cDD = (RefreshingAnimView) findViewById(a.f.refreshing_anim_view);
        this.cDy = ai.dip2px(getContext(), 29.0f);
        this.cDz = (int) (2.4f * this.cDy);
        this.cDB = (int) (1.5f * this.cDy);
        this.cDA = this.cDB;
        this.cDE = (HeaderRefreshIndicator) findViewById(a.f.refresh_over_tip);
        this.cDE.QC();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.cDC != null ? this.cDC.getHeight() : ai.dip2px(getContext(), 50.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        this.cDC = LayoutInflater.from(context).inflate(a.g.aiapps_common_pull_to_refresh_header, viewGroup, false);
        return this.cDC;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        setTranslationY(0.0f);
        this.cDD.setAlpha(1.0f);
        this.cDD.stopAnim();
        this.cDE.setVisibility(4);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.cDD.setAlpha(1.0f);
        this.cDD.stopAnim();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setHeaderBackgroundResource(int i) {
        super.setHeaderBackgroundResource(i);
        this.cDE.aqz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void aqx() {
        this.cDD.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.cDD.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        this.cDD.aqO();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        return this.cDz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void gE(int i) {
        if (getState() == ILoadingLayout.State.PULL_TO_REFRESH) {
            this.cDD.setAnimPercent(gF(i));
        }
        if (i > this.cDA) {
            setTranslationY((this.cDA - i) / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        return this.cDB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(boolean z, String str, final Runnable runnable) {
        if (z) {
            this.cDD.setAlpha(0.0f);
            if (TextUtils.isEmpty(str)) {
                this.cDE.setText(getResources().getText(a.h.aiapps_pull_down_refresh_success));
            } else {
                this.cDE.setText(str);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(this.cDE.getHeight(), 0);
            ofInt.setDuration(150L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.CommonHeaderLoadingLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CommonHeaderLoadingLayout.this.cDE.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.CommonHeaderLoadingLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    CommonHeaderLoadingLayout.this.cDE.setTranslationY(0.0f);
                    CommonHeaderLoadingLayout.this.cDE.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    CommonHeaderLoadingLayout.this.postDelayed(runnable, 800L);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofInt.start();
            return;
        }
        setState(ILoadingLayout.State.PULL_TO_REFRESH);
        runnable.run();
    }

    protected float gF(int i) {
        float f;
        if (i < this.cDz) {
            f = i < this.cDy ? 0.0f : (i - this.cDy) / (this.cDz - this.cDy);
        } else {
            f = 1.0f;
        }
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }
}
