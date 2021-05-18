package com.baidu.media.duplayer;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f8099a;

    /* renamed from: b  reason: collision with root package name */
    public String f8100b;

    /* renamed from: c  reason: collision with root package name */
    public String f8101c;

    /* renamed from: d  reason: collision with root package name */
    public a f8102d;

    /* loaded from: classes2.dex */
    public enum a {
        LIB_TYPE_JAR,
        LIB_TYPE_SO
    }

    public d(int i2, String str, String str2) {
        this.f8099a = str;
        this.f8100b = str2;
        this.f8102d = a.LIB_TYPE_SO;
    }

    public d(int i2, String str, String str2, a aVar) {
        this(i2, str, str2);
        this.f8102d = aVar;
    }

    public String a() {
        return this.f8099a;
    }

    public void b(String str) {
        this.f8101c = str;
    }

    public String c() {
        return this.f8100b;
    }

    public String d() {
        return this.f8101c;
    }

    public a e() {
        return this.f8102d;
    }
}
