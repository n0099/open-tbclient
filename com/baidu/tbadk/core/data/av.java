package com.baidu.tbadk.core.data;

import android.content.Intent;
/* loaded from: classes.dex */
public class av {
    private String bIV;
    private String bIW;
    private String bIX;
    private String bIY;

    public void n(bh bhVar) {
        if (bhVar != null) {
            this.bIV = bhVar.mRecomWeight;
            this.bIW = bhVar.mRecomSource;
            this.bIX = bhVar.mRecomAbTag;
            this.bIY = bhVar.mRecomExtra;
        }
    }

    public void O(Intent intent) {
        if (intent != null) {
            this.bIV = intent.getStringExtra("recom_weight");
            this.bIW = intent.getStringExtra("recom_source");
            this.bIX = intent.getStringExtra("recom_abtag");
            this.bIY = intent.getStringExtra("recom_extra");
        }
    }

    public void P(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.bIV);
            intent.putExtra("recom_source", this.bIW);
            intent.putExtra("recom_abtag", this.bIX);
            intent.putExtra("recom_extra", this.bIY);
        }
    }

    public void b(com.baidu.tieba.play.z zVar) {
        if (zVar != null) {
            zVar.iAD = this.bIV;
            zVar.mSource = this.bIW;
            zVar.iAG = this.bIX;
            zVar.eHk = this.bIY;
        }
    }
}
