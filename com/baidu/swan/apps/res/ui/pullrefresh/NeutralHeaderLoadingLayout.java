package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes8.dex */
public class NeutralHeaderLoadingLayout extends LoadingLayout {
    private static final boolean DEBUG = b.DEBUG;
    private View cMA;
    private NeutralRefreshAnimView cMO;
    private int cMw;
    private int cMx;
    private int cMy;
    private int cMz;

    public NeutralHeaderLoadingLayout(Context context) {
        super(context);
        this.cMw = 0;
        init();
    }

    private void init() {
        this.cMO = (NeutralRefreshAnimView) findViewById(a.f.neutral_refresh_anim_view);
        this.cMw = ah.dip2px(getContext(), 29.0f);
        this.cMx = (int) (2.4f * this.cMw);
        this.cMz = (int) (1.5f * this.cMw);
        this.cMy = this.cMz;
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "mRefreshingViewSizeInPixel" + this.cMw);
            Log.e("NeutralLoadingLayout", "mTriggerRefreshLength" + this.cMx);
            Log.e("NeutralLoadingLayout", "mRefreshingHeight" + this.cMz);
            Log.e("NeutralLoadingLayout", "mScrollStartLength" + this.cMy);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.cMA != null ? this.cMA.getHeight() : ah.dip2px(getContext(), 50.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        this.cMA = LayoutInflater.from(getContext()).inflate(a.g.aiapps_neutral_pull_to_refresh_header, viewGroup, false);
        return this.cMA;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onReset");
        }
        this.cMO.stopAnim();
        this.cMO.setAlpha(1.0f);
        setTranslationY(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void iL(int i) {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "pullLength = " + i);
        }
        if (getState() == ILoadingLayout.State.PULL_TO_REFRESH) {
            this.cMO.setAnimPercent(iM(i));
        }
        if (i > this.cMy) {
            setTranslationY((this.cMy - i) / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(boolean z, String str, final Runnable runnable) {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onPullRefreshComplete");
        }
        this.cMO.stopAnim();
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "current thread name:" + Thread.currentThread().getName());
        }
        this.cMO.ayP();
        post(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralHeaderLoadingLayout.1
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void ayJ() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onReleaseToLongRefresh");
        }
        this.cMO.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onReleaseToRefresh");
        }
        this.cMO.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onPullToRefresh");
        }
        this.cMO.setAlpha(1.0f);
        this.cMO.stopAnim();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        return this.cMz;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        return this.cMx;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onRefreshing");
        }
        this.cMO.ayN();
    }

    protected float iM(int i) {
        float f;
        if (i < this.cMx) {
            f = i < this.cMw ? 0.0f : (i - this.cMw) / (this.cMx - this.cMw);
        } else {
            f = 1.0f;
        }
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    public boolean gu(int i) {
        if (this.cMO == null) {
            return false;
        }
        this.cMO.gu(i);
        return true;
    }
}
