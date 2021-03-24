package com.baidu.cyberplayer.sdk.extractor;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f4929a;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f4929a == null) {
                f4929a = new a();
            }
            aVar = f4929a;
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
