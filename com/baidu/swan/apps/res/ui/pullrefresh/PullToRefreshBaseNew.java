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
    protected HEADERTYPE bIE;
    private float bIF;
    private a<T> bIG;
    private PullToRefreshBaseNew<T>.b bIH;
    private boolean bII;
    private float bIJ;
    private boolean bIK;
    private LoadingLayout bIk;
    private LoadingLayout bIl;
    private int bIm;
    private int bIn;
    private boolean bIo;
    private boolean bIp;
    private boolean bIq;
    private boolean bIr;
    private boolean bIs;
    private ILoadingLayout.State bIt;
    private ILoadingLayout.State bIu;
    T bIv;
    private FrameLayout bIw;
    private int bIx;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> bIy;
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
        this.bIE = HEADERTYPE.STANDARD_HEADER;
        this.bIF = 2.5f;
        this.mLastMotionY = -1.0f;
        this.bIo = true;
        this.bIp = false;
        this.bIq = false;
        this.bIr = true;
        this.bIs = false;
        this.bIt = ILoadingLayout.State.NONE;
        this.bIu = ILoadingLayout.State.NONE;
        this.bIx = -1;
        this.bII = false;
        this.bIJ = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bIE = HEADERTYPE.STANDARD_HEADER;
        this.bIF = 2.5f;
        this.mLastMotionY = -1.0f;
        this.bIo = true;
        this.bIp = false;
        this.bIq = false;
        this.bIr = true;
        this.bIs = false;
        this.bIt = ILoadingLayout.State.NONE;
        this.bIu = ILoadingLayout.State.NONE;
        this.bIx = -1;
        this.bII = false;
        this.bIJ = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.bIk = e(context, attributeSet);
        this.bIl = f(context, attributeSet);
        this.bIv = createRefreshableView(context, attributeSet);
        if (this.bIv == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.bIv);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (ZG()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.bIs = false;
                    return false;
                } else if (action == 0 || !this.bIs) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.bIs = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || ZI()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.bIs = z;
                                    if (this.bIs && ZF()) {
                                        this.bIv.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.bIs = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.bIs;
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
                this.bIs = false;
                return false;
            case 1:
            case 3:
                if (this.bIs) {
                    this.bIs = false;
                    if (isReadyForPullDown()) {
                        if (this.bIo) {
                            if (this.bIt == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.bII && this.bIt == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                ZJ();
                                if (this.bIK) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.bIt = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.bIu == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.bIF);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.bIF);
                    return true;
                } else {
                    this.bIs = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.bIo = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.bIp = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.bIq = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.bIo && this.bIk != null;
    }

    public boolean isPullLoadEnabled() {
        return this.bIp && this.bIl != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.bIG = aVar;
    }

    public T getRefreshableView() {
        return this.bIv;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.bIy;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.bIk;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.bIl;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.bIk != null) {
            this.bIk.setLastUpdatedLabel(charSequence);
        }
        if (this.bIl != null) {
            this.bIl.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.bIx = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.bIk != null) {
            this.bIk.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.bIk != null) {
            this.bIk.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.bIk != null) {
            this.bIk.setHeaderBigBackground(i);
        }
    }

    protected boolean ZF() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        ZH();
        LoadingLayout loadingLayout = null;
        switch (this.bIE) {
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
        if (this.bIw != null) {
            this.bIw.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.bIk;
        LoadingLayout loadingLayout2 = this.bIl;
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
        if (this.bIk != null) {
            this.bIk.layout(this.bIk.getLeft(), this.bIk.getTop() - this.bIk.getHeight(), this.bIk.getRight(), this.bIk.getBottom() - this.bIk.getHeight());
            this.bIm = this.bIk.getContentSize();
        }
        if (this.bIl != null && this.bIv != null) {
            this.bIl.layout(this.bIl.getLeft(), this.bIv.getBottom(), this.bIl.getRight(), this.bIv.getBottom() + this.bIl.getHeight());
            this.bIn = this.bIl.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.bIK = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            ad(0, 0);
        } else if (this.bIx <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.bIx) {
            ae(0, -((int) f));
            if (this.bIk != null && this.bIm != 0) {
                this.bIk.onPull(Math.abs(getScrollYValue()) / this.bIm);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !ZI()) {
                if (this.bII && abs > this.bIm * this.bIJ * 2.0f) {
                    this.bIt = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.bIm * this.bIJ) {
                    this.bIt = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.bIt = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.bIk != null) {
                    this.bIk.setState(this.bIt);
                }
                a(this.bIt, true);
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
        if (this.bIl != null && this.bIn != 0) {
            this.bIl.onPull(Math.abs(getScrollYValue()) / this.bIn);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.bIn) {
                this.bIu = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.bIu = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.bIl != null) {
                this.bIl.setState(this.bIu);
            }
            a(this.bIu, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean ZI = ZI();
        if ((isPullRefreshing || ZI) && abs <= this.bIm) {
            fy(0);
        } else if (isPullRefreshing || ZI) {
            fy(-this.bIm);
        } else {
            fy(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.bIn) {
            fy(0);
        } else if (isPullLoading) {
            fy(this.bIn);
        } else {
            fy(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.bIt == ILoadingLayout.State.REFRESHING;
    }

    protected boolean ZI() {
        return this.bIt == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.bIu == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        m22do(true);
    }

    /* renamed from: do  reason: not valid java name */
    private void m22do(boolean z) {
        if (!isPullRefreshing() && !ZI()) {
            this.bIt = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.bIk != null) {
                this.bIk.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.bIG != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bIG.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void ZJ() {
        dp(true);
    }

    private void dp(boolean z) {
        if (!isPullRefreshing() && !ZI()) {
            this.bIt = ILoadingLayout.State.LONG_REFRESHING;
            a(this.bIt, true);
            if (this.bIk != null) {
                this.bIk.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.bIG != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bIG.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.bIu = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.bIl != null) {
                this.bIl.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.bIG != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.bIG.d(PullToRefreshBaseNew.this);
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

    private void fy(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.bIH != null) {
            this.bIH.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.bIH = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.bIH, j2);
            } else {
                post(this.bIH);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.bIr = z;
    }

    private boolean ZG() {
        return this.bIr;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.bII = z;
    }

    public void setPullRatio(float f) {
        this.bIJ = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public final class b implements Runnable {
        private final int azb;
        private final int azc;
        private final long mDuration;
        private boolean aze = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.azc = i;
            this.azb = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.ad(0, this.azb);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.azc - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.azc - this.azb));
                PullToRefreshBaseNew.this.ad(0, this.mCurrentY);
            }
            if (this.aze && this.azb != this.mCurrentY) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.aze = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void ZH() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.bIF = f;
    }
}
