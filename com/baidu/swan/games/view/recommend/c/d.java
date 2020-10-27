package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes10.dex */
public class d extends RecyclerView.ViewHolder {
    public SimpleDraweeView dVK;
    public TextView dVL;
    public TextView dVV;
    public Button dVW;

    public d(View view) {
        super(view);
        this.dVK = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.dVL = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.dVV = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.dVW = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
