package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.a;
/* loaded from: classes9.dex */
public class ListRecommendDivider extends RecyclerView.ItemDecoration {
    private int eqg;
    private int mDividerHeight;
    private Paint mDividerPaint;

    public ListRecommendDivider(@NonNull Context context) {
        Resources resources = context.getResources();
        this.mDividerHeight = resources.getDimensionPixelSize(a.d.swangame_recommend_dialog_list_divider_height);
        this.eqg = resources.getDimensionPixelSize(a.d.swangame_recommend_dialog_list_divider_margin);
        this.mDividerPaint = new Paint();
        this.mDividerPaint.setColor(resources.getColor(a.c.swangame_recommend_dialog_list_divider));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.set(0, 0, 0, this.mDividerHeight);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int itemCount = recyclerView.getAdapter().getItemCount();
        for (int i = 0; i < itemCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (childAt != null && recyclerView.getChildAdapterPosition(childAt) != itemCount - 1) {
                canvas.drawRect(this.eqg, childAt.getBottom(), childAt.getWidth() - this.eqg, childAt.getBottom() + this.mDividerHeight, this.mDividerPaint);
            }
        }
    }
}
