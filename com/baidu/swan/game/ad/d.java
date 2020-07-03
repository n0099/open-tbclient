package com.baidu.swan.game.ad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes11.dex */
public class d extends b {
    public d(Context context, AdElementInfo adElementInfo) {
        super(context, adElementInfo);
    }

    @Override // com.baidu.swan.game.ad.b
    public View axd() {
        return LayoutInflater.from(this.mContext).inflate(c.f.ng_game_land_play, (ViewGroup) null);
    }
}
