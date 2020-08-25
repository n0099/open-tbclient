package com.baidu.swan.game.ad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes19.dex */
public class d extends b {
    private boolean djj;

    public d(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.jsbridge.a aVar) {
        super(context, adElementInfo, aVar);
        this.djj = false;
    }

    @Override // com.baidu.swan.game.ad.b
    public View aIc() {
        return LayoutInflater.from(this.mContext).inflate(c.f.ng_game_land_play, (ViewGroup) null);
    }

    @Override // com.baidu.swan.game.ad.b
    public void a(RelativeLayout relativeLayout, AdElementInfo adElementInfo) {
        int videoWidth = adElementInfo.getVideoWidth();
        int videoHeight = adElementInfo.getVideoHeight();
        this.bKv = com.baidu.swan.games.view.a.c.aQt();
        this.bKw = com.baidu.swan.games.view.a.c.aQu();
        if (videoWidth < videoHeight) {
            this.djj = true;
            int i = (int) (((this.bKv - videoWidth) / 2) * 0.8d);
            int i2 = (int) (((this.bKv - videoWidth) / 2) * 0.1d);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
            layoutParams.leftMargin = (this.bKv - i) - i2;
            layoutParams.addRule(15);
            layoutParams.removeRule(13);
            layoutParams.removeRule(12);
            layoutParams.bottomMargin = 0;
            relativeLayout.setLayoutParams(layoutParams);
            relativeLayout.setBackgroundColor(this.mResources.getColor(c.b.ng_game_black));
        }
    }

    @Override // com.baidu.swan.game.ad.b
    public String aId() {
        return this.djj ? "reward_banner_land_html" : "reward_banner_html";
    }
}
