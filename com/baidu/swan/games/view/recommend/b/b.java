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
    public View dpe;
    public SimpleDraweeView dpf;
    public TextView dpg;

    public b(Context context) {
        this.dpe = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.dpf = (SimpleDraweeView) this.dpe.findViewById(a.f.swangame_recommend_button_icon);
        this.dpg = (TextView) this.dpe.findViewById(a.f.swangame_recommend_button_name);
    }
}
