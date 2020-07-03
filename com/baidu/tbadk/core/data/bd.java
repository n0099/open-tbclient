package com.baidu.tbadk.core.data;

import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class bd {
    private String dKk;
    private String recomExtra;
    private String recomSource;
    private String recomWeight;

    public void s(bu buVar) {
        if (buVar != null) {
            this.recomWeight = buVar.mRecomWeight;
            this.recomSource = buVar.mRecomSource;
            this.dKk = buVar.mRecomAbTag;
            this.recomExtra = buVar.mRecomExtra;
        }
    }

    public void A(Intent intent) {
        if (intent != null) {
            this.recomWeight = intent.getStringExtra("recom_weight");
            this.recomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
            this.dKk = intent.getStringExtra("recom_abtag");
            this.recomExtra = intent.getStringExtra("recom_extra");
        }
    }

    public void B(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.recomWeight);
            intent.putExtra(IntentConfig.RECOM_SOURCE, this.recomSource);
            intent.putExtra("recom_abtag", this.dKk);
            intent.putExtra("recom_extra", this.recomExtra);
        }
    }

    public void b(com.baidu.tieba.play.y yVar) {
        if (yVar != null) {
            yVar.kVo = this.recomWeight;
            yVar.mSource = this.recomSource;
            yVar.kVs = this.dKk;
            yVar.mExtra = this.recomExtra;
        }
    }
}
