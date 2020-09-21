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
/* loaded from: classes3.dex */
public abstract class PullToRefreshBaseNew<T extends View> extends FrameLayout {
    private boolean cPA;
    private boolean cPB;
    private boolean cPC;
    private boolean cPD;
    private ILoadingLayout.State cPE;
    private ILoadingLayout.State cPF;
    T cPG;
    private FrameLayout cPH;
    private int cPI;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> cPJ;
    protected HEADERTYPE cPP;
    private float cPQ;
    private a<T> cPR;
    private PullToRefreshBaseNew<T>.b cPS;
    private boolean cPT;
    private float cPU;
    private boolean cPV;
    private LoadingLayout cPv;
    private LoadingLayout cPw;
    private int cPx;
    private int cPy;
    private boolean cPz;
    private float mLastMotionY;
    private int mTouchSlop;

    /* loaded from: classes3.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER
    }

    /* loaded from: classes3.dex */
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
        this.cPP = HEADERTYPE.STANDARD_HEADER;
        this.cPQ = 2.5f;
        this.mLastMotionY = -1.0f;
        this.cPz = true;
        this.cPA = false;
        this.cPB = false;
        this.cPC = true;
        this.cPD = false;
        this.cPE = ILoadingLayout.State.NONE;
        this.cPF = ILoadingLayout.State.NONE;
        this.cPI = -1;
        this.cPT = false;
        this.cPU = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cPP = HEADERTYPE.STANDARD_HEADER;
        this.cPQ = 2.5f;
        this.mLastMotionY = -1.0f;
        this.cPz = true;
        this.cPA = false;
        this.cPB = false;
        this.cPC = true;
        this.cPD = false;
        this.cPE = ILoadingLayout.State.NONE;
        this.cPF = ILoadingLayout.State.NONE;
        this.cPI = -1;
        this.cPT = false;
        this.cPU = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.cPv = e(context, attributeSet);
        this.cPw = f(context, attributeSet);
        this.cPG = createRefreshableView(context, attributeSet);
        if (this.cPG == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.cPG);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (azC()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.cPD = false;
                    return false;
                } else if (action == 0 || !this.cPD) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.cPD = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || azE()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.cPD = z;
                                    if (this.cPD && azB()) {
                                        this.cPG.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.cPD = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.cPD;
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
                this.cPD = false;
                return false;
            case 1:
            case 3:
                if (this.cPD) {
                    this.cPD = false;
                    if (isReadyForPullDown()) {
                        if (this.cPz) {
                            if (this.cPE == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.cPT && this.cPE == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                azF();
                                if (this.cPV) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.cPE = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.cPF == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.cPQ);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.cPQ);
                    return true;
                } else {
                    this.cPD = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.cPz = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.cPA = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.cPB = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.cPz && this.cPv != null;
    }

    public boolean isPullLoadEnabled() {
        return this.cPA && this.cPw != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.cPR = aVar;
    }

    public T getRefreshableView() {
        return this.cPG;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.cPJ;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.cPv;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.cPw;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.cPv != null) {
            this.cPv.setLastUpdatedLabel(charSequence);
        }
        if (this.cPw != null) {
            this.cPw.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.cPI = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.cPv != null) {
            this.cPv.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.cPv != null) {
            this.cPv.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.cPv != null) {
            this.cPv.setHeaderBigBackground(i);
        }
    }

    protected boolean azB() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        azD();
        LoadingLayout loadingLayout = null;
        switch (this.cPP) {
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
        if (this.cPH != null) {
            this.cPH.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.cPv;
        LoadingLayout loadingLayout2 = this.cPw;
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
        if (this.cPv != null) {
            this.cPv.layout(this.cPv.getLeft(), this.cPv.getTop() - this.cPv.getHeight(), this.cPv.getRight(), this.cPv.getBottom() - this.cPv.getHeight());
            this.cPx = this.cPv.getContentSize();
        }
        if (this.cPw != null && this.cPG != null) {
            this.cPw.layout(this.cPw.getLeft(), this.cPG.getBottom(), this.cPw.getRight(), this.cPG.getBottom() + this.cPw.getHeight());
            this.cPy = this.cPw.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.cPV = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            aq(0, 0);
        } else if (this.cPI <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.cPI) {
            ar(0, -((int) f));
            if (this.cPv != null && this.cPx != 0) {
                this.cPv.onPull(Math.abs(getScrollYValue()) / this.cPx);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !azE()) {
                if (this.cPT && abs > this.cPx * this.cPU * 2.0f) {
                    this.cPE = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.cPx * this.cPU) {
                    this.cPE = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.cPE = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.cPv != null) {
                    this.cPv.setState(this.cPE);
                }
                a(this.cPE, true);
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
        if (this.cPw != null && this.cPy != 0) {
            this.cPw.onPull(Math.abs(getScrollYValue()) / this.cPy);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.cPy) {
                this.cPF = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.cPF = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.cPw != null) {
                this.cPw.setState(this.cPF);
            }
            a(this.cPF, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean azE = azE();
        if ((isPullRefreshing || azE) && abs <= this.cPx) {
            jb(0);
        } else if (isPullRefreshing || azE) {
            jb(-this.cPx);
        } else {
            jb(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.cPy) {
            jb(0);
        } else if (isPullLoading) {
            jb(this.cPy);
        } else {
            jb(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.cPE == ILoadingLayout.State.REFRESHING;
    }

    protected boolean azE() {
        return this.cPE == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.cPF == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        fr(true);
    }

    private void fr(boolean z) {
        if (!isPullRefreshing() && !azE()) {
            this.cPE = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.cPv != null) {
                this.cPv.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.cPR != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.cPR.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void azF() {
        fs(true);
    }

    private void fs(boolean z) {
        if (!isPullRefreshing() && !azE()) {
            this.cPE = ILoadingLayout.State.LONG_REFRESHING;
            a(this.cPE, true);
            if (this.cPv != null) {
                this.cPv.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.cPR != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.cPR.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.cPF = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.cPw != null) {
                this.cPw.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.cPR != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.cPR.d(PullToRefreshBaseNew.this);
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

    private void jb(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.cPS != null) {
            this.cPS.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.cPS = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.cPS, j2);
            } else {
                post(this.cPS);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.cPC = z;
    }

    private boolean azC() {
        return this.cPC;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.cPT = z;
    }

    public void setPullRatio(float f) {
        this.cPU = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class b implements Runnable {
        private final int btk;
        private final int btl;
        private final long mDuration;
        private boolean bto = true;
        private long mStartTime = -1;
        private int btp = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.btl = i;
            this.btk = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.aq(0, this.btk);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.btp = this.btl - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.btl - this.btk));
                PullToRefreshBaseNew.this.aq(0, this.btp);
            }
            if (this.bto && this.btk != this.btp) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.bto = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void azD() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.cPQ = f;
    }
}
