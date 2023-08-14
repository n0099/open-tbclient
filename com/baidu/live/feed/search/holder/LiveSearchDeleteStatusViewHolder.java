package com.baidu.live.feed.search.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tieba.R;
import com.baidu.tieba.fd0;
/* loaded from: classes3.dex */
public class LiveSearchDeleteStatusViewHolder extends RecyclerView.ViewHolder {
    public View a;
    public View b;
    public TextView c;
    public ImageView d;
    public View e;

    public LiveSearchDeleteStatusViewHolder(View view2) {
        super(view2);
        this.a = view2;
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f0915a6);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090877);
        this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0915a5);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f0915df);
    }

    public void b(int i) {
        this.c.setTextColor(fd0.f().a(this.a.getContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
        String r = fd0.f().r();
        if (r == "day") {
            this.d.setImageResource(R.drawable.obfuscated_res_0x7f080f46);
            this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f34);
        } else if (r == "night") {
            this.d.setImageResource(R.drawable.obfuscated_res_0x7f080f50);
            this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f35);
        }
    }
}
