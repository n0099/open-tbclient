package com.baidu.live.feed.search.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tieba.R;
import com.baidu.tieba.jd0;
/* loaded from: classes2.dex */
public class LiveSearchDeleteStatusViewHolder extends RecyclerView.ViewHolder {
    public View a;
    public View b;
    public TextView c;
    public ImageView d;
    public View e;

    public LiveSearchDeleteStatusViewHolder(View view2) {
        super(view2);
        this.a = view2;
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f0914cd);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09081b);
        this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0914cc);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f091503);
    }

    public void a(int i) {
        this.c.setTextColor(jd0.f().a(this.a.getContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
        String r = jd0.f().r();
        if (r == "day") {
            this.d.setImageResource(R.drawable.obfuscated_res_0x7f080d97);
            this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d85);
        } else if (r == LiveFeedPageSdk.UI_MODE_NIGHT) {
            this.d.setImageResource(R.drawable.obfuscated_res_0x7f080da1);
            this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d86);
        }
    }
}
