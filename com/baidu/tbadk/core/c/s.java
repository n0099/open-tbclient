package com.baidu.tbadk.core.c;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
class s implements l {
    final /* synthetic */ r Uq;
    private final /* synthetic */ int Ur;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, int i) {
        this.Uq = rVar;
        this.Ur = i;
    }

    @Override // com.baidu.tbadk.core.c.l
    public void a(n nVar, JSONObject jSONObject) {
        this.Uq.a(nVar, this.Ur);
    }

    @Override // com.baidu.tbadk.core.c.l
    public void a(int i, Throwable th) {
        int[] iArr;
        String sD;
        int[] iArr2;
        int[] iArr3;
        if (i == 1) {
            int i2 = this.Ur;
            iArr = r.Up;
            if (i2 < iArr.length) {
                this.Uq.sE();
            }
            if (this.Ur >= 0) {
                int i3 = this.Ur;
                iArr2 = r.Up;
                if (i3 < iArr2.length) {
                    r rVar = this.Uq;
                    iArr3 = r.Up;
                    rVar.S(String.valueOf(iArr3[this.Ur]), "");
                    return;
                }
            }
            BdLog.e("pingIndex " + this.Ur + " out of bounds.");
            sD = this.Uq.sD();
            d.r(sD, "103", "ping timeout for index " + this.Ur);
        }
    }
}
