package com.baidu.swan.games.view.recommend.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
/* loaded from: classes25.dex */
public class a extends RecyclerView.Adapter<d> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.model.a egF;
    private InterfaceC0558a egW;
    private LayoutInflater mInflater;

    /* renamed from: com.baidu.swan.games.view.recommend.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0558a {
        void mP(int i);
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
        RecommendItemModel recommendItemModel = this.egF.ehi.get(i);
        if (recommendItemModel != null) {
            dVar.egU.setImageURI(recommendItemModel.iconUrl);
            dVar.egV.setText(recommendItemModel.appName);
            dVar.ehf.setText(recommendItemModel.desc);
            dVar.ehg.setText(recommendItemModel.buttonText);
            dVar.itemView.setTag(Integer.valueOf(i));
            dVar.ehg.setTag(Integer.valueOf(i));
            dVar.itemView.setOnClickListener(this);
            dVar.ehg.setOnClickListener(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.egF == null || this.egF.ehi == null) {
            return 0;
        }
        return this.egF.ehi.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.egW != null && view != null && (view.getTag() instanceof Integer)) {
            this.egW.mP(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.egF = aVar;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0558a interfaceC0558a) {
        this.egW = interfaceC0558a;
    }
}
