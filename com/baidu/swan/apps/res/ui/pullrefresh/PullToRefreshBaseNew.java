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
    private LoadingLayout aIU;
    private LoadingLayout aIV;
    private int aIW;
    private int aIX;
    private boolean aIY;
    private boolean aIZ;
    private boolean aJa;
    private boolean aJb;
    private boolean aJc;
    private ILoadingLayout.State aJd;
    private ILoadingLayout.State aJe;
    T aJf;
    private FrameLayout aJg;
    private int aJh;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> aJi;
    protected HEADERTYPE aJo;
    private float aJp;
    private a<T> aJq;
    private PullToRefreshBaseNew<T>.b aJr;
    private boolean aJs;
    private float aJt;
    private boolean aJu;
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
        this.aJo = HEADERTYPE.STANDARD_HEADER;
        this.aJp = 2.5f;
        this.mLastMotionY = -1.0f;
        this.aIY = true;
        this.aIZ = false;
        this.aJa = false;
        this.aJb = true;
        this.aJc = false;
        this.aJd = ILoadingLayout.State.NONE;
        this.aJe = ILoadingLayout.State.NONE;
        this.aJh = -1;
        this.aJs = false;
        this.aJt = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJo = HEADERTYPE.STANDARD_HEADER;
        this.aJp = 2.5f;
        this.mLastMotionY = -1.0f;
        this.aIY = true;
        this.aIZ = false;
        this.aJa = false;
        this.aJb = true;
        this.aJc = false;
        this.aJd = ILoadingLayout.State.NONE;
        this.aJe = ILoadingLayout.State.NONE;
        this.aJh = -1;
        this.aJs = false;
        this.aJt = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.aIU = f(context, attributeSet);
        this.aIV = g(context, attributeSet);
        this.aJf = createRefreshableView(context, attributeSet);
        if (this.aJf == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.aJf);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (Hu()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.aJc = false;
                    return false;
                } else if (action == 0 || !this.aJc) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.aJc = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || Hw()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.aJc = z;
                                    if (this.aJc && Ht()) {
                                        this.aJf.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.aJc = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.aJc;
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
                this.aJc = false;
                return false;
            case 1:
            case 3:
                if (this.aJc) {
                    this.aJc = false;
                    if (isReadyForPullDown()) {
                        if (this.aIY) {
                            if (this.aJd == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.aJs && this.aJd == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                Hx();
                                if (this.aJu) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.aJd = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.aJe == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.aJp);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.aJp);
                    return true;
                } else {
                    this.aJc = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.aIY = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.aIZ = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.aJa = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.aIY && this.aIU != null;
    }

    public boolean isPullLoadEnabled() {
        return this.aIZ && this.aIV != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.aJq = aVar;
    }

    public T getRefreshableView() {
        return this.aJf;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.aJi;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.aIU;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.aIV;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.aIU != null) {
            this.aIU.setLastUpdatedLabel(charSequence);
        }
        if (this.aIV != null) {
            this.aIV.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.aJh = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.aIU != null) {
            this.aIU.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.aIU != null) {
            this.aIU.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.aIU != null) {
            this.aIU.setHeaderBigBackground(i);
        }
    }

    protected boolean Ht() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        Hv();
        LoadingLayout loadingLayout = null;
        switch (this.aJo) {
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
        if (this.aJg != null) {
            this.aJg.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.aIU;
        LoadingLayout loadingLayout2 = this.aIV;
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
        if (this.aIU != null) {
            this.aIU.layout(this.aIU.getLeft(), this.aIU.getTop() - this.aIU.getHeight(), this.aIU.getRight(), this.aIU.getBottom() - this.aIU.getHeight());
            this.aIW = this.aIU.getContentSize();
        }
        if (this.aIV != null && this.aJf != null) {
            this.aIV.layout(this.aIV.getLeft(), this.aJf.getBottom(), this.aIV.getRight(), this.aJf.getBottom() + this.aIV.getHeight());
            this.aIX = this.aIV.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.aJu = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            E(0, 0);
        } else if (this.aJh <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.aJh) {
            F(0, -((int) f));
            if (this.aIU != null && this.aIW != 0) {
                this.aIU.onPull(Math.abs(getScrollYValue()) / this.aIW);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !Hw()) {
                if (this.aJs && abs > this.aIW * this.aJt * 2.0f) {
                    this.aJd = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.aIW * this.aJt) {
                    this.aJd = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.aJd = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                this.aIU.setState(this.aJd);
                a(this.aJd, true);
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
        if (this.aIV != null && this.aIX != 0) {
            this.aIV.onPull(Math.abs(getScrollYValue()) / this.aIX);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.aIX) {
                this.aJe = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.aJe = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            this.aIV.setState(this.aJe);
            a(this.aJe, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean Hw = Hw();
        if ((isPullRefreshing || Hw) && abs <= this.aIW) {
            cW(0);
        } else if (isPullRefreshing || Hw) {
            cW(-this.aIW);
        } else {
            cW(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.aIX) {
            cW(0);
        } else if (isPullLoading) {
            cW(this.aIX);
        } else {
            cW(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.aJd == ILoadingLayout.State.REFRESHING;
    }

    protected boolean Hw() {
        return this.aJd == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.aJe == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        bC(true);
    }

    private void bC(boolean z) {
        if (!isPullRefreshing() && !Hw()) {
            this.aJd = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.aIU != null) {
                this.aIU.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.aJq != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aJq.b(PullToRefreshBaseNew.this);
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
            this.aJd = ILoadingLayout.State.LONG_REFRESHING;
            a(this.aJd, true);
            if (this.aIU != null) {
                this.aIU.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.aJq != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aJq.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.aJe = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.aIV != null) {
                this.aIV.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.aJq != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.aJq.d(PullToRefreshBaseNew.this);
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
        if (this.aJr != null) {
            this.aJr.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.aJr = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.aJr, j2);
            } else {
                post(this.aJr);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.aJb = z;
    }

    private boolean Hu() {
        return this.aJb;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.aJs = z;
    }

    public void setPullRatio(float f) {
        this.aJt = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b implements Runnable {
        private final int aJx;
        private final int aJy;
        private final long mDuration;
        private boolean aJz = true;
        private long mStartTime = -1;
        private int aJA = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.aJy = i;
            this.aJx = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.E(0, this.aJx);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aJA = this.aJy - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aJy - this.aJx));
                PullToRefreshBaseNew.this.E(0, this.aJA);
            }
            if (this.aJz && this.aJx != this.aJA) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.aJz = false;
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
        this.aJp = f;
    }
}
