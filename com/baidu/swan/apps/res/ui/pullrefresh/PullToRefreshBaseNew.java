package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes11.dex */
public abstract class PullToRefreshBaseNew<T extends View> extends FrameLayout {
    private ILoadingLayout.State bMA;
    private ILoadingLayout.State bMB;
    T bMC;
    private FrameLayout bMD;
    private int bME;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> bMF;
    protected HEADERTYPE bML;
    private float bMM;
    private a<T> bMN;
    private PullToRefreshBaseNew<T>.b bMO;
    private boolean bMP;
    private float bMQ;
    private boolean bMR;
    private LoadingLayout bMr;
    private LoadingLayout bMs;
    private int bMt;
    private int bMu;
    private boolean bMv;
    private boolean bMw;
    private boolean bMx;
    private boolean bMy;
    private boolean bMz;
    private float mLastMotionY;
    private int mTouchSlop;

    /* loaded from: classes11.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER
    }

    /* loaded from: classes11.dex */
    public interface a<V extends View> {
        void b(PullToRefreshBaseNew<V> pullToRefreshBaseNew);

        void c(PullToRefreshBaseNew<V> pullToRefreshBaseNew);

        void d(PullToRefreshBaseNew<V> pullToRefreshBaseNew);
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    protected abstract boolean isReadyForPullDown();

    protected abstract boolean isReadyForPullUp();

    public PullToRefreshBaseNew(Context context) {
        super(context);
        this.bML = HEADERTYPE.STANDARD_HEADER;
        this.bMM = 2.5f;
        this.mLastMotionY = -1.0f;
        this.bMv = true;
        this.bMw = false;
        this.bMx = false;
        this.bMy = true;
        this.bMz = false;
        this.bMA = ILoadingLayout.State.NONE;
        this.bMB = ILoadingLayout.State.NONE;
        this.bME = -1;
        this.bMP = false;
        this.bMQ = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bML = HEADERTYPE.STANDARD_HEADER;
        this.bMM = 2.5f;
        this.mLastMotionY = -1.0f;
        this.bMv = true;
        this.bMw = false;
        this.bMx = false;
        this.bMy = true;
        this.bMz = false;
        this.bMA = ILoadingLayout.State.NONE;
        this.bMB = ILoadingLayout.State.NONE;
        this.bME = -1;
        this.bMP = false;
        this.bMQ = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.bMr = e(context, attributeSet);
        this.bMs = f(context, attributeSet);
        this.bMC = createRefreshableView(context, attributeSet);
        if (this.bMC == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.bMC);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (abW()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.bMz = false;
                    return false;
                } else if (action == 0 || !this.bMz) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.bMz = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || abY()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.bMz = z;
                                    if (this.bMz && abV()) {
                                        this.bMC.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.bMz = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.bMz;
                } else {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean z2 = true;
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastMotionY = motionEvent.getY();
                this.bMz = false;
                return false;
            case 1:
            case 3:
                if (this.bMz) {
                    this.bMz = false;
                    if (isReadyForPullDown()) {
                        if (this.bMv) {
                            if (this.bMA == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.bMP && this.bMA == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                abZ();
                                if (this.bMR) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.bMA = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.bMB == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startLoading();
                            z = true;
                        }
                        resetFooterLayout();
                        return z;
                    } else {
                        return false;
                    }
                }
                return false;
            case 2:
                float y = motionEvent.getY() - this.mLastMotionY;
                this.mLastMotionY = motionEvent.getY();
                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                    pullHeaderLayout(y / this.bMM);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.bMM);
                    return true;
                } else {
                    this.bMz = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.bMv = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.bMw = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.bMx = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.bMv && this.bMr != null;
    }

    public boolean isPullLoadEnabled() {
        return this.bMw && this.bMs != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.bMN = aVar;
    }

    public T getRefreshableView() {
        return this.bMC;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.bMF;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.bMr;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.bMs;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.bMr != null) {
            this.bMr.setLastUpdatedLabel(charSequence);
        }
        if (this.bMs != null) {
            this.bMs.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.bME = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.bMr != null) {
            this.bMr.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.bMr != null) {
            this.bMr.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.bMr != null) {
            this.bMr.setHeaderBigBackground(i);
        }
    }

    protected boolean abV() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        abX();
        LoadingLayout loadingLayout = null;
        switch (this.bML) {
            case STANDARD_HEADER:
                loadingLayout = new HeaderLoadingLayout(context);
                break;
            case BIG_BG_HEADER:
                loadingLayout = new BigBgHeaderLoadingLayout(context);
                break;
            case ROTATE_HEADER:
                loadingLayout = new RotateLoadingLayout(context);
                break;
        }
        if (loadingLayout == null) {
            return new HeaderLoadingLayout(context);
        }
        return loadingLayout;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        return new FooterLoadingLayout(context);
    }

    protected long getSmoothScrollDuration() {
        return 150L;
    }

    public void setEmptyView(View view) {
        if (this.bMD != null) {
            this.bMD.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.bMr;
        LoadingLayout loadingLayout2 = this.bMs;
        if (loadingLayout != null) {
            if (this == loadingLayout.getParent()) {
                removeView(loadingLayout);
            }
            addView(loadingLayout, 0, new FrameLayout.LayoutParams(-1, -2));
        }
        if (loadingLayout2 != null) {
            if (this == loadingLayout2.getParent()) {
                removeView(loadingLayout2);
            }
            addView(loadingLayout2, -1, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.bMr != null) {
            this.bMr.layout(this.bMr.getLeft(), this.bMr.getTop() - this.bMr.getHeight(), this.bMr.getRight(), this.bMr.getBottom() - this.bMr.getHeight());
            this.bMt = this.bMr.getContentSize();
        }
        if (this.bMs != null && this.bMC != null) {
            this.bMs.layout(this.bMs.getLeft(), this.bMC.getBottom(), this.bMs.getRight(), this.bMC.getBottom() + this.bMs.getHeight());
            this.bMu = this.bMs.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.bMR = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            ad(0, 0);
        } else if (this.bME <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.bME) {
            ae(0, -((int) f));
            if (this.bMr != null && this.bMt != 0) {
                this.bMr.onPull(Math.abs(getScrollYValue()) / this.bMt);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !abY()) {
                if (this.bMP && abs > this.bMt * this.bMQ * 2.0f) {
                    this.bMA = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.bMt * this.bMQ) {
                    this.bMA = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.bMA = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.bMr != null) {
                    this.bMr.setState(this.bMA);
                }
                a(this.bMA, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            ad(0, 0);
            return;
        }
        ae(0, -((int) f));
        if (this.bMs != null && this.bMu != 0) {
            this.bMs.onPull(Math.abs(getScrollYValue()) / this.bMu);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.bMu) {
                this.bMB = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.bMB = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.bMs != null) {
                this.bMs.setState(this.bMB);
            }
            a(this.bMB, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean abY = abY();
        if ((isPullRefreshing || abY) && abs <= this.bMt) {
            fO(0);
        } else if (isPullRefreshing || abY) {
            fO(-this.bMt);
        } else {
            fO(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.bMu) {
            fO(0);
        } else if (isPullLoading) {
            fO(this.bMu);
        } else {
            fO(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.bMA == ILoadingLayout.State.REFRESHING;
    }

    protected boolean abY() {
        return this.bMA == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.bMB == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        dv(true);
    }

    private void dv(boolean z) {
        if (!isPullRefreshing() && !abY()) {
            this.bMA = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.bMr != null) {
                this.bMr.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.bMN != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bMN.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void abZ() {
        dw(true);
    }

    private void dw(boolean z) {
        if (!isPullRefreshing() && !abY()) {
            this.bMA = ILoadingLayout.State.LONG_REFRESHING;
            a(this.bMA, true);
            if (this.bMr != null) {
                this.bMr.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.bMN != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bMN.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.bMB = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.bMs != null) {
                this.bMs.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.bMN != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bMN.d(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(int i, int i2) {
        scrollTo(i, i2);
    }

    private void ae(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void fO(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.bMO != null) {
            this.bMO.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.bMO = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.bMO, j2);
            } else {
                post(this.bMO);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.bMy = z;
    }

    private boolean abW() {
        return this.bMy;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.bMP = z;
    }

    public void setPullRatio(float f) {
        this.bMQ = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public final class b implements Runnable {
        private final int aDt;
        private final int aDu;
        private final long mDuration;
        private boolean aDw = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.aDu = i;
            this.aDt = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.ad(0, this.aDt);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.aDu - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aDu - this.aDt));
                PullToRefreshBaseNew.this.ad(0, this.mCurrentY);
            }
            if (this.aDw && this.aDt != this.mCurrentY) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.aDw = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void abX() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.bMM = f;
    }
}
