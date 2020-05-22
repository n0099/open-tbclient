package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes11.dex */
public class d extends RecyclerView.ViewHolder {
    public TextView deJ;
    public Button deK;
    public SimpleDraweeView dey;
    public TextView dez;

    public d(View view) {
        super(view);
        this.dey = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.dez = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.deJ = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.deK = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
