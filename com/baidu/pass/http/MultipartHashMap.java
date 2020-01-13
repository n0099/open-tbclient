package com.baidu.pass.http;

import java.io.InputStream;
/* loaded from: classes6.dex */
public class MultipartHashMap extends HttpHashMap {
    public a fileWrapper;

    public void put(String str, InputStream inputStream, String str2, String str3) {
        this.fileWrapper = new a(str, inputStream, str2, str3);
    }

    /* loaded from: classes6.dex */
    static class a {
        public String a;
        public String b;
        public String c;
        public InputStream d;

        public a(String str, InputStream inputStream, String str2, String str3) {
            this.a = str;
            this.d = inputStream;
            this.b = str2;
            this.c = str3;
        }

        public String a() {
            return this.b != null ? this.b : "nofilename";
        }
    }
}
