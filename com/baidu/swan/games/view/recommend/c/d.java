package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes11.dex */
public class d extends RecyclerView.ViewHolder {
    public SimpleDraweeView djk;
    public TextView djl;
    public TextView djv;
    public Button djw;

    public d(View view) {
        super(view);
        this.djk = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.djl = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.djv = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.djw = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
