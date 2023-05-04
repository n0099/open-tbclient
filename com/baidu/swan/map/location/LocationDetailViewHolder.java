package com.baidu.swan.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.jd4;
import com.baidu.tieba.kd4;
/* loaded from: classes3.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView a;
    public TextView b;
    public View c;
    public LocationDetailAdapter d;
    public kd4 e;
    public jd4 f;

    public LocationDetailViewHolder(View view2, LocationDetailAdapter locationDetailAdapter, jd4 jd4Var) {
        super(view2);
        a(view2);
        this.d = locationDetailAdapter;
        this.f = jd4Var;
    }

    public final void a(View view2) {
        this.a = (TextView) view2.findViewById(R.id.main_title);
        this.b = (TextView) view2.findViewById(R.id.sub_title);
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f091ffc);
        this.c = findViewById;
        findViewById.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        this.d.m();
        this.e.b = true;
        this.d.notifyDataSetChanged();
        jd4 jd4Var = this.f;
        if (jd4Var != null) {
            jd4Var.e(this.e);
        }
    }

    public void update(kd4 kd4Var) {
        update(kd4Var, null, false);
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

    public void update(kd4 kd4Var, String str, boolean z) {
        CharSequence charSequence;
        if (kd4Var != null) {
            this.e = kd4Var;
            TextView textView = this.a;
            if (z) {
                charSequence = b(kd4Var.a.name, str);
            } else {
                charSequence = kd4Var.a.name;
            }
            textView.setText(charSequence);
            int i = 0;
            this.b.setVisibility(0);
            this.b.setText(kd4Var.a.address);
            if (kd4Var.c || TextUtils.isEmpty(kd4Var.a.address)) {
                this.b.setVisibility(8);
            }
            View view2 = this.c;
            if (!kd4Var.b) {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }
}
