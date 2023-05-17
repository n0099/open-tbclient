package com.baidu.live.feed.search.holder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tieba.R;
import com.baidu.tieba.tc0;
/* loaded from: classes3.dex */
public class LiveSearchHistoryRecordViewHolder extends RecyclerView.ViewHolder {
    public View a;
    public TextView b;

    public LiveSearchHistoryRecordViewHolder(View view2) {
        super(view2);
        this.a = view2;
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f16);
    }

    public void a(int i) {
        this.b.setTextColor(tc0.f().a(this.a.getContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
    }
}
