package com.baidu.tbadk.core.data;

import android.content.Intent;
/* loaded from: classes.dex */
public class ax {
    private String cQp;
    private String cQq;
    private String cQr;
    private String cQs;

    public void s(bj bjVar) {
        if (bjVar != null) {
            this.cQp = bjVar.mRecomWeight;
            this.cQq = bjVar.mRecomSource;
            this.cQr = bjVar.mRecomAbTag;
            this.cQs = bjVar.mRecomExtra;
        }
    }

    public void R(Intent intent) {
        if (intent != null) {
            this.cQp = intent.getStringExtra("recom_weight");
            this.cQq = intent.getStringExtra("recom_source");
            this.cQr = intent.getStringExtra("recom_abtag");
            this.cQs = intent.getStringExtra("recom_extra");
        }
    }

    public void S(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.cQp);
            intent.putExtra("recom_source", this.cQq);
            intent.putExtra("recom_abtag", this.cQr);
            intent.putExtra("recom_extra", this.cQs);
        }
    }

    public void b(com.baidu.tieba.play.y yVar) {
        if (yVar != null) {
            yVar.jwE = this.cQp;
            yVar.mSource = this.cQq;
            yVar.mAbTag = this.cQr;
            yVar.mExtra = this.cQs;
        }
    }
}
