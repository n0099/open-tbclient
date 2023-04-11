package com.baidu.live.feed.search.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tieba.R;
import com.baidu.tieba.ac0;
/* loaded from: classes2.dex */
public class LiveSearchDeleteEntranceViewHolder extends RecyclerView.ViewHolder {
    public View a;
    public TextView b;
    public ImageView c;

    public LiveSearchDeleteEntranceViewHolder(View view2) {
        super(view2);
        this.a = view2;
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091506);
        this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091505);
    }

    public void a(int i) {
        this.b.setTextColor(ac0.f().a(this.a.getContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
        String r = ac0.f().r();
        if ("day".equals(r)) {
            this.c.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d99);
        } else if (LiveFeedPageSdk.UI_MODE_NIGHT.equals(r)) {
            this.c.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d9a);
        }
    }
}
