package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes25.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private b dPK;
    private TextView dPY;
    private View dPZ;
    private g dQa;
    private e dQb;
    private TextView mSubTitle;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.dPK = bVar;
        this.dQb = eVar;
    }

    private void init(View view) {
        this.dPY = (TextView) view.findViewById(R.id.main_title);
        this.mSubTitle = (TextView) view.findViewById(R.id.sub_title);
        this.dPZ = view.findViewById(R.id.select);
        this.dPZ.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dPK.aVy();
        this.dQa.isSelected = true;
        this.dPK.notifyDataSetChanged();
        if (this.dQb != null) {
            this.dQb.a(this.dQa);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.dQa = gVar;
            this.dPY.setText(z ? di(gVar.dQf.name, str) : gVar.dQf.name);
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(gVar.dQf.address);
            if (gVar.dQg || TextUtils.isEmpty(gVar.dQf.address)) {
                this.mSubTitle.setVisibility(8);
            }
            this.dPZ.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence di(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
