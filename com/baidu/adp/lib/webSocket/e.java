package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class e {
    private static b zP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f a(String str, int i, al alVar, boolean z) {
        if (zP != null) {
            return zP.a(str, i, alVar);
        }
        if (z) {
            return new g(str, i, alVar);
        }
        return new h(str, i, alVar);
    }
}
