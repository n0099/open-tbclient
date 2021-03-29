package com.baidu.swan.impl.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import d.b.g0.h.a.j.b;
import d.b.g0.h.a.j.c;
/* loaded from: classes3.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TextView f12964e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12965f;

    /* renamed from: g  reason: collision with root package name */
    public View f12966g;

    /* renamed from: h  reason: collision with root package name */
    public LocationDetailAdapter f12967h;
    public c i;
    public b j;

    public LocationDetailViewHolder(View view, LocationDetailAdapter locationDetailAdapter, b bVar) {
        super(view);
        a(view);
        this.f12967h = locationDetailAdapter;
        this.j = bVar;
    }

    public final void a(View view) {
        this.f12964e = (TextView) view.findViewById(R.id.main_title);
        this.f12965f = (TextView) view.findViewById(R.id.sub_title);
        View findViewById = view.findViewById(R.id.select);
        this.f12966g = findViewById;
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
            this.f12964e.setText(z ? b(cVar.f48771a.name, str) : cVar.f48771a.name);
            this.f12965f.setVisibility(0);
            this.f12965f.setText(cVar.f48771a.address);
            if (cVar.f48773c || TextUtils.isEmpty(cVar.f48771a.address)) {
                this.f12965f.setVisibility(8);
            }
            this.f12966g.setVisibility(cVar.f48772b ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f12967h.o();
        this.i.f48772b = true;
        this.f12967h.notifyDataSetChanged();
        b bVar = this.j;
        if (bVar != null) {
            bVar.c(this.i);
        }
    }
}
