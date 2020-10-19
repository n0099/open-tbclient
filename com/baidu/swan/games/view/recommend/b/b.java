package com.baidu.swan.games.view.recommend.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes10.dex */
public class b {
    public View dNm;
    public SimpleDraweeView dNn;
    public TextView dNo;

    public b(Context context) {
        this.dNm = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.dNn = (SimpleDraweeView) this.dNm.findViewById(a.f.swangame_recommend_button_icon);
        this.dNo = (TextView) this.dNm.findViewById(a.f.swangame_recommend_button_name);
    }
}
