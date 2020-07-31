package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes19.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private b drD;
    private TextView drR;
    private View drS;
    private g drT;
    private e drU;
    private TextView mSubTitle;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.drD = bVar;
        this.drU = eVar;
    }

    private void init(View view) {
        this.drR = (TextView) view.findViewById(R.id.main_title);
        this.mSubTitle = (TextView) view.findViewById(R.id.sub_title);
        this.drS = view.findViewById(R.id.select);
        this.drS.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.drD.aJn();
        this.drT.isSelected = true;
        this.drD.notifyDataSetChanged();
        if (this.drU != null) {
            this.drU.a(this.drT);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.drT = gVar;
            this.drR.setText(z ? cJ(gVar.drY.name, str) : gVar.drY.name);
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(gVar.drY.address);
            if (gVar.drZ || TextUtils.isEmpty(gVar.drY.address)) {
                this.mSubTitle.setVisibility(8);
            }
            this.drS.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    private CharSequence cJ(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
