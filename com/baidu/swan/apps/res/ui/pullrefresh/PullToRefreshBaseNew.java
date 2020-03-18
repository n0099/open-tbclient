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
    private LoadingLayout bMC;
    private LoadingLayout bMD;
    private int bME;
    private int bMF;
    private boolean bMG;
    private boolean bMH;
    private boolean bMI;
    private boolean bMJ;
    private boolean bMK;
    private ILoadingLayout.State bML;
    private ILoadingLayout.State bMM;
    T bMN;
    private FrameLayout bMO;
    private int bMP;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> bMQ;
    protected HEADERTYPE bMW;
    private float bMX;
    private a<T> bMY;
    private PullToRefreshBaseNew<T>.b bMZ;
    private boolean bNa;
    private float bNb;
    private boolean bNc;
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
        this.bMW = HEADERTYPE.STANDARD_HEADER;
        this.bMX = 2.5f;
        this.mLastMotionY = -1.0f;
        this.bMG = true;
        this.bMH = false;
        this.bMI = false;
        this.bMJ = true;
        this.bMK = false;
        this.bML = ILoadingLayout.State.NONE;
        this.bMM = ILoadingLayout.State.NONE;
        this.bMP = -1;
        this.bNa = false;
        this.bNb = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMW = HEADERTYPE.STANDARD_HEADER;
        this.bMX = 2.5f;
        this.mLastMotionY = -1.0f;
        this.bMG = true;
        this.bMH = false;
        this.bMI = false;
        this.bMJ = true;
        this.bMK = false;
        this.bML = ILoadingLayout.State.NONE;
        this.bMM = ILoadingLayout.State.NONE;
        this.bMP = -1;
        this.bNa = false;
        this.bNb = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.bMC = e(context, attributeSet);
        this.bMD = f(context, attributeSet);
        this.bMN = createRefreshableView(context, attributeSet);
        if (this.bMN == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.bMN);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (abZ()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.bMK = false;
                    return false;
                } else if (action == 0 || !this.bMK) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.bMK = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || acb()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.bMK = z;
                                    if (this.bMK && abY()) {
                                        this.bMN.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.bMK = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.bMK;
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
                this.bMK = false;
                return false;
            case 1:
            case 3:
                if (this.bMK) {
                    this.bMK = false;
                    if (isReadyForPullDown()) {
                        if (this.bMG) {
                            if (this.bML == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.bNa && this.bML == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                acc();
                                if (this.bNc) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.bML = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.bMM == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.bMX);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.bMX);
                    return true;
                } else {
                    this.bMK = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.bMG = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.bMH = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.bMI = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.bMG && this.bMC != null;
    }

    public boolean isPullLoadEnabled() {
        return this.bMH && this.bMD != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.bMY = aVar;
    }

    public T getRefreshableView() {
        return this.bMN;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.bMQ;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.bMC;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.bMD;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.bMC != null) {
            this.bMC.setLastUpdatedLabel(charSequence);
        }
        if (this.bMD != null) {
            this.bMD.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.bMP = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.bMC != null) {
            this.bMC.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.bMC != null) {
            this.bMC.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.bMC != null) {
            this.bMC.setHeaderBigBackground(i);
        }
    }

    protected boolean abY() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        aca();
        LoadingLayout loadingLayout = null;
        switch (this.bMW) {
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
        if (this.bMO != null) {
            this.bMO.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.bMC;
        LoadingLayout loadingLayout2 = this.bMD;
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
        if (this.bMC != null) {
            this.bMC.layout(this.bMC.getLeft(), this.bMC.getTop() - this.bMC.getHeight(), this.bMC.getRight(), this.bMC.getBottom() - this.bMC.getHeight());
            this.bME = this.bMC.getContentSize();
        }
        if (this.bMD != null && this.bMN != null) {
            this.bMD.layout(this.bMD.getLeft(), this.bMN.getBottom(), this.bMD.getRight(), this.bMN.getBottom() + this.bMD.getHeight());
            this.bMF = this.bMD.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.bNc = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            ad(0, 0);
        } else if (this.bMP <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.bMP) {
            ae(0, -((int) f));
            if (this.bMC != null && this.bME != 0) {
                this.bMC.onPull(Math.abs(getScrollYValue()) / this.bME);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !acb()) {
                if (this.bNa && abs > this.bME * this.bNb * 2.0f) {
                    this.bML = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.bME * this.bNb) {
                    this.bML = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.bML = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.bMC != null) {
                    this.bMC.setState(this.bML);
                }
                a(this.bML, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            ad(0, 0);
            return;
        }
        ae(0, -((int) f));
        if (this.bMD != null && this.bMF != 0) {
            this.bMD.onPull(Math.abs(getScrollYValue()) / this.bMF);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.bMF) {
                this.bMM = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.bMM = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.bMD != null) {
                this.bMD.setState(this.bMM);
            }
            a(this.bMM, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean acb = acb();
        if ((isPullRefreshing || acb) && abs <= this.bME) {
            fO(0);
        } else if (isPullRefreshing || acb) {
            fO(-this.bME);
        } else {
            fO(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.bMF) {
            fO(0);
        } else if (isPullLoading) {
            fO(this.bMF);
        } else {
            fO(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.bML == ILoadingLayout.State.REFRESHING;
    }

    protected boolean acb() {
        return this.bML == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.bMM == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        dw(true);
    }

    private void dw(boolean z) {
        if (!isPullRefreshing() && !acb()) {
            this.bML = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.bMC != null) {
                this.bMC.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.bMY != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bMY.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void acc() {
        dx(true);
    }

    private void dx(boolean z) {
        if (!isPullRefreshing() && !acb()) {
            this.bML = ILoadingLayout.State.LONG_REFRESHING;
            a(this.bML, true);
            if (this.bMC != null) {
                this.bMC.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.bMY != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bMY.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.bMM = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.bMD != null) {
                this.bMD.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.bMY != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bMY.d(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(int i, int i2) {
        scrollTo(i, i2);
    }

    private void ae(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void fO(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.bMZ != null) {
            this.bMZ.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.bMZ = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.bMZ, j2);
            } else {
                post(this.bMZ);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.bMJ = z;
    }

    private boolean abZ() {
        return this.bMJ;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.bNa = z;
    }

    public void setPullRatio(float f) {
        this.bNb = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public final class b implements Runnable {
        private final int aDH;
        private final int aDI;
        private final long mDuration;
        private boolean aDK = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.aDI = i;
            this.aDH = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.ad(0, this.aDH);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.aDI - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aDI - this.aDH));
                PullToRefreshBaseNew.this.ad(0, this.mCurrentY);
            }
            if (this.aDK && this.aDH != this.mCurrentY) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.aDK = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void aca() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.bMX = f;
    }
}
