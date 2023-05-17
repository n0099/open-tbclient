package com.baidu.swan.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.se4;
import com.baidu.tieba.te4;
/* loaded from: classes4.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView a;
    public TextView b;
    public View c;
    public LocationDetailAdapter d;
    public te4 e;
    public se4 f;

    public LocationDetailViewHolder(View view2, LocationDetailAdapter locationDetailAdapter, se4 se4Var) {
        super(view2);
        a(view2);
        this.d = locationDetailAdapter;
        this.f = se4Var;
    }

    public final void a(View view2) {
        this.a = (TextView) view2.findViewById(R.id.main_title);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921e6);
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f092058);
        this.c = findViewById;
        findViewById.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        this.d.m();
        this.e.b = true;
        this.d.notifyDataSetChanged();
        se4 se4Var = this.f;
        if (se4Var != null) {
            se4Var.e(this.e);
        }
    }

    public void update(te4 te4Var) {
        update(te4Var, null, false);
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

    public void update(te4 te4Var, String str, boolean z) {
        CharSequence charSequence;
        if (te4Var != null) {
            this.e = te4Var;
            TextView textView = this.a;
            if (z) {
                charSequence = b(te4Var.a.name, str);
            } else {
                charSequence = te4Var.a.name;
            }
            textView.setText(charSequence);
            int i = 0;
            this.b.setVisibility(0);
            this.b.setText(te4Var.a.address);
            if (te4Var.c || TextUtils.isEmpty(te4Var.a.address)) {
                this.b.setVisibility(8);
            }
            View view2 = this.c;
            if (!te4Var.b) {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }
}
