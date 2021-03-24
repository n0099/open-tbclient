package com.baidu.swan.impl.map.location;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import d.b.g0.h.a.j.b;
import d.b.g0.h.a.j.c;
import java.util.List;
/* loaded from: classes3.dex */
public class LocationDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f12957a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f12958b;

    /* renamed from: c  reason: collision with root package name */
    public List<c> f12959c;

    /* renamed from: d  reason: collision with root package name */
    public b f12960d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12961e;

    /* renamed from: f  reason: collision with root package name */
    public String f12962f;

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, b bVar, boolean z) {
        this.f12958b = recyclerView;
        this.f12957a = context;
        this.f12960d = bVar;
        this.f12961e = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<c> list = this.f12959c;
        if (list == null) {
            return 0;
        }
        return list.size() + (this.f12961e ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.f12961e || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public final boolean m() {
        return !TextUtils.isEmpty(this.f12962f);
    }

    public final boolean n() {
        RecyclerView recyclerView = this.f12958b;
        return recyclerView != null && recyclerView.computeVerticalScrollOffset() > 0;
    }

    public void o() {
        for (c cVar : this.f12959c) {
            cVar.f48771b = false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder.getItemViewType() != 101) {
            ((LocationDetailViewHolder) viewHolder).c(this.f12959c.get(i), this.f12962f, m());
        } else {
            ((LocationFooterViewHolder) viewHolder).b(n());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 101) {
            return new LocationDetailViewHolder(LayoutInflater.from(this.f12957a).inflate(R.layout.ai_apps_location_item, viewGroup, false), this, this.f12960d);
        }
        return new LocationFooterViewHolder(LayoutInflater.from(this.f12957a).inflate(R.layout.ai_apps_location_footer, viewGroup, false));
    }

    public void p(List<c> list, String str) {
        if (list != null) {
            this.f12959c = list;
            this.f12962f = str;
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
