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
    private ILoadingLayout.State cNA;
    private ILoadingLayout.State cNB;
    T cNC;
    private FrameLayout cND;
    private int cNE;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> cNF;
    protected HEADERTYPE cNL;
    private float cNM;
    private a<T> cNN;
    private PullToRefreshBaseNew<T>.b cNO;
    private boolean cNP;
    private float cNQ;
    private boolean cNR;
    private LoadingLayout cNr;
    private LoadingLayout cNs;
    private int cNt;
    private int cNu;
    private boolean cNv;
    private boolean cNw;
    private boolean cNx;
    private boolean cNy;
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
        this.cNL = HEADERTYPE.STANDARD_HEADER;
        this.cNM = 2.5f;
        this.mLastMotionY = -1.0f;
        this.cNv = true;
        this.cNw = false;
        this.cNx = false;
        this.cNy = true;
        this.cNz = false;
        this.cNA = ILoadingLayout.State.NONE;
        this.cNB = ILoadingLayout.State.NONE;
        this.cNE = -1;
        this.cNP = false;
        this.cNQ = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cNL = HEADERTYPE.STANDARD_HEADER;
        this.cNM = 2.5f;
        this.mLastMotionY = -1.0f;
        this.cNv = true;
        this.cNw = false;
        this.cNx = false;
        this.cNy = true;
        this.cNz = false;
        this.cNA = ILoadingLayout.State.NONE;
        this.cNB = ILoadingLayout.State.NONE;
        this.cNE = -1;
        this.cNP = false;
        this.cNQ = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.cNr = e(context, attributeSet);
        this.cNs = f(context, attributeSet);
        this.cNC = createRefreshableView(context, attributeSet);
        if (this.cNC == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.cNC);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (ayT()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.cNz = false;
                    return false;
                } else if (action == 0 || !this.cNz) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.cNz = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || ayV()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.cNz = z;
                                    if (this.cNz && ayS()) {
                                        this.cNC.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.cNz = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.cNz;
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
                this.cNz = false;
                return false;
            case 1:
            case 3:
                if (this.cNz) {
                    this.cNz = false;
                    if (isReadyForPullDown()) {
                        if (this.cNv) {
                            if (this.cNA == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.cNP && this.cNA == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                ayW();
                                if (this.cNR) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.cNA = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.cNB == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.cNM);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.cNM);
                    return true;
                } else {
                    this.cNz = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.cNv = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.cNw = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.cNx = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.cNv && this.cNr != null;
    }

    public boolean isPullLoadEnabled() {
        return this.cNw && this.cNs != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.cNN = aVar;
    }

    public T getRefreshableView() {
        return this.cNC;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.cNF;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.cNr;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.cNs;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.cNr != null) {
            this.cNr.setLastUpdatedLabel(charSequence);
        }
        if (this.cNs != null) {
            this.cNs.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.cNE = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.cNr != null) {
            this.cNr.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.cNr != null) {
            this.cNr.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.cNr != null) {
            this.cNr.setHeaderBigBackground(i);
        }
    }

    protected boolean ayS() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        ayU();
        LoadingLayout loadingLayout = null;
        switch (this.cNL) {
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
        if (this.cND != null) {
            this.cND.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.cNr;
        LoadingLayout loadingLayout2 = this.cNs;
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
        if (this.cNr != null) {
            this.cNr.layout(this.cNr.getLeft(), this.cNr.getTop() - this.cNr.getHeight(), this.cNr.getRight(), this.cNr.getBottom() - this.cNr.getHeight());
            this.cNt = this.cNr.getContentSize();
        }
        if (this.cNs != null && this.cNC != null) {
            this.cNs.layout(this.cNs.getLeft(), this.cNC.getBottom(), this.cNs.getRight(), this.cNC.getBottom() + this.cNs.getHeight());
            this.cNu = this.cNs.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.cNR = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            aq(0, 0);
        } else if (this.cNE <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.cNE) {
            ar(0, -((int) f));
            if (this.cNr != null && this.cNt != 0) {
                this.cNr.onPull(Math.abs(getScrollYValue()) / this.cNt);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !ayV()) {
                if (this.cNP && abs > this.cNt * this.cNQ * 2.0f) {
                    this.cNA = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.cNt * this.cNQ) {
                    this.cNA = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.cNA = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.cNr != null) {
                    this.cNr.setState(this.cNA);
                }
                a(this.cNA, true);
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
        if (this.cNs != null && this.cNu != 0) {
            this.cNs.onPull(Math.abs(getScrollYValue()) / this.cNu);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.cNu) {
                this.cNB = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.cNB = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.cNs != null) {
                this.cNs.setState(this.cNB);
            }
            a(this.cNB, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean ayV = ayV();
        if ((isPullRefreshing || ayV) && abs <= this.cNt) {
            iQ(0);
        } else if (isPullRefreshing || ayV) {
            iQ(-this.cNt);
        } else {
            iQ(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.cNu) {
            iQ(0);
        } else if (isPullLoading) {
            iQ(this.cNu);
        } else {
            iQ(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.cNA == ILoadingLayout.State.REFRESHING;
    }

    protected boolean ayV() {
        return this.cNA == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.cNB == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        fs(true);
    }

    private void fs(boolean z) {
        if (!isPullRefreshing() && !ayV()) {
            this.cNA = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.cNr != null) {
                this.cNr.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.cNN != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.cNN.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void ayW() {
        ft(true);
    }

    private void ft(boolean z) {
        if (!isPullRefreshing() && !ayV()) {
            this.cNA = ILoadingLayout.State.LONG_REFRESHING;
            a(this.cNA, true);
            if (this.cNr != null) {
                this.cNr.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.cNN != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.cNN.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.cNB = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.cNs != null) {
                this.cNs.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.cNN != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.cNN.d(PullToRefreshBaseNew.this);
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
        if (this.cNO != null) {
            this.cNO.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.cNO = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.cNO, j2);
            } else {
                post(this.cNO);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.cNy = z;
    }

    private boolean ayT() {
        return this.cNy;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.cNP = z;
    }

    public void setPullRatio(float f) {
        this.cNQ = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public final class b implements Runnable {
        private final int bpY;
        private final int bpZ;
        private final long mDuration;
        private boolean bqb = true;
        private long mStartTime = -1;
        private int bqc = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.bpZ = i;
            this.bpY = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.aq(0, this.bpY);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bqc = this.bpZ - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bpZ - this.bpY));
                PullToRefreshBaseNew.this.aq(0, this.bqc);
            }
            if (this.bqb && this.bpY != this.bqc) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.bqb = false;
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
        this.cNM = f;
    }
}
