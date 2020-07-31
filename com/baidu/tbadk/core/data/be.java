package com.baidu.tbadk.core.data;

import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class be {
    private String dQw;
    private String recomExtra;
    private String recomSource;
    private String recomWeight;

    public void t(bv bvVar) {
        if (bvVar != null) {
            this.recomWeight = bvVar.mRecomWeight;
            this.recomSource = bvVar.mRecomSource;
            this.dQw = bvVar.mRecomAbTag;
            this.recomExtra = bvVar.mRecomExtra;
        }
    }

    public void A(Intent intent) {
        if (intent != null) {
            this.recomWeight = intent.getStringExtra("recom_weight");
            this.recomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
            this.dQw = intent.getStringExtra("recom_abtag");
            this.recomExtra = intent.getStringExtra("recom_extra");
        }
    }

    public void B(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.recomWeight);
            intent.putExtra(IntentConfig.RECOM_SOURCE, this.recomSource);
            intent.putExtra("recom_abtag", this.dQw);
            intent.putExtra("recom_extra", this.recomExtra);
        }
    }

    public void a(com.baidu.tieba.play.o oVar) {
        if (oVar != null) {
            oVar.lcH = this.recomWeight;
            oVar.mSource = this.recomSource;
            oVar.lcL = this.dQw;
            oVar.mExtra = this.recomExtra;
        }
    }
}
