package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes12.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private b cwU;
    private TextView cxi;
    private View cxj;
    private g cxk;
    private e cxl;
    private TextView mSubTitle;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.cwU = bVar;
        this.cxl = eVar;
    }

    private void init(View view) {
        this.cxi = (TextView) view.findViewById(R.id.main_title);
        this.mSubTitle = (TextView) view.findViewById(R.id.sub_title);
        this.cxj = view.findViewById(R.id.select);
        this.cxj.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cwU.aso();
        this.cxk.isSelected = true;
        this.cwU.notifyDataSetChanged();
        if (this.cxl != null) {
            this.cxl.a(this.cxk);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.cxk = gVar;
            this.cxi.setText(z ? bY(gVar.cxp.name, str) : gVar.cxp.name);
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(gVar.cxp.address);
            if (gVar.cxq || TextUtils.isEmpty(gVar.cxp.address)) {
                this.mSubTitle.setVisibility(8);
            }
            this.cxj.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence bY(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
