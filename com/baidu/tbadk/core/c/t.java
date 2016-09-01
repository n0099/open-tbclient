package com.baidu.tbadk.core.c;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
class t implements m {
    final /* synthetic */ s XN;
    private final /* synthetic */ int XO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, int i) {
        this.XN = sVar;
        this.XO = i;
    }

    @Override // com.baidu.tbadk.core.c.m
    public void a(o oVar, JSONObject jSONObject) {
        this.XN.a(oVar, this.XO);
    }

    @Override // com.baidu.tbadk.core.c.m
    public void a(int i, Throwable th) {
        int[] iArr;
        String tH;
        int[] iArr2;
        int[] iArr3;
        if (i == 1) {
            int i2 = this.XO;
            iArr = s.XM;
            if (i2 < iArr.length) {
                this.XN.tI();
            }
            if (this.XO >= 0) {
                int i3 = this.XO;
                iArr2 = s.XM;
                if (i3 < iArr2.length) {
                    s sVar = this.XN;
                    iArr3 = s.XM;
                    sVar.S(String.valueOf(iArr3[this.XO]), "");
                    return;
                }
            }
            BdLog.e("pingIndex " + this.XO + " out of bounds.");
            tH = this.XN.tH();
            e.q(tH, "103", "ping timeout for index " + this.XO);
        }
    }
}
