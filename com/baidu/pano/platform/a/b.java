package com.baidu.pano.platform.a;

import java.util.Collections;
import java.util.Map;
/* loaded from: classes4.dex */
public interface b {
    a a(String str);

    void a();

    void a(String str, a aVar);

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f2699a;
        public String b;
        public long c;
        public long d;
        public long e;
        public long f;
        public Map<String, String> g = Collections.emptyMap();

        public boolean a() {
            return this.e < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f < System.currentTimeMillis();
        }
    }
}
