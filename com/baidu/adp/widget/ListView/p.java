package com.baidu.adp.widget.ListView;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes.dex */
public class p extends RecyclerView.ItemDecoration {
    private int Xk;
    private int Xl;
    private int mEnd;

    public p(int i, int i2, int i3) {
        this.Xk = i;
        this.Xl = i2;
        this.mEnd = i3;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        if (layoutParams.getSpanIndex() != -1) {
            if (layoutParams.getSpanIndex() % 2 == 0) {
                rect.left = this.Xk;
                rect.right = this.Xl;
                return;
            }
            rect.left = this.Xl;
            rect.right = this.mEnd;
        }
    }
}
