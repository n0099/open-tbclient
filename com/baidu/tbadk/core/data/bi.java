package com.baidu.tbadk.core.data;

import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class bi {
    private String eRF;
    private String recomExtra;
    private String recomSource;
    private String recomWeight;

    public void u(bz bzVar) {
        if (bzVar != null) {
            this.recomWeight = bzVar.mRecomWeight;
            this.recomSource = bzVar.mRecomSource;
            this.eRF = bzVar.mRecomAbTag;
            this.recomExtra = bzVar.mRecomExtra;
        }
    }

    public void D(Intent intent) {
        if (intent != null) {
            this.recomWeight = intent.getStringExtra("recom_weight");
            this.recomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
            this.eRF = intent.getStringExtra("recom_abtag");
            this.recomExtra = intent.getStringExtra("recom_extra");
        }
    }

    public void E(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.recomWeight);
            intent.putExtra(IntentConfig.RECOM_SOURCE, this.recomSource);
            intent.putExtra("recom_abtag", this.eRF);
            intent.putExtra("recom_extra", this.recomExtra);
        }
    }

    public void a(com.baidu.tieba.play.o oVar) {
        if (oVar != null) {
            oVar.mDH = this.recomWeight;
            oVar.mSource = this.recomSource;
            oVar.mDL = this.eRF;
            oVar.mExtra = this.recomExtra;
        }
    }
}
