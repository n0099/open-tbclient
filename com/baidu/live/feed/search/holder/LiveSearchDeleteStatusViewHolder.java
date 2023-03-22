package com.baidu.live.feed.search.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tieba.R;
import com.baidu.tieba.zb0;
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
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f0914ff);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090835);
        this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0914fe);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f091535);
    }

    public void a(int i) {
        this.c.setTextColor(zb0.f().a(this.a.getContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
        String r = zb0.f().r();
        if (r == "day") {
            this.d.setImageResource(R.drawable.obfuscated_res_0x7f080dab);
            this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d99);
        } else if (r == LiveFeedPageSdk.UI_MODE_NIGHT) {
            this.d.setImageResource(R.drawable.obfuscated_res_0x7f080db5);
            this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d9a);
        }
    }
}
