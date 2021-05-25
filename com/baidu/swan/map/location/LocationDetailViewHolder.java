package com.baidu.swan.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import d.a.l0.j.e;
import d.a.l0.j.o.b;
import d.a.l0.j.o.c;
/* loaded from: classes3.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TextView f11774e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f11775f;

    /* renamed from: g  reason: collision with root package name */
    public View f11776g;

    /* renamed from: h  reason: collision with root package name */
    public LocationDetailAdapter f11777h;

    /* renamed from: i  reason: collision with root package name */
    public c f11778i;
    public b j;

    public LocationDetailViewHolder(View view, LocationDetailAdapter locationDetailAdapter, b bVar) {
        super(view);
        a(view);
        this.f11777h = locationDetailAdapter;
        this.j = bVar;
    }

    public final void a(View view) {
        this.f11774e = (TextView) view.findViewById(e.main_title);
        this.f11775f = (TextView) view.findViewById(e.sub_title);
        View findViewById = view.findViewById(e.select);
        this.f11776g = findViewById;
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
            this.f11778i = cVar;
            this.f11774e.setText(z ? b(cVar.f47895a.name, str) : cVar.f47895a.name);
            this.f11775f.setVisibility(0);
            this.f11775f.setText(cVar.f47895a.address);
            if (cVar.f47897c || TextUtils.isEmpty(cVar.f47895a.address)) {
                this.f11775f.setVisibility(8);
            }
            this.f11776g.setVisibility(cVar.f47896b ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f11777h.e();
        this.f11778i.f47896b = true;
        this.f11777h.notifyDataSetChanged();
        b bVar = this.j;
        if (bVar != null) {
            bVar.c(this.f11778i);
        }
    }
}
