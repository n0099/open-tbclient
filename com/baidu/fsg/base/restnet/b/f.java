package com.baidu.fsg.base.restnet.b;

import android.text.TextUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.fsg.base.restnet.http.HttpStatus;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes.dex */
public class f implements com.baidu.fsg.base.restnet.rest.e {

    /* renamed from: a  reason: collision with root package name */
    public InputStream f5199a;

    /* renamed from: b  reason: collision with root package name */
    public int f5200b;

    /* renamed from: c  reason: collision with root package name */
    public String f5201c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, List<String>> f5202d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.fsg.base.restnet.http.a f5203e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f5204f;

    public f(InputStream inputStream, int i, String str, Map<String, List<String>> map) {
        this.f5199a = inputStream;
        this.f5200b = i;
        this.f5201c = str;
        this.f5202d = map;
    }

    private boolean g() {
        String g2 = d().g();
        return !TextUtils.isEmpty(g2) && g2.contains(AsyncHttpClient.ENCODING_GZIP);
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public int a() throws IOException {
        return this.f5200b;
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public String b() throws IOException {
        return this.f5201c;
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public InputStream c() throws IOException {
        if (g()) {
            return a(this.f5199a);
        }
        return this.f5199a;
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public com.baidu.fsg.base.restnet.http.a d() {
        if (this.f5203e == null) {
            this.f5203e = new com.baidu.fsg.base.restnet.http.a(this.f5202d, false);
        }
        return this.f5203e;
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public HttpStatus e() throws Exception {
        return HttpStatus.valueOf(a());
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public void f() {
        InputStream inputStream = this.f5204f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        InputStream inputStream2 = this.f5199a;
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    private InputStream a(InputStream inputStream) throws IOException {
        if (this.f5204f == null) {
            this.f5204f = new GZIPInputStream(inputStream);
        }
        return this.f5204f;
    }
}
