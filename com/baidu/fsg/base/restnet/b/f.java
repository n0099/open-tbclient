package com.baidu.fsg.base.restnet.b;

import android.text.TextUtils;
import com.baidu.fsg.base.restnet.http.HttpStatus;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes16.dex */
public class f implements com.baidu.fsg.base.restnet.rest.e {

    /* renamed from: a  reason: collision with root package name */
    private InputStream f1466a;
    private int b;
    private String c;
    private Map<String, List<String>> d;
    private com.baidu.fsg.base.restnet.http.a e;
    private InputStream f;

    public f(InputStream inputStream, int i, String str, Map<String, List<String>> map) {
        this.f1466a = inputStream;
        this.b = i;
        this.c = str;
        this.d = map;
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public int a() throws IOException {
        return this.b;
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public String b() throws IOException {
        return this.c;
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public InputStream c() throws IOException {
        return g() ? a(this.f1466a) : this.f1466a;
    }

    private boolean g() {
        String g = d().g();
        return !TextUtils.isEmpty(g) && g.contains("gzip");
    }

    private InputStream a(InputStream inputStream) throws IOException {
        if (this.f == null) {
            this.f = new GZIPInputStream(inputStream);
        }
        return this.f;
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public com.baidu.fsg.base.restnet.http.a d() {
        if (this.e == null) {
            this.e = new com.baidu.fsg.base.restnet.http.a(this.d, false);
        }
        return this.e;
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public HttpStatus e() throws Exception {
        return HttpStatus.valueOf(a());
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public void f() {
        if (this.f != null) {
            try {
                this.f.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.f1466a != null) {
            try {
                this.f1466a.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
