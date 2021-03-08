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
    public View eoR;
    public SimpleDraweeView eoS;
    public TextView eoT;

    public b(Context context) {
        this.eoR = LayoutInflater.from(context).inflate(a.g.swangame_recommend_button, (ViewGroup) null);
        this.eoS = (SimpleDraweeView) this.eoR.findViewById(a.f.swangame_recommend_button_icon);
        this.eoT = (TextView) this.eoR.findViewById(a.f.swangame_recommend_button_name);
    }
}
