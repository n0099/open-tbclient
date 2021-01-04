package com.baidu.pass.http;

import java.io.InputStream;
/* loaded from: classes4.dex */
public class MultipartHashMap extends HttpHashMap implements com.baidu.pass.a {
    public a fileWrapper;

    /* loaded from: classes4.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f4132a;

        /* renamed from: b  reason: collision with root package name */
        public String f4133b;
        public String c;
        public InputStream d;

        public a(String str, InputStream inputStream, String str2, String str3) {
            this.f4132a = str;
            this.d = inputStream;
            this.f4133b = str2;
            this.c = str3;
        }

        public String a() {
            String str = this.f4133b;
            return str != null ? str : "nofilename";
        }
    }

    public void put(String str, InputStream inputStream, String str2, String str3) {
        this.fileWrapper = new a(str, inputStream, str2, str3);
    }
}
