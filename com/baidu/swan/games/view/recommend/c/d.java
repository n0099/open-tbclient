package com.baidu.swan.games.view.recommend.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes2.dex */
public class d extends RecyclerView.ViewHolder {
    public TextView bnB;
    public Button bnC;
    public SimpleDraweeView bnq;
    public TextView bnr;

    public d(View view) {
        super(view);
        this.bnq = (SimpleDraweeView) view.findViewById(a.f.swangame_recommend_item_icon);
        this.bnr = (TextView) view.findViewById(a.f.swangame_recommend_item_name);
        this.bnB = (TextView) view.findViewById(a.f.swangame_recommend_item_detail);
        this.bnC = (Button) view.findViewById(a.f.swangame_recommend_item_play);
    }
}
