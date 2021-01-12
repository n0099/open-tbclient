package com.baidu.swan.games.view.recommend.listmode;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes8.dex */
public class ListRecommendViewHolder extends RecyclerView.ViewHolder {
    public SimpleDraweeView elh;
    public TextView eli;
    public TextView els;
    public Button elt;

    public ListRecommendViewHolder(View view) {
        super(view);
        this.elh = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.eli = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.els = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.elt = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
