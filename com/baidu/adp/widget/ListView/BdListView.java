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
    private com.baidu.adp.widget.ListView.e yQ;
    private AdapterView.OnItemClickListener yR;
    private AdapterView.OnItemLongClickListener yS;
    private AdapterView.OnItemSelectedListener yT;
    private b yU;
    private a yV;
    private AbsListView.OnScrollListener yW;
    private d yX;
    private g yY;
    private long yZ;
    private h za;
    private int zb;
    private e zc;
    private f zd;
    private com.baidu.adp.widget.ListView.c ze;
    private com.baidu.adp.widget.ListView.c zf;
    private View zg;
    private int zh;
    private Runnable zi;
    private Runnable zj;
    private boolean zk;
    private boolean zl;
    private c zm;
    private Runnable zn;
    private i zo;

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
        void at(int i);
    }

    /* loaded from: classes.dex */
    public interface d {
        void i(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface e {
        void jA();
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
        void jB();
    }

    public BdListView(Context context) {
        super(context);
        this.yQ = null;
        this.yR = null;
        this.yS = null;
        this.yT = null;
        this.yU = null;
        this.yV = null;
        this.yW = null;
        this.yX = null;
        this.yY = null;
        this.yZ = 100L;
        this.za = null;
        this.zb = 0;
        this.zc = null;
        this.zd = null;
        this.ze = null;
        this.zf = null;
        this.zg = null;
        this.zh = 0;
        this.zi = new com.baidu.adp.widget.ListView.g(this);
        this.zj = new com.baidu.adp.widget.ListView.i(this);
        this.preLoadRunnable = new j(this);
        this.mLayoutHasInit = false;
        this.zk = false;
        this.zl = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.zm = null;
        this.zn = new k(this);
        this.zo = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yQ = null;
        this.yR = null;
        this.yS = null;
        this.yT = null;
        this.yU = null;
        this.yV = null;
        this.yW = null;
        this.yX = null;
        this.yY = null;
        this.yZ = 100L;
        this.za = null;
        this.zb = 0;
        this.zc = null;
        this.zd = null;
        this.ze = null;
        this.zf = null;
        this.zg = null;
        this.zh = 0;
        this.zi = new com.baidu.adp.widget.ListView.g(this);
        this.zj = new com.baidu.adp.widget.ListView.i(this);
        this.preLoadRunnable = new j(this);
        this.mLayoutHasInit = false;
        this.zk = false;
        this.zl = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.zm = null;
        this.zn = new k(this);
        this.zo = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.yQ = null;
        this.yR = null;
        this.yS = null;
        this.yT = null;
        this.yU = null;
        this.yV = null;
        this.yW = null;
        this.yX = null;
        this.yY = null;
        this.yZ = 100L;
        this.za = null;
        this.zb = 0;
        this.zc = null;
        this.zd = null;
        this.ze = null;
        this.zf = null;
        this.zg = null;
        this.zh = 0;
        this.zi = new com.baidu.adp.widget.ListView.g(this);
        this.zj = new com.baidu.adp.widget.ListView.i(this);
        this.preLoadRunnable = new j(this);
        this.mLayoutHasInit = false;
        this.zk = false;
        this.zl = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.zm = null;
        this.zn = new k(this);
        this.zo = null;
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

    public void jw() {
        removeCallbacks(this.zj);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.yQ = new com.baidu.adp.widget.ListView.e(getContext());
        this.yQ.a(new l(this));
        super.setOnItemClickListener(new m(this));
        super.setOnScrollListener(new n(this));
    }

    public void setOnScrollToPullListener(g gVar) {
        this.yY = gVar;
    }

    public void setOnSrollToTopListener(h hVar) {
        this.za = hVar;
    }

    public void setOnSrollToBottomListener(e eVar) {
        this.zc = eVar;
    }

    public void setExOnSrollToBottomListener(f fVar) {
        this.zd = fVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.yS = onItemLongClickListener;
        super.setOnItemLongClickListener(new o(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.yT = onItemSelectedListener;
        super.setOnItemSelectedListener(new p(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.yW = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.yR = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.yQ;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.yQ instanceof com.baidu.adp.widget.ListView.e) {
            return this.yQ.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.yQ.a(listAdapter);
        super.setAdapter((ListAdapter) this.yQ);
    }

    public void setOnHeaderClickListener(b bVar) {
        this.yU = bVar;
    }

    public void setOnFooterClickListener(a aVar) {
        this.yV = aVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.yQ.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.yQ.f(view, getHeaderIndex());
    }

    public void f(View view, int i2) {
        this.yQ.f(view, i2);
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.yQ.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.yQ.getFooterViewsCount();
    }

    public void s(View view) {
        this.yQ.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.yQ.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.yQ.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.yQ.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.yQ.removeFooter(view);
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
        if (this.zg != null) {
            removeHeaderView(this.zg);
            this.zg = null;
        }
        if (view != null) {
            addHeaderView(view, null, false);
            this.zg = view;
        }
    }

    public void setPrePage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.ze != null) {
            removeHeaderView(this.ze.getView());
            this.ze = null;
        }
        if (cVar != null) {
            addHeaderView(cVar.getView());
            this.ze = cVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i2, int i3) {
        super.setSelectionFromTop(i2, i3);
    }

    public void setNextPage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.zf != null) {
            removeFooterView(this.zf.getView());
            this.zf = null;
        }
        if (cVar != null) {
            this.yQ.b(cVar.getView(), null, true, 0);
            this.zf = cVar;
        }
    }

    private int getHeaderIndex() {
        if (this.ze != null) {
            return this.yQ.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.zi);
            getHandler().removeCallbacks(this.zn);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.zl = z;
    }

    public void setOnkbdStateListener(c cVar) {
        this.zm = cVar;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i2, i3, i4, i5);
            if (!this.mLayoutHasInit) {
                this.mLayoutHasInit = true;
                this.mMaxHeight = i5;
                if (this.zm != null) {
                    this.zm.at(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i5 ? i5 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i5 && i5 != this.mPreHeight) {
                this.zk = true;
                if (this.zm != null) {
                    this.zm.at(-3);
                }
                if (this.zl && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.zn, 1L);
                }
            }
            if (this.mLayoutHasInit && this.zk && this.mMaxHeight == i5) {
                this.zk = false;
                if (this.zm != null) {
                    this.zm.at(-2);
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
        if (this.zo != null) {
            removeHeaderView(this.zo.jC().getView());
        }
        this.zo = null;
        if (dVar != null) {
            this.zo = new i(this, dVar);
            this.zo.setOnScrollToPullListener(this.yY);
        }
    }

    public void jx() {
        if (this.zo != null) {
            if (this.zo.jC() != null) {
                this.zo.zr.jq();
            }
            this.zo.jD();
        }
    }

    public void k(long j) {
        if (this.zo != null && this.zo.jC() != null) {
            this.zo.zr.jq();
        }
        com.baidu.adp.lib.h.h.dL().postDelayed(new com.baidu.adp.widget.ListView.h(this), j);
    }

    public void jy() {
        if (this.zo != null) {
            setSelection(0);
            this.zo.S(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zo != null) {
            this.zo.a(motionEvent, this.zh);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zo != null) {
            this.zo.b(motionEvent, this.zh);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public boolean jz() {
        return this.zo == null || this.zo.mState == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static float zq = 3.0f;
        private com.baidu.adp.widget.ListView.d zr;
        private BdListView zu;
        private boolean zs = false;
        private int zt = 0;
        protected int mState = 3;
        private Boolean zv = false;
        private g yY = null;
        private int zw = 800;

        public i(BdListView bdListView, com.baidu.adp.widget.ListView.d dVar) {
            this.zr = null;
            this.zu = null;
            if (dVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView == null) {
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            this.zr = dVar;
            this.zu = bdListView;
            View view = this.zr.getView();
            view.setPadding(0, -this.zr.js(), 0, 0);
            view.invalidate();
            this.zu.s(view);
        }

        public com.baidu.adp.widget.ListView.d jC() {
            return this.zr;
        }

        public void done() {
            this.mState = 3;
            this.zr.setPadding(0, -this.zr.js(), 0, 0);
            this.zr.O(true);
            if (this.yY != null) {
                this.yY.R(false);
            }
        }

        public void S(boolean z) {
            this.mState = 2;
            this.zr.setPadding(0, 0, 0, 0);
            this.zr.jp();
            this.zr.P(z);
        }

        public void setOnScrollToPullListener(g gVar) {
            this.yY = gVar;
        }

        public void a(MotionEvent motionEvent, int i) {
            if (motionEvent.getAction() == 0 && jC().jr()) {
                this.zs = false;
                this.zv = false;
                if (i == 0 && !this.zs && this.zu.getChildAt(0) != null && this.zu.getChildAt(0).getTop() >= 0) {
                    this.zs = true;
                    this.zt = (int) motionEvent.getY();
                }
            }
        }

        public void b(MotionEvent motionEvent, int i) {
            if (jC().jr()) {
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        if (this.mState != 2) {
                            if (this.mState == 1) {
                                this.mState = 3;
                                this.zr.setPadding(0, -this.zr.js(), 0, 0);
                                this.zr.O(false);
                                if (this.yY != null) {
                                    this.yY.R(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 0) {
                                S(false);
                                if (this.yY != null) {
                                    this.yY.R(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 3 && this.yY != null) {
                                this.yY.R(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case 2:
                        int y = (int) motionEvent.getY();
                        if (!this.zs && i == 0 && this.zu.getChildAt(0) != null && this.zu.getChildAt(0).getTop() >= 0) {
                            this.zs = true;
                            this.zt = y;
                        }
                        if (this.mState != 2 && this.zs) {
                            if (this.mState == 0) {
                                this.zu.setSelection(0);
                                if (((int) ((y - this.zt) / zq)) < this.zr.js() && y - this.zt > 0) {
                                    this.mState = 1;
                                    this.zr.N(this.zv.booleanValue());
                                    this.zv = false;
                                    if (this.yY != null) {
                                        this.yY.R(true);
                                    }
                                } else if (y - this.zt <= 0) {
                                    this.mState = 3;
                                    this.zr.setPadding(0, -this.zr.js(), 0, 0);
                                    this.zr.O(false);
                                    if (this.yY != null) {
                                        this.yY.R(true);
                                    }
                                }
                            } else if (this.mState == 1) {
                                this.zu.setSelection(0);
                                if (((int) ((y - this.zt) / zq)) >= this.zr.js()) {
                                    this.mState = 0;
                                    this.zv = true;
                                    this.zr.jo();
                                    if (this.yY != null) {
                                        this.yY.R(true);
                                    }
                                } else if (y - this.zt <= 0) {
                                    this.mState = 3;
                                    this.zr.setPadding(0, -this.zr.js(), 0, 0);
                                    this.zr.O(false);
                                    if (this.yY != null) {
                                        this.yY.R(true);
                                    }
                                }
                            } else if (this.mState == 3) {
                                if (y - this.zt > 0) {
                                    this.mState = 1;
                                    this.zr.N(this.zv.booleanValue());
                                    this.zv = false;
                                    if (this.yY != null) {
                                        this.yY.R(true);
                                    }
                                } else if (this.yY != null) {
                                    this.yY.R(false);
                                }
                            }
                            if (this.mState == 1 || this.mState == 0) {
                                this.zr.setPadding(0, ((int) ((y - this.zt) / zq)) - this.zr.js(), 0, 0);
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
        public void jD() {
            View view;
            com.baidu.adp.widget.ListView.d jC = jC();
            if (jC != null && (view = jC.getView()) != null) {
                r rVar = new r(view.getContext(), 0, -jC.js(), this.zw);
                rVar.a(new q(this));
                rVar.t(view);
            }
        }
    }
}
