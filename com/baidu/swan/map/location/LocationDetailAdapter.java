package com.baidu.swan.map.location;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import d.a.m0.j.f;
import d.a.m0.j.o.b;
import d.a.m0.j.o.c;
import java.util.List;
/* loaded from: classes3.dex */
public class LocationDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f11912a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f11913b;

    /* renamed from: c  reason: collision with root package name */
    public List<c> f11914c;

    /* renamed from: d  reason: collision with root package name */
    public b f11915d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11916e;

    /* renamed from: f  reason: collision with root package name */
    public String f11917f;

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, b bVar, boolean z) {
        this.f11913b = recyclerView;
        this.f11912a = context;
        this.f11915d = bVar;
        this.f11916e = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<c> list = this.f11914c;
        if (list == null) {
            return 0;
        }
        return list.size() + (this.f11916e ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return (!this.f11916e || i2 < getItemCount() + (-1)) ? 100 : 101;
    }

    public final boolean m() {
        return !TextUtils.isEmpty(this.f11917f);
    }

    public final boolean n() {
        RecyclerView recyclerView = this.f11913b;
        return recyclerView != null && recyclerView.computeVerticalScrollOffset() > 0;
    }

    public void o() {
        for (c cVar : this.f11914c) {
            cVar.f51678b = false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() != 101) {
            ((LocationDetailViewHolder) viewHolder).c(this.f11914c.get(i2), this.f11917f, m());
        } else {
            ((LocationFooterViewHolder) viewHolder).b(n());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 != 101) {
            return new LocationDetailViewHolder(LayoutInflater.from(this.f11912a).inflate(f.ai_apps_location_item, viewGroup, false), this, this.f11915d);
        }
        return new LocationFooterViewHolder(LayoutInflater.from(this.f11912a).inflate(f.ai_apps_location_footer, viewGroup, false));
    }

    public void p(List<c> list, String str) {
        if (list != null) {
            this.f11914c = list;
            this.f11917f = str;
            notifyDataSetChanged();
        }
    }

    public void setData(List<c> list) {
        p(list, null);
    }

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, b bVar) {
        this(context, recyclerView, bVar, true);
    }
}
