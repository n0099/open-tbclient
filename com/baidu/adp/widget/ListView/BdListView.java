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
    private k wK;
    private AdapterView.OnItemClickListener wL;
    private AdapterView.OnItemLongClickListener wM;
    private AdapterView.OnItemSelectedListener wN;
    private y wO;
    private x wP;
    private AbsListView.OnScrollListener wQ;
    private aa wR;
    private ad wS;
    private long wT;
    private ae wU;
    private int wV;
    private ab wW;
    private ac wX;
    private i wY;
    private i wZ;
    private View xa;
    private int xb;
    private Runnable xc;
    private Runnable xd;
    private boolean xe;
    private boolean xf;
    private z xg;
    private Runnable xh;
    private af xi;

    public BdListView(Context context) {
        super(context);
        this.REFRESH_DELAY = 100;
        this.wK = null;
        this.wL = null;
        this.wM = null;
        this.wN = null;
        this.wO = null;
        this.wP = null;
        this.wQ = null;
        this.wR = null;
        this.wS = null;
        this.wT = 100L;
        this.wU = null;
        this.wV = 0;
        this.wW = null;
        this.wX = null;
        this.wY = null;
        this.wZ = null;
        this.xa = null;
        this.xb = 0;
        this.xc = new o(this);
        this.xd = new p(this);
        this.preLoadRunnable = new q(this);
        this.mLayoutHasInit = false;
        this.xe = false;
        this.xf = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.xg = null;
        this.xh = new r(this);
        this.xi = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.REFRESH_DELAY = 100;
        this.wK = null;
        this.wL = null;
        this.wM = null;
        this.wN = null;
        this.wO = null;
        this.wP = null;
        this.wQ = null;
        this.wR = null;
        this.wS = null;
        this.wT = 100L;
        this.wU = null;
        this.wV = 0;
        this.wW = null;
        this.wX = null;
        this.wY = null;
        this.wZ = null;
        this.xa = null;
        this.xb = 0;
        this.xc = new o(this);
        this.xd = new p(this);
        this.preLoadRunnable = new q(this);
        this.mLayoutHasInit = false;
        this.xe = false;
        this.xf = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.xg = null;
        this.xh = new r(this);
        this.xi = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.REFRESH_DELAY = 100;
        this.wK = null;
        this.wL = null;
        this.wM = null;
        this.wN = null;
        this.wO = null;
        this.wP = null;
        this.wQ = null;
        this.wR = null;
        this.wS = null;
        this.wT = 100L;
        this.wU = null;
        this.wV = 0;
        this.wW = null;
        this.wX = null;
        this.wY = null;
        this.wZ = null;
        this.xa = null;
        this.xb = 0;
        this.xc = new o(this);
        this.xd = new p(this);
        this.preLoadRunnable = new q(this);
        this.mLayoutHasInit = false;
        this.xe = false;
        this.xf = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.xg = null;
        this.xh = new r(this);
        this.xi = null;
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

    public void jA() {
        removeCallbacks(this.xd);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.wK = new k(getContext());
        this.wK.a(new s(this));
        super.setOnItemClickListener(new t(this));
        super.setOnScrollListener(new u(this));
    }

    public void setOnScrollToPullListener(ad adVar) {
        this.wS = adVar;
    }

    public void setOnSrollToTopListener(ae aeVar) {
        this.wU = aeVar;
    }

    public void setOnSrollToBottomListener(ab abVar) {
        this.wW = abVar;
    }

    public void setExOnSrollToBottomListener(ac acVar) {
        this.wX = acVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.wM = onItemLongClickListener;
        super.setOnItemLongClickListener(new v(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.wN = onItemSelectedListener;
        super.setOnItemSelectedListener(new w(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.wQ = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.wL = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.wK;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.wK instanceof k) {
            return this.wK.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.wK.a(listAdapter);
        super.setAdapter((ListAdapter) this.wK);
    }

    public void setOnHeaderClickListener(y yVar) {
        this.wO = yVar;
    }

    public void setOnFooterClickListener(x xVar) {
        this.wP = xVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.wK.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.wK.d(view, getHeaderIndex());
    }

    public void d(View view, int i) {
        this.wK.d(view, i);
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.wK.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.wK.getFooterViewsCount();
    }

    public void f(View view) {
        this.wK.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.wK.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.wK.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.wK.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.wK.removeFooter(view);
    }

    public void setNoData(String str) {
        if (this.xa != null) {
            removeHeaderView(this.xa);
            this.xa = null;
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
        if (this.wY != null) {
            removeHeaderView(this.wY.getView());
            this.wY = null;
        }
        if (iVar != null) {
            addHeaderView(iVar.getView());
            this.wY = iVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i, int i2) {
        super.setSelectionFromTop(i, i2);
    }

    public void setNextPage(i iVar) {
        if (this.wZ != null) {
            removeFooterView(this.wZ.getView());
            this.wZ = null;
        }
        if (iVar != null) {
            this.wK.b(iVar.getView(), null, true, 0);
            this.wZ = iVar;
        }
    }

    private int getHeaderIndex() {
        if (this.wY != null) {
            return this.wK.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.xc);
            getHandler().removeCallbacks(this.xh);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.xf = z;
    }

    public void setOnkbdStateListener(z zVar) {
        this.xg = zVar;
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
                if (this.xg != null) {
                    this.xg.onKeyBoardStateChange(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i4 ? i4 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i4 && i4 != this.mPreHeight) {
                this.xe = true;
                if (this.xg != null) {
                    this.xg.onKeyBoardStateChange(-3);
                }
                if (this.xf && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.xh, 1L);
                }
            }
            if (this.mLayoutHasInit && this.xe && this.mMaxHeight == i4) {
                this.xe = false;
                if (this.xg != null) {
                    this.xg.onKeyBoardStateChange(-2);
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
        if (this.xi != null) {
            removeHeaderView(this.xi.jE().getView());
        }
        this.xi = null;
        if (jVar != null) {
            this.xi = new af(this, jVar);
            this.xi.setOnScrollToPullListener(this.wS);
        }
    }

    public void jB() {
        if (this.xi != null) {
            af.a(this.xi);
        }
    }

    public void jC() {
        if (this.xi != null) {
            setSelection(0);
            this.xi.U(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.xi != null) {
            this.xi.a(motionEvent, this.xb);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.xi != null) {
            this.xi.b(motionEvent, this.xb);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean jD() {
        return this.xi == null || this.xi.mState == 3;
    }
}
