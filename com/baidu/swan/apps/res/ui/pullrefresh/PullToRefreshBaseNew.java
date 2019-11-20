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
    private LoadingLayout beO;
    private LoadingLayout beP;
    private int beQ;
    private int beR;
    private boolean beS;
    private boolean beT;
    private boolean beU;
    private boolean beV;
    private boolean beW;
    private ILoadingLayout.State beX;
    private ILoadingLayout.State beY;
    T beZ;
    private FrameLayout bfa;
    private int bfc;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> bfd;
    protected HEADERTYPE bfj;
    private float bfk;
    private a<T> bfl;
    private PullToRefreshBaseNew<T>.b bfm;
    private boolean bfn;
    private float bfo;
    private boolean bfp;
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
        this.bfj = HEADERTYPE.STANDARD_HEADER;
        this.bfk = 2.5f;
        this.mLastMotionY = -1.0f;
        this.beS = true;
        this.beT = false;
        this.beU = false;
        this.beV = true;
        this.beW = false;
        this.beX = ILoadingLayout.State.NONE;
        this.beY = ILoadingLayout.State.NONE;
        this.bfc = -1;
        this.bfn = false;
        this.bfo = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfj = HEADERTYPE.STANDARD_HEADER;
        this.bfk = 2.5f;
        this.mLastMotionY = -1.0f;
        this.beS = true;
        this.beT = false;
        this.beU = false;
        this.beV = true;
        this.beW = false;
        this.beX = ILoadingLayout.State.NONE;
        this.beY = ILoadingLayout.State.NONE;
        this.bfc = -1;
        this.bfn = false;
        this.bfo = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.beO = f(context, attributeSet);
        this.beP = g(context, attributeSet);
        this.beZ = createRefreshableView(context, attributeSet);
        if (this.beZ == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.beZ);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (Pv()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.beW = false;
                    return false;
                } else if (action == 0 || !this.beW) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.beW = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || Px()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.beW = z;
                                    if (this.beW && Pu()) {
                                        this.beZ.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.beW = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.beW;
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
                this.beW = false;
                return false;
            case 1:
            case 3:
                if (this.beW) {
                    this.beW = false;
                    if (isReadyForPullDown()) {
                        if (this.beS) {
                            if (this.beX == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.bfn && this.beX == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                Py();
                                if (this.bfp) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.beX = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.beY == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.bfk);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.bfk);
                    return true;
                } else {
                    this.beW = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.beS = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.beT = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.beU = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.beS && this.beO != null;
    }

    public boolean isPullLoadEnabled() {
        return this.beT && this.beP != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.bfl = aVar;
    }

    public T getRefreshableView() {
        return this.beZ;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.bfd;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.beO;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.beP;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.beO != null) {
            this.beO.setLastUpdatedLabel(charSequence);
        }
        if (this.beP != null) {
            this.beP.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.bfc = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.beO != null) {
            this.beO.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.beO != null) {
            this.beO.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.beO != null) {
            this.beO.setHeaderBigBackground(i);
        }
    }

    protected boolean Pu() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        Pw();
        LoadingLayout loadingLayout = null;
        switch (this.bfj) {
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
        if (this.bfa != null) {
            this.bfa.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.beO;
        LoadingLayout loadingLayout2 = this.beP;
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
        if (this.beO != null) {
            this.beO.layout(this.beO.getLeft(), this.beO.getTop() - this.beO.getHeight(), this.beO.getRight(), this.beO.getBottom() - this.beO.getHeight());
            this.beQ = this.beO.getContentSize();
        }
        if (this.beP != null && this.beZ != null) {
            this.beP.layout(this.beP.getLeft(), this.beZ.getBottom(), this.beP.getRight(), this.beZ.getBottom() + this.beP.getHeight());
            this.beR = this.beP.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.bfp = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            J(0, 0);
        } else if (this.bfc <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.bfc) {
            K(0, -((int) f));
            if (this.beO != null && this.beQ != 0) {
                this.beO.onPull(Math.abs(getScrollYValue()) / this.beQ);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !Px()) {
                if (this.bfn && abs > this.beQ * this.bfo * 2.0f) {
                    this.beX = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.beQ * this.bfo) {
                    this.beX = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.beX = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                this.beO.setState(this.beX);
                a(this.beX, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            J(0, 0);
            return;
        }
        K(0, -((int) f));
        if (this.beP != null && this.beR != 0) {
            this.beP.onPull(Math.abs(getScrollYValue()) / this.beR);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.beR) {
                this.beY = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.beY = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            this.beP.setState(this.beY);
            a(this.beY, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean Px = Px();
        if ((isPullRefreshing || Px) && abs <= this.beQ) {
            ea(0);
        } else if (isPullRefreshing || Px) {
            ea(-this.beQ);
        } else {
            ea(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.beR) {
            ea(0);
        } else if (isPullLoading) {
            ea(this.beR);
        } else {
            ea(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.beX == ILoadingLayout.State.REFRESHING;
    }

    protected boolean Px() {
        return this.beX == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.beY == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        cf(true);
    }

    private void cf(boolean z) {
        if (!isPullRefreshing() && !Px()) {
            this.beX = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.beO != null) {
                this.beO.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.bfl != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bfl.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void Py() {
        cg(true);
    }

    private void cg(boolean z) {
        if (!isPullRefreshing() && !Px()) {
            this.beX = ILoadingLayout.State.LONG_REFRESHING;
            a(this.beX, true);
            if (this.beO != null) {
                this.beO.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.bfl != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bfl.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.beY = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.beP != null) {
                this.beP.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.bfl != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bfl.d(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i, int i2) {
        scrollTo(i, i2);
    }

    private void K(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void ea(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.bfm != null) {
            this.bfm.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.bfm = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.bfm, j2);
            } else {
                post(this.bfm);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.beV = z;
    }

    private boolean Pv() {
        return this.beV;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.bfn = z;
    }

    public void setPullRatio(float f) {
        this.bfo = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b implements Runnable {
        private final int aqD;
        private final int aqE;
        private final long mDuration;
        private boolean aqG = true;
        private long mStartTime = -1;
        private int aqH = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.aqE = i;
            this.aqD = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.J(0, this.aqD);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aqH = this.aqE - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aqE - this.aqD));
                PullToRefreshBaseNew.this.J(0, this.aqH);
            }
            if (this.aqG && this.aqD != this.aqH) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.aqG = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void Pw() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.bfk = f;
    }
}
