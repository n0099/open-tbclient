package com.baidu.tbadk.core.d;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
class t implements m {
    final /* synthetic */ s acu;
    private final /* synthetic */ int acv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, int i) {
        this.acu = sVar;
        this.acv = i;
    }

    @Override // com.baidu.tbadk.core.d.m
    public void a(o oVar, JSONObject jSONObject) {
        this.acu.a(oVar, this.acv);
    }

    @Override // com.baidu.tbadk.core.d.m
    public void a(int i, Throwable th) {
        int[] iArr;
        String uc;
        int[] iArr2;
        int[] iArr3;
        if (i == 1) {
            int i2 = this.acv;
            iArr = s.act;
            if (i2 < iArr.length) {
                this.acu.ud();
            }
            if (this.acv >= 0) {
                int i3 = this.acv;
                iArr2 = s.act;
                if (i3 < iArr2.length) {
                    s sVar = this.acu;
                    iArr3 = s.act;
                    sVar.Q(String.valueOf(iArr3[this.acv]), "");
                    return;
                }
            }
            BdLog.e("pingIndex " + this.acv + " out of bounds.");
            uc = this.acu.uc();
            e.p(uc, "103", "ping timeout for index " + this.acv);
        }
    }
}
