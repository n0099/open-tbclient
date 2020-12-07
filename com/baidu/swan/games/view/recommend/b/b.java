package com.baidu.swan.games.view.recommend.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes25.dex */
public class b {
    public View egT;
    public SimpleDraweeView egU;
    public TextView egV;

    public b(Context context) {
        this.egT = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.egU = (SimpleDraweeView) this.egT.findViewById(a.f.swangame_recommend_button_icon);
        this.egV = (TextView) this.egT.findViewById(a.f.swangame_recommend_button_name);
    }
}
