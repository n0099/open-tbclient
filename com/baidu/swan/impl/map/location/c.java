package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes12.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private b cwH;
    private TextView cwV;
    private View cwW;
    private g cwX;
    private e cwY;
    private TextView mSubTitle;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.cwH = bVar;
        this.cwY = eVar;
    }

    private void init(View view) {
        this.cwV = (TextView) view.findViewById(R.id.main_title);
        this.mSubTitle = (TextView) view.findViewById(R.id.sub_title);
        this.cwW = view.findViewById(R.id.select);
        this.cwW.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cwH.asi();
        this.cwX.isSelected = true;
        this.cwH.notifyDataSetChanged();
        if (this.cwY != null) {
            this.cwY.a(this.cwX);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.cwX = gVar;
            this.cwV.setText(z ? bZ(gVar.cxc.name, str) : gVar.cxc.name);
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(gVar.cxc.address);
            if (gVar.cxd || TextUtils.isEmpty(gVar.cxc.address)) {
                this.mSubTitle.setVisibility(8);
            }
            this.cwW.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence bZ(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
