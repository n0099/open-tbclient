package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes10.dex */
public class NeutralHeaderLoadingLayout extends LoadingLayout {
    private static final boolean DEBUG = b.DEBUG;
    private NeutralRefreshAnimView bHH;
    private int bHo;
    private int bHp;
    private int bHq;
    private int bHr;
    private View bHs;

    public NeutralHeaderLoadingLayout(Context context) {
        super(context);
        this.bHo = 0;
        init();
    }

    private void init() {
        this.bHH = (NeutralRefreshAnimView) findViewById(a.f.neutral_refresh_anim_view);
        this.bHo = af.dip2px(getContext(), 29.0f);
        this.bHp = (int) (2.4f * this.bHo);
        this.bHr = (int) (1.5f * this.bHo);
        this.bHq = this.bHr;
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "mRefreshingViewSizeInPixel" + this.bHo);
            Log.e("NeutralLoadingLayout", "mTriggerRefreshLength" + this.bHp);
            Log.e("NeutralLoadingLayout", "mRefreshingHeight" + this.bHr);
            Log.e("NeutralLoadingLayout", "mScrollStartLength" + this.bHq);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.bHs != null ? this.bHs.getHeight() : af.dip2px(getContext(), 50.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        this.bHs = LayoutInflater.from(getContext()).inflate(a.g.aiapps_neutral_pull_to_refresh_header, viewGroup, false);
        return this.bHs;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onReset");
        }
        this.bHH.stopAnim();
        this.bHH.setAlpha(1.0f);
        setTranslationY(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void ft(int i) {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "pullLength = " + i);
        }
        if (getState() == ILoadingLayout.State.PULL_TO_REFRESH) {
            this.bHH.setAnimPercent(fu(i));
        }
        if (i > this.bHq) {
            setTranslationY((this.bHq - i) / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(boolean z, String str, final Runnable runnable) {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onPullRefreshComplete");
        }
        this.bHH.stopAnim();
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "current thread name:" + Thread.currentThread().getName());
        }
        this.bHH.ZC();
        post(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralHeaderLoadingLayout.1
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void Zw() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onReleaseToLongRefresh");
        }
        this.bHH.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onReleaseToRefresh");
        }
        this.bHH.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onPullToRefresh");
        }
        this.bHH.setAlpha(1.0f);
        this.bHH.stopAnim();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        return this.bHr;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        return this.bHp;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onRefreshing");
        }
        this.bHH.ZA();
    }

    protected float fu(int i) {
        float f;
        if (i < this.bHp) {
            f = i < this.bHo ? 0.0f : (i - this.bHo) / (this.bHp - this.bHo);
        } else {
            f = 1.0f;
        }
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    public boolean dG(int i) {
        if (this.bHH == null) {
            return false;
        }
        this.bHH.dG(i);
        return true;
    }
}
