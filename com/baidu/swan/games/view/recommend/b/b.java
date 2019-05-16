package com.baidu.swan.games.view.recommend.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes2.dex */
public class b {
    public View bmd;
    public SimpleDraweeView bme;
    public TextView bmf;

    public b(Context context) {
        this.bmd = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.bme = (SimpleDraweeView) this.bmd.findViewById(a.f.swangame_recommend_button_icon);
        this.bmf = (TextView) this.bmd.findViewById(a.f.swangame_recommend_button_name);
    }
}
