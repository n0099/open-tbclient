package com.baidu.apollon.restnet.rest.httpurlconnection;

import android.text.TextUtils;
import com.baidu.apollon.restnet.http.HttpStatus;
import com.baidu.apollon.restnet.rest.e;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes.dex */
public class d implements e {

    /* renamed from: a  reason: collision with root package name */
    public InputStream f3914a;

    /* renamed from: b  reason: collision with root package name */
    public int f3915b;

    /* renamed from: c  reason: collision with root package name */
    public String f3916c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, List<String>> f3917d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.apollon.restnet.http.a f3918e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f3919f;

    public d(InputStream inputStream, int i2, String str, Map<String, List<String>> map) {
        this.f3914a = inputStream;
        this.f3915b = i2;
        this.f3916c = str;
        this.f3917d = map;
    }

    private boolean g() {
        String g2 = d().g();
        return !TextUtils.isEmpty(g2) && g2.contains(AsyncHttpClient.ENCODING_GZIP);
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public int a() throws IOException {
        return this.f3915b;
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public String b() throws IOException {
        return this.f3916c;
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public InputStream c() throws IOException {
        if (g()) {
            return a(this.f3914a);
        }
        return this.f3914a;
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public com.baidu.apollon.restnet.http.a d() {
        if (this.f3918e == null) {
            this.f3918e = new com.baidu.apollon.restnet.http.a(this.f3917d, false);
        }
        return this.f3918e;
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public HttpStatus e() throws Exception {
        return HttpStatus.valueOf(a());
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public void f() {
        InputStream inputStream = this.f3919f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        InputStream inputStream2 = this.f3914a;
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    private InputStream a(InputStream inputStream) throws IOException {
        if (this.f3919f == null) {
            this.f3919f = new GZIPInputStream(inputStream);
        }
        return this.f3919f;
    }
}
