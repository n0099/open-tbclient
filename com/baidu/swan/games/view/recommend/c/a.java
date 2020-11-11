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
    private InterfaceC0548a ebE;
    private com.baidu.swan.games.view.recommend.model.a ebn;
    private LayoutInflater mInflater;

    /* renamed from: com.baidu.swan.games.view.recommend.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0548a {
        void mv(int i);
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
        RecommendItemModel recommendItemModel = this.ebn.ebQ.get(i);
        if (recommendItemModel != null) {
            dVar.ebC.setImageURI(recommendItemModel.iconUrl);
            dVar.ebD.setText(recommendItemModel.appName);
            dVar.ebN.setText(recommendItemModel.desc);
            dVar.ebO.setText(recommendItemModel.buttonText);
            dVar.itemView.setTag(Integer.valueOf(i));
            dVar.ebO.setTag(Integer.valueOf(i));
            dVar.itemView.setOnClickListener(this);
            dVar.ebO.setOnClickListener(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ebn == null || this.ebn.ebQ == null) {
            return 0;
        }
        return this.ebn.ebQ.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ebE != null && view != null && (view.getTag() instanceof Integer)) {
            this.ebE.mv(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.ebn = aVar;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0548a interfaceC0548a) {
        this.ebE = interfaceC0548a;
    }
}
