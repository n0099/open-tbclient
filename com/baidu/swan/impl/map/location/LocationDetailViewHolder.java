package com.baidu.swan.impl.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView dxT;
    private TextView esJ;
    private View esK;
    private c esL;
    private b esM;
    private LocationDetailAdapter esv;

    public LocationDetailViewHolder(View view, LocationDetailAdapter locationDetailAdapter, b bVar) {
        super(view);
        init(view);
        this.esv = locationDetailAdapter;
        this.esM = bVar;
    }

    private void init(View view) {
        this.esJ = (TextView) view.findViewById(R.id.main_title);
        this.dxT = (TextView) view.findViewById(R.id.sub_title);
        this.esK = view.findViewById(R.id.select);
        this.esK.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.esv.beI();
        this.esL.isSelected = true;
        this.esv.notifyDataSetChanged();
        if (this.esM != null) {
            this.esM.a(this.esL);
        }
    }

    public void a(c cVar, String str, boolean z) {
        if (cVar != null) {
            this.esL = cVar;
            this.esJ.setText(z ? du(cVar.esR.name, str) : cVar.esR.name);
            this.dxT.setVisibility(0);
            this.dxT.setText(cVar.esR.address);
            if (cVar.esS || TextUtils.isEmpty(cVar.esR.address)) {
                this.dxT.setVisibility(8);
            }
            this.esK.setVisibility(cVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence du(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
