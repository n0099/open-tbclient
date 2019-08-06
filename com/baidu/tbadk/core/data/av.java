package com.baidu.tbadk.core.data;

import android.content.Intent;
/* loaded from: classes.dex */
public class av {
    private String bIA;
    private String bIx;
    private String bIy;
    private String bIz;

    public void m(bh bhVar) {
        if (bhVar != null) {
            this.bIx = bhVar.mRecomWeight;
            this.bIy = bhVar.mRecomSource;
            this.bIz = bhVar.mRecomAbTag;
            this.bIA = bhVar.mRecomExtra;
        }
    }

    public void O(Intent intent) {
        if (intent != null) {
            this.bIx = intent.getStringExtra("recom_weight");
            this.bIy = intent.getStringExtra("recom_source");
            this.bIz = intent.getStringExtra("recom_abtag");
            this.bIA = intent.getStringExtra("recom_extra");
        }
    }

    public void P(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.bIx);
            intent.putExtra("recom_source", this.bIy);
            intent.putExtra("recom_abtag", this.bIz);
            intent.putExtra("recom_extra", this.bIA);
        }
    }

    public void b(com.baidu.tieba.play.z zVar) {
        if (zVar != null) {
            zVar.iyB = this.bIx;
            zVar.mSource = this.bIy;
            zVar.iyE = this.bIz;
            zVar.eFB = this.bIA;
        }
    }
}
