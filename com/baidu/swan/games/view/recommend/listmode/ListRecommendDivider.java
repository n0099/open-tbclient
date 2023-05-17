package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ListRecommendDivider extends RecyclerView.ItemDecoration {
    public int a;
    public int b;
    public Paint c;

    public ListRecommendDivider(@NonNull Context context) {
        Resources resources = context.getResources();
        this.a = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070884);
        this.b = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070885);
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(resources.getColor(R.color.obfuscated_res_0x7f060b0c));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
        rect.set(0, 0, 0, this.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int itemCount = recyclerView.getAdapter().getItemCount();
        for (int i = 0; i < itemCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (childAt != null && recyclerView.getChildAdapterPosition(childAt) != itemCount - 1) {
                canvas.drawRect(this.b, childAt.getBottom(), childAt.getWidth() - this.b, childAt.getBottom() + this.a, this.c);
            }
        }
    }
}
