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
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> clA;
    protected HEADERTYPE clG;
    private float clH;
    private a<T> clI;
    private PullToRefreshBaseNew<T>.b clJ;
    private boolean clK;
    private float clL;
    private boolean clM;
    private LoadingLayout clm;
    private LoadingLayout cln;
    private int clo;
    private int clp;
    private boolean clq;
    private boolean clr;
    private boolean cls;
    private boolean clt;
    private boolean clu;
    private ILoadingLayout.State clv;
    private ILoadingLayout.State clw;
    T clx;
    private FrameLayout cly;
    private int clz;
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
        this.clG = HEADERTYPE.STANDARD_HEADER;
        this.clH = 2.5f;
        this.mLastMotionY = -1.0f;
        this.clq = true;
        this.clr = false;
        this.cls = false;
        this.clt = true;
        this.clu = false;
        this.clv = ILoadingLayout.State.NONE;
        this.clw = ILoadingLayout.State.NONE;
        this.clz = -1;
        this.clK = false;
        this.clL = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clG = HEADERTYPE.STANDARD_HEADER;
        this.clH = 2.5f;
        this.mLastMotionY = -1.0f;
        this.clq = true;
        this.clr = false;
        this.cls = false;
        this.clt = true;
        this.clu = false;
        this.clv = ILoadingLayout.State.NONE;
        this.clw = ILoadingLayout.State.NONE;
        this.clz = -1;
        this.clK = false;
        this.clL = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.clm = e(context, attributeSet);
        this.cln = f(context, attributeSet);
        this.clx = createRefreshableView(context, attributeSet);
        if (this.clx == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.clx);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (ake()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.clu = false;
                    return false;
                } else if (action == 0 || !this.clu) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.clu = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || akg()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.clu = z;
                                    if (this.clu && akd()) {
                                        this.clx.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.clu = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.clu;
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
                this.clu = false;
                return false;
            case 1:
            case 3:
                if (this.clu) {
                    this.clu = false;
                    if (isReadyForPullDown()) {
                        if (this.clq) {
                            if (this.clv == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.clK && this.clv == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                akh();
                                if (this.clM) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.clv = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.clw == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.clH);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.clH);
                    return true;
                } else {
                    this.clu = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.clq = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.clr = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.cls = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.clq && this.clm != null;
    }

    public boolean isPullLoadEnabled() {
        return this.clr && this.cln != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.clI = aVar;
    }

    public T getRefreshableView() {
        return this.clx;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.clA;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.clm;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.cln;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.clm != null) {
            this.clm.setLastUpdatedLabel(charSequence);
        }
        if (this.cln != null) {
            this.cln.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.clz = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.clm != null) {
            this.clm.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.clm != null) {
            this.clm.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.clm != null) {
            this.clm.setHeaderBigBackground(i);
        }
    }

    protected boolean akd() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        akf();
        LoadingLayout loadingLayout = null;
        switch (this.clG) {
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
        if (this.cly != null) {
            this.cly.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.clm;
        LoadingLayout loadingLayout2 = this.cln;
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
        if (this.clm != null) {
            this.clm.layout(this.clm.getLeft(), this.clm.getTop() - this.clm.getHeight(), this.clm.getRight(), this.clm.getBottom() - this.clm.getHeight());
            this.clo = this.clm.getContentSize();
        }
        if (this.cln != null && this.clx != null) {
            this.cln.layout(this.cln.getLeft(), this.clx.getBottom(), this.cln.getRight(), this.clx.getBottom() + this.cln.getHeight());
            this.clp = this.cln.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.clM = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            ag(0, 0);
        } else if (this.clz <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.clz) {
            ah(0, -((int) f));
            if (this.clm != null && this.clo != 0) {
                this.clm.onPull(Math.abs(getScrollYValue()) / this.clo);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !akg()) {
                if (this.clK && abs > this.clo * this.clL * 2.0f) {
                    this.clv = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.clo * this.clL) {
                    this.clv = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.clv = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.clm != null) {
                    this.clm.setState(this.clv);
                }
                a(this.clv, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            ag(0, 0);
            return;
        }
        ah(0, -((int) f));
        if (this.cln != null && this.clp != 0) {
            this.cln.onPull(Math.abs(getScrollYValue()) / this.clp);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.clp) {
                this.clw = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.clw = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.cln != null) {
                this.cln.setState(this.clw);
            }
            a(this.clw, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean akg = akg();
        if ((isPullRefreshing || akg) && abs <= this.clo) {
            fV(0);
        } else if (isPullRefreshing || akg) {
            fV(-this.clo);
        } else {
            fV(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.clp) {
            fV(0);
        } else if (isPullLoading) {
            fV(this.clp);
        } else {
            fV(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.clv == ILoadingLayout.State.REFRESHING;
    }

    protected boolean akg() {
        return this.clv == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.clw == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        es(true);
    }

    private void es(boolean z) {
        if (!isPullRefreshing() && !akg()) {
            this.clv = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.clm != null) {
                this.clm.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.clI != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.clI.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void akh() {
        et(true);
    }

    private void et(boolean z) {
        if (!isPullRefreshing() && !akg()) {
            this.clv = ILoadingLayout.State.LONG_REFRESHING;
            a(this.clv, true);
            if (this.clm != null) {
                this.clm.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.clI != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.clI.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.clw = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.cln != null) {
                this.cln.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.clI != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.clI.d(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(int i, int i2) {
        scrollTo(i, i2);
    }

    private void ah(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void fV(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.clJ != null) {
            this.clJ.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.clJ = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.clJ, j2);
            } else {
                post(this.clJ);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.clt = z;
    }

    private boolean ake() {
        return this.clt;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.clK = z;
    }

    public void setPullRatio(float f) {
        this.clL = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public final class b implements Runnable {
        private final int aXp;
        private final int aXq;
        private final long mDuration;
        private boolean aXs = true;
        private long mStartTime = -1;
        private int aXt = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.aXq = i;
            this.aXp = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.ag(0, this.aXp);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aXt = this.aXq - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aXq - this.aXp));
                PullToRefreshBaseNew.this.ag(0, this.aXt);
            }
            if (this.aXs && this.aXp != this.aXt) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.aXs = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void akf() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.clH = f;
    }
}
