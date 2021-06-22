package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import d.a.m0.f.b;
import d.a.m0.f.c;
/* loaded from: classes3.dex */
public class ListRecommendDivider extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f11865a;

    /* renamed from: b  reason: collision with root package name */
    public int f11866b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f11867c;

    public ListRecommendDivider(@NonNull Context context) {
        Resources resources = context.getResources();
        this.f11865a = resources.getDimensionPixelSize(c.swangame_recommend_dialog_list_divider_height);
        this.f11866b = resources.getDimensionPixelSize(c.swangame_recommend_dialog_list_divider_margin);
        Paint paint = new Paint();
        this.f11867c = paint;
        paint.setColor(resources.getColor(b.swangame_recommend_dialog_list_divider));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.set(0, 0, 0, this.f11865a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int itemCount = recyclerView.getAdapter().getItemCount();
        for (int i2 = 0; i2 < itemCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            if (childAt != null && recyclerView.getChildAdapterPosition(childAt) != itemCount - 1) {
                canvas.drawRect(this.f11866b, childAt.getBottom(), childAt.getWidth() - this.f11866b, childAt.getBottom() + this.f11865a, this.f11867c);
            }
        }
    }
}
