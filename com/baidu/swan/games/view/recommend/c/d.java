package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes11.dex */
public class d extends RecyclerView.ViewHolder {
    public TextView cTG;
    public Button cTH;
    public SimpleDraweeView cTv;
    public TextView cTw;

    public d(View view) {
        super(view);
        this.cTv = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.cTw = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.cTG = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.cTH = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
