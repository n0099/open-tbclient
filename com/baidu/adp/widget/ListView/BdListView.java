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
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdListView extends ListView {
    private AdapterView.OnItemSelectedListener HA;
    private b HB;
    private a HC;
    private AbsListView.OnScrollListener HD;
    private d HE;
    private g HF;
    private long HG;
    private h HH;
    private int HI;
    private e HJ;
    private f HK;
    private com.baidu.adp.widget.ListView.c HL;
    private com.baidu.adp.widget.ListView.c HM;
    private View HN;
    private int HO;
    private Runnable HP;
    private Runnable HQ;
    private boolean HR;
    private boolean HS;
    private c HT;
    private Runnable HU;
    private i HV;
    private com.baidu.adp.widget.ListView.e Hx;
    private AdapterView.OnItemClickListener Hy;
    private AdapterView.OnItemLongClickListener Hz;
    private boolean mLayoutHasInit;
    private int mMaxHeight;
    private int mPreHeight;
    private Runnable preLoadRunnable;

    /* loaded from: classes.dex */
    public interface a {
        void onClick(View view);
    }

    /* loaded from: classes.dex */
    public interface b {
        void onClick(View view);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onKeyBoardStateChange(int i);
    }

    /* loaded from: classes.dex */
    public interface d {
        void i(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface e {
        void onScrollToBottom();
    }

    /* loaded from: classes.dex */
    public interface f {
        void s(BdListView bdListView);
    }

    /* loaded from: classes.dex */
    public interface g {
        void V(boolean z);
    }

    /* loaded from: classes.dex */
    public interface h {
        void onScrollToTop();
    }

    public BdListView(Context context) {
        super(context);
        this.Hx = null;
        this.Hy = null;
        this.Hz = null;
        this.HA = null;
        this.HB = null;
        this.HC = null;
        this.HD = null;
        this.HE = null;
        this.HF = null;
        this.HG = 100L;
        this.HH = null;
        this.HI = 0;
        this.HJ = null;
        this.HK = null;
        this.HL = null;
        this.HM = null;
        this.HN = null;
        this.HO = 0;
        this.HP = new com.baidu.adp.widget.ListView.g(this);
        this.HQ = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.HR = false;
        this.HS = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.HT = null;
        this.HU = new j(this);
        this.HV = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hx = null;
        this.Hy = null;
        this.Hz = null;
        this.HA = null;
        this.HB = null;
        this.HC = null;
        this.HD = null;
        this.HE = null;
        this.HF = null;
        this.HG = 100L;
        this.HH = null;
        this.HI = 0;
        this.HJ = null;
        this.HK = null;
        this.HL = null;
        this.HM = null;
        this.HN = null;
        this.HO = 0;
        this.HP = new com.baidu.adp.widget.ListView.g(this);
        this.HQ = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.HR = false;
        this.HS = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.HT = null;
        this.HU = new j(this);
        this.HV = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Hx = null;
        this.Hy = null;
        this.Hz = null;
        this.HA = null;
        this.HB = null;
        this.HC = null;
        this.HD = null;
        this.HE = null;
        this.HF = null;
        this.HG = 100L;
        this.HH = null;
        this.HI = 0;
        this.HJ = null;
        this.HK = null;
        this.HL = null;
        this.HM = null;
        this.HN = null;
        this.HO = 0;
        this.HP = new com.baidu.adp.widget.ListView.g(this);
        this.HQ = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.HR = false;
        this.HS = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.HT = null;
        this.HU = new j(this);
        this.HV = null;
        initial();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (NullPointerException e2) {
            BdLog.detailException(e2);
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        } catch (OutOfMemoryError e3) {
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
        } catch (NullPointerException e2) {
            BdLog.detailException(e2);
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    public void nw() {
        removeCallbacks(this.HQ);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.Hx = new com.baidu.adp.widget.ListView.e(getContext());
        this.Hx.a(new k(this));
        super.setOnItemClickListener(new l(this));
        super.setOnScrollListener(new m(this));
    }

    public void setOnScrollToPullListener(g gVar) {
        this.HF = gVar;
    }

    public void setOnSrollToTopListener(h hVar) {
        this.HH = hVar;
    }

    public void setOnSrollToBottomListener(e eVar) {
        this.HJ = eVar;
    }

    public void setExOnSrollToBottomListener(f fVar) {
        this.HK = fVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.Hz = onItemLongClickListener;
        super.setOnItemLongClickListener(new n(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.HA = onItemSelectedListener;
        super.setOnItemSelectedListener(new o(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.HD = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Hy = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.Hx;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.Hx instanceof com.baidu.adp.widget.ListView.e) {
            return this.Hx.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.Hx.a(listAdapter);
        super.setAdapter((ListAdapter) this.Hx);
    }

    public void setOnHeaderClickListener(b bVar) {
        this.HB = bVar;
    }

    public void setOnFooterClickListener(a aVar) {
        this.HC = aVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.Hx.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.Hx.d(view, getHeaderIndex());
    }

    public void d(View view, int i2) {
        this.Hx.d(view, i2);
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.Hx.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.Hx.getFooterViewsCount();
    }

    public void g(View view) {
        this.Hx.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.Hx.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.Hx.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.Hx.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.Hx.removeFooter(view);
    }

    public void setNoData(String str) {
        if (str != null) {
            TextView textView = new TextView(getContext());
            textView.setText(str);
            textView.setTextSize(16.0f);
            textView.setGravity(17);
            setNoData(textView);
        }
    }

    public void setNoData(View view) {
        if (this.HN != null) {
            removeHeaderView(this.HN);
            this.HN = null;
        }
        if (view != null) {
            addHeaderView(view, null, false);
            this.HN = view;
        }
    }

    public void setPrePage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.HL != null) {
            removeHeaderView(this.HL.getView());
            this.HL = null;
        }
        if (cVar != null) {
            addHeaderView(cVar.getView());
            this.HL = cVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i2, int i3) {
        super.setSelectionFromTop(i2, i3);
    }

    public void setNextPage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.HM != null) {
            removeFooterView(this.HM.getView());
            this.HM = null;
        }
        if (cVar != null) {
            this.Hx.b(cVar.getView(), null, true, 0);
            this.HM = cVar;
        }
    }

    private int getHeaderIndex() {
        if (this.HL != null) {
            return this.Hx.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.HP);
            getHandler().removeCallbacks(this.HU);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.HS = z;
    }

    public void setOnkbdStateListener(c cVar) {
        this.HT = cVar;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i2, i3, i4, i5);
            if (!this.mLayoutHasInit) {
                this.mLayoutHasInit = true;
                this.mMaxHeight = i5;
                if (this.HT != null) {
                    this.HT.onKeyBoardStateChange(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i5 ? i5 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i5 && i5 != this.mPreHeight) {
                this.HR = true;
                if (this.HT != null) {
                    this.HT.onKeyBoardStateChange(-3);
                }
                if (this.HS && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.HU, 1L);
                }
            }
            if (this.mLayoutHasInit && this.HR && this.mMaxHeight == i5) {
                this.HR = false;
                if (this.HT != null) {
                    this.HT.onKeyBoardStateChange(-2);
                }
            }
            this.mPreHeight = i5;
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    public void setPullRefresh(com.baidu.adp.widget.ListView.d dVar) {
        if (this.HV != null) {
            removeHeaderView(this.HV.nz().getView());
        }
        this.HV = null;
        if (dVar != null) {
            this.HV = new i(this, dVar);
            this.HV.setOnScrollToPullListener(this.HF);
        }
    }

    public void completePullRefresh() {
        if (this.HV == null) {
            return;
        }
        this.HV.nA();
    }

    public void nx() {
        if (this.HV != null) {
            setSelection(0);
            this.HV.W(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.HV != null) {
            this.HV.a(motionEvent, this.HO);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.HV != null) {
            this.HV.b(motionEvent, this.HO);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public boolean ny() {
        return this.HV == null || this.HV.mState == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static float HX = 3.0f;
        private com.baidu.adp.widget.ListView.d HY;
        private BdListView mListView;
        private boolean HZ = false;
        private int Ia = 0;
        protected int mState = 3;
        private Boolean Ib = false;
        private g HF = null;
        private int Ic = 800;

        public i(BdListView bdListView, com.baidu.adp.widget.ListView.d dVar) {
            this.HY = null;
            this.mListView = null;
            if (dVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView == null) {
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            this.HY = dVar;
            this.mListView = bdListView;
            View view = this.HY.getView();
            view.setPadding(0, -this.HY.ns(), 0, 0);
            view.invalidate();
            this.mListView.g(view);
        }

        public com.baidu.adp.widget.ListView.d nz() {
            return this.HY;
        }

        public void done() {
            this.mState = 3;
            this.HY.setPadding(0, -this.HY.ns(), 0, 0);
            this.HY.S(true);
            if (this.HF != null) {
                this.HF.V(false);
            }
        }

        public void W(boolean z) {
            this.mState = 2;
            this.HY.setPadding(0, 0, 0, 0);
            this.HY.nr();
            this.HY.T(z);
        }

        public void setOnScrollToPullListener(g gVar) {
            this.HF = gVar;
        }

        public void a(MotionEvent motionEvent, int i) {
            if (motionEvent.getAction() == 0 && nz().isEnable()) {
                this.HZ = false;
                this.Ib = false;
                if (i == 0 && !this.HZ) {
                    this.HZ = true;
                    this.Ia = (int) motionEvent.getY();
                }
            }
        }

        public void b(MotionEvent motionEvent, int i) {
            if (nz().isEnable()) {
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        if (this.mState != 2) {
                            if (this.mState == 1) {
                                this.mState = 3;
                                this.HY.setPadding(0, -this.HY.ns(), 0, 0);
                                this.HY.S(false);
                                if (this.HF != null) {
                                    this.HF.V(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 0) {
                                W(false);
                                if (this.HF != null) {
                                    this.HF.V(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 3 && this.HF != null) {
                                this.HF.V(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case 2:
                        int y = (int) motionEvent.getY();
                        if (!this.HZ && i == 0) {
                            this.HZ = true;
                            this.Ia = y;
                        }
                        if (this.mState != 2 && this.HZ) {
                            if (this.mState == 0) {
                                this.mListView.setSelection(0);
                                if (((int) ((y - this.Ia) / HX)) < this.HY.ns() && y - this.Ia > 0) {
                                    this.mState = 1;
                                    this.HY.R(this.Ib.booleanValue());
                                    this.Ib = false;
                                    if (this.HF != null) {
                                        this.HF.V(true);
                                    }
                                } else if (y - this.Ia <= 0) {
                                    this.mState = 3;
                                    this.HY.setPadding(0, -this.HY.ns(), 0, 0);
                                    this.HY.S(false);
                                    if (this.HF != null) {
                                        this.HF.V(true);
                                    }
                                }
                            } else if (this.mState == 1) {
                                this.mListView.setSelection(0);
                                if (((int) ((y - this.Ia) / HX)) >= this.HY.ns()) {
                                    this.mState = 0;
                                    this.Ib = true;
                                    this.HY.nq();
                                    if (this.HF != null) {
                                        this.HF.V(true);
                                    }
                                } else if (y - this.Ia <= 0) {
                                    this.mState = 3;
                                    this.HY.setPadding(0, -this.HY.ns(), 0, 0);
                                    this.HY.S(false);
                                    if (this.HF != null) {
                                        this.HF.V(true);
                                    }
                                }
                            } else if (this.mState == 3) {
                                if (y - this.Ia > 0) {
                                    this.mState = 1;
                                    this.HY.R(this.Ib.booleanValue());
                                    this.Ib = false;
                                    if (this.HF != null) {
                                        this.HF.V(true);
                                    }
                                } else if (this.HF != null) {
                                    this.HF.V(false);
                                }
                            }
                            if (this.mState == 1 || this.mState == 0) {
                                this.HY.setPadding(0, ((int) ((y - this.Ia) / HX)) - this.HY.ns(), 0, 0);
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void nA() {
            View view;
            com.baidu.adp.widget.ListView.d nz = nz();
            if (nz != null && (view = nz.getView()) != null) {
                q qVar = new q(view.getContext(), 0, -nz.ns(), this.Ic);
                qVar.a(new p(this));
                qVar.h(view);
            }
        }
    }
}
