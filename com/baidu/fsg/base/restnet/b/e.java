package com.baidu.fsg.base.restnet.b;

import android.text.TextUtils;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.http.HttpDefines;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes2.dex */
public class e implements com.baidu.fsg.base.restnet.rest.d {

    /* renamed from: a  reason: collision with root package name */
    public final com.baidu.fsg.base.restnet.rest.c f5211a;

    /* renamed from: c  reason: collision with root package name */
    public String f5213c;

    /* renamed from: d  reason: collision with root package name */
    public HttpDefines.HttpMethod f5214d;

    /* renamed from: e  reason: collision with root package name */
    public String f5215e;

    /* renamed from: f  reason: collision with root package name */
    public String f5216f;

    /* renamed from: g  reason: collision with root package name */
    public List<RestNameValuePair> f5217g;

    /* renamed from: h  reason: collision with root package name */
    public RestMultipartEntity f5218h;

    /* renamed from: b  reason: collision with root package name */
    public final com.baidu.fsg.base.restnet.http.a f5212b = new com.baidu.fsg.base.restnet.http.a();

    /* renamed from: i  reason: collision with root package name */
    public int f5219i = -1;

    public e(com.baidu.fsg.base.restnet.rest.c cVar, String str, HttpDefines.HttpMethod httpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2) {
        this.f5211a = cVar;
        this.f5213c = str2;
        this.f5214d = httpMethod;
        this.f5215e = str;
        this.f5217g = list;
        this.f5218h = restMultipartEntity;
    }

    public RestMultipartEntity a() {
        return this.f5218h;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public com.baidu.fsg.base.restnet.http.a b() {
        return this.f5212b;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public HttpDefines.HttpMethod c() {
        return this.f5214d;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public String d() {
        return this.f5215e;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public com.baidu.fsg.base.restnet.rest.e e() throws Exception {
        if (Thread.currentThread().isInterrupted()) {
            return null;
        }
        return this.f5211a.a(this);
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public String f() {
        return this.f5213c;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public void g() {
        this.f5211a.a();
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public int h() {
        return this.f5219i;
    }

    public boolean i() {
        return c() == HttpDefines.HttpMethod.POST;
    }

    public boolean j() {
        return c() == HttpDefines.HttpMethod.GET;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public String k() {
        return this.f5216f;
    }

    public String l() {
        List<RestNameValuePair> list = this.f5217g;
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (RestNameValuePair restNameValuePair : this.f5217g) {
            String name = restNameValuePair.getName();
            String value = restNameValuePair.getValue();
            if (!TextUtils.isEmpty(name)) {
                if (value == null) {
                    value = "";
                }
                try {
                    sb.append(URLEncoder.encode(name, this.f5213c));
                    sb.append(com.alipay.sdk.encrypt.a.f1873h);
                    sb.append(URLEncoder.encode(value, this.f5213c));
                    sb.append(Typography.amp);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (sb.length() > 1) {
            sb.replace(sb.length() - 1, sb.length(), "");
        }
        return sb.toString();
    }

    public void a(String str) {
        this.f5215e = str;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public void b(String str) {
        this.f5216f = str;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public void a(int i2) {
        this.f5219i = i2;
    }
}
