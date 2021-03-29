package com.baidu.cyberplayer.sdk.extractor;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f4930a;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f4930a == null) {
                f4930a = new a();
            }
            aVar = f4930a;
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
