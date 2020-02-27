package com.baidu.fsg.base.restnet.b;

import android.text.TextUtils;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.http.HttpDefines;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
/* loaded from: classes4.dex */
public class e implements com.baidu.fsg.base.restnet.rest.d {
    private final com.baidu.fsg.base.restnet.rest.c a;
    private String c;
    private HttpDefines.HttpMethod d;
    private String e;
    private String f;
    private List<RestNameValuePair> g;
    private RestMultipartEntity h;
    private final com.baidu.fsg.base.restnet.http.a b = new com.baidu.fsg.base.restnet.http.a();
    private int i = -1;

    public e(com.baidu.fsg.base.restnet.rest.c cVar, String str, HttpDefines.HttpMethod httpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2) {
        this.a = cVar;
        this.c = str2;
        this.d = httpMethod;
        this.e = str;
        this.g = list;
        this.h = restMultipartEntity;
    }

    public RestMultipartEntity a() {
        return this.h;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public com.baidu.fsg.base.restnet.http.a b() {
        return this.b;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public HttpDefines.HttpMethod c() {
        return this.d;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public String d() {
        return this.e;
    }

    public void a(String str) {
        this.e = str;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public com.baidu.fsg.base.restnet.rest.e e() throws Exception {
        if (Thread.currentThread().isInterrupted()) {
            return null;
        }
        return this.a.a(this);
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public String f() {
        return this.c;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public void g() {
        this.a.a();
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public int h() {
        return this.i;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public void a(int i) {
        this.i = i;
    }

    public boolean i() {
        return c() == HttpDefines.HttpMethod.POST;
    }

    public boolean j() {
        return c() == HttpDefines.HttpMethod.GET;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public String k() {
        return this.f;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public void b(String str) {
        this.f = str;
    }

    public String l() {
        if (this.g == null || this.g.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (RestNameValuePair restNameValuePair : this.g) {
            String name = restNameValuePair.getName();
            String value = restNameValuePair.getValue();
            if (!TextUtils.isEmpty(name)) {
                if (value == null) {
                    value = "";
                }
                try {
                    sb.append(URLEncoder.encode(name, this.c)).append('=').append(URLEncoder.encode(value, this.c)).append('&');
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        if (sb.length() > 1) {
            sb.replace(sb.length() - 1, sb.length(), "");
        }
        return sb.toString();
    }
}
