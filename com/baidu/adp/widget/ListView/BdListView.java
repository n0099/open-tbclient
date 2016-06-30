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
    private com.baidu.adp.widget.ListView.e yP;
    private AdapterView.OnItemClickListener yQ;
    private AdapterView.OnItemLongClickListener yR;
    private AdapterView.OnItemSelectedListener yS;
    private b yT;
    private a yU;
    private AbsListView.OnScrollListener yV;
    private d yW;
    private g yX;
    private long yY;
    private h yZ;
    private int za;
    private e zb;
    private f zc;
    private com.baidu.adp.widget.ListView.c zd;
    private com.baidu.adp.widget.ListView.c ze;
    private View zf;
    private int zg;
    private Runnable zh;
    private Runnable zi;
    private boolean zj;
    private boolean zk;
    private c zl;
    private Runnable zm;
    private i zn;

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
        void au(int i);
    }

    /* loaded from: classes.dex */
    public interface d {
        void i(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface e {
        void jD();
    }

    /* loaded from: classes.dex */
    public interface f {
        void t(BdListView bdListView);
    }

    /* loaded from: classes.dex */
    public interface g {
        void R(boolean z);
    }

    /* loaded from: classes.dex */
    public interface h {
        void jE();
    }

    public BdListView(Context context) {
        super(context);
        this.yP = null;
        this.yQ = null;
        this.yR = null;
        this.yS = null;
        this.yT = null;
        this.yU = null;
        this.yV = null;
        this.yW = null;
        this.yX = null;
        this.yY = 100L;
        this.yZ = null;
        this.za = 0;
        this.zb = null;
        this.zc = null;
        this.zd = null;
        this.ze = null;
        this.zf = null;
        this.zg = 0;
        this.zh = new com.baidu.adp.widget.ListView.g(this);
        this.zi = new com.baidu.adp.widget.ListView.i(this);
        this.preLoadRunnable = new j(this);
        this.mLayoutHasInit = false;
        this.zj = false;
        this.zk = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.zl = null;
        this.zm = new k(this);
        this.zn = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yP = null;
        this.yQ = null;
        this.yR = null;
        this.yS = null;
        this.yT = null;
        this.yU = null;
        this.yV = null;
        this.yW = null;
        this.yX = null;
        this.yY = 100L;
        this.yZ = null;
        this.za = 0;
        this.zb = null;
        this.zc = null;
        this.zd = null;
        this.ze = null;
        this.zf = null;
        this.zg = 0;
        this.zh = new com.baidu.adp.widget.ListView.g(this);
        this.zi = new com.baidu.adp.widget.ListView.i(this);
        this.preLoadRunnable = new j(this);
        this.mLayoutHasInit = false;
        this.zj = false;
        this.zk = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.zl = null;
        this.zm = new k(this);
        this.zn = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.yP = null;
        this.yQ = null;
        this.yR = null;
        this.yS = null;
        this.yT = null;
        this.yU = null;
        this.yV = null;
        this.yW = null;
        this.yX = null;
        this.yY = 100L;
        this.yZ = null;
        this.za = 0;
        this.zb = null;
        this.zc = null;
        this.zd = null;
        this.ze = null;
        this.zf = null;
        this.zg = 0;
        this.zh = new com.baidu.adp.widget.ListView.g(this);
        this.zi = new com.baidu.adp.widget.ListView.i(this);
        this.preLoadRunnable = new j(this);
        this.mLayoutHasInit = false;
        this.zj = false;
        this.zk = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.zl = null;
        this.zm = new k(this);
        this.zn = null;
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

    public void jz() {
        removeCallbacks(this.zi);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.yP = new com.baidu.adp.widget.ListView.e(getContext());
        this.yP.a(new l(this));
        super.setOnItemClickListener(new m(this));
        super.setOnScrollListener(new n(this));
    }

    public void setOnScrollToPullListener(g gVar) {
        this.yX = gVar;
    }

    public void setOnSrollToTopListener(h hVar) {
        this.yZ = hVar;
    }

    public void setOnSrollToBottomListener(e eVar) {
        this.zb = eVar;
    }

    public void setExOnSrollToBottomListener(f fVar) {
        this.zc = fVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.yR = onItemLongClickListener;
        super.setOnItemLongClickListener(new o(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.yS = onItemSelectedListener;
        super.setOnItemSelectedListener(new p(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.yV = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.yQ = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.yP;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.yP instanceof com.baidu.adp.widget.ListView.e) {
            return this.yP.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.yP.a(listAdapter);
        super.setAdapter((ListAdapter) this.yP);
    }

    public void setOnHeaderClickListener(b bVar) {
        this.yT = bVar;
    }

    public void setOnFooterClickListener(a aVar) {
        this.yU = aVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.yP.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.yP.f(view, getHeaderIndex());
    }

    public void f(View view, int i2) {
        this.yP.f(view, i2);
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.yP.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.yP.getFooterViewsCount();
    }

    public void s(View view) {
        this.yP.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.yP.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.yP.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.yP.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.yP.removeFooter(view);
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
        if (this.zf != null) {
            removeHeaderView(this.zf);
            this.zf = null;
        }
        if (view != null) {
            addHeaderView(view, null, false);
            this.zf = view;
        }
    }

    public void setPrePage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.zd != null) {
            removeHeaderView(this.zd.getView());
            this.zd = null;
        }
        if (cVar != null) {
            addHeaderView(cVar.getView());
            this.zd = cVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i2, int i3) {
        super.setSelectionFromTop(i2, i3);
    }

    public void setNextPage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.ze != null) {
            removeFooterView(this.ze.getView());
            this.ze = null;
        }
        if (cVar != null) {
            this.yP.b(cVar.getView(), null, true, 0);
            this.ze = cVar;
        }
    }

    private int getHeaderIndex() {
        if (this.zd != null) {
            return this.yP.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.zh);
            getHandler().removeCallbacks(this.zm);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.zk = z;
    }

    public void setOnkbdStateListener(c cVar) {
        this.zl = cVar;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i2, i3, i4, i5);
            if (!this.mLayoutHasInit) {
                this.mLayoutHasInit = true;
                this.mMaxHeight = i5;
                if (this.zl != null) {
                    this.zl.au(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i5 ? i5 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i5 && i5 != this.mPreHeight) {
                this.zj = true;
                if (this.zl != null) {
                    this.zl.au(-3);
                }
                if (this.zk && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.zm, 1L);
                }
            }
            if (this.mLayoutHasInit && this.zj && this.mMaxHeight == i5) {
                this.zj = false;
                if (this.zl != null) {
                    this.zl.au(-2);
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
        if (this.zn != null) {
            removeHeaderView(this.zn.jF().getView());
        }
        this.zn = null;
        if (dVar != null) {
            this.zn = new i(this, dVar);
            this.zn.setOnScrollToPullListener(this.yX);
        }
    }

    public void jA() {
        if (this.zn != null) {
            if (this.zn.jF() != null) {
                this.zn.zq.jt();
            }
            this.zn.jG();
        }
    }

    public void k(long j) {
        if (this.zn != null && this.zn.jF() != null) {
            this.zn.zq.jt();
        }
        com.baidu.adp.lib.h.h.dM().postDelayed(new com.baidu.adp.widget.ListView.h(this), j);
    }

    public void jB() {
        if (this.zn != null) {
            setSelection(0);
            this.zn.S(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zn != null) {
            this.zn.a(motionEvent, this.zg);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zn != null) {
            this.zn.b(motionEvent, this.zg);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public boolean jC() {
        return this.zn == null || this.zn.mState == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static float zp = 3.0f;
        private com.baidu.adp.widget.ListView.d zq;
        private BdListView zt;
        private boolean zr = false;
        private int zs = 0;
        protected int mState = 3;
        private Boolean zu = false;
        private g yX = null;
        private int zv = 800;

        public i(BdListView bdListView, com.baidu.adp.widget.ListView.d dVar) {
            this.zq = null;
            this.zt = null;
            if (dVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView == null) {
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            this.zq = dVar;
            this.zt = bdListView;
            View view = this.zq.getView();
            view.setPadding(0, -this.zq.jv(), 0, 0);
            view.invalidate();
            this.zt.s(view);
        }

        public com.baidu.adp.widget.ListView.d jF() {
            return this.zq;
        }

        public void done() {
            this.mState = 3;
            this.zq.setPadding(0, -this.zq.jv(), 0, 0);
            this.zq.O(true);
            if (this.yX != null) {
                this.yX.R(false);
            }
        }

        public void S(boolean z) {
            this.mState = 2;
            this.zq.setPadding(0, 0, 0, 0);
            this.zq.js();
            this.zq.P(z);
        }

        public void setOnScrollToPullListener(g gVar) {
            this.yX = gVar;
        }

        public void a(MotionEvent motionEvent, int i) {
            if (motionEvent.getAction() == 0 && jF().ju()) {
                this.zr = false;
                this.zu = false;
                if (i == 0 && !this.zr && this.zt.getChildAt(0) != null && this.zt.getChildAt(0).getTop() >= 0) {
                    this.zr = true;
                    this.zs = (int) motionEvent.getY();
                }
            }
        }

        public void b(MotionEvent motionEvent, int i) {
            if (jF().ju()) {
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        if (this.mState != 2) {
                            if (this.mState == 1) {
                                this.mState = 3;
                                this.zq.setPadding(0, -this.zq.jv(), 0, 0);
                                this.zq.O(false);
                                if (this.yX != null) {
                                    this.yX.R(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 0) {
                                S(false);
                                if (this.yX != null) {
                                    this.yX.R(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 3 && this.yX != null) {
                                this.yX.R(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case 2:
                        int y = (int) motionEvent.getY();
                        if (!this.zr && i == 0 && this.zt.getChildAt(0) != null && this.zt.getChildAt(0).getTop() >= 0) {
                            this.zr = true;
                            this.zs = y;
                        }
                        if (this.mState != 2 && this.zr) {
                            if (this.mState == 0) {
                                this.zt.setSelection(0);
                                if (((int) ((y - this.zs) / zp)) < this.zq.jv() && y - this.zs > 0) {
                                    this.mState = 1;
                                    this.zq.N(this.zu.booleanValue());
                                    this.zu = false;
                                    if (this.yX != null) {
                                        this.yX.R(true);
                                    }
                                } else if (y - this.zs <= 0) {
                                    this.mState = 3;
                                    this.zq.setPadding(0, -this.zq.jv(), 0, 0);
                                    this.zq.O(false);
                                    if (this.yX != null) {
                                        this.yX.R(true);
                                    }
                                }
                            } else if (this.mState == 1) {
                                this.zt.setSelection(0);
                                if (((int) ((y - this.zs) / zp)) >= this.zq.jv()) {
                                    this.mState = 0;
                                    this.zu = true;
                                    this.zq.jr();
                                    if (this.yX != null) {
                                        this.yX.R(true);
                                    }
                                } else if (y - this.zs <= 0) {
                                    this.mState = 3;
                                    this.zq.setPadding(0, -this.zq.jv(), 0, 0);
                                    this.zq.O(false);
                                    if (this.yX != null) {
                                        this.yX.R(true);
                                    }
                                }
                            } else if (this.mState == 3) {
                                if (y - this.zs > 0) {
                                    this.mState = 1;
                                    this.zq.N(this.zu.booleanValue());
                                    this.zu = false;
                                    if (this.yX != null) {
                                        this.yX.R(true);
                                    }
                                } else if (this.yX != null) {
                                    this.yX.R(false);
                                }
                            }
                            if (this.mState == 1 || this.mState == 0) {
                                this.zq.setPadding(0, ((int) ((y - this.zs) / zp)) - this.zq.jv(), 0, 0);
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
        public void jG() {
            View view;
            com.baidu.adp.widget.ListView.d jF = jF();
            if (jF != null && (view = jF.getView()) != null) {
                r rVar = new r(view.getContext(), 0, -jF.jv(), this.zv);
                rVar.a(new q(this));
                rVar.t(view);
            }
        }
    }
}
