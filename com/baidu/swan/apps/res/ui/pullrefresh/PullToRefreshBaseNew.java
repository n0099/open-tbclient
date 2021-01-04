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
/* loaded from: classes9.dex */
public abstract class PullToRefreshBaseNew<T extends View> extends FrameLayout {
    private LoadingLayout dBA;
    private LoadingLayout dBB;
    private int dBC;
    private int dBD;
    private boolean dBE;
    private boolean dBF;
    private boolean dBG;
    private boolean dBH;
    private boolean dBI;
    private ILoadingLayout.State dBJ;
    private ILoadingLayout.State dBK;
    T dBL;
    private FrameLayout dBM;
    private int dBN;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> dBO;
    protected HEADERTYPE dBU;
    private float dBV;
    private a<T> dBW;
    private PullToRefreshBaseNew<T>.b dBX;
    private boolean dBY;
    private float dBZ;
    private boolean dCa;
    private float mLastMotionY;
    private int mTouchSlop;

    /* loaded from: classes9.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER
    }

    /* loaded from: classes9.dex */
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
        this.dBU = HEADERTYPE.STANDARD_HEADER;
        this.dBV = 2.5f;
        this.mLastMotionY = -1.0f;
        this.dBE = true;
        this.dBF = false;
        this.dBG = false;
        this.dBH = true;
        this.dBI = false;
        this.dBJ = ILoadingLayout.State.NONE;
        this.dBK = ILoadingLayout.State.NONE;
        this.dBN = -1;
        this.dBY = false;
        this.dBZ = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dBU = HEADERTYPE.STANDARD_HEADER;
        this.dBV = 2.5f;
        this.mLastMotionY = -1.0f;
        this.dBE = true;
        this.dBF = false;
        this.dBG = false;
        this.dBH = true;
        this.dBI = false;
        this.dBJ = ILoadingLayout.State.NONE;
        this.dBK = ILoadingLayout.State.NONE;
        this.dBN = -1;
        this.dBY = false;
        this.dBZ = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dBA = f(context, attributeSet);
        this.dBB = g(context, attributeSet);
        this.dBL = createRefreshableView(context, attributeSet);
        if (this.dBL == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.dBL);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (aKP()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.dBI = false;
                    return false;
                } else if (action == 0 || !this.dBI) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.dBI = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || aKR()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.dBI = z;
                                    if (this.dBI && aKO()) {
                                        this.dBL.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.dBI = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.dBI;
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
                this.dBI = false;
                return false;
            case 1:
            case 3:
                if (this.dBI) {
                    this.dBI = false;
                    if (isReadyForPullDown()) {
                        if (this.dBE) {
                            if (this.dBJ == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.dBY && this.dBJ == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                aKS();
                                if (this.dCa) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.dBJ = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.dBK == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.dBV);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.dBV);
                    return true;
                } else {
                    this.dBI = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.dBE = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.dBF = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.dBG = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.dBE && this.dBA != null;
    }

    public boolean isPullLoadEnabled() {
        return this.dBF && this.dBB != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.dBW = aVar;
    }

    public T getRefreshableView() {
        return this.dBL;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.dBO;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.dBA;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.dBB;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.dBA != null) {
            this.dBA.setLastUpdatedLabel(charSequence);
        }
        if (this.dBB != null) {
            this.dBB.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.dBN = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.dBA != null) {
            this.dBA.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.dBA != null) {
            this.dBA.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.dBA != null) {
            this.dBA.setHeaderBigBackground(i);
        }
    }

    protected boolean aKO() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        aKQ();
        LoadingLayout loadingLayout = null;
        switch (this.dBU) {
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
        if (this.dBM != null) {
            this.dBM.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.dBA;
        LoadingLayout loadingLayout2 = this.dBB;
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
        if (this.dBA != null) {
            this.dBA.layout(this.dBA.getLeft(), this.dBA.getTop() - this.dBA.getHeight(), this.dBA.getRight(), this.dBA.getBottom() - this.dBA.getHeight());
            this.dBC = this.dBA.getContentSize();
        }
        if (this.dBB != null && this.dBL != null) {
            this.dBB.layout(this.dBB.getLeft(), this.dBL.getBottom(), this.dBB.getRight(), this.dBL.getBottom() + this.dBB.getHeight());
            this.dBD = this.dBB.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.dCa = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            ao(0, 0);
        } else if (this.dBN <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.dBN) {
            ap(0, -((int) f));
            if (this.dBA != null && this.dBC != 0) {
                this.dBA.onPull(Math.abs(getScrollYValue()) / this.dBC);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !aKR()) {
                if (this.dBY && abs > this.dBC * this.dBZ * 2.0f) {
                    this.dBJ = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.dBC * this.dBZ) {
                    this.dBJ = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.dBJ = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.dBA != null) {
                    this.dBA.setState(this.dBJ);
                }
                a(this.dBJ, true);
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
        if (this.dBB != null && this.dBD != 0) {
            this.dBB.onPull(Math.abs(getScrollYValue()) / this.dBD);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.dBD) {
                this.dBK = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.dBK = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.dBB != null) {
                this.dBB.setState(this.dBK);
            }
            a(this.dBK, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean aKR = aKR();
        if ((isPullRefreshing || aKR) && abs <= this.dBC) {
            km(0);
        } else if (isPullRefreshing || aKR) {
            km(-this.dBC);
        } else {
            km(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.dBD) {
            km(0);
        } else if (isPullLoading) {
            km(this.dBD);
        } else {
            km(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.dBJ == ILoadingLayout.State.REFRESHING;
    }

    protected boolean aKR() {
        return this.dBJ == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.dBK == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        gK(true);
    }

    private void gK(boolean z) {
        if (!isPullRefreshing() && !aKR()) {
            this.dBJ = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.dBA != null) {
                this.dBA.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.dBW != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dBW.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void aKS() {
        gL(true);
    }

    private void gL(boolean z) {
        if (!isPullRefreshing() && !aKR()) {
            this.dBJ = ILoadingLayout.State.LONG_REFRESHING;
            a(this.dBJ, true);
            if (this.dBA != null) {
                this.dBA.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.dBW != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dBW.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.dBK = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.dBB != null) {
                this.dBB.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.dBW != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dBW.d(PullToRefreshBaseNew.this);
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

    private void km(int i) {
        e(i, getSmoothScrollDuration(), 0L);
    }

    private void e(int i, long j, long j2) {
        if (this.dBX != null) {
            this.dBX.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.dBX = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.dBX, j2);
            } else {
                post(this.dBX);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.dBH = z;
    }

    private boolean aKP() {
        return this.dBH;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.dBY = z;
    }

    public void setPullRatio(float f) {
        this.dBZ = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class b implements Runnable {
        private final int bNI;
        private final int bNJ;
        private final long mDuration;
        private boolean bNL = true;
        private long mStartTime = -1;
        private int bNM = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.bNJ = i;
            this.bNI = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.ao(0, this.bNI);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bNM = this.bNJ - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bNJ - this.bNI));
                PullToRefreshBaseNew.this.ao(0, this.bNM);
            }
            if (this.bNL && this.bNI != this.bNM) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.bNL = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void aKQ() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.dBV = f;
    }
}
