package com.baidu.swan.games.view.recommend.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes8.dex */
public class b {
    public View dzk;
    public SimpleDraweeView dzl;
    public TextView dzm;

    public b(Context context) {
        this.dzk = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.dzl = (SimpleDraweeView) this.dzk.findViewById(a.f.swangame_recommend_button_icon);
        this.dzm = (TextView) this.dzk.findViewById(a.f.swangame_recommend_button_name);
    }
}
