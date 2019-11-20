package com.baidu.tbadk.core.data;

import android.content.Intent;
/* loaded from: classes.dex */
public class av {
    private String bZL;
    private String bZM;
    private String bZN;
    private String bZO;

    public void n(bh bhVar) {
        if (bhVar != null) {
            this.bZL = bhVar.mRecomWeight;
            this.bZM = bhVar.mRecomSource;
            this.bZN = bhVar.mRecomAbTag;
            this.bZO = bhVar.mRecomExtra;
        }
    }

    public void U(Intent intent) {
        if (intent != null) {
            this.bZL = intent.getStringExtra("recom_weight");
            this.bZM = intent.getStringExtra("recom_source");
            this.bZN = intent.getStringExtra("recom_abtag");
            this.bZO = intent.getStringExtra("recom_extra");
        }
    }

    public void V(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.bZL);
            intent.putExtra("recom_source", this.bZM);
            intent.putExtra("recom_abtag", this.bZN);
            intent.putExtra("recom_extra", this.bZO);
        }
    }

    public void b(com.baidu.tieba.play.z zVar) {
        if (zVar != null) {
            zVar.iyj = this.bZL;
            zVar.mSource = this.bZM;
            zVar.iym = this.bZN;
            zVar.dhw = this.bZO;
        }
    }
}
