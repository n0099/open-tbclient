package com.baidu.adp.widget.ListView;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f2372a;

    /* renamed from: b  reason: collision with root package name */
    public int f2373b;

    /* renamed from: c  reason: collision with root package name */
    public int f2374c;

    public GridSpaceItemDecoration(int i2, int i3, int i4) {
        this.f2372a = i2;
        this.f2373b = i3;
        this.f2374c = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        if (layoutParams.getSpanIndex() != -1) {
            if (layoutParams.getSpanIndex() % 2 == 0) {
                rect.left = this.f2372a;
                rect.right = this.f2373b;
                return;
            }
            rect.left = this.f2373b;
            rect.right = this.f2374c;
        }
    }
}
