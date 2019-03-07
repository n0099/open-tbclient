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
    private LoadingLayout aIP;
    private LoadingLayout aIQ;
    private int aIR;
    private int aIS;
    private boolean aIT;
    private boolean aIU;
    private boolean aIV;
    private boolean aIW;
    private boolean aIX;
    private ILoadingLayout.State aIY;
    private ILoadingLayout.State aIZ;
    T aJa;
    private FrameLayout aJb;
    private int aJc;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> aJd;
    protected HEADERTYPE aJj;
    private float aJk;
    private a<T> aJl;
    private PullToRefreshBaseNew<T>.b aJm;
    private boolean aJn;
    private float aJo;
    private boolean aJp;
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
        this.aJj = HEADERTYPE.STANDARD_HEADER;
        this.aJk = 2.5f;
        this.mLastMotionY = -1.0f;
        this.aIT = true;
        this.aIU = false;
        this.aIV = false;
        this.aIW = true;
        this.aIX = false;
        this.aIY = ILoadingLayout.State.NONE;
        this.aIZ = ILoadingLayout.State.NONE;
        this.aJc = -1;
        this.aJn = false;
        this.aJo = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJj = HEADERTYPE.STANDARD_HEADER;
        this.aJk = 2.5f;
        this.mLastMotionY = -1.0f;
        this.aIT = true;
        this.aIU = false;
        this.aIV = false;
        this.aIW = true;
        this.aIX = false;
        this.aIY = ILoadingLayout.State.NONE;
        this.aIZ = ILoadingLayout.State.NONE;
        this.aJc = -1;
        this.aJn = false;
        this.aJo = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.aIP = f(context, attributeSet);
        this.aIQ = g(context, attributeSet);
        this.aJa = createRefreshableView(context, attributeSet);
        if (this.aJa == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.aJa);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (Hw()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.aIX = false;
                    return false;
                } else if (action == 0 || !this.aIX) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.aIX = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || Hy()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.aIX = z;
                                    if (this.aIX && Hv()) {
                                        this.aJa.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.aIX = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.aIX;
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
                this.aIX = false;
                return false;
            case 1:
            case 3:
                if (this.aIX) {
                    this.aIX = false;
                    if (isReadyForPullDown()) {
                        if (this.aIT) {
                            if (this.aIY == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.aJn && this.aIY == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                Hz();
                                if (this.aJp) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.aIY = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.aIZ == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.aJk);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.aJk);
                    return true;
                } else {
                    this.aIX = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.aIT = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.aIU = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.aIV = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.aIT && this.aIP != null;
    }

    public boolean isPullLoadEnabled() {
        return this.aIU && this.aIQ != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.aJl = aVar;
    }

    public T getRefreshableView() {
        return this.aJa;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.aJd;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.aIP;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.aIQ;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.aIP != null) {
            this.aIP.setLastUpdatedLabel(charSequence);
        }
        if (this.aIQ != null) {
            this.aIQ.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.aJc = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.aIP != null) {
            this.aIP.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.aIP != null) {
            this.aIP.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.aIP != null) {
            this.aIP.setHeaderBigBackground(i);
        }
    }

    protected boolean Hv() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        Hx();
        LoadingLayout loadingLayout = null;
        switch (this.aJj) {
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
        if (this.aJb != null) {
            this.aJb.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.aIP;
        LoadingLayout loadingLayout2 = this.aIQ;
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
        if (this.aIP != null) {
            this.aIP.layout(this.aIP.getLeft(), this.aIP.getTop() - this.aIP.getHeight(), this.aIP.getRight(), this.aIP.getBottom() - this.aIP.getHeight());
            this.aIR = this.aIP.getContentSize();
        }
        if (this.aIQ != null && this.aJa != null) {
            this.aIQ.layout(this.aIQ.getLeft(), this.aJa.getBottom(), this.aIQ.getRight(), this.aJa.getBottom() + this.aIQ.getHeight());
            this.aIS = this.aIQ.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.aJp = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            E(0, 0);
        } else if (this.aJc <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.aJc) {
            F(0, -((int) f));
            if (this.aIP != null && this.aIR != 0) {
                this.aIP.onPull(Math.abs(getScrollYValue()) / this.aIR);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !Hy()) {
                if (this.aJn && abs > this.aIR * this.aJo * 2.0f) {
                    this.aIY = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.aIR * this.aJo) {
                    this.aIY = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.aIY = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                this.aIP.setState(this.aIY);
                a(this.aIY, true);
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
        if (this.aIQ != null && this.aIS != 0) {
            this.aIQ.onPull(Math.abs(getScrollYValue()) / this.aIS);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.aIS) {
                this.aIZ = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.aIZ = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            this.aIQ.setState(this.aIZ);
            a(this.aIZ, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean Hy = Hy();
        if ((isPullRefreshing || Hy) && abs <= this.aIR) {
            cX(0);
        } else if (isPullRefreshing || Hy) {
            cX(-this.aIR);
        } else {
            cX(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.aIS) {
            cX(0);
        } else if (isPullLoading) {
            cX(this.aIS);
        } else {
            cX(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.aIY == ILoadingLayout.State.REFRESHING;
    }

    protected boolean Hy() {
        return this.aIY == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.aIZ == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        bC(true);
    }

    private void bC(boolean z) {
        if (!isPullRefreshing() && !Hy()) {
            this.aIY = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.aIP != null) {
                this.aIP.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.aJl != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aJl.b(PullToRefreshBaseNew.this);
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
            this.aIY = ILoadingLayout.State.LONG_REFRESHING;
            a(this.aIY, true);
            if (this.aIP != null) {
                this.aIP.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.aJl != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aJl.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.aIZ = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.aIQ != null) {
                this.aIQ.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.aJl != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aJl.d(PullToRefreshBaseNew.this);
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
        if (this.aJm != null) {
            this.aJm.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.aJm = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.aJm, j2);
            } else {
                post(this.aJm);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.aIW = z;
    }

    private boolean Hw() {
        return this.aIW;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.aJn = z;
    }

    public void setPullRatio(float f) {
        this.aJo = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b implements Runnable {
        private final int aJs;
        private final int aJt;
        private final long mDuration;
        private boolean aJu = true;
        private long mStartTime = -1;
        private int aJv = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.aJt = i;
            this.aJs = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.E(0, this.aJs);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aJv = this.aJt - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aJt - this.aJs));
                PullToRefreshBaseNew.this.E(0, this.aJv);
            }
            if (this.aJu && this.aJs != this.aJv) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.aJu = false;
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
        this.aJk = f;
    }
}
