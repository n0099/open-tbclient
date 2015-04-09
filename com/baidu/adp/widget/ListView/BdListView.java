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
    private g HE;
    private AdapterView.OnItemClickListener HF;
    private AdapterView.OnItemLongClickListener HG;
    private AdapterView.OnItemSelectedListener HH;
    private u HI;
    private t HJ;
    private AbsListView.OnScrollListener HK;
    private w HL;
    private z HM;
    private long HN;
    private aa HO;
    private int HP;
    private x HQ;
    private y HR;
    private e HS;
    private e HT;
    private View HU;
    private int HV;
    private Runnable HW;
    private Runnable HX;
    private boolean HY;
    private boolean HZ;
    private v Ia;
    private Runnable Ib;
    private ab Ic;
    private final int REFRESH_DELAY;
    private boolean mLayoutHasInit;
    private int mMaxHeight;
    private int mPreHeight;
    private Runnable preLoadRunnable;

    public BdListView(Context context) {
        super(context);
        this.REFRESH_DELAY = 100;
        this.HE = null;
        this.HF = null;
        this.HG = null;
        this.HH = null;
        this.HI = null;
        this.HJ = null;
        this.HK = null;
        this.HL = null;
        this.HM = null;
        this.HN = 100L;
        this.HO = null;
        this.HP = 0;
        this.HQ = null;
        this.HR = null;
        this.HS = null;
        this.HT = null;
        this.HU = null;
        this.HV = 0;
        this.HW = new k(this);
        this.HX = new l(this);
        this.preLoadRunnable = new m(this);
        this.mLayoutHasInit = false;
        this.HY = false;
        this.HZ = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.Ia = null;
        this.Ib = new n(this);
        this.Ic = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.REFRESH_DELAY = 100;
        this.HE = null;
        this.HF = null;
        this.HG = null;
        this.HH = null;
        this.HI = null;
        this.HJ = null;
        this.HK = null;
        this.HL = null;
        this.HM = null;
        this.HN = 100L;
        this.HO = null;
        this.HP = 0;
        this.HQ = null;
        this.HR = null;
        this.HS = null;
        this.HT = null;
        this.HU = null;
        this.HV = 0;
        this.HW = new k(this);
        this.HX = new l(this);
        this.preLoadRunnable = new m(this);
        this.mLayoutHasInit = false;
        this.HY = false;
        this.HZ = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.Ia = null;
        this.Ib = new n(this);
        this.Ic = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.REFRESH_DELAY = 100;
        this.HE = null;
        this.HF = null;
        this.HG = null;
        this.HH = null;
        this.HI = null;
        this.HJ = null;
        this.HK = null;
        this.HL = null;
        this.HM = null;
        this.HN = 100L;
        this.HO = null;
        this.HP = 0;
        this.HQ = null;
        this.HR = null;
        this.HS = null;
        this.HT = null;
        this.HU = null;
        this.HV = 0;
        this.HW = new k(this);
        this.HX = new l(this);
        this.preLoadRunnable = new m(this);
        this.mLayoutHasInit = false;
        this.HY = false;
        this.HZ = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.Ia = null;
        this.Ib = new n(this);
        this.Ic = null;
        initial();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
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

    public void mV() {
        removeCallbacks(this.HX);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.HE = new g(getContext());
        this.HE.a(new o(this));
        super.setOnItemClickListener(new p(this));
        super.setOnScrollListener(new q(this));
    }

    public void setOnScrollToPullListener(z zVar) {
        this.HM = zVar;
    }

    public void setOnSrollToTopListener(aa aaVar) {
        this.HO = aaVar;
    }

    public void setOnSrollToBottomListener(x xVar) {
        this.HQ = xVar;
    }

    public void setExOnSrollToBottomListener(y yVar) {
        this.HR = yVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.HG = onItemLongClickListener;
        super.setOnItemLongClickListener(new r(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.HH = onItemSelectedListener;
        super.setOnItemSelectedListener(new s(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.HK = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.HF = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.HE;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.HE instanceof g) {
            return this.HE.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.HE.a(listAdapter);
        super.setAdapter((ListAdapter) this.HE);
    }

    public void setOnHeaderClickListener(u uVar) {
        this.HI = uVar;
    }

    public void setOnFooterClickListener(t tVar) {
        this.HJ = tVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.HE.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.HE.d(view, getHeaderIndex());
    }

    public void d(View view, int i) {
        this.HE.d(view, i);
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.HE.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.HE.getFooterViewsCount();
    }

    public void f(View view) {
        this.HE.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.HE.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.HE.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.HE.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.HE.removeFooter(view);
    }

    public void setNoData(String str) {
        if (this.HU != null) {
            removeHeaderView(this.HU);
            this.HU = null;
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

    public void setPrePage(e eVar) {
        if (this.HS != null) {
            removeHeaderView(this.HS.getView());
            this.HS = null;
        }
        if (eVar != null) {
            addHeaderView(eVar.getView());
            this.HS = eVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i, int i2) {
        super.setSelectionFromTop(i, i2);
    }

    public void setNextPage(e eVar) {
        if (this.HT != null) {
            removeFooterView(this.HT.getView());
            this.HT = null;
        }
        if (eVar != null) {
            this.HE.b(eVar.getView(), null, true, 0);
            this.HT = eVar;
        }
    }

    private int getHeaderIndex() {
        if (this.HS != null) {
            return this.HE.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.HW);
            getHandler().removeCallbacks(this.Ib);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.HZ = z;
    }

    public void setOnkbdStateListener(v vVar) {
        this.Ia = vVar;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i, i2, i3, i4);
            if (!this.mLayoutHasInit) {
                this.mLayoutHasInit = true;
                this.mMaxHeight = i4;
                if (this.Ia != null) {
                    this.Ia.onKeyBoardStateChange(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i4 ? i4 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i4 && i4 != this.mPreHeight) {
                this.HY = true;
                if (this.Ia != null) {
                    this.Ia.onKeyBoardStateChange(-3);
                }
                if (this.HZ && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.Ib, 1L);
                }
            }
            if (this.mLayoutHasInit && this.HY && this.mMaxHeight == i4) {
                this.HY = false;
                if (this.Ia != null) {
                    this.Ia.onKeyBoardStateChange(-2);
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

    public void setPullRefresh(f fVar) {
        if (this.Ic != null) {
            removeHeaderView(this.Ic.mZ().getView());
        }
        this.Ic = null;
        if (fVar != null) {
            this.Ic = new ab(this, fVar);
            this.Ic.setOnScrollToPullListener(this.HM);
        }
    }

    public void mW() {
        if (this.Ic != null) {
            ab.a(this.Ic);
        }
    }

    public void mX() {
        if (this.Ic != null) {
            setSelection(0);
            this.Ic.S(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Ic != null) {
            this.Ic.a(motionEvent, this.HV);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Ic != null) {
            this.Ic.b(motionEvent, this.HV);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean mY() {
        return this.Ic == null || this.Ic.mState == 3;
    }
}
