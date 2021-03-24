package com.baidu.pano.platform.a;

import java.util.Collections;
import java.util.Map;
/* loaded from: classes2.dex */
public interface b {

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f9346a;

        /* renamed from: b  reason: collision with root package name */
        public String f9347b;

        /* renamed from: c  reason: collision with root package name */
        public long f9348c;

        /* renamed from: d  reason: collision with root package name */
        public long f9349d;

        /* renamed from: e  reason: collision with root package name */
        public long f9350e;

        /* renamed from: f  reason: collision with root package name */
        public long f9351f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, String> f9352g = Collections.emptyMap();

        public boolean a() {
            return this.f9350e < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f9351f < System.currentTimeMillis();
        }
    }

    a a(String str);

    void a();

    void a(String str, a aVar);
}
