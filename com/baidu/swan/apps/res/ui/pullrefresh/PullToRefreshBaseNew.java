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
    T bMA;
    private FrameLayout bMB;
    private int bMC;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> bMD;
    protected HEADERTYPE bMJ;
    private float bMK;
    private a<T> bML;
    private PullToRefreshBaseNew<T>.b bMM;
    private boolean bMN;
    private float bMO;
    private boolean bMP;
    private LoadingLayout bMp;
    private LoadingLayout bMq;
    private int bMr;
    private int bMs;
    private boolean bMt;
    private boolean bMu;
    private boolean bMv;
    private boolean bMw;
    private boolean bMx;
    private ILoadingLayout.State bMy;
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
        this.bMJ = HEADERTYPE.STANDARD_HEADER;
        this.bMK = 2.5f;
        this.mLastMotionY = -1.0f;
        this.bMt = true;
        this.bMu = false;
        this.bMv = false;
        this.bMw = true;
        this.bMx = false;
        this.bMy = ILoadingLayout.State.NONE;
        this.bMz = ILoadingLayout.State.NONE;
        this.bMC = -1;
        this.bMN = false;
        this.bMO = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMJ = HEADERTYPE.STANDARD_HEADER;
        this.bMK = 2.5f;
        this.mLastMotionY = -1.0f;
        this.bMt = true;
        this.bMu = false;
        this.bMv = false;
        this.bMw = true;
        this.bMx = false;
        this.bMy = ILoadingLayout.State.NONE;
        this.bMz = ILoadingLayout.State.NONE;
        this.bMC = -1;
        this.bMN = false;
        this.bMO = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.bMp = e(context, attributeSet);
        this.bMq = f(context, attributeSet);
        this.bMA = createRefreshableView(context, attributeSet);
        if (this.bMA == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.bMA);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (abU()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.bMx = false;
                    return false;
                } else if (action == 0 || !this.bMx) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.bMx = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || abW()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.bMx = z;
                                    if (this.bMx && abT()) {
                                        this.bMA.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.bMx = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.bMx;
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
                this.bMx = false;
                return false;
            case 1:
            case 3:
                if (this.bMx) {
                    this.bMx = false;
                    if (isReadyForPullDown()) {
                        if (this.bMt) {
                            if (this.bMy == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.bMN && this.bMy == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                abX();
                                if (this.bMP) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.bMy = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.bMz == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.bMK);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.bMK);
                    return true;
                } else {
                    this.bMx = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.bMt = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.bMu = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.bMv = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.bMt && this.bMp != null;
    }

    public boolean isPullLoadEnabled() {
        return this.bMu && this.bMq != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.bML = aVar;
    }

    public T getRefreshableView() {
        return this.bMA;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.bMD;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.bMp;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.bMq;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.bMp != null) {
            this.bMp.setLastUpdatedLabel(charSequence);
        }
        if (this.bMq != null) {
            this.bMq.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.bMC = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.bMp != null) {
            this.bMp.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.bMp != null) {
            this.bMp.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.bMp != null) {
            this.bMp.setHeaderBigBackground(i);
        }
    }

    protected boolean abT() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        abV();
        LoadingLayout loadingLayout = null;
        switch (this.bMJ) {
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
        if (this.bMB != null) {
            this.bMB.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.bMp;
        LoadingLayout loadingLayout2 = this.bMq;
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
        if (this.bMp != null) {
            this.bMp.layout(this.bMp.getLeft(), this.bMp.getTop() - this.bMp.getHeight(), this.bMp.getRight(), this.bMp.getBottom() - this.bMp.getHeight());
            this.bMr = this.bMp.getContentSize();
        }
        if (this.bMq != null && this.bMA != null) {
            this.bMq.layout(this.bMq.getLeft(), this.bMA.getBottom(), this.bMq.getRight(), this.bMA.getBottom() + this.bMq.getHeight());
            this.bMs = this.bMq.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.bMP = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            ad(0, 0);
        } else if (this.bMC <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.bMC) {
            ae(0, -((int) f));
            if (this.bMp != null && this.bMr != 0) {
                this.bMp.onPull(Math.abs(getScrollYValue()) / this.bMr);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !abW()) {
                if (this.bMN && abs > this.bMr * this.bMO * 2.0f) {
                    this.bMy = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.bMr * this.bMO) {
                    this.bMy = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.bMy = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.bMp != null) {
                    this.bMp.setState(this.bMy);
                }
                a(this.bMy, true);
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
        if (this.bMq != null && this.bMs != 0) {
            this.bMq.onPull(Math.abs(getScrollYValue()) / this.bMs);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.bMs) {
                this.bMz = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.bMz = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.bMq != null) {
                this.bMq.setState(this.bMz);
            }
            a(this.bMz, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean abW = abW();
        if ((isPullRefreshing || abW) && abs <= this.bMr) {
            fO(0);
        } else if (isPullRefreshing || abW) {
            fO(-this.bMr);
        } else {
            fO(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.bMs) {
            fO(0);
        } else if (isPullLoading) {
            fO(this.bMs);
        } else {
            fO(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.bMy == ILoadingLayout.State.REFRESHING;
    }

    protected boolean abW() {
        return this.bMy == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.bMz == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        dv(true);
    }

    private void dv(boolean z) {
        if (!isPullRefreshing() && !abW()) {
            this.bMy = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.bMp != null) {
                this.bMp.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.bML != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bML.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void abX() {
        dw(true);
    }

    private void dw(boolean z) {
        if (!isPullRefreshing() && !abW()) {
            this.bMy = ILoadingLayout.State.LONG_REFRESHING;
            a(this.bMy, true);
            if (this.bMp != null) {
                this.bMp.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.bML != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bML.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.bMz = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.bMq != null) {
                this.bMq.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.bML != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bML.d(PullToRefreshBaseNew.this);
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
        if (this.bMM != null) {
            this.bMM.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.bMM = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.bMM, j2);
            } else {
                post(this.bMM);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.bMw = z;
    }

    private boolean abU() {
        return this.bMw;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.bMN = z;
    }

    public void setPullRatio(float f) {
        this.bMO = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public final class b implements Runnable {
        private final int aDr;
        private final int aDs;
        private final long mDuration;
        private boolean aDu = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.aDs = i;
            this.aDr = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.ad(0, this.aDr);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.aDs - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aDs - this.aDr));
                PullToRefreshBaseNew.this.ad(0, this.mCurrentY);
            }
            if (this.aDu && this.aDr != this.mCurrentY) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.aDu = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void abV() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.bMK = f;
    }
}
