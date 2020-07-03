package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes11.dex */
public class NeutralHeaderLoadingLayout extends LoadingLayout {
    private static final boolean DEBUG = b.DEBUG;
    private int cAL;
    private int cAM;
    private int cAN;
    private int cAO;
    private View cAP;
    private NeutralRefreshAnimView cBd;

    public NeutralHeaderLoadingLayout(Context context) {
        super(context);
        this.cAL = 0;
        init();
    }

    private void init() {
        this.cBd = (NeutralRefreshAnimView) findViewById(a.f.neutral_refresh_anim_view);
        this.cAL = ag.dip2px(getContext(), 29.0f);
        this.cAM = (int) (2.4f * this.cAL);
        this.cAO = (int) (1.5f * this.cAL);
        this.cAN = this.cAO;
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "mRefreshingViewSizeInPixel" + this.cAL);
            Log.e("NeutralLoadingLayout", "mTriggerRefreshLength" + this.cAM);
            Log.e("NeutralLoadingLayout", "mRefreshingHeight" + this.cAO);
            Log.e("NeutralLoadingLayout", "mScrollStartLength" + this.cAN);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.cAP != null ? this.cAP.getHeight() : ag.dip2px(getContext(), 50.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        this.cAP = LayoutInflater.from(getContext()).inflate(a.g.aiapps_neutral_pull_to_refresh_header, viewGroup, false);
        return this.cAP;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onReset");
        }
        this.cBd.stopAnim();
        this.cBd.setAlpha(1.0f);
        setTranslationY(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void gv(int i) {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "pullLength = " + i);
        }
        if (getState() == ILoadingLayout.State.PULL_TO_REFRESH) {
            this.cBd.setAnimPercent(gw(i));
        }
        if (i > this.cAN) {
            setTranslationY((this.cAN - i) / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(boolean z, String str, final Runnable runnable) {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onPullRefreshComplete");
        }
        this.cBd.stopAnim();
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "current thread name:" + Thread.currentThread().getName());
        }
        this.cBd.aoT();
        post(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralHeaderLoadingLayout.1
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void aoN() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onReleaseToLongRefresh");
        }
        this.cBd.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onReleaseToRefresh");
        }
        this.cBd.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onPullToRefresh");
        }
        this.cBd.setAlpha(1.0f);
        this.cBd.stopAnim();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        return this.cAO;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        return this.cAM;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onRefreshing");
        }
        this.cBd.aoR();
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

    public boolean eu(int i) {
        if (this.cBd == null) {
            return false;
        }
        this.cBd.eu(i);
        return true;
    }
}
