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
    public View ebB;
    public SimpleDraweeView ebC;
    public TextView ebD;

    public b(Context context) {
        this.ebB = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.ebC = (SimpleDraweeView) this.ebB.findViewById(a.f.swangame_recommend_button_icon);
        this.ebD = (TextView) this.ebB.findViewById(a.f.swangame_recommend_button_name);
    }
}
