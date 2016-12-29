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
    private com.baidu.adp.widget.ListView.e BG;
    private AdapterView.OnItemClickListener BH;
    private AdapterView.OnItemLongClickListener BI;
    private AdapterView.OnItemSelectedListener BJ;
    private b BK;
    private a BL;
    private AbsListView.OnScrollListener BM;
    private d BN;
    private g BO;
    private long BP;
    private h BQ;
    private int BR;
    private e BS;
    private f BT;
    private com.baidu.adp.widget.ListView.c BU;
    private com.baidu.adp.widget.ListView.c BV;
    private View BW;
    private int BX;
    private Runnable BY;
    private Runnable BZ;
    private boolean Ca;
    private boolean Cb;
    private c Cc;
    private Runnable Cd;
    private i Ce;
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
        void aL(int i);
    }

    /* loaded from: classes.dex */
    public interface d {
        void k(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface e {
        void kx();
    }

    /* loaded from: classes.dex */
    public interface f {
        void t(BdListView bdListView);
    }

    /* loaded from: classes.dex */
    public interface g {
        void V(boolean z);
    }

    /* loaded from: classes.dex */
    public interface h {
        void ky();
    }

    public BdListView(Context context) {
        super(context);
        this.BG = null;
        this.BH = null;
        this.BI = null;
        this.BJ = null;
        this.BK = null;
        this.BL = null;
        this.BM = null;
        this.BN = null;
        this.BO = null;
        this.BP = 100L;
        this.BQ = null;
        this.BR = 0;
        this.BS = null;
        this.BT = null;
        this.BU = null;
        this.BV = null;
        this.BW = null;
        this.BX = 0;
        this.BY = new com.baidu.adp.widget.ListView.g(this);
        this.BZ = new com.baidu.adp.widget.ListView.i(this);
        this.preLoadRunnable = new j(this);
        this.mLayoutHasInit = false;
        this.Ca = false;
        this.Cb = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.Cc = null;
        this.Cd = new k(this);
        this.Ce = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.BG = null;
        this.BH = null;
        this.BI = null;
        this.BJ = null;
        this.BK = null;
        this.BL = null;
        this.BM = null;
        this.BN = null;
        this.BO = null;
        this.BP = 100L;
        this.BQ = null;
        this.BR = 0;
        this.BS = null;
        this.BT = null;
        this.BU = null;
        this.BV = null;
        this.BW = null;
        this.BX = 0;
        this.BY = new com.baidu.adp.widget.ListView.g(this);
        this.BZ = new com.baidu.adp.widget.ListView.i(this);
        this.preLoadRunnable = new j(this);
        this.mLayoutHasInit = false;
        this.Ca = false;
        this.Cb = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.Cc = null;
        this.Cd = new k(this);
        this.Ce = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.BG = null;
        this.BH = null;
        this.BI = null;
        this.BJ = null;
        this.BK = null;
        this.BL = null;
        this.BM = null;
        this.BN = null;
        this.BO = null;
        this.BP = 100L;
        this.BQ = null;
        this.BR = 0;
        this.BS = null;
        this.BT = null;
        this.BU = null;
        this.BV = null;
        this.BW = null;
        this.BX = 0;
        this.BY = new com.baidu.adp.widget.ListView.g(this);
        this.BZ = new com.baidu.adp.widget.ListView.i(this);
        this.preLoadRunnable = new j(this);
        this.mLayoutHasInit = false;
        this.Ca = false;
        this.Cb = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.Cc = null;
        this.Cd = new k(this);
        this.Ce = null;
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

    public void kt() {
        removeCallbacks(this.BZ);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.BG = new com.baidu.adp.widget.ListView.e(getContext());
        this.BG.a(new l(this));
        super.setOnItemClickListener(new m(this));
        super.setOnScrollListener(new n(this));
    }

    public void setOnScrollToPullListener(g gVar) {
        this.BO = gVar;
    }

    public void setOnSrollToTopListener(h hVar) {
        this.BQ = hVar;
    }

    public void setOnSrollToBottomListener(e eVar) {
        this.BS = eVar;
    }

    public void setExOnSrollToBottomListener(f fVar) {
        this.BT = fVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.BI = onItemLongClickListener;
        super.setOnItemLongClickListener(new o(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.BJ = onItemSelectedListener;
        super.setOnItemSelectedListener(new p(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.BM = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.BH = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.BG;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.BG instanceof com.baidu.adp.widget.ListView.e) {
            return this.BG.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.BG.a(listAdapter);
        super.setAdapter((ListAdapter) this.BG);
    }

    public void setOnHeaderClickListener(b bVar) {
        this.BK = bVar;
    }

    public void setOnFooterClickListener(a aVar) {
        this.BL = aVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.BG.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.BG.f(view, getHeaderIndex());
    }

    public void f(View view, int i2) {
        this.BG.f(view, i2);
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.BG.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.BG.getFooterViewsCount();
    }

    public void s(View view) {
        this.BG.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.BG.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.BG.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.BG.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.BG.removeFooter(view);
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
        if (this.BW != null) {
            removeHeaderView(this.BW);
            this.BW = null;
        }
        if (view != null) {
            addHeaderView(view, null, false);
            this.BW = view;
        }
    }

    public void setPrePage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.BU != null) {
            removeHeaderView(this.BU.getView());
            this.BU = null;
        }
        if (cVar != null) {
            addHeaderView(cVar.getView());
            this.BU = cVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i2, int i3) {
        super.setSelectionFromTop(i2, i3);
    }

    public void setNextPage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.BV != null) {
            removeFooterView(this.BV.getView());
            this.BV = null;
        }
        if (cVar != null) {
            this.BG.b(cVar.getView(), null, true, 0);
            this.BV = cVar;
        }
    }

    private int getHeaderIndex() {
        if (this.BU != null) {
            return this.BG.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.BY);
            getHandler().removeCallbacks(this.Cd);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.Cb = z;
    }

    public void setOnkbdStateListener(c cVar) {
        this.Cc = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i2, i3, i4, i5);
            if (!this.mLayoutHasInit) {
                this.mLayoutHasInit = true;
                this.mMaxHeight = i5;
                if (this.Cc != null) {
                    this.Cc.aL(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i5 ? i5 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i5 && i5 != this.mPreHeight) {
                this.Ca = true;
                if (this.Cc != null) {
                    this.Cc.aL(-3);
                }
                if (this.Cb && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.Cd, 1L);
                }
            }
            if (this.mLayoutHasInit && this.Ca && this.mMaxHeight == i5) {
                this.Ca = false;
                if (this.Cc != null) {
                    this.Cc.aL(-2);
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
        if (this.Ce != null) {
            removeHeaderView(this.Ce.kz().getView());
        }
        this.Ce = null;
        if (dVar != null) {
            this.Ce = new i(this, dVar);
            this.Ce.setOnScrollToPullListener(this.BO);
        }
    }

    public void ku() {
        if (this.Ce != null) {
            if (this.Ce.kz() != null) {
                this.Ce.Ch.kn();
            }
            this.Ce.kA();
        }
    }

    public void l(long j) {
        if (this.Ce != null && this.Ce.kz() != null) {
            this.Ce.Ch.kn();
        }
        com.baidu.adp.lib.h.h.eG().postDelayed(new com.baidu.adp.widget.ListView.h(this), j);
    }

    public void kv() {
        if (this.Ce != null) {
            setSelection(0);
            this.Ce.W(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Ce != null) {
            this.Ce.a(motionEvent, this.BX);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Ce != null) {
            this.Ce.b(motionEvent, this.BX);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public boolean kw() {
        return this.Ce == null || this.Ce.mState == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static float Cg = 3.0f;
        private com.baidu.adp.widget.ListView.d Ch;
        private BdListView Ck;
        private boolean Ci = false;
        private int Cj = 0;
        protected int mState = 3;
        private Boolean Cl = false;
        private g BO = null;
        private int Cm = 800;

        public i(BdListView bdListView, com.baidu.adp.widget.ListView.d dVar) {
            this.Ch = null;
            this.Ck = null;
            if (dVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView == null) {
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            this.Ch = dVar;
            this.Ck = bdListView;
            View view = this.Ch.getView();
            view.setPadding(0, -this.Ch.kp(), 0, 0);
            view.invalidate();
            this.Ck.s(view);
        }

        public com.baidu.adp.widget.ListView.d kz() {
            return this.Ch;
        }

        public void done() {
            this.mState = 3;
            this.Ch.setPadding(0, -this.Ch.kp(), 0, 0);
            this.Ch.S(true);
            if (this.BO != null) {
                this.BO.V(false);
            }
        }

        public void W(boolean z) {
            this.mState = 2;
            this.Ch.setPadding(0, 0, 0, 0);
            this.Ch.km();
            this.Ch.T(z);
        }

        public void setOnScrollToPullListener(g gVar) {
            this.BO = gVar;
        }

        public void a(MotionEvent motionEvent, int i) {
            if (motionEvent.getAction() == 0 && kz().ko()) {
                this.Ci = false;
                this.Cl = false;
                if (i == 0 && !this.Ci && this.Ck.getChildAt(0) != null && this.Ck.getChildAt(0).getTop() >= 0) {
                    this.Ci = true;
                    this.Cj = (int) motionEvent.getY();
                }
            }
        }

        public void b(MotionEvent motionEvent, int i) {
            if (kz().ko()) {
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        if (this.mState != 2) {
                            if (this.mState == 1) {
                                this.mState = 3;
                                this.Ch.setPadding(0, -this.Ch.kp(), 0, 0);
                                this.Ch.S(false);
                                if (this.BO != null) {
                                    this.BO.V(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 0) {
                                W(false);
                                if (this.BO != null) {
                                    this.BO.V(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 3 && this.BO != null) {
                                this.BO.V(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case 2:
                        int y = (int) motionEvent.getY();
                        if (!this.Ci && i == 0 && this.Ck.getChildAt(0) != null && this.Ck.getChildAt(0).getTop() >= 0) {
                            this.Ci = true;
                            this.Cj = y;
                        }
                        if (this.mState != 2 && this.Ci) {
                            if (this.mState == 0) {
                                this.Ck.setSelection(0);
                                if (((int) ((y - this.Cj) / Cg)) < this.Ch.kp() && y - this.Cj > 0) {
                                    this.mState = 1;
                                    this.Ch.R(this.Cl.booleanValue());
                                    this.Cl = false;
                                    if (this.BO != null) {
                                        this.BO.V(true);
                                    }
                                } else if (y - this.Cj <= 0) {
                                    this.mState = 3;
                                    this.Ch.setPadding(0, -this.Ch.kp(), 0, 0);
                                    this.Ch.S(false);
                                    if (this.BO != null) {
                                        this.BO.V(true);
                                    }
                                }
                            } else if (this.mState == 1) {
                                this.Ck.setSelection(0);
                                if (((int) ((y - this.Cj) / Cg)) >= this.Ch.kp()) {
                                    this.mState = 0;
                                    this.Cl = true;
                                    this.Ch.kl();
                                    if (this.BO != null) {
                                        this.BO.V(true);
                                    }
                                } else if (y - this.Cj <= 0) {
                                    this.mState = 3;
                                    this.Ch.setPadding(0, -this.Ch.kp(), 0, 0);
                                    this.Ch.S(false);
                                    if (this.BO != null) {
                                        this.BO.V(true);
                                    }
                                }
                            } else if (this.mState == 3) {
                                if (y - this.Cj > 0) {
                                    this.mState = 1;
                                    this.Ch.R(this.Cl.booleanValue());
                                    this.Cl = false;
                                    if (this.BO != null) {
                                        this.BO.V(true);
                                    }
                                } else if (this.BO != null) {
                                    this.BO.V(false);
                                }
                            }
                            if (this.mState == 1 || this.mState == 0) {
                                this.Ch.setPadding(0, ((int) ((y - this.Cj) / Cg)) - this.Ch.kp(), 0, 0);
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
        public void kA() {
            View view;
            com.baidu.adp.widget.ListView.d kz = kz();
            if (kz != null && (view = kz.getView()) != null) {
                r rVar = new r(view.getContext(), 0, -kz.kp(), this.Cm);
                rVar.a(new q(this));
                rVar.t(view);
            }
        }
    }
}
