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
    private InterfaceC0443a deA;
    private com.baidu.swan.games.view.recommend.model.a dei;
    private LayoutInflater mInflater;

    /* renamed from: com.baidu.swan.games.view.recommend.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0443a {
        void iH(int i);
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
        RecommendItemModel recommendItemModel = this.dei.deM.get(i);
        if (recommendItemModel != null) {
            dVar.dey.setImageURI(recommendItemModel.iconUrl);
            dVar.dez.setText(recommendItemModel.appName);
            dVar.deJ.setText(recommendItemModel.desc);
            dVar.deK.setText(recommendItemModel.buttonText);
            dVar.itemView.setTag(Integer.valueOf(i));
            dVar.deK.setTag(Integer.valueOf(i));
            dVar.itemView.setOnClickListener(this);
            dVar.deK.setOnClickListener(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dei == null || this.dei.deM == null) {
            return 0;
        }
        return this.dei.deM.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.deA != null && view != null && (view.getTag() instanceof Integer)) {
            this.deA.iH(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.dei = aVar;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0443a interfaceC0443a) {
        this.deA = interfaceC0443a;
    }
}
