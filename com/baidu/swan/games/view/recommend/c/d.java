package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes11.dex */
public class d extends RecyclerView.ViewHolder {
    public SimpleDraweeView cug;
    public TextView cuh;
    public TextView cus;
    public Button cuu;

    public d(View view) {
        super(view);
        this.cug = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.cuh = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.cus = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.cuu = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
