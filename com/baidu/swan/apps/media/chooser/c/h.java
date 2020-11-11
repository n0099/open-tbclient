package com.baidu.swan.apps.media.chooser.c;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import java.util.Collections;
/* loaded from: classes10.dex */
public class h extends ItemTouchHelper.Callback {
    private g ddC;
    private com.baidu.swan.apps.media.chooser.adapter.c ddD;

    public h(g gVar, com.baidu.swan.apps.media.chooser.adapter.c cVar) {
        this.ddC = gVar;
        this.ddD = cVar;
    }

    @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(15, 0);
    }

    @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        if (this.ddD.aAS() == null) {
            return false;
        }
        int adapterPosition = viewHolder.getAdapterPosition();
        int adapterPosition2 = viewHolder2.getAdapterPosition();
        if (this.ddD != null) {
            Collections.swap(this.ddD.aAS(), adapterPosition, adapterPosition2);
            this.ddD.notifyItemMoved(adapterPosition, adapterPosition2);
        }
        if (this.ddC != null) {
            this.ddC.an(adapterPosition, adapterPosition2);
        }
        return true;
    }

    @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
    }

    @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        super.onSelectedChanged(viewHolder, i);
        if (i != 0) {
            viewHolder.itemView.setScaleX(1.2f);
            viewHolder.itemView.setScaleY(1.2f);
        }
    }

    @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (!recyclerView.isComputingLayout()) {
            viewHolder.itemView.setScaleX(1.0f);
            viewHolder.itemView.setScaleY(1.0f);
        }
    }

    @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }
}
