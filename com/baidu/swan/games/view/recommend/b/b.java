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
    public View cTp;
    public SimpleDraweeView cTq;
    public TextView cTr;

    public b(Context context) {
        this.cTp = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.cTq = (SimpleDraweeView) this.cTp.findViewById(a.f.swangame_recommend_button_icon);
        this.cTr = (TextView) this.cTp.findViewById(a.f.swangame_recommend_button_name);
    }
}
