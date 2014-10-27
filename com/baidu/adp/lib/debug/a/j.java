package com.baidu.adp.lib.debug.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.adp.lib.debug.b {
    final /* synthetic */ i gv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.gv = iVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0008 */
    @Override // com.baidu.adp.lib.debug.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void K(String str) {
        String[] strArr;
        String[] strArr2;
        for (int i = 0; i < strArr.length; i++) {
            strArr2 = this.gv.gu;
            if (str.contains(strArr2[i])) {
                com.baidu.adp.lib.debug.d.p(com.baidu.adp.lib.debug.d.cD() + 1);
                return;
            }
        }
    }
}
