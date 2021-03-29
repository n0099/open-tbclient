package com.baidu.pass.http;

import java.io.InputStream;
/* loaded from: classes2.dex */
public class MultipartHashMap extends HttpHashMap implements com.baidu.pass.a {
    public a fileWrapper;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f9746a;

        /* renamed from: b  reason: collision with root package name */
        public String f9747b;

        /* renamed from: c  reason: collision with root package name */
        public String f9748c;

        /* renamed from: d  reason: collision with root package name */
        public InputStream f9749d;

        public a(String str, InputStream inputStream, String str2, String str3) {
            this.f9746a = str;
            this.f9749d = inputStream;
            this.f9747b = str2;
            this.f9748c = str3;
        }

        public String a() {
            String str = this.f9747b;
            return str != null ? str : "nofilename";
        }
    }

    public void put(String str, InputStream inputStream, String str2, String str3) {
        this.fileWrapper = new a(str, inputStream, str2, str3);
    }
}
