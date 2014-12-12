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
    private AbsListView.OnScrollListener xH;
    private final DataSetObserver xI;
    private View xJ;
    private int xK;
    private int xL;
    private int xM;
    private int xN;
    private int xO;
    private int xP;
    private int xQ;
    private boolean xR;
    private boolean xS;
    private q xT;

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
        this.xI = new o(this);
        this.xK = -1;
        this.xP = this.xO;
        this.xS = false;
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
        this.xT = (q) listAdapter;
        this.xK = this.xT.jS();
        this.xJ = this.xT.jT();
        if (this.xJ.getLayoutParams() == null) {
            this.xJ.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
        if (this.xJ != null) {
            setFadingEdgeLength(0);
        }
        this.xT.registerDataSetObserver(this.xI);
    }

    private void j(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.xJ != null) {
            ViewGroup.LayoutParams layoutParams = this.xJ.getLayoutParams();
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
            this.xJ.measure(makeMeasureSpec, makeMeasureSpec2);
            this.xL = this.xJ.getMeasuredWidth();
            this.xM = this.xJ.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        jQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.xR && !this.xS && this.xJ.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.xN);
            drawChild(canvas, this.xJ, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void jQ() {
        if (this.xJ != null) {
            q qVar = this.xT;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = qVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = qVar.getItemViewType(i);
            if (this.xR) {
                if (itemViewType2 == this.xK) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.xN = Math.min(this.xM, Math.max(0, this.xM - childAt.getTop()));
                        invalidate(0, 0, this.xL, this.xM);
                    }
                } else if (itemViewType == this.xK && firstVisiblePosition != this.xO) {
                    qVar.a(this.xJ, this, firstVisiblePosition);
                    j(getMeasuredWidth(), getMeasuredHeight());
                    this.xJ.layout(0, 0, this.xL, this.xM);
                    invalidate(0, 0, this.xL, this.xM);
                    this.xO = firstVisiblePosition;
                    this.xQ = this.xO;
                } else {
                    this.xN = 0;
                    invalidate(0, 0, this.xL, this.xM);
                }
                int az = az(i);
                if (az == -1) {
                    this.xR = false;
                    qVar.a(null, this, -1);
                } else if (az != this.xQ || az == 0) {
                    qVar.a(this.xJ, this, az);
                    j(getMeasuredWidth(), getMeasuredHeight());
                    this.xJ.layout(0, 0, this.xL, this.xM);
                    invalidate(0, 0, this.xL, this.xM);
                    this.xQ = az;
                    this.xO = this.xP;
                }
            } else if (itemViewType == this.xK) {
                this.xR = true;
                this.xN = 0;
                qVar.a(this.xJ, this, firstVisiblePosition);
                j(getMeasuredWidth(), getMeasuredHeight());
                this.xJ.layout(0, 0, this.xL, this.xM);
                invalidate(0, 0, this.xL, this.xM);
                this.xO = firstVisiblePosition;
                this.xP = firstVisiblePosition;
            }
        }
    }

    private int az(int i) {
        q qVar = this.xT;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (qVar.getItemViewType(i2) == this.xK) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.xH = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.xH != null) {
            this.xH.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        jQ();
        if (this.xH != null) {
            this.xH.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /* renamed from: jR */
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2);
    }
}
