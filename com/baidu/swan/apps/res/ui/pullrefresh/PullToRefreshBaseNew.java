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
    protected HEADERTYPE bfB;
    private float bfC;
    private a<T> bfD;
    private PullToRefreshBaseNew<T>.b bfE;
    private boolean bfF;
    private float bfG;
    private boolean bfH;
    private LoadingLayout bfh;
    private LoadingLayout bfi;
    private int bfj;
    private int bfk;
    private boolean bfl;
    private boolean bfm;
    private boolean bfn;
    private boolean bfo;
    private boolean bfp;
    private ILoadingLayout.State bfq;
    private ILoadingLayout.State bfr;
    T bfs;
    private FrameLayout bft;
    private int bfu;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> bfv;
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
        this.bfB = HEADERTYPE.STANDARD_HEADER;
        this.bfC = 2.5f;
        this.mLastMotionY = -1.0f;
        this.bfl = true;
        this.bfm = false;
        this.bfn = false;
        this.bfo = true;
        this.bfp = false;
        this.bfq = ILoadingLayout.State.NONE;
        this.bfr = ILoadingLayout.State.NONE;
        this.bfu = -1;
        this.bfF = false;
        this.bfG = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfB = HEADERTYPE.STANDARD_HEADER;
        this.bfC = 2.5f;
        this.mLastMotionY = -1.0f;
        this.bfl = true;
        this.bfm = false;
        this.bfn = false;
        this.bfo = true;
        this.bfp = false;
        this.bfq = ILoadingLayout.State.NONE;
        this.bfr = ILoadingLayout.State.NONE;
        this.bfu = -1;
        this.bfF = false;
        this.bfG = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.bfh = f(context, attributeSet);
        this.bfi = g(context, attributeSet);
        this.bfs = createRefreshableView(context, attributeSet);
        if (this.bfs == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.bfs);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (Pu()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.bfp = false;
                    return false;
                } else if (action == 0 || !this.bfp) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.bfp = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || Pw()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.bfp = z;
                                    if (this.bfp && Pt()) {
                                        this.bfs.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.bfp = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.bfp;
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
                this.bfp = false;
                return false;
            case 1:
            case 3:
                if (this.bfp) {
                    this.bfp = false;
                    if (isReadyForPullDown()) {
                        if (this.bfl) {
                            if (this.bfq == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.bfF && this.bfq == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                Px();
                                if (this.bfH) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.bfq = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.bfr == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.bfC);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.bfC);
                    return true;
                } else {
                    this.bfp = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.bfl = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.bfm = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.bfn = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.bfl && this.bfh != null;
    }

    public boolean isPullLoadEnabled() {
        return this.bfm && this.bfi != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.bfD = aVar;
    }

    public T getRefreshableView() {
        return this.bfs;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.bfv;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.bfh;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.bfi;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.bfh != null) {
            this.bfh.setLastUpdatedLabel(charSequence);
        }
        if (this.bfi != null) {
            this.bfi.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.bfu = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.bfh != null) {
            this.bfh.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.bfh != null) {
            this.bfh.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.bfh != null) {
            this.bfh.setHeaderBigBackground(i);
        }
    }

    protected boolean Pt() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        Pv();
        LoadingLayout loadingLayout = null;
        switch (this.bfB) {
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
        if (this.bft != null) {
            this.bft.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.bfh;
        LoadingLayout loadingLayout2 = this.bfi;
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
        if (this.bfh != null) {
            this.bfh.layout(this.bfh.getLeft(), this.bfh.getTop() - this.bfh.getHeight(), this.bfh.getRight(), this.bfh.getBottom() - this.bfh.getHeight());
            this.bfj = this.bfh.getContentSize();
        }
        if (this.bfi != null && this.bfs != null) {
            this.bfi.layout(this.bfi.getLeft(), this.bfs.getBottom(), this.bfi.getRight(), this.bfs.getBottom() + this.bfi.getHeight());
            this.bfk = this.bfi.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.bfH = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            L(0, 0);
        } else if (this.bfu <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.bfu) {
            M(0, -((int) f));
            if (this.bfh != null && this.bfj != 0) {
                this.bfh.onPull(Math.abs(getScrollYValue()) / this.bfj);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !Pw()) {
                if (this.bfF && abs > this.bfj * this.bfG * 2.0f) {
                    this.bfq = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.bfj * this.bfG) {
                    this.bfq = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.bfq = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                this.bfh.setState(this.bfq);
                a(this.bfq, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            L(0, 0);
            return;
        }
        M(0, -((int) f));
        if (this.bfi != null && this.bfk != 0) {
            this.bfi.onPull(Math.abs(getScrollYValue()) / this.bfk);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.bfk) {
                this.bfr = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.bfr = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            this.bfi.setState(this.bfr);
            a(this.bfr, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean Pw = Pw();
        if ((isPullRefreshing || Pw) && abs <= this.bfj) {
            ea(0);
        } else if (isPullRefreshing || Pw) {
            ea(-this.bfj);
        } else {
            ea(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.bfk) {
            ea(0);
        } else if (isPullLoading) {
            ea(this.bfk);
        } else {
            ea(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.bfq == ILoadingLayout.State.REFRESHING;
    }

    protected boolean Pw() {
        return this.bfq == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.bfr == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        cf(true);
    }

    private void cf(boolean z) {
        if (!isPullRefreshing() && !Pw()) {
            this.bfq = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.bfh != null) {
                this.bfh.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.bfD != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bfD.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void Px() {
        cg(true);
    }

    private void cg(boolean z) {
        if (!isPullRefreshing() && !Pw()) {
            this.bfq = ILoadingLayout.State.LONG_REFRESHING;
            a(this.bfq, true);
            if (this.bfh != null) {
                this.bfh.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.bfD != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bfD.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.bfr = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.bfi != null) {
                this.bfi.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.bfD != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bfD.d(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i, int i2) {
        scrollTo(i, i2);
    }

    private void M(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void ea(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.bfE != null) {
            this.bfE.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.bfE = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.bfE, j2);
            } else {
                post(this.bfE);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.bfo = z;
    }

    private boolean Pu() {
        return this.bfo;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.bfF = z;
    }

    public void setPullRatio(float f) {
        this.bfG = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b implements Runnable {
        private final int aqV;
        private final int aqW;
        private final long mDuration;
        private boolean aqY = true;
        private long mStartTime = -1;
        private int aqZ = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.aqW = i;
            this.aqV = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.L(0, this.aqV);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aqZ = this.aqW - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aqW - this.aqV));
                PullToRefreshBaseNew.this.L(0, this.aqZ);
            }
            if (this.aqY && this.aqV != this.aqZ) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.aqY = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void Pv() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.bfC = f;
    }
}
