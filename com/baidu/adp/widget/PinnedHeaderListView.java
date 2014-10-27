package com.baidu.adp.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
public class PinnedHeaderListView extends BdListView implements AbsListView.OnScrollListener {
    private AbsListView.OnScrollListener vE;
    private final DataSetObserver vF;
    private View vG;
    private int vH;
    private int vI;
    private int vJ;
    private int vK;
    private int vL;
    private int vM;
    private int vN;
    private boolean vO;
    private boolean vP;
    private q vQ;

    public PinnedHeaderListView(Context context) {
        this(context, null, 0);
        init();
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init();
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vF = new o(this);
        this.vH = -1;
        this.vM = this.vL;
        this.vP = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        init();
    }

    private void init() {
        setOnScrollToPullListener(new p(this));
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof q)) {
            throw new RuntimeException("Adapter must extended from PinnedHeaderListAdapter");
        }
        super.setAdapter(listAdapter);
        this.vQ = (q) listAdapter;
        this.vH = this.vQ.hZ();
        this.vG = this.vQ.ia();
        if (this.vG.getLayoutParams() == null) {
            this.vG.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
        if (this.vG != null) {
            setFadingEdgeLength(0);
        }
        this.vQ.registerDataSetObserver(this.vF);
    }

    private void h(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.vG != null) {
            ViewGroup.LayoutParams layoutParams = this.vG.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
            }
            switch (layoutParams.width) {
                case -2:
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
                    break;
                case -1:
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
                    break;
                default:
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                    break;
            }
            switch (layoutParams.height) {
                case -2:
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE);
                    break;
                case -1:
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
                    break;
                default:
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                    break;
            }
            this.vG.measure(makeMeasureSpec, makeMeasureSpec2);
            this.vI = this.vG.getMeasuredWidth();
            this.vJ = this.vG.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        hX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.vO && !this.vP && this.vG.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.vK);
            drawChild(canvas, this.vG, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void hX() {
        if (this.vG != null) {
            q qVar = this.vQ;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = qVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = qVar.getItemViewType(i);
            if (this.vO) {
                if (itemViewType2 == this.vH) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.vK = Math.min(this.vJ, Math.max(0, this.vJ - childAt.getTop()));
                        invalidate(0, 0, this.vI, this.vJ);
                    }
                } else if (itemViewType == this.vH && firstVisiblePosition != this.vL) {
                    qVar.a(this.vG, this, firstVisiblePosition);
                    h(getMeasuredWidth(), getMeasuredHeight());
                    this.vG.layout(0, 0, this.vI, this.vJ);
                    invalidate(0, 0, this.vI, this.vJ);
                    this.vL = firstVisiblePosition;
                    this.vN = this.vL;
                } else {
                    this.vK = 0;
                    invalidate(0, 0, this.vI, this.vJ);
                }
                int ak = ak(i);
                if (ak == -1) {
                    this.vO = false;
                    qVar.a(null, this, -1);
                } else if (ak != this.vN || ak == 0) {
                    qVar.a(this.vG, this, ak);
                    h(getMeasuredWidth(), getMeasuredHeight());
                    this.vG.layout(0, 0, this.vI, this.vJ);
                    invalidate(0, 0, this.vI, this.vJ);
                    this.vN = ak;
                    this.vL = this.vM;
                }
            } else if (itemViewType == this.vH) {
                this.vO = true;
                this.vK = 0;
                qVar.a(this.vG, this, firstVisiblePosition);
                h(getMeasuredWidth(), getMeasuredHeight());
                this.vG.layout(0, 0, this.vI, this.vJ);
                invalidate(0, 0, this.vI, this.vJ);
                this.vL = firstVisiblePosition;
                this.vM = firstVisiblePosition;
            }
        }
    }

    private int ak(int i) {
        q qVar = this.vQ;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (qVar.getItemViewType(i2) == this.vH) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.vE = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.vE != null) {
            this.vE.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        hX();
        if (this.vE != null) {
            this.vE.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /* renamed from: hY */
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2);
    }
}
