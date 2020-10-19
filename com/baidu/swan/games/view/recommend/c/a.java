package com.baidu.swan.games.view.recommend.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
/* loaded from: classes10.dex */
public class a extends RecyclerView.Adapter<d> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.model.a dMY;
    private InterfaceC0522a dNp;
    private LayoutInflater mInflater;

    /* renamed from: com.baidu.swan.games.view.recommend.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0522a {
        void ma(int i);
    }

    public a(@NonNull Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: c */
    public d onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new d(this.mInflater.inflate(a.g.swangame_recommend_dialog_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(d dVar, int i) {
        RecommendItemModel recommendItemModel = this.dMY.dNB.get(i);
        if (recommendItemModel != null) {
            dVar.dNn.setImageURI(recommendItemModel.iconUrl);
            dVar.dNo.setText(recommendItemModel.appName);
            dVar.dNy.setText(recommendItemModel.desc);
            dVar.dNz.setText(recommendItemModel.buttonText);
            dVar.itemView.setTag(Integer.valueOf(i));
            dVar.dNz.setTag(Integer.valueOf(i));
            dVar.itemView.setOnClickListener(this);
            dVar.dNz.setOnClickListener(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dMY == null || this.dMY.dNB == null) {
            return 0;
        }
        return this.dMY.dNB.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dNp != null && view != null && (view.getTag() instanceof Integer)) {
            this.dNp.ma(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.dMY = aVar;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0522a interfaceC0522a) {
        this.dNp = interfaceC0522a;
    }
}
