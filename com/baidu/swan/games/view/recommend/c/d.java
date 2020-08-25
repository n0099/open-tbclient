package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes8.dex */
public class d extends RecyclerView.ViewHolder {
    public SimpleDraweeView dzh;
    public TextView dzi;
    public TextView dzs;
    public Button dzt;

    public d(View view) {
        super(view);
        this.dzh = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.dzi = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.dzs = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.dzt = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
