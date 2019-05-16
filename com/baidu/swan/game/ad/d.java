package com.baidu.swan.game.ad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.game.ad.a;
/* loaded from: classes2.dex */
public class d extends c {
    public d(Context context, com.baidu.swan.game.ad.a.a aVar) {
        super(context, aVar);
    }

    @Override // com.baidu.swan.game.ad.c
    public View PR() {
        return LayoutInflater.from(this.c).inflate(a.e.ng_game_land_play, (ViewGroup) null);
    }
}
