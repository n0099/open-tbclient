package com.baidu.swan.impl.map.location;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import d.b.h0.h.a.j.b;
import d.b.h0.h.a.j.c;
import java.util.List;
/* loaded from: classes3.dex */
public class LocationDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f12627a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f12628b;

    /* renamed from: c  reason: collision with root package name */
    public List<c> f12629c;

    /* renamed from: d  reason: collision with root package name */
    public b f12630d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12631e;

    /* renamed from: f  reason: collision with root package name */
    public String f12632f;

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, b bVar, boolean z) {
        this.f12628b = recyclerView;
        this.f12627a = context;
        this.f12630d = bVar;
        this.f12631e = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<c> list = this.f12629c;
        if (list == null) {
            return 0;
        }
        return list.size() + (this.f12631e ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.f12631e || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public final boolean m() {
        return !TextUtils.isEmpty(this.f12632f);
    }

    public final boolean n() {
        RecyclerView recyclerView = this.f12628b;
        return recyclerView != null && recyclerView.computeVerticalScrollOffset() > 0;
    }

    public void o() {
        for (c cVar : this.f12629c) {
            cVar.f49493b = false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder.getItemViewType() != 101) {
            ((LocationDetailViewHolder) viewHolder).c(this.f12629c.get(i), this.f12632f, m());
        } else {
            ((LocationFooterViewHolder) viewHolder).b(n());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 101) {
            return new LocationDetailViewHolder(LayoutInflater.from(this.f12627a).inflate(R.layout.ai_apps_location_item, viewGroup, false), this, this.f12630d);
        }
        return new LocationFooterViewHolder(LayoutInflater.from(this.f12627a).inflate(R.layout.ai_apps_location_footer, viewGroup, false));
    }

    public void p(List<c> list, String str) {
        if (list != null) {
            this.f12629c = list;
            this.f12632f = str;
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
