package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class e {
    private static b zE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f a(String str, int i, al alVar, boolean z) {
        if (zE != null) {
            return zE.a(str, i, alVar);
        }
        if (z) {
            return new g(str, i, alVar);
        }
        return new h(str, i, alVar);
    }
}
