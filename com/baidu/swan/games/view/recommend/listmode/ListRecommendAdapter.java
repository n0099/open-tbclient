package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
/* loaded from: classes8.dex */
public class ListRecommendAdapter extends RecyclerView.Adapter<ListRecommendViewHolder> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.model.a ekR;
    private a elj;
    private LayoutInflater mInflater;

    /* loaded from: classes8.dex */
    public interface a {
        void lr(int i);
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
        RecommendItemModel recommendItemModel = this.ekR.elv.get(i);
        if (recommendItemModel != null) {
            listRecommendViewHolder.elh.setImageURI(recommendItemModel.iconUrl);
            listRecommendViewHolder.eli.setText(recommendItemModel.appName);
            listRecommendViewHolder.els.setText(recommendItemModel.desc);
            listRecommendViewHolder.elt.setText(recommendItemModel.buttonText);
            listRecommendViewHolder.itemView.setTag(Integer.valueOf(i));
            listRecommendViewHolder.elt.setTag(Integer.valueOf(i));
            listRecommendViewHolder.itemView.setOnClickListener(this);
            listRecommendViewHolder.elt.setOnClickListener(this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ekR == null || this.ekR.elv == null) {
            return 0;
        }
        return this.ekR.elv.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.elj != null && view != null && (view.getTag() instanceof Integer)) {
            this.elj.lr(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.ekR = aVar;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.elj = aVar;
    }
}
