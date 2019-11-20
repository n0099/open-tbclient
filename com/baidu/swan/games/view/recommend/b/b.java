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
    public View bFk;
    public SimpleDraweeView bFl;
    public TextView bFm;

    public b(Context context) {
        this.bFk = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.bFl = (SimpleDraweeView) this.bFk.findViewById(a.f.swangame_recommend_button_icon);
        this.bFm = (TextView) this.bFk.findViewById(a.f.swangame_recommend_button_name);
    }
}
