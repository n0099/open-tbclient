package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
/* loaded from: classes2.dex */
public class PinnedHeaderListView extends ListView {
    private a aIM;
    private boolean aIN;
    private int aIO;
    private int aIP;
    private AbsListView.OnScrollListener aIQ;
    private View mHeaderView;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, int i, int i2);

        int cV(int i);
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
                if (PinnedHeaderListView.this.aIQ != null) {
                    PinnedHeaderListView.this.aIQ.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                PinnedHeaderListView.this.cU(i);
                if (PinnedHeaderListView.this.aIQ != null) {
                    PinnedHeaderListView.this.aIQ.onScroll(absListView, i, i2, i3);
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
            this.aIM = (a) listAdapter;
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mHeaderView != null) {
            measureChild(this.mHeaderView, i, i2);
            this.aIO = this.mHeaderView.getMeasuredWidth();
            this.aIP = this.mHeaderView.getMeasuredHeight();
        }
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mHeaderView != null) {
            this.mHeaderView.layout(0, 0, this.aIO, this.aIP);
            cU(getFirstVisiblePosition());
        }
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aIQ = onScrollListener;
    }

    public void cU(int i) {
        int i2;
        int i3 = 255;
        if (this.mHeaderView != null && this.aIM != null) {
            switch (this.aIM.cV(i)) {
                case 0:
                    this.aIN = false;
                    return;
                case 1:
                    this.aIM.b(this.mHeaderView, i, 255);
                    if (this.mHeaderView.getTop() != 0) {
                        this.mHeaderView.layout(0, 0, this.aIO, this.aIP);
                    }
                    this.aIN = true;
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
                    this.aIM.b(this.mHeaderView, i, i3);
                    if (this.mHeaderView.getTop() != i2) {
                        this.mHeaderView.layout(0, i2, this.aIO, this.aIP + i2);
                    }
                    this.aIN = true;
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aIN) {
            drawChild(canvas, this.mHeaderView, getDrawingTime());
        }
    }
}
