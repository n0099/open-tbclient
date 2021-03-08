package com.baidu.ar.http;

import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.ar.ihttp.IProgressCallback;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class f implements IHttpRequest {
    private IProgressCallback qN;
    private HttpRequestFactory qW;
    private l qZ;
    private o qX = new o();
    private k qY = null;
    private g qK = new g();

    public f(HttpRequestFactory httpRequestFactory) {
        this.qW = httpRequestFactory;
        this.qK.method = "GET";
        this.qK.rd = new HashMap();
        this.qK.rc = new h();
        this.qZ = null;
    }

    private IHttpRequest a(byte[] bArr, String str) {
        if (ao(str)) {
            ((n) this.qY).setData(bArr);
        }
        return this;
    }

    private String a(k kVar) {
        return kVar instanceof n ? "该请求已通过setBody设置请求体数据，不能再使用其他方式添加数据" : kVar instanceof b ? "该请求是FormData方式传输数据，请使用addFormData或addFormField添加请求体数据" : kVar instanceof m ? "该请求是Multipart方式传输数据，请使用addPart、addPartMap或addFile添加请求体数据" : "";
    }

    private void addHeader(String str, String str2) {
        this.qK.rd.put(str, str2);
    }

    private boolean an(String str) {
        if (this.qY != null && !(this.qY instanceof m)) {
            this.qK.ap(a(this.qY));
            return false;
        }
        if (this.qY == null) {
            this.qY = new m();
            this.qY.a(this.qK.rb);
            m mVar = (m) this.qY;
            if (!TextUtils.isEmpty(str)) {
                mVar.at(str);
            }
        } else if (!TextUtils.isEmpty(str)) {
            m mVar2 = (m) this.qY;
            if (!mVar2.isEmpty() && !str.equals(mVar2.getBoundary())) {
                this.qK.ap("已经添加请求体内容，不能再更改boundary");
                return false;
            }
        }
        return true;
    }

    private boolean ao(String str) {
        if (this.qY != null && !(this.qY instanceof n)) {
            this.qK.ap(a(this.qY));
            return false;
        }
        if (this.qY == null) {
            this.qY = new n();
            this.qY.a(this.qK.rb);
        }
        if (!TextUtils.isEmpty(str) && !this.qK.rd.containsKey("Content-Type")) {
            addHeader("Content-Type", str);
        }
        return true;
    }

    private boolean eL() {
        if (this.qY != null && !(this.qY instanceof b)) {
            this.qK.ap(a(this.qY));
            return false;
        }
        if (this.qY == null) {
            this.qY = new b();
            this.qY.a(this.qK.rb);
        }
        return true;
    }

    private g eM() {
        if (this.qK.hasError()) {
            throw new HttpException(3, this.qK.eN());
        }
        if (this.qK.rb != null) {
            addHeader("charset", this.qK.rb.name());
        }
        try {
            this.qK.url = this.qX.eO();
            if (this.qY != null) {
                if (!this.qK.rd.containsKey("Content-Type")) {
                    String contentType = this.qY.getContentType();
                    if (!TextUtils.isEmpty(contentType)) {
                        this.qK.rd.put("Content-Type", contentType);
                    }
                }
                this.qK.re = this.qY;
            }
            return this.qK;
        } catch (MalformedURLException e) {
            throw new HttpException(3, e);
        }
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFile(String str, String str2) {
        if (an(null)) {
            ((m) this.qY).h(str, str2);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFile(String str, byte[] bArr) {
        if (an(null)) {
            ((m) this.qY).a(str, bArr);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFormData(Map<String, Object> map) {
        if (map != null && eL()) {
            b bVar = (b) this.qY;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    bVar.f(entry.getKey(), entry.getValue().toString());
                }
            }
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFormField(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null && eL()) {
            ((b) this.qY).f(str, obj.toString());
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addHeader(String str) {
        String[] aq = j.aq(str);
        if (aq == null) {
            this.qK.ap(String.format("Header 格式必须是： \\\"Name: Value\\\". Found: \\\"%s\\\"", str));
        } else {
            addHeader(aq[0], aq[1]);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addHeaders(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                addHeader(str);
            }
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addPart(String str, Object obj) {
        if (obj != null && an(null)) {
            ((m) this.qY).g(str, obj.toString());
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addPartMap(Map<String, Object> map) {
        if (map != null && an(null)) {
            m mVar = (m) this.qY;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    mVar.g(entry.getKey(), entry.getValue().toString());
                }
            }
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addQueryField(String str, Object obj) {
        if (obj != null) {
            this.qX.i(str, obj.toString());
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addQueryMap(Map<String, Object> map) {
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    this.qX.i(entry.getKey(), entry.getValue().toString());
                }
            }
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public void cancel() {
        this.qN = null;
        if (this.qZ != null) {
            this.qZ.cancel();
        }
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public void enqueue(com.baidu.ar.ihttp.a aVar) {
        if (this.qZ != null) {
            this.qZ.cancel();
        }
        e executor = this.qW.getExecutor();
        try {
            g eM = eM();
            if (eM != null) {
                this.qZ = executor.a(eM, aVar, this.qN);
            }
        } catch (HttpException e) {
            this.qZ = executor.a(e, aVar);
        }
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpResponse execute() {
        if (this.qZ != null) {
            this.qZ.cancel();
        }
        this.qZ = this.qW.getExecutor().a(eM(), this.qN);
        return this.qZ.eH();
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setAsMultipart() {
        return (this.qY == null || !(this.qY instanceof m)) ? setAsMultipart(d.MULTIPART_BOUNDARY) : this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setAsMultipart(String str) {
        if (an(str)) {
            ((m) this.qY).at(str);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setBody(String str) {
        if (!TextUtils.isEmpty(str)) {
            a(str.getBytes(this.qK.rb), "application/x-www-form-urlencoded");
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setBody(JSONObject jSONObject) {
        if (jSONObject != null) {
            a(jSONObject.toString().getBytes(this.qK.rb), HttpHelper.CONTENT_JSON);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setBody(byte[] bArr) {
        return a(bArr, null);
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setCharset(Charset charset) {
        this.qK.rb = charset;
        this.qX.a(charset);
        if (this.qY != null) {
            this.qY.a(charset);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setConnectionTimeout(int i) {
        this.qK.rc.rg = i;
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setMethod(String str) {
        if (str != null) {
            this.qK.method = str.toUpperCase();
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public void setProgressCallback(IProgressCallback iProgressCallback) {
        this.qN = iProgressCallback;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setReadTimeout(int i) {
        this.qK.rc.rh = i;
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setUrl(String str) {
        this.qX.au(str);
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setUseCache(boolean z) {
        this.qK.rc.ri = z;
        return this;
    }
}
