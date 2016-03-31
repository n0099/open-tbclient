package com.baidu.tbadk.core.c;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
class s implements l {
    final /* synthetic */ r YK;
    private final /* synthetic */ int YL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, int i) {
        this.YK = rVar;
        this.YL = i;
    }

    @Override // com.baidu.tbadk.core.c.l
    public void a(n nVar, JSONObject jSONObject) {
        this.YK.a(nVar, this.YL);
    }

    @Override // com.baidu.tbadk.core.c.l
    public void a(int i, Throwable th) {
        int[] iArr;
        String uZ;
        int[] iArr2;
        int[] iArr3;
        if (i == 1) {
            int i2 = this.YL;
            iArr = r.YJ;
            if (i2 < iArr.length) {
                this.YK.va();
            }
            if (this.YL >= 0) {
                int i3 = this.YL;
                iArr2 = r.YJ;
                if (i3 < iArr2.length) {
                    r rVar = this.YK;
                    iArr3 = r.YJ;
                    rVar.T(String.valueOf(iArr3[this.YL]), "");
                    return;
                }
            }
            BdLog.e("pingIndex " + this.YL + " out of bounds.");
            uZ = this.YK.uZ();
            d.m(uZ, "103", "ping timeout for index " + this.YL);
        }
    }
}
