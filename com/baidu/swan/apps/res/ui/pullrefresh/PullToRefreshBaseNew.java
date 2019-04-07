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
    private LoadingLayout aIT;
    private LoadingLayout aIU;
    private int aIV;
    private int aIW;
    private boolean aIX;
    private boolean aIY;
    private boolean aIZ;
    private boolean aJa;
    private boolean aJb;
    private ILoadingLayout.State aJc;
    private ILoadingLayout.State aJd;
    T aJe;
    private FrameLayout aJf;
    private int aJg;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> aJh;
    protected HEADERTYPE aJn;
    private float aJo;
    private a<T> aJp;
    private PullToRefreshBaseNew<T>.b aJq;
    private boolean aJr;
    private float aJs;
    private boolean aJt;
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
        this.aJn = HEADERTYPE.STANDARD_HEADER;
        this.aJo = 2.5f;
        this.mLastMotionY = -1.0f;
        this.aIX = true;
        this.aIY = false;
        this.aIZ = false;
        this.aJa = true;
        this.aJb = false;
        this.aJc = ILoadingLayout.State.NONE;
        this.aJd = ILoadingLayout.State.NONE;
        this.aJg = -1;
        this.aJr = false;
        this.aJs = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJn = HEADERTYPE.STANDARD_HEADER;
        this.aJo = 2.5f;
        this.mLastMotionY = -1.0f;
        this.aIX = true;
        this.aIY = false;
        this.aIZ = false;
        this.aJa = true;
        this.aJb = false;
        this.aJc = ILoadingLayout.State.NONE;
        this.aJd = ILoadingLayout.State.NONE;
        this.aJg = -1;
        this.aJr = false;
        this.aJs = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.aIT = f(context, attributeSet);
        this.aIU = g(context, attributeSet);
        this.aJe = createRefreshableView(context, attributeSet);
        if (this.aJe == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.aJe);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (Hu()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.aJb = false;
                    return false;
                } else if (action == 0 || !this.aJb) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.aJb = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || Hw()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.aJb = z;
                                    if (this.aJb && Ht()) {
                                        this.aJe.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.aJb = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.aJb;
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
                this.aJb = false;
                return false;
            case 1:
            case 3:
                if (this.aJb) {
                    this.aJb = false;
                    if (isReadyForPullDown()) {
                        if (this.aIX) {
                            if (this.aJc == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.aJr && this.aJc == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                Hx();
                                if (this.aJt) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.aJc = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.aJd == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.aJo);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.aJo);
                    return true;
                } else {
                    this.aJb = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.aIX = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.aIY = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.aIZ = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.aIX && this.aIT != null;
    }

    public boolean isPullLoadEnabled() {
        return this.aIY && this.aIU != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.aJp = aVar;
    }

    public T getRefreshableView() {
        return this.aJe;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.aJh;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.aIT;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.aIU;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.aIT != null) {
            this.aIT.setLastUpdatedLabel(charSequence);
        }
        if (this.aIU != null) {
            this.aIU.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.aJg = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.aIT != null) {
            this.aIT.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.aIT != null) {
            this.aIT.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.aIT != null) {
            this.aIT.setHeaderBigBackground(i);
        }
    }

    protected boolean Ht() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        Hv();
        LoadingLayout loadingLayout = null;
        switch (this.aJn) {
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
        if (this.aJf != null) {
            this.aJf.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.aIT;
        LoadingLayout loadingLayout2 = this.aIU;
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
        if (this.aIT != null) {
            this.aIT.layout(this.aIT.getLeft(), this.aIT.getTop() - this.aIT.getHeight(), this.aIT.getRight(), this.aIT.getBottom() - this.aIT.getHeight());
            this.aIV = this.aIT.getContentSize();
        }
        if (this.aIU != null && this.aJe != null) {
            this.aIU.layout(this.aIU.getLeft(), this.aJe.getBottom(), this.aIU.getRight(), this.aJe.getBottom() + this.aIU.getHeight());
            this.aIW = this.aIU.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.aJt = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            E(0, 0);
        } else if (this.aJg <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.aJg) {
            F(0, -((int) f));
            if (this.aIT != null && this.aIV != 0) {
                this.aIT.onPull(Math.abs(getScrollYValue()) / this.aIV);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !Hw()) {
                if (this.aJr && abs > this.aIV * this.aJs * 2.0f) {
                    this.aJc = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.aIV * this.aJs) {
                    this.aJc = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.aJc = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                this.aIT.setState(this.aJc);
                a(this.aJc, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            E(0, 0);
            return;
        }
        F(0, -((int) f));
        if (this.aIU != null && this.aIW != 0) {
            this.aIU.onPull(Math.abs(getScrollYValue()) / this.aIW);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.aIW) {
                this.aJd = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.aJd = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            this.aIU.setState(this.aJd);
            a(this.aJd, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean Hw = Hw();
        if ((isPullRefreshing || Hw) && abs <= this.aIV) {
            cW(0);
        } else if (isPullRefreshing || Hw) {
            cW(-this.aIV);
        } else {
            cW(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.aIW) {
            cW(0);
        } else if (isPullLoading) {
            cW(this.aIW);
        } else {
            cW(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.aJc == ILoadingLayout.State.REFRESHING;
    }

    protected boolean Hw() {
        return this.aJc == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.aJd == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        bC(true);
    }

    private void bC(boolean z) {
        if (!isPullRefreshing() && !Hw()) {
            this.aJc = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.aIT != null) {
                this.aIT.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.aJp != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aJp.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void Hx() {
        bD(true);
    }

    private void bD(boolean z) {
        if (!isPullRefreshing() && !Hw()) {
            this.aJc = ILoadingLayout.State.LONG_REFRESHING;
            a(this.aJc, true);
            if (this.aIT != null) {
                this.aIT.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.aJp != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aJp.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.aJd = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.aIU != null) {
                this.aIU.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.aJp != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aJp.d(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i, int i2) {
        scrollTo(i, i2);
    }

    private void F(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void cW(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.aJq != null) {
            this.aJq.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.aJq = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.aJq, j2);
            } else {
                post(this.aJq);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.aJa = z;
    }

    private boolean Hu() {
        return this.aJa;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.aJr = z;
    }

    public void setPullRatio(float f) {
        this.aJs = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b implements Runnable {
        private final int aJw;
        private final int aJx;
        private final long mDuration;
        private boolean aJy = true;
        private long mStartTime = -1;
        private int aJz = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.aJx = i;
            this.aJw = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.E(0, this.aJw);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aJz = this.aJx - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aJx - this.aJw));
                PullToRefreshBaseNew.this.E(0, this.aJz);
            }
            if (this.aJy && this.aJw != this.aJz) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.aJy = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void Hv() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.aJo = f;
    }
}
