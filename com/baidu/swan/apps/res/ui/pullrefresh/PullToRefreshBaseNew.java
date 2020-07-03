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
    private LoadingLayout cBG;
    private LoadingLayout cBH;
    private int cBI;
    private int cBJ;
    private boolean cBK;
    private boolean cBL;
    private boolean cBM;
    private boolean cBN;
    private boolean cBO;
    private ILoadingLayout.State cBP;
    private ILoadingLayout.State cBQ;
    T cBR;
    private FrameLayout cBS;
    private int cBT;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> cBU;
    protected HEADERTYPE cCa;
    private float cCb;
    private a<T> cCc;
    private PullToRefreshBaseNew<T>.b cCd;
    private boolean cCe;
    private float cCf;
    private boolean cCg;
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
        this.cCa = HEADERTYPE.STANDARD_HEADER;
        this.cCb = 2.5f;
        this.mLastMotionY = -1.0f;
        this.cBK = true;
        this.cBL = false;
        this.cBM = false;
        this.cBN = true;
        this.cBO = false;
        this.cBP = ILoadingLayout.State.NONE;
        this.cBQ = ILoadingLayout.State.NONE;
        this.cBT = -1;
        this.cCe = false;
        this.cCf = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cCa = HEADERTYPE.STANDARD_HEADER;
        this.cCb = 2.5f;
        this.mLastMotionY = -1.0f;
        this.cBK = true;
        this.cBL = false;
        this.cBM = false;
        this.cBN = true;
        this.cBO = false;
        this.cBP = ILoadingLayout.State.NONE;
        this.cBQ = ILoadingLayout.State.NONE;
        this.cBT = -1;
        this.cCe = false;
        this.cCf = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.cBG = e(context, attributeSet);
        this.cBH = f(context, attributeSet);
        this.cBR = createRefreshableView(context, attributeSet);
        if (this.cBR == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.cBR);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (aoX()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.cBO = false;
                    return false;
                } else if (action == 0 || !this.cBO) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.cBO = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || aoZ()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.cBO = z;
                                    if (this.cBO && aoW()) {
                                        this.cBR.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.cBO = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.cBO;
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
                this.cBO = false;
                return false;
            case 1:
            case 3:
                if (this.cBO) {
                    this.cBO = false;
                    if (isReadyForPullDown()) {
                        if (this.cBK) {
                            if (this.cBP == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.cCe && this.cBP == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                apa();
                                if (this.cCg) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.cBP = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.cBQ == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.cCb);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.cCb);
                    return true;
                } else {
                    this.cBO = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.cBK = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.cBL = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.cBM = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.cBK && this.cBG != null;
    }

    public boolean isPullLoadEnabled() {
        return this.cBL && this.cBH != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.cCc = aVar;
    }

    public T getRefreshableView() {
        return this.cBR;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.cBU;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.cBG;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.cBH;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.cBG != null) {
            this.cBG.setLastUpdatedLabel(charSequence);
        }
        if (this.cBH != null) {
            this.cBH.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.cBT = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.cBG != null) {
            this.cBG.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.cBG != null) {
            this.cBG.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.cBG != null) {
            this.cBG.setHeaderBigBackground(i);
        }
    }

    protected boolean aoW() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        aoY();
        LoadingLayout loadingLayout = null;
        switch (this.cCa) {
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
        if (this.cBS != null) {
            this.cBS.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.cBG;
        LoadingLayout loadingLayout2 = this.cBH;
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
        if (this.cBG != null) {
            this.cBG.layout(this.cBG.getLeft(), this.cBG.getTop() - this.cBG.getHeight(), this.cBG.getRight(), this.cBG.getBottom() - this.cBG.getHeight());
            this.cBI = this.cBG.getContentSize();
        }
        if (this.cBH != null && this.cBR != null) {
            this.cBH.layout(this.cBH.getLeft(), this.cBR.getBottom(), this.cBH.getRight(), this.cBR.getBottom() + this.cBH.getHeight());
            this.cBJ = this.cBH.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.cCg = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            al(0, 0);
        } else if (this.cBT <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.cBT) {
            am(0, -((int) f));
            if (this.cBG != null && this.cBI != 0) {
                this.cBG.onPull(Math.abs(getScrollYValue()) / this.cBI);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !aoZ()) {
                if (this.cCe && abs > this.cBI * this.cCf * 2.0f) {
                    this.cBP = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.cBI * this.cCf) {
                    this.cBP = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.cBP = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.cBG != null) {
                    this.cBG.setState(this.cBP);
                }
                a(this.cBP, true);
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
        if (this.cBH != null && this.cBJ != 0) {
            this.cBH.onPull(Math.abs(getScrollYValue()) / this.cBJ);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.cBJ) {
                this.cBQ = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.cBQ = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.cBH != null) {
                this.cBH.setState(this.cBQ);
            }
            a(this.cBQ, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean aoZ = aoZ();
        if ((isPullRefreshing || aoZ) && abs <= this.cBI) {
            gA(0);
        } else if (isPullRefreshing || aoZ) {
            gA(-this.cBI);
        } else {
            gA(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.cBJ) {
            gA(0);
        } else if (isPullLoading) {
            gA(this.cBJ);
        } else {
            gA(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.cBP == ILoadingLayout.State.REFRESHING;
    }

    protected boolean aoZ() {
        return this.cBP == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.cBQ == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        eQ(true);
    }

    private void eQ(boolean z) {
        if (!isPullRefreshing() && !aoZ()) {
            this.cBP = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.cBG != null) {
                this.cBG.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.cCc != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.cCc.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void apa() {
        eR(true);
    }

    private void eR(boolean z) {
        if (!isPullRefreshing() && !aoZ()) {
            this.cBP = ILoadingLayout.State.LONG_REFRESHING;
            a(this.cBP, true);
            if (this.cBG != null) {
                this.cBG.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.cCc != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.cCc.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.cBQ = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.cBH != null) {
                this.cBH.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.cCc != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.cCc.d(PullToRefreshBaseNew.this);
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

    private void gA(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.cCd != null) {
            this.cCd.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.cCd = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.cCd, j2);
            } else {
                post(this.cCd);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.cBN = z;
    }

    private boolean aoX() {
        return this.cBN;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.cCe = z;
    }

    public void setPullRatio(float f) {
        this.cCf = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public final class b implements Runnable {
        private final int bjZ;
        private final int bka;
        private final long mDuration;
        private boolean bkc = true;
        private long mStartTime = -1;
        private int bkd = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.bka = i;
            this.bjZ = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.al(0, this.bjZ);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bkd = this.bka - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bka - this.bjZ));
                PullToRefreshBaseNew.this.al(0, this.bkd);
            }
            if (this.bkc && this.bjZ != this.bkd) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.bkc = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void aoY() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.cCb = f;
    }
}
