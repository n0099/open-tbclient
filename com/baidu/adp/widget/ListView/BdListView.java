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
    private b HA;
    private a HB;
    private AbsListView.OnScrollListener HC;
    private d HD;
    private g HE;
    private long HF;
    private h HG;
    private int HH;
    private e HI;
    private f HJ;
    private com.baidu.adp.widget.ListView.c HK;
    private com.baidu.adp.widget.ListView.c HL;
    private View HM;
    private int HN;
    private Runnable HO;
    private Runnable HP;
    private boolean HQ;
    private boolean HR;
    private c HS;
    private Runnable HT;
    private i HU;
    private com.baidu.adp.widget.ListView.e Hw;
    private AdapterView.OnItemClickListener Hx;
    private AdapterView.OnItemLongClickListener Hy;
    private AdapterView.OnItemSelectedListener Hz;
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
        this.Hw = null;
        this.Hx = null;
        this.Hy = null;
        this.Hz = null;
        this.HA = null;
        this.HB = null;
        this.HC = null;
        this.HD = null;
        this.HE = null;
        this.HF = 100L;
        this.HG = null;
        this.HH = 0;
        this.HI = null;
        this.HJ = null;
        this.HK = null;
        this.HL = null;
        this.HM = null;
        this.HN = 0;
        this.HO = new com.baidu.adp.widget.ListView.g(this);
        this.HP = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.HQ = false;
        this.HR = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.HS = null;
        this.HT = new j(this);
        this.HU = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hw = null;
        this.Hx = null;
        this.Hy = null;
        this.Hz = null;
        this.HA = null;
        this.HB = null;
        this.HC = null;
        this.HD = null;
        this.HE = null;
        this.HF = 100L;
        this.HG = null;
        this.HH = 0;
        this.HI = null;
        this.HJ = null;
        this.HK = null;
        this.HL = null;
        this.HM = null;
        this.HN = 0;
        this.HO = new com.baidu.adp.widget.ListView.g(this);
        this.HP = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.HQ = false;
        this.HR = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.HS = null;
        this.HT = new j(this);
        this.HU = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Hw = null;
        this.Hx = null;
        this.Hy = null;
        this.Hz = null;
        this.HA = null;
        this.HB = null;
        this.HC = null;
        this.HD = null;
        this.HE = null;
        this.HF = 100L;
        this.HG = null;
        this.HH = 0;
        this.HI = null;
        this.HJ = null;
        this.HK = null;
        this.HL = null;
        this.HM = null;
        this.HN = 0;
        this.HO = new com.baidu.adp.widget.ListView.g(this);
        this.HP = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.HQ = false;
        this.HR = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.HS = null;
        this.HT = new j(this);
        this.HU = null;
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

    public void nv() {
        removeCallbacks(this.HP);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.Hw = new com.baidu.adp.widget.ListView.e(getContext());
        this.Hw.a(new k(this));
        super.setOnItemClickListener(new l(this));
        super.setOnScrollListener(new m(this));
    }

    public void setOnScrollToPullListener(g gVar) {
        this.HE = gVar;
    }

    public void setOnSrollToTopListener(h hVar) {
        this.HG = hVar;
    }

    public void setOnSrollToBottomListener(e eVar) {
        this.HI = eVar;
    }

    public void setExOnSrollToBottomListener(f fVar) {
        this.HJ = fVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.Hy = onItemLongClickListener;
        super.setOnItemLongClickListener(new n(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.Hz = onItemSelectedListener;
        super.setOnItemSelectedListener(new o(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.HC = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Hx = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.Hw;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.Hw instanceof com.baidu.adp.widget.ListView.e) {
            return this.Hw.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.Hw.a(listAdapter);
        super.setAdapter((ListAdapter) this.Hw);
    }

    public void setOnHeaderClickListener(b bVar) {
        this.HA = bVar;
    }

    public void setOnFooterClickListener(a aVar) {
        this.HB = aVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.Hw.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.Hw.d(view, getHeaderIndex());
    }

    public void d(View view, int i2) {
        this.Hw.d(view, i2);
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.Hw.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.Hw.getFooterViewsCount();
    }

    public void g(View view) {
        this.Hw.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.Hw.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.Hw.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.Hw.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.Hw.removeFooter(view);
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
        if (this.HM != null) {
            removeHeaderView(this.HM);
            this.HM = null;
        }
        if (view != null) {
            addHeaderView(view, null, false);
            this.HM = view;
        }
    }

    public void setPrePage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.HK != null) {
            removeHeaderView(this.HK.getView());
            this.HK = null;
        }
        if (cVar != null) {
            addHeaderView(cVar.getView());
            this.HK = cVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i2, int i3) {
        super.setSelectionFromTop(i2, i3);
    }

    public void setNextPage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.HL != null) {
            removeFooterView(this.HL.getView());
            this.HL = null;
        }
        if (cVar != null) {
            this.Hw.b(cVar.getView(), null, true, 0);
            this.HL = cVar;
        }
    }

    private int getHeaderIndex() {
        if (this.HK != null) {
            return this.Hw.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.HO);
            getHandler().removeCallbacks(this.HT);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.HR = z;
    }

    public void setOnkbdStateListener(c cVar) {
        this.HS = cVar;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i2, i3, i4, i5);
            if (!this.mLayoutHasInit) {
                this.mLayoutHasInit = true;
                this.mMaxHeight = i5;
                if (this.HS != null) {
                    this.HS.onKeyBoardStateChange(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i5 ? i5 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i5 && i5 != this.mPreHeight) {
                this.HQ = true;
                if (this.HS != null) {
                    this.HS.onKeyBoardStateChange(-3);
                }
                if (this.HR && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.HT, 1L);
                }
            }
            if (this.mLayoutHasInit && this.HQ && this.mMaxHeight == i5) {
                this.HQ = false;
                if (this.HS != null) {
                    this.HS.onKeyBoardStateChange(-2);
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
        if (this.HU != null) {
            removeHeaderView(this.HU.ny().getView());
        }
        this.HU = null;
        if (dVar != null) {
            this.HU = new i(this, dVar);
            this.HU.setOnScrollToPullListener(this.HE);
        }
    }

    public void completePullRefresh() {
        if (this.HU == null) {
            return;
        }
        this.HU.nz();
    }

    public void nw() {
        if (this.HU != null) {
            setSelection(0);
            this.HU.W(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.HU != null) {
            this.HU.a(motionEvent, this.HN);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.HU != null) {
            this.HU.b(motionEvent, this.HN);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public boolean nx() {
        return this.HU == null || this.HU.mState == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static float HW = 3.0f;
        private com.baidu.adp.widget.ListView.d HX;
        private BdListView mListView;
        private boolean HY = false;
        private int HZ = 0;
        protected int mState = 3;
        private Boolean Ia = false;
        private g HE = null;
        private int Ib = 800;

        public i(BdListView bdListView, com.baidu.adp.widget.ListView.d dVar) {
            this.HX = null;
            this.mListView = null;
            if (dVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView == null) {
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            this.HX = dVar;
            this.mListView = bdListView;
            View view = this.HX.getView();
            view.setPadding(0, -this.HX.nr(), 0, 0);
            view.invalidate();
            this.mListView.g(view);
        }

        public com.baidu.adp.widget.ListView.d ny() {
            return this.HX;
        }

        public void done() {
            this.mState = 3;
            this.HX.setPadding(0, -this.HX.nr(), 0, 0);
            this.HX.S(true);
            if (this.HE != null) {
                this.HE.V(false);
            }
        }

        public void W(boolean z) {
            this.mState = 2;
            this.HX.setPadding(0, 0, 0, 0);
            this.HX.nq();
            this.HX.T(z);
        }

        public void setOnScrollToPullListener(g gVar) {
            this.HE = gVar;
        }

        public void a(MotionEvent motionEvent, int i) {
            if (motionEvent.getAction() == 0 && ny().isEnable()) {
                this.HY = false;
                this.Ia = false;
                if (i == 0 && !this.HY) {
                    this.HY = true;
                    this.HZ = (int) motionEvent.getY();
                }
            }
        }

        public void b(MotionEvent motionEvent, int i) {
            if (ny().isEnable()) {
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        if (this.mState != 2) {
                            if (this.mState == 1) {
                                this.mState = 3;
                                this.HX.setPadding(0, -this.HX.nr(), 0, 0);
                                this.HX.S(false);
                                if (this.HE != null) {
                                    this.HE.V(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 0) {
                                W(false);
                                if (this.HE != null) {
                                    this.HE.V(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 3 && this.HE != null) {
                                this.HE.V(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case 2:
                        int y = (int) motionEvent.getY();
                        if (!this.HY && i == 0) {
                            this.HY = true;
                            this.HZ = y;
                        }
                        if (this.mState != 2 && this.HY) {
                            if (this.mState == 0) {
                                this.mListView.setSelection(0);
                                if (((int) ((y - this.HZ) / HW)) < this.HX.nr() && y - this.HZ > 0) {
                                    this.mState = 1;
                                    this.HX.R(this.Ia.booleanValue());
                                    this.Ia = false;
                                    if (this.HE != null) {
                                        this.HE.V(true);
                                    }
                                } else if (y - this.HZ <= 0) {
                                    this.mState = 3;
                                    this.HX.setPadding(0, -this.HX.nr(), 0, 0);
                                    this.HX.S(false);
                                    if (this.HE != null) {
                                        this.HE.V(true);
                                    }
                                }
                            } else if (this.mState == 1) {
                                this.mListView.setSelection(0);
                                if (((int) ((y - this.HZ) / HW)) >= this.HX.nr()) {
                                    this.mState = 0;
                                    this.Ia = true;
                                    this.HX.np();
                                    if (this.HE != null) {
                                        this.HE.V(true);
                                    }
                                } else if (y - this.HZ <= 0) {
                                    this.mState = 3;
                                    this.HX.setPadding(0, -this.HX.nr(), 0, 0);
                                    this.HX.S(false);
                                    if (this.HE != null) {
                                        this.HE.V(true);
                                    }
                                }
                            } else if (this.mState == 3) {
                                if (y - this.HZ > 0) {
                                    this.mState = 1;
                                    this.HX.R(this.Ia.booleanValue());
                                    this.Ia = false;
                                    if (this.HE != null) {
                                        this.HE.V(true);
                                    }
                                } else if (this.HE != null) {
                                    this.HE.V(false);
                                }
                            }
                            if (this.mState == 1 || this.mState == 0) {
                                this.HX.setPadding(0, ((int) ((y - this.HZ) / HW)) - this.HX.nr(), 0, 0);
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
        public void nz() {
            View view;
            com.baidu.adp.widget.ListView.d ny = ny();
            if (ny != null && (view = ny.getView()) != null) {
                q qVar = new q(view.getContext(), 0, -ny.nr(), this.Ib);
                qVar.a(new p(this));
                qVar.h(view);
            }
        }
    }
}
