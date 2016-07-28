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
    private boolean mLayoutHasInit;
    private int mMaxHeight;
    private int mPreHeight;
    private Runnable preLoadRunnable;
    private h zA;
    private int zB;
    private e zC;
    private f zD;
    private com.baidu.adp.widget.ListView.c zE;
    private com.baidu.adp.widget.ListView.c zF;
    private View zG;
    private int zH;
    private Runnable zI;
    private Runnable zJ;
    private boolean zK;
    private boolean zL;
    private c zM;
    private Runnable zN;
    private i zO;
    private com.baidu.adp.widget.ListView.e zq;
    private AdapterView.OnItemClickListener zr;
    private AdapterView.OnItemLongClickListener zs;
    private AdapterView.OnItemSelectedListener zt;
    private b zu;
    private a zv;
    private AbsListView.OnScrollListener zw;
    private d zx;
    private g zy;
    private long zz;

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
        void ax(int i);
    }

    /* loaded from: classes.dex */
    public interface d {
        void i(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface e {
        void jC();
    }

    /* loaded from: classes.dex */
    public interface f {
        void t(BdListView bdListView);
    }

    /* loaded from: classes.dex */
    public interface g {
        void T(boolean z);
    }

    /* loaded from: classes.dex */
    public interface h {
        void jD();
    }

    public BdListView(Context context) {
        super(context);
        this.zq = null;
        this.zr = null;
        this.zs = null;
        this.zt = null;
        this.zu = null;
        this.zv = null;
        this.zw = null;
        this.zx = null;
        this.zy = null;
        this.zz = 100L;
        this.zA = null;
        this.zB = 0;
        this.zC = null;
        this.zD = null;
        this.zE = null;
        this.zF = null;
        this.zG = null;
        this.zH = 0;
        this.zI = new com.baidu.adp.widget.ListView.g(this);
        this.zJ = new com.baidu.adp.widget.ListView.i(this);
        this.preLoadRunnable = new j(this);
        this.mLayoutHasInit = false;
        this.zK = false;
        this.zL = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.zM = null;
        this.zN = new k(this);
        this.zO = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zq = null;
        this.zr = null;
        this.zs = null;
        this.zt = null;
        this.zu = null;
        this.zv = null;
        this.zw = null;
        this.zx = null;
        this.zy = null;
        this.zz = 100L;
        this.zA = null;
        this.zB = 0;
        this.zC = null;
        this.zD = null;
        this.zE = null;
        this.zF = null;
        this.zG = null;
        this.zH = 0;
        this.zI = new com.baidu.adp.widget.ListView.g(this);
        this.zJ = new com.baidu.adp.widget.ListView.i(this);
        this.preLoadRunnable = new j(this);
        this.mLayoutHasInit = false;
        this.zK = false;
        this.zL = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.zM = null;
        this.zN = new k(this);
        this.zO = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.zq = null;
        this.zr = null;
        this.zs = null;
        this.zt = null;
        this.zu = null;
        this.zv = null;
        this.zw = null;
        this.zx = null;
        this.zy = null;
        this.zz = 100L;
        this.zA = null;
        this.zB = 0;
        this.zC = null;
        this.zD = null;
        this.zE = null;
        this.zF = null;
        this.zG = null;
        this.zH = 0;
        this.zI = new com.baidu.adp.widget.ListView.g(this);
        this.zJ = new com.baidu.adp.widget.ListView.i(this);
        this.preLoadRunnable = new j(this);
        this.mLayoutHasInit = false;
        this.zK = false;
        this.zL = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.zM = null;
        this.zN = new k(this);
        this.zO = null;
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

    public void jy() {
        removeCallbacks(this.zJ);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.zq = new com.baidu.adp.widget.ListView.e(getContext());
        this.zq.a(new l(this));
        super.setOnItemClickListener(new m(this));
        super.setOnScrollListener(new n(this));
    }

    public void setOnScrollToPullListener(g gVar) {
        this.zy = gVar;
    }

    public void setOnSrollToTopListener(h hVar) {
        this.zA = hVar;
    }

    public void setOnSrollToBottomListener(e eVar) {
        this.zC = eVar;
    }

    public void setExOnSrollToBottomListener(f fVar) {
        this.zD = fVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.zs = onItemLongClickListener;
        super.setOnItemLongClickListener(new o(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.zt = onItemSelectedListener;
        super.setOnItemSelectedListener(new p(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.zw = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.zr = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.zq;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.zq instanceof com.baidu.adp.widget.ListView.e) {
            return this.zq.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.zq.a(listAdapter);
        super.setAdapter((ListAdapter) this.zq);
    }

    public void setOnHeaderClickListener(b bVar) {
        this.zu = bVar;
    }

    public void setOnFooterClickListener(a aVar) {
        this.zv = aVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.zq.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.zq.f(view, getHeaderIndex());
    }

    public void f(View view, int i2) {
        this.zq.f(view, i2);
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.zq.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.zq.getFooterViewsCount();
    }

    public void s(View view) {
        this.zq.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.zq.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.zq.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.zq.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.zq.removeFooter(view);
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
        if (this.zG != null) {
            removeHeaderView(this.zG);
            this.zG = null;
        }
        if (view != null) {
            addHeaderView(view, null, false);
            this.zG = view;
        }
    }

    public void setPrePage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.zE != null) {
            removeHeaderView(this.zE.getView());
            this.zE = null;
        }
        if (cVar != null) {
            addHeaderView(cVar.getView());
            this.zE = cVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i2, int i3) {
        super.setSelectionFromTop(i2, i3);
    }

    public void setNextPage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.zF != null) {
            removeFooterView(this.zF.getView());
            this.zF = null;
        }
        if (cVar != null) {
            this.zq.b(cVar.getView(), null, true, 0);
            this.zF = cVar;
        }
    }

    private int getHeaderIndex() {
        if (this.zE != null) {
            return this.zq.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.zI);
            getHandler().removeCallbacks(this.zN);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.zL = z;
    }

    public void setOnkbdStateListener(c cVar) {
        this.zM = cVar;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i2, i3, i4, i5);
            if (!this.mLayoutHasInit) {
                this.mLayoutHasInit = true;
                this.mMaxHeight = i5;
                if (this.zM != null) {
                    this.zM.ax(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i5 ? i5 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i5 && i5 != this.mPreHeight) {
                this.zK = true;
                if (this.zM != null) {
                    this.zM.ax(-3);
                }
                if (this.zL && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.zN, 1L);
                }
            }
            if (this.mLayoutHasInit && this.zK && this.mMaxHeight == i5) {
                this.zK = false;
                if (this.zM != null) {
                    this.zM.ax(-2);
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
        if (this.zO != null) {
            removeHeaderView(this.zO.jE().getView());
        }
        this.zO = null;
        if (dVar != null) {
            this.zO = new i(this, dVar);
            this.zO.setOnScrollToPullListener(this.zy);
        }
    }

    public void jz() {
        if (this.zO != null) {
            if (this.zO.jE() != null) {
                this.zO.zR.js();
            }
            this.zO.jF();
        }
    }

    public void l(long j) {
        if (this.zO != null && this.zO.jE() != null) {
            this.zO.zR.js();
        }
        com.baidu.adp.lib.h.h.dL().postDelayed(new com.baidu.adp.widget.ListView.h(this), j);
    }

    public void jA() {
        if (this.zO != null) {
            setSelection(0);
            this.zO.U(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zO != null) {
            this.zO.a(motionEvent, this.zH);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zO != null) {
            this.zO.b(motionEvent, this.zH);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public boolean jB() {
        return this.zO == null || this.zO.mState == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static float zQ = 3.0f;
        private com.baidu.adp.widget.ListView.d zR;
        private BdListView zU;
        private boolean zS = false;
        private int zT = 0;
        protected int mState = 3;
        private Boolean zV = false;
        private g zy = null;
        private int zW = 800;

        public i(BdListView bdListView, com.baidu.adp.widget.ListView.d dVar) {
            this.zR = null;
            this.zU = null;
            if (dVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView == null) {
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            this.zR = dVar;
            this.zU = bdListView;
            View view = this.zR.getView();
            view.setPadding(0, -this.zR.ju(), 0, 0);
            view.invalidate();
            this.zU.s(view);
        }

        public com.baidu.adp.widget.ListView.d jE() {
            return this.zR;
        }

        public void done() {
            this.mState = 3;
            this.zR.setPadding(0, -this.zR.ju(), 0, 0);
            this.zR.Q(true);
            if (this.zy != null) {
                this.zy.T(false);
            }
        }

        public void U(boolean z) {
            this.mState = 2;
            this.zR.setPadding(0, 0, 0, 0);
            this.zR.jr();
            this.zR.R(z);
        }

        public void setOnScrollToPullListener(g gVar) {
            this.zy = gVar;
        }

        public void a(MotionEvent motionEvent, int i) {
            if (motionEvent.getAction() == 0 && jE().jt()) {
                this.zS = false;
                this.zV = false;
                if (i == 0 && !this.zS && this.zU.getChildAt(0) != null && this.zU.getChildAt(0).getTop() >= 0) {
                    this.zS = true;
                    this.zT = (int) motionEvent.getY();
                }
            }
        }

        public void b(MotionEvent motionEvent, int i) {
            if (jE().jt()) {
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        if (this.mState != 2) {
                            if (this.mState == 1) {
                                this.mState = 3;
                                this.zR.setPadding(0, -this.zR.ju(), 0, 0);
                                this.zR.Q(false);
                                if (this.zy != null) {
                                    this.zy.T(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 0) {
                                U(false);
                                if (this.zy != null) {
                                    this.zy.T(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 3 && this.zy != null) {
                                this.zy.T(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case 2:
                        int y = (int) motionEvent.getY();
                        if (!this.zS && i == 0 && this.zU.getChildAt(0) != null && this.zU.getChildAt(0).getTop() >= 0) {
                            this.zS = true;
                            this.zT = y;
                        }
                        if (this.mState != 2 && this.zS) {
                            if (this.mState == 0) {
                                this.zU.setSelection(0);
                                if (((int) ((y - this.zT) / zQ)) < this.zR.ju() && y - this.zT > 0) {
                                    this.mState = 1;
                                    this.zR.P(this.zV.booleanValue());
                                    this.zV = false;
                                    if (this.zy != null) {
                                        this.zy.T(true);
                                    }
                                } else if (y - this.zT <= 0) {
                                    this.mState = 3;
                                    this.zR.setPadding(0, -this.zR.ju(), 0, 0);
                                    this.zR.Q(false);
                                    if (this.zy != null) {
                                        this.zy.T(true);
                                    }
                                }
                            } else if (this.mState == 1) {
                                this.zU.setSelection(0);
                                if (((int) ((y - this.zT) / zQ)) >= this.zR.ju()) {
                                    this.mState = 0;
                                    this.zV = true;
                                    this.zR.jq();
                                    if (this.zy != null) {
                                        this.zy.T(true);
                                    }
                                } else if (y - this.zT <= 0) {
                                    this.mState = 3;
                                    this.zR.setPadding(0, -this.zR.ju(), 0, 0);
                                    this.zR.Q(false);
                                    if (this.zy != null) {
                                        this.zy.T(true);
                                    }
                                }
                            } else if (this.mState == 3) {
                                if (y - this.zT > 0) {
                                    this.mState = 1;
                                    this.zR.P(this.zV.booleanValue());
                                    this.zV = false;
                                    if (this.zy != null) {
                                        this.zy.T(true);
                                    }
                                } else if (this.zy != null) {
                                    this.zy.T(false);
                                }
                            }
                            if (this.mState == 1 || this.mState == 0) {
                                this.zR.setPadding(0, ((int) ((y - this.zT) / zQ)) - this.zR.ju(), 0, 0);
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
        public void jF() {
            View view;
            com.baidu.adp.widget.ListView.d jE = jE();
            if (jE != null && (view = jE.getView()) != null) {
                r rVar = new r(view.getContext(), 0, -jE.ju(), this.zW);
                rVar.a(new q(this));
                rVar.t(view);
            }
        }
    }
}
