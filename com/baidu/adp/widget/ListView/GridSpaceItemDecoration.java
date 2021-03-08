package com.baidu.adp.widget.ListView;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int Zx;
    private int Zy;
    private int mEnd;

    public GridSpaceItemDecoration(int i, int i2, int i3) {
        this.Zx = i;
        this.Zy = i2;
        this.mEnd = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        if (layoutParams.getSpanIndex() != -1) {
            if (layoutParams.getSpanIndex() % 2 == 0) {
                rect.left = this.Zx;
                rect.right = this.Zy;
                return;
            }
            rect.left = this.Zy;
            rect.right = this.mEnd;
        }
    }
}
