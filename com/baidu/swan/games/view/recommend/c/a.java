package com.baidu.swan.games.view.recommend.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
/* loaded from: classes9.dex */
public class a extends RecyclerView.Adapter<d> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.model.a cpD;
    private InterfaceC0339a cpU;
    private LayoutInflater mInflater;

    /* renamed from: com.baidu.swan.games.view.recommend.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0339a {
        void hQ(int i);
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
        RecommendItemModel recommendItemModel = this.cpD.cqg.get(i);
        if (recommendItemModel != null) {
            dVar.cpS.setImageURI(recommendItemModel.iconUrl);
            dVar.cpT.setText(recommendItemModel.appName);
            dVar.cqd.setText(recommendItemModel.desc);
            dVar.cqe.setText(recommendItemModel.buttonText);
            dVar.itemView.setTag(Integer.valueOf(i));
            dVar.cqe.setTag(Integer.valueOf(i));
            dVar.itemView.setOnClickListener(this);
            dVar.cqe.setOnClickListener(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cpD == null || this.cpD.cqg == null) {
            return 0;
        }
        return this.cpD.cqg.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cpU != null && view != null && (view.getTag() instanceof Integer)) {
            this.cpU.hQ(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.cpD = aVar;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0339a interfaceC0339a) {
        this.cpU = interfaceC0339a;
    }
}
