package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes3.dex */
public class d extends RecyclerView.ViewHolder {
    public SimpleDraweeView dBm;
    public TextView dBn;
    public TextView dBx;
    public Button dBy;

    public d(View view) {
        super(view);
        this.dBm = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.dBn = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.dBx = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.dBy = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
