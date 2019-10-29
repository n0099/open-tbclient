package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private b bHV;
    private TextView bIj;
    private View bIk;
    private g bIl;
    private e bIm;
    private TextView bcx;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.bHV = bVar;
        this.bIm = eVar;
    }

    private void init(View view) {
        this.bIj = (TextView) view.findViewById(R.id.main_title);
        this.bcx = (TextView) view.findViewById(R.id.sub_title);
        this.bIk = view.findViewById(R.id.select);
        this.bIk.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bHV.ZU();
        this.bIl.isSelected = true;
        this.bHV.notifyDataSetChanged();
        if (this.bIm != null) {
            this.bIm.a(this.bIl);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.bIl = gVar;
            this.bIj.setText(z ? bs(gVar.bIq.name, str) : gVar.bIq.name);
            this.bcx.setVisibility(0);
            this.bcx.setText(gVar.bIq.address);
            if (gVar.bIr || TextUtils.isEmpty(gVar.bIq.address)) {
                this.bcx.setVisibility(8);
            }
            this.bIk.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence bs(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
