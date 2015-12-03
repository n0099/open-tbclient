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
    private com.baidu.adp.widget.ListView.e HO;
    private AdapterView.OnItemClickListener HP;
    private AdapterView.OnItemLongClickListener HQ;
    private AdapterView.OnItemSelectedListener HR;
    private b HS;
    private a HT;
    private AbsListView.OnScrollListener HU;
    private d HV;
    private g HW;
    private long HX;
    private h HY;
    private int HZ;
    private e Ia;
    private f Ib;
    private com.baidu.adp.widget.ListView.c Ic;
    private com.baidu.adp.widget.ListView.c Id;
    private View Ie;
    private int If;
    private Runnable Ig;
    private Runnable Ih;
    private boolean Ii;
    private boolean Ij;
    private c Ik;
    private Runnable Il;
    private i Im;
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
        this.HO = null;
        this.HP = null;
        this.HQ = null;
        this.HR = null;
        this.HS = null;
        this.HT = null;
        this.HU = null;
        this.HV = null;
        this.HW = null;
        this.HX = 100L;
        this.HY = null;
        this.HZ = 0;
        this.Ia = null;
        this.Ib = null;
        this.Ic = null;
        this.Id = null;
        this.Ie = null;
        this.If = 0;
        this.Ig = new com.baidu.adp.widget.ListView.g(this);
        this.Ih = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.Ii = false;
        this.Ij = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.Ik = null;
        this.Il = new j(this);
        this.Im = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HO = null;
        this.HP = null;
        this.HQ = null;
        this.HR = null;
        this.HS = null;
        this.HT = null;
        this.HU = null;
        this.HV = null;
        this.HW = null;
        this.HX = 100L;
        this.HY = null;
        this.HZ = 0;
        this.Ia = null;
        this.Ib = null;
        this.Ic = null;
        this.Id = null;
        this.Ie = null;
        this.If = 0;
        this.Ig = new com.baidu.adp.widget.ListView.g(this);
        this.Ih = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.Ii = false;
        this.Ij = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.Ik = null;
        this.Il = new j(this);
        this.Im = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.HO = null;
        this.HP = null;
        this.HQ = null;
        this.HR = null;
        this.HS = null;
        this.HT = null;
        this.HU = null;
        this.HV = null;
        this.HW = null;
        this.HX = 100L;
        this.HY = null;
        this.HZ = 0;
        this.Ia = null;
        this.Ib = null;
        this.Ic = null;
        this.Id = null;
        this.Ie = null;
        this.If = 0;
        this.Ig = new com.baidu.adp.widget.ListView.g(this);
        this.Ih = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.Ii = false;
        this.Ij = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.Ik = null;
        this.Il = new j(this);
        this.Im = null;
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

    public void nC() {
        removeCallbacks(this.Ih);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.HO = new com.baidu.adp.widget.ListView.e(getContext());
        this.HO.a(new k(this));
        super.setOnItemClickListener(new l(this));
        super.setOnScrollListener(new m(this));
    }

    public void setOnScrollToPullListener(g gVar) {
        this.HW = gVar;
    }

    public void setOnSrollToTopListener(h hVar) {
        this.HY = hVar;
    }

    public void setOnSrollToBottomListener(e eVar) {
        this.Ia = eVar;
    }

    public void setExOnSrollToBottomListener(f fVar) {
        this.Ib = fVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.HQ = onItemLongClickListener;
        super.setOnItemLongClickListener(new n(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.HR = onItemSelectedListener;
        super.setOnItemSelectedListener(new o(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.HU = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.HP = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.HO;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.HO instanceof com.baidu.adp.widget.ListView.e) {
            return this.HO.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.HO.a(listAdapter);
        super.setAdapter((ListAdapter) this.HO);
    }

    public void setOnHeaderClickListener(b bVar) {
        this.HS = bVar;
    }

    public void setOnFooterClickListener(a aVar) {
        this.HT = aVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.HO.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.HO.d(view, getHeaderIndex());
    }

    public void d(View view, int i2) {
        this.HO.d(view, i2);
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.HO.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.HO.getFooterViewsCount();
    }

    public void g(View view) {
        this.HO.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.HO.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.HO.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.HO.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.HO.removeFooter(view);
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
        if (this.Ie != null) {
            removeHeaderView(this.Ie);
            this.Ie = null;
        }
        if (view != null) {
            addHeaderView(view, null, false);
            this.Ie = view;
        }
    }

    public void setPrePage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.Ic != null) {
            removeHeaderView(this.Ic.getView());
            this.Ic = null;
        }
        if (cVar != null) {
            addHeaderView(cVar.getView());
            this.Ic = cVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i2, int i3) {
        super.setSelectionFromTop(i2, i3);
    }

    public void setNextPage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.Id != null) {
            removeFooterView(this.Id.getView());
            this.Id = null;
        }
        if (cVar != null) {
            this.HO.b(cVar.getView(), null, true, 0);
            this.Id = cVar;
        }
    }

    private int getHeaderIndex() {
        if (this.Ic != null) {
            return this.HO.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.Ig);
            getHandler().removeCallbacks(this.Il);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.Ij = z;
    }

    public void setOnkbdStateListener(c cVar) {
        this.Ik = cVar;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i2, i3, i4, i5);
            if (!this.mLayoutHasInit) {
                this.mLayoutHasInit = true;
                this.mMaxHeight = i5;
                if (this.Ik != null) {
                    this.Ik.onKeyBoardStateChange(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i5 ? i5 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i5 && i5 != this.mPreHeight) {
                this.Ii = true;
                if (this.Ik != null) {
                    this.Ik.onKeyBoardStateChange(-3);
                }
                if (this.Ij && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.Il, 1L);
                }
            }
            if (this.mLayoutHasInit && this.Ii && this.mMaxHeight == i5) {
                this.Ii = false;
                if (this.Ik != null) {
                    this.Ik.onKeyBoardStateChange(-2);
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
        if (this.Im != null) {
            removeHeaderView(this.Im.nF().getView());
        }
        this.Im = null;
        if (dVar != null) {
            this.Im = new i(this, dVar);
            this.Im.setOnScrollToPullListener(this.HW);
        }
    }

    public void completePullRefresh() {
        if (this.Im == null) {
            return;
        }
        this.Im.nG();
    }

    public void nD() {
        if (this.Im != null) {
            setSelection(0);
            this.Im.W(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Im != null) {
            this.Im.a(motionEvent, this.If);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Im != null) {
            this.Im.b(motionEvent, this.If);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public boolean nE() {
        return this.Im == null || this.Im.mState == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static float Io = 3.0f;
        private com.baidu.adp.widget.ListView.d Ip;
        private BdListView mListView;
        private boolean Iq = false;
        private int Ir = 0;
        protected int mState = 3;
        private Boolean Is = false;
        private g HW = null;
        private int It = 800;

        public i(BdListView bdListView, com.baidu.adp.widget.ListView.d dVar) {
            this.Ip = null;
            this.mListView = null;
            if (dVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView == null) {
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            this.Ip = dVar;
            this.mListView = bdListView;
            View view = this.Ip.getView();
            view.setPadding(0, -this.Ip.ny(), 0, 0);
            view.invalidate();
            this.mListView.g(view);
        }

        public com.baidu.adp.widget.ListView.d nF() {
            return this.Ip;
        }

        public void done() {
            this.mState = 3;
            this.Ip.setPadding(0, -this.Ip.ny(), 0, 0);
            this.Ip.S(true);
            if (this.HW != null) {
                this.HW.V(false);
            }
        }

        public void W(boolean z) {
            this.mState = 2;
            this.Ip.setPadding(0, 0, 0, 0);
            this.Ip.nx();
            this.Ip.T(z);
        }

        public void setOnScrollToPullListener(g gVar) {
            this.HW = gVar;
        }

        public void a(MotionEvent motionEvent, int i) {
            if (motionEvent.getAction() == 0 && nF().isEnable()) {
                this.Iq = false;
                this.Is = false;
                if (i == 0 && !this.Iq) {
                    this.Iq = true;
                    this.Ir = (int) motionEvent.getY();
                }
            }
        }

        public void b(MotionEvent motionEvent, int i) {
            if (nF().isEnable()) {
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        if (this.mState != 2) {
                            if (this.mState == 1) {
                                this.mState = 3;
                                this.Ip.setPadding(0, -this.Ip.ny(), 0, 0);
                                this.Ip.S(false);
                                if (this.HW != null) {
                                    this.HW.V(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 0) {
                                W(false);
                                if (this.HW != null) {
                                    this.HW.V(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 3 && this.HW != null) {
                                this.HW.V(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case 2:
                        int y = (int) motionEvent.getY();
                        if (!this.Iq && i == 0) {
                            this.Iq = true;
                            this.Ir = y;
                        }
                        if (this.mState != 2 && this.Iq) {
                            if (this.mState == 0) {
                                this.mListView.setSelection(0);
                                if (((int) ((y - this.Ir) / Io)) < this.Ip.ny() && y - this.Ir > 0) {
                                    this.mState = 1;
                                    this.Ip.R(this.Is.booleanValue());
                                    this.Is = false;
                                    if (this.HW != null) {
                                        this.HW.V(true);
                                    }
                                } else if (y - this.Ir <= 0) {
                                    this.mState = 3;
                                    this.Ip.setPadding(0, -this.Ip.ny(), 0, 0);
                                    this.Ip.S(false);
                                    if (this.HW != null) {
                                        this.HW.V(true);
                                    }
                                }
                            } else if (this.mState == 1) {
                                this.mListView.setSelection(0);
                                if (((int) ((y - this.Ir) / Io)) >= this.Ip.ny()) {
                                    this.mState = 0;
                                    this.Is = true;
                                    this.Ip.nw();
                                    if (this.HW != null) {
                                        this.HW.V(true);
                                    }
                                } else if (y - this.Ir <= 0) {
                                    this.mState = 3;
                                    this.Ip.setPadding(0, -this.Ip.ny(), 0, 0);
                                    this.Ip.S(false);
                                    if (this.HW != null) {
                                        this.HW.V(true);
                                    }
                                }
                            } else if (this.mState == 3) {
                                if (y - this.Ir > 0) {
                                    this.mState = 1;
                                    this.Ip.R(this.Is.booleanValue());
                                    this.Is = false;
                                    if (this.HW != null) {
                                        this.HW.V(true);
                                    }
                                } else if (this.HW != null) {
                                    this.HW.V(false);
                                }
                            }
                            if (this.mState == 1 || this.mState == 0) {
                                this.Ip.setPadding(0, ((int) ((y - this.Ir) / Io)) - this.Ip.ny(), 0, 0);
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
        public void nG() {
            View view;
            com.baidu.adp.widget.ListView.d nF = nF();
            if (nF != null && (view = nF.getView()) != null) {
                q qVar = new q(view.getContext(), 0, -nF.ny(), this.It);
                qVar.a(new p(this));
                qVar.h(view);
            }
        }
    }
}
