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
    public View elg;
    public SimpleDraweeView elh;
    public TextView eli;

    public b(Context context) {
        this.elg = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.elh = (SimpleDraweeView) this.elg.findViewById(a.f.swangame_recommend_button_icon);
        this.eli = (TextView) this.elg.findViewById(a.f.swangame_recommend_button_name);
    }
}
