package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes9.dex */
public class d extends RecyclerView.ViewHolder {
    public SimpleDraweeView cpS;
    public TextView cpT;
    public TextView cqd;
    public Button cqe;

    public d(View view) {
        super(view);
        this.cpS = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.cpT = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.cqd = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.cqe = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
