package com.baidu.pass.http;

import java.io.InputStream;
/* loaded from: classes2.dex */
public class MultipartHashMap extends HttpHashMap implements com.baidu.pass.a {
    public a fileWrapper;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f9170a;

        /* renamed from: b  reason: collision with root package name */
        public String f9171b;

        /* renamed from: c  reason: collision with root package name */
        public String f9172c;

        /* renamed from: d  reason: collision with root package name */
        public InputStream f9173d;

        public a(String str, InputStream inputStream, String str2, String str3) {
            this.f9170a = str;
            this.f9173d = inputStream;
            this.f9171b = str2;
            this.f9172c = str3;
        }

        public String a() {
            String str = this.f9171b;
            return str != null ? str : "nofilename";
        }
    }

    public void put(String str, InputStream inputStream, String str2, String str3) {
        this.fileWrapper = new a(str, inputStream, str2, str3);
    }
}
