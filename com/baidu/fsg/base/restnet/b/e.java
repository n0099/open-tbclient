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
    public final com.baidu.fsg.base.restnet.rest.c f5357a;

    /* renamed from: c  reason: collision with root package name */
    public String f5359c;

    /* renamed from: d  reason: collision with root package name */
    public HttpDefines.HttpMethod f5360d;

    /* renamed from: e  reason: collision with root package name */
    public String f5361e;

    /* renamed from: f  reason: collision with root package name */
    public String f5362f;

    /* renamed from: g  reason: collision with root package name */
    public List<RestNameValuePair> f5363g;

    /* renamed from: h  reason: collision with root package name */
    public RestMultipartEntity f5364h;

    /* renamed from: b  reason: collision with root package name */
    public final com.baidu.fsg.base.restnet.http.a f5358b = new com.baidu.fsg.base.restnet.http.a();

    /* renamed from: i  reason: collision with root package name */
    public int f5365i = -1;

    public e(com.baidu.fsg.base.restnet.rest.c cVar, String str, HttpDefines.HttpMethod httpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2) {
        this.f5357a = cVar;
        this.f5359c = str2;
        this.f5360d = httpMethod;
        this.f5361e = str;
        this.f5363g = list;
        this.f5364h = restMultipartEntity;
    }

    public RestMultipartEntity a() {
        return this.f5364h;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public com.baidu.fsg.base.restnet.http.a b() {
        return this.f5358b;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public HttpDefines.HttpMethod c() {
        return this.f5360d;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public String d() {
        return this.f5361e;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public com.baidu.fsg.base.restnet.rest.e e() throws Exception {
        if (Thread.currentThread().isInterrupted()) {
            return null;
        }
        return this.f5357a.a(this);
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public String f() {
        return this.f5359c;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public void g() {
        this.f5357a.a();
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public int h() {
        return this.f5365i;
    }

    public boolean i() {
        return c() == HttpDefines.HttpMethod.POST;
    }

    public boolean j() {
        return c() == HttpDefines.HttpMethod.GET;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public String k() {
        return this.f5362f;
    }

    public String l() {
        List<RestNameValuePair> list = this.f5363g;
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (RestNameValuePair restNameValuePair : this.f5363g) {
            String name = restNameValuePair.getName();
            String value = restNameValuePair.getValue();
            if (!TextUtils.isEmpty(name)) {
                if (value == null) {
                    value = "";
                }
                try {
                    sb.append(URLEncoder.encode(name, this.f5359c));
                    sb.append(com.alipay.sdk.encrypt.a.f1873h);
                    sb.append(URLEncoder.encode(value, this.f5359c));
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
        this.f5361e = str;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public void b(String str) {
        this.f5362f = str;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public void a(int i2) {
        this.f5365i = i2;
    }
}
