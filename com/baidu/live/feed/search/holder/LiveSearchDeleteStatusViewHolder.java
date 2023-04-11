package com.baidu.live.feed.search.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tieba.R;
import com.baidu.tieba.ac0;
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
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f091502);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090838);
        this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091501);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f091538);
    }

    public void a(int i) {
        this.c.setTextColor(ac0.f().a(this.a.getContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
        String r = ac0.f().r();
        if (r == "day") {
            this.d.setImageResource(R.drawable.obfuscated_res_0x7f080d98);
            this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d86);
        } else if (r == LiveFeedPageSdk.UI_MODE_NIGHT) {
            this.d.setImageResource(R.drawable.obfuscated_res_0x7f080da2);
            this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d87);
        }
    }
}
