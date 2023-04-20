package com.baidu.swan.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.hd4;
import com.baidu.tieba.id4;
/* loaded from: classes3.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView a;
    public TextView b;
    public View c;
    public LocationDetailAdapter d;
    public id4 e;
    public hd4 f;

    public LocationDetailViewHolder(View view2, LocationDetailAdapter locationDetailAdapter, hd4 hd4Var) {
        super(view2);
        a(view2);
        this.d = locationDetailAdapter;
        this.f = hd4Var;
    }

    public final void a(View view2) {
        this.a = (TextView) view2.findViewById(R.id.main_title);
        this.b = (TextView) view2.findViewById(R.id.sub_title);
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f091fe8);
        this.c = findViewById;
        findViewById.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        this.d.m();
        this.e.b = true;
        this.d.notifyDataSetChanged();
        hd4 hd4Var = this.f;
        if (hd4Var != null) {
            hd4Var.e(this.e);
        }
    }

    public void update(id4 id4Var) {
        update(id4Var, null, false);
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

    public void update(id4 id4Var, String str, boolean z) {
        CharSequence charSequence;
        if (id4Var != null) {
            this.e = id4Var;
            TextView textView = this.a;
            if (z) {
                charSequence = b(id4Var.a.name, str);
            } else {
                charSequence = id4Var.a.name;
            }
            textView.setText(charSequence);
            int i = 0;
            this.b.setVisibility(0);
            this.b.setText(id4Var.a.address);
            if (id4Var.c || TextUtils.isEmpty(id4Var.a.address)) {
                this.b.setVisibility(8);
            }
            View view2 = this.c;
            if (!id4Var.b) {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }
}
