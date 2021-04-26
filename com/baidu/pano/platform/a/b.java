package com.baidu.pano.platform.a;

import java.util.Collections;
import java.util.Map;
/* loaded from: classes2.dex */
public interface b {

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f9233a;

        /* renamed from: b  reason: collision with root package name */
        public String f9234b;

        /* renamed from: c  reason: collision with root package name */
        public long f9235c;

        /* renamed from: d  reason: collision with root package name */
        public long f9236d;

        /* renamed from: e  reason: collision with root package name */
        public long f9237e;

        /* renamed from: f  reason: collision with root package name */
        public long f9238f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, String> f9239g = Collections.emptyMap();

        public boolean a() {
            return this.f9237e < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f9238f < System.currentTimeMillis();
        }
    }

    a a(String str);

    void a();

    void a(String str, a aVar);
}
