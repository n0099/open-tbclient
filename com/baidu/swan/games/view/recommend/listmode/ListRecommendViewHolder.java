package com.baidu.swan.games.view.recommend.listmode;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes4.dex */
public class ListRecommendViewHolder extends RecyclerView.ViewHolder {
    public SimpleDraweeView a;
    public TextView b;
    public TextView c;
    public Button d;

    public ListRecommendViewHolder(View view2) {
        super(view2);
        this.a = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f0922e0);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922e1);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922df);
        this.d = (Button) view2.findViewById(R.id.obfuscated_res_0x7f0922e2);
    }
}
