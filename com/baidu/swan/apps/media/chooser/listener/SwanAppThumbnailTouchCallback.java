package com.baidu.swan.apps.media.chooser.listener;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.media.chooser.adapter.SwanAppThumbnailAdapter;
import com.baidu.tieba.sv2;
import java.util.Collections;
/* loaded from: classes3.dex */
public class SwanAppThumbnailTouchCallback extends ItemTouchHelper.Callback {
    public sv2 a;
    public SwanAppThumbnailAdapter b;

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
    }

    public SwanAppThumbnailTouchCallback(sv2 sv2Var, SwanAppThumbnailAdapter swanAppThumbnailAdapter) {
        this.a = sv2Var;
        this.b = swanAppThumbnailAdapter;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (!recyclerView.isComputingLayout()) {
            viewHolder.itemView.setScaleX(1.0f);
            viewHolder.itemView.setScaleY(1.0f);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return ItemTouchHelper.Callback.makeMovementFlags(15, 0);
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
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        if (this.b.l() == null) {
            return false;
        }
        int adapterPosition = viewHolder.getAdapterPosition();
        int adapterPosition2 = viewHolder2.getAdapterPosition();
        SwanAppThumbnailAdapter swanAppThumbnailAdapter = this.b;
        if (swanAppThumbnailAdapter != null) {
            Collections.swap(swanAppThumbnailAdapter.l(), adapterPosition, adapterPosition2);
            this.b.notifyItemMoved(adapterPosition, adapterPosition2);
        }
        sv2 sv2Var = this.a;
        if (sv2Var != null) {
            sv2Var.onMove(adapterPosition, adapterPosition2);
            return true;
        }
        return true;
    }
}
