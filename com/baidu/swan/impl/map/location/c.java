package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private b dDJ;
    private TextView dDX;
    private View dDY;
    private g dDZ;
    private e dEa;
    private TextView mSubTitle;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.dDJ = bVar;
        this.dEa = eVar;
    }

    private void init(View view) {
        this.dDX = (TextView) view.findViewById(R.id.main_title);
        this.mSubTitle = (TextView) view.findViewById(R.id.sub_title);
        this.dDY = view.findViewById(R.id.select);
        this.dDY.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dDJ.aSP();
        this.dDZ.isSelected = true;
        this.dDJ.notifyDataSetChanged();
        if (this.dEa != null) {
            this.dEa.a(this.dDZ);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.dDZ = gVar;
            this.dDX.setText(z ? dd(gVar.dEe.name, str) : gVar.dEe.name);
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(gVar.dEe.address);
            if (gVar.dEf || TextUtils.isEmpty(gVar.dEe.address)) {
                this.mSubTitle.setVisibility(8);
            }
            this.dDY.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence dd(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
