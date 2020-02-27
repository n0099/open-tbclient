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
    public View cue;
    public SimpleDraweeView cuf;
    public TextView cug;

    public b(Context context) {
        this.cue = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.cuf = (SimpleDraweeView) this.cue.findViewById(a.f.swangame_recommend_button_icon);
        this.cug = (TextView) this.cue.findViewById(a.f.swangame_recommend_button_name);
    }
}
