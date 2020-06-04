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
    private int cwa;
    private int cwb;
    private int cwc;
    private int cwd;
    private View cwe;
    private NeutralRefreshAnimView cwt;

    public NeutralHeaderLoadingLayout(Context context) {
        super(context);
        this.cwa = 0;
        init();
    }

    private void init() {
        this.cwt = (NeutralRefreshAnimView) findViewById(a.f.neutral_refresh_anim_view);
        this.cwa = ag.dip2px(getContext(), 29.0f);
        this.cwb = (int) (2.4f * this.cwa);
        this.cwd = (int) (1.5f * this.cwa);
        this.cwc = this.cwd;
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "mRefreshingViewSizeInPixel" + this.cwa);
            Log.e("NeutralLoadingLayout", "mTriggerRefreshLength" + this.cwb);
            Log.e("NeutralLoadingLayout", "mRefreshingHeight" + this.cwd);
            Log.e("NeutralLoadingLayout", "mScrollStartLength" + this.cwc);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.cwe != null ? this.cwe.getHeight() : ag.dip2px(getContext(), 50.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        this.cwe = LayoutInflater.from(getContext()).inflate(a.g.aiapps_neutral_pull_to_refresh_header, viewGroup, false);
        return this.cwe;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onReset");
        }
        this.cwt.stopAnim();
        this.cwt.setAlpha(1.0f);
        setTranslationY(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void gj(int i) {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "pullLength = " + i);
        }
        if (getState() == ILoadingLayout.State.PULL_TO_REFRESH) {
            this.cwt.setAnimPercent(gk(i));
        }
        if (i > this.cwc) {
            setTranslationY((this.cwc - i) / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(boolean z, String str, final Runnable runnable) {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onPullRefreshComplete");
        }
        this.cwt.stopAnim();
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "current thread name:" + Thread.currentThread().getName());
        }
        this.cwt.anN();
        post(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralHeaderLoadingLayout.1
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void anH() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onReleaseToLongRefresh");
        }
        this.cwt.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onReleaseToRefresh");
        }
        this.cwt.setAnimPercent(1.0f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onPullToRefresh");
        }
        this.cwt.setAlpha(1.0f);
        this.cwt.stopAnim();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        return this.cwd;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        return this.cwb;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        if (DEBUG) {
            Log.e("NeutralLoadingLayout", "onRefreshing");
        }
        this.cwt.anL();
    }

    protected float gk(int i) {
        float f;
        if (i < this.cwb) {
            f = i < this.cwa ? 0.0f : (i - this.cwa) / (this.cwb - this.cwa);
        } else {
            f = 1.0f;
        }
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    public boolean ej(int i) {
        if (this.cwt == null) {
            return false;
        }
        this.cwt.ej(i);
        return true;
    }
}
