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
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes8.dex */
public class CommonHeaderLoadingLayout extends LoadingLayout {
    private int dvS;
    private int dvT;
    private int dvU;
    private int dvV;
    private View dvW;
    private RefreshingAnimView dvX;
    private HeaderRefreshIndicator dvY;

    public CommonHeaderLoadingLayout(Context context) {
        super(context);
        this.dvS = 0;
        this.dvX = (RefreshingAnimView) findViewById(a.f.refreshing_anim_view);
        this.dvS = ah.dip2px(getContext(), 29.0f);
        this.dvT = (int) (2.4f * this.dvS);
        this.dvV = (int) (1.5f * this.dvS);
        this.dvU = this.dvV;
        this.dvY = (HeaderRefreshIndicator) findViewById(a.f.refresh_over_tip);
        this.dvY.aea();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.dvW != null ? this.dvW.getHeight() : ah.dip2px(getContext(), 50.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        this.dvW = LayoutInflater.from(context).inflate(a.g.aiapps_common_pull_to_refresh_header, viewGroup, false);
        return this.dvW;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        setTranslationY(0.0f);
        this.dvX.setAlpha(1.0f);
        this.dvX.stopAnim();
        this.dvY.setVisibility(4);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.dvX.setAlpha(1.0f);
        this.dvX.stopAnim();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setHeaderBackgroundResource(int i) {
        super.setHeaderBackgroundResource(i);
        this.dvY.aGO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void aGM() {
        this.dvX.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.dvX.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        this.dvX.aHd();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        return this.dvT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void iA(int i) {
        if (getState() == ILoadingLayout.State.PULL_TO_REFRESH) {
            this.dvX.setAnimPercent(iB(i));
        }
        if (i > this.dvU) {
            setTranslationY((this.dvU - i) / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        return this.dvV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(boolean z, String str, final Runnable runnable) {
        if (z) {
            this.dvX.setAlpha(0.0f);
            if (TextUtils.isEmpty(str)) {
                this.dvY.setText(getResources().getText(a.h.aiapps_pull_down_refresh_success));
            } else {
                this.dvY.setText(str);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(this.dvY.getHeight(), 0);
            ofInt.setDuration(150L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.CommonHeaderLoadingLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CommonHeaderLoadingLayout.this.dvY.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.CommonHeaderLoadingLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    CommonHeaderLoadingLayout.this.dvY.setTranslationY(0.0f);
                    CommonHeaderLoadingLayout.this.dvY.setVisibility(0);
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

    protected float iB(int i) {
        float f;
        if (i < this.dvT) {
            f = i < this.dvS ? 0.0f : (i - this.dvS) / (this.dvT - this.dvS);
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
