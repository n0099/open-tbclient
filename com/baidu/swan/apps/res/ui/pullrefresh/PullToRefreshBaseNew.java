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
    private LoadingLayout aIQ;
    private LoadingLayout aIR;
    private int aIS;
    private int aIT;
    private boolean aIU;
    private boolean aIV;
    private boolean aIW;
    private boolean aIX;
    private boolean aIY;
    private ILoadingLayout.State aIZ;
    private ILoadingLayout.State aJa;
    T aJb;
    private FrameLayout aJc;
    private int aJd;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> aJe;
    protected HEADERTYPE aJk;
    private float aJl;
    private a<T> aJm;
    private PullToRefreshBaseNew<T>.b aJn;
    private boolean aJo;
    private float aJp;
    private boolean aJq;
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
        this.aJk = HEADERTYPE.STANDARD_HEADER;
        this.aJl = 2.5f;
        this.mLastMotionY = -1.0f;
        this.aIU = true;
        this.aIV = false;
        this.aIW = false;
        this.aIX = true;
        this.aIY = false;
        this.aIZ = ILoadingLayout.State.NONE;
        this.aJa = ILoadingLayout.State.NONE;
        this.aJd = -1;
        this.aJo = false;
        this.aJp = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJk = HEADERTYPE.STANDARD_HEADER;
        this.aJl = 2.5f;
        this.mLastMotionY = -1.0f;
        this.aIU = true;
        this.aIV = false;
        this.aIW = false;
        this.aIX = true;
        this.aIY = false;
        this.aIZ = ILoadingLayout.State.NONE;
        this.aJa = ILoadingLayout.State.NONE;
        this.aJd = -1;
        this.aJo = false;
        this.aJp = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.aIQ = f(context, attributeSet);
        this.aIR = g(context, attributeSet);
        this.aJb = createRefreshableView(context, attributeSet);
        if (this.aJb == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.aJb);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (Hw()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.aIY = false;
                    return false;
                } else if (action == 0 || !this.aIY) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.aIY = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || Hy()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.aIY = z;
                                    if (this.aIY && Hv()) {
                                        this.aJb.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.aIY = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.aIY;
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
                this.aIY = false;
                return false;
            case 1:
            case 3:
                if (this.aIY) {
                    this.aIY = false;
                    if (isReadyForPullDown()) {
                        if (this.aIU) {
                            if (this.aIZ == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.aJo && this.aIZ == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                Hz();
                                if (this.aJq) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.aIZ = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.aJa == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.aJl);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.aJl);
                    return true;
                } else {
                    this.aIY = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.aIU = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.aIV = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.aIW = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.aIU && this.aIQ != null;
    }

    public boolean isPullLoadEnabled() {
        return this.aIV && this.aIR != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.aJm = aVar;
    }

    public T getRefreshableView() {
        return this.aJb;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.aJe;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.aIQ;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.aIR;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.aIQ != null) {
            this.aIQ.setLastUpdatedLabel(charSequence);
        }
        if (this.aIR != null) {
            this.aIR.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.aJd = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.aIQ != null) {
            this.aIQ.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.aIQ != null) {
            this.aIQ.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.aIQ != null) {
            this.aIQ.setHeaderBigBackground(i);
        }
    }

    protected boolean Hv() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        Hx();
        LoadingLayout loadingLayout = null;
        switch (this.aJk) {
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
        if (this.aJc != null) {
            this.aJc.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.aIQ;
        LoadingLayout loadingLayout2 = this.aIR;
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
        if (this.aIQ != null) {
            this.aIQ.layout(this.aIQ.getLeft(), this.aIQ.getTop() - this.aIQ.getHeight(), this.aIQ.getRight(), this.aIQ.getBottom() - this.aIQ.getHeight());
            this.aIS = this.aIQ.getContentSize();
        }
        if (this.aIR != null && this.aJb != null) {
            this.aIR.layout(this.aIR.getLeft(), this.aJb.getBottom(), this.aIR.getRight(), this.aJb.getBottom() + this.aIR.getHeight());
            this.aIT = this.aIR.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.aJq = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            E(0, 0);
        } else if (this.aJd <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.aJd) {
            F(0, -((int) f));
            if (this.aIQ != null && this.aIS != 0) {
                this.aIQ.onPull(Math.abs(getScrollYValue()) / this.aIS);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !Hy()) {
                if (this.aJo && abs > this.aIS * this.aJp * 2.0f) {
                    this.aIZ = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.aIS * this.aJp) {
                    this.aIZ = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.aIZ = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                this.aIQ.setState(this.aIZ);
                a(this.aIZ, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            E(0, 0);
            return;
        }
        F(0, -((int) f));
        if (this.aIR != null && this.aIT != 0) {
            this.aIR.onPull(Math.abs(getScrollYValue()) / this.aIT);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.aIT) {
                this.aJa = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.aJa = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            this.aIR.setState(this.aJa);
            a(this.aJa, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean Hy = Hy();
        if ((isPullRefreshing || Hy) && abs <= this.aIS) {
            cX(0);
        } else if (isPullRefreshing || Hy) {
            cX(-this.aIS);
        } else {
            cX(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.aIT) {
            cX(0);
        } else if (isPullLoading) {
            cX(this.aIT);
        } else {
            cX(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.aIZ == ILoadingLayout.State.REFRESHING;
    }

    protected boolean Hy() {
        return this.aIZ == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.aJa == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        bC(true);
    }

    private void bC(boolean z) {
        if (!isPullRefreshing() && !Hy()) {
            this.aIZ = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.aIQ != null) {
                this.aIQ.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.aJm != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aJm.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void Hz() {
        bD(true);
    }

    private void bD(boolean z) {
        if (!isPullRefreshing() && !Hy()) {
            this.aIZ = ILoadingLayout.State.LONG_REFRESHING;
            a(this.aIZ, true);
            if (this.aIQ != null) {
                this.aIQ.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.aJm != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aJm.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.aJa = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.aIR != null) {
                this.aIR.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.aJm != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aJm.d(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i, int i2) {
        scrollTo(i, i2);
    }

    private void F(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void cX(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.aJn != null) {
            this.aJn.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.aJn = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.aJn, j2);
            } else {
                post(this.aJn);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.aIX = z;
    }

    private boolean Hw() {
        return this.aIX;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.aJo = z;
    }

    public void setPullRatio(float f) {
        this.aJp = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b implements Runnable {
        private final int aJt;
        private final int aJu;
        private final long mDuration;
        private boolean aJv = true;
        private long mStartTime = -1;
        private int aJw = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.aJu = i;
            this.aJt = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.E(0, this.aJt);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aJw = this.aJu - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aJu - this.aJt));
                PullToRefreshBaseNew.this.E(0, this.aJw);
            }
            if (this.aJv && this.aJt != this.aJw) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.aJv = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void Hx() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.aJl = f;
    }
}
