package com.baidu.tbadk.core.c;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
class t implements m {
    final /* synthetic */ s Yy;
    private final /* synthetic */ int Yz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, int i) {
        this.Yy = sVar;
        this.Yz = i;
    }

    @Override // com.baidu.tbadk.core.c.m
    public void a(o oVar, JSONObject jSONObject) {
        this.Yy.a(oVar, this.Yz);
    }

    @Override // com.baidu.tbadk.core.c.m
    public void a(int i, Throwable th) {
        int[] iArr;
        String ua;
        int[] iArr2;
        int[] iArr3;
        if (i == 1) {
            int i2 = this.Yz;
            iArr = s.Yx;
            if (i2 < iArr.length) {
                this.Yy.ub();
            }
            if (this.Yz >= 0) {
                int i3 = this.Yz;
                iArr2 = s.Yx;
                if (i3 < iArr2.length) {
                    s sVar = this.Yy;
                    iArr3 = s.Yx;
                    sVar.S(String.valueOf(iArr3[this.Yz]), "");
                    return;
                }
            }
            BdLog.e("pingIndex " + this.Yz + " out of bounds.");
            ua = this.Yy.ua();
            e.q(ua, "103", "ping timeout for index " + this.Yz);
        }
    }
}
