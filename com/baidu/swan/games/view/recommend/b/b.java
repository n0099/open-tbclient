package com.baidu.swan.games.view.recommend.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes11.dex */
public class b {
    public View dex;
    public SimpleDraweeView dey;
    public TextView dez;

    public b(Context context) {
        this.dex = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.dey = (SimpleDraweeView) this.dex.findViewById(a.f.swangame_recommend_button_icon);
        this.dez = (TextView) this.dex.findViewById(a.f.swangame_recommend_button_name);
    }
}
