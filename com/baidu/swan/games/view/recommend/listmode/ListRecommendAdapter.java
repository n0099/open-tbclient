package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
/* loaded from: classes9.dex */
public class ListRecommendAdapter extends RecyclerView.Adapter<ListRecommendViewHolder> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.model.a emY;
    private a enr;
    private LayoutInflater mInflater;

    /* loaded from: classes9.dex */
    public interface a {
        void lu(int i);
    }

    public ListRecommendAdapter(@NonNull Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public ListRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ListRecommendViewHolder(this.mInflater.inflate(a.g.swangame_recommend_dialog_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(ListRecommendViewHolder listRecommendViewHolder, int i) {
        RecommendItemModel recommendItemModel = this.emY.enE.get(i);
        if (recommendItemModel != null) {
            listRecommendViewHolder.enp.setImageURI(recommendItemModel.iconUrl);
            listRecommendViewHolder.enq.setText(recommendItemModel.appName);
            listRecommendViewHolder.enB.setText(recommendItemModel.desc);
            listRecommendViewHolder.enC.setText(recommendItemModel.buttonText);
            listRecommendViewHolder.itemView.setTag(Integer.valueOf(i));
            listRecommendViewHolder.enC.setTag(Integer.valueOf(i));
            listRecommendViewHolder.itemView.setOnClickListener(this);
            listRecommendViewHolder.enC.setOnClickListener(this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.emY == null || this.emY.enE == null) {
            return 0;
        }
        return this.emY.enE.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.enr != null && view != null && (view.getTag() instanceof Integer)) {
            this.enr.lu(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.emY = aVar;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.enr = aVar;
    }
}
