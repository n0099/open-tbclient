package com.baidu.adp.widget.ListView;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes.dex */
public class p extends RecyclerView.ItemDecoration {
    private int Wa;
    private int Wb;
    private int mEnd;

    public p(int i, int i2, int i3) {
        this.Wa = i;
        this.Wb = i2;
        this.mEnd = i3;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        if (layoutParams.getSpanIndex() != -1) {
            if (layoutParams.getSpanIndex() % 2 == 0) {
                rect.left = this.Wa;
                rect.right = this.Wb;
                return;
            }
            rect.left = this.Wb;
            rect.right = this.mEnd;
        }
    }
}
