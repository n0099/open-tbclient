package com.baidu.tbadk.core.c;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
class t implements m {
    final /* synthetic */ s Ya;
    private final /* synthetic */ int Yb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, int i) {
        this.Ya = sVar;
        this.Yb = i;
    }

    @Override // com.baidu.tbadk.core.c.m
    public void a(o oVar, JSONObject jSONObject) {
        this.Ya.a(oVar, this.Yb);
    }

    @Override // com.baidu.tbadk.core.c.m
    public void a(int i, Throwable th) {
        int[] iArr;
        String tW;
        int[] iArr2;
        int[] iArr3;
        if (i == 1) {
            int i2 = this.Yb;
            iArr = s.XZ;
            if (i2 < iArr.length) {
                this.Ya.tX();
            }
            if (this.Yb >= 0) {
                int i3 = this.Yb;
                iArr2 = s.XZ;
                if (i3 < iArr2.length) {
                    s sVar = this.Ya;
                    iArr3 = s.XZ;
                    sVar.S(String.valueOf(iArr3[this.Yb]), "");
                    return;
                }
            }
            BdLog.e("pingIndex " + this.Yb + " out of bounds.");
            tW = this.Ya.tW();
            e.q(tW, "103", "ping timeout for index " + this.Yb);
        }
    }
}
