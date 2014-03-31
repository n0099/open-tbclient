package com.baidu.adp.lib.debug.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements com.baidu.adp.lib.debug.b {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // com.baidu.adp.lib.debug.b
    public final void a(String str) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        strArr = this.a.b;
        if (str.contains(strArr[0])) {
            strArr2 = this.a.b;
            if (str.contains(strArr2[1])) {
                strArr3 = this.a.b;
                if (str.contains(strArr3[2])) {
                    com.baidu.adp.lib.debug.c.c(com.baidu.adp.lib.debug.c.e() + 1);
                }
            }
        }
    }
}
