package com.baidu.adp.framework.message;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class HttpResponsedMessage extends f<byte[]> {
    private int a;
    private Map<String, List<String>> b;
    private String c;
    private String d;
    private String e;

    public HttpResponsedMessage(int i) {
        super(i);
        this.a = -1;
        this.b = null;
        this.c = "";
        this.d = "";
        this.e = "";
    }

    public final void a(String str) {
        this.c = str;
    }

    public final String a() {
        return this.d;
    }

    public final void b(String str) {
        this.d = str;
    }

    public final String b() {
        return this.e;
    }

    public final void c(String str) {
        this.e = str;
    }

    public final synchronized void a(Map<String, List<String>> map) {
        this.b = map;
    }

    public final boolean c() {
        return this.a == 200 || this.a / 100 == 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final byte[] a(byte[] bArr) {
        if (this.c != null && this.c.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.e.a(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        return bArr;
    }

    public final int d() {
        return this.a;
    }

    public final void a(int i, String str) {
        this.a = i;
        if (!c()) {
            a(-1);
            d(str);
        }
    }

    public void a(int i, com.baidu.adp.lib.network.http.e eVar) {
    }
}
