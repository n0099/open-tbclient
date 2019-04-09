package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView aGk;
    private b bhT;
    private TextView bij;
    private View bik;
    private g bil;
    private e bim;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.bhT = bVar;
        this.bim = eVar;
    }

    private void init(View view) {
        this.bij = (TextView) view.findViewById(d.g.main_title);
        this.aGk = (TextView) view.findViewById(d.g.sub_title);
        this.bik = view.findViewById(d.g.select);
        this.bik.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bhT.Qx();
        this.bil.isSelected = true;
        this.bhT.notifyDataSetChanged();
        if (this.bim != null) {
            this.bim.a(this.bil);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.bil = gVar;
            this.bij.setText(z ? bh(gVar.biq.name, str) : gVar.biq.name);
            this.aGk.setVisibility(0);
            this.aGk.setText(gVar.biq.address);
            if (gVar.bir || TextUtils.isEmpty(gVar.biq.address)) {
                this.aGk.setVisibility(8);
            }
            this.bik.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence bh(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
