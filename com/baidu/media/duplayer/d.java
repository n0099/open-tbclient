package com.baidu.media.duplayer;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f7997a;

    /* renamed from: b  reason: collision with root package name */
    public String f7998b;

    /* renamed from: c  reason: collision with root package name */
    public String f7999c;

    /* renamed from: d  reason: collision with root package name */
    public a f8000d;

    /* loaded from: classes2.dex */
    public enum a {
        LIB_TYPE_JAR,
        LIB_TYPE_SO
    }

    public d(int i, String str, String str2) {
        this.f7997a = str;
        this.f7998b = str2;
        this.f8000d = a.LIB_TYPE_SO;
    }

    public d(int i, String str, String str2, a aVar) {
        this(i, str, str2);
        this.f8000d = aVar;
    }

    public String a() {
        return this.f7997a;
    }

    public void b(String str) {
        this.f7999c = str;
    }

    public String c() {
        return this.f7998b;
    }

    public String d() {
        return this.f7999c;
    }

    public a e() {
        return this.f8000d;
    }
}
