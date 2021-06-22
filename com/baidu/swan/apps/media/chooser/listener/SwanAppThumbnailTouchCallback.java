package com.baidu.swan.apps.media.chooser.listener;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.media.chooser.adapter.SwanAppThumbnailAdapter;
import d.a.m0.a.i1.d.d.f;
import java.util.Collections;
/* loaded from: classes3.dex */
public class SwanAppThumbnailTouchCallback extends ItemTouchHelper.Callback {

    /* renamed from: a  reason: collision with root package name */
    public f f11063a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAppThumbnailAdapter f11064b;

    public SwanAppThumbnailTouchCallback(f fVar, SwanAppThumbnailAdapter swanAppThumbnailAdapter) {
        this.f11063a = fVar;
        this.f11064b = swanAppThumbnailAdapter;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (recyclerView.isComputingLayout()) {
            return;
        }
        viewHolder.itemView.setScaleX(1.0f);
        viewHolder.itemView.setScaleY(1.0f);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return ItemTouchHelper.Callback.makeMovementFlags(15, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        if (this.f11064b.m() == null) {
            return false;
        }
        int adapterPosition = viewHolder.getAdapterPosition();
        int adapterPosition2 = viewHolder2.getAdapterPosition();
        SwanAppThumbnailAdapter swanAppThumbnailAdapter = this.f11064b;
        if (swanAppThumbnailAdapter != null) {
            Collections.swap(swanAppThumbnailAdapter.m(), adapterPosition, adapterPosition2);
            this.f11064b.notifyItemMoved(adapterPosition, adapterPosition2);
        }
        f fVar = this.f11063a;
        if (fVar != null) {
            fVar.onMove(adapterPosition, adapterPosition2);
            return true;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i2) {
        super.onSelectedChanged(viewHolder, i2);
        if (i2 != 0) {
            viewHolder.itemView.setScaleX(1.2f);
            viewHolder.itemView.setScaleY(1.2f);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i2) {
    }
}
