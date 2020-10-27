package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes25.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private b dYh;
    private TextView dYv;
    private View dYw;
    private g dYx;
    private e dYy;
    private TextView mSubTitle;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.dYh = bVar;
        this.dYy = eVar;
    }

    private void init(View view) {
        this.dYv = (TextView) view.findViewById(R.id.main_title);
        this.mSubTitle = (TextView) view.findViewById(R.id.sub_title);
        this.dYw = view.findViewById(R.id.select);
        this.dYw.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dYh.aXs();
        this.dYx.isSelected = true;
        this.dYh.notifyDataSetChanged();
        if (this.dYy != null) {
            this.dYy.a(this.dYx);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.dYx = gVar;
            this.dYv.setText(z ? dp(gVar.dYC.name, str) : gVar.dYC.name);
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(gVar.dYC.address);
            if (gVar.dYD || TextUtils.isEmpty(gVar.dYC.address)) {
                this.mSubTitle.setVisibility(8);
            }
            this.dYw.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence dp(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
