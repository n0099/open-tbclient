package com.baidu.swan.map.location;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.pg4;
import com.baidu.tieba.qg4;
import java.util.List;
/* loaded from: classes4.dex */
public class LocationDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context a;
    public RecyclerView b;
    public List<qg4> c;
    public pg4 d;
    public boolean e;
    public String f;

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, pg4 pg4Var) {
        this(context, recyclerView, pg4Var, true);
    }

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, pg4 pg4Var, boolean z) {
        this.b = recyclerView;
        this.a = context;
        this.d = pg4Var;
        this.e = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<qg4> list = this.c;
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
        for (qg4 qg4Var : this.c) {
            qg4Var.b = false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (!this.e || i < getItemCount() - 1) {
            return 100;
        }
        return 101;
    }

    public void setData(List<qg4> list) {
        o(list, null);
    }

    public void o(List<qg4> list, String str) {
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
            return new LocationDetailViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d008c, viewGroup, false), this, this.d);
        }
        return new LocationFooterViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d008b, viewGroup, false));
    }
}
