package com.baidu.tbadk.core.hybrid;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
class ab implements q {
    final /* synthetic */ aa acC;
    private final /* synthetic */ int acD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, int i) {
        this.acC = aaVar;
        this.acD = i;
    }

    @Override // com.baidu.tbadk.core.hybrid.q
    public void a(t tVar, JSONObject jSONObject) {
        this.acC.a(tVar, this.acD);
    }

    @Override // com.baidu.tbadk.core.hybrid.q
    public void b(int i, Throwable th) {
        int[] iArr;
        String tR;
        int[] iArr2;
        int[] iArr3;
        if (i == 1) {
            int i2 = this.acD;
            iArr = aa.acB;
            if (i2 < iArr.length) {
                this.acC.tS();
            }
            if (this.acD >= 0) {
                int i3 = this.acD;
                iArr2 = aa.acB;
                if (i3 < iArr2.length) {
                    aa aaVar = this.acC;
                    iArr3 = aa.acB;
                    aaVar.R(String.valueOf(iArr3[this.acD]), "");
                    return;
                }
            }
            BdLog.e("pingIndex " + this.acD + " out of bounds.");
            tR = this.acC.tR();
            e.k(tR, "103", "ping timeout for index " + this.acD);
        }
    }
}
