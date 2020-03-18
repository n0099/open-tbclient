package com.baidu.swan.games.view.recommend.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
/* loaded from: classes11.dex */
public class a extends RecyclerView.Adapter<d> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.model.a cud;
    private InterfaceC0351a cuw;
    private LayoutInflater mInflater;

    /* renamed from: com.baidu.swan.games.view.recommend.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0351a {
        void ih(int i);
    }

    public a(@NonNull Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: e */
    public d onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new d(this.mInflater.inflate(a.g.swangame_recommend_dialog_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(d dVar, int i) {
        RecommendItemModel recommendItemModel = this.cud.cuI.get(i);
        if (recommendItemModel != null) {
            dVar.cuu.setImageURI(recommendItemModel.iconUrl);
            dVar.cuv.setText(recommendItemModel.appName);
            dVar.cuF.setText(recommendItemModel.desc);
            dVar.cuG.setText(recommendItemModel.buttonText);
            dVar.itemView.setTag(Integer.valueOf(i));
            dVar.cuG.setTag(Integer.valueOf(i));
            dVar.itemView.setOnClickListener(this);
            dVar.cuG.setOnClickListener(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cud == null || this.cud.cuI == null) {
            return 0;
        }
        return this.cud.cuI.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cuw != null && view != null && (view.getTag() instanceof Integer)) {
            this.cuw.ih(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.cud = aVar;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0351a interfaceC0351a) {
        this.cuw = interfaceC0351a;
    }
}
