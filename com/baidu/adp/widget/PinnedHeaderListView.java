package com.baidu.adp.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
public class PinnedHeaderListView extends BdListView implements AbsListView.OnScrollListener {
    private AbsListView.OnScrollListener xE;
    private final DataSetObserver xF;
    private View xG;
    private int xH;
    private int xI;
    private int xJ;
    private int xK;
    private int xL;
    private int xM;
    private int xN;
    private boolean xO;
    private boolean xP;
    private q xQ;

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
        this.xF = new o(this);
        this.xH = -1;
        this.xM = this.xL;
        this.xP = false;
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
        this.xQ = (q) listAdapter;
        this.xH = this.xQ.jL();
        this.xG = this.xQ.jM();
        if (this.xG.getLayoutParams() == null) {
            this.xG.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
        if (this.xG != null) {
            setFadingEdgeLength(0);
        }
        this.xQ.registerDataSetObserver(this.xF);
    }

    private void j(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.xG != null) {
            ViewGroup.LayoutParams layoutParams = this.xG.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
            }
            switch (layoutParams.width) {
                case -2:
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, ExploreByTouchHelper.INVALID_ID);
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
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, ExploreByTouchHelper.INVALID_ID);
                    break;
                case -1:
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
                    break;
                default:
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                    break;
            }
            this.xG.measure(makeMeasureSpec, makeMeasureSpec2);
            this.xI = this.xG.getMeasuredWidth();
            this.xJ = this.xG.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        jJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.xO && !this.xP && this.xG.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.xK);
            drawChild(canvas, this.xG, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void jJ() {
        if (this.xG != null) {
            q qVar = this.xQ;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = qVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = qVar.getItemViewType(i);
            if (this.xO) {
                if (itemViewType2 == this.xH) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.xK = Math.min(this.xJ, Math.max(0, this.xJ - childAt.getTop()));
                        invalidate(0, 0, this.xI, this.xJ);
                    }
                } else if (itemViewType == this.xH && firstVisiblePosition != this.xL) {
                    qVar.a(this.xG, this, firstVisiblePosition);
                    j(getMeasuredWidth(), getMeasuredHeight());
                    this.xG.layout(0, 0, this.xI, this.xJ);
                    invalidate(0, 0, this.xI, this.xJ);
                    this.xL = firstVisiblePosition;
                    this.xN = this.xL;
                } else {
                    this.xK = 0;
                    invalidate(0, 0, this.xI, this.xJ);
                }
                int aE = aE(i);
                if (aE == -1) {
                    this.xO = false;
                    qVar.a(null, this, -1);
                } else if (aE != this.xN || aE == 0) {
                    qVar.a(this.xG, this, aE);
                    j(getMeasuredWidth(), getMeasuredHeight());
                    this.xG.layout(0, 0, this.xI, this.xJ);
                    invalidate(0, 0, this.xI, this.xJ);
                    this.xN = aE;
                    this.xL = this.xM;
                }
            } else if (itemViewType == this.xH) {
                this.xO = true;
                this.xK = 0;
                qVar.a(this.xG, this, firstVisiblePosition);
                j(getMeasuredWidth(), getMeasuredHeight());
                this.xG.layout(0, 0, this.xI, this.xJ);
                invalidate(0, 0, this.xI, this.xJ);
                this.xL = firstVisiblePosition;
                this.xM = firstVisiblePosition;
            }
        }
    }

    private int aE(int i) {
        q qVar = this.xQ;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (qVar.getItemViewType(i2) == this.xH) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.xE = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.xE != null) {
            this.xE.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        jJ();
        if (this.xE != null) {
            this.xE.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /* renamed from: jK */
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2);
    }
}
