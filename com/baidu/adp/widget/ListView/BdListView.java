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
    private c IA;
    private Runnable IB;
    private i IC;
    private com.baidu.adp.widget.ListView.e Ie;
    private AdapterView.OnItemClickListener If;
    private AdapterView.OnItemLongClickListener Ig;
    private AdapterView.OnItemSelectedListener Ih;
    private b Ii;
    private a Ij;
    private AbsListView.OnScrollListener Ik;
    private d Il;
    private g Im;
    private long In;
    private h Io;
    private int Ip;
    private e Iq;
    private f Ir;
    private com.baidu.adp.widget.ListView.c Is;
    private com.baidu.adp.widget.ListView.c It;
    private View Iu;
    private int Iv;
    private Runnable Iw;
    private Runnable Ix;
    private boolean Iy;
    private boolean Iz;
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
        void h(int i, int i2);
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
        void S(boolean z);
    }

    /* loaded from: classes.dex */
    public interface h {
        void onScrollToTop();
    }

    public BdListView(Context context) {
        super(context);
        this.Ie = null;
        this.If = null;
        this.Ig = null;
        this.Ih = null;
        this.Ii = null;
        this.Ij = null;
        this.Ik = null;
        this.Il = null;
        this.Im = null;
        this.In = 100L;
        this.Io = null;
        this.Ip = 0;
        this.Iq = null;
        this.Ir = null;
        this.Is = null;
        this.It = null;
        this.Iu = null;
        this.Iv = 0;
        this.Iw = new com.baidu.adp.widget.ListView.g(this);
        this.Ix = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.Iy = false;
        this.Iz = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.IA = null;
        this.IB = new j(this);
        this.IC = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ie = null;
        this.If = null;
        this.Ig = null;
        this.Ih = null;
        this.Ii = null;
        this.Ij = null;
        this.Ik = null;
        this.Il = null;
        this.Im = null;
        this.In = 100L;
        this.Io = null;
        this.Ip = 0;
        this.Iq = null;
        this.Ir = null;
        this.Is = null;
        this.It = null;
        this.Iu = null;
        this.Iv = 0;
        this.Iw = new com.baidu.adp.widget.ListView.g(this);
        this.Ix = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.Iy = false;
        this.Iz = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.IA = null;
        this.IB = new j(this);
        this.IC = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Ie = null;
        this.If = null;
        this.Ig = null;
        this.Ih = null;
        this.Ii = null;
        this.Ij = null;
        this.Ik = null;
        this.Il = null;
        this.Im = null;
        this.In = 100L;
        this.Io = null;
        this.Ip = 0;
        this.Iq = null;
        this.Ir = null;
        this.Is = null;
        this.It = null;
        this.Iu = null;
        this.Iv = 0;
        this.Iw = new com.baidu.adp.widget.ListView.g(this);
        this.Ix = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.Iy = false;
        this.Iz = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.IA = null;
        this.IB = new j(this);
        this.IC = null;
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

    public void na() {
        removeCallbacks(this.Ix);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.Ie = new com.baidu.adp.widget.ListView.e(getContext());
        this.Ie.a(new k(this));
        super.setOnItemClickListener(new l(this));
        super.setOnScrollListener(new m(this));
    }

    public void setOnScrollToPullListener(g gVar) {
        this.Im = gVar;
    }

    public void setOnSrollToTopListener(h hVar) {
        this.Io = hVar;
    }

    public void setOnSrollToBottomListener(e eVar) {
        this.Iq = eVar;
    }

    public void setExOnSrollToBottomListener(f fVar) {
        this.Ir = fVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.Ig = onItemLongClickListener;
        super.setOnItemLongClickListener(new n(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.Ih = onItemSelectedListener;
        super.setOnItemSelectedListener(new o(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Ik = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.If = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.Ie;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.Ie instanceof com.baidu.adp.widget.ListView.e) {
            return this.Ie.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.Ie.a(listAdapter);
        super.setAdapter((ListAdapter) this.Ie);
    }

    public void setOnHeaderClickListener(b bVar) {
        this.Ii = bVar;
    }

    public void setOnFooterClickListener(a aVar) {
        this.Ij = aVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.Ie.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.Ie.d(view, getHeaderIndex());
    }

    public void d(View view, int i2) {
        this.Ie.d(view, i2);
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.Ie.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.Ie.getFooterViewsCount();
    }

    public void g(View view) {
        this.Ie.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.Ie.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.Ie.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.Ie.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.Ie.removeFooter(view);
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
        if (this.Iu != null) {
            removeHeaderView(this.Iu);
            this.Iu = null;
        }
        if (view != null) {
            addHeaderView(view, null, false);
            this.Iu = view;
        }
    }

    public void setPrePage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.Is != null) {
            removeHeaderView(this.Is.getView());
            this.Is = null;
        }
        if (cVar != null) {
            addHeaderView(cVar.getView());
            this.Is = cVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i2, int i3) {
        super.setSelectionFromTop(i2, i3);
    }

    public void setNextPage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.It != null) {
            removeFooterView(this.It.getView());
            this.It = null;
        }
        if (cVar != null) {
            this.Ie.b(cVar.getView(), null, true, 0);
            this.It = cVar;
        }
    }

    private int getHeaderIndex() {
        if (this.Is != null) {
            return this.Ie.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.Iw);
            getHandler().removeCallbacks(this.IB);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.Iz = z;
    }

    public void setOnkbdStateListener(c cVar) {
        this.IA = cVar;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i2, i3, i4, i5);
            if (!this.mLayoutHasInit) {
                this.mLayoutHasInit = true;
                this.mMaxHeight = i5;
                if (this.IA != null) {
                    this.IA.onKeyBoardStateChange(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i5 ? i5 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i5 && i5 != this.mPreHeight) {
                this.Iy = true;
                if (this.IA != null) {
                    this.IA.onKeyBoardStateChange(-3);
                }
                if (this.Iz && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.IB, 1L);
                }
            }
            if (this.mLayoutHasInit && this.Iy && this.mMaxHeight == i5) {
                this.Iy = false;
                if (this.IA != null) {
                    this.IA.onKeyBoardStateChange(-2);
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
        if (this.IC != null) {
            removeHeaderView(this.IC.nd().getView());
        }
        this.IC = null;
        if (dVar != null) {
            this.IC = new i(this, dVar);
            this.IC.setOnScrollToPullListener(this.Im);
        }
    }

    public void completePullRefresh() {
        if (this.IC == null) {
            return;
        }
        this.IC.ne();
    }

    public void nb() {
        if (this.IC != null) {
            setSelection(0);
            this.IC.T(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.IC != null) {
            this.IC.a(motionEvent, this.Iv);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.IC != null) {
            this.IC.b(motionEvent, this.Iv);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public boolean nc() {
        return this.IC == null || this.IC.mState == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static float IF = 3.0f;
        private com.baidu.adp.widget.ListView.d IG;
        private BdListView mListView;
        private boolean IH = false;
        private int II = 0;
        protected int mState = 3;
        private Boolean IJ = false;
        private g Im = null;
        private int IK = 800;

        public i(BdListView bdListView, com.baidu.adp.widget.ListView.d dVar) {
            this.IG = null;
            this.mListView = null;
            if (dVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView == null) {
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            this.IG = dVar;
            this.mListView = bdListView;
            View view = this.IG.getView();
            view.setPadding(0, -this.IG.mW(), 0, 0);
            view.invalidate();
            this.mListView.g(view);
        }

        public com.baidu.adp.widget.ListView.d nd() {
            return this.IG;
        }

        public void done() {
            this.mState = 3;
            this.IG.setPadding(0, -this.IG.mW(), 0, 0);
            this.IG.P(true);
            if (this.Im != null) {
                this.Im.S(false);
            }
        }

        public void T(boolean z) {
            this.mState = 2;
            this.IG.setPadding(0, 0, 0, 0);
            this.IG.mV();
            this.IG.Q(z);
        }

        public void setOnScrollToPullListener(g gVar) {
            this.Im = gVar;
        }

        public void a(MotionEvent motionEvent, int i) {
            if (motionEvent.getAction() == 0 && nd().isEnable()) {
                this.IH = false;
                this.IJ = false;
                if (i == 0 && !this.IH) {
                    this.IH = true;
                    this.II = (int) motionEvent.getY();
                }
            }
        }

        public void b(MotionEvent motionEvent, int i) {
            if (nd().isEnable()) {
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        if (this.mState != 2) {
                            if (this.mState == 1) {
                                this.mState = 3;
                                this.IG.setPadding(0, -this.IG.mW(), 0, 0);
                                this.IG.P(false);
                                if (this.Im != null) {
                                    this.Im.S(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 0) {
                                T(false);
                                if (this.Im != null) {
                                    this.Im.S(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 3 && this.Im != null) {
                                this.Im.S(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case 2:
                        int y = (int) motionEvent.getY();
                        if (!this.IH && i == 0) {
                            this.IH = true;
                            this.II = y;
                        }
                        if (this.mState != 2 && this.IH) {
                            if (this.mState == 0) {
                                this.mListView.setSelection(0);
                                if (((int) ((y - this.II) / IF)) < this.IG.mW() && y - this.II > 0) {
                                    this.mState = 1;
                                    this.IG.O(this.IJ.booleanValue());
                                    this.IJ = false;
                                    if (this.Im != null) {
                                        this.Im.S(true);
                                    }
                                } else if (y - this.II <= 0) {
                                    this.mState = 3;
                                    this.IG.setPadding(0, -this.IG.mW(), 0, 0);
                                    this.IG.P(false);
                                    if (this.Im != null) {
                                        this.Im.S(true);
                                    }
                                }
                            } else if (this.mState == 1) {
                                this.mListView.setSelection(0);
                                if (((int) ((y - this.II) / IF)) >= this.IG.mW()) {
                                    this.mState = 0;
                                    this.IJ = true;
                                    this.IG.mU();
                                    if (this.Im != null) {
                                        this.Im.S(true);
                                    }
                                } else if (y - this.II <= 0) {
                                    this.mState = 3;
                                    this.IG.setPadding(0, -this.IG.mW(), 0, 0);
                                    this.IG.P(false);
                                    if (this.Im != null) {
                                        this.Im.S(true);
                                    }
                                }
                            } else if (this.mState == 3) {
                                if (y - this.II > 0) {
                                    this.mState = 1;
                                    this.IG.O(this.IJ.booleanValue());
                                    this.IJ = false;
                                    if (this.Im != null) {
                                        this.Im.S(true);
                                    }
                                } else if (this.Im != null) {
                                    this.Im.S(false);
                                }
                            }
                            if (this.mState == 1 || this.mState == 0) {
                                this.IG.setPadding(0, ((int) ((y - this.II) / IF)) - this.IG.mW(), 0, 0);
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
        public void ne() {
            View view;
            com.baidu.adp.widget.ListView.d nd = nd();
            if (nd != null && (view = nd.getView()) != null) {
                q qVar = new q(view.getContext(), 0, -nd.mW(), this.IK);
                qVar.a(new p(this));
                qVar.h(view);
            }
        }
    }
}
