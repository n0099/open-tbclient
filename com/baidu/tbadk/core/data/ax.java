package com.baidu.tbadk.core.data;

import android.content.Intent;
/* loaded from: classes.dex */
public class ax {
    private String cQE;
    private String cQF;
    private String cQG;
    private String cQH;

    public void s(bj bjVar) {
        if (bjVar != null) {
            this.cQE = bjVar.mRecomWeight;
            this.cQF = bjVar.mRecomSource;
            this.cQG = bjVar.mRecomAbTag;
            this.cQH = bjVar.mRecomExtra;
        }
    }

    public void R(Intent intent) {
        if (intent != null) {
            this.cQE = intent.getStringExtra("recom_weight");
            this.cQF = intent.getStringExtra("recom_source");
            this.cQG = intent.getStringExtra("recom_abtag");
            this.cQH = intent.getStringExtra("recom_extra");
        }
    }

    public void S(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.cQE);
            intent.putExtra("recom_source", this.cQF);
            intent.putExtra("recom_abtag", this.cQG);
            intent.putExtra("recom_extra", this.cQH);
        }
    }

    public void b(com.baidu.tieba.play.y yVar) {
        if (yVar != null) {
            yVar.jyr = this.cQE;
            yVar.mSource = this.cQF;
            yVar.mAbTag = this.cQG;
            yVar.mExtra = this.cQH;
        }
    }
}
