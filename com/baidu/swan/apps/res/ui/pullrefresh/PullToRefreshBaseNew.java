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
    private LoadingLayout cwW;
    private LoadingLayout cwX;
    private int cwY;
    private int cwZ;
    private boolean cxa;
    private boolean cxb;
    private boolean cxc;
    private boolean cxd;
    private boolean cxe;
    private ILoadingLayout.State cxf;
    private ILoadingLayout.State cxg;
    T cxh;
    private FrameLayout cxi;
    private int cxj;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> cxk;
    protected HEADERTYPE cxq;
    private float cxr;
    private a<T> cxs;
    private PullToRefreshBaseNew<T>.b cxt;
    private boolean cxu;
    private float cxv;
    private boolean cxw;
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
        this.cxq = HEADERTYPE.STANDARD_HEADER;
        this.cxr = 2.5f;
        this.mLastMotionY = -1.0f;
        this.cxa = true;
        this.cxb = false;
        this.cxc = false;
        this.cxd = true;
        this.cxe = false;
        this.cxf = ILoadingLayout.State.NONE;
        this.cxg = ILoadingLayout.State.NONE;
        this.cxj = -1;
        this.cxu = false;
        this.cxv = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cxq = HEADERTYPE.STANDARD_HEADER;
        this.cxr = 2.5f;
        this.mLastMotionY = -1.0f;
        this.cxa = true;
        this.cxb = false;
        this.cxc = false;
        this.cxd = true;
        this.cxe = false;
        this.cxf = ILoadingLayout.State.NONE;
        this.cxg = ILoadingLayout.State.NONE;
        this.cxj = -1;
        this.cxu = false;
        this.cxv = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.cwW = e(context, attributeSet);
        this.cwX = f(context, attributeSet);
        this.cxh = createRefreshableView(context, attributeSet);
        if (this.cxh == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.cxh);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (anR()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.cxe = false;
                    return false;
                } else if (action == 0 || !this.cxe) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.cxe = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || anT()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.cxe = z;
                                    if (this.cxe && anQ()) {
                                        this.cxh.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.cxe = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.cxe;
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
                this.cxe = false;
                return false;
            case 1:
            case 3:
                if (this.cxe) {
                    this.cxe = false;
                    if (isReadyForPullDown()) {
                        if (this.cxa) {
                            if (this.cxf == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.cxu && this.cxf == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                anU();
                                if (this.cxw) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.cxf = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.cxg == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.cxr);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.cxr);
                    return true;
                } else {
                    this.cxe = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.cxa = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.cxb = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.cxc = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.cxa && this.cwW != null;
    }

    public boolean isPullLoadEnabled() {
        return this.cxb && this.cwX != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.cxs = aVar;
    }

    public T getRefreshableView() {
        return this.cxh;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.cxk;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.cwW;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.cwX;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.cwW != null) {
            this.cwW.setLastUpdatedLabel(charSequence);
        }
        if (this.cwX != null) {
            this.cwX.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.cxj = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.cwW != null) {
            this.cwW.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.cwW != null) {
            this.cwW.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.cwW != null) {
            this.cwW.setHeaderBigBackground(i);
        }
    }

    protected boolean anQ() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        anS();
        LoadingLayout loadingLayout = null;
        switch (this.cxq) {
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
        if (this.cxi != null) {
            this.cxi.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.cwW;
        LoadingLayout loadingLayout2 = this.cwX;
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
        if (this.cwW != null) {
            this.cwW.layout(this.cwW.getLeft(), this.cwW.getTop() - this.cwW.getHeight(), this.cwW.getRight(), this.cwW.getBottom() - this.cwW.getHeight());
            this.cwY = this.cwW.getContentSize();
        }
        if (this.cwX != null && this.cxh != null) {
            this.cwX.layout(this.cwX.getLeft(), this.cxh.getBottom(), this.cwX.getRight(), this.cxh.getBottom() + this.cwX.getHeight());
            this.cwZ = this.cwX.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.cxw = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            aj(0, 0);
        } else if (this.cxj <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.cxj) {
            ak(0, -((int) f));
            if (this.cwW != null && this.cwY != 0) {
                this.cwW.onPull(Math.abs(getScrollYValue()) / this.cwY);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !anT()) {
                if (this.cxu && abs > this.cwY * this.cxv * 2.0f) {
                    this.cxf = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.cwY * this.cxv) {
                    this.cxf = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.cxf = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.cwW != null) {
                    this.cwW.setState(this.cxf);
                }
                a(this.cxf, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            aj(0, 0);
            return;
        }
        ak(0, -((int) f));
        if (this.cwX != null && this.cwZ != 0) {
            this.cwX.onPull(Math.abs(getScrollYValue()) / this.cwZ);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.cwZ) {
                this.cxg = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.cxg = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.cwX != null) {
                this.cwX.setState(this.cxg);
            }
            a(this.cxg, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean anT = anT();
        if ((isPullRefreshing || anT) && abs <= this.cwY) {
            gp(0);
        } else if (isPullRefreshing || anT) {
            gp(-this.cwY);
        } else {
            gp(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.cwZ) {
            gp(0);
        } else if (isPullLoading) {
            gp(this.cwZ);
        } else {
            gp(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.cxf == ILoadingLayout.State.REFRESHING;
    }

    protected boolean anT() {
        return this.cxf == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.cxg == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        eL(true);
    }

    private void eL(boolean z) {
        if (!isPullRefreshing() && !anT()) {
            this.cxf = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.cwW != null) {
                this.cwW.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.cxs != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.cxs.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void anU() {
        eM(true);
    }

    private void eM(boolean z) {
        if (!isPullRefreshing() && !anT()) {
            this.cxf = ILoadingLayout.State.LONG_REFRESHING;
            a(this.cxf, true);
            if (this.cwW != null) {
                this.cwW.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.cxs != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.cxs.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.cxg = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.cwX != null) {
                this.cwX.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.cxs != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.cxs.d(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(int i, int i2) {
        scrollTo(i, i2);
    }

    private void ak(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void gp(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.cxt != null) {
            this.cxt.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.cxt = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.cxt, j2);
            } else {
                post(this.cxt);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.cxd = z;
    }

    private boolean anR() {
        return this.cxd;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.cxu = z;
    }

    public void setPullRatio(float f) {
        this.cxv = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public final class b implements Runnable {
        private final int beO;
        private final int beP;
        private final long mDuration;
        private boolean beR = true;
        private long mStartTime = -1;
        private int beS = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.beP = i;
            this.beO = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.aj(0, this.beO);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.beS = this.beP - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.beP - this.beO));
                PullToRefreshBaseNew.this.aj(0, this.beS);
            }
            if (this.beR && this.beO != this.beS) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.beR = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void anS() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.cxr = f;
    }
}
