package com.baidu.swan.impl.map.location;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
/* loaded from: classes9.dex */
public class LocationItemDecoration extends RecyclerView.ItemDecoration {
    private static final int esQ = ah.O(15.0f);
    private ColorDrawable esO;
    private boolean esP;

    public LocationItemDecoration(Context context) {
        this(context, false);
    }

    public LocationItemDecoration(Context context, boolean z) {
        this.esP = true;
        this.esO = new ColorDrawable(context.getResources().getColor(a.c.aiapps_location_item_bg_pressed));
        this.esP = z;
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft() + esQ;
        int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - esQ;
        int childCount = recyclerView.getChildCount();
        int i = this.esP ? childCount : childCount - 1;
        for (int i2 = 0; i2 < i; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            if (childAt != null) {
                int bottom = ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin + childAt.getBottom();
                this.esO.setBounds(paddingLeft, bottom, width, bottom + 1);
                this.esO.draw(canvas);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        drawVertical(canvas, recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.set(0, 0, 0, 1);
    }
}
