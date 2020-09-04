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
    private com.baidu.swan.games.view.recommend.model.a dyW;
    private InterfaceC0510a dzn;
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
        RecommendItemModel recommendItemModel = this.dyW.dzz.get(i);
        if (recommendItemModel != null) {
            dVar.dzl.setImageURI(recommendItemModel.iconUrl);
            dVar.dzm.setText(recommendItemModel.appName);
            dVar.dzw.setText(recommendItemModel.desc);
            dVar.dzx.setText(recommendItemModel.buttonText);
            dVar.itemView.setTag(Integer.valueOf(i));
            dVar.dzx.setTag(Integer.valueOf(i));
            dVar.itemView.setOnClickListener(this);
            dVar.dzx.setOnClickListener(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dyW == null || this.dyW.dzz == null) {
            return 0;
        }
        return this.dyW.dzz.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dzn != null && view != null && (view.getTag() instanceof Integer)) {
            this.dzn.ls(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.dyW = aVar;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0510a interfaceC0510a) {
        this.dzn = interfaceC0510a;
    }
}
