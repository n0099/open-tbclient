package com.baidu.swan.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.oh4;
import com.baidu.tieba.ph4;
/* loaded from: classes4.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView a;
    public TextView b;
    public View c;
    public LocationDetailAdapter d;
    public ph4 e;
    public oh4 f;

    public LocationDetailViewHolder(View view2, LocationDetailAdapter locationDetailAdapter, oh4 oh4Var) {
        super(view2);
        a(view2);
        this.d = locationDetailAdapter;
        this.f = oh4Var;
    }

    public final void a(View view2) {
        this.a = (TextView) view2.findViewById(R.id.main_title);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092284);
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f0920f0);
        this.c = findViewById;
        findViewById.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        this.d.m();
        this.e.b = true;
        this.d.notifyDataSetChanged();
        oh4 oh4Var = this.f;
        if (oh4Var != null) {
            oh4Var.d(this.e);
        }
    }

    public void update(ph4 ph4Var) {
        update(ph4Var, null, false);
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

    public void update(ph4 ph4Var, String str, boolean z) {
        CharSequence charSequence;
        if (ph4Var != null) {
            this.e = ph4Var;
            TextView textView = this.a;
            if (z) {
                charSequence = b(ph4Var.a.name, str);
            } else {
                charSequence = ph4Var.a.name;
            }
            textView.setText(charSequence);
            int i = 0;
            this.b.setVisibility(0);
            this.b.setText(ph4Var.a.address);
            if (ph4Var.c || TextUtils.isEmpty(ph4Var.a.address)) {
                this.b.setVisibility(8);
            }
            View view2 = this.c;
            if (!ph4Var.b) {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }
}
