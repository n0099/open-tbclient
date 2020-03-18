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
    public View cus;
    public SimpleDraweeView cuu;
    public TextView cuv;

    public b(Context context) {
        this.cus = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.cuu = (SimpleDraweeView) this.cus.findViewById(a.f.swangame_recommend_button_icon);
        this.cuv = (TextView) this.cus.findViewById(a.f.swangame_recommend_button_name);
    }
}
