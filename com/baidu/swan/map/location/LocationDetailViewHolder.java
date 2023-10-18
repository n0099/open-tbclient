package com.baidu.swan.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.bb4;
import com.baidu.tieba.cb4;
/* loaded from: classes4.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView a;
    public TextView b;
    public View c;
    public LocationDetailAdapter d;
    public cb4 e;
    public bb4 f;

    public LocationDetailViewHolder(View view2, LocationDetailAdapter locationDetailAdapter, bb4 bb4Var) {
        super(view2);
        a(view2);
        this.d = locationDetailAdapter;
        this.f = bb4Var;
    }

    public final void a(View view2) {
        this.a = (TextView) view2.findViewById(R.id.main_title);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092311);
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f09217b);
        this.c = findViewById;
        findViewById.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        this.d.n();
        this.e.b = true;
        this.d.notifyDataSetChanged();
        bb4 bb4Var = this.f;
        if (bb4Var != null) {
            bb4Var.d(this.e);
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

    public void c(cb4 cb4Var, String str, boolean z) {
        CharSequence charSequence;
        if (cb4Var != null) {
            this.e = cb4Var;
            TextView textView = this.a;
            if (z) {
                charSequence = b(cb4Var.a.name, str);
            } else {
                charSequence = cb4Var.a.name;
            }
            textView.setText(charSequence);
            int i = 0;
            this.b.setVisibility(0);
            this.b.setText(cb4Var.a.address);
            if (cb4Var.c || TextUtils.isEmpty(cb4Var.a.address)) {
                this.b.setVisibility(8);
            }
            View view2 = this.c;
            if (!cb4Var.b) {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }
}
