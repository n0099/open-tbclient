package com.baidu.fsg.base.restnet.b;

import android.text.TextUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.fsg.base.restnet.http.HttpStatus;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes2.dex */
public class f implements com.baidu.fsg.base.restnet.rest.e {

    /* renamed from: a  reason: collision with root package name */
    public InputStream f5220a;

    /* renamed from: b  reason: collision with root package name */
    public int f5221b;

    /* renamed from: c  reason: collision with root package name */
    public String f5222c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, List<String>> f5223d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.fsg.base.restnet.http.a f5224e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f5225f;

    public f(InputStream inputStream, int i2, String str, Map<String, List<String>> map) {
        this.f5220a = inputStream;
        this.f5221b = i2;
        this.f5222c = str;
        this.f5223d = map;
    }

    private boolean g() {
        String g2 = d().g();
        return !TextUtils.isEmpty(g2) && g2.contains(AsyncHttpClient.ENCODING_GZIP);
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public int a() throws IOException {
        return this.f5221b;
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public String b() throws IOException {
        return this.f5222c;
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public InputStream c() throws IOException {
        if (g()) {
            return a(this.f5220a);
        }
        return this.f5220a;
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public com.baidu.fsg.base.restnet.http.a d() {
        if (this.f5224e == null) {
            this.f5224e = new com.baidu.fsg.base.restnet.http.a(this.f5223d, false);
        }
        return this.f5224e;
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public HttpStatus e() throws Exception {
        return HttpStatus.valueOf(a());
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public void f() {
        InputStream inputStream = this.f5225f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        InputStream inputStream2 = this.f5220a;
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    private InputStream a(InputStream inputStream) throws IOException {
        if (this.f5225f == null) {
            this.f5225f = new GZIPInputStream(inputStream);
        }
        return this.f5225f;
    }
}
