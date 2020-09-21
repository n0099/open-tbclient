package com.baidu.swan.games.view.recommend.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes3.dex */
public class b {
    public View dBl;
    public SimpleDraweeView dBm;
    public TextView dBn;

    public b(Context context) {
        this.dBl = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.dBm = (SimpleDraweeView) this.dBl.findViewById(a.f.swangame_recommend_button_icon);
        this.dBn = (TextView) this.dBl.findViewById(a.f.swangame_recommend_button_name);
    }
}
