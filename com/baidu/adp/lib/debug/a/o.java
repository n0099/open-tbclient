package com.baidu.adp.lib.debug.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.adp.lib.debug.b {
    final /* synthetic */ n gH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.gH = nVar;
    }

    @Override // com.baidu.adp.lib.debug.b
    public void K(String str) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        strArr = this.gH.gG;
        if (str.contains(strArr[0])) {
            strArr2 = this.gH.gG;
            if (str.contains(strArr2[1])) {
                strArr3 = this.gH.gG;
                if (str.contains(strArr3[2])) {
                    com.baidu.adp.lib.debug.d.q(com.baidu.adp.lib.debug.d.cE() + 1);
                }
            }
        }
    }
}
