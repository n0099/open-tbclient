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
    private a HA;
    private AbsListView.OnScrollListener HB;
    private d HC;
    private g HD;
    private long HE;
    private h HF;
    private int HG;
    private e HH;
    private f HI;
    private com.baidu.adp.widget.ListView.c HJ;
    private com.baidu.adp.widget.ListView.c HK;
    private View HL;
    private int HM;
    private Runnable HN;
    private Runnable HO;
    private boolean HP;
    private boolean HQ;
    private c HR;
    private Runnable HS;
    private i HT;
    private com.baidu.adp.widget.ListView.e Hv;
    private AdapterView.OnItemClickListener Hw;
    private AdapterView.OnItemLongClickListener Hx;
    private AdapterView.OnItemSelectedListener Hy;
    private b Hz;
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
        this.Hv = null;
        this.Hw = null;
        this.Hx = null;
        this.Hy = null;
        this.Hz = null;
        this.HA = null;
        this.HB = null;
        this.HC = null;
        this.HD = null;
        this.HE = 100L;
        this.HF = null;
        this.HG = 0;
        this.HH = null;
        this.HI = null;
        this.HJ = null;
        this.HK = null;
        this.HL = null;
        this.HM = 0;
        this.HN = new com.baidu.adp.widget.ListView.g(this);
        this.HO = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.HP = false;
        this.HQ = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.HR = null;
        this.HS = new j(this);
        this.HT = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hv = null;
        this.Hw = null;
        this.Hx = null;
        this.Hy = null;
        this.Hz = null;
        this.HA = null;
        this.HB = null;
        this.HC = null;
        this.HD = null;
        this.HE = 100L;
        this.HF = null;
        this.HG = 0;
        this.HH = null;
        this.HI = null;
        this.HJ = null;
        this.HK = null;
        this.HL = null;
        this.HM = 0;
        this.HN = new com.baidu.adp.widget.ListView.g(this);
        this.HO = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.HP = false;
        this.HQ = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.HR = null;
        this.HS = new j(this);
        this.HT = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Hv = null;
        this.Hw = null;
        this.Hx = null;
        this.Hy = null;
        this.Hz = null;
        this.HA = null;
        this.HB = null;
        this.HC = null;
        this.HD = null;
        this.HE = 100L;
        this.HF = null;
        this.HG = 0;
        this.HH = null;
        this.HI = null;
        this.HJ = null;
        this.HK = null;
        this.HL = null;
        this.HM = 0;
        this.HN = new com.baidu.adp.widget.ListView.g(this);
        this.HO = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.HP = false;
        this.HQ = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.HR = null;
        this.HS = new j(this);
        this.HT = null;
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

    public void nu() {
        removeCallbacks(this.HO);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.Hv = new com.baidu.adp.widget.ListView.e(getContext());
        this.Hv.a(new k(this));
        super.setOnItemClickListener(new l(this));
        super.setOnScrollListener(new m(this));
    }

    public void setOnScrollToPullListener(g gVar) {
        this.HD = gVar;
    }

    public void setOnSrollToTopListener(h hVar) {
        this.HF = hVar;
    }

    public void setOnSrollToBottomListener(e eVar) {
        this.HH = eVar;
    }

    public void setExOnSrollToBottomListener(f fVar) {
        this.HI = fVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.Hx = onItemLongClickListener;
        super.setOnItemLongClickListener(new n(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.Hy = onItemSelectedListener;
        super.setOnItemSelectedListener(new o(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.HB = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Hw = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.Hv;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.Hv instanceof com.baidu.adp.widget.ListView.e) {
            return this.Hv.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.Hv.a(listAdapter);
        super.setAdapter((ListAdapter) this.Hv);
    }

    public void setOnHeaderClickListener(b bVar) {
        this.Hz = bVar;
    }

    public void setOnFooterClickListener(a aVar) {
        this.HA = aVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.Hv.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.Hv.d(view, getHeaderIndex());
    }

    public void d(View view, int i2) {
        this.Hv.d(view, i2);
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.Hv.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.Hv.getFooterViewsCount();
    }

    public void g(View view) {
        this.Hv.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.Hv.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.Hv.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.Hv.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.Hv.removeFooter(view);
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
        if (this.HL != null) {
            removeHeaderView(this.HL);
            this.HL = null;
        }
        if (view != null) {
            addHeaderView(view, null, false);
            this.HL = view;
        }
    }

    public void setPrePage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.HJ != null) {
            removeHeaderView(this.HJ.getView());
            this.HJ = null;
        }
        if (cVar != null) {
            addHeaderView(cVar.getView());
            this.HJ = cVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i2, int i3) {
        super.setSelectionFromTop(i2, i3);
    }

    public void setNextPage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.HK != null) {
            removeFooterView(this.HK.getView());
            this.HK = null;
        }
        if (cVar != null) {
            this.Hv.b(cVar.getView(), null, true, 0);
            this.HK = cVar;
        }
    }

    private int getHeaderIndex() {
        if (this.HJ != null) {
            return this.Hv.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.HN);
            getHandler().removeCallbacks(this.HS);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.HQ = z;
    }

    public void setOnkbdStateListener(c cVar) {
        this.HR = cVar;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i2, i3, i4, i5);
            if (!this.mLayoutHasInit) {
                this.mLayoutHasInit = true;
                this.mMaxHeight = i5;
                if (this.HR != null) {
                    this.HR.onKeyBoardStateChange(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i5 ? i5 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i5 && i5 != this.mPreHeight) {
                this.HP = true;
                if (this.HR != null) {
                    this.HR.onKeyBoardStateChange(-3);
                }
                if (this.HQ && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.HS, 1L);
                }
            }
            if (this.mLayoutHasInit && this.HP && this.mMaxHeight == i5) {
                this.HP = false;
                if (this.HR != null) {
                    this.HR.onKeyBoardStateChange(-2);
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
        if (this.HT != null) {
            removeHeaderView(this.HT.nx().getView());
        }
        this.HT = null;
        if (dVar != null) {
            this.HT = new i(this, dVar);
            this.HT.setOnScrollToPullListener(this.HD);
        }
    }

    public void completePullRefresh() {
        if (this.HT == null) {
            return;
        }
        this.HT.ny();
    }

    public void nv() {
        if (this.HT != null) {
            setSelection(0);
            this.HT.W(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.HT != null) {
            this.HT.a(motionEvent, this.HM);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.HT != null) {
            this.HT.b(motionEvent, this.HM);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public boolean nw() {
        return this.HT == null || this.HT.mState == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static float HV = 3.0f;
        private com.baidu.adp.widget.ListView.d HW;
        private BdListView mListView;
        private boolean HX = false;
        private int HY = 0;
        protected int mState = 3;
        private Boolean HZ = false;
        private g HD = null;
        private int Ia = 800;

        public i(BdListView bdListView, com.baidu.adp.widget.ListView.d dVar) {
            this.HW = null;
            this.mListView = null;
            if (dVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView == null) {
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            this.HW = dVar;
            this.mListView = bdListView;
            View view = this.HW.getView();
            view.setPadding(0, -this.HW.nq(), 0, 0);
            view.invalidate();
            this.mListView.g(view);
        }

        public com.baidu.adp.widget.ListView.d nx() {
            return this.HW;
        }

        public void done() {
            this.mState = 3;
            this.HW.setPadding(0, -this.HW.nq(), 0, 0);
            this.HW.S(true);
            if (this.HD != null) {
                this.HD.V(false);
            }
        }

        public void W(boolean z) {
            this.mState = 2;
            this.HW.setPadding(0, 0, 0, 0);
            this.HW.np();
            this.HW.T(z);
        }

        public void setOnScrollToPullListener(g gVar) {
            this.HD = gVar;
        }

        public void a(MotionEvent motionEvent, int i) {
            if (motionEvent.getAction() == 0 && nx().isEnable()) {
                this.HX = false;
                this.HZ = false;
                if (i == 0 && !this.HX) {
                    this.HX = true;
                    this.HY = (int) motionEvent.getY();
                }
            }
        }

        public void b(MotionEvent motionEvent, int i) {
            if (nx().isEnable()) {
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        if (this.mState != 2) {
                            if (this.mState == 1) {
                                this.mState = 3;
                                this.HW.setPadding(0, -this.HW.nq(), 0, 0);
                                this.HW.S(false);
                                if (this.HD != null) {
                                    this.HD.V(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 0) {
                                W(false);
                                if (this.HD != null) {
                                    this.HD.V(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 3 && this.HD != null) {
                                this.HD.V(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case 2:
                        int y = (int) motionEvent.getY();
                        if (!this.HX && i == 0) {
                            this.HX = true;
                            this.HY = y;
                        }
                        if (this.mState != 2 && this.HX) {
                            if (this.mState == 0) {
                                this.mListView.setSelection(0);
                                if (((int) ((y - this.HY) / HV)) < this.HW.nq() && y - this.HY > 0) {
                                    this.mState = 1;
                                    this.HW.R(this.HZ.booleanValue());
                                    this.HZ = false;
                                    if (this.HD != null) {
                                        this.HD.V(true);
                                    }
                                } else if (y - this.HY <= 0) {
                                    this.mState = 3;
                                    this.HW.setPadding(0, -this.HW.nq(), 0, 0);
                                    this.HW.S(false);
                                    if (this.HD != null) {
                                        this.HD.V(true);
                                    }
                                }
                            } else if (this.mState == 1) {
                                this.mListView.setSelection(0);
                                if (((int) ((y - this.HY) / HV)) >= this.HW.nq()) {
                                    this.mState = 0;
                                    this.HZ = true;
                                    this.HW.no();
                                    if (this.HD != null) {
                                        this.HD.V(true);
                                    }
                                } else if (y - this.HY <= 0) {
                                    this.mState = 3;
                                    this.HW.setPadding(0, -this.HW.nq(), 0, 0);
                                    this.HW.S(false);
                                    if (this.HD != null) {
                                        this.HD.V(true);
                                    }
                                }
                            } else if (this.mState == 3) {
                                if (y - this.HY > 0) {
                                    this.mState = 1;
                                    this.HW.R(this.HZ.booleanValue());
                                    this.HZ = false;
                                    if (this.HD != null) {
                                        this.HD.V(true);
                                    }
                                } else if (this.HD != null) {
                                    this.HD.V(false);
                                }
                            }
                            if (this.mState == 1 || this.mState == 0) {
                                this.HW.setPadding(0, ((int) ((y - this.HY) / HV)) - this.HW.nq(), 0, 0);
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
        public void ny() {
            View view;
            com.baidu.adp.widget.ListView.d nx = nx();
            if (nx != null && (view = nx.getView()) != null) {
                q qVar = new q(view.getContext(), 0, -nx.nq(), this.Ia);
                qVar.a(new p(this));
                qVar.h(view);
            }
        }
    }
}
