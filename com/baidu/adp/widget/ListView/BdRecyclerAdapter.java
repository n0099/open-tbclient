package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.b.b.j.e.d;
import d.b.b.j.e.o;
/* loaded from: classes.dex */
public class BdRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements o {

    /* renamed from: e  reason: collision with root package name */
    public Context f2321e;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView.Adapter f2323g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f2324h;
    public BdRecyclerView.i j = null;
    public BdRecyclerView.j k = null;

    /* renamed from: f  reason: collision with root package name */
    public d f2322f = new d();
    public RecyclerView.AdapterDataObserver i = new a();

    /* loaded from: classes.dex */
    public class a extends RecyclerView.AdapterDataObserver {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            RecyclerView.AdapterDataObserver adapterDataObserver = BdRecyclerAdapter.this.f2324h;
            if (adapterDataObserver != null) {
                adapterDataObserver.onChanged();
            }
            if (BdRecyclerAdapter.this.f2322f.f42369c != null) {
                BdRecyclerAdapter.this.f2322f.f42369c.onPreLoad();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            RecyclerView.AdapterDataObserver adapterDataObserver = BdRecyclerAdapter.this.f2324h;
            if (adapterDataObserver != null) {
                adapterDataObserver.onItemRangeChanged(i, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            RecyclerView.AdapterDataObserver adapterDataObserver = BdRecyclerAdapter.this.f2324h;
            if (adapterDataObserver != null) {
                adapterDataObserver.onItemRangeInserted(i, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            RecyclerView.AdapterDataObserver adapterDataObserver = BdRecyclerAdapter.this.f2324h;
            if (adapterDataObserver != null) {
                adapterDataObserver.onItemRangeMoved(i, i2, i3);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            RecyclerView.AdapterDataObserver adapterDataObserver = BdRecyclerAdapter.this.f2324h;
            if (adapterDataObserver != null) {
                adapterDataObserver.onItemRangeRemoved(i, i2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f2326e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2327f;

        public b(RecyclerView.ViewHolder viewHolder, ViewGroup viewGroup) {
            this.f2326e = viewHolder;
            this.f2327f = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BdRecyclerAdapter.this.j != null) {
                int adapterPosition = this.f2326e.getAdapterPosition();
                BdRecyclerAdapter.this.j.c(this.f2327f, this.f2326e.itemView, BdRecyclerAdapter.this.getItem(adapterPosition), adapterPosition, BdRecyclerAdapter.this.getItemId(adapterPosition));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f2329e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2330f;

        public c(RecyclerView.ViewHolder viewHolder, ViewGroup viewGroup) {
            this.f2329e = viewHolder;
            this.f2330f = viewGroup;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (BdRecyclerAdapter.this.k != null) {
                int adapterPosition = this.f2329e.getAdapterPosition();
                return BdRecyclerAdapter.this.k.a(this.f2330f, this.f2329e.itemView, BdRecyclerAdapter.this.getItem(adapterPosition), adapterPosition, BdRecyclerAdapter.this.getItemId(adapterPosition));
            }
            return false;
        }
    }

    public BdRecyclerAdapter(Context context) {
        this.f2321e = null;
        this.f2321e = context;
    }

    public void g(View view) {
        h(view, null, true, -1);
    }

    @Override // d.b.b.j.e.o
    public int getCount() {
        return getItemCount();
    }

    @Override // d.b.b.j.e.o
    public Object getItem(int i) {
        if (i < 0) {
            return null;
        }
        int o = o();
        if (i < o) {
            return this.f2322f.f42367a.get(i).f42373d;
        }
        int i2 = i - o;
        int i3 = 0;
        RecyclerView.Adapter adapter = this.f2323g;
        if (adapter != null && i2 < (i3 = adapter.getItemCount())) {
            RecyclerView.Adapter adapter2 = this.f2323g;
            if (adapter2 instanceof o) {
                return ((o) adapter2).getItem(i2);
            }
        }
        int n = n();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= n) {
            return null;
        }
        return this.f2322f.f42368b.get(i4).f42373d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int n;
        int o;
        if (this.f2323g != null) {
            n = n() + o();
            o = this.f2323g.getItemCount();
        } else {
            n = n();
            o = o();
        }
        return n + o;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        if (i < 0) {
            return -1L;
        }
        int o = o();
        if (i < o) {
            return this.f2322f.f42367a.get(i).f42370a;
        }
        int i2 = 0;
        RecyclerView.Adapter adapter = this.f2323g;
        if (adapter != null && i >= o) {
            int i3 = i - o;
            int itemCount = adapter.getItemCount();
            if (i3 < itemCount) {
                return this.f2323g.getItemId(i3);
            }
            i2 = itemCount;
        }
        int i4 = (i - o) - i2;
        if (i4 <= -1 || i4 >= n()) {
            return -1L;
        }
        return this.f2322f.f42368b.get(i4).f42370a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i < 0) {
            return -1;
        }
        int o = o();
        if (i < o) {
            return this.f2322f.f42367a.get(i).f42371b;
        }
        int i2 = i - o;
        int i3 = 0;
        RecyclerView.Adapter adapter = this.f2323g;
        if (adapter != null && i2 < (i3 = adapter.getItemCount())) {
            return this.f2323g.getItemViewType(i2);
        }
        int n = n();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= n) {
            return -1;
        }
        return this.f2322f.f42368b.get(i4).f42371b;
    }

    public void h(View view, Object obj, boolean z, int i) {
        if (view == null) {
            return;
        }
        this.f2322f.a(view, obj, z, true, i);
        notifyDataSetChanged();
    }

    public void i(View view, int i) {
        j(view, null, true, true, i);
    }

    public void j(View view, Object obj, boolean z, boolean z2, int i) {
        if (view == null) {
            return;
        }
        this.f2322f.b(view, obj, z, z2, i);
        notifyDataSetChanged();
    }

    public final void k(ViewGroup viewGroup, RecyclerView.ViewHolder viewHolder) {
        View view;
        if (viewGroup == null || viewHolder == null || (view = viewHolder.itemView) == null) {
            return;
        }
        view.setOnClickListener(new b(viewHolder, viewGroup));
        viewHolder.itemView.setOnLongClickListener(new c(viewHolder, viewGroup));
    }

    public d.c l(int i) {
        return this.f2322f.e(i);
    }

    public d.c m(int i) {
        return this.f2322f.g(i);
    }

    public int n() {
        return this.f2322f.h();
    }

    public int o() {
        return this.f2322f.i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.Adapter adapter = this.f2323g;
        if (adapter != null) {
            adapter.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        if (i < 0 || getItemViewType(i) == -1 || (viewHolder instanceof d.b)) {
            return;
        }
        int o = o();
        RecyclerView.Adapter adapter = this.f2323g;
        if (adapter == null || i < o || (i2 = i - o) >= adapter.getItemCount()) {
            return;
        }
        this.f2323g.onBindViewHolder(viewHolder, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        TypeAdapter.ViewHolder viewHolder;
        boolean z;
        RecyclerView.Adapter adapter;
        d.c m = m(i);
        boolean z2 = true;
        if (m != null) {
            viewHolder = m.f42372c;
            z = m.f42374e;
        } else {
            viewHolder = null;
            z = true;
        }
        if (viewHolder == null) {
            d.c l = l(i);
            TypeAdapter.ViewHolder viewHolder2 = l != null ? l.f42372c : null;
            if (l != null && !l.f42374e) {
                z2 = false;
            }
            z = z2;
            viewHolder = viewHolder2;
        }
        if (viewHolder == null && (adapter = this.f2323g) != null) {
            viewHolder = adapter.onCreateViewHolder(viewGroup, i);
        }
        if (viewHolder == null) {
            viewHolder = this.f2322f.c(this.f2321e);
        }
        if (z) {
            k(viewGroup, viewHolder);
        }
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        RecyclerView.Adapter adapter = this.f2323g;
        if (adapter != null) {
            adapter.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.Adapter adapter = this.f2323g;
        if (adapter != null) {
            return adapter.onFailedToRecycleView(viewHolder);
        }
        return super.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        RecyclerView.Adapter adapter = this.f2323g;
        if (adapter != null) {
            adapter.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        RecyclerView.Adapter adapter = this.f2323g;
        if (adapter != null) {
            adapter.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        RecyclerView.Adapter adapter = this.f2323g;
        if (adapter != null) {
            adapter.onViewRecycled(viewHolder);
        }
    }

    public RecyclerView.Adapter p() {
        return this.f2323g;
    }

    public boolean q(View view) {
        if (this.f2322f.j(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public boolean r(View view) {
        if (this.f2322f.k(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.f2324h = adapterDataObserver;
        RecyclerView.Adapter adapter = this.f2323g;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.i);
        }
    }

    public void s(RecyclerView.Adapter adapter) {
        this.f2323g = adapter;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        RecyclerView.Adapter adapter = this.f2323g;
        if (adapter != null) {
            adapter.setHasStableIds(z);
        }
        super.setHasStableIds(z);
    }

    public void u(View view, Object obj, boolean z, boolean z2, int i) {
        if (view == null) {
            return;
        }
        int d2 = this.f2322f.d(view);
        if (d2 < 0) {
            this.f2322f.a(view, obj, z, z2, i);
            notifyDataSetChanged();
        } else if (d2 != i) {
            this.f2322f.j(view);
            this.f2322f.a(view, obj, z, z2, i);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.f2324h = adapterDataObserver;
        RecyclerView.Adapter adapter = this.f2323g;
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.i);
        }
    }

    public void v(View view, Object obj, boolean z, boolean z2, int i) {
        if (view == null) {
            return;
        }
        int f2 = this.f2322f.f(view);
        if (f2 < 0) {
            this.f2322f.b(view, obj, z, z2, i);
            notifyDataSetChanged();
        } else if (f2 != i) {
            this.f2322f.k(view);
            this.f2322f.b(view, obj, z, z2, i);
            notifyDataSetChanged();
        }
    }

    public void w(d.a aVar) {
        this.f2322f.l(aVar);
    }

    public void x(BdRecyclerView.i iVar) {
        this.j = iVar;
    }

    public void y(BdRecyclerView.j jVar) {
        this.k = jVar;
    }
}
