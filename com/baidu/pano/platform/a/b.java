package com.baidu.pano.platform.a;

import java.util.Collections;
import java.util.Map;
/* loaded from: classes2.dex */
public interface b {

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f9347a;

        /* renamed from: b  reason: collision with root package name */
        public String f9348b;

        /* renamed from: c  reason: collision with root package name */
        public long f9349c;

        /* renamed from: d  reason: collision with root package name */
        public long f9350d;

        /* renamed from: e  reason: collision with root package name */
        public long f9351e;

        /* renamed from: f  reason: collision with root package name */
        public long f9352f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, String> f9353g = Collections.emptyMap();

        public boolean a() {
            return this.f9351e < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f9352f < System.currentTimeMillis();
        }
    }

    a a(String str);

    void a();

    void a(String str, a aVar);
}
