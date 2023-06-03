package com.baidu.cyberplayer.sdk.extractor;

import com.baidu.cyberplayer.sdk.f;
/* loaded from: classes3.dex */
public class a {
    public static a a;

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
        ExtractorProvider extractorProvider;
        if (z) {
            extractorProvider = d.a();
        } else {
            extractorProvider = null;
        }
        if (extractorProvider == null) {
            extractorProvider = f.b();
        }
        if (extractorProvider == null) {
            return new b();
        }
        return extractorProvider;
    }
}
