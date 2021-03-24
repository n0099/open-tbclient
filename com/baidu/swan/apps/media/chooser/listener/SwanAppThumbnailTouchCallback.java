package com.baidu.swan.apps.media.chooser.listener;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.media.chooser.adapter.SwanAppThumbnailAdapter;
import d.b.g0.a.b1.d.d.f;
import java.util.Collections;
/* loaded from: classes3.dex */
public class SwanAppThumbnailTouchCallback extends ItemTouchHelper.Callback {

    /* renamed from: a  reason: collision with root package name */
    public f f12337a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAppThumbnailAdapter f12338b;

    public SwanAppThumbnailTouchCallback(f fVar, SwanAppThumbnailAdapter swanAppThumbnailAdapter) {
        this.f12337a = fVar;
        this.f12338b = swanAppThumbnailAdapter;
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
        if (this.f12338b.m() == null) {
            return false;
        }
        int adapterPosition = viewHolder.getAdapterPosition();
        int adapterPosition2 = viewHolder2.getAdapterPosition();
        SwanAppThumbnailAdapter swanAppThumbnailAdapter = this.f12338b;
        if (swanAppThumbnailAdapter != null) {
            Collections.swap(swanAppThumbnailAdapter.m(), adapterPosition, adapterPosition2);
            this.f12338b.notifyItemMoved(adapterPosition, adapterPosition2);
        }
        f fVar = this.f12337a;
        if (fVar != null) {
            fVar.onMove(adapterPosition, adapterPosition2);
            return true;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        super.onSelectedChanged(viewHolder, i);
        if (i != 0) {
            viewHolder.itemView.setScaleX(1.2f);
            viewHolder.itemView.setScaleY(1.2f);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
    }
}
