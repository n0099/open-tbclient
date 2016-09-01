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
    private com.baidu.adp.widget.ListView.e BF;
    private AdapterView.OnItemClickListener BG;
    private AdapterView.OnItemLongClickListener BH;
    private AdapterView.OnItemSelectedListener BI;
    private b BJ;
    private a BK;
    private AbsListView.OnScrollListener BL;
    private d BM;
    private g BN;
    private long BO;
    private h BP;
    private int BQ;
    private e BR;
    private f BS;
    private com.baidu.adp.widget.ListView.c BT;
    private com.baidu.adp.widget.ListView.c BU;
    private View BV;
    private int BW;
    private Runnable BX;
    private Runnable BY;
    private boolean BZ;
    private boolean Ca;
    private c Cb;
    private Runnable Cc;
    private i Cd;
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
        void aK(int i);
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
        this.BF = null;
        this.BG = null;
        this.BH = null;
        this.BI = null;
        this.BJ = null;
        this.BK = null;
        this.BL = null;
        this.BM = null;
        this.BN = null;
        this.BO = 100L;
        this.BP = null;
        this.BQ = 0;
        this.BR = null;
        this.BS = null;
        this.BT = null;
        this.BU = null;
        this.BV = null;
        this.BW = 0;
        this.BX = new com.baidu.adp.widget.ListView.g(this);
        this.BY = new com.baidu.adp.widget.ListView.i(this);
        this.preLoadRunnable = new j(this);
        this.mLayoutHasInit = false;
        this.BZ = false;
        this.Ca = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.Cb = null;
        this.Cc = new k(this);
        this.Cd = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.BF = null;
        this.BG = null;
        this.BH = null;
        this.BI = null;
        this.BJ = null;
        this.BK = null;
        this.BL = null;
        this.BM = null;
        this.BN = null;
        this.BO = 100L;
        this.BP = null;
        this.BQ = 0;
        this.BR = null;
        this.BS = null;
        this.BT = null;
        this.BU = null;
        this.BV = null;
        this.BW = 0;
        this.BX = new com.baidu.adp.widget.ListView.g(this);
        this.BY = new com.baidu.adp.widget.ListView.i(this);
        this.preLoadRunnable = new j(this);
        this.mLayoutHasInit = false;
        this.BZ = false;
        this.Ca = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.Cb = null;
        this.Cc = new k(this);
        this.Cd = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.BF = null;
        this.BG = null;
        this.BH = null;
        this.BI = null;
        this.BJ = null;
        this.BK = null;
        this.BL = null;
        this.BM = null;
        this.BN = null;
        this.BO = 100L;
        this.BP = null;
        this.BQ = 0;
        this.BR = null;
        this.BS = null;
        this.BT = null;
        this.BU = null;
        this.BV = null;
        this.BW = 0;
        this.BX = new com.baidu.adp.widget.ListView.g(this);
        this.BY = new com.baidu.adp.widget.ListView.i(this);
        this.preLoadRunnable = new j(this);
        this.mLayoutHasInit = false;
        this.BZ = false;
        this.Ca = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.Cb = null;
        this.Cc = new k(this);
        this.Cd = null;
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
        removeCallbacks(this.BY);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.BF = new com.baidu.adp.widget.ListView.e(getContext());
        this.BF.a(new l(this));
        super.setOnItemClickListener(new m(this));
        super.setOnScrollListener(new n(this));
    }

    public void setOnScrollToPullListener(g gVar) {
        this.BN = gVar;
    }

    public void setOnSrollToTopListener(h hVar) {
        this.BP = hVar;
    }

    public void setOnSrollToBottomListener(e eVar) {
        this.BR = eVar;
    }

    public void setExOnSrollToBottomListener(f fVar) {
        this.BS = fVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.BH = onItemLongClickListener;
        super.setOnItemLongClickListener(new o(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.BI = onItemSelectedListener;
        super.setOnItemSelectedListener(new p(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.BL = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.BG = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.BF;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.BF instanceof com.baidu.adp.widget.ListView.e) {
            return this.BF.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.BF.a(listAdapter);
        super.setAdapter((ListAdapter) this.BF);
    }

    public void setOnHeaderClickListener(b bVar) {
        this.BJ = bVar;
    }

    public void setOnFooterClickListener(a aVar) {
        this.BK = aVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.BF.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.BF.f(view, getHeaderIndex());
    }

    public void f(View view, int i2) {
        this.BF.f(view, i2);
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.BF.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.BF.getFooterViewsCount();
    }

    public void s(View view) {
        this.BF.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.BF.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.BF.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.BF.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.BF.removeFooter(view);
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
        if (this.BV != null) {
            removeHeaderView(this.BV);
            this.BV = null;
        }
        if (view != null) {
            addHeaderView(view, null, false);
            this.BV = view;
        }
    }

    public void setPrePage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.BT != null) {
            removeHeaderView(this.BT.getView());
            this.BT = null;
        }
        if (cVar != null) {
            addHeaderView(cVar.getView());
            this.BT = cVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i2, int i3) {
        super.setSelectionFromTop(i2, i3);
    }

    public void setNextPage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.BU != null) {
            removeFooterView(this.BU.getView());
            this.BU = null;
        }
        if (cVar != null) {
            this.BF.b(cVar.getView(), null, true, 0);
            this.BU = cVar;
        }
    }

    private int getHeaderIndex() {
        if (this.BT != null) {
            return this.BF.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.BX);
            getHandler().removeCallbacks(this.Cc);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.Ca = z;
    }

    public void setOnkbdStateListener(c cVar) {
        this.Cb = cVar;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i2, i3, i4, i5);
            if (!this.mLayoutHasInit) {
                this.mLayoutHasInit = true;
                this.mMaxHeight = i5;
                if (this.Cb != null) {
                    this.Cb.aK(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i5 ? i5 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i5 && i5 != this.mPreHeight) {
                this.BZ = true;
                if (this.Cb != null) {
                    this.Cb.aK(-3);
                }
                if (this.Ca && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.Cc, 1L);
                }
            }
            if (this.mLayoutHasInit && this.BZ && this.mMaxHeight == i5) {
                this.BZ = false;
                if (this.Cb != null) {
                    this.Cb.aK(-2);
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
        if (this.Cd != null) {
            removeHeaderView(this.Cd.kz().getView());
        }
        this.Cd = null;
        if (dVar != null) {
            this.Cd = new i(this, dVar);
            this.Cd.setOnScrollToPullListener(this.BN);
        }
    }

    public void ku() {
        if (this.Cd != null) {
            if (this.Cd.kz() != null) {
                this.Cd.Cg.kn();
            }
            this.Cd.kA();
        }
    }

    public void l(long j) {
        if (this.Cd != null && this.Cd.kz() != null) {
            this.Cd.Cg.kn();
        }
        com.baidu.adp.lib.h.h.eG().postDelayed(new com.baidu.adp.widget.ListView.h(this), j);
    }

    public void kv() {
        if (this.Cd != null) {
            setSelection(0);
            this.Cd.W(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Cd != null) {
            this.Cd.a(motionEvent, this.BW);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Cd != null) {
            this.Cd.b(motionEvent, this.BW);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public boolean kw() {
        return this.Cd == null || this.Cd.mState == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static float Cf = 3.0f;
        private com.baidu.adp.widget.ListView.d Cg;
        private BdListView Cj;
        private boolean Ch = false;
        private int Ci = 0;
        protected int mState = 3;
        private Boolean Ck = false;
        private g BN = null;
        private int Cl = 800;

        public i(BdListView bdListView, com.baidu.adp.widget.ListView.d dVar) {
            this.Cg = null;
            this.Cj = null;
            if (dVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView == null) {
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            this.Cg = dVar;
            this.Cj = bdListView;
            View view = this.Cg.getView();
            view.setPadding(0, -this.Cg.kp(), 0, 0);
            view.invalidate();
            this.Cj.s(view);
        }

        public com.baidu.adp.widget.ListView.d kz() {
            return this.Cg;
        }

        public void done() {
            this.mState = 3;
            this.Cg.setPadding(0, -this.Cg.kp(), 0, 0);
            this.Cg.S(true);
            if (this.BN != null) {
                this.BN.V(false);
            }
        }

        public void W(boolean z) {
            this.mState = 2;
            this.Cg.setPadding(0, 0, 0, 0);
            this.Cg.km();
            this.Cg.T(z);
        }

        public void setOnScrollToPullListener(g gVar) {
            this.BN = gVar;
        }

        public void a(MotionEvent motionEvent, int i) {
            if (motionEvent.getAction() == 0 && kz().ko()) {
                this.Ch = false;
                this.Ck = false;
                if (i == 0 && !this.Ch && this.Cj.getChildAt(0) != null && this.Cj.getChildAt(0).getTop() >= 0) {
                    this.Ch = true;
                    this.Ci = (int) motionEvent.getY();
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
                                this.Cg.setPadding(0, -this.Cg.kp(), 0, 0);
                                this.Cg.S(false);
                                if (this.BN != null) {
                                    this.BN.V(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 0) {
                                W(false);
                                if (this.BN != null) {
                                    this.BN.V(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 3 && this.BN != null) {
                                this.BN.V(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case 2:
                        int y = (int) motionEvent.getY();
                        if (!this.Ch && i == 0 && this.Cj.getChildAt(0) != null && this.Cj.getChildAt(0).getTop() >= 0) {
                            this.Ch = true;
                            this.Ci = y;
                        }
                        if (this.mState != 2 && this.Ch) {
                            if (this.mState == 0) {
                                this.Cj.setSelection(0);
                                if (((int) ((y - this.Ci) / Cf)) < this.Cg.kp() && y - this.Ci > 0) {
                                    this.mState = 1;
                                    this.Cg.R(this.Ck.booleanValue());
                                    this.Ck = false;
                                    if (this.BN != null) {
                                        this.BN.V(true);
                                    }
                                } else if (y - this.Ci <= 0) {
                                    this.mState = 3;
                                    this.Cg.setPadding(0, -this.Cg.kp(), 0, 0);
                                    this.Cg.S(false);
                                    if (this.BN != null) {
                                        this.BN.V(true);
                                    }
                                }
                            } else if (this.mState == 1) {
                                this.Cj.setSelection(0);
                                if (((int) ((y - this.Ci) / Cf)) >= this.Cg.kp()) {
                                    this.mState = 0;
                                    this.Ck = true;
                                    this.Cg.kl();
                                    if (this.BN != null) {
                                        this.BN.V(true);
                                    }
                                } else if (y - this.Ci <= 0) {
                                    this.mState = 3;
                                    this.Cg.setPadding(0, -this.Cg.kp(), 0, 0);
                                    this.Cg.S(false);
                                    if (this.BN != null) {
                                        this.BN.V(true);
                                    }
                                }
                            } else if (this.mState == 3) {
                                if (y - this.Ci > 0) {
                                    this.mState = 1;
                                    this.Cg.R(this.Ck.booleanValue());
                                    this.Ck = false;
                                    if (this.BN != null) {
                                        this.BN.V(true);
                                    }
                                } else if (this.BN != null) {
                                    this.BN.V(false);
                                }
                            }
                            if (this.mState == 1 || this.mState == 0) {
                                this.Cg.setPadding(0, ((int) ((y - this.Ci) / Cf)) - this.Cg.kp(), 0, 0);
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
                r rVar = new r(view.getContext(), 0, -kz.kp(), this.Cl);
                rVar.a(new q(this));
                rVar.t(view);
            }
        }
    }
}
