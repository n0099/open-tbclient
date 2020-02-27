package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes11.dex */
public class d extends RecyclerView.ViewHolder {
    public SimpleDraweeView cuf;
    public TextView cug;
    public TextView cuq;
    public Button cus;

    public d(View view) {
        super(view);
        this.cuf = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.cug = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.cuq = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.cus = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
