package com.baidu.pass.http;

import java.io.InputStream;
/* loaded from: classes2.dex */
public class MultipartHashMap extends HttpHashMap implements com.baidu.pass.a {
    public a fileWrapper;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f9227a;

        /* renamed from: b  reason: collision with root package name */
        public String f9228b;

        /* renamed from: c  reason: collision with root package name */
        public String f9229c;

        /* renamed from: d  reason: collision with root package name */
        public InputStream f9230d;

        public a(String str, InputStream inputStream, String str2, String str3) {
            this.f9227a = str;
            this.f9230d = inputStream;
            this.f9228b = str2;
            this.f9229c = str3;
        }

        public String a() {
            String str = this.f9228b;
            return str != null ? str : "nofilename";
        }
    }

    public void put(String str, InputStream inputStream, String str2, String str3) {
        this.fileWrapper = new a(str, inputStream, str2, str3);
    }
}
