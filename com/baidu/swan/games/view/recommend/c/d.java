package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes11.dex */
public class d extends RecyclerView.ViewHolder {
    public TextView cTB;
    public Button cTC;
    public SimpleDraweeView cTq;
    public TextView cTr;

    public d(View view) {
        super(view);
        this.cTq = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.cTr = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.cTB = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.cTC = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
