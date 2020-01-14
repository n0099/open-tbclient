package com.baidu.tbadk.core.data;

import android.content.Intent;
/* loaded from: classes.dex */
public class ax {
    private String cMm;
    private String cMn;
    private String cMo;
    private String cMp;

    public void s(bj bjVar) {
        if (bjVar != null) {
            this.cMm = bjVar.mRecomWeight;
            this.cMn = bjVar.mRecomSource;
            this.cMo = bjVar.mRecomAbTag;
            this.cMp = bjVar.mRecomExtra;
        }
    }

    public void R(Intent intent) {
        if (intent != null) {
            this.cMm = intent.getStringExtra("recom_weight");
            this.cMn = intent.getStringExtra("recom_source");
            this.cMo = intent.getStringExtra("recom_abtag");
            this.cMp = intent.getStringExtra("recom_extra");
        }
    }

    public void S(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.cMm);
            intent.putExtra("recom_source", this.cMn);
            intent.putExtra("recom_abtag", this.cMo);
            intent.putExtra("recom_extra", this.cMp);
        }
    }

    public void b(com.baidu.tieba.play.y yVar) {
        if (yVar != null) {
            yVar.jvO = this.cMm;
            yVar.mSource = this.cMn;
            yVar.mAbTag = this.cMo;
            yVar.mExtra = this.cMp;
        }
    }
}
