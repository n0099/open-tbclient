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
    private boolean cNA;
    private boolean cNB;
    private boolean cNC;
    private boolean cND;
    private ILoadingLayout.State cNE;
    private ILoadingLayout.State cNF;
    T cNG;
    private FrameLayout cNH;
    private int cNI;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> cNJ;
    protected HEADERTYPE cNP;
    private float cNQ;
    private a<T> cNR;
    private PullToRefreshBaseNew<T>.b cNS;
    private boolean cNT;
    private float cNU;
    private boolean cNV;
    private LoadingLayout cNv;
    private LoadingLayout cNw;
    private int cNx;
    private int cNy;
    private boolean cNz;
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
        this.cNP = HEADERTYPE.STANDARD_HEADER;
        this.cNQ = 2.5f;
        this.mLastMotionY = -1.0f;
        this.cNz = true;
        this.cNA = false;
        this.cNB = false;
        this.cNC = true;
        this.cND = false;
        this.cNE = ILoadingLayout.State.NONE;
        this.cNF = ILoadingLayout.State.NONE;
        this.cNI = -1;
        this.cNT = false;
        this.cNU = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cNP = HEADERTYPE.STANDARD_HEADER;
        this.cNQ = 2.5f;
        this.mLastMotionY = -1.0f;
        this.cNz = true;
        this.cNA = false;
        this.cNB = false;
        this.cNC = true;
        this.cND = false;
        this.cNE = ILoadingLayout.State.NONE;
        this.cNF = ILoadingLayout.State.NONE;
        this.cNI = -1;
        this.cNT = false;
        this.cNU = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.cNv = e(context, attributeSet);
        this.cNw = f(context, attributeSet);
        this.cNG = createRefreshableView(context, attributeSet);
        if (this.cNG == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.cNG);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (ayT()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.cND = false;
                    return false;
                } else if (action == 0 || !this.cND) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.cND = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || ayV()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.cND = z;
                                    if (this.cND && ayS()) {
                                        this.cNG.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.cND = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.cND;
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
                this.cND = false;
                return false;
            case 1:
            case 3:
                if (this.cND) {
                    this.cND = false;
                    if (isReadyForPullDown()) {
                        if (this.cNz) {
                            if (this.cNE == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.cNT && this.cNE == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                ayW();
                                if (this.cNV) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.cNE = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.cNF == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.cNQ);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.cNQ);
                    return true;
                } else {
                    this.cND = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.cNz = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.cNA = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.cNB = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.cNz && this.cNv != null;
    }

    public boolean isPullLoadEnabled() {
        return this.cNA && this.cNw != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.cNR = aVar;
    }

    public T getRefreshableView() {
        return this.cNG;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.cNJ;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.cNv;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.cNw;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.cNv != null) {
            this.cNv.setLastUpdatedLabel(charSequence);
        }
        if (this.cNw != null) {
            this.cNw.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.cNI = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.cNv != null) {
            this.cNv.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.cNv != null) {
            this.cNv.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.cNv != null) {
            this.cNv.setHeaderBigBackground(i);
        }
    }

    protected boolean ayS() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        ayU();
        LoadingLayout loadingLayout = null;
        switch (this.cNP) {
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
        if (this.cNH != null) {
            this.cNH.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.cNv;
        LoadingLayout loadingLayout2 = this.cNw;
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
        if (this.cNv != null) {
            this.cNv.layout(this.cNv.getLeft(), this.cNv.getTop() - this.cNv.getHeight(), this.cNv.getRight(), this.cNv.getBottom() - this.cNv.getHeight());
            this.cNx = this.cNv.getContentSize();
        }
        if (this.cNw != null && this.cNG != null) {
            this.cNw.layout(this.cNw.getLeft(), this.cNG.getBottom(), this.cNw.getRight(), this.cNG.getBottom() + this.cNw.getHeight());
            this.cNy = this.cNw.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.cNV = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            aq(0, 0);
        } else if (this.cNI <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.cNI) {
            ar(0, -((int) f));
            if (this.cNv != null && this.cNx != 0) {
                this.cNv.onPull(Math.abs(getScrollYValue()) / this.cNx);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !ayV()) {
                if (this.cNT && abs > this.cNx * this.cNU * 2.0f) {
                    this.cNE = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.cNx * this.cNU) {
                    this.cNE = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.cNE = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.cNv != null) {
                    this.cNv.setState(this.cNE);
                }
                a(this.cNE, true);
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
        if (this.cNw != null && this.cNy != 0) {
            this.cNw.onPull(Math.abs(getScrollYValue()) / this.cNy);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.cNy) {
                this.cNF = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.cNF = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.cNw != null) {
                this.cNw.setState(this.cNF);
            }
            a(this.cNF, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean ayV = ayV();
        if ((isPullRefreshing || ayV) && abs <= this.cNx) {
            iQ(0);
        } else if (isPullRefreshing || ayV) {
            iQ(-this.cNx);
        } else {
            iQ(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.cNy) {
            iQ(0);
        } else if (isPullLoading) {
            iQ(this.cNy);
        } else {
            iQ(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.cNE == ILoadingLayout.State.REFRESHING;
    }

    protected boolean ayV() {
        return this.cNE == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.cNF == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        ft(true);
    }

    private void ft(boolean z) {
        if (!isPullRefreshing() && !ayV()) {
            this.cNE = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.cNv != null) {
                this.cNv.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.cNR != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.cNR.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void ayW() {
        fu(true);
    }

    private void fu(boolean z) {
        if (!isPullRefreshing() && !ayV()) {
            this.cNE = ILoadingLayout.State.LONG_REFRESHING;
            a(this.cNE, true);
            if (this.cNv != null) {
                this.cNv.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.cNR != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.cNR.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.cNF = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.cNw != null) {
                this.cNw.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.cNR != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.cNR.d(PullToRefreshBaseNew.this);
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

    private void iQ(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.cNS != null) {
            this.cNS.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.cNS = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.cNS, j2);
            } else {
                post(this.cNS);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.cNC = z;
    }

    private boolean ayT() {
        return this.cNC;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.cNT = z;
    }

    public void setPullRatio(float f) {
        this.cNU = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public final class b implements Runnable {
        private final int bqb;
        private final int bqc;
        private final long mDuration;
        private boolean bqe = true;
        private long mStartTime = -1;
        private int bqf = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.bqc = i;
            this.bqb = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.aq(0, this.bqb);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bqf = this.bqc - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bqc - this.bqb));
                PullToRefreshBaseNew.this.aq(0, this.bqf);
            }
            if (this.bqe && this.bqb != this.bqf) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.bqe = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void ayU() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.cNQ = f;
    }
}
