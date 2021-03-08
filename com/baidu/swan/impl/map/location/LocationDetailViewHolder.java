package com.baidu.swan.impl.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView dwS;
    private TextView erE;
    private View erF;
    private c erG;
    private b erH;
    private LocationDetailAdapter erp;

    public LocationDetailViewHolder(View view, LocationDetailAdapter locationDetailAdapter, b bVar) {
        super(view);
        init(view);
        this.erp = locationDetailAdapter;
        this.erH = bVar;
    }

    private void init(View view) {
        this.erE = (TextView) view.findViewById(R.id.main_title);
        this.dwS = (TextView) view.findViewById(R.id.sub_title);
        this.erF = view.findViewById(R.id.select);
        this.erF.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.erp.bbf();
        this.erG.isSelected = true;
        this.erp.notifyDataSetChanged();
        if (this.erH != null) {
            this.erH.a(this.erG);
        }
    }

    public void a(c cVar, String str, boolean z) {
        if (cVar != null) {
            this.erG = cVar;
            this.erE.setText(z ? dn(cVar.erM.name, str) : cVar.erM.name);
            this.dwS.setVisibility(0);
            this.dwS.setText(cVar.erM.address);
            if (cVar.erN || TextUtils.isEmpty(cVar.erM.address)) {
                this.dwS.setVisibility(8);
            }
            this.erF.setVisibility(cVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence dn(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
