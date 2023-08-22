package com.baidu.live.feed.search.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.id0;
/* loaded from: classes3.dex */
public class ShowAllViewHolder extends RecyclerView.ViewHolder {
    public View a;
    public Context b;
    public TextView c;
    public View d;
    public ImageView e;
    public String f;

    public ShowAllViewHolder(Context context, View view2, String str) {
        super(view2);
        this.a = view2;
        this.b = context;
        this.f = str;
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092204);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f091601);
        this.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09220a);
    }

    public void b(int i) {
        this.c.setText("查看全部");
        if ("recommend".equals(this.f)) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
        }
        String r = id0.f().r();
        if ("day".equals(r)) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080f5a);
        } else if ("night".equals(r)) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080f5b);
        }
    }
}
