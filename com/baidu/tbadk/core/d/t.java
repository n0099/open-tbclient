package com.baidu.tbadk.core.d;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
class t implements m {
    final /* synthetic */ s acf;
    private final /* synthetic */ int acg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, int i) {
        this.acf = sVar;
        this.acg = i;
    }

    @Override // com.baidu.tbadk.core.d.m
    public void a(o oVar, JSONObject jSONObject) {
        this.acf.a(oVar, this.acg);
    }

    @Override // com.baidu.tbadk.core.d.m
    public void a(int i, Throwable th) {
        int[] iArr;
        String tL;
        int[] iArr2;
        int[] iArr3;
        if (i == 1) {
            int i2 = this.acg;
            iArr = s.ace;
            if (i2 < iArr.length) {
                this.acf.tM();
            }
            if (this.acg >= 0) {
                int i3 = this.acg;
                iArr2 = s.ace;
                if (i3 < iArr2.length) {
                    s sVar = this.acf;
                    iArr3 = s.ace;
                    sVar.R(String.valueOf(iArr3[this.acg]), "");
                    return;
                }
            }
            BdLog.e("pingIndex " + this.acg + " out of bounds.");
            tL = this.acf.tL();
            e.k(tL, "103", "ping timeout for index " + this.acg);
        }
    }
}
