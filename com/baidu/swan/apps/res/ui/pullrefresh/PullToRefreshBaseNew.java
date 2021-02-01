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
    private LoadingLayout dyT;
    private LoadingLayout dyU;
    private int dyV;
    private int dyW;
    private boolean dyX;
    private boolean dyY;
    private boolean dyZ;
    private boolean dza;
    private boolean dzb;
    private ILoadingLayout.State dzc;
    private ILoadingLayout.State dzd;
    T dze;
    private FrameLayout dzf;
    private int dzg;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> dzh;
    protected HEADERTYPE dzn;
    private float dzo;
    private a<T> dzp;
    private PullToRefreshBaseNew<T>.b dzq;
    private boolean dzr;
    private float dzs;
    private boolean dzt;
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
        this.dzn = HEADERTYPE.STANDARD_HEADER;
        this.dzo = 2.5f;
        this.mLastMotionY = -1.0f;
        this.dyX = true;
        this.dyY = false;
        this.dyZ = false;
        this.dza = true;
        this.dzb = false;
        this.dzc = ILoadingLayout.State.NONE;
        this.dzd = ILoadingLayout.State.NONE;
        this.dzg = -1;
        this.dzr = false;
        this.dzs = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dzn = HEADERTYPE.STANDARD_HEADER;
        this.dzo = 2.5f;
        this.mLastMotionY = -1.0f;
        this.dyX = true;
        this.dyY = false;
        this.dyZ = false;
        this.dza = true;
        this.dzb = false;
        this.dzc = ILoadingLayout.State.NONE;
        this.dzd = ILoadingLayout.State.NONE;
        this.dzg = -1;
        this.dzr = false;
        this.dzs = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dyT = f(context, attributeSet);
        this.dyU = g(context, attributeSet);
        this.dze = createRefreshableView(context, attributeSet);
        if (this.dze == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.dze);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (aHp()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.dzb = false;
                    return false;
                } else if (action == 0 || !this.dzb) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.dzb = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || aHr()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.dzb = z;
                                    if (this.dzb && aHo()) {
                                        this.dze.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.dzb = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.dzb;
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
                this.dzb = false;
                return false;
            case 1:
            case 3:
                if (this.dzb) {
                    this.dzb = false;
                    if (isReadyForPullDown()) {
                        if (this.dyX) {
                            if (this.dzc == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.dzr && this.dzc == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                aHs();
                                if (this.dzt) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.dzc = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.dzd == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.dzo);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.dzo);
                    return true;
                } else {
                    this.dzb = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.dyX = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.dyY = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.dyZ = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.dyX && this.dyT != null;
    }

    public boolean isPullLoadEnabled() {
        return this.dyY && this.dyU != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.dzp = aVar;
    }

    public T getRefreshableView() {
        return this.dze;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.dzh;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.dyT;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.dyU;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.dyT != null) {
            this.dyT.setLastUpdatedLabel(charSequence);
        }
        if (this.dyU != null) {
            this.dyU.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.dzg = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.dyT != null) {
            this.dyT.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.dyT != null) {
            this.dyT.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.dyT != null) {
            this.dyT.setHeaderBigBackground(i);
        }
    }

    protected boolean aHo() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        aHq();
        LoadingLayout loadingLayout = null;
        switch (this.dzn) {
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
        if (this.dzf != null) {
            this.dzf.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.dyT;
        LoadingLayout loadingLayout2 = this.dyU;
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
        if (this.dyT != null) {
            this.dyT.layout(this.dyT.getLeft(), this.dyT.getTop() - this.dyT.getHeight(), this.dyT.getRight(), this.dyT.getBottom() - this.dyT.getHeight());
            this.dyV = this.dyT.getContentSize();
        }
        if (this.dyU != null && this.dze != null) {
            this.dyU.layout(this.dyU.getLeft(), this.dze.getBottom(), this.dyU.getRight(), this.dze.getBottom() + this.dyU.getHeight());
            this.dyW = this.dyU.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.dzt = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            al(0, 0);
        } else if (this.dzg <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.dzg) {
            am(0, -((int) f));
            if (this.dyT != null && this.dyV != 0) {
                this.dyT.onPull(Math.abs(getScrollYValue()) / this.dyV);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !aHr()) {
                if (this.dzr && abs > this.dyV * this.dzs * 2.0f) {
                    this.dzc = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.dyV * this.dzs) {
                    this.dzc = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.dzc = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.dyT != null) {
                    this.dyT.setState(this.dzc);
                }
                a(this.dzc, true);
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
        if (this.dyU != null && this.dyW != 0) {
            this.dyU.onPull(Math.abs(getScrollYValue()) / this.dyW);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.dyW) {
                this.dzd = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.dzd = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.dyU != null) {
                this.dyU.setState(this.dzd);
            }
            a(this.dzd, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean aHr = aHr();
        if ((isPullRefreshing || aHr) && abs <= this.dyV) {
            iJ(0);
        } else if (isPullRefreshing || aHr) {
            iJ(-this.dyV);
        } else {
            iJ(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.dyW) {
            iJ(0);
        } else if (isPullLoading) {
            iJ(this.dyW);
        } else {
            iJ(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.dzc == ILoadingLayout.State.REFRESHING;
    }

    protected boolean aHr() {
        return this.dzc == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.dzd == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        gI(true);
    }

    private void gI(boolean z) {
        if (!isPullRefreshing() && !aHr()) {
            this.dzc = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.dyT != null) {
                this.dyT.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.dzp != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dzp.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void aHs() {
        gJ(true);
    }

    private void gJ(boolean z) {
        if (!isPullRefreshing() && !aHr()) {
            this.dzc = ILoadingLayout.State.LONG_REFRESHING;
            a(this.dzc, true);
            if (this.dyT != null) {
                this.dyT.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.dzp != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dzp.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.dzd = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.dyU != null) {
                this.dyU.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.dzp != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dzp.d(PullToRefreshBaseNew.this);
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

    private void iJ(int i) {
        e(i, getSmoothScrollDuration(), 0L);
    }

    private void e(int i, long j, long j2) {
        if (this.dzq != null) {
            this.dzq.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.dzq = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.dzq, j2);
            } else {
                post(this.dzq);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.dza = z;
    }

    private boolean aHp() {
        return this.dza;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.dzr = z;
    }

    public void setPullRatio(float f) {
        this.dzs = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class b implements Runnable {
        private final int bMG;
        private final int bMH;
        private final long mDuration;
        private boolean bMJ = true;
        private long mStartTime = -1;
        private int bMK = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.bMH = i;
            this.bMG = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.al(0, this.bMG);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bMK = this.bMH - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bMH - this.bMG));
                PullToRefreshBaseNew.this.al(0, this.bMK);
            }
            if (this.bMJ && this.bMG != this.bMK) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.bMJ = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void aHq() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.dzo = f;
    }
}
