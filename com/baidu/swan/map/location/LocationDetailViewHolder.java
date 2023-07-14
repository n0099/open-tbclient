package com.baidu.swan.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.hh4;
import com.baidu.tieba.ih4;
/* loaded from: classes4.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView a;
    public TextView b;
    public View c;
    public LocationDetailAdapter d;
    public ih4 e;
    public hh4 f;

    public LocationDetailViewHolder(View view2, LocationDetailAdapter locationDetailAdapter, hh4 hh4Var) {
        super(view2);
        b(view2);
        this.d = locationDetailAdapter;
        this.f = hh4Var;
    }

    public final void b(View view2) {
        this.a = (TextView) view2.findViewById(R.id.main_title);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922b7);
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f092124);
        this.c = findViewById;
        findViewById.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        this.d.n();
        this.e.b = true;
        this.d.notifyDataSetChanged();
        hh4 hh4Var = this.f;
        if (hh4Var != null) {
            hh4Var.d(this.e);
        }
    }

    public void update(ih4 ih4Var) {
        update(ih4Var, null, false);
    }

    public final CharSequence c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>"));
    }

    public void update(ih4 ih4Var, String str, boolean z) {
        CharSequence charSequence;
        if (ih4Var != null) {
            this.e = ih4Var;
            TextView textView = this.a;
            if (z) {
                charSequence = c(ih4Var.a.name, str);
            } else {
                charSequence = ih4Var.a.name;
            }
            textView.setText(charSequence);
            int i = 0;
            this.b.setVisibility(0);
            this.b.setText(ih4Var.a.address);
            if (ih4Var.c || TextUtils.isEmpty(ih4Var.a.address)) {
                this.b.setVisibility(8);
            }
            View view2 = this.c;
            if (!ih4Var.b) {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }
}
