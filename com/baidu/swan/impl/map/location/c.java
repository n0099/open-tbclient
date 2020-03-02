package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes12.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private b cwI;
    private TextView cwW;
    private View cwX;
    private g cwY;
    private e cwZ;
    private TextView mSubTitle;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.cwI = bVar;
        this.cwZ = eVar;
    }

    private void init(View view) {
        this.cwW = (TextView) view.findViewById(R.id.main_title);
        this.mSubTitle = (TextView) view.findViewById(R.id.sub_title);
        this.cwX = view.findViewById(R.id.select);
        this.cwX.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cwI.ask();
        this.cwY.isSelected = true;
        this.cwI.notifyDataSetChanged();
        if (this.cwZ != null) {
            this.cwZ.a(this.cwY);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.cwY = gVar;
            this.cwW.setText(z ? bZ(gVar.cxd.name, str) : gVar.cxd.name);
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(gVar.cxd.address);
            if (gVar.cxe || TextUtils.isEmpty(gVar.cxd.address)) {
                this.mSubTitle.setVisibility(8);
            }
            this.cwX.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence bZ(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
