package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes11.dex */
public class d extends RecyclerView.ViewHolder {
    public SimpleDraweeView cuh;
    public TextView cui;
    public TextView cuu;
    public Button cuv;

    public d(View view) {
        super(view);
        this.cuh = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.cui = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.cuu = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.cuv = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
