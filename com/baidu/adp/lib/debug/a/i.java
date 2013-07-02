package com.baidu.adp.lib.debug.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.adp.lib.debug.a {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0008 */
    @Override // com.baidu.adp.lib.debug.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str) {
        String[] strArr;
        String[] strArr2;
        for (int i = 0; i < strArr.length; i++) {
            strArr2 = this.a.b;
            if (str.contains(strArr2[i])) {
                com.baidu.adp.lib.debug.b.b(com.baidu.adp.lib.debug.b.d() + 1);
                return;
            }
        }
    }
}
