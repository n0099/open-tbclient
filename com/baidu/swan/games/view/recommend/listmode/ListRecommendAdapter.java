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
    public LayoutInflater f12571e;

    /* renamed from: f  reason: collision with root package name */
    public a f12572f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.g.k0.i.e.a f12573g;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i);
    }

    public ListRecommendAdapter(@NonNull Context context) {
        this.f12571e = LayoutInflater.from(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(ListRecommendViewHolder listRecommendViewHolder, int i) {
        RecommendItemModel recommendItemModel = this.f12573g.f48695b.get(i);
        if (recommendItemModel != null) {
            listRecommendViewHolder.f12577a.setImageURI(recommendItemModel.iconUrl);
            listRecommendViewHolder.f12578b.setText(recommendItemModel.appName);
            listRecommendViewHolder.f12579c.setText(recommendItemModel.desc);
            listRecommendViewHolder.f12580d.setText(recommendItemModel.buttonText);
            listRecommendViewHolder.itemView.setTag(Integer.valueOf(i));
            listRecommendViewHolder.f12580d.setTag(Integer.valueOf(i));
            listRecommendViewHolder.itemView.setOnClickListener(this);
            listRecommendViewHolder.f12580d.setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public ListRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ListRecommendViewHolder(this.f12571e.inflate(g.swangame_recommend_dialog_item, viewGroup, false));
    }

    public void e(a aVar) {
        this.f12572f = aVar;
    }

    public void f(d.b.g0.g.k0.i.e.a aVar) {
        this.f12573g = aVar;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<RecommendItemModel> list;
        d.b.g0.g.k0.i.e.a aVar = this.f12573g;
        if (aVar == null || (list = aVar.f48695b) == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f12572f == null || view == null || !(view.getTag() instanceof Integer)) {
            return;
        }
        this.f12572f.a(((Integer) view.getTag()).intValue());
    }
}
