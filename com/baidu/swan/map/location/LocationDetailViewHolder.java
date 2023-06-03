package com.baidu.swan.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.kh4;
import com.baidu.tieba.lh4;
/* loaded from: classes4.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView a;
    public TextView b;
    public View c;
    public LocationDetailAdapter d;
    public lh4 e;
    public kh4 f;

    public LocationDetailViewHolder(View view2, LocationDetailAdapter locationDetailAdapter, kh4 kh4Var) {
        super(view2);
        a(view2);
        this.d = locationDetailAdapter;
        this.f = kh4Var;
    }

    public final void a(View view2) {
        this.a = (TextView) view2.findViewById(R.id.main_title);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092219);
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f092086);
        this.c = findViewById;
        findViewById.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        this.d.m();
        this.e.b = true;
        this.d.notifyDataSetChanged();
        kh4 kh4Var = this.f;
        if (kh4Var != null) {
            kh4Var.d(this.e);
        }
    }

    public void update(lh4 lh4Var) {
        update(lh4Var, null, false);
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

    public void update(lh4 lh4Var, String str, boolean z) {
        CharSequence charSequence;
        if (lh4Var != null) {
            this.e = lh4Var;
            TextView textView = this.a;
            if (z) {
                charSequence = b(lh4Var.a.name, str);
            } else {
                charSequence = lh4Var.a.name;
            }
            textView.setText(charSequence);
            int i = 0;
            this.b.setVisibility(0);
            this.b.setText(lh4Var.a.address);
            if (lh4Var.c || TextUtils.isEmpty(lh4Var.a.address)) {
                this.b.setVisibility(8);
            }
            View view2 = this.c;
            if (!lh4Var.b) {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }
}
