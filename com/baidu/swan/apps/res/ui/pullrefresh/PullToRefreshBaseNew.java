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
    private boolean clA;
    private ILoadingLayout.State clB;
    private ILoadingLayout.State clC;
    T clD;
    private FrameLayout clE;
    private int clF;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> clG;
    protected HEADERTYPE clM;
    private float clN;
    private a<T> clO;
    private PullToRefreshBaseNew<T>.b clP;
    private boolean clQ;
    private float clR;
    private boolean clS;
    private LoadingLayout cls;
    private LoadingLayout clt;
    private int clu;
    private int clv;
    private boolean clw;
    private boolean clx;
    private boolean cly;
    private boolean clz;
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
        this.clM = HEADERTYPE.STANDARD_HEADER;
        this.clN = 2.5f;
        this.mLastMotionY = -1.0f;
        this.clw = true;
        this.clx = false;
        this.cly = false;
        this.clz = true;
        this.clA = false;
        this.clB = ILoadingLayout.State.NONE;
        this.clC = ILoadingLayout.State.NONE;
        this.clF = -1;
        this.clQ = false;
        this.clR = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clM = HEADERTYPE.STANDARD_HEADER;
        this.clN = 2.5f;
        this.mLastMotionY = -1.0f;
        this.clw = true;
        this.clx = false;
        this.cly = false;
        this.clz = true;
        this.clA = false;
        this.clB = ILoadingLayout.State.NONE;
        this.clC = ILoadingLayout.State.NONE;
        this.clF = -1;
        this.clQ = false;
        this.clR = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.cls = e(context, attributeSet);
        this.clt = f(context, attributeSet);
        this.clD = createRefreshableView(context, attributeSet);
        if (this.clD == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.clD);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (akd()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.clA = false;
                    return false;
                } else if (action == 0 || !this.clA) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.clA = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || akf()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.clA = z;
                                    if (this.clA && akc()) {
                                        this.clD.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.clA = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.clA;
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
                this.clA = false;
                return false;
            case 1:
            case 3:
                if (this.clA) {
                    this.clA = false;
                    if (isReadyForPullDown()) {
                        if (this.clw) {
                            if (this.clB == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.clQ && this.clB == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                akg();
                                if (this.clS) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.clB = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.clC == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.clN);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.clN);
                    return true;
                } else {
                    this.clA = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.clw = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.clx = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.cly = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.clw && this.cls != null;
    }

    public boolean isPullLoadEnabled() {
        return this.clx && this.clt != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.clO = aVar;
    }

    public T getRefreshableView() {
        return this.clD;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.clG;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.cls;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.clt;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.cls != null) {
            this.cls.setLastUpdatedLabel(charSequence);
        }
        if (this.clt != null) {
            this.clt.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.clF = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.cls != null) {
            this.cls.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.cls != null) {
            this.cls.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.cls != null) {
            this.cls.setHeaderBigBackground(i);
        }
    }

    protected boolean akc() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        ake();
        LoadingLayout loadingLayout = null;
        switch (this.clM) {
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
        if (this.clE != null) {
            this.clE.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.cls;
        LoadingLayout loadingLayout2 = this.clt;
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
        if (this.cls != null) {
            this.cls.layout(this.cls.getLeft(), this.cls.getTop() - this.cls.getHeight(), this.cls.getRight(), this.cls.getBottom() - this.cls.getHeight());
            this.clu = this.cls.getContentSize();
        }
        if (this.clt != null && this.clD != null) {
            this.clt.layout(this.clt.getLeft(), this.clD.getBottom(), this.clt.getRight(), this.clD.getBottom() + this.clt.getHeight());
            this.clv = this.clt.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.clS = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            ag(0, 0);
        } else if (this.clF <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.clF) {
            ah(0, -((int) f));
            if (this.cls != null && this.clu != 0) {
                this.cls.onPull(Math.abs(getScrollYValue()) / this.clu);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !akf()) {
                if (this.clQ && abs > this.clu * this.clR * 2.0f) {
                    this.clB = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.clu * this.clR) {
                    this.clB = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.clB = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.cls != null) {
                    this.cls.setState(this.clB);
                }
                a(this.clB, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            ag(0, 0);
            return;
        }
        ah(0, -((int) f));
        if (this.clt != null && this.clv != 0) {
            this.clt.onPull(Math.abs(getScrollYValue()) / this.clv);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.clv) {
                this.clC = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.clC = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.clt != null) {
                this.clt.setState(this.clC);
            }
            a(this.clC, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean akf = akf();
        if ((isPullRefreshing || akf) && abs <= this.clu) {
            fV(0);
        } else if (isPullRefreshing || akf) {
            fV(-this.clu);
        } else {
            fV(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.clv) {
            fV(0);
        } else if (isPullLoading) {
            fV(this.clv);
        } else {
            fV(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.clB == ILoadingLayout.State.REFRESHING;
    }

    protected boolean akf() {
        return this.clB == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.clC == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        es(true);
    }

    private void es(boolean z) {
        if (!isPullRefreshing() && !akf()) {
            this.clB = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.cls != null) {
                this.cls.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.clO != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.clO.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void akg() {
        et(true);
    }

    private void et(boolean z) {
        if (!isPullRefreshing() && !akf()) {
            this.clB = ILoadingLayout.State.LONG_REFRESHING;
            a(this.clB, true);
            if (this.cls != null) {
                this.cls.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.clO != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.clO.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.clC = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.clt != null) {
                this.clt.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.clO != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.clO.d(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(int i, int i2) {
        scrollTo(i, i2);
    }

    private void ah(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void fV(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.clP != null) {
            this.clP.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.clP = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.clP, j2);
            } else {
                post(this.clP);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.clz = z;
    }

    private boolean akd() {
        return this.clz;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.clQ = z;
    }

    public void setPullRatio(float f) {
        this.clR = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public final class b implements Runnable {
        private final int aXu;
        private final int aXv;
        private final long mDuration;
        private boolean aXx = true;
        private long mStartTime = -1;
        private int aXy = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.aXv = i;
            this.aXu = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.ag(0, this.aXu);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aXy = this.aXv - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aXv - this.aXu));
                PullToRefreshBaseNew.this.ag(0, this.aXy);
            }
            if (this.aXx && this.aXu != this.aXy) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.aXx = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void ake() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.clN = f;
    }
}
