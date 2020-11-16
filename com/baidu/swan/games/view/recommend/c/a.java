package com.baidu.swan.games.view.recommend.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
/* loaded from: classes7.dex */
public class a extends RecyclerView.Adapter<d> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.model.a dZF;
    private InterfaceC0546a dZW;
    private LayoutInflater mInflater;

    /* renamed from: com.baidu.swan.games.view.recommend.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0546a {
        void mr(int i);
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
        RecommendItemModel recommendItemModel = this.dZF.eai.get(i);
        if (recommendItemModel != null) {
            dVar.dZU.setImageURI(recommendItemModel.iconUrl);
            dVar.dZV.setText(recommendItemModel.appName);
            dVar.eaf.setText(recommendItemModel.desc);
            dVar.eag.setText(recommendItemModel.buttonText);
            dVar.itemView.setTag(Integer.valueOf(i));
            dVar.eag.setTag(Integer.valueOf(i));
            dVar.itemView.setOnClickListener(this);
            dVar.eag.setOnClickListener(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dZF == null || this.dZF.eai == null) {
            return 0;
        }
        return this.dZF.eai.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dZW != null && view != null && (view.getTag() instanceof Integer)) {
            this.dZW.mr(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.dZF = aVar;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0546a interfaceC0546a) {
        this.dZW = interfaceC0546a;
    }
}
