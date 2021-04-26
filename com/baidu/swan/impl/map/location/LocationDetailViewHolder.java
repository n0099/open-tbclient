package com.baidu.swan.impl.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import d.a.h0.h.a.j.b;
import d.a.h0.h.a.j.c;
/* loaded from: classes3.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TextView f12531e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12532f;

    /* renamed from: g  reason: collision with root package name */
    public View f12533g;

    /* renamed from: h  reason: collision with root package name */
    public LocationDetailAdapter f12534h;

    /* renamed from: i  reason: collision with root package name */
    public c f12535i;
    public b j;

    public LocationDetailViewHolder(View view, LocationDetailAdapter locationDetailAdapter, b bVar) {
        super(view);
        a(view);
        this.f12534h = locationDetailAdapter;
        this.j = bVar;
    }

    public final void a(View view) {
        this.f12531e = (TextView) view.findViewById(R.id.main_title);
        this.f12532f = (TextView) view.findViewById(R.id.sub_title);
        View findViewById = view.findViewById(R.id.select);
        this.f12533g = findViewById;
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
            this.f12535i = cVar;
            this.f12531e.setText(z ? b(cVar.f46994a.name, str) : cVar.f46994a.name);
            this.f12532f.setVisibility(0);
            this.f12532f.setText(cVar.f46994a.address);
            if (cVar.f46996c || TextUtils.isEmpty(cVar.f46994a.address)) {
                this.f12532f.setVisibility(8);
            }
            this.f12533g.setVisibility(cVar.f46995b ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f12534h.e();
        this.f12535i.f46995b = true;
        this.f12534h.notifyDataSetChanged();
        b bVar = this.j;
        if (bVar != null) {
            bVar.c(this.f12535i);
        }
    }
}
