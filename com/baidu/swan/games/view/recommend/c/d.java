package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes8.dex */
public class d extends RecyclerView.ViewHolder {
    public SimpleDraweeView dzl;
    public TextView dzm;
    public TextView dzw;
    public Button dzx;

    public d(View view) {
        super(view);
        this.dzl = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.dzm = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.dzw = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.dzx = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
