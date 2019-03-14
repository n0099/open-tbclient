package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView aGg;
    private b bhP;
    private TextView bie;
    private View bif;
    private g bih;
    private e bii;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.bhP = bVar;
        this.bii = eVar;
    }

    private void init(View view) {
        this.bie = (TextView) view.findViewById(d.g.main_title);
        this.aGg = (TextView) view.findViewById(d.g.sub_title);
        this.bif = view.findViewById(d.g.select);
        this.bif.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bhP.Qz();
        this.bih.isSelected = true;
        this.bhP.notifyDataSetChanged();
        if (this.bii != null) {
            this.bii.a(this.bih);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.bih = gVar;
            this.bie.setText(z ? bh(gVar.bim.name, str) : gVar.bim.name);
            this.aGg.setVisibility(0);
            this.aGg.setText(gVar.bim.address);
            if (gVar.bin || TextUtils.isEmpty(gVar.bim.address)) {
                this.aGg.setVisibility(8);
            }
            this.bif.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence bh(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
