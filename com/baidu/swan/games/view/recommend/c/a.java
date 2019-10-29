package com.baidu.swan.games.view.recommend.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
/* loaded from: classes2.dex */
public class a extends RecyclerView.Adapter<d> implements View.OnClickListener {
    private com.baidu.swan.games.view.recommend.d.b bFM;
    private InterfaceC0262a bGe;
    private LayoutInflater mInflater;

    /* renamed from: com.baidu.swan.games.view.recommend.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0262a {
        void gm(int i);
    }

    public a(@NonNull Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: b */
    public d onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new d(this.mInflater.inflate(a.g.swangame_recommend_dialog_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(d dVar, int i) {
        com.baidu.swan.games.view.recommend.d.a aVar = this.bFM.bGq.get(i);
        if (aVar != null) {
            dVar.bGc.setImageURI(aVar.iconUrl);
            dVar.bGd.setText(aVar.appName);
            dVar.bGn.setText(aVar.desc);
            dVar.bGo.setText(aVar.buttonText);
            dVar.itemView.setTag(Integer.valueOf(i));
            dVar.bGo.setTag(Integer.valueOf(i));
            dVar.itemView.setOnClickListener(this);
            dVar.bGo.setOnClickListener(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bFM == null || this.bFM.bGq == null) {
            return 0;
        }
        return this.bFM.bGq.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bGe != null && view != null && (view.getTag() instanceof Integer)) {
            this.bGe.gm(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.d.b bVar) {
        this.bFM = bVar;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0262a interfaceC0262a) {
        this.bGe = interfaceC0262a;
    }
}
