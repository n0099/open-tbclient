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
    private LoadingLayout aLT;
    private LoadingLayout aLU;
    private int aLV;
    private int aLW;
    private boolean aLX;
    private boolean aLY;
    private boolean aLZ;
    private boolean aMa;
    private boolean aMb;
    private ILoadingLayout.State aMc;
    private ILoadingLayout.State aMd;
    T aMe;
    private FrameLayout aMf;
    private int aMg;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> aMh;
    protected HEADERTYPE aMn;
    private float aMo;
    private a<T> aMp;
    private PullToRefreshBaseNew<T>.b aMq;
    private boolean aMr;
    private float aMs;
    private boolean aMt;
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
        this.aMn = HEADERTYPE.STANDARD_HEADER;
        this.aMo = 2.5f;
        this.mLastMotionY = -1.0f;
        this.aLX = true;
        this.aLY = false;
        this.aLZ = false;
        this.aMa = true;
        this.aMb = false;
        this.aMc = ILoadingLayout.State.NONE;
        this.aMd = ILoadingLayout.State.NONE;
        this.aMg = -1;
        this.aMr = false;
        this.aMs = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aMn = HEADERTYPE.STANDARD_HEADER;
        this.aMo = 2.5f;
        this.mLastMotionY = -1.0f;
        this.aLX = true;
        this.aLY = false;
        this.aLZ = false;
        this.aMa = true;
        this.aMb = false;
        this.aMc = ILoadingLayout.State.NONE;
        this.aMd = ILoadingLayout.State.NONE;
        this.aMg = -1;
        this.aMr = false;
        this.aMs = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.aLT = f(context, attributeSet);
        this.aLU = g(context, attributeSet);
        this.aMe = createRefreshableView(context, attributeSet);
        if (this.aMe == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.aMe);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (KB()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.aMb = false;
                    return false;
                } else if (action == 0 || !this.aMb) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.aMb = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || KD()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.aMb = z;
                                    if (this.aMb && KA()) {
                                        this.aMe.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.aMb = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.aMb;
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
                this.aMb = false;
                return false;
            case 1:
            case 3:
                if (this.aMb) {
                    this.aMb = false;
                    if (isReadyForPullDown()) {
                        if (this.aLX) {
                            if (this.aMc == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.aMr && this.aMc == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                KE();
                                if (this.aMt) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.aMc = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.aMd == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.aMo);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.aMo);
                    return true;
                } else {
                    this.aMb = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.aLX = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.aLY = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.aLZ = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.aLX && this.aLT != null;
    }

    public boolean isPullLoadEnabled() {
        return this.aLY && this.aLU != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.aMp = aVar;
    }

    public T getRefreshableView() {
        return this.aMe;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.aMh;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.aLT;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.aLU;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.aLT != null) {
            this.aLT.setLastUpdatedLabel(charSequence);
        }
        if (this.aLU != null) {
            this.aLU.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.aMg = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.aLT != null) {
            this.aLT.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.aLT != null) {
            this.aLT.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.aLT != null) {
            this.aLT.setHeaderBigBackground(i);
        }
    }

    protected boolean KA() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        KC();
        LoadingLayout loadingLayout = null;
        switch (this.aMn) {
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
        if (this.aMf != null) {
            this.aMf.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.aLT;
        LoadingLayout loadingLayout2 = this.aLU;
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
        if (this.aLT != null) {
            this.aLT.layout(this.aLT.getLeft(), this.aLT.getTop() - this.aLT.getHeight(), this.aLT.getRight(), this.aLT.getBottom() - this.aLT.getHeight());
            this.aLV = this.aLT.getContentSize();
        }
        if (this.aLU != null && this.aMe != null) {
            this.aLU.layout(this.aLU.getLeft(), this.aMe.getBottom(), this.aLU.getRight(), this.aMe.getBottom() + this.aLU.getHeight());
            this.aLW = this.aLU.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.aMt = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            F(0, 0);
        } else if (this.aMg <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.aMg) {
            G(0, -((int) f));
            if (this.aLT != null && this.aLV != 0) {
                this.aLT.onPull(Math.abs(getScrollYValue()) / this.aLV);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !KD()) {
                if (this.aMr && abs > this.aLV * this.aMs * 2.0f) {
                    this.aMc = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.aLV * this.aMs) {
                    this.aMc = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.aMc = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                this.aLT.setState(this.aMc);
                a(this.aMc, true);
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
        if (this.aLU != null && this.aLW != 0) {
            this.aLU.onPull(Math.abs(getScrollYValue()) / this.aLW);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.aLW) {
                this.aMd = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.aMd = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            this.aLU.setState(this.aMd);
            a(this.aMd, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean KD = KD();
        if ((isPullRefreshing || KD) && abs <= this.aLV) {
            df(0);
        } else if (isPullRefreshing || KD) {
            df(-this.aLV);
        } else {
            df(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.aLW) {
            df(0);
        } else if (isPullLoading) {
            df(this.aLW);
        } else {
            df(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.aMc == ILoadingLayout.State.REFRESHING;
    }

    protected boolean KD() {
        return this.aMc == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.aMd == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        bO(true);
    }

    private void bO(boolean z) {
        if (!isPullRefreshing() && !KD()) {
            this.aMc = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.aLT != null) {
                this.aLT.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.aMp != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aMp.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void KE() {
        bP(true);
    }

    private void bP(boolean z) {
        if (!isPullRefreshing() && !KD()) {
            this.aMc = ILoadingLayout.State.LONG_REFRESHING;
            a(this.aMc, true);
            if (this.aLT != null) {
                this.aLT.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.aMp != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aMp.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.aMd = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.aLU != null) {
                this.aLU.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.aMp != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aMp.d(PullToRefreshBaseNew.this);
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

    private void df(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.aMq != null) {
            this.aMq.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.aMq = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.aMq, j2);
            } else {
                post(this.aMq);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.aMa = z;
    }

    private boolean KB() {
        return this.aMa;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.aMr = z;
    }

    public void setPullRatio(float f) {
        this.aMs = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b implements Runnable {
        private final int aMw;
        private final int aMx;
        private final long mDuration;
        private boolean aMy = true;
        private long mStartTime = -1;
        private int aMz = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.aMx = i;
            this.aMw = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.F(0, this.aMw);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aMz = this.aMx - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aMx - this.aMw));
                PullToRefreshBaseNew.this.F(0, this.aMz);
            }
            if (this.aMy && this.aMw != this.aMz) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.aMy = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void KC() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.aMo = f;
    }
}
