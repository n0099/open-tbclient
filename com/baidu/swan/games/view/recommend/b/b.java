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
    public View bGb;
    public SimpleDraweeView bGc;
    public TextView bGd;

    public b(Context context) {
        this.bGb = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.bGc = (SimpleDraweeView) this.bGb.findViewById(a.f.swangame_recommend_button_icon);
        this.bGd = (TextView) this.bGb.findViewById(a.f.swangame_recommend_button_name);
    }
}
