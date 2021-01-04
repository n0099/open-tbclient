package com.baidu.swan.games.view.recommend.listmode;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes9.dex */
public class ListRecommendViewHolder extends RecyclerView.ViewHolder {
    public SimpleDraweeView epW;
    public TextView epX;
    public TextView eqh;
    public Button eqi;

    public ListRecommendViewHolder(View view) {
        super(view);
        this.epW = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.epX = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.eqh = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.eqi = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
