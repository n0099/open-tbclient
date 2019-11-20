package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes2.dex */
public class d extends RecyclerView.ViewHolder {
    public SimpleDraweeView bFl;
    public TextView bFm;
    public TextView bFw;
    public Button bFx;

    public d(View view) {
        super(view);
        this.bFl = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.bFm = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.bFw = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.bFx = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
