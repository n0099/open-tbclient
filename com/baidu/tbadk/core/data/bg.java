package com.baidu.tbadk.core.data;

import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class bg {
    private String eAO;
    private String recomExtra;
    private String recomSource;
    private String recomWeight;

    public void u(bx bxVar) {
        if (bxVar != null) {
            this.recomWeight = bxVar.mRecomWeight;
            this.recomSource = bxVar.mRecomSource;
            this.eAO = bxVar.mRecomAbTag;
            this.recomExtra = bxVar.mRecomExtra;
        }
    }

    public void C(Intent intent) {
        if (intent != null) {
            this.recomWeight = intent.getStringExtra("recom_weight");
            this.recomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
            this.eAO = intent.getStringExtra("recom_abtag");
            this.recomExtra = intent.getStringExtra("recom_extra");
        }
    }

    public void D(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.recomWeight);
            intent.putExtra(IntentConfig.RECOM_SOURCE, this.recomSource);
            intent.putExtra("recom_abtag", this.eAO);
            intent.putExtra("recom_extra", this.recomExtra);
        }
    }

    public void a(com.baidu.tieba.play.o oVar) {
        if (oVar != null) {
            oVar.mkk = this.recomWeight;
            oVar.mSource = this.recomSource;
            oVar.mko = this.eAO;
            oVar.mExtra = this.recomExtra;
        }
    }
}
