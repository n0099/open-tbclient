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
/* loaded from: classes3.dex */
public class NeutralHeaderLoadingLayout extends LoadingLayout {
    private static final boolean DEBUG = b.DEBUG;
    private int cOA;
    private int cOB;
    private int cOC;
    private int cOD;
    private View cOE;
    private NeutralRefreshAnimView cOS;

    public NeutralHeaderLoadingLayout(Context context) {
        super(context);
        this.cOA = 0;
        init();
    }

    private void init() {
        this.cOS = (NeutralRefreshAnimView) findViewById(a.f.neutral_refresh_anim_view);
        this.cOA = ah.dip2px(getContext(), 29.0f);
        this.cOB = (int) (2.4f * this.cOA);
        this.cOD = (int) (1.5f * this.cOA);
        this.cOC = this.cOD;
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "mRefreshingViewSizeInPixel" + this.cOA);
            Log.e("NeutralLoadingLayout", "mTriggerRefreshLength" + this.cOB);
            Log.e("NeutralLoadingLayout", "mRefreshingHeight" + this.cOD);
            Log.e("NeutralLoadingLayout", "mScrollStartLength" + this.cOC);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.cOE != null ? this.cOE.getHeight() : ah.dip2px(getContext(), 50.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        this.cOE = LayoutInflater.from(getContext()).inflate(a.g.aiapps_neutral_pull_to_refresh_header, viewGroup, false);
        return this.cOE;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onReset");
        }
        this.cOS.stopAnim();
        this.cOS.setAlpha(1.0f);
        setTranslationY(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void iV(int i) {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "pullLength = " + i);
        }
        if (getState() == ILoadingLayout.State.PULL_TO_REFRESH) {
            this.cOS.setAnimPercent(iW(i));
        }
        if (i > this.cOC) {
            setTranslationY((this.cOC - i) / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(boolean z, String str, final Runnable runnable) {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onPullRefreshComplete");
        }
        this.cOS.stopAnim();
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "current thread name:" + Thread.currentThread().getName());
        }
        this.cOS.azy();
        post(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralHeaderLoadingLayout.1
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void azs() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onReleaseToLongRefresh");
        }
        this.cOS.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onReleaseToRefresh");
        }
        this.cOS.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onPullToRefresh");
        }
        this.cOS.setAlpha(1.0f);
        this.cOS.stopAnim();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        return this.cOD;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        return this.cOB;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onRefreshing");
        }
        this.cOS.azw();
    }

    protected float iW(int i) {
        float f;
        if (i < this.cOB) {
            f = i < this.cOA ? 0.0f : (i - this.cOA) / (this.cOB - this.cOA);
        } else {
            f = 1.0f;
        }
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    public boolean gD(int i) {
        if (this.cOS == null) {
            return false;
        }
        this.cOS.gD(i);
        return true;
    }
}
