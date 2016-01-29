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
    private long IA;
    private h IB;
    private int IC;
    private e IE;
    private f IG;
    private com.baidu.adp.widget.ListView.c IH;
    private com.baidu.adp.widget.ListView.c II;
    private View IJ;
    private int IK;
    private Runnable IL;
    private Runnable IM;
    private boolean IN;
    private boolean IO;
    private c IP;
    private Runnable IQ;
    private i IR;
    private com.baidu.adp.widget.ListView.e Ir;
    private AdapterView.OnItemClickListener Is;
    private AdapterView.OnItemLongClickListener It;
    private AdapterView.OnItemSelectedListener Iu;
    private b Iv;
    private a Iw;
    private AbsListView.OnScrollListener Ix;
    private d Iy;
    private g Iz;
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
        void aH(int i);
    }

    /* loaded from: classes.dex */
    public interface d {
        void i(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface e {
        void nv();
    }

    /* loaded from: classes.dex */
    public interface f {
        void s(BdListView bdListView);
    }

    /* loaded from: classes.dex */
    public interface g {
        void S(boolean z);
    }

    /* loaded from: classes.dex */
    public interface h {
        void nw();
    }

    public BdListView(Context context) {
        super(context);
        this.Ir = null;
        this.Is = null;
        this.It = null;
        this.Iu = null;
        this.Iv = null;
        this.Iw = null;
        this.Ix = null;
        this.Iy = null;
        this.Iz = null;
        this.IA = 100L;
        this.IB = null;
        this.IC = 0;
        this.IE = null;
        this.IG = null;
        this.IH = null;
        this.II = null;
        this.IJ = null;
        this.IK = 0;
        this.IL = new com.baidu.adp.widget.ListView.g(this);
        this.IM = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.IN = false;
        this.IO = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.IP = null;
        this.IQ = new j(this);
        this.IR = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ir = null;
        this.Is = null;
        this.It = null;
        this.Iu = null;
        this.Iv = null;
        this.Iw = null;
        this.Ix = null;
        this.Iy = null;
        this.Iz = null;
        this.IA = 100L;
        this.IB = null;
        this.IC = 0;
        this.IE = null;
        this.IG = null;
        this.IH = null;
        this.II = null;
        this.IJ = null;
        this.IK = 0;
        this.IL = new com.baidu.adp.widget.ListView.g(this);
        this.IM = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.IN = false;
        this.IO = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.IP = null;
        this.IQ = new j(this);
        this.IR = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Ir = null;
        this.Is = null;
        this.It = null;
        this.Iu = null;
        this.Iv = null;
        this.Iw = null;
        this.Ix = null;
        this.Iy = null;
        this.Iz = null;
        this.IA = 100L;
        this.IB = null;
        this.IC = 0;
        this.IE = null;
        this.IG = null;
        this.IH = null;
        this.II = null;
        this.IJ = null;
        this.IK = 0;
        this.IL = new com.baidu.adp.widget.ListView.g(this);
        this.IM = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.IN = false;
        this.IO = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.IP = null;
        this.IQ = new j(this);
        this.IR = null;
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

    public void nq() {
        removeCallbacks(this.IM);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.Ir = new com.baidu.adp.widget.ListView.e(getContext());
        this.Ir.a(new k(this));
        super.setOnItemClickListener(new l(this));
        super.setOnScrollListener(new m(this));
    }

    public void setOnScrollToPullListener(g gVar) {
        this.Iz = gVar;
    }

    public void setOnSrollToTopListener(h hVar) {
        this.IB = hVar;
    }

    public void setOnSrollToBottomListener(e eVar) {
        this.IE = eVar;
    }

    public void setExOnSrollToBottomListener(f fVar) {
        this.IG = fVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.It = onItemLongClickListener;
        super.setOnItemLongClickListener(new n(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.Iu = onItemSelectedListener;
        super.setOnItemSelectedListener(new o(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Ix = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Is = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.Ir;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.Ir instanceof com.baidu.adp.widget.ListView.e) {
            return this.Ir.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.Ir.a(listAdapter);
        super.setAdapter((ListAdapter) this.Ir);
    }

    public void setOnHeaderClickListener(b bVar) {
        this.Iv = bVar;
    }

    public void setOnFooterClickListener(a aVar) {
        this.Iw = aVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.Ir.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.Ir.f(view, getHeaderIndex());
    }

    public void f(View view, int i2) {
        this.Ir.f(view, i2);
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.Ir.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.Ir.getFooterViewsCount();
    }

    public void s(View view) {
        this.Ir.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.Ir.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.Ir.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.Ir.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.Ir.removeFooter(view);
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
        if (this.IJ != null) {
            removeHeaderView(this.IJ);
            this.IJ = null;
        }
        if (view != null) {
            addHeaderView(view, null, false);
            this.IJ = view;
        }
    }

    public void setPrePage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.IH != null) {
            removeHeaderView(this.IH.getView());
            this.IH = null;
        }
        if (cVar != null) {
            addHeaderView(cVar.getView());
            this.IH = cVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i2, int i3) {
        super.setSelectionFromTop(i2, i3);
    }

    public void setNextPage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.II != null) {
            removeFooterView(this.II.getView());
            this.II = null;
        }
        if (cVar != null) {
            this.Ir.b(cVar.getView(), null, true, 0);
            this.II = cVar;
        }
    }

    private int getHeaderIndex() {
        if (this.IH != null) {
            return this.Ir.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.IL);
            getHandler().removeCallbacks(this.IQ);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.IO = z;
    }

    public void setOnkbdStateListener(c cVar) {
        this.IP = cVar;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i2, i3, i4, i5);
            if (!this.mLayoutHasInit) {
                this.mLayoutHasInit = true;
                this.mMaxHeight = i5;
                if (this.IP != null) {
                    this.IP.aH(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i5 ? i5 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i5 && i5 != this.mPreHeight) {
                this.IN = true;
                if (this.IP != null) {
                    this.IP.aH(-3);
                }
                if (this.IO && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.IQ, 1L);
                }
            }
            if (this.mLayoutHasInit && this.IN && this.mMaxHeight == i5) {
                this.IN = false;
                if (this.IP != null) {
                    this.IP.aH(-2);
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
        if (this.IR != null) {
            removeHeaderView(this.IR.nx().getView());
        }
        this.IR = null;
        if (dVar != null) {
            this.IR = new i(this, dVar);
            this.IR.setOnScrollToPullListener(this.Iz);
        }
    }

    public void nr() {
        if (this.IR == null) {
            return;
        }
        this.IR.ny();
    }

    public void ns() {
        if (this.IR != null) {
            setSelection(0);
            this.IR.T(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.IR != null) {
            this.IR.a(motionEvent, this.IK);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.IR != null) {
            this.IR.b(motionEvent, this.IK);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public boolean nt() {
        return this.IR == null || this.IR.mState == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static float IT = 3.0f;
        private com.baidu.adp.widget.ListView.d IU;
        private BdListView IY;
        private boolean IW = false;
        private int IX = 0;
        protected int mState = 3;
        private Boolean IZ = false;
        private g Iz = null;
        private int Ja = 800;

        public i(BdListView bdListView, com.baidu.adp.widget.ListView.d dVar) {
            this.IU = null;
            this.IY = null;
            if (dVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView == null) {
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            this.IU = dVar;
            this.IY = bdListView;
            View view = this.IU.getView();
            view.setPadding(0, -this.IU.nm(), 0, 0);
            view.invalidate();
            this.IY.s(view);
        }

        public com.baidu.adp.widget.ListView.d nx() {
            return this.IU;
        }

        public void done() {
            this.mState = 3;
            this.IU.setPadding(0, -this.IU.nm(), 0, 0);
            this.IU.P(true);
            if (this.Iz != null) {
                this.Iz.S(false);
            }
        }

        public void T(boolean z) {
            this.mState = 2;
            this.IU.setPadding(0, 0, 0, 0);
            this.IU.nk();
            this.IU.Q(z);
        }

        public void setOnScrollToPullListener(g gVar) {
            this.Iz = gVar;
        }

        public void a(MotionEvent motionEvent, int i) {
            if (motionEvent.getAction() == 0 && nx().nl()) {
                this.IW = false;
                this.IZ = false;
                if (i == 0 && !this.IW) {
                    this.IW = true;
                    this.IX = (int) motionEvent.getY();
                }
            }
        }

        public void b(MotionEvent motionEvent, int i) {
            if (nx().nl()) {
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        if (this.mState != 2) {
                            if (this.mState == 1) {
                                this.mState = 3;
                                this.IU.setPadding(0, -this.IU.nm(), 0, 0);
                                this.IU.P(false);
                                if (this.Iz != null) {
                                    this.Iz.S(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 0) {
                                T(false);
                                if (this.Iz != null) {
                                    this.Iz.S(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 3 && this.Iz != null) {
                                this.Iz.S(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case 2:
                        int y = (int) motionEvent.getY();
                        if (!this.IW && i == 0) {
                            this.IW = true;
                            this.IX = y;
                        }
                        if (this.mState != 2 && this.IW) {
                            if (this.mState == 0) {
                                this.IY.setSelection(0);
                                if (((int) ((y - this.IX) / IT)) < this.IU.nm() && y - this.IX > 0) {
                                    this.mState = 1;
                                    this.IU.O(this.IZ.booleanValue());
                                    this.IZ = false;
                                    if (this.Iz != null) {
                                        this.Iz.S(true);
                                    }
                                } else if (y - this.IX <= 0) {
                                    this.mState = 3;
                                    this.IU.setPadding(0, -this.IU.nm(), 0, 0);
                                    this.IU.P(false);
                                    if (this.Iz != null) {
                                        this.Iz.S(true);
                                    }
                                }
                            } else if (this.mState == 1) {
                                this.IY.setSelection(0);
                                if (((int) ((y - this.IX) / IT)) >= this.IU.nm()) {
                                    this.mState = 0;
                                    this.IZ = true;
                                    this.IU.nj();
                                    if (this.Iz != null) {
                                        this.Iz.S(true);
                                    }
                                } else if (y - this.IX <= 0) {
                                    this.mState = 3;
                                    this.IU.setPadding(0, -this.IU.nm(), 0, 0);
                                    this.IU.P(false);
                                    if (this.Iz != null) {
                                        this.Iz.S(true);
                                    }
                                }
                            } else if (this.mState == 3) {
                                if (y - this.IX > 0) {
                                    this.mState = 1;
                                    this.IU.O(this.IZ.booleanValue());
                                    this.IZ = false;
                                    if (this.Iz != null) {
                                        this.Iz.S(true);
                                    }
                                } else if (this.Iz != null) {
                                    this.Iz.S(false);
                                }
                            }
                            if (this.mState == 1 || this.mState == 0) {
                                this.IU.setPadding(0, ((int) ((y - this.IX) / IT)) - this.IU.nm(), 0, 0);
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
                q qVar = new q(view.getContext(), 0, -nx.nm(), this.Ja);
                qVar.a(new p(this));
                qVar.t(view);
            }
        }
    }
}
