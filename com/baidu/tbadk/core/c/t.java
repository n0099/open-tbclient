package com.baidu.tbadk.core.c;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
class t implements m {
    final /* synthetic */ s Va;
    private final /* synthetic */ int Vb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, int i) {
        this.Va = sVar;
        this.Vb = i;
    }

    @Override // com.baidu.tbadk.core.c.m
    public void a(o oVar, JSONObject jSONObject) {
        this.Va.a(oVar, this.Vb);
    }

    @Override // com.baidu.tbadk.core.c.m
    public void a(int i, Throwable th) {
        int[] iArr;
        String sC;
        int[] iArr2;
        int[] iArr3;
        if (i == 1) {
            int i2 = this.Vb;
            iArr = s.UZ;
            if (i2 < iArr.length) {
                this.Va.sD();
            }
            if (this.Vb >= 0) {
                int i3 = this.Vb;
                iArr2 = s.UZ;
                if (i3 < iArr2.length) {
                    s sVar = this.Va;
                    iArr3 = s.UZ;
                    sVar.S(String.valueOf(iArr3[this.Vb]), "");
                    return;
                }
            }
            BdLog.e("pingIndex " + this.Vb + " out of bounds.");
            sC = this.Va.sC();
            e.r(sC, "103", "ping timeout for index " + this.Vb);
        }
    }
}
