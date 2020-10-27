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
    private InterfaceC0536a dVM;
    private com.baidu.swan.games.view.recommend.model.a dVv;
    private LayoutInflater mInflater;

    /* renamed from: com.baidu.swan.games.view.recommend.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0536a {
        void ml(int i);
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
        RecommendItemModel recommendItemModel = this.dVv.dVY.get(i);
        if (recommendItemModel != null) {
            dVar.dVK.setImageURI(recommendItemModel.iconUrl);
            dVar.dVL.setText(recommendItemModel.appName);
            dVar.dVV.setText(recommendItemModel.desc);
            dVar.dVW.setText(recommendItemModel.buttonText);
            dVar.itemView.setTag(Integer.valueOf(i));
            dVar.dVW.setTag(Integer.valueOf(i));
            dVar.itemView.setOnClickListener(this);
            dVar.dVW.setOnClickListener(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dVv == null || this.dVv.dVY == null) {
            return 0;
        }
        return this.dVv.dVY.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dVM != null && view != null && (view.getTag() instanceof Integer)) {
            this.dVM.ml(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.dVv = aVar;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0536a interfaceC0536a) {
        this.dVM = interfaceC0536a;
    }
}
