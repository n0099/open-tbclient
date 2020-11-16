package com.baidu.swan.games.view.recommend.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes7.dex */
public class b {
    public View dZT;
    public SimpleDraweeView dZU;
    public TextView dZV;

    public b(Context context) {
        this.dZT = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.dZU = (SimpleDraweeView) this.dZT.findViewById(a.f.swangame_recommend_button_icon);
        this.dZV = (TextView) this.dZT.findViewById(a.f.swangame_recommend_button_name);
    }
}
