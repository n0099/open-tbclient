package com.baidu.tbadk.core.data;

import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ay {
    private String dDO;
    private String recomExtra;
    private String recomSource;
    private String recomWeight;

    public void t(bk bkVar) {
        if (bkVar != null) {
            this.recomWeight = bkVar.mRecomWeight;
            this.recomSource = bkVar.mRecomSource;
            this.dDO = bkVar.mRecomAbTag;
            this.recomExtra = bkVar.mRecomExtra;
        }
    }

    public void A(Intent intent) {
        if (intent != null) {
            this.recomWeight = intent.getStringExtra("recom_weight");
            this.recomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
            this.dDO = intent.getStringExtra("recom_abtag");
            this.recomExtra = intent.getStringExtra("recom_extra");
        }
    }

    public void B(Intent intent) {
        if (intent != null) {
            intent.putExtra("recom_weight", this.recomWeight);
            intent.putExtra(IntentConfig.RECOM_SOURCE, this.recomSource);
            intent.putExtra("recom_abtag", this.dDO);
            intent.putExtra("recom_extra", this.recomExtra);
        }
    }

    public void b(com.baidu.tieba.play.y yVar) {
        if (yVar != null) {
            yVar.kBr = this.recomWeight;
            yVar.mSource = this.recomSource;
            yVar.kBv = this.dDO;
            yVar.mExtra = this.recomExtra;
        }
    }
}
