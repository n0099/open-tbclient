package com.baidu.fsg.base.restnet.b;

import android.text.TextUtils;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.http.HttpDefines;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public class e implements com.baidu.fsg.base.restnet.rest.d {

    /* renamed from: a  reason: collision with root package name */
    public final com.baidu.fsg.base.restnet.rest.c f5191a;

    /* renamed from: c  reason: collision with root package name */
    public String f5193c;

    /* renamed from: d  reason: collision with root package name */
    public HttpDefines.HttpMethod f5194d;

    /* renamed from: e  reason: collision with root package name */
    public String f5195e;

    /* renamed from: f  reason: collision with root package name */
    public String f5196f;

    /* renamed from: g  reason: collision with root package name */
    public List<RestNameValuePair> f5197g;

    /* renamed from: h  reason: collision with root package name */
    public RestMultipartEntity f5198h;

    /* renamed from: b  reason: collision with root package name */
    public final com.baidu.fsg.base.restnet.http.a f5192b = new com.baidu.fsg.base.restnet.http.a();
    public int i = -1;

    public e(com.baidu.fsg.base.restnet.rest.c cVar, String str, HttpDefines.HttpMethod httpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2) {
        this.f5191a = cVar;
        this.f5193c = str2;
        this.f5194d = httpMethod;
        this.f5195e = str;
        this.f5197g = list;
        this.f5198h = restMultipartEntity;
    }

    public RestMultipartEntity a() {
        return this.f5198h;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public com.baidu.fsg.base.restnet.http.a b() {
        return this.f5192b;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public HttpDefines.HttpMethod c() {
        return this.f5194d;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public String d() {
        return this.f5195e;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public com.baidu.fsg.base.restnet.rest.e e() throws Exception {
        if (Thread.currentThread().isInterrupted()) {
            return null;
        }
        return this.f5191a.a(this);
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public String f() {
        return this.f5193c;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public void g() {
        this.f5191a.a();
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public int h() {
        return this.i;
    }

    public boolean i() {
        return c() == HttpDefines.HttpMethod.POST;
    }

    public boolean j() {
        return c() == HttpDefines.HttpMethod.GET;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public String k() {
        return this.f5196f;
    }

    public String l() {
        List<RestNameValuePair> list = this.f5197g;
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (RestNameValuePair restNameValuePair : this.f5197g) {
            String name = restNameValuePair.getName();
            String value = restNameValuePair.getValue();
            if (!TextUtils.isEmpty(name)) {
                if (value == null) {
                    value = "";
                }
                try {
                    sb.append(URLEncoder.encode(name, this.f5193c));
                    sb.append(com.alipay.sdk.encrypt.a.f1897h);
                    sb.append(URLEncoder.encode(value, this.f5193c));
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
        this.f5195e = str;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public void b(String str) {
        this.f5196f = str;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public void a(int i) {
        this.i = i;
    }
}
