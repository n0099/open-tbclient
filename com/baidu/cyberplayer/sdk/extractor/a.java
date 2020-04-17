package com.baidu.cyberplayer.sdk.extractor;
/* loaded from: classes.dex */
public class a {
    private static a a = null;

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public ExtractorProvider a(boolean z) {
        ExtractorProvider a2 = z ? d.a() : null;
        if (a2 == null) {
            a2 = com.baidu.cyberplayer.sdk.d.b();
        }
        return a2 == null ? new b() : a2;
    }
}
