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
/* loaded from: classes10.dex */
public abstract class PullToRefreshBaseNew<T extends View> extends FrameLayout {
    private LoadingLayout dpX;
    private LoadingLayout dpY;
    private int dpZ;
    private int dqa;
    private boolean dqb;
    private boolean dqc;
    private boolean dqd;
    private boolean dqe;
    private boolean dqf;
    private ILoadingLayout.State dqg;
    private ILoadingLayout.State dqh;
    T dqi;
    private FrameLayout dqj;
    private int dqk;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> dql;
    protected HEADERTYPE dqr;
    private float dqs;
    private a<T> dqt;
    private PullToRefreshBaseNew<T>.b dqu;
    private boolean dqv;
    private float dqw;
    private boolean dqx;
    private float mLastMotionY;
    private int mTouchSlop;

    /* loaded from: classes10.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER
    }

    /* loaded from: classes10.dex */
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
        this.dqr = HEADERTYPE.STANDARD_HEADER;
        this.dqs = 2.5f;
        this.mLastMotionY = -1.0f;
        this.dqb = true;
        this.dqc = false;
        this.dqd = false;
        this.dqe = true;
        this.dqf = false;
        this.dqg = ILoadingLayout.State.NONE;
        this.dqh = ILoadingLayout.State.NONE;
        this.dqk = -1;
        this.dqv = false;
        this.dqw = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dqr = HEADERTYPE.STANDARD_HEADER;
        this.dqs = 2.5f;
        this.mLastMotionY = -1.0f;
        this.dqb = true;
        this.dqc = false;
        this.dqd = false;
        this.dqe = true;
        this.dqf = false;
        this.dqg = ILoadingLayout.State.NONE;
        this.dqh = ILoadingLayout.State.NONE;
        this.dqk = -1;
        this.dqv = false;
        this.dqw = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dpX = e(context, attributeSet);
        this.dpY = f(context, attributeSet);
        this.dqi = createRefreshableView(context, attributeSet);
        if (this.dqi == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.dqi);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (aGF()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.dqf = false;
                    return false;
                } else if (action == 0 || !this.dqf) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.dqf = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || aGH()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.dqf = z;
                                    if (this.dqf && aGE()) {
                                        this.dqi.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.dqf = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.dqf;
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
                this.dqf = false;
                return false;
            case 1:
            case 3:
                if (this.dqf) {
                    this.dqf = false;
                    if (isReadyForPullDown()) {
                        if (this.dqb) {
                            if (this.dqg == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.dqv && this.dqg == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                aGI();
                                if (this.dqx) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.dqg = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.dqh == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.dqs);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.dqs);
                    return true;
                } else {
                    this.dqf = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.dqb = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.dqc = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.dqd = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.dqb && this.dpX != null;
    }

    public boolean isPullLoadEnabled() {
        return this.dqc && this.dpY != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.dqt = aVar;
    }

    public T getRefreshableView() {
        return this.dqi;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.dql;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.dpX;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.dpY;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.dpX != null) {
            this.dpX.setLastUpdatedLabel(charSequence);
        }
        if (this.dpY != null) {
            this.dpY.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.dqk = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.dpX != null) {
            this.dpX.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.dpX != null) {
            this.dpX.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.dpX != null) {
            this.dpX.setHeaderBigBackground(i);
        }
    }

    protected boolean aGE() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        aGG();
        LoadingLayout loadingLayout = null;
        switch (this.dqr) {
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
        if (this.dqj != null) {
            this.dqj.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.dpX;
        LoadingLayout loadingLayout2 = this.dpY;
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
        if (this.dpX != null) {
            this.dpX.layout(this.dpX.getLeft(), this.dpX.getTop() - this.dpX.getHeight(), this.dpX.getRight(), this.dpX.getBottom() - this.dpX.getHeight());
            this.dpZ = this.dpX.getContentSize();
        }
        if (this.dpY != null && this.dqi != null) {
            this.dpY.layout(this.dpY.getLeft(), this.dqi.getBottom(), this.dpY.getRight(), this.dqi.getBottom() + this.dpY.getHeight());
            this.dqa = this.dpY.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.dqx = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            aq(0, 0);
        } else if (this.dqk <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.dqk) {
            ar(0, -((int) f));
            if (this.dpX != null && this.dpZ != 0) {
                this.dpX.onPull(Math.abs(getScrollYValue()) / this.dpZ);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !aGH()) {
                if (this.dqv && abs > this.dpZ * this.dqw * 2.0f) {
                    this.dqg = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.dpZ * this.dqw) {
                    this.dqg = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.dqg = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.dpX != null) {
                    this.dpX.setState(this.dqg);
                }
                a(this.dqg, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            aq(0, 0);
            return;
        }
        ar(0, -((int) f));
        if (this.dpY != null && this.dqa != 0) {
            this.dpY.onPull(Math.abs(getScrollYValue()) / this.dqa);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.dqa) {
                this.dqh = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.dqh = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.dpY != null) {
                this.dpY.setState(this.dqh);
            }
            a(this.dqh, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean aGH = aGH();
        if ((isPullRefreshing || aGH) && abs <= this.dpZ) {
            jT(0);
        } else if (isPullRefreshing || aGH) {
            jT(-this.dpZ);
        } else {
            jT(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.dqa) {
            jT(0);
        } else if (isPullLoading) {
            jT(this.dqa);
        } else {
            jT(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.dqg == ILoadingLayout.State.REFRESHING;
    }

    protected boolean aGH() {
        return this.dqg == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.dqh == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        gj(true);
    }

    private void gj(boolean z) {
        if (!isPullRefreshing() && !aGH()) {
            this.dqg = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.dpX != null) {
                this.dpX.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.dqt != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dqt.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void aGI() {
        gk(true);
    }

    private void gk(boolean z) {
        if (!isPullRefreshing() && !aGH()) {
            this.dqg = ILoadingLayout.State.LONG_REFRESHING;
            a(this.dqg, true);
            if (this.dpX != null) {
                this.dpX.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.dqt != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dqt.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.dqh = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.dpY != null) {
                this.dpY.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.dqt != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dqt.d(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(int i, int i2) {
        scrollTo(i, i2);
    }

    private void ar(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void jT(int i) {
        d(i, getSmoothScrollDuration(), 0L);
    }

    private void d(int i, long j, long j2) {
        if (this.dqu != null) {
            this.dqu.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.dqu = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.dqu, j2);
            } else {
                post(this.dqu);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.dqe = z;
    }

    private boolean aGF() {
        return this.dqe;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.dqv = z;
    }

    public void setPullRatio(float f) {
        this.dqw = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public final class b implements Runnable {
        private final int bFx;
        private final int bFy;
        private final long mDuration;
        private boolean bFA = true;
        private long mStartTime = -1;
        private int bFB = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.bFy = i;
            this.bFx = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.aq(0, this.bFx);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bFB = this.bFy - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bFy - this.bFx));
                PullToRefreshBaseNew.this.aq(0, this.bFB);
            }
            if (this.bFA && this.bFx != this.bFB) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.bFA = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void aGG() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.dqs = f;
    }
}
