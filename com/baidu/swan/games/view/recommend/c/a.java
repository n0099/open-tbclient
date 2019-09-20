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
    private com.baidu.swan.games.view.recommend.d.b bna;
    private InterfaceC0230a bns;
    private LayoutInflater mInflater;

    /* renamed from: com.baidu.swan.games.view.recommend.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0230a {
        void fr(int i);
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
        com.baidu.swan.games.view.recommend.d.a aVar = this.bna.bnE.get(i);
        if (aVar != null) {
            dVar.bnq.setImageURI(aVar.iconUrl);
            dVar.bnr.setText(aVar.appName);
            dVar.bnB.setText(aVar.desc);
            dVar.bnC.setText(aVar.buttonText);
            dVar.itemView.setTag(Integer.valueOf(i));
            dVar.bnC.setTag(Integer.valueOf(i));
            dVar.itemView.setOnClickListener(this);
            dVar.bnC.setOnClickListener(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bna == null || this.bna.bnE == null) {
            return 0;
        }
        return this.bna.bnE.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bns != null && view != null && (view.getTag() instanceof Integer)) {
            this.bns.fr(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.d.b bVar) {
        this.bna = bVar;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0230a interfaceC0230a) {
        this.bns = interfaceC0230a;
    }
}
