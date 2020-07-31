package com.baidu.adp.widget.ListView;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes.dex */
public class ac extends RecyclerView.ItemDecoration {
    private int Wa;
    private int Wb;
    private int mEnd;

    public ac(int i, int i2, int i3) {
        this.Wa = i;
        this.Wb = i2;
        this.mEnd = i3;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (linearLayoutManager.getOrientation() == 1) {
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.top = this.Wa;
            } else {
                rect.top = this.Wb;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.bottom = this.mEnd;
                return;
            }
            return;
        }
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.left = this.Wa;
        } else {
            rect.left = this.Wb;
        }
        if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
            rect.right = this.mEnd;
        }
    }
}
