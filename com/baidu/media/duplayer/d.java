package com.baidu.media.duplayer;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f7999a;

    /* renamed from: b  reason: collision with root package name */
    public String f8000b;

    /* renamed from: c  reason: collision with root package name */
    public String f8001c;

    /* renamed from: d  reason: collision with root package name */
    public a f8002d;

    /* loaded from: classes2.dex */
    public enum a {
        LIB_TYPE_JAR,
        LIB_TYPE_SO
    }

    public d(int i2, String str, String str2) {
        this.f7999a = str;
        this.f8000b = str2;
        this.f8002d = a.LIB_TYPE_SO;
    }

    public d(int i2, String str, String str2, a aVar) {
        this(i2, str, str2);
        this.f8002d = aVar;
    }

    public String a() {
        return this.f7999a;
    }

    public void b(String str) {
        this.f8001c = str;
    }

    public String c() {
        return this.f8000b;
    }

    public String d() {
        return this.f8001c;
    }

    public a e() {
        return this.f8002d;
    }
}
