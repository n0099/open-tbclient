package com.baidu.swan.map.location;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.fd4;
import com.baidu.tieba.gd4;
import java.util.List;
/* loaded from: classes3.dex */
public class LocationDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context a;
    public RecyclerView b;
    public List<gd4> c;
    public fd4 d;
    public boolean e;
    public String f;

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, fd4 fd4Var) {
        this(context, recyclerView, fd4Var, true);
    }

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, fd4 fd4Var, boolean z) {
        this.b = recyclerView;
        this.a = context;
        this.d = fd4Var;
        this.e = z;
    }

    public final boolean d() {
        return !TextUtils.isEmpty(this.f);
    }

    public final boolean e() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null && recyclerView.computeVerticalScrollOffset() > 0) {
            return true;
        }
        return false;
    }

    public void f() {
        for (gd4 gd4Var : this.c) {
            gd4Var.b = false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<gd4> list = this.c;
        if (list == null) {
            return 0;
        }
        return list.size() + (this.e ? 1 : 0);
    }

    public void g(List<gd4> list, String str) {
        if (list != null) {
            this.c = list;
            this.f = str;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder.getItemViewType() != 101) {
            ((LocationDetailViewHolder) viewHolder).update(this.c.get(i), this.f, d());
        } else {
            ((LocationFooterViewHolder) viewHolder).b(e());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 101) {
            return new LocationDetailViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0089, viewGroup, false), this, this.d);
        }
        return new LocationFooterViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0088, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (!this.e || i < getItemCount() - 1) {
            return 100;
        }
        return 101;
    }

    public void setData(List<gd4> list) {
        g(list, null);
    }
}
