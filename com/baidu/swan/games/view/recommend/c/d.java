package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes7.dex */
public class d extends RecyclerView.ViewHolder {
    public SimpleDraweeView dpf;
    public TextView dpg;
    public TextView dpq;
    public Button dpr;

    public d(View view) {
        super(view);
        this.dpf = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.dpg = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.dpq = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.dpr = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
