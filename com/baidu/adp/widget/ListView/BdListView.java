package com.baidu.adp.widget.ListView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class BdListView extends ListView {
    private final int REFRESH_DELAY;
    private boolean mLayoutHasInit;
    private int mMaxHeight;
    private int mPreHeight;
    private Runnable preLoadRunnable;
    private k wN;
    private AdapterView.OnItemClickListener wO;
    private AdapterView.OnItemLongClickListener wP;
    private AdapterView.OnItemSelectedListener wQ;
    private y wR;
    private x wS;
    private AbsListView.OnScrollListener wT;
    private aa wU;
    private ad wV;
    private long wW;
    private ae wX;
    private int wY;
    private ab wZ;
    private ac xa;
    private i xb;
    private i xc;
    private View xd;
    private int xe;
    private Runnable xf;
    private Runnable xg;
    private boolean xh;
    private boolean xi;
    private z xj;
    private Runnable xk;
    private af xl;

    public BdListView(Context context) {
        super(context);
        this.REFRESH_DELAY = 100;
        this.wN = null;
        this.wO = null;
        this.wP = null;
        this.wQ = null;
        this.wR = null;
        this.wS = null;
        this.wT = null;
        this.wU = null;
        this.wV = null;
        this.wW = 100L;
        this.wX = null;
        this.wY = 0;
        this.wZ = null;
        this.xa = null;
        this.xb = null;
        this.xc = null;
        this.xd = null;
        this.xe = 0;
        this.xf = new o(this);
        this.xg = new p(this);
        this.preLoadRunnable = new q(this);
        this.mLayoutHasInit = false;
        this.xh = false;
        this.xi = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.xj = null;
        this.xk = new r(this);
        this.xl = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.REFRESH_DELAY = 100;
        this.wN = null;
        this.wO = null;
        this.wP = null;
        this.wQ = null;
        this.wR = null;
        this.wS = null;
        this.wT = null;
        this.wU = null;
        this.wV = null;
        this.wW = 100L;
        this.wX = null;
        this.wY = 0;
        this.wZ = null;
        this.xa = null;
        this.xb = null;
        this.xc = null;
        this.xd = null;
        this.xe = 0;
        this.xf = new o(this);
        this.xg = new p(this);
        this.preLoadRunnable = new q(this);
        this.mLayoutHasInit = false;
        this.xh = false;
        this.xi = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.xj = null;
        this.xk = new r(this);
        this.xl = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.REFRESH_DELAY = 100;
        this.wN = null;
        this.wO = null;
        this.wP = null;
        this.wQ = null;
        this.wR = null;
        this.wS = null;
        this.wT = null;
        this.wU = null;
        this.wV = null;
        this.wW = 100L;
        this.wX = null;
        this.wY = 0;
        this.wZ = null;
        this.xa = null;
        this.xb = null;
        this.xc = null;
        this.xd = null;
        this.xe = 0;
        this.xf = new o(this);
        this.xg = new p(this);
        this.preLoadRunnable = new q(this);
        this.mLayoutHasInit = false;
        this.xh = false;
        this.xi = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.xj = null;
        this.xk = new r(this);
        this.xl = null;
        initial();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (NullPointerException e) {
            BdLog.detailException(e);
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        } catch (OutOfMemoryError e2) {
            BdBaseApplication.getInst().onAppMemoryLow();
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    public void jI() {
        removeCallbacks(this.xg);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.wN = new k(getContext());
        this.wN.a(new s(this));
        super.setOnItemClickListener(new t(this));
        super.setOnScrollListener(new u(this));
    }

    public void setOnScrollToPullListener(ad adVar) {
        this.wV = adVar;
    }

    public void setOnSrollToTopListener(ae aeVar) {
        this.wX = aeVar;
    }

    public void setOnSrollToBottomListener(ab abVar) {
        this.wZ = abVar;
    }

    public void setExOnSrollToBottomListener(ac acVar) {
        this.xa = acVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.wP = onItemLongClickListener;
        super.setOnItemLongClickListener(new v(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.wQ = onItemSelectedListener;
        super.setOnItemSelectedListener(new w(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.wT = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.wO = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.wN;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.wN instanceof k) {
            return this.wN.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.wN.a(listAdapter);
        super.setAdapter((ListAdapter) this.wN);
    }

    public void setOnHeaderClickListener(y yVar) {
        this.wR = yVar;
    }

    public void setOnFooterClickListener(x xVar) {
        this.wS = xVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.wN.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.wN.d(view, getHeaderIndex());
    }

    public void d(View view, int i) {
        this.wN.d(view, i);
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.wN.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.wN.getFooterViewsCount();
    }

    public void f(View view) {
        this.wN.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.wN.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.wN.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.wN.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.wN.removeFooter(view);
    }

    public void setNoData(String str) {
        if (this.xd != null) {
            removeHeaderView(this.xd);
            this.xd = null;
        }
        if (str != null) {
            TextView textView = new TextView(getContext());
            textView.setText(str);
            textView.setTextSize(16.0f);
            textView.setGravity(17);
            setNoData(textView);
        }
    }

    public void setNoData(View view) {
        addHeaderView(view, null, false);
    }

    public void setPrePage(i iVar) {
        if (this.xb != null) {
            removeHeaderView(this.xb.getView());
            this.xb = null;
        }
        if (iVar != null) {
            addHeaderView(iVar.getView());
            this.xb = iVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i, int i2) {
        super.setSelectionFromTop(i, i2);
    }

    public void setNextPage(i iVar) {
        if (this.xc != null) {
            removeFooterView(this.xc.getView());
            this.xc = null;
        }
        if (iVar != null) {
            this.wN.b(iVar.getView(), null, true, 0);
            this.xc = iVar;
        }
    }

    private int getHeaderIndex() {
        if (this.xb != null) {
            return this.wN.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.xf);
            getHandler().removeCallbacks(this.xk);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.xi = z;
    }

    public void setOnkbdStateListener(z zVar) {
        this.xj = zVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i, i2, i3, i4);
            if (!this.mLayoutHasInit) {
                this.mLayoutHasInit = true;
                this.mMaxHeight = i4;
                if (this.xj != null) {
                    this.xj.onKeyBoardStateChange(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i4 ? i4 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i4 && i4 != this.mPreHeight) {
                this.xh = true;
                if (this.xj != null) {
                    this.xj.onKeyBoardStateChange(-3);
                }
                if (this.xi && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.xk, 1L);
                }
            }
            if (this.mLayoutHasInit && this.xh && this.mMaxHeight == i4) {
                this.xh = false;
                if (this.xj != null) {
                    this.xj.onKeyBoardStateChange(-2);
                }
            }
            this.mPreHeight = i4;
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    public void setPullRefresh(j jVar) {
        if (this.xl != null) {
            removeHeaderView(this.xl.jM().getView());
        }
        this.xl = null;
        if (jVar != null) {
            this.xl = new af(this, jVar);
            this.xl.setOnScrollToPullListener(this.wV);
        }
    }

    public void jJ() {
        if (this.xl != null) {
            af.a(this.xl);
        }
    }

    public void jK() {
        if (this.xl != null) {
            setSelection(0);
            this.xl.U(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.xl != null) {
            this.xl.a(motionEvent, this.xe);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.xl != null) {
            this.xl.b(motionEvent, this.xe);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean jL() {
        return this.xl == null || this.xl.mState == 3;
    }
}
