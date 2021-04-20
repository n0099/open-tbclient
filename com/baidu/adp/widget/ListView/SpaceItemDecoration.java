package com.baidu.adp.widget.ListView;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f2395a;

    /* renamed from: b  reason: collision with root package name */
    public int f2396b;

    /* renamed from: c  reason: collision with root package name */
    public int f2397c;

    public SpaceItemDecoration(int i, int i2, int i3) {
        this.f2395a = i;
        this.f2396b = i2;
        this.f2397c = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (linearLayoutManager.getOrientation() == 1) {
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.top = this.f2395a;
            } else {
                rect.top = this.f2396b;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.bottom = this.f2397c;
                return;
            }
            return;
        }
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.left = this.f2395a;
        } else {
            rect.left = this.f2396b;
        }
        if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
            rect.right = this.f2397c;
        }
    }
}
