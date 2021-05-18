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
    public InputStream f3892a;

    /* renamed from: b  reason: collision with root package name */
    public int f3893b;

    /* renamed from: c  reason: collision with root package name */
    public String f3894c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, List<String>> f3895d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.apollon.restnet.http.a f3896e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f3897f;

    public d(InputStream inputStream, int i2, String str, Map<String, List<String>> map) {
        this.f3892a = inputStream;
        this.f3893b = i2;
        this.f3894c = str;
        this.f3895d = map;
    }

    private boolean g() {
        String g2 = d().g();
        return !TextUtils.isEmpty(g2) && g2.contains(AsyncHttpClient.ENCODING_GZIP);
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public int a() throws IOException {
        return this.f3893b;
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public String b() throws IOException {
        return this.f3894c;
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public InputStream c() throws IOException {
        if (g()) {
            return a(this.f3892a);
        }
        return this.f3892a;
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public com.baidu.apollon.restnet.http.a d() {
        if (this.f3896e == null) {
            this.f3896e = new com.baidu.apollon.restnet.http.a(this.f3895d, false);
        }
        return this.f3896e;
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public HttpStatus e() throws Exception {
        return HttpStatus.valueOf(a());
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public void f() {
        InputStream inputStream = this.f3897f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        InputStream inputStream2 = this.f3892a;
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    private InputStream a(InputStream inputStream) throws IOException {
        if (this.f3897f == null) {
            this.f3897f = new GZIPInputStream(inputStream);
        }
        return this.f3897f;
    }
}
