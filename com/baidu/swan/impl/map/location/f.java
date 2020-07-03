package com.baidu.swan.impl.map.location;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ag;
/* loaded from: classes12.dex */
public class f extends RecyclerView.ItemDecoration {
    private static final int MARGIN = ag.D(15.0f);
    private ColorDrawable dmb;
    private boolean dmc;

    public f(Context context) {
        this(context, false);
    }

    public f(Context context, boolean z) {
        this.dmc = true;
        this.dmb = new ColorDrawable(context.getResources().getColor(a.c.aiapps_location_item_bg_pressed));
        this.dmc = z;
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft() + MARGIN;
        int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - MARGIN;
        int childCount = recyclerView.getChildCount();
        int i = this.dmc ? childCount : childCount - 1;
        for (int i2 = 0; i2 < i; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            if (childAt != null) {
                int bottom = ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin + childAt.getBottom();
                this.dmb.setBounds(paddingLeft, bottom, width, bottom + 1);
                this.dmb.draw(canvas);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        drawVertical(canvas, recyclerView);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.set(0, 0, 0, 1);
    }
}
