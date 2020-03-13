package com.baidu.tbadk.core.data;

import android.content.Intent;
/* loaded from: classes.dex */
public class ax {
    private String cQr;
    private String cQs;
    private String cQt;
    private String cQu;

    public void s(bj bjVar) {
        if (bjVar != null) {
            this.cQr = bjVar.mRecomWeight;
            this.cQs = bjVar.mRecomSource;
            this.cQt = bjVar.mRecomAbTag;
            this.cQu = bjVar.mRecomExtra;
        }
    }

    public void R(Intent intent) {
        if (intent != null) {
            this.cQr = intent.getStringExtra("recom_weight");
            this.cQs = intent.getStringExtra("recom_source");
            this.cQt = intent.getStringExtra("recom_abtag");
            this.cQu = intent.getStringExtra("recom_extra");
        }
    }

    public void S(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.cQr);
            intent.putExtra("recom_source", this.cQs);
            intent.putExtra("recom_abtag", this.cQt);
            intent.putExtra("recom_extra", this.cQu);
        }
    }

    public void b(com.baidu.tieba.play.y yVar) {
        if (yVar != null) {
            yVar.jwS = this.cQr;
            yVar.mSource = this.cQs;
            yVar.mAbTag = this.cQt;
            yVar.mExtra = this.cQu;
        }
    }
}
