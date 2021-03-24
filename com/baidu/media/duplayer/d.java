package com.baidu.media.duplayer;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f7961a;

    /* renamed from: b  reason: collision with root package name */
    public String f7962b;

    /* renamed from: c  reason: collision with root package name */
    public String f7963c;

    /* renamed from: d  reason: collision with root package name */
    public a f7964d;

    /* loaded from: classes2.dex */
    public enum a {
        LIB_TYPE_JAR,
        LIB_TYPE_SO
    }

    public d(int i, String str, String str2) {
        this.f7961a = str;
        this.f7962b = str2;
        this.f7964d = a.LIB_TYPE_SO;
    }

    public d(int i, String str, String str2, a aVar) {
        this(i, str, str2);
        this.f7964d = aVar;
    }

    public String a() {
        return this.f7961a;
    }

    public void b(String str) {
        this.f7963c = str;
    }

    public String c() {
        return this.f7962b;
    }

    public String d() {
        return this.f7963c;
    }

    public a e() {
        return this.f7964d;
    }
}
