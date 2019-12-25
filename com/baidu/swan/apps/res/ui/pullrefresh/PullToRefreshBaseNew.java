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
    private LoadingLayout bHA;
    private LoadingLayout bHB;
    private int bHC;
    private int bHD;
    private boolean bHE;
    private boolean bHF;
    private boolean bHG;
    private boolean bHH;
    private boolean bHI;
    private ILoadingLayout.State bHJ;
    private ILoadingLayout.State bHK;
    T bHL;
    private FrameLayout bHM;
    private int bHN;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> bHO;
    protected HEADERTYPE bHU;
    private float bHV;
    private a<T> bHW;
    private PullToRefreshBaseNew<T>.b bHX;
    private boolean bHY;
    private float bHZ;
    private boolean bIa;
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
        this.bHU = HEADERTYPE.STANDARD_HEADER;
        this.bHV = 2.5f;
        this.mLastMotionY = -1.0f;
        this.bHE = true;
        this.bHF = false;
        this.bHG = false;
        this.bHH = true;
        this.bHI = false;
        this.bHJ = ILoadingLayout.State.NONE;
        this.bHK = ILoadingLayout.State.NONE;
        this.bHN = -1;
        this.bHY = false;
        this.bHZ = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHU = HEADERTYPE.STANDARD_HEADER;
        this.bHV = 2.5f;
        this.mLastMotionY = -1.0f;
        this.bHE = true;
        this.bHF = false;
        this.bHG = false;
        this.bHH = true;
        this.bHI = false;
        this.bHJ = ILoadingLayout.State.NONE;
        this.bHK = ILoadingLayout.State.NONE;
        this.bHN = -1;
        this.bHY = false;
        this.bHZ = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.bHA = e(context, attributeSet);
        this.bHB = f(context, attributeSet);
        this.bHL = createRefreshableView(context, attributeSet);
        if (this.bHL == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.bHL);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (Zj()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.bHI = false;
                    return false;
                } else if (action == 0 || !this.bHI) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.bHI = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || Zl()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.bHI = z;
                                    if (this.bHI && Zi()) {
                                        this.bHL.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.bHI = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.bHI;
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
                this.bHI = false;
                return false;
            case 1:
            case 3:
                if (this.bHI) {
                    this.bHI = false;
                    if (isReadyForPullDown()) {
                        if (this.bHE) {
                            if (this.bHJ == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.bHY && this.bHJ == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                Zm();
                                if (this.bIa) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.bHJ = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.bHK == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.bHV);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.bHV);
                    return true;
                } else {
                    this.bHI = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.bHE = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.bHF = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.bHG = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.bHE && this.bHA != null;
    }

    public boolean isPullLoadEnabled() {
        return this.bHF && this.bHB != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.bHW = aVar;
    }

    public T getRefreshableView() {
        return this.bHL;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.bHO;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.bHA;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.bHB;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.bHA != null) {
            this.bHA.setLastUpdatedLabel(charSequence);
        }
        if (this.bHB != null) {
            this.bHB.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.bHN = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.bHA != null) {
            this.bHA.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.bHA != null) {
            this.bHA.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.bHA != null) {
            this.bHA.setHeaderBigBackground(i);
        }
    }

    protected boolean Zi() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        Zk();
        LoadingLayout loadingLayout = null;
        switch (this.bHU) {
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
        if (this.bHM != null) {
            this.bHM.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.bHA;
        LoadingLayout loadingLayout2 = this.bHB;
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
        if (this.bHA != null) {
            this.bHA.layout(this.bHA.getLeft(), this.bHA.getTop() - this.bHA.getHeight(), this.bHA.getRight(), this.bHA.getBottom() - this.bHA.getHeight());
            this.bHC = this.bHA.getContentSize();
        }
        if (this.bHB != null && this.bHL != null) {
            this.bHB.layout(this.bHB.getLeft(), this.bHL.getBottom(), this.bHB.getRight(), this.bHL.getBottom() + this.bHB.getHeight());
            this.bHD = this.bHB.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.bIa = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            Z(0, 0);
        } else if (this.bHN <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.bHN) {
            aa(0, -((int) f));
            if (this.bHA != null && this.bHC != 0) {
                this.bHA.onPull(Math.abs(getScrollYValue()) / this.bHC);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !Zl()) {
                if (this.bHY && abs > this.bHC * this.bHZ * 2.0f) {
                    this.bHJ = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.bHC * this.bHZ) {
                    this.bHJ = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.bHJ = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.bHA != null) {
                    this.bHA.setState(this.bHJ);
                }
                a(this.bHJ, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            Z(0, 0);
            return;
        }
        aa(0, -((int) f));
        if (this.bHB != null && this.bHD != 0) {
            this.bHB.onPull(Math.abs(getScrollYValue()) / this.bHD);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.bHD) {
                this.bHK = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.bHK = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.bHB != null) {
                this.bHB.setState(this.bHK);
            }
            a(this.bHK, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean Zl = Zl();
        if ((isPullRefreshing || Zl) && abs <= this.bHC) {
            fx(0);
        } else if (isPullRefreshing || Zl) {
            fx(-this.bHC);
        } else {
            fx(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.bHD) {
            fx(0);
        } else if (isPullLoading) {
            fx(this.bHD);
        } else {
            fx(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.bHJ == ILoadingLayout.State.REFRESHING;
    }

    protected boolean Zl() {
        return this.bHJ == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.bHK == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        dj(true);
    }

    private void dj(boolean z) {
        if (!isPullRefreshing() && !Zl()) {
            this.bHJ = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.bHA != null) {
                this.bHA.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.bHW != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bHW.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void Zm() {
        dk(true);
    }

    private void dk(boolean z) {
        if (!isPullRefreshing() && !Zl()) {
            this.bHJ = ILoadingLayout.State.LONG_REFRESHING;
            a(this.bHJ, true);
            if (this.bHA != null) {
                this.bHA.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.bHW != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bHW.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.bHK = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.bHB != null) {
                this.bHB.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.bHW != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bHW.d(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i, int i2) {
        scrollTo(i, i2);
    }

    private void aa(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void fx(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.bHX != null) {
            this.bHX.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.bHX = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.bHX, j2);
            } else {
                post(this.bHX);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.bHH = z;
    }

    private boolean Zj() {
        return this.bHH;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.bHY = z;
    }

    public void setPullRatio(float f) {
        this.bHZ = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class b implements Runnable {
        private final int ays;
        private final int ayt;
        private final long mDuration;
        private boolean ayv = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.ayt = i;
            this.ays = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.Z(0, this.ays);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.ayt - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.ayt - this.ays));
                PullToRefreshBaseNew.this.Z(0, this.mCurrentY);
            }
            if (this.ayv && this.ays != this.mCurrentY) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.ayv = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void Zk() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.bHV = f;
    }
}
