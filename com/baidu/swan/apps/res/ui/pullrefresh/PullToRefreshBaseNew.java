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
    private LoadingLayout dwO;
    private LoadingLayout dwP;
    private int dwQ;
    private int dwR;
    private boolean dwS;
    private boolean dwT;
    private boolean dwU;
    private boolean dwV;
    private boolean dwW;
    private ILoadingLayout.State dwX;
    private ILoadingLayout.State dwY;
    T dwZ;
    private FrameLayout dxa;
    private int dxb;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> dxc;
    protected HEADERTYPE dxi;
    private float dxj;
    private a<T> dxk;
    private PullToRefreshBaseNew<T>.b dxl;
    private boolean dxm;
    private float dxn;
    private boolean dxo;
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
        this.dxi = HEADERTYPE.STANDARD_HEADER;
        this.dxj = 2.5f;
        this.mLastMotionY = -1.0f;
        this.dwS = true;
        this.dwT = false;
        this.dwU = false;
        this.dwV = true;
        this.dwW = false;
        this.dwX = ILoadingLayout.State.NONE;
        this.dwY = ILoadingLayout.State.NONE;
        this.dxb = -1;
        this.dxm = false;
        this.dxn = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dxi = HEADERTYPE.STANDARD_HEADER;
        this.dxj = 2.5f;
        this.mLastMotionY = -1.0f;
        this.dwS = true;
        this.dwT = false;
        this.dwU = false;
        this.dwV = true;
        this.dwW = false;
        this.dwX = ILoadingLayout.State.NONE;
        this.dwY = ILoadingLayout.State.NONE;
        this.dxb = -1;
        this.dxm = false;
        this.dxn = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dwO = f(context, attributeSet);
        this.dwP = g(context, attributeSet);
        this.dwZ = createRefreshableView(context, attributeSet);
        if (this.dwZ == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.dwZ);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (aGW()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.dwW = false;
                    return false;
                } else if (action == 0 || !this.dwW) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.dwW = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || aGY()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.dwW = z;
                                    if (this.dwW && aGV()) {
                                        this.dwZ.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.dwW = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.dwW;
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
                this.dwW = false;
                return false;
            case 1:
            case 3:
                if (this.dwW) {
                    this.dwW = false;
                    if (isReadyForPullDown()) {
                        if (this.dwS) {
                            if (this.dwX == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.dxm && this.dwX == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                aGZ();
                                if (this.dxo) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.dwX = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.dwY == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.dxj);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.dxj);
                    return true;
                } else {
                    this.dwW = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.dwS = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.dwT = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.dwU = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.dwS && this.dwO != null;
    }

    public boolean isPullLoadEnabled() {
        return this.dwT && this.dwP != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.dxk = aVar;
    }

    public T getRefreshableView() {
        return this.dwZ;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.dxc;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.dwO;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.dwP;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.dwO != null) {
            this.dwO.setLastUpdatedLabel(charSequence);
        }
        if (this.dwP != null) {
            this.dwP.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.dxb = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.dwO != null) {
            this.dwO.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.dwO != null) {
            this.dwO.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.dwO != null) {
            this.dwO.setHeaderBigBackground(i);
        }
    }

    protected boolean aGV() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        aGX();
        LoadingLayout loadingLayout = null;
        switch (this.dxi) {
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
        if (this.dxa != null) {
            this.dxa.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.dwO;
        LoadingLayout loadingLayout2 = this.dwP;
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
        if (this.dwO != null) {
            this.dwO.layout(this.dwO.getLeft(), this.dwO.getTop() - this.dwO.getHeight(), this.dwO.getRight(), this.dwO.getBottom() - this.dwO.getHeight());
            this.dwQ = this.dwO.getContentSize();
        }
        if (this.dwP != null && this.dwZ != null) {
            this.dwP.layout(this.dwP.getLeft(), this.dwZ.getBottom(), this.dwP.getRight(), this.dwZ.getBottom() + this.dwP.getHeight());
            this.dwR = this.dwP.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.dxo = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            ao(0, 0);
        } else if (this.dxb <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.dxb) {
            ap(0, -((int) f));
            if (this.dwO != null && this.dwQ != 0) {
                this.dwO.onPull(Math.abs(getScrollYValue()) / this.dwQ);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !aGY()) {
                if (this.dxm && abs > this.dwQ * this.dxn * 2.0f) {
                    this.dwX = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.dwQ * this.dxn) {
                    this.dwX = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.dwX = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.dwO != null) {
                    this.dwO.setState(this.dwX);
                }
                a(this.dwX, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            ao(0, 0);
            return;
        }
        ap(0, -((int) f));
        if (this.dwP != null && this.dwR != 0) {
            this.dwP.onPull(Math.abs(getScrollYValue()) / this.dwR);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.dwR) {
                this.dwY = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.dwY = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.dwP != null) {
                this.dwP.setState(this.dwY);
            }
            a(this.dwY, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean aGY = aGY();
        if ((isPullRefreshing || aGY) && abs <= this.dwQ) {
            iG(0);
        } else if (isPullRefreshing || aGY) {
            iG(-this.dwQ);
        } else {
            iG(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.dwR) {
            iG(0);
        } else if (isPullLoading) {
            iG(this.dwR);
        } else {
            iG(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.dwX == ILoadingLayout.State.REFRESHING;
    }

    protected boolean aGY() {
        return this.dwX == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.dwY == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        gG(true);
    }

    private void gG(boolean z) {
        if (!isPullRefreshing() && !aGY()) {
            this.dwX = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.dwO != null) {
                this.dwO.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.dxk != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dxk.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void aGZ() {
        gH(true);
    }

    private void gH(boolean z) {
        if (!isPullRefreshing() && !aGY()) {
            this.dwX = ILoadingLayout.State.LONG_REFRESHING;
            a(this.dwX, true);
            if (this.dwO != null) {
                this.dwO.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.dxk != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dxk.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.dwY = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.dwP != null) {
                this.dwP.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.dxk != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dxk.d(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(int i, int i2) {
        scrollTo(i, i2);
    }

    private void ap(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void iG(int i) {
        e(i, getSmoothScrollDuration(), 0L);
    }

    private void e(int i, long j, long j2) {
        if (this.dxl != null) {
            this.dxl.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.dxl = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.dxl, j2);
            } else {
                post(this.dxl);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.dwV = z;
    }

    private boolean aGW() {
        return this.dwV;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.dxm = z;
    }

    public void setPullRatio(float f) {
        this.dxn = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public final class b implements Runnable {
        private final int bIW;
        private final int bIX;
        private final long mDuration;
        private boolean bIZ = true;
        private long mStartTime = -1;
        private int bJa = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.bIX = i;
            this.bIW = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.ao(0, this.bIW);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bJa = this.bIX - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bIX - this.bIW));
                PullToRefreshBaseNew.this.ao(0, this.bJa);
            }
            if (this.bIZ && this.bIW != this.bJa) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.bIZ = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void aGX() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.dxj = f;
    }
}
