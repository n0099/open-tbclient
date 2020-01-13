package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
/* loaded from: classes10.dex */
public class PinnedHeaderListView extends ListView {
    private a bIc;
    private boolean bId;
    private int bIe;
    private int bIf;
    private AbsListView.OnScrollListener bIg;
    private View mHeaderView;

    /* loaded from: classes10.dex */
    public interface a {
        void a(View view, int i, int i2);

        int fx(int i);
    }

    public PinnedHeaderListView(Context context) {
        super(context);
        init(context);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        super.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PinnedHeaderListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (PinnedHeaderListView.this.bIg != null) {
                    PinnedHeaderListView.this.bIg.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                PinnedHeaderListView.this.fw(i);
                if (PinnedHeaderListView.this.bIg != null) {
                    PinnedHeaderListView.this.bIg.onScroll(absListView, i, i2, i3);
                }
            }
        });
    }

    public void setPinnedHeaderView(View view) {
        this.mHeaderView = view;
        if (this.mHeaderView != null) {
            setFadingEdgeLength(0);
        }
        requestLayout();
    }

    public View getPinnedHeaderView() {
        return this.mHeaderView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof a) {
            this.bIc = (a) listAdapter;
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mHeaderView != null) {
            measureChild(this.mHeaderView, i, i2);
            this.bIe = this.mHeaderView.getMeasuredWidth();
            this.bIf = this.mHeaderView.getMeasuredHeight();
        }
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mHeaderView != null) {
            this.mHeaderView.layout(0, 0, this.bIe, this.bIf);
            fw(getFirstVisiblePosition());
        }
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bIg = onScrollListener;
    }

    public void fw(int i) {
        int i2;
        int i3 = 255;
        if (this.mHeaderView != null && this.bIc != null) {
            switch (this.bIc.fx(i)) {
                case 0:
                    this.bId = false;
                    return;
                case 1:
                    this.bIc.a(this.mHeaderView, i, 255);
                    if (this.mHeaderView.getTop() != 0) {
                        this.mHeaderView.layout(0, 0, this.bIe, this.bIf);
                    }
                    this.bId = true;
                    return;
                case 2:
                    int bottom = getChildAt(0).getBottom();
                    int height = this.mHeaderView.getHeight();
                    if (bottom < height) {
                        i2 = bottom - height;
                        i3 = ((height + i2) * 255) / height;
                    } else {
                        i2 = 0;
                    }
                    this.bIc.a(this.mHeaderView, i, i3);
                    if (this.mHeaderView.getTop() != i2) {
                        this.mHeaderView.layout(0, i2, this.bIe, this.bIf + i2);
                    }
                    this.bId = true;
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bId) {
            drawChild(canvas, this.mHeaderView, getDrawingTime());
        }
    }
}
