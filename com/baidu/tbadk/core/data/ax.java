package com.baidu.tbadk.core.data;

import android.content.Intent;
/* loaded from: classes.dex */
public class ax {
    private String cQq;
    private String cQr;
    private String cQs;
    private String cQt;

    public void s(bj bjVar) {
        if (bjVar != null) {
            this.cQq = bjVar.mRecomWeight;
            this.cQr = bjVar.mRecomSource;
            this.cQs = bjVar.mRecomAbTag;
            this.cQt = bjVar.mRecomExtra;
        }
    }

    public void R(Intent intent) {
        if (intent != null) {
            this.cQq = intent.getStringExtra("recom_weight");
            this.cQr = intent.getStringExtra("recom_source");
            this.cQs = intent.getStringExtra("recom_abtag");
            this.cQt = intent.getStringExtra("recom_extra");
        }
    }

    public void S(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.cQq);
            intent.putExtra("recom_source", this.cQr);
            intent.putExtra("recom_abtag", this.cQs);
            intent.putExtra("recom_extra", this.cQt);
        }
    }

    public void b(com.baidu.tieba.play.y yVar) {
        if (yVar != null) {
            yVar.jwG = this.cQq;
            yVar.mSource = this.cQr;
            yVar.mAbTag = this.cQs;
            yVar.mExtra = this.cQt;
        }
    }
}
