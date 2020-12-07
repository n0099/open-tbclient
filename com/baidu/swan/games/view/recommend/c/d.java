package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes25.dex */
public class d extends RecyclerView.ViewHolder {
    public SimpleDraweeView egU;
    public TextView egV;
    public TextView ehf;
    public Button ehg;

    public d(View view) {
        super(view);
        this.egU = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.egV = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.ehf = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.ehg = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
