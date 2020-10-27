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
    private boolean dkA;
    private float dkB;
    private boolean dkC;
    private LoadingLayout dkc;
    private LoadingLayout dkd;
    private int dke;
    private int dkf;
    private boolean dkg;
    private boolean dkh;
    private boolean dki;
    private boolean dkj;
    private boolean dkk;
    private ILoadingLayout.State dkl;
    private ILoadingLayout.State dkm;
    T dkn;
    private FrameLayout dko;
    private int dkp;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> dkq;
    protected HEADERTYPE dkw;
    private float dkx;
    private a<T> dky;
    private PullToRefreshBaseNew<T>.b dkz;
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
        this.dkw = HEADERTYPE.STANDARD_HEADER;
        this.dkx = 2.5f;
        this.mLastMotionY = -1.0f;
        this.dkg = true;
        this.dkh = false;
        this.dki = false;
        this.dkj = true;
        this.dkk = false;
        this.dkl = ILoadingLayout.State.NONE;
        this.dkm = ILoadingLayout.State.NONE;
        this.dkp = -1;
        this.dkA = false;
        this.dkB = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dkw = HEADERTYPE.STANDARD_HEADER;
        this.dkx = 2.5f;
        this.mLastMotionY = -1.0f;
        this.dkg = true;
        this.dkh = false;
        this.dki = false;
        this.dkj = true;
        this.dkk = false;
        this.dkl = ILoadingLayout.State.NONE;
        this.dkm = ILoadingLayout.State.NONE;
        this.dkp = -1;
        this.dkA = false;
        this.dkB = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dkc = e(context, attributeSet);
        this.dkd = f(context, attributeSet);
        this.dkn = createRefreshableView(context, attributeSet);
        if (this.dkn == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.dkn);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (aEf()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.dkk = false;
                    return false;
                } else if (action == 0 || !this.dkk) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.dkk = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || aEh()) {
                                this.mLastMotionY = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.dkk = z;
                                    if (this.dkk && aEe()) {
                                        this.dkn.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.dkk = z;
                                    break;
                                }
                            }
                            break;
                    }
                    return this.dkk;
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
                this.dkk = false;
                return false;
            case 1:
            case 3:
                if (this.dkk) {
                    this.dkk = false;
                    if (isReadyForPullDown()) {
                        if (this.dkg) {
                            if (this.dkl == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.dkA && this.dkl == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                aEi();
                                if (this.dkC) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.dkl = ILoadingLayout.State.RESET;
                        a(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.dkm == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    pullHeaderLayout(y / this.dkx);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.dkx);
                    return true;
                } else {
                    this.dkk = false;
                    return false;
                }
            default:
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.dkg = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.dkh = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.dki = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.dkg && this.dkc != null;
    }

    public boolean isPullLoadEnabled() {
        return this.dkh && this.dkd != null;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.dky = aVar;
    }

    public T getRefreshableView() {
        return this.dkn;
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.dkq;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.dkc;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.dkd;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.dkc != null) {
            this.dkc.setLastUpdatedLabel(charSequence);
        }
        if (this.dkd != null) {
            this.dkd.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.dkp = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.dkc != null) {
            this.dkc.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.dkc != null) {
            this.dkc.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.dkc != null) {
            this.dkc.setHeaderBigBackground(i);
        }
    }

    protected boolean aEe() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        aEg();
        LoadingLayout loadingLayout = null;
        switch (this.dkw) {
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
        if (this.dko != null) {
            this.dko.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.dkc;
        LoadingLayout loadingLayout2 = this.dkd;
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
        if (this.dkc != null) {
            this.dkc.layout(this.dkc.getLeft(), this.dkc.getTop() - this.dkc.getHeight(), this.dkc.getRight(), this.dkc.getBottom() - this.dkc.getHeight());
            this.dke = this.dkc.getContentSize();
        }
        if (this.dkd != null && this.dkn != null) {
            this.dkd.layout(this.dkd.getLeft(), this.dkn.getBottom(), this.dkd.getRight(), this.dkn.getBottom() + this.dkd.getHeight());
            this.dkf = this.dkd.getContentSize();
        }
    }

    public void setListenParentScroll(boolean z) {
        this.dkC = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            aq(0, 0);
        } else if (this.dkp <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.dkp) {
            ar(0, -((int) f));
            if (this.dkc != null && this.dke != 0) {
                this.dkc.onPull(Math.abs(getScrollYValue()) / this.dke);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !aEh()) {
                if (this.dkA && abs > this.dke * this.dkB * 2.0f) {
                    this.dkl = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.dke * this.dkB) {
                    this.dkl = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.dkl = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.dkc != null) {
                    this.dkc.setState(this.dkl);
                }
                a(this.dkl, true);
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
        if (this.dkd != null && this.dkf != 0) {
            this.dkd.onPull(Math.abs(getScrollYValue()) / this.dkf);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.dkf) {
                this.dkm = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.dkm = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.dkd != null) {
                this.dkd.setState(this.dkm);
            }
            a(this.dkm, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean aEh = aEh();
        if ((isPullRefreshing || aEh) && abs <= this.dke) {
            jJ(0);
        } else if (isPullRefreshing || aEh) {
            jJ(-this.dke);
        } else {
            jJ(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.dkf) {
            jJ(0);
        } else if (isPullLoading) {
            jJ(this.dkf);
        } else {
            jJ(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.dkl == ILoadingLayout.State.REFRESHING;
    }

    protected boolean aEh() {
        return this.dkl == ILoadingLayout.State.LONG_REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.dkm == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        ga(true);
    }

    private void ga(boolean z) {
        if (!isPullRefreshing() && !aEh()) {
            this.dkl = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.dkc != null) {
                this.dkc.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.dky != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dky.b(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void aEi() {
        gb(true);
    }

    private void gb(boolean z) {
        if (!isPullRefreshing() && !aEh()) {
            this.dkl = ILoadingLayout.State.LONG_REFRESHING;
            a(this.dkl, true);
            if (this.dkc != null) {
                this.dkc.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.dky != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dky.c(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.dkm = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.dkd != null) {
                this.dkd.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.dky != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.dky.d(PullToRefreshBaseNew.this);
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

    private void jJ(int i) {
        c(i, getSmoothScrollDuration(), 0L);
    }

    private void c(int i, long j, long j2) {
        if (this.dkz != null) {
            this.dkz.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.dkz = new b(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.dkz, j2);
            } else {
                post(this.dkz);
            }
        }
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.dkj = z;
    }

    private boolean aEf() {
        return this.dkj;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.dkA = z;
    }

    public void setPullRatio(float f) {
        this.dkB = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public final class b implements Runnable {
        private final int bzm;
        private final int bzn;
        private final long mDuration;
        private boolean bzp = true;
        private long mStartTime = -1;
        private int bzq = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public b(int i, int i2, long j) {
            this.bzn = i;
            this.bzm = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.aq(0, this.bzm);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bzq = this.bzn - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bzn - this.bzm));
                PullToRefreshBaseNew.this.aq(0, this.bzq);
            }
            if (this.bzp && this.bzm != this.bzq) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.bzp = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
    }

    protected void aEg() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOffsetRadio(float f) {
        this.dkx = f;
    }
}
