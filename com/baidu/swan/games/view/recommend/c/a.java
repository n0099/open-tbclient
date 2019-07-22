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
    private com.baidu.swan.games.view.recommend.d.b bmC;
    private InterfaceC0216a bmU;
    private LayoutInflater mInflater;

    /* renamed from: com.baidu.swan.games.view.recommend.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0216a {
        void fq(int i);
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
        com.baidu.swan.games.view.recommend.d.a aVar = this.bmC.bng.get(i);
        if (aVar != null) {
            dVar.bmS.setImageURI(aVar.iconUrl);
            dVar.bmT.setText(aVar.appName);
            dVar.bnd.setText(aVar.desc);
            dVar.bne.setText(aVar.buttonText);
            dVar.itemView.setTag(Integer.valueOf(i));
            dVar.bne.setTag(Integer.valueOf(i));
            dVar.itemView.setOnClickListener(this);
            dVar.bne.setOnClickListener(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bmC == null || this.bmC.bng == null) {
            return 0;
        }
        return this.bmC.bng.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bmU != null && view != null && (view.getTag() instanceof Integer)) {
            this.bmU.fq(((Integer) view.getTag()).intValue());
        }
    }

    public void a(com.baidu.swan.games.view.recommend.d.b bVar) {
        this.bmC = bVar;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0216a interfaceC0216a) {
        this.bmU = interfaceC0216a;
    }
}
