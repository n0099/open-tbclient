package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import d.b.g0.a.g;
import java.util.List;
/* loaded from: classes3.dex */
public class ListRecommendAdapter extends RecyclerView.Adapter<ListRecommendViewHolder> implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f12910e;

    /* renamed from: f  reason: collision with root package name */
    public a f12911f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.g.k0.i.e.a f12912g;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i);
    }

    public ListRecommendAdapter(@NonNull Context context) {
        this.f12910e = LayoutInflater.from(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(ListRecommendViewHolder listRecommendViewHolder, int i) {
        RecommendItemModel recommendItemModel = this.f12912g.f48303b.get(i);
        if (recommendItemModel != null) {
            listRecommendViewHolder.f12916a.setImageURI(recommendItemModel.iconUrl);
            listRecommendViewHolder.f12917b.setText(recommendItemModel.appName);
            listRecommendViewHolder.f12918c.setText(recommendItemModel.desc);
            listRecommendViewHolder.f12919d.setText(recommendItemModel.buttonText);
            listRecommendViewHolder.itemView.setTag(Integer.valueOf(i));
            listRecommendViewHolder.f12919d.setTag(Integer.valueOf(i));
            listRecommendViewHolder.itemView.setOnClickListener(this);
            listRecommendViewHolder.f12919d.setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public ListRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ListRecommendViewHolder(this.f12910e.inflate(g.swangame_recommend_dialog_item, viewGroup, false));
    }

    public void e(a aVar) {
        this.f12911f = aVar;
    }

    public void f(d.b.g0.g.k0.i.e.a aVar) {
        this.f12912g = aVar;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<RecommendItemModel> list;
        d.b.g0.g.k0.i.e.a aVar = this.f12912g;
        if (aVar == null || (list = aVar.f48303b) == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f12911f == null || view == null || !(view.getTag() instanceof Integer)) {
            return;
        }
        this.f12911f.a(((Integer) view.getTag()).intValue());
    }
}
