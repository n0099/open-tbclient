package com.baidu.tbadk.core.data;

import android.content.Intent;
/* loaded from: classes.dex */
public class av {
    private String caC;
    private String caD;
    private String caE;
    private String caF;

    public void n(bh bhVar) {
        if (bhVar != null) {
            this.caC = bhVar.mRecomWeight;
            this.caD = bhVar.mRecomSource;
            this.caE = bhVar.mRecomAbTag;
            this.caF = bhVar.mRecomExtra;
        }
    }

    public void U(Intent intent) {
        if (intent != null) {
            this.caC = intent.getStringExtra("recom_weight");
            this.caD = intent.getStringExtra("recom_source");
            this.caE = intent.getStringExtra("recom_abtag");
            this.caF = intent.getStringExtra("recom_extra");
        }
    }

    public void V(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.caC);
            intent.putExtra("recom_source", this.caD);
            intent.putExtra("recom_abtag", this.caE);
            intent.putExtra("recom_extra", this.caF);
        }
    }

    public void b(com.baidu.tieba.play.z zVar) {
        if (zVar != null) {
            zVar.iza = this.caC;
            zVar.mSource = this.caD;
            zVar.izd = this.caE;
            zVar.din = this.caF;
        }
    }
}
