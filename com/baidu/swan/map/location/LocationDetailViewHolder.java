package com.baidu.swan.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.tg4;
import com.baidu.tieba.ug4;
/* loaded from: classes4.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView a;
    public TextView b;
    public View c;
    public LocationDetailAdapter d;
    public ug4 e;
    public tg4 f;

    public LocationDetailViewHolder(View view2, LocationDetailAdapter locationDetailAdapter, tg4 tg4Var) {
        super(view2);
        a(view2);
        this.d = locationDetailAdapter;
        this.f = tg4Var;
    }

    public final void a(View view2) {
        this.a = (TextView) view2.findViewById(R.id.main_title);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09233c);
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f0921a7);
        this.c = findViewById;
        findViewById.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        this.d.n();
        this.e.b = true;
        this.d.notifyDataSetChanged();
        tg4 tg4Var = this.f;
        if (tg4Var != null) {
            tg4Var.d(this.e);
        }
    }

    public void update(ug4 ug4Var) {
        update(ug4Var, null, false);
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

    public void update(ug4 ug4Var, String str, boolean z) {
        CharSequence charSequence;
        if (ug4Var != null) {
            this.e = ug4Var;
            TextView textView = this.a;
            if (z) {
                charSequence = b(ug4Var.a.name, str);
            } else {
                charSequence = ug4Var.a.name;
            }
            textView.setText(charSequence);
            int i = 0;
            this.b.setVisibility(0);
            this.b.setText(ug4Var.a.address);
            if (ug4Var.c || TextUtils.isEmpty(ug4Var.a.address)) {
                this.b.setVisibility(8);
            }
            View view2 = this.c;
            if (!ug4Var.b) {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }
}
