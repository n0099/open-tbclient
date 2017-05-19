package com.baidu.tbadk.core.d;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
class t implements m {
    final /* synthetic */ s acg;
    private final /* synthetic */ int ach;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, int i) {
        this.acg = sVar;
        this.ach = i;
    }

    @Override // com.baidu.tbadk.core.d.m
    public void a(o oVar, JSONObject jSONObject) {
        this.acg.a(oVar, this.ach);
    }

    @Override // com.baidu.tbadk.core.d.m
    public void a(int i, Throwable th) {
        int[] iArr;
        String tM;
        int[] iArr2;
        int[] iArr3;
        if (i == 1) {
            int i2 = this.ach;
            iArr = s.acf;
            if (i2 < iArr.length) {
                this.acg.tN();
            }
            if (this.ach >= 0) {
                int i3 = this.ach;
                iArr2 = s.acf;
                if (i3 < iArr2.length) {
                    s sVar = this.acg;
                    iArr3 = s.acf;
                    sVar.R(String.valueOf(iArr3[this.ach]), "");
                    return;
                }
            }
            BdLog.e("pingIndex " + this.ach + " out of bounds.");
            tM = this.acg.tM();
            e.k(tM, "103", "ping timeout for index " + this.ach);
        }
    }
}
