package com.baidu.tbadk.core.data;

import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class bf {
    private String dZP;
    private String recomExtra;
    private String recomSource;
    private String recomWeight;

    public void t(bw bwVar) {
        if (bwVar != null) {
            this.recomWeight = bwVar.mRecomWeight;
            this.recomSource = bwVar.mRecomSource;
            this.dZP = bwVar.mRecomAbTag;
            this.recomExtra = bwVar.mRecomExtra;
        }
    }

    public void C(Intent intent) {
        if (intent != null) {
            this.recomWeight = intent.getStringExtra("recom_weight");
            this.recomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
            this.dZP = intent.getStringExtra("recom_abtag");
            this.recomExtra = intent.getStringExtra("recom_extra");
        }
    }

    public void D(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.recomWeight);
            intent.putExtra(IntentConfig.RECOM_SOURCE, this.recomSource);
            intent.putExtra("recom_abtag", this.dZP);
            intent.putExtra("recom_extra", this.recomExtra);
        }
    }

    public void a(com.baidu.tieba.play.o oVar) {
        if (oVar != null) {
            oVar.ltc = this.recomWeight;
            oVar.mSource = this.recomSource;
            oVar.ltg = this.dZP;
            oVar.mExtra = this.recomExtra;
        }
    }
}
