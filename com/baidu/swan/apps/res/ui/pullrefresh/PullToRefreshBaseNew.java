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
/* loaded from: classes7.dex */
public abstract class PullToRefreshBaseNew<T extends View> extends FrameLayout {
    private ILoadingLayout.State doA;
    T doB;
    private FrameLayout doC;
    private int doD;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> doE;
    protected HEADERTYPE doK;
    private float doL;
    private a<T> doM;
    private PullToRefreshBaseNew<T>.b doN;
    private boolean doO;
    private float doP;
    private boolean doQ;
    private LoadingLayout dop;
    private LoadingLayout doq;
    private int dor;
    private int dos;
    private boolean dou;
    private boolean dov;
    private boolean dow;
    private boolean dox;
    private boolean doy;
    private ILoadingLayout.State doz;
    private float mLastMotionY;
    private int mTouchSlop;

    /* loaded from: classes7.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER
    }

    /* loaded from: classes7.dex */
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
        this.doK = HEADERTYPE.STANDARD_HEADER;
        this.doL = 2.5f;
        this.mLastMotionY = -1.0f;
        this.dou = true;
        this.dov = false;
        this.dow = false;
        this.dox = true;
        this.doy = false;
        this.doz = ILoadingLayout.State.NONE;
        this.doA = ILoadingLayout.State.NONE;
        this.doD = -1;
        this.doO = false;
        this.doP = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.doK = HEADERTYPE.STANDARD_HEADER;
        this.doL = 2.5f;
        this.mLastMotionY = -1.0f;
        this.dou = true;
        this.dov = false;
        this.dow = false;
        this.dox = true;
        this.doy = false;
        this.doz = ILoadingLayout.State.NONE;
        this.doA = ILoadingLayout.State.NONE;
        this.doD = -1;
        this.doO = false;
        this.doP = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dop = e(context, attributeSet);
        this.doq = f(context, attributeSet);
        this.doB = createRefreshableView(context, attributeSet);
        if (this.doB == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.doB);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (aFX()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.doy = false;
                    return false;
                } else if (action == 0 || !this.doy) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.doy = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || aFZ()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.doy = z;
                                    if (this.doy && aFW()) {
                                        this.doB.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.doy = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.doy;
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
                this.doy = false;
                return false;
            case 1:
            case 3:
                if (this.doy) {
                    this.doy = false;
                    if (isReadyForPullDown()) {
                        if (this.dou) {
                            if (this.doz == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.doO && this.doz == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                aGa();
                                if (this.doQ) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.doz = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.doA == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.doL);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.doL);
                    return true;
                } else {
                    this.doy = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.dou = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.dov = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.dow = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.dou && this.dop != null;
    }

    public boolean isPullLoadEnabled() {
        return this.dov && this.doq != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.doM = aVar;
    }

    public T getRefreshableView() {
        return this.doB;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.doE;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.dop;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.doq;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.dop != null) {
            this.dop.setLastUpdatedLabel(charSequence);
        }
        if (this.doq != null) {
            this.doq.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.doD = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.dop != null) {
            this.dop.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.dop != null) {
            this.dop.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.dop != null) {
            this.dop.setHeaderBigBackground(i);
        }
    }

    protected boolean aFW() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        aFY();
        LoadingLayout loadingLayout = null;
        switch (this.doK) {
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
        if (this.doC != null) {
            this.doC.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.dop;
        LoadingLayout loadingLayout2 = this.doq;
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
        if (this.dop != null) {
            this.dop.layout(this.dop.getLeft(), this.dop.getTop() - this.dop.getHeight(), this.dop.getRight(), this.dop.getBottom() - this.dop.getHeight());
            this.dor = this.dop.getContentSize();
        }
        if (this.doq != null && this.doB != null) {
            this.doq.layout(this.doq.getLeft(), this.doB.getBottom(), this.doq.getRight(), this.doB.getBottom() + this.doq.getHeight());
            this.dos = this.doq.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.doQ = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            aq(0, 0);
        } else if (this.doD <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.doD) {
            ar(0, -((int) f));
            if (this.dop != null && this.dor != 0) {
                this.dop.onPull(Math.abs(getScrollYValue()) / this.dor);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !aFZ()) {
                if (this.doO && abs > this.dor * this.doP * 2.0f) {
                    this.doz = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.dor * this.doP) {
                    this.doz = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.doz = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.dop != null) {
                    this.dop.setState(this.doz);
                }
                a(this.doz, true);
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
        if (this.doq != null && this.dos != 0) {
            this.doq.onPull(Math.abs(getScrollYValue()) / this.dos);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.dos) {
                this.doA = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.doA = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.doq != null) {
                this.doq.setState(this.doA);
            }
            a(this.doA, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean aFZ = aFZ();
        if ((isPullRefreshing || aFZ) && abs <= this.dor) {
            jP(0);
        } else if (isPullRefreshing || aFZ) {
            jP(-this.dor);
        } else {
            jP(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.dos) {
            jP(0);
        } else if (isPullLoading) {
            jP(this.dos);
        } else {
            jP(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.doz == ILoadingLayout.State.REFRESHING;
    }

    protected boolean aFZ() {
        return this.doz == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.doA == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        gm(true);
    }

    private void gm(boolean z) {
        if (!isPullRefreshing() && !aFZ()) {
            this.doz = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.dop != null) {
                this.dop.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.doM != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.doM.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void aGa() {
        gn(true);
    }

    private void gn(boolean z) {
        if (!isPullRefreshing() && !aFZ()) {
            this.doz = ILoadingLayout.State.LONG_REFRESHING;
            a(this.doz, true);
            if (this.dop != null) {
                this.dop.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.doM != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.doM.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.doA = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.doq != null) {
                this.doq.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.doM != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.doM.d(PullToRefreshBaseNew.this);
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

    private void jP(int i) {
        d(i, getSmoothScrollDuration(), 0L);
    }

    private void d(int i, long j, long j2) {
        if (this.doN != null) {
            this.doN.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.doN = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.doN, j2);
            } else {
                post(this.doN);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.dox = z;
    }

    private boolean aFX() {
        return this.dox;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.doO = z;
    }

    public void setPullRatio(float f) {
        this.doP = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public final class b implements Runnable {
        private final int bDM;
        private final int bDN;
        private final long mDuration;
        private boolean bDP = true;
        private long mStartTime = -1;
        private int bDQ = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.bDN = i;
            this.bDM = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.aq(0, this.bDM);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bDQ = this.bDN - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bDN - this.bDM));
                PullToRefreshBaseNew.this.aq(0, this.bDQ);
            }
            if (this.bDP && this.bDM != this.bDQ) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.bDP = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void aFY() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.doL = f;
    }
}
