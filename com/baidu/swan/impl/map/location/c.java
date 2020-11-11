package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes25.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private b edY;
    private TextView eem;
    private View een;
    private g eeo;
    private e eep;
    private TextView mSubTitle;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.edY = bVar;
        this.eep = eVar;
    }

    private void init(View view) {
        this.eem = (TextView) view.findViewById(R.id.main_title);
        this.mSubTitle = (TextView) view.findViewById(R.id.sub_title);
        this.een = view.findViewById(R.id.select);
        this.een.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.edY.aZS();
        this.eeo.isSelected = true;
        this.edY.notifyDataSetChanged();
        if (this.eep != null) {
            this.eep.a(this.eeo);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.eeo = gVar;
            this.eem.setText(z ? dp(gVar.eet.name, str) : gVar.eet.name);
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(gVar.eet.address);
            if (gVar.eeu || TextUtils.isEmpty(gVar.eet.address)) {
                this.mSubTitle.setVisibility(8);
            }
            this.een.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence dp(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
