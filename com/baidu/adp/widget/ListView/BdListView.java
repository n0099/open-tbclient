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
    private AbsListView.OnScrollListener HA;
    private w HB;
    private z HC;
    private long HD;
    private aa HE;
    private int HF;
    private x HG;
    private y HH;
    private e HI;
    private e HJ;
    private View HK;
    private int HL;
    private Runnable HM;
    private Runnable HN;
    private boolean HO;
    private boolean HP;
    private v HQ;
    private Runnable HR;
    private ab HS;
    private g Hu;
    private AdapterView.OnItemClickListener Hv;
    private AdapterView.OnItemLongClickListener Hw;
    private AdapterView.OnItemSelectedListener Hx;
    private u Hy;
    private t Hz;
    private final int REFRESH_DELAY;
    private boolean mLayoutHasInit;
    private int mMaxHeight;
    private int mPreHeight;
    private Runnable preLoadRunnable;

    public BdListView(Context context) {
        super(context);
        this.REFRESH_DELAY = 100;
        this.Hu = null;
        this.Hv = null;
        this.Hw = null;
        this.Hx = null;
        this.Hy = null;
        this.Hz = null;
        this.HA = null;
        this.HB = null;
        this.HC = null;
        this.HD = 100L;
        this.HE = null;
        this.HF = 0;
        this.HG = null;
        this.HH = null;
        this.HI = null;
        this.HJ = null;
        this.HK = null;
        this.HL = 0;
        this.HM = new k(this);
        this.HN = new l(this);
        this.preLoadRunnable = new m(this);
        this.mLayoutHasInit = false;
        this.HO = false;
        this.HP = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.HQ = null;
        this.HR = new n(this);
        this.HS = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.REFRESH_DELAY = 100;
        this.Hu = null;
        this.Hv = null;
        this.Hw = null;
        this.Hx = null;
        this.Hy = null;
        this.Hz = null;
        this.HA = null;
        this.HB = null;
        this.HC = null;
        this.HD = 100L;
        this.HE = null;
        this.HF = 0;
        this.HG = null;
        this.HH = null;
        this.HI = null;
        this.HJ = null;
        this.HK = null;
        this.HL = 0;
        this.HM = new k(this);
        this.HN = new l(this);
        this.preLoadRunnable = new m(this);
        this.mLayoutHasInit = false;
        this.HO = false;
        this.HP = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.HQ = null;
        this.HR = new n(this);
        this.HS = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.REFRESH_DELAY = 100;
        this.Hu = null;
        this.Hv = null;
        this.Hw = null;
        this.Hx = null;
        this.Hy = null;
        this.Hz = null;
        this.HA = null;
        this.HB = null;
        this.HC = null;
        this.HD = 100L;
        this.HE = null;
        this.HF = 0;
        this.HG = null;
        this.HH = null;
        this.HI = null;
        this.HJ = null;
        this.HK = null;
        this.HL = 0;
        this.HM = new k(this);
        this.HN = new l(this);
        this.preLoadRunnable = new m(this);
        this.mLayoutHasInit = false;
        this.HO = false;
        this.HP = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.HQ = null;
        this.HR = new n(this);
        this.HS = null;
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

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        try {
            super.layoutChildren();
        } catch (NullPointerException e) {
            BdLog.detailException(e);
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    public void nn() {
        removeCallbacks(this.HN);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.Hu = new g(getContext());
        this.Hu.a(new o(this));
        super.setOnItemClickListener(new p(this));
        super.setOnScrollListener(new q(this));
    }

    public void setOnScrollToPullListener(z zVar) {
        this.HC = zVar;
    }

    public void setOnSrollToTopListener(aa aaVar) {
        this.HE = aaVar;
    }

    public void setOnSrollToBottomListener(x xVar) {
        this.HG = xVar;
    }

    public void setExOnSrollToBottomListener(y yVar) {
        this.HH = yVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.Hw = onItemLongClickListener;
        super.setOnItemLongClickListener(new r(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.Hx = onItemSelectedListener;
        super.setOnItemSelectedListener(new s(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.HA = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Hv = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.Hu;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.Hu instanceof g) {
            return this.Hu.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.Hu.a(listAdapter);
        super.setAdapter((ListAdapter) this.Hu);
    }

    public void setOnHeaderClickListener(u uVar) {
        this.Hy = uVar;
    }

    public void setOnFooterClickListener(t tVar) {
        this.Hz = tVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.Hu.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.Hu.d(view, getHeaderIndex());
    }

    public void d(View view, int i) {
        this.Hu.d(view, i);
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.Hu.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.Hu.getFooterViewsCount();
    }

    public void f(View view) {
        this.Hu.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.Hu.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.Hu.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.Hu.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.Hu.removeFooter(view);
    }

    public void setNoData(String str) {
        if (this.HK != null) {
            removeHeaderView(this.HK);
            this.HK = null;
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
        if (this.HI != null) {
            removeHeaderView(this.HI.getView());
            this.HI = null;
        }
        if (eVar != null) {
            addHeaderView(eVar.getView());
            this.HI = eVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i, int i2) {
        super.setSelectionFromTop(i, i2);
    }

    public void setNextPage(e eVar) {
        if (this.HJ != null) {
            removeFooterView(this.HJ.getView());
            this.HJ = null;
        }
        if (eVar != null) {
            this.Hu.b(eVar.getView(), null, true, 0);
            this.HJ = eVar;
        }
    }

    private int getHeaderIndex() {
        if (this.HI != null) {
            return this.Hu.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.HM);
            getHandler().removeCallbacks(this.HR);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.HP = z;
    }

    public void setOnkbdStateListener(v vVar) {
        this.HQ = vVar;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i, i2, i3, i4);
            if (!this.mLayoutHasInit) {
                this.mLayoutHasInit = true;
                this.mMaxHeight = i4;
                if (this.HQ != null) {
                    this.HQ.onKeyBoardStateChange(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i4 ? i4 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i4 && i4 != this.mPreHeight) {
                this.HO = true;
                if (this.HQ != null) {
                    this.HQ.onKeyBoardStateChange(-3);
                }
                if (this.HP && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.HR, 1L);
                }
            }
            if (this.mLayoutHasInit && this.HO && this.mMaxHeight == i4) {
                this.HO = false;
                if (this.HQ != null) {
                    this.HQ.onKeyBoardStateChange(-2);
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
        if (this.HS != null) {
            removeHeaderView(this.HS.nq().getView());
        }
        this.HS = null;
        if (fVar != null) {
            this.HS = new ab(this, fVar);
            this.HS.setOnScrollToPullListener(this.HC);
        }
    }

    public void completePullRefresh() {
        if (this.HS != null) {
            ab.a(this.HS);
        }
    }

    public void no() {
        if (this.HS != null) {
            setSelection(0);
            this.HS.U(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.HS != null) {
            this.HS.a(motionEvent, this.HL);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.HS != null) {
            this.HS.b(motionEvent, this.HL);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean np() {
        return this.HS == null || this.HS.mState == 3;
    }
}
