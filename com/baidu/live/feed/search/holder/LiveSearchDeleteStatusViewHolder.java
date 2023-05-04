package com.baidu.live.feed.search.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tieba.R;
import com.baidu.tieba.dc0;
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
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f091510);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09083b);
        this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09150f);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f091546);
    }

    public void a(int i) {
        this.c.setTextColor(dc0.f().a(this.a.getContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
        String r = dc0.f().r();
        if (r == "day") {
            this.d.setImageResource(R.drawable.obfuscated_res_0x7f080dc6);
            this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080db4);
        } else if (r == LiveFeedPageSdk.UI_MODE_NIGHT) {
            this.d.setImageResource(R.drawable.obfuscated_res_0x7f080dd0);
            this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080db5);
        }
    }
}
