package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView aId;
    private b bnY;
    private TextView bom;
    private View bon;
    private g boo;
    private e bop;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.bnY = bVar;
        this.bop = eVar;
    }

    private void init(View view) {
        this.bom = (TextView) view.findViewById(R.id.main_title);
        this.aId = (TextView) view.findViewById(R.id.sub_title);
        this.bon = view.findViewById(R.id.select);
        this.bon.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bnY.Uj();
        this.boo.isSelected = true;
        this.bnY.notifyDataSetChanged();
        if (this.bop != null) {
            this.bop.a(this.boo);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.boo = gVar;
            this.bom.setText(z ? bl(gVar.bot.name, str) : gVar.bot.name);
            this.aId.setVisibility(0);
            this.aId.setText(gVar.bot.address);
            if (gVar.bou || TextUtils.isEmpty(gVar.bot.address)) {
                this.aId.setVisibility(8);
            }
            this.bon.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence bl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
