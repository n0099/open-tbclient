package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes19.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private b dBE;
    private TextView dBS;
    private View dBT;
    private g dBU;
    private e dBV;
    private TextView mSubTitle;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.dBE = bVar;
        this.dBV = eVar;
    }

    private void init(View view) {
        this.dBS = (TextView) view.findViewById(R.id.main_title);
        this.mSubTitle = (TextView) view.findViewById(R.id.sub_title);
        this.dBT = view.findViewById(R.id.select);
        this.dBT.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dBE.aSd();
        this.dBU.isSelected = true;
        this.dBE.notifyDataSetChanged();
        if (this.dBV != null) {
            this.dBV.a(this.dBU);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.dBU = gVar;
            this.dBS.setText(z ? dd(gVar.dBZ.name, str) : gVar.dBZ.name);
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(gVar.dBZ.address);
            if (gVar.dCa || TextUtils.isEmpty(gVar.dBZ.address)) {
                this.mSubTitle.setVisibility(8);
            }
            this.dBT.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence dd(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
