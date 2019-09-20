package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView aJj;
    private e bpA;
    private b bpj;
    private TextView bpx;
    private View bpy;
    private g bpz;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.bpj = bVar;
        this.bpA = eVar;
    }

    private void init(View view) {
        this.bpx = (TextView) view.findViewById(R.id.main_title);
        this.aJj = (TextView) view.findViewById(R.id.sub_title);
        this.bpy = view.findViewById(R.id.select);
        this.bpy.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bpj.Vf();
        this.bpz.isSelected = true;
        this.bpj.notifyDataSetChanged();
        if (this.bpA != null) {
            this.bpA.a(this.bpz);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.bpz = gVar;
            this.bpx.setText(z ? bl(gVar.bpE.name, str) : gVar.bpE.name);
            this.aJj.setVisibility(0);
            this.aJj.setText(gVar.bpE.address);
            if (gVar.bpF || TextUtils.isEmpty(gVar.bpE.address)) {
                this.aJj.setVisibility(8);
            }
            this.bpy.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence bl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
