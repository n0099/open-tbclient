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
    private g HC;
    private AdapterView.OnItemClickListener HD;
    private AdapterView.OnItemLongClickListener HE;
    private AdapterView.OnItemSelectedListener HF;
    private u HG;
    private t HH;
    private AbsListView.OnScrollListener HI;
    private w HJ;
    private z HK;
    private long HL;
    private aa HM;
    private int HN;
    private x HO;
    private y HP;
    private e HQ;
    private e HR;
    private View HS;
    private int HT;
    private Runnable HU;
    private Runnable HV;
    private boolean HW;
    private boolean HX;
    private v HY;
    private Runnable HZ;
    private ab Ia;
    private final int REFRESH_DELAY;
    private boolean mLayoutHasInit;
    private int mMaxHeight;
    private int mPreHeight;
    private Runnable preLoadRunnable;

    public BdListView(Context context) {
        super(context);
        this.REFRESH_DELAY = 100;
        this.HC = null;
        this.HD = null;
        this.HE = null;
        this.HF = null;
        this.HG = null;
        this.HH = null;
        this.HI = null;
        this.HJ = null;
        this.HK = null;
        this.HL = 100L;
        this.HM = null;
        this.HN = 0;
        this.HO = null;
        this.HP = null;
        this.HQ = null;
        this.HR = null;
        this.HS = null;
        this.HT = 0;
        this.HU = new k(this);
        this.HV = new l(this);
        this.preLoadRunnable = new m(this);
        this.mLayoutHasInit = false;
        this.HW = false;
        this.HX = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.HY = null;
        this.HZ = new n(this);
        this.Ia = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.REFRESH_DELAY = 100;
        this.HC = null;
        this.HD = null;
        this.HE = null;
        this.HF = null;
        this.HG = null;
        this.HH = null;
        this.HI = null;
        this.HJ = null;
        this.HK = null;
        this.HL = 100L;
        this.HM = null;
        this.HN = 0;
        this.HO = null;
        this.HP = null;
        this.HQ = null;
        this.HR = null;
        this.HS = null;
        this.HT = 0;
        this.HU = new k(this);
        this.HV = new l(this);
        this.preLoadRunnable = new m(this);
        this.mLayoutHasInit = false;
        this.HW = false;
        this.HX = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.HY = null;
        this.HZ = new n(this);
        this.Ia = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.REFRESH_DELAY = 100;
        this.HC = null;
        this.HD = null;
        this.HE = null;
        this.HF = null;
        this.HG = null;
        this.HH = null;
        this.HI = null;
        this.HJ = null;
        this.HK = null;
        this.HL = 100L;
        this.HM = null;
        this.HN = 0;
        this.HO = null;
        this.HP = null;
        this.HQ = null;
        this.HR = null;
        this.HS = null;
        this.HT = 0;
        this.HU = new k(this);
        this.HV = new l(this);
        this.preLoadRunnable = new m(this);
        this.mLayoutHasInit = false;
        this.HW = false;
        this.HX = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.HY = null;
        this.HZ = new n(this);
        this.Ia = null;
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
        removeCallbacks(this.HV);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.HC = new g(getContext());
        this.HC.a(new o(this));
        super.setOnItemClickListener(new p(this));
        super.setOnScrollListener(new q(this));
    }

    public void setOnScrollToPullListener(z zVar) {
        this.HK = zVar;
    }

    public void setOnSrollToTopListener(aa aaVar) {
        this.HM = aaVar;
    }

    public void setOnSrollToBottomListener(x xVar) {
        this.HO = xVar;
    }

    public void setExOnSrollToBottomListener(y yVar) {
        this.HP = yVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.HE = onItemLongClickListener;
        super.setOnItemLongClickListener(new r(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.HF = onItemSelectedListener;
        super.setOnItemSelectedListener(new s(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.HI = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.HD = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.HC;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.HC instanceof g) {
            return this.HC.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.HC.a(listAdapter);
        super.setAdapter((ListAdapter) this.HC);
    }

    public void setOnHeaderClickListener(u uVar) {
        this.HG = uVar;
    }

    public void setOnFooterClickListener(t tVar) {
        this.HH = tVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.HC.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.HC.d(view, getHeaderIndex());
    }

    public void d(View view, int i) {
        this.HC.d(view, i);
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.HC.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.HC.getFooterViewsCount();
    }

    public void f(View view) {
        this.HC.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.HC.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.HC.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.HC.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.HC.removeFooter(view);
    }

    public void setNoData(String str) {
        if (this.HS != null) {
            removeHeaderView(this.HS);
            this.HS = null;
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
        if (this.HQ != null) {
            removeHeaderView(this.HQ.getView());
            this.HQ = null;
        }
        if (eVar != null) {
            addHeaderView(eVar.getView());
            this.HQ = eVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i, int i2) {
        super.setSelectionFromTop(i, i2);
    }

    public void setNextPage(e eVar) {
        if (this.HR != null) {
            removeFooterView(this.HR.getView());
            this.HR = null;
        }
        if (eVar != null) {
            this.HC.b(eVar.getView(), null, true, 0);
            this.HR = eVar;
        }
    }

    private int getHeaderIndex() {
        if (this.HQ != null) {
            return this.HC.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.HU);
            getHandler().removeCallbacks(this.HZ);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.HX = z;
    }

    public void setOnkbdStateListener(v vVar) {
        this.HY = vVar;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i, i2, i3, i4);
            if (!this.mLayoutHasInit) {
                this.mLayoutHasInit = true;
                this.mMaxHeight = i4;
                if (this.HY != null) {
                    this.HY.onKeyBoardStateChange(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i4 ? i4 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i4 && i4 != this.mPreHeight) {
                this.HW = true;
                if (this.HY != null) {
                    this.HY.onKeyBoardStateChange(-3);
                }
                if (this.HX && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.HZ, 1L);
                }
            }
            if (this.mLayoutHasInit && this.HW && this.mMaxHeight == i4) {
                this.HW = false;
                if (this.HY != null) {
                    this.HY.onKeyBoardStateChange(-2);
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
        if (this.Ia != null) {
            removeHeaderView(this.Ia.mZ().getView());
        }
        this.Ia = null;
        if (fVar != null) {
            this.Ia = new ab(this, fVar);
            this.Ia.setOnScrollToPullListener(this.HK);
        }
    }

    public void mW() {
        if (this.Ia != null) {
            ab.a(this.Ia);
        }
    }

    public void mX() {
        if (this.Ia != null) {
            setSelection(0);
            this.Ia.S(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Ia != null) {
            this.Ia.a(motionEvent, this.HT);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Ia != null) {
            this.Ia.b(motionEvent, this.HT);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean mY() {
        return this.Ia == null || this.Ia.mState == 3;
    }
}
