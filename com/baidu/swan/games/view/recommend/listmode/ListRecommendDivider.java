package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import d.b.g0.a.c;
import d.b.g0.a.d;
/* loaded from: classes3.dex */
public class ListRecommendDivider extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f12913a;

    /* renamed from: b  reason: collision with root package name */
    public int f12914b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f12915c;

    public ListRecommendDivider(@NonNull Context context) {
        Resources resources = context.getResources();
        this.f12913a = resources.getDimensionPixelSize(d.swangame_recommend_dialog_list_divider_height);
        this.f12914b = resources.getDimensionPixelSize(d.swangame_recommend_dialog_list_divider_margin);
        Paint paint = new Paint();
        this.f12915c = paint;
        paint.setColor(resources.getColor(c.swangame_recommend_dialog_list_divider));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.set(0, 0, 0, this.f12913a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int itemCount = recyclerView.getAdapter().getItemCount();
        for (int i = 0; i < itemCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (childAt != null && recyclerView.getChildAdapterPosition(childAt) != itemCount - 1) {
                canvas.drawRect(this.f12914b, childAt.getBottom(), childAt.getWidth() - this.f12914b, childAt.getBottom() + this.f12913a, this.f12915c);
            }
        }
    }
}
