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
    public View cug;
    public SimpleDraweeView cuh;
    public TextView cui;

    public b(Context context) {
        this.cug = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.cuh = (SimpleDraweeView) this.cug.findViewById(a.f.swangame_recommend_button_icon);
        this.cui = (TextView) this.cug.findViewById(a.f.swangame_recommend_button_name);
    }
}
