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
/* loaded from: classes2.dex */
public abstract class PullToRefreshBaseNew<T extends View> extends FrameLayout {
    private boolean aLA;
    private boolean aLB;
    private boolean aLC;
    private boolean aLD;
    private ILoadingLayout.State aLE;
    private ILoadingLayout.State aLF;
    T aLG;
    private FrameLayout aLH;
    private int aLI;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> aLJ;
    protected HEADERTYPE aLP;
    private float aLQ;
    private a<T> aLR;
    private PullToRefreshBaseNew<T>.b aLS;
    private boolean aLT;
    private float aLU;
    private boolean aLV;
    private LoadingLayout aLv;
    private LoadingLayout aLw;
    private int aLx;
    private int aLy;
    private boolean aLz;
    private float mLastMotionY;
    private int mTouchSlop;

    /* loaded from: classes2.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER
    }

    /* loaded from: classes2.dex */
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
        this.aLP = HEADERTYPE.STANDARD_HEADER;
        this.aLQ = 2.5f;
        this.mLastMotionY = -1.0f;
        this.aLz = true;
        this.aLA = false;
        this.aLB = false;
        this.aLC = true;
        this.aLD = false;
        this.aLE = ILoadingLayout.State.NONE;
        this.aLF = ILoadingLayout.State.NONE;
        this.aLI = -1;
        this.aLT = false;
        this.aLU = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLP = HEADERTYPE.STANDARD_HEADER;
        this.aLQ = 2.5f;
        this.mLastMotionY = -1.0f;
        this.aLz = true;
        this.aLA = false;
        this.aLB = false;
        this.aLC = true;
        this.aLD = false;
        this.aLE = ILoadingLayout.State.NONE;
        this.aLF = ILoadingLayout.State.NONE;
        this.aLI = -1;
        this.aLT = false;
        this.aLU = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.aLv = f(context, attributeSet);
        this.aLw = g(context, attributeSet);
        this.aLG = createRefreshableView(context, attributeSet);
        if (this.aLG == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.aLG);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (Kx()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.aLD = false;
                    return false;
                } else if (action == 0 || !this.aLD) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.aLD = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || Kz()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.aLD = z;
                                    if (this.aLD && Kw()) {
                                        this.aLG.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.aLD = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.aLD;
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
                this.aLD = false;
                return false;
            case 1:
            case 3:
                if (this.aLD) {
                    this.aLD = false;
                    if (isReadyForPullDown()) {
                        if (this.aLz) {
                            if (this.aLE == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.aLT && this.aLE == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                KA();
                                if (this.aLV) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.aLE = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.aLF == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.aLQ);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.aLQ);
                    return true;
                } else {
                    this.aLD = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.aLz = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.aLA = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.aLB = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.aLz && this.aLv != null;
    }

    public boolean isPullLoadEnabled() {
        return this.aLA && this.aLw != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.aLR = aVar;
    }

    public T getRefreshableView() {
        return this.aLG;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.aLJ;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.aLv;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.aLw;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.aLv != null) {
            this.aLv.setLastUpdatedLabel(charSequence);
        }
        if (this.aLw != null) {
            this.aLw.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.aLI = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.aLv != null) {
            this.aLv.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.aLv != null) {
            this.aLv.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.aLv != null) {
            this.aLv.setHeaderBigBackground(i);
        }
    }

    protected boolean Kw() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        Ky();
        LoadingLayout loadingLayout = null;
        switch (this.aLP) {
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

    protected LoadingLayout g(Context context, AttributeSet attributeSet) {
        return new FooterLoadingLayout(context);
    }

    protected long getSmoothScrollDuration() {
        return 150L;
    }

    public void setEmptyView(View view) {
        if (this.aLH != null) {
            this.aLH.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.aLv;
        LoadingLayout loadingLayout2 = this.aLw;
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
        if (this.aLv != null) {
            this.aLv.layout(this.aLv.getLeft(), this.aLv.getTop() - this.aLv.getHeight(), this.aLv.getRight(), this.aLv.getBottom() - this.aLv.getHeight());
            this.aLx = this.aLv.getContentSize();
        }
        if (this.aLw != null && this.aLG != null) {
            this.aLw.layout(this.aLw.getLeft(), this.aLG.getBottom(), this.aLw.getRight(), this.aLG.getBottom() + this.aLw.getHeight());
            this.aLy = this.aLw.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.aLV = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            F(0, 0);
        } else if (this.aLI <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.aLI) {
            G(0, -((int) f));
            if (this.aLv != null && this.aLx != 0) {
                this.aLv.onPull(Math.abs(getScrollYValue()) / this.aLx);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !Kz()) {
                if (this.aLT && abs > this.aLx * this.aLU * 2.0f) {
                    this.aLE = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.aLx * this.aLU) {
                    this.aLE = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.aLE = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                this.aLv.setState(this.aLE);
                a(this.aLE, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            F(0, 0);
            return;
        }
        G(0, -((int) f));
        if (this.aLw != null && this.aLy != 0) {
            this.aLw.onPull(Math.abs(getScrollYValue()) / this.aLy);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.aLy) {
                this.aLF = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.aLF = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            this.aLw.setState(this.aLF);
            a(this.aLF, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean Kz = Kz();
        if ((isPullRefreshing || Kz) && abs <= this.aLx) {
            de(0);
        } else if (isPullRefreshing || Kz) {
            de(-this.aLx);
        } else {
            de(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.aLy) {
            de(0);
        } else if (isPullLoading) {
            de(this.aLy);
        } else {
            de(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.aLE == ILoadingLayout.State.REFRESHING;
    }

    protected boolean Kz() {
        return this.aLE == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.aLF == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        bO(true);
    }

    private void bO(boolean z) {
        if (!isPullRefreshing() && !Kz()) {
            this.aLE = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.aLv != null) {
                this.aLv.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.aLR != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aLR.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void KA() {
        bP(true);
    }

    private void bP(boolean z) {
        if (!isPullRefreshing() && !Kz()) {
            this.aLE = ILoadingLayout.State.LONG_REFRESHING;
            a(this.aLE, true);
            if (this.aLv != null) {
                this.aLv.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.aLR != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aLR.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.aLF = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.aLw != null) {
                this.aLw.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.aLR != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aLR.d(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i, int i2) {
        scrollTo(i, i2);
    }

    private void G(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void de(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.aLS != null) {
            this.aLS.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.aLS = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.aLS, j2);
            } else {
                post(this.aLS);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.aLC = z;
    }

    private boolean Kx() {
        return this.aLC;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.aLT = z;
    }

    public void setPullRatio(float f) {
        this.aLU = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b implements Runnable {
        private final int aLY;
        private final int aLZ;
        private final long mDuration;
        private boolean aMa = true;
        private long mStartTime = -1;
        private int aMb = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.aLZ = i;
            this.aLY = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.F(0, this.aLY);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aMb = this.aLZ - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aLZ - this.aLY));
                PullToRefreshBaseNew.this.F(0, this.aMb);
            }
            if (this.aMa && this.aLY != this.aMb) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.aMa = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void Ky() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.aLQ = f;
    }
}
