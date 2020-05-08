package com.baidu.tbadk.core.data;

import android.content.Intent;
/* loaded from: classes.dex */
public class ax {
    private String dpO;
    private String dpP;
    private String dpQ;
    private String dpR;

    public void s(bj bjVar) {
        if (bjVar != null) {
            this.dpO = bjVar.mRecomWeight;
            this.dpP = bjVar.mRecomSource;
            this.dpQ = bjVar.mRecomAbTag;
            this.dpR = bjVar.mRecomExtra;
        }
    }

    public void D(Intent intent) {
        if (intent != null) {
            this.dpO = intent.getStringExtra("recom_weight");
            this.dpP = intent.getStringExtra("recom_source");
            this.dpQ = intent.getStringExtra("recom_abtag");
            this.dpR = intent.getStringExtra("recom_extra");
        }
    }

    public void E(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.dpO);
            intent.putExtra("recom_source", this.dpP);
            intent.putExtra("recom_abtag", this.dpQ);
            intent.putExtra("recom_extra", this.dpR);
        }
    }

    public void b(com.baidu.tieba.play.y yVar) {
        if (yVar != null) {
            yVar.kir = this.dpO;
            yVar.mSource = this.dpP;
            yVar.kiv = this.dpQ;
            yVar.mExtra = this.dpR;
        }
    }
}
