package com.baidu.swan.games.view.recommend.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
/* loaded from: classes8.dex */
public class a extends RecyclerView.Adapter<d> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.model.a dyS;
    private InterfaceC0510a dzj;
    private LayoutInflater mInflater;

    /* renamed from: com.baidu.swan.games.view.recommend.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0510a {
        void ls(int i);
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
        RecommendItemModel recommendItemModel = this.dyS.dzv.get(i);
        if (recommendItemModel != null) {
            dVar.dzh.setImageURI(recommendItemModel.iconUrl);
            dVar.dzi.setText(recommendItemModel.appName);
            dVar.dzs.setText(recommendItemModel.desc);
            dVar.dzt.setText(recommendItemModel.buttonText);
            dVar.itemView.setTag(Integer.valueOf(i));
            dVar.dzt.setTag(Integer.valueOf(i));
            dVar.itemView.setOnClickListener(this);
            dVar.dzt.setOnClickListener(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dyS == null || this.dyS.dzv == null) {
            return 0;
        }
        return this.dyS.dzv.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dzj != null && view != null && (view.getTag() instanceof Integer)) {
            this.dzj.ls(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.dyS = aVar;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0510a interfaceC0510a) {
        this.dzj = interfaceC0510a;
    }
}
