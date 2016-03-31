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
    private AdapterView.OnItemSelectedListener IA;
    private b IB;
    private a IC;
    private AbsListView.OnScrollListener IE;
    private d IG;
    private g IH;
    private long II;
    private h IJ;
    private int IK;
    private e IL;
    private f IM;
    private com.baidu.adp.widget.ListView.c IN;
    private com.baidu.adp.widget.ListView.c IO;
    private View IP;
    private int IQ;
    private Runnable IR;
    private Runnable IS;
    private boolean IT;
    private boolean IU;
    private c IW;
    private Runnable IX;
    private i IY;
    private com.baidu.adp.widget.ListView.e Ix;
    private AdapterView.OnItemClickListener Iy;
    private AdapterView.OnItemLongClickListener Iz;
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
        void aG(int i);
    }

    /* loaded from: classes.dex */
    public interface d {
        void i(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface e {
        void nm();
    }

    /* loaded from: classes.dex */
    public interface f {
        void s(BdListView bdListView);
    }

    /* loaded from: classes.dex */
    public interface g {
        void R(boolean z);
    }

    /* loaded from: classes.dex */
    public interface h {
        void nn();
    }

    public BdListView(Context context) {
        super(context);
        this.Ix = null;
        this.Iy = null;
        this.Iz = null;
        this.IA = null;
        this.IB = null;
        this.IC = null;
        this.IE = null;
        this.IG = null;
        this.IH = null;
        this.II = 100L;
        this.IJ = null;
        this.IK = 0;
        this.IL = null;
        this.IM = null;
        this.IN = null;
        this.IO = null;
        this.IP = null;
        this.IQ = 0;
        this.IR = new com.baidu.adp.widget.ListView.g(this);
        this.IS = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.IT = false;
        this.IU = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.IW = null;
        this.IX = new j(this);
        this.IY = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ix = null;
        this.Iy = null;
        this.Iz = null;
        this.IA = null;
        this.IB = null;
        this.IC = null;
        this.IE = null;
        this.IG = null;
        this.IH = null;
        this.II = 100L;
        this.IJ = null;
        this.IK = 0;
        this.IL = null;
        this.IM = null;
        this.IN = null;
        this.IO = null;
        this.IP = null;
        this.IQ = 0;
        this.IR = new com.baidu.adp.widget.ListView.g(this);
        this.IS = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.IT = false;
        this.IU = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.IW = null;
        this.IX = new j(this);
        this.IY = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Ix = null;
        this.Iy = null;
        this.Iz = null;
        this.IA = null;
        this.IB = null;
        this.IC = null;
        this.IE = null;
        this.IG = null;
        this.IH = null;
        this.II = 100L;
        this.IJ = null;
        this.IK = 0;
        this.IL = null;
        this.IM = null;
        this.IN = null;
        this.IO = null;
        this.IP = null;
        this.IQ = 0;
        this.IR = new com.baidu.adp.widget.ListView.g(this);
        this.IS = new com.baidu.adp.widget.ListView.h(this);
        this.preLoadRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.mLayoutHasInit = false;
        this.IT = false;
        this.IU = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.IW = null;
        this.IX = new j(this);
        this.IY = null;
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

    public void ni() {
        removeCallbacks(this.IS);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.Ix = new com.baidu.adp.widget.ListView.e(getContext());
        this.Ix.a(new k(this));
        super.setOnItemClickListener(new l(this));
        super.setOnScrollListener(new m(this));
    }

    public void setOnScrollToPullListener(g gVar) {
        this.IH = gVar;
    }

    public void setOnSrollToTopListener(h hVar) {
        this.IJ = hVar;
    }

    public void setOnSrollToBottomListener(e eVar) {
        this.IL = eVar;
    }

    public void setExOnSrollToBottomListener(f fVar) {
        this.IM = fVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.Iz = onItemLongClickListener;
        super.setOnItemLongClickListener(new n(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.IA = onItemSelectedListener;
        super.setOnItemSelectedListener(new o(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.IE = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Iy = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.Ix;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.Ix instanceof com.baidu.adp.widget.ListView.e) {
            return this.Ix.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.Ix.a(listAdapter);
        super.setAdapter((ListAdapter) this.Ix);
    }

    public void setOnHeaderClickListener(b bVar) {
        this.IB = bVar;
    }

    public void setOnFooterClickListener(a aVar) {
        this.IC = aVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.Ix.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.Ix.f(view, getHeaderIndex());
    }

    public void f(View view, int i2) {
        this.Ix.f(view, i2);
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.Ix.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.Ix.getFooterViewsCount();
    }

    public void s(View view) {
        this.Ix.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.Ix.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.Ix.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.Ix.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.Ix.removeFooter(view);
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
        if (this.IP != null) {
            removeHeaderView(this.IP);
            this.IP = null;
        }
        if (view != null) {
            addHeaderView(view, null, false);
            this.IP = view;
        }
    }

    public void setPrePage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.IN != null) {
            removeHeaderView(this.IN.getView());
            this.IN = null;
        }
        if (cVar != null) {
            addHeaderView(cVar.getView());
            this.IN = cVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i2, int i3) {
        super.setSelectionFromTop(i2, i3);
    }

    public void setNextPage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.IO != null) {
            removeFooterView(this.IO.getView());
            this.IO = null;
        }
        if (cVar != null) {
            this.Ix.b(cVar.getView(), null, true, 0);
            this.IO = cVar;
        }
    }

    private int getHeaderIndex() {
        if (this.IN != null) {
            return this.Ix.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.IR);
            getHandler().removeCallbacks(this.IX);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.IU = z;
    }

    public void setOnkbdStateListener(c cVar) {
        this.IW = cVar;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i2, i3, i4, i5);
            if (!this.mLayoutHasInit) {
                this.mLayoutHasInit = true;
                this.mMaxHeight = i5;
                if (this.IW != null) {
                    this.IW.aG(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i5 ? i5 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i5 && i5 != this.mPreHeight) {
                this.IT = true;
                if (this.IW != null) {
                    this.IW.aG(-3);
                }
                if (this.IU && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.IX, 1L);
                }
            }
            if (this.mLayoutHasInit && this.IT && this.mMaxHeight == i5) {
                this.IT = false;
                if (this.IW != null) {
                    this.IW.aG(-2);
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
        if (this.IY != null) {
            removeHeaderView(this.IY.no().getView());
        }
        this.IY = null;
        if (dVar != null) {
            this.IY = new i(this, dVar);
            this.IY.setOnScrollToPullListener(this.IH);
        }
    }

    public void nj() {
        if (this.IY == null) {
            return;
        }
        this.IY.np();
    }

    public void nk() {
        if (this.IY != null) {
            setSelection(0);
            this.IY.S(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.IY != null) {
            this.IY.a(motionEvent, this.IQ);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.IY != null) {
            this.IY.b(motionEvent, this.IQ);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public boolean nl() {
        return this.IY == null || this.IY.mState == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static float Ja = 3.0f;
        private com.baidu.adp.widget.ListView.d Jb;
        private BdListView Je;
        private boolean Jc = false;
        private int Jd = 0;
        protected int mState = 3;
        private Boolean Jf = false;
        private g IH = null;
        private int Jg = 800;

        public i(BdListView bdListView, com.baidu.adp.widget.ListView.d dVar) {
            this.Jb = null;
            this.Je = null;
            if (dVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView == null) {
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            this.Jb = dVar;
            this.Je = bdListView;
            View view = this.Jb.getView();
            view.setPadding(0, -this.Jb.nd(), 0, 0);
            view.invalidate();
            this.Je.s(view);
        }

        public com.baidu.adp.widget.ListView.d no() {
            return this.Jb;
        }

        public void done() {
            this.mState = 3;
            this.Jb.setPadding(0, -this.Jb.nd(), 0, 0);
            this.Jb.O(true);
            if (this.IH != null) {
                this.IH.R(false);
            }
        }

        public void S(boolean z) {
            this.mState = 2;
            this.Jb.setPadding(0, 0, 0, 0);
            this.Jb.nb();
            this.Jb.P(z);
        }

        public void setOnScrollToPullListener(g gVar) {
            this.IH = gVar;
        }

        public void a(MotionEvent motionEvent, int i) {
            if (motionEvent.getAction() == 0 && no().nc()) {
                this.Jc = false;
                this.Jf = false;
                if (i == 0 && !this.Jc) {
                    this.Jc = true;
                    this.Jd = (int) motionEvent.getY();
                }
            }
        }

        public void b(MotionEvent motionEvent, int i) {
            if (no().nc()) {
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        if (this.mState != 2) {
                            if (this.mState == 1) {
                                this.mState = 3;
                                this.Jb.setPadding(0, -this.Jb.nd(), 0, 0);
                                this.Jb.O(false);
                                if (this.IH != null) {
                                    this.IH.R(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 0) {
                                S(false);
                                if (this.IH != null) {
                                    this.IH.R(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 3 && this.IH != null) {
                                this.IH.R(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case 2:
                        int y = (int) motionEvent.getY();
                        if (!this.Jc && i == 0) {
                            this.Jc = true;
                            this.Jd = y;
                        }
                        if (this.mState != 2 && this.Jc) {
                            if (this.mState == 0) {
                                this.Je.setSelection(0);
                                if (((int) ((y - this.Jd) / Ja)) < this.Jb.nd() && y - this.Jd > 0) {
                                    this.mState = 1;
                                    this.Jb.N(this.Jf.booleanValue());
                                    this.Jf = false;
                                    if (this.IH != null) {
                                        this.IH.R(true);
                                    }
                                } else if (y - this.Jd <= 0) {
                                    this.mState = 3;
                                    this.Jb.setPadding(0, -this.Jb.nd(), 0, 0);
                                    this.Jb.O(false);
                                    if (this.IH != null) {
                                        this.IH.R(true);
                                    }
                                }
                            } else if (this.mState == 1) {
                                this.Je.setSelection(0);
                                if (((int) ((y - this.Jd) / Ja)) >= this.Jb.nd()) {
                                    this.mState = 0;
                                    this.Jf = true;
                                    this.Jb.na();
                                    if (this.IH != null) {
                                        this.IH.R(true);
                                    }
                                } else if (y - this.Jd <= 0) {
                                    this.mState = 3;
                                    this.Jb.setPadding(0, -this.Jb.nd(), 0, 0);
                                    this.Jb.O(false);
                                    if (this.IH != null) {
                                        this.IH.R(true);
                                    }
                                }
                            } else if (this.mState == 3) {
                                if (y - this.Jd > 0) {
                                    this.mState = 1;
                                    this.Jb.N(this.Jf.booleanValue());
                                    this.Jf = false;
                                    if (this.IH != null) {
                                        this.IH.R(true);
                                    }
                                } else if (this.IH != null) {
                                    this.IH.R(false);
                                }
                            }
                            if (this.mState == 1 || this.mState == 0) {
                                this.Jb.setPadding(0, ((int) ((y - this.Jd) / Ja)) - this.Jb.nd(), 0, 0);
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
        public void np() {
            View view;
            com.baidu.adp.widget.ListView.d no = no();
            if (no != null && (view = no.getView()) != null) {
                q qVar = new q(view.getContext(), 0, -no.nd(), this.Jg);
                qVar.a(new p(this));
                qVar.t(view);
            }
        }
    }
}
