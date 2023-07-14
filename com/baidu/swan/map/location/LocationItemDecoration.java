package com.baidu.swan.map.location;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.mp3;
/* loaded from: classes4.dex */
public class LocationItemDecoration extends RecyclerView.ItemDecoration {
    public static final int c = mp3.g(15.0f);
    public ColorDrawable a;
    public boolean b;

    public LocationItemDecoration(Context context) {
        this(context, false);
    }

    public LocationItemDecoration(Context context, boolean z) {
        this.b = true;
        this.a = new ColorDrawable(context.getResources().getColor(R.color.obfuscated_res_0x7f06043f));
        this.b = z;
    }

    public final void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft() + c;
        int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - c;
        int childCount = recyclerView.getChildCount();
        if (!this.b) {
            childCount--;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (childAt != null) {
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
                this.a.setBounds(paddingLeft, bottom, width, bottom + 1);
                this.a.draw(canvas);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
        rect.set(0, 0, 0, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        drawVertical(canvas, recyclerView);
    }
}
