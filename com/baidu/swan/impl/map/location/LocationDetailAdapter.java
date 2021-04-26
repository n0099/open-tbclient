package com.baidu.swan.impl.map.location;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import d.a.h0.h.a.j.b;
import d.a.h0.h.a.j.c;
import java.util.List;
/* loaded from: classes3.dex */
public class LocationDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f12525a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f12526b;

    /* renamed from: c  reason: collision with root package name */
    public List<c> f12527c;

    /* renamed from: d  reason: collision with root package name */
    public b f12528d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12529e;

    /* renamed from: f  reason: collision with root package name */
    public String f12530f;

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, b bVar, boolean z) {
        this.f12526b = recyclerView;
        this.f12525a = context;
        this.f12528d = bVar;
        this.f12529e = z;
    }

    public final boolean c() {
        return !TextUtils.isEmpty(this.f12530f);
    }

    public final boolean d() {
        RecyclerView recyclerView = this.f12526b;
        return recyclerView != null && recyclerView.computeVerticalScrollOffset() > 0;
    }

    public void e() {
        for (c cVar : this.f12527c) {
            cVar.f46995b = false;
        }
    }

    public void f(List<c> list, String str) {
        if (list != null) {
            this.f12527c = list;
            this.f12530f = str;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<c> list = this.f12527c;
        if (list == null) {
            return 0;
        }
        return list.size() + (this.f12529e ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return (!this.f12529e || i2 < getItemCount() + (-1)) ? 100 : 101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() != 101) {
            ((LocationDetailViewHolder) viewHolder).c(this.f12527c.get(i2), this.f12530f, c());
        } else {
            ((LocationFooterViewHolder) viewHolder).b(d());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 != 101) {
            return new LocationDetailViewHolder(LayoutInflater.from(this.f12525a).inflate(R.layout.ai_apps_location_item, viewGroup, false), this, this.f12528d);
        }
        return new LocationFooterViewHolder(LayoutInflater.from(this.f12525a).inflate(R.layout.ai_apps_location_footer, viewGroup, false));
    }

    public void setData(List<c> list) {
        f(list, null);
    }

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, b bVar) {
        this(context, recyclerView, bVar, true);
    }
}
