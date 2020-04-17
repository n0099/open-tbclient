package com.baidu.tbadk.core.data;

import android.content.Intent;
/* loaded from: classes.dex */
public class ax {
    private String dpK;
    private String dpL;
    private String dpM;
    private String dpN;

    public void s(bj bjVar) {
        if (bjVar != null) {
            this.dpK = bjVar.mRecomWeight;
            this.dpL = bjVar.mRecomSource;
            this.dpM = bjVar.mRecomAbTag;
            this.dpN = bjVar.mRecomExtra;
        }
    }

    public void Q(Intent intent) {
        if (intent != null) {
            this.dpK = intent.getStringExtra("recom_weight");
            this.dpL = intent.getStringExtra("recom_source");
            this.dpM = intent.getStringExtra("recom_abtag");
            this.dpN = intent.getStringExtra("recom_extra");
        }
    }

    public void R(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.dpK);
            intent.putExtra("recom_source", this.dpL);
            intent.putExtra("recom_abtag", this.dpM);
            intent.putExtra("recom_extra", this.dpN);
        }
    }

    public void b(com.baidu.tieba.play.y yVar) {
        if (yVar != null) {
            yVar.kin = this.dpK;
            yVar.mSource = this.dpL;
            yVar.kir = this.dpM;
            yVar.mExtra = this.dpN;
        }
    }
}
