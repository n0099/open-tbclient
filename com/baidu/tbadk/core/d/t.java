package com.baidu.tbadk.core.d;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
class t implements m {
    final /* synthetic */ s acK;
    private final /* synthetic */ int acL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, int i) {
        this.acK = sVar;
        this.acL = i;
    }

    @Override // com.baidu.tbadk.core.d.m
    public void a(o oVar, JSONObject jSONObject) {
        this.acK.a(oVar, this.acL);
    }

    @Override // com.baidu.tbadk.core.d.m
    public void a(int i, Throwable th) {
        int[] iArr;
        String uA;
        int[] iArr2;
        int[] iArr3;
        if (i == 1) {
            int i2 = this.acL;
            iArr = s.acJ;
            if (i2 < iArr.length) {
                this.acK.uB();
            }
            if (this.acL >= 0) {
                int i3 = this.acL;
                iArr2 = s.acJ;
                if (i3 < iArr2.length) {
                    s sVar = this.acK;
                    iArr3 = s.acJ;
                    sVar.R(String.valueOf(iArr3[this.acL]), "");
                    return;
                }
            }
            BdLog.e("pingIndex " + this.acL + " out of bounds.");
            uA = this.acK.uA();
            e.k(uA, "103", "ping timeout for index " + this.acL);
        }
    }
}
