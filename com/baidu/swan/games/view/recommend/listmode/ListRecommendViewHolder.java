package com.baidu.swan.games.view.recommend.listmode;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes8.dex */
public class ListRecommendViewHolder extends RecyclerView.ViewHolder {
    public SimpleDraweeView eoS;
    public TextView eoT;
    public TextView epd;
    public Button epe;

    public ListRecommendViewHolder(View view) {
        super(view);
        this.eoS = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.eoT = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.epd = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.epe = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
