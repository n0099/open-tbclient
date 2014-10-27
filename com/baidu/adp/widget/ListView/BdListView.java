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
    private boolean mLayoutHasInit;
    private int mMaxHeight;
    private int mPreHeight;
    private Runnable preLoadRunnable;
    private final int uG;
    private j uH;
    private AdapterView.OnItemClickListener uI;
    private AdapterView.OnItemLongClickListener uJ;
    private AdapterView.OnItemSelectedListener uK;
    private x uL;
    private w uM;
    private AbsListView.OnScrollListener uN;
    private z uO;
    private ac uP;
    private long uQ;
    private ad uR;
    private int uS;
    private aa uT;
    private ab uU;
    private h uV;
    private h uW;
    private View uX;
    private int uY;
    private Runnable uZ;
    private Runnable va;
    private boolean vb;
    private boolean vc;
    private y vd;
    private Runnable ve;
    private ae vf;

    public BdListView(Context context) {
        super(context);
        this.uG = 100;
        this.uH = null;
        this.uI = null;
        this.uJ = null;
        this.uK = null;
        this.uL = null;
        this.uM = null;
        this.uN = null;
        this.uO = null;
        this.uP = null;
        this.uQ = 100L;
        this.uR = null;
        this.uS = 0;
        this.uT = null;
        this.uU = null;
        this.uV = null;
        this.uW = null;
        this.uX = null;
        this.uY = 0;
        this.uZ = new n(this);
        this.va = new o(this);
        this.preLoadRunnable = new p(this);
        this.mLayoutHasInit = false;
        this.vb = false;
        this.vc = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.vd = null;
        this.ve = new q(this);
        this.vf = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.uG = 100;
        this.uH = null;
        this.uI = null;
        this.uJ = null;
        this.uK = null;
        this.uL = null;
        this.uM = null;
        this.uN = null;
        this.uO = null;
        this.uP = null;
        this.uQ = 100L;
        this.uR = null;
        this.uS = 0;
        this.uT = null;
        this.uU = null;
        this.uV = null;
        this.uW = null;
        this.uX = null;
        this.uY = 0;
        this.uZ = new n(this);
        this.va = new o(this);
        this.preLoadRunnable = new p(this);
        this.mLayoutHasInit = false;
        this.vb = false;
        this.vc = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.vd = null;
        this.ve = new q(this);
        this.vf = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uG = 100;
        this.uH = null;
        this.uI = null;
        this.uJ = null;
        this.uK = null;
        this.uL = null;
        this.uM = null;
        this.uN = null;
        this.uO = null;
        this.uP = null;
        this.uQ = 100L;
        this.uR = null;
        this.uS = 0;
        this.uT = null;
        this.uU = null;
        this.uV = null;
        this.uW = null;
        this.uX = null;
        this.uY = 0;
        this.uZ = new n(this);
        this.va = new o(this);
        this.preLoadRunnable = new p(this);
        this.mLayoutHasInit = false;
        this.vb = false;
        this.vc = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.vd = null;
        this.ve = new q(this);
        this.vf = null;
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

    public void hM() {
        removeCallbacks(this.va);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.uH = new j(getContext());
        this.uH.a(new r(this));
        super.setOnItemClickListener(new s(this));
        super.setOnScrollListener(new t(this));
    }

    public void setOnScrollToPullListener(ac acVar) {
        this.uP = acVar;
    }

    public void setOnSrollToTopListener(ad adVar) {
        this.uR = adVar;
    }

    public void setOnSrollToBottomListener(aa aaVar) {
        this.uT = aaVar;
    }

    public void setExOnSrollToBottomListener(ab abVar) {
        this.uU = abVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.uJ = onItemLongClickListener;
        super.setOnItemLongClickListener(new u(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.uK = onItemSelectedListener;
        super.setOnItemSelectedListener(new v(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.uN = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.uI = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.uH;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.uH instanceof j) {
            return this.uH.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.uH.a(listAdapter);
        super.setAdapter((ListAdapter) this.uH);
    }

    public void setOnHeaderClickListener(x xVar) {
        this.uL = xVar;
    }

    public void setOnFooterClickListener(w wVar) {
        this.uM = wVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.uH.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.uH.c(view, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.uH.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.uH.getFooterViewsCount();
    }

    public void f(View view) {
        this.uH.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.uH.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.uH.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.uH.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.uH.removeFooter(view);
    }

    public void setNoData(String str) {
        if (this.uX != null) {
            removeHeaderView(this.uX);
            this.uX = null;
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

    public void setPrePage(h hVar) {
        if (this.uV != null) {
            removeHeaderView(this.uV.getView());
            this.uV = null;
        }
        if (hVar != null) {
            addHeaderView(hVar.getView());
            this.uV = hVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i, int i2) {
        super.setSelectionFromTop(i, i2);
    }

    public void setNextPage(h hVar) {
        if (this.uW != null) {
            removeFooterView(this.uW.getView());
            this.uW = null;
        }
        if (hVar != null) {
            this.uH.b(hVar.getView(), null, true, 0);
            this.uW = hVar;
        }
    }

    private int getHeaderIndex() {
        if (this.uV != null) {
            return this.uH.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.uZ);
            getHandler().removeCallbacks(this.ve);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.vc = z;
    }

    public void setOnkbdStateListener(y yVar) {
        this.vd = yVar;
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
                if (this.vd != null) {
                    this.vd.aj(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i4 ? i4 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i4 && i4 != this.mPreHeight) {
                this.vb = true;
                if (this.vd != null) {
                    this.vd.aj(-3);
                }
                if (this.vc && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.ve, 1L);
                }
            }
            if (this.mLayoutHasInit && this.vb && this.mMaxHeight == i4) {
                this.vb = false;
                if (this.vd != null) {
                    this.vd.aj(-2);
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

    public void setPullRefresh(i iVar) {
        if (this.vf != null) {
            removeHeaderView(this.vf.hS().getView());
        }
        this.vf = null;
        if (iVar != null) {
            this.vf = new ae(this, iVar);
            this.vf.setOnScrollToPullListener(this.uP);
        }
    }

    public void hN() {
        if (this.vf != null) {
            ae.a(this.vf);
        }
    }

    public void hO() {
        if (this.vf != null) {
            setSelection(0);
            this.vf.J(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.vf != null) {
            this.vf.a(motionEvent, this.uY);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.vf != null) {
            this.vf.b(motionEvent, this.uY);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean hP() {
        return this.vf == null || this.vf.mState == 3;
    }
}
