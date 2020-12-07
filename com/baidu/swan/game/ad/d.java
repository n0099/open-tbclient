package com.baidu.swan.game.ad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes14.dex */
public class d extends b {
    private boolean dRa;

    public d(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.jsbridge.a aVar) {
        super(context, adElementInfo, aVar);
        this.dRa = false;
    }

    @Override // com.baidu.swan.game.ad.b
    public View aSn() {
        return LayoutInflater.from(this.mContext).inflate(c.f.ng_game_land_play, (ViewGroup) null);
    }

    @Override // com.baidu.swan.game.ad.b
    public void a(RelativeLayout relativeLayout, AdElementInfo adElementInfo) {
        int videoWidth = adElementInfo.getVideoWidth();
        int videoHeight = adElementInfo.getVideoHeight();
        this.cmn = com.baidu.swan.games.view.a.c.baF();
        this.cmo = com.baidu.swan.games.view.a.c.baG();
        if (videoWidth < videoHeight) {
            this.dRa = true;
            int i = (int) (((this.cmn - videoWidth) / 2) * 0.8d);
            int i2 = (int) (((this.cmn - videoWidth) / 2) * 0.1d);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
            layoutParams.leftMargin = (this.cmn - i) - i2;
            layoutParams.addRule(15);
            layoutParams.removeRule(13);
            layoutParams.removeRule(12);
            layoutParams.bottomMargin = 0;
            relativeLayout.setLayoutParams(layoutParams);
            relativeLayout.setBackgroundColor(this.mResources.getColor(c.b.ng_game_black));
        }
    }

    @Override // com.baidu.swan.game.ad.b
    public String aSo() {
        return this.dRa ? "reward_banner_land_html" : "reward_banner_html";
    }
}
