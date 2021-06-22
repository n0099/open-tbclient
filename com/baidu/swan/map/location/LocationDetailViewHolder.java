package com.baidu.swan.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import d.a.m0.j.e;
import d.a.m0.j.o.b;
import d.a.m0.j.o.c;
/* loaded from: classes3.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TextView f11918e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f11919f;

    /* renamed from: g  reason: collision with root package name */
    public View f11920g;

    /* renamed from: h  reason: collision with root package name */
    public LocationDetailAdapter f11921h;

    /* renamed from: i  reason: collision with root package name */
    public c f11922i;
    public b j;

    public LocationDetailViewHolder(View view, LocationDetailAdapter locationDetailAdapter, b bVar) {
        super(view);
        a(view);
        this.f11921h = locationDetailAdapter;
        this.j = bVar;
    }

    public final void a(View view) {
        this.f11918e = (TextView) view.findViewById(e.main_title);
        this.f11919f = (TextView) view.findViewById(e.sub_title);
        View findViewById = view.findViewById(e.select);
        this.f11920g = findViewById;
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
            this.f11922i = cVar;
            this.f11918e.setText(z ? b(cVar.f51677a.name, str) : cVar.f51677a.name);
            this.f11919f.setVisibility(0);
            this.f11919f.setText(cVar.f51677a.address);
            if (cVar.f51679c || TextUtils.isEmpty(cVar.f51677a.address)) {
                this.f11919f.setVisibility(8);
            }
            this.f11920g.setVisibility(cVar.f51678b ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f11921h.o();
        this.f11922i.f51678b = true;
        this.f11921h.notifyDataSetChanged();
        b bVar = this.j;
        if (bVar != null) {
            bVar.c(this.f11922i);
        }
    }
}
