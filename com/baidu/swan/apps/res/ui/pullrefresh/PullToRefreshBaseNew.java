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
    private LoadingLayout dbA;
    private LoadingLayout dbB;
    private int dbC;
    private int dbD;
    private boolean dbE;
    private boolean dbF;
    private boolean dbG;
    private boolean dbH;
    private boolean dbI;
    private ILoadingLayout.State dbJ;
    private ILoadingLayout.State dbK;
    T dbL;
    private FrameLayout dbM;
    private int dbN;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> dbO;
    protected HEADERTYPE dbU;
    private float dbV;
    private a<T> dbW;
    private PullToRefreshBaseNew<T>.b dbX;
    private boolean dbY;
    private float dbZ;
    private boolean dca;
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
        this.dbU = HEADERTYPE.STANDARD_HEADER;
        this.dbV = 2.5f;
        this.mLastMotionY = -1.0f;
        this.dbE = true;
        this.dbF = false;
        this.dbG = false;
        this.dbH = true;
        this.dbI = false;
        this.dbJ = ILoadingLayout.State.NONE;
        this.dbK = ILoadingLayout.State.NONE;
        this.dbN = -1;
        this.dbY = false;
        this.dbZ = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dbU = HEADERTYPE.STANDARD_HEADER;
        this.dbV = 2.5f;
        this.mLastMotionY = -1.0f;
        this.dbE = true;
        this.dbF = false;
        this.dbG = false;
        this.dbH = true;
        this.dbI = false;
        this.dbJ = ILoadingLayout.State.NONE;
        this.dbK = ILoadingLayout.State.NONE;
        this.dbN = -1;
        this.dbY = false;
        this.dbZ = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dbA = e(context, attributeSet);
        this.dbB = f(context, attributeSet);
        this.dbL = createRefreshableView(context, attributeSet);
        if (this.dbL == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.dbL);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (aCl()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.dbI = false;
                    return false;
                } else if (action == 0 || !this.dbI) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.dbI = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || aCn()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.dbI = z;
                                    if (this.dbI && aCk()) {
                                        this.dbL.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.dbI = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.dbI;
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
                this.dbI = false;
                return false;
            case 1:
            case 3:
                if (this.dbI) {
                    this.dbI = false;
                    if (isReadyForPullDown()) {
                        if (this.dbE) {
                            if (this.dbJ == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.dbY && this.dbJ == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                aCo();
                                if (this.dca) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.dbJ = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.dbK == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.dbV);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.dbV);
                    return true;
                } else {
                    this.dbI = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.dbE = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.dbF = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.dbG = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.dbE && this.dbA != null;
    }

    public boolean isPullLoadEnabled() {
        return this.dbF && this.dbB != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.dbW = aVar;
    }

    public T getRefreshableView() {
        return this.dbL;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.dbO;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.dbA;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.dbB;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.dbA != null) {
            this.dbA.setLastUpdatedLabel(charSequence);
        }
        if (this.dbB != null) {
            this.dbB.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.dbN = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.dbA != null) {
            this.dbA.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.dbA != null) {
            this.dbA.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.dbA != null) {
            this.dbA.setHeaderBigBackground(i);
        }
    }

    protected boolean aCk() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        aCm();
        LoadingLayout loadingLayout = null;
        switch (this.dbU) {
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
        if (this.dbM != null) {
            this.dbM.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.dbA;
        LoadingLayout loadingLayout2 = this.dbB;
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
        if (this.dbA != null) {
            this.dbA.layout(this.dbA.getLeft(), this.dbA.getTop() - this.dbA.getHeight(), this.dbA.getRight(), this.dbA.getBottom() - this.dbA.getHeight());
            this.dbC = this.dbA.getContentSize();
        }
        if (this.dbB != null && this.dbL != null) {
            this.dbB.layout(this.dbB.getLeft(), this.dbL.getBottom(), this.dbB.getRight(), this.dbL.getBottom() + this.dbB.getHeight());
            this.dbD = this.dbB.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.dca = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            ap(0, 0);
        } else if (this.dbN <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.dbN) {
            aq(0, -((int) f));
            if (this.dbA != null && this.dbC != 0) {
                this.dbA.onPull(Math.abs(getScrollYValue()) / this.dbC);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !aCn()) {
                if (this.dbY && abs > this.dbC * this.dbZ * 2.0f) {
                    this.dbJ = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.dbC * this.dbZ) {
                    this.dbJ = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.dbJ = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.dbA != null) {
                    this.dbA.setState(this.dbJ);
                }
                a(this.dbJ, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            ap(0, 0);
            return;
        }
        aq(0, -((int) f));
        if (this.dbB != null && this.dbD != 0) {
            this.dbB.onPull(Math.abs(getScrollYValue()) / this.dbD);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.dbD) {
                this.dbK = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.dbK = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.dbB != null) {
                this.dbB.setState(this.dbK);
            }
            a(this.dbK, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean aCn = aCn();
        if ((isPullRefreshing || aCn) && abs <= this.dbC) {
            jy(0);
        } else if (isPullRefreshing || aCn) {
            jy(-this.dbC);
        } else {
            jy(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.dbD) {
            jy(0);
        } else if (isPullLoading) {
            jy(this.dbD);
        } else {
            jy(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.dbJ == ILoadingLayout.State.REFRESHING;
    }

    protected boolean aCn() {
        return this.dbJ == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.dbK == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        fN(true);
    }

    private void fN(boolean z) {
        if (!isPullRefreshing() && !aCn()) {
            this.dbJ = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.dbA != null) {
                this.dbA.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.dbW != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dbW.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void aCo() {
        fO(true);
    }

    private void fO(boolean z) {
        if (!isPullRefreshing() && !aCn()) {
            this.dbJ = ILoadingLayout.State.LONG_REFRESHING;
            a(this.dbJ, true);
            if (this.dbA != null) {
                this.dbA.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.dbW != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dbW.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.dbK = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.dbB != null) {
                this.dbB.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.dbW != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dbW.d(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(int i, int i2) {
        scrollTo(i, i2);
    }

    private void aq(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void jy(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.dbX != null) {
            this.dbX.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.dbX = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.dbX, j2);
            } else {
                post(this.dbX);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.dbH = z;
    }

    private boolean aCl() {
        return this.dbH;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.dbY = z;
    }

    public void setPullRatio(float f) {
        this.dbZ = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public final class b implements Runnable {
        private final int bwY;
        private final int bwZ;
        private final long mDuration;
        private boolean bxb = true;
        private long mStartTime = -1;
        private int bxc = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.bwZ = i;
            this.bwY = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.ap(0, this.bwY);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bxc = this.bwZ - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bwZ - this.bwY));
                PullToRefreshBaseNew.this.ap(0, this.bxc);
            }
            if (this.bxb && this.bwY != this.bxc) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.bxb = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void aCm() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.dbV = f;
    }
}
