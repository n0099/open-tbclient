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
/* loaded from: classes7.dex */
public abstract class PullToRefreshBaseNew<T extends View> extends FrameLayout {
    private boolean cEA;
    private boolean cEB;
    private ILoadingLayout.State cEC;
    private ILoadingLayout.State cED;
    T cEE;
    private FrameLayout cEF;
    private int cEG;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> cEH;
    protected HEADERTYPE cEN;
    private float cEO;
    private a<T> cEP;
    private PullToRefreshBaseNew<T>.b cEQ;
    private boolean cER;
    private float cES;
    private boolean cET;
    private LoadingLayout cEt;
    private LoadingLayout cEu;
    private int cEv;
    private int cEw;
    private boolean cEx;
    private boolean cEy;
    private boolean cEz;
    private float mLastMotionY;
    private int mTouchSlop;

    /* loaded from: classes7.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER
    }

    /* loaded from: classes7.dex */
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
        this.cEN = HEADERTYPE.STANDARD_HEADER;
        this.cEO = 2.5f;
        this.mLastMotionY = -1.0f;
        this.cEx = true;
        this.cEy = false;
        this.cEz = false;
        this.cEA = true;
        this.cEB = false;
        this.cEC = ILoadingLayout.State.NONE;
        this.cED = ILoadingLayout.State.NONE;
        this.cEG = -1;
        this.cER = false;
        this.cES = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cEN = HEADERTYPE.STANDARD_HEADER;
        this.cEO = 2.5f;
        this.mLastMotionY = -1.0f;
        this.cEx = true;
        this.cEy = false;
        this.cEz = false;
        this.cEA = true;
        this.cEB = false;
        this.cEC = ILoadingLayout.State.NONE;
        this.cED = ILoadingLayout.State.NONE;
        this.cEG = -1;
        this.cER = false;
        this.cES = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.cEt = e(context, attributeSet);
        this.cEu = f(context, attributeSet);
        this.cEE = createRefreshableView(context, attributeSet);
        if (this.cEE == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.cEE);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (aqH()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.cEB = false;
                    return false;
                } else if (action == 0 || !this.cEB) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.cEB = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || aqJ()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.cEB = z;
                                    if (this.cEB && aqG()) {
                                        this.cEE.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.cEB = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.cEB;
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
                this.cEB = false;
                return false;
            case 1:
            case 3:
                if (this.cEB) {
                    this.cEB = false;
                    if (isReadyForPullDown()) {
                        if (this.cEx) {
                            if (this.cEC == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.cER && this.cEC == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                aqK();
                                if (this.cET) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.cEC = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.cED == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.cEO);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.cEO);
                    return true;
                } else {
                    this.cEB = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.cEx = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.cEy = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.cEz = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.cEx && this.cEt != null;
    }

    public boolean isPullLoadEnabled() {
        return this.cEy && this.cEu != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.cEP = aVar;
    }

    public T getRefreshableView() {
        return this.cEE;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.cEH;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.cEt;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.cEu;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.cEt != null) {
            this.cEt.setLastUpdatedLabel(charSequence);
        }
        if (this.cEu != null) {
            this.cEu.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.cEG = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.cEt != null) {
            this.cEt.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.cEt != null) {
            this.cEt.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.cEt != null) {
            this.cEt.setHeaderBigBackground(i);
        }
    }

    protected boolean aqG() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        aqI();
        LoadingLayout loadingLayout = null;
        switch (this.cEN) {
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
        if (this.cEF != null) {
            this.cEF.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.cEt;
        LoadingLayout loadingLayout2 = this.cEu;
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
        if (this.cEt != null) {
            this.cEt.layout(this.cEt.getLeft(), this.cEt.getTop() - this.cEt.getHeight(), this.cEt.getRight(), this.cEt.getBottom() - this.cEt.getHeight());
            this.cEv = this.cEt.getContentSize();
        }
        if (this.cEu != null && this.cEE != null) {
            this.cEu.layout(this.cEu.getLeft(), this.cEE.getBottom(), this.cEu.getRight(), this.cEE.getBottom() + this.cEu.getHeight());
            this.cEw = this.cEu.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.cET = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            al(0, 0);
        } else if (this.cEG <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.cEG) {
            am(0, -((int) f));
            if (this.cEt != null && this.cEv != 0) {
                this.cEt.onPull(Math.abs(getScrollYValue()) / this.cEv);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !aqJ()) {
                if (this.cER && abs > this.cEv * this.cES * 2.0f) {
                    this.cEC = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.cEv * this.cES) {
                    this.cEC = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.cEC = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.cEt != null) {
                    this.cEt.setState(this.cEC);
                }
                a(this.cEC, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            al(0, 0);
            return;
        }
        am(0, -((int) f));
        if (this.cEu != null && this.cEw != 0) {
            this.cEu.onPull(Math.abs(getScrollYValue()) / this.cEw);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.cEw) {
                this.cED = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.cED = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.cEu != null) {
                this.cEu.setState(this.cED);
            }
            a(this.cED, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean aqJ = aqJ();
        if ((isPullRefreshing || aqJ) && abs <= this.cEv) {
            gJ(0);
        } else if (isPullRefreshing || aqJ) {
            gJ(-this.cEv);
        } else {
            gJ(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.cEw) {
            gJ(0);
        } else if (isPullLoading) {
            gJ(this.cEw);
        } else {
            gJ(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.cEC == ILoadingLayout.State.REFRESHING;
    }

    protected boolean aqJ() {
        return this.cEC == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.cED == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        eZ(true);
    }

    private void eZ(boolean z) {
        if (!isPullRefreshing() && !aqJ()) {
            this.cEC = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.cEt != null) {
                this.cEt.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.cEP != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.cEP.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void aqK() {
        fa(true);
    }

    private void fa(boolean z) {
        if (!isPullRefreshing() && !aqJ()) {
            this.cEC = ILoadingLayout.State.LONG_REFRESHING;
            a(this.cEC, true);
            if (this.cEt != null) {
                this.cEt.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.cEP != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.cEP.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.cED = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.cEu != null) {
                this.cEu.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.cEP != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.cEP.d(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i, int i2) {
        scrollTo(i, i2);
    }

    private void am(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void gJ(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.cEQ != null) {
            this.cEQ.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.cEQ = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.cEQ, j2);
            } else {
                post(this.cEQ);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.cEA = z;
    }

    private boolean aqH() {
        return this.cEA;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.cER = z;
    }

    public void setPullRatio(float f) {
        this.cES = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public final class b implements Runnable {
        private final int bkt;
        private final int bku;
        private final long mDuration;
        private boolean bkw = true;
        private long mStartTime = -1;
        private int bkx = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.bku = i;
            this.bkt = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.al(0, this.bkt);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bkx = this.bku - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bku - this.bkt));
                PullToRefreshBaseNew.this.al(0, this.bkx);
            }
            if (this.bkw && this.bkt != this.bkx) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.bkw = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void aqI() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.cEO = f;
    }
}
