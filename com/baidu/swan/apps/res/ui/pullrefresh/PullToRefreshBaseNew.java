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
    T bMB;
    private FrameLayout bMC;
    private int bMD;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> bME;
    protected HEADERTYPE bMK;
    private float bML;
    private a<T> bMM;
    private PullToRefreshBaseNew<T>.b bMN;
    private boolean bMO;
    private float bMP;
    private boolean bMQ;
    private LoadingLayout bMq;
    private LoadingLayout bMr;
    private int bMs;
    private int bMt;
    private boolean bMu;
    private boolean bMv;
    private boolean bMw;
    private boolean bMx;
    private boolean bMy;
    private ILoadingLayout.State bMz;
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
        this.bMK = HEADERTYPE.STANDARD_HEADER;
        this.bML = 2.5f;
        this.mLastMotionY = -1.0f;
        this.bMu = true;
        this.bMv = false;
        this.bMw = false;
        this.bMx = true;
        this.bMy = false;
        this.bMz = ILoadingLayout.State.NONE;
        this.bMA = ILoadingLayout.State.NONE;
        this.bMD = -1;
        this.bMO = false;
        this.bMP = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMK = HEADERTYPE.STANDARD_HEADER;
        this.bML = 2.5f;
        this.mLastMotionY = -1.0f;
        this.bMu = true;
        this.bMv = false;
        this.bMw = false;
        this.bMx = true;
        this.bMy = false;
        this.bMz = ILoadingLayout.State.NONE;
        this.bMA = ILoadingLayout.State.NONE;
        this.bMD = -1;
        this.bMO = false;
        this.bMP = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.bMq = e(context, attributeSet);
        this.bMr = f(context, attributeSet);
        this.bMB = createRefreshableView(context, attributeSet);
        if (this.bMB == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.bMB);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (abW()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.bMy = false;
                    return false;
                } else if (action == 0 || !this.bMy) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.bMy = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || abY()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.bMy = z;
                                    if (this.bMy && abV()) {
                                        this.bMB.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.bMy = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.bMy;
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
                this.bMy = false;
                return false;
            case 1:
            case 3:
                if (this.bMy) {
                    this.bMy = false;
                    if (isReadyForPullDown()) {
                        if (this.bMu) {
                            if (this.bMz == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.bMO && this.bMz == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                abZ();
                                if (this.bMQ) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.bMz = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.bMA == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.bML);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.bML);
                    return true;
                } else {
                    this.bMy = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.bMu = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.bMv = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.bMw = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.bMu && this.bMq != null;
    }

    public boolean isPullLoadEnabled() {
        return this.bMv && this.bMr != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.bMM = aVar;
    }

    public T getRefreshableView() {
        return this.bMB;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.bME;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.bMq;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.bMr;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.bMq != null) {
            this.bMq.setLastUpdatedLabel(charSequence);
        }
        if (this.bMr != null) {
            this.bMr.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.bMD = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.bMq != null) {
            this.bMq.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.bMq != null) {
            this.bMq.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.bMq != null) {
            this.bMq.setHeaderBigBackground(i);
        }
    }

    protected boolean abV() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        abX();
        LoadingLayout loadingLayout = null;
        switch (this.bMK) {
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
        if (this.bMC != null) {
            this.bMC.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.bMq;
        LoadingLayout loadingLayout2 = this.bMr;
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
        if (this.bMq != null) {
            this.bMq.layout(this.bMq.getLeft(), this.bMq.getTop() - this.bMq.getHeight(), this.bMq.getRight(), this.bMq.getBottom() - this.bMq.getHeight());
            this.bMs = this.bMq.getContentSize();
        }
        if (this.bMr != null && this.bMB != null) {
            this.bMr.layout(this.bMr.getLeft(), this.bMB.getBottom(), this.bMr.getRight(), this.bMB.getBottom() + this.bMr.getHeight());
            this.bMt = this.bMr.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.bMQ = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            ad(0, 0);
        } else if (this.bMD <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.bMD) {
            ae(0, -((int) f));
            if (this.bMq != null && this.bMs != 0) {
                this.bMq.onPull(Math.abs(getScrollYValue()) / this.bMs);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !abY()) {
                if (this.bMO && abs > this.bMs * this.bMP * 2.0f) {
                    this.bMz = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.bMs * this.bMP) {
                    this.bMz = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.bMz = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.bMq != null) {
                    this.bMq.setState(this.bMz);
                }
                a(this.bMz, true);
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
        if (this.bMr != null && this.bMt != 0) {
            this.bMr.onPull(Math.abs(getScrollYValue()) / this.bMt);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.bMt) {
                this.bMA = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.bMA = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.bMr != null) {
                this.bMr.setState(this.bMA);
            }
            a(this.bMA, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean abY = abY();
        if ((isPullRefreshing || abY) && abs <= this.bMs) {
            fO(0);
        } else if (isPullRefreshing || abY) {
            fO(-this.bMs);
        } else {
            fO(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.bMt) {
            fO(0);
        } else if (isPullLoading) {
            fO(this.bMt);
        } else {
            fO(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.bMz == ILoadingLayout.State.REFRESHING;
    }

    protected boolean abY() {
        return this.bMz == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.bMA == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        dv(true);
    }

    private void dv(boolean z) {
        if (!isPullRefreshing() && !abY()) {
            this.bMz = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.bMq != null) {
                this.bMq.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.bMM != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bMM.b(PullToRefreshBaseNew.this);
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
            this.bMz = ILoadingLayout.State.LONG_REFRESHING;
            a(this.bMz, true);
            if (this.bMq != null) {
                this.bMq.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.bMM != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bMM.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.bMA = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.bMr != null) {
                this.bMr.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.bMM != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bMM.d(PullToRefreshBaseNew.this);
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
        if (this.bMN != null) {
            this.bMN.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.bMN = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.bMN, j2);
            } else {
                post(this.bMN);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.bMx = z;
    }

    private boolean abW() {
        return this.bMx;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.bMO = z;
    }

    public void setPullRatio(float f) {
        this.bMP = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public final class b implements Runnable {
        private final int aDs;
        private final int aDt;
        private final long mDuration;
        private boolean aDv = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.aDt = i;
            this.aDs = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.ad(0, this.aDs);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.aDt - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aDt - this.aDs));
                PullToRefreshBaseNew.this.ad(0, this.mCurrentY);
            }
            if (this.aDv && this.aDs != this.mCurrentY) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.aDv = false;
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
        this.bML = f;
    }
}
