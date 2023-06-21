package com.baidu.live.feed.search.holder;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.de0;
/* loaded from: classes3.dex */
public class LiveSearchHotRankHeaderViewHolder extends RecyclerView.ViewHolder {
    public LiveSearchHotRankHeaderViewHolder(@NonNull View view2) {
        super(view2);
        int i;
        if (!(view2 instanceof ImageView)) {
            return;
        }
        ImageView imageView = (ImageView) view2;
        if ("day".equals(de0.f().r())) {
            i = R.drawable.obfuscated_res_0x7f080f10;
        } else {
            i = R.drawable.obfuscated_res_0x7f080f11;
        }
        imageView.setImageResource(i);
    }
}
