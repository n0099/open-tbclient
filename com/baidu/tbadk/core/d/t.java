package com.baidu.tbadk.core.d;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
class t implements m {
    final /* synthetic */ s acJ;
    private final /* synthetic */ int acK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, int i) {
        this.acJ = sVar;
        this.acK = i;
    }

    @Override // com.baidu.tbadk.core.d.m
    public void a(o oVar, JSONObject jSONObject) {
        this.acJ.a(oVar, this.acK);
    }

    @Override // com.baidu.tbadk.core.d.m
    public void a(int i, Throwable th) {
        int[] iArr;
        String uA;
        int[] iArr2;
        int[] iArr3;
        if (i == 1) {
            int i2 = this.acK;
            iArr = s.acI;
            if (i2 < iArr.length) {
                this.acJ.uB();
            }
            if (this.acK >= 0) {
                int i3 = this.acK;
                iArr2 = s.acI;
                if (i3 < iArr2.length) {
                    s sVar = this.acJ;
                    iArr3 = s.acI;
                    sVar.R(String.valueOf(iArr3[this.acK]), "");
                    return;
                }
            }
            BdLog.e("pingIndex " + this.acK + " out of bounds.");
            uA = this.acJ.uA();
            e.k(uA, "103", "ping timeout for index " + this.acK);
        }
    }
}
