package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.tieba.R;
import com.baidu.tieba.bd4;
import java.util.List;
/* loaded from: classes3.dex */
public class ListRecommendAdapter extends RecyclerView.Adapter<ListRecommendViewHolder> implements View.OnClickListener {
    public LayoutInflater a;
    public a b;
    public bd4 c;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i);
    }

    public ListRecommendAdapter(@NonNull Context context) {
        this.a = LayoutInflater.from(context);
    }

    public void f(a aVar) {
        this.b = aVar;
    }

    public void g(bd4 bd4Var) {
        this.c = bd4Var;
        notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.b != null && view2 != null && (view2.getTag() instanceof Integer)) {
            this.b.a(((Integer) view2.getTag()).intValue());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
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
    /* renamed from: e */
    public ListRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ListRecommendViewHolder(this.a.inflate(R.layout.obfuscated_res_0x7f0d0898, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<RecommendItemModel> list;
        bd4 bd4Var = this.c;
        if (bd4Var != null && (list = bd4Var.b) != null) {
            return list.size();
        }
        return 0;
    }
}
