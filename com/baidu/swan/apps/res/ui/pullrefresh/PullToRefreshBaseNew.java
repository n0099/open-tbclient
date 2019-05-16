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
    private LoadingLayout aKN;
    private LoadingLayout aKO;
    private int aKP;
    private int aKQ;
    private boolean aKR;
    private boolean aKS;
    private boolean aKT;
    private boolean aKU;
    private boolean aKV;
    private ILoadingLayout.State aKW;
    private ILoadingLayout.State aKX;
    T aKY;
    private FrameLayout aKZ;
    private int aLa;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> aLb;
    protected HEADERTYPE aLh;
    private float aLi;
    private a<T> aLj;
    private PullToRefreshBaseNew<T>.b aLk;
    private boolean aLl;
    private float aLm;
    private boolean aLn;
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
        this.aLh = HEADERTYPE.STANDARD_HEADER;
        this.aLi = 2.5f;
        this.mLastMotionY = -1.0f;
        this.aKR = true;
        this.aKS = false;
        this.aKT = false;
        this.aKU = true;
        this.aKV = false;
        this.aKW = ILoadingLayout.State.NONE;
        this.aKX = ILoadingLayout.State.NONE;
        this.aLa = -1;
        this.aLl = false;
        this.aLm = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLh = HEADERTYPE.STANDARD_HEADER;
        this.aLi = 2.5f;
        this.mLastMotionY = -1.0f;
        this.aKR = true;
        this.aKS = false;
        this.aKT = false;
        this.aKU = true;
        this.aKV = false;
        this.aKW = ILoadingLayout.State.NONE;
        this.aKX = ILoadingLayout.State.NONE;
        this.aLa = -1;
        this.aLl = false;
        this.aLm = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.aKN = f(context, attributeSet);
        this.aKO = g(context, attributeSet);
        this.aKY = createRefreshableView(context, attributeSet);
        if (this.aKY == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.aKY);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (JK()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.aKV = false;
                    return false;
                } else if (action == 0 || !this.aKV) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.aKV = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || JM()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.aKV = z;
                                    if (this.aKV && JJ()) {
                                        this.aKY.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.aKV = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.aKV;
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
                this.aKV = false;
                return false;
            case 1:
            case 3:
                if (this.aKV) {
                    this.aKV = false;
                    if (isReadyForPullDown()) {
                        if (this.aKR) {
                            if (this.aKW == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.aLl && this.aKW == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                JN();
                                if (this.aLn) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.aKW = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.aKX == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.aLi);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.aLi);
                    return true;
                } else {
                    this.aKV = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.aKR = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.aKS = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.aKT = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.aKR && this.aKN != null;
    }

    public boolean isPullLoadEnabled() {
        return this.aKS && this.aKO != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.aLj = aVar;
    }

    public T getRefreshableView() {
        return this.aKY;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.aLb;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.aKN;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.aKO;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.aKN != null) {
            this.aKN.setLastUpdatedLabel(charSequence);
        }
        if (this.aKO != null) {
            this.aKO.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.aLa = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.aKN != null) {
            this.aKN.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.aKN != null) {
            this.aKN.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.aKN != null) {
            this.aKN.setHeaderBigBackground(i);
        }
    }

    protected boolean JJ() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        JL();
        LoadingLayout loadingLayout = null;
        switch (this.aLh) {
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
        if (this.aKZ != null) {
            this.aKZ.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.aKN;
        LoadingLayout loadingLayout2 = this.aKO;
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
        if (this.aKN != null) {
            this.aKN.layout(this.aKN.getLeft(), this.aKN.getTop() - this.aKN.getHeight(), this.aKN.getRight(), this.aKN.getBottom() - this.aKN.getHeight());
            this.aKP = this.aKN.getContentSize();
        }
        if (this.aKO != null && this.aKY != null) {
            this.aKO.layout(this.aKO.getLeft(), this.aKY.getBottom(), this.aKO.getRight(), this.aKY.getBottom() + this.aKO.getHeight());
            this.aKQ = this.aKO.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.aLn = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            C(0, 0);
        } else if (this.aLa <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.aLa) {
            D(0, -((int) f));
            if (this.aKN != null && this.aKP != 0) {
                this.aKN.onPull(Math.abs(getScrollYValue()) / this.aKP);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !JM()) {
                if (this.aLl && abs > this.aKP * this.aLm * 2.0f) {
                    this.aKW = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.aKP * this.aLm) {
                    this.aKW = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.aKW = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                this.aKN.setState(this.aKW);
                a(this.aKW, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            C(0, 0);
            return;
        }
        D(0, -((int) f));
        if (this.aKO != null && this.aKQ != 0) {
            this.aKO.onPull(Math.abs(getScrollYValue()) / this.aKQ);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.aKQ) {
                this.aKX = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.aKX = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            this.aKO.setState(this.aKX);
            a(this.aKX, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean JM = JM();
        if ((isPullRefreshing || JM) && abs <= this.aKP) {
            db(0);
        } else if (isPullRefreshing || JM) {
            db(-this.aKP);
        } else {
            db(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.aKQ) {
            db(0);
        } else if (isPullLoading) {
            db(this.aKQ);
        } else {
            db(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.aKW == ILoadingLayout.State.REFRESHING;
    }

    protected boolean JM() {
        return this.aKW == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.aKX == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        bL(true);
    }

    private void bL(boolean z) {
        if (!isPullRefreshing() && !JM()) {
            this.aKW = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.aKN != null) {
                this.aKN.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.aLj != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aLj.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void JN() {
        bM(true);
    }

    private void bM(boolean z) {
        if (!isPullRefreshing() && !JM()) {
            this.aKW = ILoadingLayout.State.LONG_REFRESHING;
            a(this.aKW, true);
            if (this.aKN != null) {
                this.aKN.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.aLj != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aLj.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.aKX = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.aKO != null) {
                this.aKO.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.aLj != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aLj.d(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i, int i2) {
        scrollTo(i, i2);
    }

    private void D(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void db(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.aLk != null) {
            this.aLk.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.aLk = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.aLk, j2);
            } else {
                post(this.aLk);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.aKU = z;
    }

    private boolean JK() {
        return this.aKU;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.aLl = z;
    }

    public void setPullRatio(float f) {
        this.aLm = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b implements Runnable {
        private final int aLq;
        private final int aLr;
        private final long mDuration;
        private boolean aLs = true;
        private long mStartTime = -1;
        private int aLt = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.aLr = i;
            this.aLq = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.C(0, this.aLq);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aLt = this.aLr - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aLr - this.aLq));
                PullToRefreshBaseNew.this.C(0, this.aLt);
            }
            if (this.aLs && this.aLq != this.aLt) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.aLs = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void JL() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.aLi = f;
    }
}
