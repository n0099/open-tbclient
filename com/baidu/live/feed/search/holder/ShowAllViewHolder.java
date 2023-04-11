package com.baidu.live.feed.search.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tieba.R;
import com.baidu.tieba.ac0;
/* loaded from: classes2.dex */
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
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09207f);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f091543);
        this.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092085);
    }

    public void a(int i) {
        this.c.setText("查看全部");
        if ("recommend".equals(this.f)) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
        }
        String r = ac0.f().r();
        if ("day".equals(r)) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080d9b);
        } else if (LiveFeedPageSdk.UI_MODE_NIGHT.equals(r)) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080d9c);
        }
    }
}
