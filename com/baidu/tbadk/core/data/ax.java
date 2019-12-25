package com.baidu.tbadk.core.data;

import android.content.Intent;
/* loaded from: classes.dex */
public class ax {
    private String cMc;
    private String cMd;
    private String cMe;
    private String cMf;

    public void s(bj bjVar) {
        if (bjVar != null) {
            this.cMc = bjVar.mRecomWeight;
            this.cMd = bjVar.mRecomSource;
            this.cMe = bjVar.mRecomAbTag;
            this.cMf = bjVar.mRecomExtra;
        }
    }

    public void R(Intent intent) {
        if (intent != null) {
            this.cMc = intent.getStringExtra("recom_weight");
            this.cMd = intent.getStringExtra("recom_source");
            this.cMe = intent.getStringExtra("recom_abtag");
            this.cMf = intent.getStringExtra("recom_extra");
        }
    }

    public void S(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.cMc);
            intent.putExtra("recom_source", this.cMd);
            intent.putExtra("recom_abtag", this.cMe);
            intent.putExtra("recom_extra", this.cMf);
        }
    }

    public void b(com.baidu.tieba.play.y yVar) {
        if (yVar != null) {
            yVar.jsi = this.cMc;
            yVar.mSource = this.cMd;
            yVar.mAbTag = this.cMe;
            yVar.mExtra = this.cMf;
        }
    }
}
