package com.baidu.swan.impl.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView dtg;
    private LocationDetailAdapter enH;
    private TextView enV;
    private View enW;
    private c enX;
    private b enY;

    public LocationDetailViewHolder(View view, LocationDetailAdapter locationDetailAdapter, b bVar) {
        super(view);
        init(view);
        this.enH = locationDetailAdapter;
        this.enY = bVar;
    }

    private void init(View view) {
        this.enV = (TextView) view.findViewById(R.id.main_title);
        this.dtg = (TextView) view.findViewById(R.id.sub_title);
        this.enW = view.findViewById(R.id.select);
        this.enW.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.enH.baP();
        this.enX.isSelected = true;
        this.enH.notifyDataSetChanged();
        if (this.enY != null) {
            this.enY.a(this.enX);
        }
    }

    public void a(c cVar, String str, boolean z) {
        if (cVar != null) {
            this.enX = cVar;
            this.enV.setText(z ? dt(cVar.eod.name, str) : cVar.eod.name);
            this.dtg.setVisibility(0);
            this.dtg.setText(cVar.eod.address);
            if (cVar.eoe || TextUtils.isEmpty(cVar.eod.address)) {
                this.dtg.setVisibility(8);
            }
            this.enW.setVisibility(cVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence dt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
