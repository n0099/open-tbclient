package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView aGj;
    private b bhS;
    private TextView bii;
    private View bij;
    private g bik;
    private e bil;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.bhS = bVar;
        this.bil = eVar;
    }

    private void init(View view) {
        this.bii = (TextView) view.findViewById(d.g.main_title);
        this.aGj = (TextView) view.findViewById(d.g.sub_title);
        this.bij = view.findViewById(d.g.select);
        this.bij.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bhS.Qx();
        this.bik.isSelected = true;
        this.bhS.notifyDataSetChanged();
        if (this.bil != null) {
            this.bil.a(this.bik);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.bik = gVar;
            this.bii.setText(z ? bh(gVar.bip.name, str) : gVar.bip.name);
            this.aGj.setVisibility(0);
            this.aGj.setText(gVar.bip.address);
            if (gVar.biq || TextUtils.isEmpty(gVar.bip.address)) {
                this.aGj.setVisibility(8);
            }
            this.bij.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence bh(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
