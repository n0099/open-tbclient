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
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes10.dex */
public class CommonHeaderLoadingLayout extends LoadingLayout {
    private int dpc;
    private int dpd;
    private int dpe;
    private int dpf;
    private View dpg;
    private RefreshingAnimView dph;
    private HeaderRefreshIndicator dpi;

    public CommonHeaderLoadingLayout(Context context) {
        super(context);
        this.dpc = 0;
        this.dph = (RefreshingAnimView) findViewById(a.f.refreshing_anim_view);
        this.dpc = ah.dip2px(getContext(), 29.0f);
        this.dpd = (int) (2.4f * this.dpc);
        this.dpf = (int) (1.5f * this.dpc);
        this.dpe = this.dpf;
        this.dpi = (HeaderRefreshIndicator) findViewById(a.f.refresh_over_tip);
        this.dpi.adw();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.dpg != null ? this.dpg.getHeight() : ah.dip2px(getContext(), 50.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        this.dpg = LayoutInflater.from(context).inflate(a.g.aiapps_common_pull_to_refresh_header, viewGroup, false);
        return this.dpg;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        setTranslationY(0.0f);
        this.dph.setAlpha(1.0f);
        this.dph.stopAnim();
        this.dpi.setVisibility(4);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.dph.setAlpha(1.0f);
        this.dph.stopAnim();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setHeaderBackgroundResource(int i) {
        super.setHeaderBackgroundResource(i);
        this.dpi.aGx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void aGv() {
        this.dph.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.dph.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        this.dph.aGM();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        return this.dpd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void jN(int i) {
        if (getState() == ILoadingLayout.State.PULL_TO_REFRESH) {
            this.dph.setAnimPercent(jO(i));
        }
        if (i > this.dpe) {
            setTranslationY((this.dpe - i) / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        return this.dpf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(boolean z, String str, final Runnable runnable) {
        if (z) {
            this.dph.setAlpha(0.0f);
            if (TextUtils.isEmpty(str)) {
                this.dpi.setText(getResources().getText(a.h.aiapps_pull_down_refresh_success));
            } else {
                this.dpi.setText(str);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(this.dpi.getHeight(), 0);
            ofInt.setDuration(150L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.CommonHeaderLoadingLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CommonHeaderLoadingLayout.this.dpi.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.CommonHeaderLoadingLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    CommonHeaderLoadingLayout.this.dpi.setTranslationY(0.0f);
                    CommonHeaderLoadingLayout.this.dpi.setVisibility(0);
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

    protected float jO(int i) {
        float f;
        if (i < this.dpd) {
            f = i < this.dpc ? 0.0f : (i - this.dpc) / (this.dpd - this.dpc);
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
