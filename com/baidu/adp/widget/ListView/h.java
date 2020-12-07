package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.e;
/* loaded from: classes.dex */
public class h extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements r {
    private RecyclerView.Adapter Xh;
    RecyclerView.AdapterDataObserver Xi;
    private Context mContext;
    private BdRecyclerView.a Xk = null;
    private BdRecyclerView.b Xl = null;
    private e Xg = new e();
    RecyclerView.AdapterDataObserver Xj = new RecyclerView.AdapterDataObserver() { // from class: com.baidu.adp.widget.ListView.h.1
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            if (h.this.Xi != null) {
                h.this.Xi.onChanged();
            }
            if (h.this.Xg.WF != null) {
                h.this.Xg.WF.onPreLoad();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            if (h.this.Xi != null) {
                h.this.Xi.onItemRangeChanged(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            if (h.this.Xi != null) {
                h.this.Xi.onItemRangeInserted(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            if (h.this.Xi != null) {
                h.this.Xi.onItemRangeRemoved(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            if (h.this.Xi != null) {
                h.this.Xi.onItemRangeMoved(i, i2, i3);
            }
        }
    };

    public h(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i < 0) {
            return -1;
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.Xg.mHeaderViewInfos.get(i).type;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.Xh != null && i2 < (i3 = this.Xh.getItemCount())) {
            return this.Xh.getItemViewType(i2);
        }
        int footersCount = getFootersCount();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= footersCount) {
            return -1;
        }
        return this.Xg.mFooterViewInfos.get(i4).type;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        boolean z;
        af.a aVar;
        af.a aVar2;
        boolean z2 = true;
        e.c aT = aT(i);
        if (aT != null) {
            aVar = aT.WH;
            z = aT.WI;
        } else {
            z = true;
            aVar = null;
        }
        if (aVar == null) {
            e.c aU = aU(i);
            af.a aVar3 = aU != null ? aU.WH : null;
            if (aU != null && !aU.WI) {
                z2 = false;
            }
            boolean z3 = z2;
            aVar2 = aVar3;
            z = z3;
        } else {
            aVar2 = aVar;
        }
        if (aVar2 == null && this.Xh != null) {
            aVar2 = this.Xh.onCreateViewHolder(viewGroup, i);
        }
        if (aVar2 == null) {
            aVar2 = this.Xg.L(this.mContext);
        }
        if (z) {
            a(viewGroup, aVar2);
        }
        return aVar2;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (i >= 0 && getItemViewType(i) != -1 && !(viewHolder instanceof e.b)) {
            int headersCount = getHeadersCount();
            if (this.Xh != null && i >= headersCount && i - headersCount < this.Xh.getItemCount()) {
                this.Xh.onBindViewHolder(viewHolder, i - headersCount);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.Xh != null ? getFootersCount() + getHeadersCount() + this.Xh.getItemCount() : getFootersCount() + getHeadersCount();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        if (this.Xh != null) {
            this.Xh.setHasStableIds(z);
        }
        super.setHasStableIds(z);
    }

    @Override // com.baidu.adp.widget.ListView.r
    public int getCount() {
        return getItemCount();
    }

    @Override // com.baidu.adp.widget.ListView.r
    public Object getItem(int i) {
        if (i < 0) {
            return null;
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.Xg.mHeaderViewInfos.get(i).data;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.Xh != null && i2 < (i3 = this.Xh.getItemCount()) && (this.Xh instanceof r)) {
            return ((r) this.Xh).getItem(i2);
        }
        int footersCount = getFootersCount();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= footersCount) {
            return null;
        }
        return this.Xg.mFooterViewInfos.get(i4).data;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        int i2;
        if (i < 0) {
            return -1L;
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.Xg.mHeaderViewInfos.get(i).id;
        }
        int i3 = 0;
        if (this.Xh != null && i >= headersCount && (i2 = i - headersCount) < (i3 = this.Xh.getItemCount())) {
            return this.Xh.getItemId(i2);
        }
        int i4 = (i - headersCount) - i3;
        if (i4 <= -1 || i4 >= getFootersCount()) {
            return -1L;
        }
        return this.Xg.mFooterViewInfos.get(i4).id;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        if (this.Xh != null) {
            this.Xh.onViewRecycled(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return this.Xh != null ? this.Xh.onFailedToRecycleView(viewHolder) : super.onFailedToRecycleView(viewHolder);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (this.Xh != null) {
            this.Xh.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        if (this.Xh != null) {
            this.Xh.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.Xh != null) {
            this.Xh.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.Xh != null) {
            this.Xh.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.Xi = adapterDataObserver;
        if (this.Xh != null) {
            this.Xh.registerAdapterDataObserver(this.Xj);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.Xi = adapterDataObserver;
        if (this.Xh != null) {
            this.Xh.unregisterAdapterDataObserver(this.Xj);
        }
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.Xh = adapter;
        notifyDataSetChanged();
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        return this.Xh;
    }

    public void a(e.a aVar) {
        this.Xg.a(aVar);
    }

    public int getHeadersCount() {
        return this.Xg.getHeadersCount();
    }

    public int getFootersCount() {
        return this.Xg.getFootersCount();
    }

    public boolean removeHeader(View view) {
        if (this.Xg.removeHeader(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public boolean removeFooter(View view) {
        if (this.Xg.removeFooter(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public void c(View view, Object obj, boolean z, boolean z2, int i) {
        if (view != null) {
            int z3 = this.Xg.z(view);
            if (z3 < 0) {
                this.Xg.a(view, obj, z, z2, i);
                notifyDataSetChanged();
            } else if (z3 != i) {
                this.Xg.removeHeader(view);
                this.Xg.a(view, obj, z, z2, i);
                notifyDataSetChanged();
            }
        }
    }

    public void d(View view, Object obj, boolean z, boolean z2, int i) {
        if (view != null) {
            int A = this.Xg.A(view);
            if (A < 0) {
                this.Xg.b(view, obj, z, z2, i);
                notifyDataSetChanged();
            } else if (A != i) {
                this.Xg.removeFooter(view);
                this.Xg.b(view, obj, z, z2, i);
                notifyDataSetChanged();
            }
        }
    }

    public void addHeaderView(View view, int i) {
        a(view, null, true, true, i);
    }

    public void a(View view, Object obj, boolean z, boolean z2, int i) {
        if (view != null) {
            this.Xg.a(view, obj, z, z2, i);
            notifyDataSetChanged();
        }
    }

    public void addFooterView(View view) {
        addFooterView(view, null, true, -1);
    }

    public void addFooterView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            this.Xg.b(view, obj, z, true, i);
            notifyDataSetChanged();
        }
    }

    public e.c aT(int i) {
        return this.Xg.aR(i);
    }

    public e.c aU(int i) {
        return this.Xg.aS(i);
    }

    private void a(final ViewGroup viewGroup, final RecyclerView.ViewHolder viewHolder) {
        if (viewGroup != null && viewHolder != null && viewHolder.itemView != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.adp.widget.ListView.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.Xk != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        h.this.Xk.a(viewGroup, viewHolder.itemView, h.this.getItem(adapterPosition), adapterPosition, h.this.getItemId(adapterPosition));
                    }
                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.adp.widget.ListView.h.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (h.this.Xl != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        return h.this.Xl.b(viewGroup, viewHolder.itemView, h.this.getItem(adapterPosition), adapterPosition, h.this.getItemId(adapterPosition));
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemClickListener(BdRecyclerView.a aVar) {
        this.Xk = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemLongClickListener(BdRecyclerView.b bVar) {
        this.Xl = bVar;
    }
}
