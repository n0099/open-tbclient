package com.baidu.swan.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.tb4;
import com.baidu.tieba.ub4;
/* loaded from: classes4.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView a;
    public TextView b;
    public View c;
    public LocationDetailAdapter d;
    public ub4 e;
    public tb4 f;

    public LocationDetailViewHolder(View view2, LocationDetailAdapter locationDetailAdapter, tb4 tb4Var) {
        super(view2);
        a(view2);
        this.d = locationDetailAdapter;
        this.f = tb4Var;
    }

    public final void a(View view2) {
        this.a = (TextView) view2.findViewById(R.id.main_title);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923ea);
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f09223e);
        this.c = findViewById;
        findViewById.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        this.d.o();
        this.e.b = true;
        this.d.notifyDataSetChanged();
        tb4 tb4Var = this.f;
        if (tb4Var != null) {
            tb4Var.d(this.e);
        }
    }

    public final CharSequence b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>"));
    }

    public void c(ub4 ub4Var, String str, boolean z) {
        CharSequence charSequence;
        if (ub4Var != null) {
            this.e = ub4Var;
            TextView textView = this.a;
            if (z) {
                charSequence = b(ub4Var.a.name, str);
            } else {
                charSequence = ub4Var.a.name;
            }
            textView.setText(charSequence);
            int i = 0;
            this.b.setVisibility(0);
            this.b.setText(ub4Var.a.address);
            if (ub4Var.c || TextUtils.isEmpty(ub4Var.a.address)) {
                this.b.setVisibility(8);
            }
            View view2 = this.c;
            if (!ub4Var.b) {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }
}
