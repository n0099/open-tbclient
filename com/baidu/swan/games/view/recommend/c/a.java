package com.baidu.swan.games.view.recommend.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
/* loaded from: classes3.dex */
public class a extends RecyclerView.Adapter<d> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.model.a dAX;
    private InterfaceC0505a dBo;
    private LayoutInflater mInflater;

    /* renamed from: com.baidu.swan.games.view.recommend.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0505a {
        void lD(int i);
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
        RecommendItemModel recommendItemModel = this.dAX.dBA.get(i);
        if (recommendItemModel != null) {
            dVar.dBm.setImageURI(recommendItemModel.iconUrl);
            dVar.dBn.setText(recommendItemModel.appName);
            dVar.dBx.setText(recommendItemModel.desc);
            dVar.dBy.setText(recommendItemModel.buttonText);
            dVar.itemView.setTag(Integer.valueOf(i));
            dVar.dBy.setTag(Integer.valueOf(i));
            dVar.itemView.setOnClickListener(this);
            dVar.dBy.setOnClickListener(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dAX == null || this.dAX.dBA == null) {
            return 0;
        }
        return this.dAX.dBA.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dBo != null && view != null && (view.getTag() instanceof Integer)) {
            this.dBo.lD(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.dAX = aVar;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0505a interfaceC0505a) {
        this.dBo = interfaceC0505a;
    }
}
