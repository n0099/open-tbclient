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
    private com.baidu.swan.games.view.recommend.model.a doQ;
    private InterfaceC0462a dph;
    private LayoutInflater mInflater;

    /* renamed from: com.baidu.swan.games.view.recommend.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0462a {
        void jj(int i);
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
        RecommendItemModel recommendItemModel = this.doQ.dpt.get(i);
        if (recommendItemModel != null) {
            dVar.dpf.setImageURI(recommendItemModel.iconUrl);
            dVar.dpg.setText(recommendItemModel.appName);
            dVar.dpq.setText(recommendItemModel.desc);
            dVar.dpr.setText(recommendItemModel.buttonText);
            dVar.itemView.setTag(Integer.valueOf(i));
            dVar.dpr.setTag(Integer.valueOf(i));
            dVar.itemView.setOnClickListener(this);
            dVar.dpr.setOnClickListener(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.doQ == null || this.doQ.dpt == null) {
            return 0;
        }
        return this.doQ.dpt.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dph != null && view != null && (view.getTag() instanceof Integer)) {
            this.dph.jj(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.model.a aVar) {
        this.doQ = aVar;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0462a interfaceC0462a) {
        this.dph = interfaceC0462a;
    }
}
