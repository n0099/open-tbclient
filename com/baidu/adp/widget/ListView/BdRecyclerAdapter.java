package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.a.c.k.e.d;
import d.a.c.k.e.o;
/* loaded from: classes.dex */
public class BdRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements o {

    /* renamed from: e  reason: collision with root package name */
    public Context f2360e;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView.Adapter f2362g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f2363h;
    public BdRecyclerView.i j = null;
    public BdRecyclerView.j k = null;

    /* renamed from: f  reason: collision with root package name */
    public d f2361f = new d();

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f2364i = new a();

    /* loaded from: classes.dex */
    public class a extends RecyclerView.AdapterDataObserver {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            RecyclerView.AdapterDataObserver adapterDataObserver = BdRecyclerAdapter.this.f2363h;
            if (adapterDataObserver != null) {
                adapterDataObserver.onChanged();
            }
            if (BdRecyclerAdapter.this.f2361f.f42922c != null) {
                BdRecyclerAdapter.this.f2361f.f42922c.onPreLoad();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3) {
            super.onItemRangeChanged(i2, i3);
            RecyclerView.AdapterDataObserver adapterDataObserver = BdRecyclerAdapter.this.f2363h;
            if (adapterDataObserver != null) {
                adapterDataObserver.onItemRangeChanged(i2, i3);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i2, int i3) {
            super.onItemRangeInserted(i2, i3);
            RecyclerView.AdapterDataObserver adapterDataObserver = BdRecyclerAdapter.this.f2363h;
            if (adapterDataObserver != null) {
                adapterDataObserver.onItemRangeInserted(i2, i3);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i2, int i3, int i4) {
            super.onItemRangeMoved(i2, i3, i4);
            RecyclerView.AdapterDataObserver adapterDataObserver = BdRecyclerAdapter.this.f2363h;
            if (adapterDataObserver != null) {
                adapterDataObserver.onItemRangeMoved(i2, i3, i4);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i2, int i3) {
            super.onItemRangeRemoved(i2, i3);
            RecyclerView.AdapterDataObserver adapterDataObserver = BdRecyclerAdapter.this.f2363h;
            if (adapterDataObserver != null) {
                adapterDataObserver.onItemRangeRemoved(i2, i3);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f2366e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2367f;

        public b(RecyclerView.ViewHolder viewHolder, ViewGroup viewGroup) {
            this.f2366e = viewHolder;
            this.f2367f = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BdRecyclerAdapter.this.j != null) {
                int adapterPosition = this.f2366e.getAdapterPosition();
                BdRecyclerAdapter.this.j.b(this.f2367f, this.f2366e.itemView, BdRecyclerAdapter.this.getItem(adapterPosition), adapterPosition, BdRecyclerAdapter.this.getItemId(adapterPosition));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f2369e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2370f;

        public c(RecyclerView.ViewHolder viewHolder, ViewGroup viewGroup) {
            this.f2369e = viewHolder;
            this.f2370f = viewGroup;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (BdRecyclerAdapter.this.k != null) {
                int adapterPosition = this.f2369e.getAdapterPosition();
                return BdRecyclerAdapter.this.k.a(this.f2370f, this.f2369e.itemView, BdRecyclerAdapter.this.getItem(adapterPosition), adapterPosition, BdRecyclerAdapter.this.getItemId(adapterPosition));
            }
            return false;
        }
    }

    public BdRecyclerAdapter(Context context) {
        this.f2360e = null;
        this.f2360e = context;
    }

    public void g(View view) {
        h(view, null, true, -1);
    }

    @Override // d.a.c.k.e.o
    public int getCount() {
        return getItemCount();
    }

    @Override // d.a.c.k.e.o
    public Object getItem(int i2) {
        if (i2 < 0) {
            return null;
        }
        int o = o();
        if (i2 < o) {
            return this.f2361f.f42920a.get(i2).f42926d;
        }
        int i3 = i2 - o;
        int i4 = 0;
        RecyclerView.Adapter adapter = this.f2362g;
        if (adapter != null && i3 < (i4 = adapter.getItemCount())) {
            RecyclerView.Adapter adapter2 = this.f2362g;
            if (adapter2 instanceof o) {
                return ((o) adapter2).getItem(i3);
            }
        }
        int n = n();
        int i5 = i3 - i4;
        if (i5 < 0 || i5 >= n) {
            return null;
        }
        return this.f2361f.f42921b.get(i5).f42926d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int n;
        int o;
        if (this.f2362g != null) {
            n = n() + o();
            o = this.f2362g.getItemCount();
        } else {
            n = n();
            o = o();
        }
        return n + o;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        if (i2 < 0) {
            return -1L;
        }
        int o = o();
        if (i2 < o) {
            return this.f2361f.f42920a.get(i2).f42923a;
        }
        int i3 = 0;
        RecyclerView.Adapter adapter = this.f2362g;
        if (adapter != null && i2 >= o) {
            int i4 = i2 - o;
            int itemCount = adapter.getItemCount();
            if (i4 < itemCount) {
                return this.f2362g.getItemId(i4);
            }
            i3 = itemCount;
        }
        int i5 = (i2 - o) - i3;
        if (i5 <= -1 || i5 >= n()) {
            return -1L;
        }
        return this.f2361f.f42921b.get(i5).f42923a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int o = o();
        if (i2 < o) {
            return this.f2361f.f42920a.get(i2).f42924b;
        }
        int i3 = i2 - o;
        int i4 = 0;
        RecyclerView.Adapter adapter = this.f2362g;
        if (adapter != null && i3 < (i4 = adapter.getItemCount())) {
            return this.f2362g.getItemViewType(i3);
        }
        int n = n();
        int i5 = i3 - i4;
        if (i5 < 0 || i5 >= n) {
            return -1;
        }
        return this.f2361f.f42921b.get(i5).f42924b;
    }

    public void h(View view, Object obj, boolean z, int i2) {
        if (view == null) {
            return;
        }
        this.f2361f.a(view, obj, z, true, i2);
        notifyDataSetChanged();
    }

    public void i(View view, int i2) {
        j(view, null, true, true, i2);
    }

    public void j(View view, Object obj, boolean z, boolean z2, int i2) {
        if (view == null) {
            return;
        }
        this.f2361f.b(view, obj, z, z2, i2);
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

    public d.c l(int i2) {
        return this.f2361f.e(i2);
    }

    public d.c m(int i2) {
        return this.f2361f.g(i2);
    }

    public int n() {
        return this.f2361f.h();
    }

    public int o() {
        return this.f2361f.i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.Adapter adapter = this.f2362g;
        if (adapter != null) {
            adapter.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        int i3;
        if (i2 < 0 || getItemViewType(i2) == -1 || (viewHolder instanceof d.b)) {
            return;
        }
        int o = o();
        RecyclerView.Adapter adapter = this.f2362g;
        if (adapter == null || i2 < o || (i3 = i2 - o) >= adapter.getItemCount()) {
            return;
        }
        this.f2362g.onBindViewHolder(viewHolder, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        TypeAdapter.ViewHolder viewHolder;
        boolean z;
        RecyclerView.Adapter adapter;
        d.c m = m(i2);
        boolean z2 = true;
        if (m != null) {
            viewHolder = m.f42925c;
            z = m.f42927e;
        } else {
            viewHolder = null;
            z = true;
        }
        if (viewHolder == null) {
            d.c l = l(i2);
            TypeAdapter.ViewHolder viewHolder2 = l != null ? l.f42925c : null;
            if (l != null && !l.f42927e) {
                z2 = false;
            }
            z = z2;
            viewHolder = viewHolder2;
        }
        if (viewHolder == null && (adapter = this.f2362g) != null) {
            viewHolder = adapter.onCreateViewHolder(viewGroup, i2);
        }
        if (viewHolder == null) {
            viewHolder = this.f2361f.c(this.f2360e);
        }
        if (z) {
            k(viewGroup, viewHolder);
        }
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        RecyclerView.Adapter adapter = this.f2362g;
        if (adapter != null) {
            adapter.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.Adapter adapter = this.f2362g;
        if (adapter != null) {
            return adapter.onFailedToRecycleView(viewHolder);
        }
        return super.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        RecyclerView.Adapter adapter = this.f2362g;
        if (adapter != null) {
            adapter.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        RecyclerView.Adapter adapter = this.f2362g;
        if (adapter != null) {
            adapter.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        RecyclerView.Adapter adapter = this.f2362g;
        if (adapter != null) {
            adapter.onViewRecycled(viewHolder);
        }
    }

    public RecyclerView.Adapter p() {
        return this.f2362g;
    }

    public boolean q(View view) {
        if (this.f2361f.j(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public boolean r(View view) {
        if (this.f2361f.k(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.f2363h = adapterDataObserver;
        RecyclerView.Adapter adapter = this.f2362g;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f2364i);
        }
    }

    public void s(RecyclerView.Adapter adapter) {
        this.f2362g = adapter;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        RecyclerView.Adapter adapter = this.f2362g;
        if (adapter != null) {
            adapter.setHasStableIds(z);
        }
        super.setHasStableIds(z);
    }

    public void t(View view, Object obj, boolean z, boolean z2, int i2) {
        if (view == null) {
            return;
        }
        int d2 = this.f2361f.d(view);
        if (d2 < 0) {
            this.f2361f.a(view, obj, z, z2, i2);
            notifyDataSetChanged();
        } else if (d2 != i2) {
            this.f2361f.j(view);
            this.f2361f.a(view, obj, z, z2, i2);
            notifyDataSetChanged();
        }
    }

    public void u(View view, Object obj, boolean z, boolean z2, int i2) {
        if (view == null) {
            return;
        }
        int f2 = this.f2361f.f(view);
        if (f2 < 0) {
            this.f2361f.b(view, obj, z, z2, i2);
            notifyDataSetChanged();
        } else if (f2 != i2) {
            this.f2361f.k(view);
            this.f2361f.b(view, obj, z, z2, i2);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.f2363h = adapterDataObserver;
        RecyclerView.Adapter adapter = this.f2362g;
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f2364i);
        }
    }

    public void v(d.a aVar) {
        this.f2361f.l(aVar);
    }

    public void w(BdRecyclerView.i iVar) {
        this.j = iVar;
    }

    public void x(BdRecyclerView.j jVar) {
        this.k = jVar;
    }
}
