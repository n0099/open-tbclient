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
    private com.baidu.swan.games.view.recommend.model.a cTg;
    private InterfaceC0402a cTx;
    private LayoutInflater mInflater;

    /* renamed from: com.baidu.swan.games.view.recommend.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0402a {
        void io(int i);
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
        RecommendItemModel recommendItemModel = this.cTg.cTJ.get(i);
        if (recommendItemModel != null) {
            dVar.cTv.setImageURI(recommendItemModel.iconUrl);
            dVar.cTw.setText(recommendItemModel.appName);
            dVar.cTG.setText(recommendItemModel.desc);
            dVar.cTH.setText(recommendItemModel.buttonText);
            dVar.itemView.setTag(Integer.valueOf(i));
            dVar.cTH.setTag(Integer.valueOf(i));
            dVar.itemView.setOnClickListener(this);
            dVar.cTH.setOnClickListener(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cTg == null || this.cTg.cTJ == null) {
            return 0;
        }
        return this.cTg.cTJ.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cTx != null && view != null && (view.getTag() instanceof Integer)) {
            this.cTx.io(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.cTg = aVar;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0402a interfaceC0402a) {
        this.cTx = interfaceC0402a;
    }
}
