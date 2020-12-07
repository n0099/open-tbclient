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
/* loaded from: classes25.dex */
public abstract class PullToRefreshBaseNew<T extends View> extends FrameLayout {
    private ILoadingLayout.State dvA;
    private ILoadingLayout.State dvB;
    T dvC;
    private FrameLayout dvD;
    private int dvE;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> dvF;
    protected HEADERTYPE dvL;
    private float dvM;
    private a<T> dvN;
    private PullToRefreshBaseNew<T>.b dvO;
    private boolean dvP;
    private float dvQ;
    private boolean dvR;
    private LoadingLayout dvr;
    private LoadingLayout dvs;
    private int dvt;
    private int dvu;
    private boolean dvv;
    private boolean dvw;
    private boolean dvx;
    private boolean dvy;
    private boolean dvz;
    private float mLastMotionY;
    private int mTouchSlop;

    /* loaded from: classes25.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER
    }

    /* loaded from: classes25.dex */
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
        this.dvL = HEADERTYPE.STANDARD_HEADER;
        this.dvM = 2.5f;
        this.mLastMotionY = -1.0f;
        this.dvv = true;
        this.dvw = false;
        this.dvx = false;
        this.dvy = true;
        this.dvz = false;
        this.dvA = ILoadingLayout.State.NONE;
        this.dvB = ILoadingLayout.State.NONE;
        this.dvE = -1;
        this.dvP = false;
        this.dvQ = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dvL = HEADERTYPE.STANDARD_HEADER;
        this.dvM = 2.5f;
        this.mLastMotionY = -1.0f;
        this.dvv = true;
        this.dvw = false;
        this.dvx = false;
        this.dvy = true;
        this.dvz = false;
        this.dvA = ILoadingLayout.State.NONE;
        this.dvB = ILoadingLayout.State.NONE;
        this.dvE = -1;
        this.dvP = false;
        this.dvQ = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dvr = e(context, attributeSet);
        this.dvs = f(context, attributeSet);
        this.dvC = createRefreshableView(context, attributeSet);
        if (this.dvC == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.dvC);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (aJf()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.dvz = false;
                    return false;
                } else if (action == 0 || !this.dvz) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.dvz = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || aJh()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.dvz = z;
                                    if (this.dvz && aJe()) {
                                        this.dvC.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.dvz = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.dvz;
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
                this.dvz = false;
                return false;
            case 1:
            case 3:
                if (this.dvz) {
                    this.dvz = false;
                    if (isReadyForPullDown()) {
                        if (this.dvv) {
                            if (this.dvA == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.dvP && this.dvA == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                aJi();
                                if (this.dvR) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.dvA = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.dvB == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.dvM);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.dvM);
                    return true;
                } else {
                    this.dvz = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.dvv = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.dvw = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.dvx = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.dvv && this.dvr != null;
    }

    public boolean isPullLoadEnabled() {
        return this.dvw && this.dvs != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.dvN = aVar;
    }

    public T getRefreshableView() {
        return this.dvC;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.dvF;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.dvr;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.dvs;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.dvr != null) {
            this.dvr.setLastUpdatedLabel(charSequence);
        }
        if (this.dvs != null) {
            this.dvs.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.dvE = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.dvr != null) {
            this.dvr.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.dvr != null) {
            this.dvr.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.dvr != null) {
            this.dvr.setHeaderBigBackground(i);
        }
    }

    protected boolean aJe() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        aJg();
        LoadingLayout loadingLayout = null;
        switch (this.dvL) {
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
        if (this.dvD != null) {
            this.dvD.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.dvr;
        LoadingLayout loadingLayout2 = this.dvs;
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
        if (this.dvr != null) {
            this.dvr.layout(this.dvr.getLeft(), this.dvr.getTop() - this.dvr.getHeight(), this.dvr.getRight(), this.dvr.getBottom() - this.dvr.getHeight());
            this.dvt = this.dvr.getContentSize();
        }
        if (this.dvs != null && this.dvC != null) {
            this.dvs.layout(this.dvs.getLeft(), this.dvC.getBottom(), this.dvs.getRight(), this.dvC.getBottom() + this.dvs.getHeight());
            this.dvu = this.dvs.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.dvR = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            as(0, 0);
        } else if (this.dvE <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.dvE) {
            at(0, -((int) f));
            if (this.dvr != null && this.dvt != 0) {
                this.dvr.onPull(Math.abs(getScrollYValue()) / this.dvt);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !aJh()) {
                if (this.dvP && abs > this.dvt * this.dvQ * 2.0f) {
                    this.dvA = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.dvt * this.dvQ) {
                    this.dvA = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.dvA = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.dvr != null) {
                    this.dvr.setState(this.dvA);
                }
                a(this.dvA, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            as(0, 0);
            return;
        }
        at(0, -((int) f));
        if (this.dvs != null && this.dvu != 0) {
            this.dvs.onPull(Math.abs(getScrollYValue()) / this.dvu);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.dvu) {
                this.dvB = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.dvB = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.dvs != null) {
                this.dvs.setState(this.dvB);
            }
            a(this.dvB, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean aJh = aJh();
        if ((isPullRefreshing || aJh) && abs <= this.dvt) {
            kn(0);
        } else if (isPullRefreshing || aJh) {
            kn(-this.dvt);
        } else {
            kn(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.dvu) {
            kn(0);
        } else if (isPullLoading) {
            kn(this.dvu);
        } else {
            kn(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.dvA == ILoadingLayout.State.REFRESHING;
    }

    protected boolean aJh() {
        return this.dvA == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.dvB == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        gB(true);
    }

    private void gB(boolean z) {
        if (!isPullRefreshing() && !aJh()) {
            this.dvA = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.dvr != null) {
                this.dvr.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.dvN != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dvN.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void aJi() {
        gC(true);
    }

    private void gC(boolean z) {
        if (!isPullRefreshing() && !aJh()) {
            this.dvA = ILoadingLayout.State.LONG_REFRESHING;
            a(this.dvA, true);
            if (this.dvr != null) {
                this.dvr.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.dvN != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dvN.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.dvB = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.dvs != null) {
                this.dvs.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.dvN != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dvN.d(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(int i, int i2) {
        scrollTo(i, i2);
    }

    private void at(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void kn(int i) {
        d(i, getSmoothScrollDuration(), 0L);
    }

    private void d(int i, long j, long j2) {
        if (this.dvO != null) {
            this.dvO.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.dvO = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.dvO, j2);
            } else {
                post(this.dvO);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.dvy = z;
    }

    private boolean aJf() {
        return this.dvy;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.dvP = z;
    }

    public void setPullRatio(float f) {
        this.dvQ = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public final class b implements Runnable {
        private final int bIU;
        private final int bIV;
        private final long mDuration;
        private boolean bIX = true;
        private long mStartTime = -1;
        private int bIY = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.bIV = i;
            this.bIU = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.as(0, this.bIU);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bIY = this.bIV - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bIV - this.bIU));
                PullToRefreshBaseNew.this.as(0, this.bIY);
            }
            if (this.bIX && this.bIU != this.bIY) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.bIX = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void aJg() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.dvM = f;
    }
}
