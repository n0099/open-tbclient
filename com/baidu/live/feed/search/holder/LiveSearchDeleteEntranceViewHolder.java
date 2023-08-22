package com.baidu.live.feed.search.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tieba.R;
import com.baidu.tieba.id0;
/* loaded from: classes3.dex */
public class LiveSearchDeleteEntranceViewHolder extends RecyclerView.ViewHolder {
    public View a;
    public TextView b;
    public ImageView c;

    public LiveSearchDeleteEntranceViewHolder(View view2) {
        super(view2);
        this.a = view2;
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0915c1);
        this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0915c0);
    }

    public void b(int i) {
        this.b.setTextColor(id0.f().a(this.a.getContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
        String r = id0.f().r();
        if ("day".equals(r)) {
            this.c.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f58);
        } else if ("night".equals(r)) {
            this.c.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f59);
        }
    }
}
