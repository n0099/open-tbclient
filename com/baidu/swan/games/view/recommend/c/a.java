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
    private com.baidu.swan.games.view.recommend.model.a diV;
    private InterfaceC0449a djm;
    private LayoutInflater mInflater;

    /* renamed from: com.baidu.swan.games.view.recommend.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0449a {
        void iS(int i);
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
        RecommendItemModel recommendItemModel = this.diV.djy.get(i);
        if (recommendItemModel != null) {
            dVar.djk.setImageURI(recommendItemModel.iconUrl);
            dVar.djl.setText(recommendItemModel.appName);
            dVar.djv.setText(recommendItemModel.desc);
            dVar.djw.setText(recommendItemModel.buttonText);
            dVar.itemView.setTag(Integer.valueOf(i));
            dVar.djw.setTag(Integer.valueOf(i));
            dVar.itemView.setOnClickListener(this);
            dVar.djw.setOnClickListener(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.diV == null || this.diV.djy == null) {
            return 0;
        }
        return this.diV.djy.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.djm != null && view != null && (view.getTag() instanceof Integer)) {
            this.djm.iS(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.diV = aVar;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0449a interfaceC0449a) {
        this.djm = interfaceC0449a;
    }
}
