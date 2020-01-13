package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes10.dex */
public class d extends RecyclerView.ViewHolder {
    public SimpleDraweeView cqe;
    public TextView cqf;
    public TextView cqp;
    public Button cqq;

    public d(View view) {
        super(view);
        this.cqe = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.cqf = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.cqp = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.cqq = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
