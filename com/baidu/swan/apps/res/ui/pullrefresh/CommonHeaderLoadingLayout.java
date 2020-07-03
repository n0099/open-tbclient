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
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes11.dex */
public class CommonHeaderLoadingLayout extends LoadingLayout {
    private int cAL;
    private int cAM;
    private int cAN;
    private int cAO;
    private View cAP;
    private RefreshingAnimView cAQ;
    private HeaderRefreshIndicator cAR;

    public CommonHeaderLoadingLayout(Context context) {
        super(context);
        this.cAL = 0;
        this.cAQ = (RefreshingAnimView) findViewById(a.f.refreshing_anim_view);
        this.cAL = ag.dip2px(getContext(), 29.0f);
        this.cAM = (int) (2.4f * this.cAL);
        this.cAO = (int) (1.5f * this.cAL);
        this.cAN = this.cAO;
        this.cAR = (HeaderRefreshIndicator) findViewById(a.f.refresh_over_tip);
        this.cAR.Qn();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.cAP != null ? this.cAP.getHeight() : ag.dip2px(getContext(), 50.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        this.cAP = LayoutInflater.from(context).inflate(a.g.aiapps_common_pull_to_refresh_header, viewGroup, false);
        return this.cAP;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        setTranslationY(0.0f);
        this.cAQ.setAlpha(1.0f);
        this.cAQ.stopAnim();
        this.cAR.setVisibility(4);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.cAQ.setAlpha(1.0f);
        this.cAQ.stopAnim();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setHeaderBackgroundResource(int i) {
        super.setHeaderBackgroundResource(i);
        this.cAR.aoP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void aoN() {
        this.cAQ.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.cAQ.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        this.cAQ.ape();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        return this.cAM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void gv(int i) {
        if (getState() == ILoadingLayout.State.PULL_TO_REFRESH) {
            this.cAQ.setAnimPercent(gw(i));
        }
        if (i > this.cAN) {
            setTranslationY((this.cAN - i) / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        return this.cAO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(boolean z, String str, final Runnable runnable) {
        if (z) {
            this.cAQ.setAlpha(0.0f);
            if (TextUtils.isEmpty(str)) {
                this.cAR.setText(getResources().getText(a.h.aiapps_pull_down_refresh_success));
            } else {
                this.cAR.setText(str);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(this.cAR.getHeight(), 0);
            ofInt.setDuration(150L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.CommonHeaderLoadingLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CommonHeaderLoadingLayout.this.cAR.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.CommonHeaderLoadingLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    CommonHeaderLoadingLayout.this.cAR.setTranslationY(0.0f);
                    CommonHeaderLoadingLayout.this.cAR.setVisibility(0);
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

    protected float gw(int i) {
        float f;
        if (i < this.cAM) {
            f = i < this.cAL ? 0.0f : (i - this.cAL) / (this.cAM - this.cAL);
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
