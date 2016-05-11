package com.baidu.tbadk.core.c;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
class s implements l {
    final /* synthetic */ r TZ;
    private final /* synthetic */ int Ua;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, int i) {
        this.TZ = rVar;
        this.Ua = i;
    }

    @Override // com.baidu.tbadk.core.c.l
    public void a(n nVar, JSONObject jSONObject) {
        this.TZ.a(nVar, this.Ua);
    }

    @Override // com.baidu.tbadk.core.c.l
    public void a(int i, Throwable th) {
        int[] iArr;
        String sF;
        int[] iArr2;
        int[] iArr3;
        if (i == 1) {
            int i2 = this.Ua;
            iArr = r.TY;
            if (i2 < iArr.length) {
                this.TZ.sG();
            }
            if (this.Ua >= 0) {
                int i3 = this.Ua;
                iArr2 = r.TY;
                if (i3 < iArr2.length) {
                    r rVar = this.TZ;
                    iArr3 = r.TY;
                    rVar.T(String.valueOf(iArr3[this.Ua]), "");
                    return;
                }
            }
            BdLog.e("pingIndex " + this.Ua + " out of bounds.");
            sF = this.TZ.sF();
            d.n(sF, "103", "ping timeout for index " + this.Ua);
        }
    }
}
