package com.baidu.tbadk.core.data;

import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class bk {
    private String eQH;
    private String recomExtra;
    private String recomSource;
    private String recomWeight;

    public void u(cb cbVar) {
        if (cbVar != null) {
            this.recomWeight = cbVar.mRecomWeight;
            this.recomSource = cbVar.mRecomSource;
            this.eQH = cbVar.mRecomAbTag;
            this.recomExtra = cbVar.mRecomExtra;
        }
    }

    public void D(Intent intent) {
        if (intent != null) {
            this.recomWeight = intent.getStringExtra("recom_weight");
            this.recomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
            this.eQH = intent.getStringExtra("recom_abtag");
            this.recomExtra = intent.getStringExtra("recom_extra");
        }
    }

    public void E(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.recomWeight);
            intent.putExtra(IntentConfig.RECOM_SOURCE, this.recomSource);
            intent.putExtra("recom_abtag", this.eQH);
            intent.putExtra("recom_extra", this.recomExtra);
        }
    }

    public void a(com.baidu.tieba.play.o oVar) {
        if (oVar != null) {
            oVar.mKz = this.recomWeight;
            oVar.mSource = this.recomSource;
            oVar.mKD = this.eQH;
            oVar.mExtra = this.recomExtra;
        }
    }
}
