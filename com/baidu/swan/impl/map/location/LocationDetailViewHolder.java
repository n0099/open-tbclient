package com.baidu.swan.impl.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView dvr;
    private LocationDetailAdapter epO;
    private TextView eqc;
    private View eqd;
    private c eqe;
    private b eqf;

    public LocationDetailViewHolder(View view, LocationDetailAdapter locationDetailAdapter, b bVar) {
        super(view);
        init(view);
        this.epO = locationDetailAdapter;
        this.eqf = bVar;
    }

    private void init(View view) {
        this.eqc = (TextView) view.findViewById(R.id.main_title);
        this.dvr = (TextView) view.findViewById(R.id.sub_title);
        this.eqd = view.findViewById(R.id.select);
        this.eqd.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.epO.bbc();
        this.eqe.isSelected = true;
        this.epO.notifyDataSetChanged();
        if (this.eqf != null) {
            this.eqf.a(this.eqe);
        }
    }

    public void a(c cVar, String str, boolean z) {
        if (cVar != null) {
            this.eqe = cVar;
            this.eqc.setText(z ? dn(cVar.eqk.name, str) : cVar.eqk.name);
            this.dvr.setVisibility(0);
            this.dvr.setText(cVar.eqk.address);
            if (cVar.eql || TextUtils.isEmpty(cVar.eqk.address)) {
                this.dvr.setVisibility(8);
            }
            this.eqd.setVisibility(cVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence dn(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
