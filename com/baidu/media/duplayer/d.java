package com.baidu.media.duplayer;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f8287a;

    /* renamed from: b  reason: collision with root package name */
    public String f8288b;

    /* renamed from: c  reason: collision with root package name */
    public String f8289c;

    /* renamed from: d  reason: collision with root package name */
    public a f8290d;

    /* loaded from: classes2.dex */
    public enum a {
        LIB_TYPE_JAR,
        LIB_TYPE_SO
    }

    public d(int i2, String str, String str2) {
        this.f8287a = str;
        this.f8288b = str2;
        this.f8290d = a.LIB_TYPE_SO;
    }

    public d(int i2, String str, String str2, a aVar) {
        this(i2, str, str2);
        this.f8290d = aVar;
    }

    public String a() {
        return this.f8287a;
    }

    public void b(String str) {
        this.f8289c = str;
    }

    public String c() {
        return this.f8288b;
    }

    public String d() {
        return this.f8289c;
    }

    public a e() {
        return this.f8290d;
    }
}
