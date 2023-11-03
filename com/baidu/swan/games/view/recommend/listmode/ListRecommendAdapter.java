package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.tieba.R;
import com.baidu.tieba.v94;
import java.util.List;
/* loaded from: classes4.dex */
public class ListRecommendAdapter extends RecyclerView.Adapter<ListRecommendViewHolder> implements View.OnClickListener {
    public LayoutInflater a;
    public a b;
    public v94 c;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i);
    }

    public ListRecommendAdapter(@NonNull Context context) {
        this.a = LayoutInflater.from(context);
    }

    public void n(a aVar) {
        this.b = aVar;
    }

    public void o(v94 v94Var) {
        this.c = v94Var;
        notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.b != null && view2 != null && (view2.getTag() instanceof Integer)) {
            this.b.a(((Integer) view2.getTag()).intValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<RecommendItemModel> list;
        v94 v94Var = this.c;
        if (v94Var != null && (list = v94Var.b) != null) {
            return list.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onBindViewHolder(ListRecommendViewHolder listRecommendViewHolder, int i) {
        RecommendItemModel recommendItemModel = this.c.b.get(i);
        if (recommendItemModel != null) {
            listRecommendViewHolder.a.setImageURI(recommendItemModel.iconUrl);
            listRecommendViewHolder.b.setText(recommendItemModel.appName);
            listRecommendViewHolder.c.setText(recommendItemModel.desc);
            listRecommendViewHolder.d.setText(recommendItemModel.buttonText);
            listRecommendViewHolder.itemView.setTag(Integer.valueOf(i));
            listRecommendViewHolder.d.setTag(Integer.valueOf(i));
            listRecommendViewHolder.itemView.setOnClickListener(this);
            listRecommendViewHolder.d.setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public ListRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ListRecommendViewHolder(this.a.inflate(R.layout.obfuscated_res_0x7f0d0961, viewGroup, false));
    }
}
