package com.baidu.cyberplayer.sdk.extractor;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f1421a = null;

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f1421a == null) {
                f1421a = new a();
            }
            aVar = f1421a;
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
