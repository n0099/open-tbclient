package com.baidu.swan.game.ad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes5.dex */
public class e extends b {
    public e(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.jsbridge.a aVar) {
        super(context, adElementInfo, aVar);
    }

    @Override // com.baidu.swan.game.ad.b
    public View aRe() {
        return LayoutInflater.from(this.mContext).inflate(c.f.ng_game_portrait_por_play, (ViewGroup) null);
    }

    @Override // com.baidu.swan.game.ad.b
    public void a(RelativeLayout relativeLayout, AdElementInfo adElementInfo) {
    }

    @Override // com.baidu.swan.game.ad.b
    public String aRf() {
        return "reward_banner_html";
    }
}
