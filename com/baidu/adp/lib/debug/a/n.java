package com.baidu.adp.lib.debug.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.adp.lib.debug.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f457a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.f457a = mVar;
    }

    @Override // com.baidu.adp.lib.debug.a
    public void a(String str) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        strArr = this.f457a.b;
        if (str.contains(strArr[0])) {
            strArr2 = this.f457a.b;
            if (str.contains(strArr2[1])) {
                strArr3 = this.f457a.b;
                if (str.contains(strArr3[2])) {
                    com.baidu.adp.lib.debug.b.c(com.baidu.adp.lib.debug.b.e() + 1);
                }
            }
        }
    }
}
