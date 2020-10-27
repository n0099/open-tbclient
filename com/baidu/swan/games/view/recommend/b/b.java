package com.baidu.swan.games.view.recommend.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes10.dex */
public class b {
    public View dVJ;
    public SimpleDraweeView dVK;
    public TextView dVL;

    public b(Context context) {
        this.dVJ = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.dVK = (SimpleDraweeView) this.dVJ.findViewById(a.f.swangame_recommend_button_icon);
        this.dVL = (TextView) this.dVJ.findViewById(a.f.swangame_recommend_button_name);
    }
}
