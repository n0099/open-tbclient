package com.baidu.swan.games.view.recommend.listmode;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes9.dex */
public class ListRecommendViewHolder extends RecyclerView.ViewHolder {
    public TextView enB;
    public Button enC;
    public SimpleDraweeView enp;
    public TextView enq;

    public ListRecommendViewHolder(View view) {
        super(view);
        this.enp = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.enq = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.enB = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.enC = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
