package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import d.a.h0.a.g;
import java.util.List;
/* loaded from: classes3.dex */
public class ListRecommendAdapter extends RecyclerView.Adapter<ListRecommendViewHolder> implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f12475e;

    /* renamed from: f  reason: collision with root package name */
    public a f12476f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.h0.g.k0.i.e.a f12477g;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i2);
    }

    public ListRecommendAdapter(@NonNull Context context) {
        this.f12475e = LayoutInflater.from(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(ListRecommendViewHolder listRecommendViewHolder, int i2) {
        RecommendItemModel recommendItemModel = this.f12477g.f46501b.get(i2);
        if (recommendItemModel != null) {
            listRecommendViewHolder.f12481a.setImageURI(recommendItemModel.iconUrl);
            listRecommendViewHolder.f12482b.setText(recommendItemModel.appName);
            listRecommendViewHolder.f12483c.setText(recommendItemModel.desc);
            listRecommendViewHolder.f12484d.setText(recommendItemModel.buttonText);
            listRecommendViewHolder.itemView.setTag(Integer.valueOf(i2));
            listRecommendViewHolder.f12484d.setTag(Integer.valueOf(i2));
            listRecommendViewHolder.itemView.setOnClickListener(this);
            listRecommendViewHolder.f12484d.setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public ListRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ListRecommendViewHolder(this.f12475e.inflate(g.swangame_recommend_dialog_item, viewGroup, false));
    }

    public void e(a aVar) {
        this.f12476f = aVar;
    }

    public void f(d.a.h0.g.k0.i.e.a aVar) {
        this.f12477g = aVar;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<RecommendItemModel> list;
        d.a.h0.g.k0.i.e.a aVar = this.f12477g;
        if (aVar == null || (list = aVar.f46501b) == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f12476f == null || view == null || !(view.getTag() instanceof Integer)) {
            return;
        }
        this.f12476f.a(((Integer) view.getTag()).intValue());
    }
}
