package com.baidu.adp.widget.ListView;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f2385a;

    /* renamed from: b  reason: collision with root package name */
    public int f2386b;

    /* renamed from: c  reason: collision with root package name */
    public int f2387c;

    public GridSpaceItemDecoration(int i, int i2, int i3) {
        this.f2385a = i;
        this.f2386b = i2;
        this.f2387c = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        if (layoutParams.getSpanIndex() != -1) {
            if (layoutParams.getSpanIndex() % 2 == 0) {
                rect.left = this.f2385a;
                rect.right = this.f2386b;
                return;
            }
            rect.left = this.f2386b;
            rect.right = this.f2387c;
        }
    }
}
