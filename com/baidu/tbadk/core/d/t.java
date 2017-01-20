package com.baidu.tbadk.core.d;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
class t implements m {
    final /* synthetic */ s Xg;
    private final /* synthetic */ int Xh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, int i) {
        this.Xg = sVar;
        this.Xh = i;
    }

    @Override // com.baidu.tbadk.core.d.m
    public void a(o oVar, JSONObject jSONObject) {
        this.Xg.a(oVar, this.Xh);
    }

    @Override // com.baidu.tbadk.core.d.m
    public void a(int i, Throwable th) {
        int[] iArr;
        String tF;
        int[] iArr2;
        int[] iArr3;
        if (i == 1) {
            int i2 = this.Xh;
            iArr = s.Xf;
            if (i2 < iArr.length) {
                this.Xg.tG();
            }
            if (this.Xh >= 0) {
                int i3 = this.Xh;
                iArr2 = s.Xf;
                if (i3 < iArr2.length) {
                    s sVar = this.Xg;
                    iArr3 = s.Xf;
                    sVar.S(String.valueOf(iArr3[this.Xh]), "");
                    return;
                }
            }
            BdLog.e("pingIndex " + this.Xh + " out of bounds.");
            tF = this.Xg.tF();
            e.q(tF, "103", "ping timeout for index " + this.Xh);
        }
    }
}
