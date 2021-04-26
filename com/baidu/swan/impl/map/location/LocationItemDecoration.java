package com.baidu.swan.impl.map.location;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import d.a.h0.a.c;
import d.a.h0.a.i2.h0;
/* loaded from: classes3.dex */
public class LocationItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: c  reason: collision with root package name */
    public static final int f12538c = h0.f(15.0f);

    /* renamed from: a  reason: collision with root package name */
    public ColorDrawable f12539a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f12540b;

    public LocationItemDecoration(Context context) {
        this(context, false);
    }

    public final void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft() + f12538c;
        int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - f12538c;
        int childCount = recyclerView.getChildCount();
        if (!this.f12540b) {
            childCount--;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            if (childAt != null) {
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
                this.f12539a.setBounds(paddingLeft, bottom, width, bottom + 1);
                this.f12539a.draw(canvas);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.set(0, 0, 0, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        drawVertical(canvas, recyclerView);
    }

    public LocationItemDecoration(Context context, boolean z) {
        this.f12540b = true;
        this.f12539a = new ColorDrawable(context.getResources().getColor(c.aiapps_location_item_bg_pressed));
        this.f12540b = z;
    }
}
