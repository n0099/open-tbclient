package com.baidu.pano.platform.a;

import java.util.Collections;
import java.util.Map;
/* loaded from: classes2.dex */
public interface b {

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f8905a;

        /* renamed from: b  reason: collision with root package name */
        public String f8906b;

        /* renamed from: c  reason: collision with root package name */
        public long f8907c;

        /* renamed from: d  reason: collision with root package name */
        public long f8908d;

        /* renamed from: e  reason: collision with root package name */
        public long f8909e;

        /* renamed from: f  reason: collision with root package name */
        public long f8910f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, String> f8911g = Collections.emptyMap();

        public boolean a() {
            return this.f8909e < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f8910f < System.currentTimeMillis();
        }
    }

    a a(String str);

    void a();

    void a(String str, a aVar);
}
