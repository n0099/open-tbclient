package com.baidu.swan.map.location;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import d.a.i0.j.f;
import d.a.i0.j.o.b;
import d.a.i0.j.o.c;
import java.util.List;
/* loaded from: classes3.dex */
public class LocationDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f11867a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f11868b;

    /* renamed from: c  reason: collision with root package name */
    public List<c> f11869c;

    /* renamed from: d  reason: collision with root package name */
    public b f11870d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11871e;

    /* renamed from: f  reason: collision with root package name */
    public String f11872f;

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, b bVar, boolean z) {
        this.f11868b = recyclerView;
        this.f11867a = context;
        this.f11870d = bVar;
        this.f11871e = z;
    }

    public final boolean c() {
        return !TextUtils.isEmpty(this.f11872f);
    }

    public final boolean d() {
        RecyclerView recyclerView = this.f11868b;
        return recyclerView != null && recyclerView.computeVerticalScrollOffset() > 0;
    }

    public void e() {
        for (c cVar : this.f11869c) {
            cVar.f47720b = false;
        }
    }

    public void f(List<c> list, String str) {
        if (list != null) {
            this.f11869c = list;
            this.f11872f = str;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<c> list = this.f11869c;
        if (list == null) {
            return 0;
        }
        return list.size() + (this.f11871e ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return (!this.f11871e || i2 < getItemCount() + (-1)) ? 100 : 101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() != 101) {
            ((LocationDetailViewHolder) viewHolder).c(this.f11869c.get(i2), this.f11872f, c());
        } else {
            ((LocationFooterViewHolder) viewHolder).b(d());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 != 101) {
            return new LocationDetailViewHolder(LayoutInflater.from(this.f11867a).inflate(f.ai_apps_location_item, viewGroup, false), this, this.f11870d);
        }
        return new LocationFooterViewHolder(LayoutInflater.from(this.f11867a).inflate(f.ai_apps_location_footer, viewGroup, false));
    }

    public void setData(List<c> list) {
        f(list, null);
    }

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, b bVar) {
        this(context, recyclerView, bVar, true);
    }
}
