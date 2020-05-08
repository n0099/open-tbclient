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
    public View cTu;
    public SimpleDraweeView cTv;
    public TextView cTw;

    public b(Context context) {
        this.cTu = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.cTv = (SimpleDraweeView) this.cTu.findViewById(a.f.swangame_recommend_button_icon);
        this.cTw = (TextView) this.cTu.findViewById(a.f.swangame_recommend_button_name);
    }
}
