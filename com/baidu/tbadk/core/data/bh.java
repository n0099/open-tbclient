package com.baidu.tbadk.core.data;

import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class bh {
    private String eHN;
    private String recomExtra;
    private String recomSource;
    private String recomWeight;

    public void u(by byVar) {
        if (byVar != null) {
            this.recomWeight = byVar.mRecomWeight;
            this.recomSource = byVar.mRecomSource;
            this.eHN = byVar.mRecomAbTag;
            this.recomExtra = byVar.mRecomExtra;
        }
    }

    public void C(Intent intent) {
        if (intent != null) {
            this.recomWeight = intent.getStringExtra("recom_weight");
            this.recomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
            this.eHN = intent.getStringExtra("recom_abtag");
            this.recomExtra = intent.getStringExtra("recom_extra");
        }
    }

    public void D(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.recomWeight);
            intent.putExtra(IntentConfig.RECOM_SOURCE, this.recomSource);
            intent.putExtra("recom_abtag", this.eHN);
            intent.putExtra("recom_extra", this.recomExtra);
        }
    }

    public void a(com.baidu.tieba.play.o oVar) {
        if (oVar != null) {
            oVar.myq = this.recomWeight;
            oVar.mSource = this.recomSource;
            oVar.myu = this.eHN;
            oVar.mExtra = this.recomExtra;
        }
    }
}
