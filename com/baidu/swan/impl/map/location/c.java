package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView aIL;
    private b boL;
    private TextView boZ;
    private View bpa;
    private g bpb;
    private e bpc;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.boL = bVar;
        this.bpc = eVar;
    }

    private void init(View view) {
        this.boZ = (TextView) view.findViewById(R.id.main_title);
        this.aIL = (TextView) view.findViewById(R.id.sub_title);
        this.bpa = view.findViewById(R.id.select);
        this.bpa.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.boL.Vb();
        this.bpb.isSelected = true;
        this.boL.notifyDataSetChanged();
        if (this.bpc != null) {
            this.bpc.a(this.bpb);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.bpb = gVar;
            this.boZ.setText(z ? bl(gVar.bpg.name, str) : gVar.bpg.name);
            this.aIL.setVisibility(0);
            this.aIL.setText(gVar.bpg.address);
            if (gVar.bph || TextUtils.isEmpty(gVar.bpg.address)) {
                this.aIL.setVisibility(8);
            }
            this.bpa.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence bl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
