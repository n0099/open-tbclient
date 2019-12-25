package com.baidu.swan.games.view.recommend.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes9.dex */
public class b {
    public View cpR;
    public SimpleDraweeView cpS;
    public TextView cpT;

    public b(Context context) {
        this.cpR = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.cpS = (SimpleDraweeView) this.cpR.findViewById(a.f.swangame_recommend_button_icon);
        this.cpT = (TextView) this.cpR.findViewById(a.f.swangame_recommend_button_name);
    }
}
