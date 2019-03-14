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
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes2.dex */
public class CommonHeaderLoadingLayout extends LoadingLayout {
    private int aHR;
    private int aHS;
    private int aHT;
    private int aHU;
    private View aHV;
    private RefreshingAnimView aHW;
    private HeaderRefreshIndicator aHX;

    public CommonHeaderLoadingLayout(Context context) {
        super(context);
        this.aHR = 0;
        this.aHW = (RefreshingAnimView) findViewById(a.f.refreshing_anim_view);
        this.aHR = x.dip2px(getContext(), 29.0f);
        this.aHS = (int) (2.4f * this.aHR);
        this.aHU = (int) (1.5f * this.aHR);
        this.aHT = this.aHU;
        this.aHX = (HeaderRefreshIndicator) findViewById(a.f.refresh_over_tip);
        this.aHX.uf();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.aHV != null ? this.aHV.getHeight() : x.dip2px(getContext(), 50.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        this.aHV = LayoutInflater.from(context).inflate(a.g.aiapps_common_pull_to_refresh_header, viewGroup, false);
        return this.aHV;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        setTranslationY(0.0f);
        this.aHW.setAlpha(1.0f);
        this.aHW.stopAnim();
        this.aHX.setVisibility(4);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.aHW.setAlpha(1.0f);
        this.aHW.stopAnim();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setHeaderBackgroundResource(int i) {
        super.setHeaderBackgroundResource(i);
        this.aHX.Ho();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void Hm() {
        this.aHW.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.aHW.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        this.aHW.HD();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        return this.aHS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void cR(int i) {
        if (getState() == ILoadingLayout.State.PULL_TO_REFRESH) {
            this.aHW.setAnimPercent(cS(i));
        }
        if (i > this.aHT) {
            setTranslationY((this.aHT - i) / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        return this.aHU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(boolean z, String str, final Runnable runnable) {
        if (z) {
            this.aHW.setAlpha(0.0f);
            if (TextUtils.isEmpty(str)) {
                this.aHX.setText(getResources().getText(a.h.aiapps_pull_down_refresh_success));
            } else {
                this.aHX.setText(str);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(this.aHX.getHeight(), 0);
            ofInt.setDuration(150L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.CommonHeaderLoadingLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CommonHeaderLoadingLayout.this.aHX.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.CommonHeaderLoadingLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    CommonHeaderLoadingLayout.this.aHX.setTranslationY(0.0f);
                    CommonHeaderLoadingLayout.this.aHX.setVisibility(0);
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

    protected float cS(int i) {
        float f;
        if (i < this.aHS) {
            f = i < this.aHR ? 0.0f : (i - this.aHR) / (this.aHS - this.aHR);
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
