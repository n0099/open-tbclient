package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes12.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private b dgW;
    private TextView dhk;
    private View dhl;
    private g dhm;
    private e dhn;
    private TextView mSubTitle;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.dgW = bVar;
        this.dhn = eVar;
    }

    private void init(View view) {
        this.dhk = (TextView) view.findViewById(R.id.main_title);
        this.mSubTitle = (TextView) view.findViewById(R.id.sub_title);
        this.dhl = view.findViewById(R.id.select);
        this.dhl.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dgW.aEq();
        this.dhm.isSelected = true;
        this.dgW.notifyDataSetChanged();
        if (this.dhn != null) {
            this.dhn.a(this.dhm);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.dhm = gVar;
            this.dhk.setText(z ? cE(gVar.dhr.name, str) : gVar.dhr.name);
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(gVar.dhr.address);
            if (gVar.dhs || TextUtils.isEmpty(gVar.dhr.address)) {
                this.mSubTitle.setVisibility(8);
            }
            this.dhl.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence cE(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
