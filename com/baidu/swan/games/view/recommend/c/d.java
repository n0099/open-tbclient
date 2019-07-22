package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes2.dex */
public class d extends RecyclerView.ViewHolder {
    public SimpleDraweeView bmS;
    public TextView bmT;
    public TextView bnd;
    public Button bne;

    public d(View view) {
        super(view);
        this.bmS = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.bmT = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.bnd = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.bne = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
