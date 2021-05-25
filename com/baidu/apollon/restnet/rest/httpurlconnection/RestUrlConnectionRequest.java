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
    public final RestHttpNetwork f3873a;

    /* renamed from: c  reason: collision with root package name */
    public String f3875c;

    /* renamed from: d  reason: collision with root package name */
    public HttpDefines.HttpMethod f3876d;

    /* renamed from: e  reason: collision with root package name */
    public String f3877e;

    /* renamed from: f  reason: collision with root package name */
    public String f3878f;

    /* renamed from: g  reason: collision with root package name */
    public List<RestNameValuePair> f3879g;

    /* renamed from: h  reason: collision with root package name */
    public RestMultipartEntity f3880h;

    /* renamed from: b  reason: collision with root package name */
    public final com.baidu.apollon.restnet.http.a f3874b = new com.baidu.apollon.restnet.http.a();

    /* renamed from: i  reason: collision with root package name */
    public int f3881i = -1;

    public RestUrlConnectionRequest(RestHttpNetwork restHttpNetwork, String str, HttpDefines.HttpMethod httpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2) {
        this.f3873a = restHttpNetwork;
        this.f3875c = str2;
        this.f3876d = httpMethod;
        this.f3877e = str;
        this.f3879g = list;
        this.f3880h = restMultipartEntity;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public com.baidu.apollon.restnet.http.a a() {
        return this.f3874b;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public HttpDefines.HttpMethod b() {
        return this.f3876d;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public String c() {
        return this.f3877e;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public e d() throws Exception {
        if (Thread.currentThread().isInterrupted()) {
            return null;
        }
        return this.f3873a.a(this);
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public String e() {
        return this.f3875c;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public void f() {
        this.f3873a.a();
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public int g() {
        return this.f3881i;
    }

    public String getProcessedParams() {
        List<RestNameValuePair> list = this.f3879g;
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (RestNameValuePair restNameValuePair : this.f3879g) {
            String name = restNameValuePair.getName();
            String value = restNameValuePair.getValue();
            if (!TextUtils.isEmpty(name)) {
                if (value == null) {
                    value = "";
                }
                try {
                    sb.append(URLEncoder.encode(name, this.f3875c));
                    sb.append(com.alipay.sdk.encrypt.a.f1873h);
                    sb.append(URLEncoder.encode(value, this.f3875c));
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
        return this.f3878f;
    }

    public RestMultipartEntity i() {
        return this.f3880h;
    }

    public boolean j() {
        return b() == HttpDefines.HttpMethod.POST;
    }

    public boolean k() {
        return b() == HttpDefines.HttpMethod.GET;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public void a(int i2) {
        this.f3881i = i2;
    }

    public void b(String str) {
        this.f3877e = str;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public void a(String str) {
        this.f3878f = str;
    }
}
