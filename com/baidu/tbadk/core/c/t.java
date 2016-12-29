package com.baidu.tbadk.core.c;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
class t implements m {
    final /* synthetic */ s XS;
    private final /* synthetic */ int XT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, int i) {
        this.XS = sVar;
        this.XT = i;
    }

    @Override // com.baidu.tbadk.core.c.m
    public void a(o oVar, JSONObject jSONObject) {
        this.XS.a(oVar, this.XT);
    }

    @Override // com.baidu.tbadk.core.c.m
    public void a(int i, Throwable th) {
        int[] iArr;
        String tL;
        int[] iArr2;
        int[] iArr3;
        if (i == 1) {
            int i2 = this.XT;
            iArr = s.XR;
            if (i2 < iArr.length) {
                this.XS.tM();
            }
            if (this.XT >= 0) {
                int i3 = this.XT;
                iArr2 = s.XR;
                if (i3 < iArr2.length) {
                    s sVar = this.XS;
                    iArr3 = s.XR;
                    sVar.S(String.valueOf(iArr3[this.XT]), "");
                    return;
                }
            }
            BdLog.e("pingIndex " + this.XT + " out of bounds.");
            tL = this.XS.tL();
            e.q(tL, "103", "ping timeout for index " + this.XT);
        }
    }
}
