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
/* loaded from: classes8.dex */
public abstract class PullToRefreshBaseNew<T extends View> extends FrameLayout {
    private boolean dAA;
    private boolean dAB;
    private boolean dAC;
    private ILoadingLayout.State dAD;
    private ILoadingLayout.State dAE;
    T dAF;
    private FrameLayout dAG;
    private int dAH;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> dAI;
    protected HEADERTYPE dAO;
    private float dAP;
    private a<T> dAQ;
    private PullToRefreshBaseNew<T>.b dAR;
    private boolean dAS;
    private float dAT;
    private boolean dAU;
    private LoadingLayout dAu;
    private LoadingLayout dAv;
    private int dAw;
    private int dAx;
    private boolean dAy;
    private boolean dAz;
    private float mLastMotionY;
    private int mTouchSlop;

    /* loaded from: classes8.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER
    }

    /* loaded from: classes8.dex */
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
        this.dAO = HEADERTYPE.STANDARD_HEADER;
        this.dAP = 2.5f;
        this.mLastMotionY = -1.0f;
        this.dAy = true;
        this.dAz = false;
        this.dAA = false;
        this.dAB = true;
        this.dAC = false;
        this.dAD = ILoadingLayout.State.NONE;
        this.dAE = ILoadingLayout.State.NONE;
        this.dAH = -1;
        this.dAS = false;
        this.dAT = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dAO = HEADERTYPE.STANDARD_HEADER;
        this.dAP = 2.5f;
        this.mLastMotionY = -1.0f;
        this.dAy = true;
        this.dAz = false;
        this.dAA = false;
        this.dAB = true;
        this.dAC = false;
        this.dAD = ILoadingLayout.State.NONE;
        this.dAE = ILoadingLayout.State.NONE;
        this.dAH = -1;
        this.dAS = false;
        this.dAT = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dAu = f(context, attributeSet);
        this.dAv = g(context, attributeSet);
        this.dAF = createRefreshableView(context, attributeSet);
        if (this.dAF == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.dAF);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (aHs()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.dAC = false;
                    return false;
                } else if (action == 0 || !this.dAC) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.dAC = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || aHu()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.dAC = z;
                                    if (this.dAC && aHr()) {
                                        this.dAF.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.dAC = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.dAC;
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
                this.dAC = false;
                return false;
            case 1:
            case 3:
                if (this.dAC) {
                    this.dAC = false;
                    if (isReadyForPullDown()) {
                        if (this.dAy) {
                            if (this.dAD == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.dAS && this.dAD == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                aHv();
                                if (this.dAU) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.dAD = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.dAE == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.dAP);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.dAP);
                    return true;
                } else {
                    this.dAC = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.dAy = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.dAz = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.dAA = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.dAy && this.dAu != null;
    }

    public boolean isPullLoadEnabled() {
        return this.dAz && this.dAv != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.dAQ = aVar;
    }

    public T getRefreshableView() {
        return this.dAF;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.dAI;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.dAu;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.dAv;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.dAu != null) {
            this.dAu.setLastUpdatedLabel(charSequence);
        }
        if (this.dAv != null) {
            this.dAv.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.dAH = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.dAu != null) {
            this.dAu.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.dAu != null) {
            this.dAu.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.dAu != null) {
            this.dAu.setHeaderBigBackground(i);
        }
    }

    protected boolean aHr() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        aHt();
        LoadingLayout loadingLayout = null;
        switch (this.dAO) {
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
        if (this.dAG != null) {
            this.dAG.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.dAu;
        LoadingLayout loadingLayout2 = this.dAv;
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
        if (this.dAu != null) {
            this.dAu.layout(this.dAu.getLeft(), this.dAu.getTop() - this.dAu.getHeight(), this.dAu.getRight(), this.dAu.getBottom() - this.dAu.getHeight());
            this.dAw = this.dAu.getContentSize();
        }
        if (this.dAv != null && this.dAF != null) {
            this.dAv.layout(this.dAv.getLeft(), this.dAF.getBottom(), this.dAv.getRight(), this.dAF.getBottom() + this.dAv.getHeight());
            this.dAx = this.dAv.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.dAU = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            al(0, 0);
        } else if (this.dAH <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.dAH) {
            am(0, -((int) f));
            if (this.dAu != null && this.dAw != 0) {
                this.dAu.onPull(Math.abs(getScrollYValue()) / this.dAw);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !aHu()) {
                if (this.dAS && abs > this.dAw * this.dAT * 2.0f) {
                    this.dAD = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.dAw * this.dAT) {
                    this.dAD = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.dAD = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.dAu != null) {
                    this.dAu.setState(this.dAD);
                }
                a(this.dAD, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            al(0, 0);
            return;
        }
        am(0, -((int) f));
        if (this.dAv != null && this.dAx != 0) {
            this.dAv.onPull(Math.abs(getScrollYValue()) / this.dAx);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.dAx) {
                this.dAE = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.dAE = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.dAv != null) {
                this.dAv.setState(this.dAE);
            }
            a(this.dAE, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean aHu = aHu();
        if ((isPullRefreshing || aHu) && abs <= this.dAw) {
            iK(0);
        } else if (isPullRefreshing || aHu) {
            iK(-this.dAw);
        } else {
            iK(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.dAx) {
            iK(0);
        } else if (isPullLoading) {
            iK(this.dAx);
        } else {
            iK(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.dAD == ILoadingLayout.State.REFRESHING;
    }

    protected boolean aHu() {
        return this.dAD == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.dAE == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        gI(true);
    }

    private void gI(boolean z) {
        if (!isPullRefreshing() && !aHu()) {
            this.dAD = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.dAu != null) {
                this.dAu.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.dAQ != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dAQ.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void aHv() {
        gJ(true);
    }

    private void gJ(boolean z) {
        if (!isPullRefreshing() && !aHu()) {
            this.dAD = ILoadingLayout.State.LONG_REFRESHING;
            a(this.dAD, true);
            if (this.dAu != null) {
                this.dAu.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.dAQ != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dAQ.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.dAE = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.dAv != null) {
                this.dAv.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.dAQ != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dAQ.d(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i, int i2) {
        scrollTo(i, i2);
    }

    private void am(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void iK(int i) {
        e(i, getSmoothScrollDuration(), 0L);
    }

    private void e(int i, long j, long j2) {
        if (this.dAR != null) {
            this.dAR.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.dAR = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.dAR, j2);
            } else {
                post(this.dAR);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.dAB = z;
    }

    private boolean aHs() {
        return this.dAB;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.dAS = z;
    }

    public void setPullRatio(float f) {
        this.dAT = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public final class b implements Runnable {
        private final int bOg;
        private final int bOh;
        private final long mDuration;
        private boolean bOj = true;
        private long mStartTime = -1;
        private int bOk = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.bOh = i;
            this.bOg = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.al(0, this.bOg);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bOk = this.bOh - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bOh - this.bOg));
                PullToRefreshBaseNew.this.al(0, this.bOk);
            }
            if (this.bOj && this.bOg != this.bOk) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.bOj = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void aHt() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.dAP = f;
    }
}
