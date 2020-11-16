package com.baidu.swan.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView ecE;
    private View ecF;
    private g ecG;
    private e ecH;
    private b ecq;
    private TextView mSubTitle;

    public c(View view, b bVar, e eVar) {
        super(view);
        init(view);
        this.ecq = bVar;
        this.ecH = eVar;
    }

    private void init(View view) {
        this.ecE = (TextView) view.findViewById(R.id.main_title);
        this.mSubTitle = (TextView) view.findViewById(R.id.sub_title);
        this.ecF = view.findViewById(R.id.select);
        this.ecF.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ecq.aZl();
        this.ecG.isSelected = true;
        this.ecq.notifyDataSetChanged();
        if (this.ecH != null) {
            this.ecH.a(this.ecG);
        }
    }

    public void a(g gVar, String str, boolean z) {
        if (gVar != null) {
            this.ecG = gVar;
            this.ecE.setText(z ? m35do(gVar.ecM.name, str) : gVar.ecM.name);
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(gVar.ecM.address);
            if (gVar.ecN || TextUtils.isEmpty(gVar.ecM.address)) {
                this.mSubTitle.setVisibility(8);
            }
            this.ecF.setVisibility(gVar.isSelected ? 0 : 8);
        }
    }

    /* renamed from: do  reason: not valid java name */
    private CharSequence m35do(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
