package com.baidu.live.feed.search.holder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class LiveSearchCompleteEntranceViewHolder extends RecyclerView.ViewHolder {
    public View a;
    public TextView b;
    public TextView c;

    public LiveSearchCompleteEntranceViewHolder(View view2) {
        super(view2);
        this.a = view2;
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0914ff);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091511);
    }
}
