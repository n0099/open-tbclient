package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private b bHe;
    private TextView bHs;
    private View bHt;
    private g bHu;
    private e bHv;
    private TextView bcf;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.bHe = bVar;
        this.bHv = eVar;
    }

    private void init(View view) {
        this.bHs = (TextView) view.findViewById(R.id.main_title);
        this.bcf = (TextView) view.findViewById(R.id.sub_title);
        this.bHt = view.findViewById(R.id.select);
        this.bHt.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bHe.ZS();
        this.bHu.isSelected = true;
        this.bHe.notifyDataSetChanged();
        if (this.bHv != null) {
            this.bHv.a(this.bHu);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.bHu = gVar;
            this.bHs.setText(z ? bs(gVar.bHz.name, str) : gVar.bHz.name);
            this.bcf.setVisibility(0);
            this.bcf.setText(gVar.bHz.address);
            if (gVar.bHA || TextUtils.isEmpty(gVar.bHz.address)) {
                this.bcf.setVisibility(8);
            }
            this.bHt.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence bs(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
