package com.baidu.swan.map.location;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.hh4;
import com.baidu.tieba.ih4;
import java.util.List;
/* loaded from: classes4.dex */
public class LocationDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context a;
    public RecyclerView b;
    public List<ih4> c;
    public hh4 d;
    public boolean e;
    public String f;

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, hh4 hh4Var) {
        this(context, recyclerView, hh4Var, true);
    }

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, hh4 hh4Var, boolean z) {
        this.b = recyclerView;
        this.a = context;
        this.d = hh4Var;
        this.e = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ih4> list = this.c;
        if (list == null) {
            return 0;
        }
        return list.size() + (this.e ? 1 : 0);
    }

    public final boolean l() {
        return !TextUtils.isEmpty(this.f);
    }

    public final boolean m() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null && recyclerView.computeVerticalScrollOffset() > 0) {
            return true;
        }
        return false;
    }

    public void n() {
        for (ih4 ih4Var : this.c) {
            ih4Var.b = false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (!this.e || i < getItemCount() - 1) {
            return 100;
        }
        return 101;
    }

    public void setData(List<ih4> list) {
        o(list, null);
    }

    public void o(List<ih4> list, String str) {
        if (list != null) {
            this.c = list;
            this.f = str;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder.getItemViewType() != 101) {
            ((LocationDetailViewHolder) viewHolder).update(this.c.get(i), this.f, l());
        } else {
            ((LocationFooterViewHolder) viewHolder).c(m());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 101) {
            return new LocationDetailViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d008a, viewGroup, false), this, this.d);
        }
        return new LocationFooterViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0089, viewGroup, false));
    }
}
