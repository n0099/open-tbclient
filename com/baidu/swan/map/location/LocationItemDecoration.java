package com.baidu.swan.map.location;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import d.a.i0.a.c;
import d.a.i0.a.v2.n0;
/* loaded from: classes3.dex */
public class LocationItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: c  reason: collision with root package name */
    public static final int f11880c = n0.g(15.0f);

    /* renamed from: a  reason: collision with root package name */
    public ColorDrawable f11881a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f11882b;

    public LocationItemDecoration(Context context) {
        this(context, false);
    }

    public final void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft() + f11880c;
        int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - f11880c;
        int childCount = recyclerView.getChildCount();
        if (!this.f11882b) {
            childCount--;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            if (childAt != null) {
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
                this.f11881a.setBounds(paddingLeft, bottom, width, bottom + 1);
                this.f11881a.draw(canvas);
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
        this.f11882b = true;
        this.f11881a = new ColorDrawable(context.getResources().getColor(c.aiapps_location_item_bg_pressed));
        this.f11882b = z;
    }
}
