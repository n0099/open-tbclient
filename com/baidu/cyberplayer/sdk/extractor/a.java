package com.baidu.cyberplayer.sdk.extractor;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f4965a;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f4965a == null) {
                f4965a = new a();
            }
            aVar = f4965a;
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
