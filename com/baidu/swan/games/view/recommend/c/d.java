package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes7.dex */
public class d extends RecyclerView.ViewHolder {
    public SimpleDraweeView dZU;
    public TextView dZV;
    public TextView eaf;
    public Button eag;

    public d(View view) {
        super(view);
        this.dZU = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.dZV = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.eaf = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.eag = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
