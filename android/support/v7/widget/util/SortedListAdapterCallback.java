package android.support.v7.widget.util;

import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
/* loaded from: classes2.dex */
public abstract class SortedListAdapterCallback<T2> extends SortedList.Callback<T2> {
    final RecyclerView.Adapter Rm;

    public SortedListAdapterCallback(RecyclerView.Adapter adapter) {
        this.Rm = adapter;
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onInserted(int i, int i2) {
        this.Rm.notifyItemRangeInserted(i, i2);
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        this.Rm.notifyItemRangeRemoved(i, i2);
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onMoved(int i, int i2) {
        this.Rm.notifyItemMoved(i, i2);
    }

    @Override // android.support.v7.util.SortedList.Callback
    public void onChanged(int i, int i2) {
        this.Rm.notifyItemRangeChanged(i, i2);
    }
}
