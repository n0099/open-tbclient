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
    private com.baidu.swan.games.view.recommend.d.b bEV;
    private InterfaceC0262a bFn;
    private LayoutInflater mInflater;

    /* renamed from: com.baidu.swan.games.view.recommend.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0262a {
        void gl(int i);
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
        com.baidu.swan.games.view.recommend.d.a aVar = this.bEV.bFz.get(i);
        if (aVar != null) {
            dVar.bFl.setImageURI(aVar.iconUrl);
            dVar.bFm.setText(aVar.appName);
            dVar.bFw.setText(aVar.desc);
            dVar.bFx.setText(aVar.buttonText);
            dVar.itemView.setTag(Integer.valueOf(i));
            dVar.bFx.setTag(Integer.valueOf(i));
            dVar.itemView.setOnClickListener(this);
            dVar.bFx.setOnClickListener(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bEV == null || this.bEV.bFz == null) {
            return 0;
        }
        return this.bEV.bFz.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bFn != null && view != null && (view.getTag() instanceof Integer)) {
            this.bFn.gl(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.d.b bVar) {
        this.bEV = bVar;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0262a interfaceC0262a) {
        this.bFn = interfaceC0262a;
    }
}
