package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView csI;
    private View csJ;
    private g csK;
    private e csL;
    private b csu;
    private TextView mSubTitle;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.csu = bVar;
        this.csL = eVar;
    }

    private void init(View view) {
        this.csI = (TextView) view.findViewById(R.id.main_title);
        this.mSubTitle = (TextView) view.findViewById(R.id.sub_title);
        this.csJ = view.findViewById(R.id.select);
        this.csJ.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.csu.apC();
        this.csK.isSelected = true;
        this.csu.notifyDataSetChanged();
        if (this.csL != null) {
            this.csL.a(this.csK);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.csK = gVar;
            this.csI.setText(z ? bP(gVar.csP.name, str) : gVar.csP.name);
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(gVar.csP.address);
            if (gVar.csQ || TextUtils.isEmpty(gVar.csP.address)) {
                this.mSubTitle.setVisibility(8);
            }
            this.csJ.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence bP(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
