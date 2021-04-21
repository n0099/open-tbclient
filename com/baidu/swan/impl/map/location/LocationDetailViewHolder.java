package com.baidu.swan.impl.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import d.b.h0.h.a.j.b;
import d.b.h0.h.a.j.c;
/* loaded from: classes3.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TextView f12633e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12634f;

    /* renamed from: g  reason: collision with root package name */
    public View f12635g;

    /* renamed from: h  reason: collision with root package name */
    public LocationDetailAdapter f12636h;
    public c i;
    public b j;

    public LocationDetailViewHolder(View view, LocationDetailAdapter locationDetailAdapter, b bVar) {
        super(view);
        a(view);
        this.f12636h = locationDetailAdapter;
        this.j = bVar;
    }

    public final void a(View view) {
        this.f12633e = (TextView) view.findViewById(R.id.main_title);
        this.f12634f = (TextView) view.findViewById(R.id.sub_title);
        View findViewById = view.findViewById(R.id.select);
        this.f12635g = findViewById;
        findViewById.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    public final CharSequence b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>"));
    }

    public void c(c cVar, String str, boolean z) {
        if (cVar != null) {
            this.i = cVar;
            this.f12633e.setText(z ? b(cVar.f49492a.name, str) : cVar.f49492a.name);
            this.f12634f.setVisibility(0);
            this.f12634f.setText(cVar.f49492a.address);
            if (cVar.f49494c || TextUtils.isEmpty(cVar.f49492a.address)) {
                this.f12634f.setVisibility(8);
            }
            this.f12635g.setVisibility(cVar.f49493b ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f12636h.o();
        this.i.f49493b = true;
        this.f12636h.notifyDataSetChanged();
        b bVar = this.j;
        if (bVar != null) {
            bVar.c(this.i);
        }
    }
}
