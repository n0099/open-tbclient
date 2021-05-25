package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import d.a.l0.f.f;
import java.util.List;
/* loaded from: classes3.dex */
public class ListRecommendAdapter extends RecyclerView.Adapter<ListRecommendViewHolder> implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f11718e;

    /* renamed from: f  reason: collision with root package name */
    public a f11719f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.h.o0.g.e.a f11720g;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i2);
    }

    public ListRecommendAdapter(@NonNull Context context) {
        this.f11718e = LayoutInflater.from(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(ListRecommendViewHolder listRecommendViewHolder, int i2) {
        RecommendItemModel recommendItemModel = this.f11720g.f47607b.get(i2);
        if (recommendItemModel != null) {
            listRecommendViewHolder.f11724a.setImageURI(recommendItemModel.iconUrl);
            listRecommendViewHolder.f11725b.setText(recommendItemModel.appName);
            listRecommendViewHolder.f11726c.setText(recommendItemModel.desc);
            listRecommendViewHolder.f11727d.setText(recommendItemModel.buttonText);
            listRecommendViewHolder.itemView.setTag(Integer.valueOf(i2));
            listRecommendViewHolder.f11727d.setTag(Integer.valueOf(i2));
            listRecommendViewHolder.itemView.setOnClickListener(this);
            listRecommendViewHolder.f11727d.setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public ListRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ListRecommendViewHolder(this.f11718e.inflate(f.swangame_recommend_dialog_item, viewGroup, false));
    }

    public void e(a aVar) {
        this.f11719f = aVar;
    }

    public void f(d.a.l0.h.o0.g.e.a aVar) {
        this.f11720g = aVar;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<RecommendItemModel> list;
        d.a.l0.h.o0.g.e.a aVar = this.f11720g;
        if (aVar == null || (list = aVar.f47607b) == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11719f == null || view == null || !(view.getTag() instanceof Integer)) {
            return;
        }
        this.f11719f.a(((Integer) view.getTag()).intValue());
    }
}
