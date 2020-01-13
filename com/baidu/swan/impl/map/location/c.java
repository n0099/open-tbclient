package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private b csF;
    private TextView csT;
    private View csU;
    private g csV;
    private e csW;
    private TextView mSubTitle;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.csF = bVar;
        this.csW = eVar;
    }

    private void init(View view) {
        this.csT = (TextView) view.findViewById(R.id.main_title);
        this.mSubTitle = (TextView) view.findViewById(R.id.sub_title);
        this.csU = view.findViewById(R.id.select);
        this.csU.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.csF.apV();
        this.csV.isSelected = true;
        this.csF.notifyDataSetChanged();
        if (this.csW != null) {
            this.csW.a(this.csV);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.csV = gVar;
            this.csT.setText(z ? bQ(gVar.cta.name, str) : gVar.cta.name);
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(gVar.cta.address);
            if (gVar.ctb || TextUtils.isEmpty(gVar.cta.address)) {
                this.mSubTitle.setVisibility(8);
            }
            this.csU.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence bQ(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
