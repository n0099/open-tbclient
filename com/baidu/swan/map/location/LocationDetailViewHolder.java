package com.baidu.swan.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.kg4;
import com.baidu.tieba.lg4;
/* loaded from: classes4.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView a;
    public TextView b;
    public View c;
    public LocationDetailAdapter d;
    public lg4 e;
    public kg4 f;

    public LocationDetailViewHolder(View view2, LocationDetailAdapter locationDetailAdapter, kg4 kg4Var) {
        super(view2);
        b(view2);
        this.d = locationDetailAdapter;
        this.f = kg4Var;
    }

    public final void b(View view2) {
        this.a = (TextView) view2.findViewById(R.id.main_title);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922d5);
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f092141);
        this.c = findViewById;
        findViewById.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        this.d.n();
        this.e.b = true;
        this.d.notifyDataSetChanged();
        kg4 kg4Var = this.f;
        if (kg4Var != null) {
            kg4Var.d(this.e);
        }
    }

    public void update(lg4 lg4Var) {
        update(lg4Var, null, false);
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

    public void update(lg4 lg4Var, String str, boolean z) {
        CharSequence charSequence;
        if (lg4Var != null) {
            this.e = lg4Var;
            TextView textView = this.a;
            if (z) {
                charSequence = c(lg4Var.a.name, str);
            } else {
                charSequence = lg4Var.a.name;
            }
            textView.setText(charSequence);
            int i = 0;
            this.b.setVisibility(0);
            this.b.setText(lg4Var.a.address);
            if (lg4Var.c || TextUtils.isEmpty(lg4Var.a.address)) {
                this.b.setVisibility(8);
            }
            View view2 = this.c;
            if (!lg4Var.b) {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }
}
