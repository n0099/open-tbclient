package com.baidu.apollon.restnet.rest.httpurlconnection;

import android.text.TextUtils;
import com.baidu.apollon.restnet.RestMultipartEntity;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.http.HttpDefines;
import com.baidu.apollon.restnet.rest.RestHttpNetwork;
import com.baidu.apollon.restnet.rest.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public class RestUrlConnectionRequest implements com.baidu.apollon.restnet.rest.d {

    /* renamed from: a  reason: collision with root package name */
    public final RestHttpNetwork f3784a;

    /* renamed from: c  reason: collision with root package name */
    public String f3786c;

    /* renamed from: d  reason: collision with root package name */
    public HttpDefines.HttpMethod f3787d;

    /* renamed from: e  reason: collision with root package name */
    public String f3788e;

    /* renamed from: f  reason: collision with root package name */
    public String f3789f;

    /* renamed from: g  reason: collision with root package name */
    public List<RestNameValuePair> f3790g;

    /* renamed from: h  reason: collision with root package name */
    public RestMultipartEntity f3791h;

    /* renamed from: b  reason: collision with root package name */
    public final com.baidu.apollon.restnet.http.a f3785b = new com.baidu.apollon.restnet.http.a();
    public int i = -1;

    public RestUrlConnectionRequest(RestHttpNetwork restHttpNetwork, String str, HttpDefines.HttpMethod httpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2) {
        this.f3784a = restHttpNetwork;
        this.f3786c = str2;
        this.f3787d = httpMethod;
        this.f3788e = str;
        this.f3790g = list;
        this.f3791h = restMultipartEntity;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public com.baidu.apollon.restnet.http.a a() {
        return this.f3785b;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public HttpDefines.HttpMethod b() {
        return this.f3787d;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public String c() {
        return this.f3788e;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public e d() throws Exception {
        if (Thread.currentThread().isInterrupted()) {
            return null;
        }
        return this.f3784a.a(this);
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public String e() {
        return this.f3786c;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public void f() {
        this.f3784a.a();
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public int g() {
        return this.i;
    }

    public String getProcessedParams() {
        List<RestNameValuePair> list = this.f3790g;
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (RestNameValuePair restNameValuePair : this.f3790g) {
            String name = restNameValuePair.getName();
            String value = restNameValuePair.getValue();
            if (!TextUtils.isEmpty(name)) {
                if (value == null) {
                    value = "";
                }
                try {
                    sb.append(URLEncoder.encode(name, this.f3786c));
                    sb.append(com.alipay.sdk.encrypt.a.f1897h);
                    sb.append(URLEncoder.encode(value, this.f3786c));
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

    @Override // com.baidu.apollon.restnet.rest.d
    public String h() {
        return this.f3789f;
    }

    public RestMultipartEntity i() {
        return this.f3791h;
    }

    public boolean j() {
        return b() == HttpDefines.HttpMethod.POST;
    }

    public boolean k() {
        return b() == HttpDefines.HttpMethod.GET;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public void a(int i) {
        this.i = i;
    }

    public void b(String str) {
        this.f3788e = str;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public void a(String str) {
        this.f3789f = str;
    }
}
