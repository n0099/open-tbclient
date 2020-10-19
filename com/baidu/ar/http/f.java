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
/* loaded from: classes14.dex */
class f implements IHttpRequest {
    private HttpRequestFactory qG;
    private l qJ;
    private IProgressCallback qx;
    private o qH = new o();
    private k qI = null;
    private g qu = new g();

    public f(HttpRequestFactory httpRequestFactory) {
        this.qG = httpRequestFactory;
        this.qu.method = "GET";
        this.qu.qN = new HashMap();
        this.qu.qM = new h();
        this.qJ = null;
    }

    private IHttpRequest a(byte[] bArr, String str) {
        if (al(str)) {
            ((n) this.qI).setData(bArr);
        }
        return this;
    }

    private String a(k kVar) {
        return kVar instanceof n ? "该请求已通过setBody设置请求体数据，不能再使用其他方式添加数据" : kVar instanceof b ? "该请求是FormData方式传输数据，请使用addFormData或addFormField添加请求体数据" : kVar instanceof m ? "该请求是Multipart方式传输数据，请使用addPart、addPartMap或addFile添加请求体数据" : "";
    }

    private void addHeader(String str, String str2) {
        this.qu.qN.put(str, str2);
    }

    private boolean ak(String str) {
        if (this.qI != null && !(this.qI instanceof m)) {
            this.qu.am(a(this.qI));
            return false;
        }
        if (this.qI == null) {
            this.qI = new m();
            this.qI.a(this.qu.qL);
            m mVar = (m) this.qI;
            if (!TextUtils.isEmpty(str)) {
                mVar.aq(str);
            }
        } else if (!TextUtils.isEmpty(str)) {
            m mVar2 = (m) this.qI;
            if (!mVar2.isEmpty() && !str.equals(mVar2.getBoundary())) {
                this.qu.am("已经添加请求体内容，不能再更改boundary");
                return false;
            }
        }
        return true;
    }

    private boolean al(String str) {
        if (this.qI != null && !(this.qI instanceof n)) {
            this.qu.am(a(this.qI));
            return false;
        }
        if (this.qI == null) {
            this.qI = new n();
            this.qI.a(this.qu.qL);
        }
        if (!TextUtils.isEmpty(str) && !this.qu.qN.containsKey("Content-Type")) {
            addHeader("Content-Type", str);
        }
        return true;
    }

    private boolean eM() {
        if (this.qI != null && !(this.qI instanceof b)) {
            this.qu.am(a(this.qI));
            return false;
        }
        if (this.qI == null) {
            this.qI = new b();
            this.qI.a(this.qu.qL);
        }
        return true;
    }

    private g eN() {
        if (this.qu.hasError()) {
            throw new HttpException(3, this.qu.eO());
        }
        if (this.qu.qL != null) {
            addHeader("charset", this.qu.qL.name());
        }
        try {
            this.qu.url = this.qH.eP();
            if (this.qI != null) {
                if (!this.qu.qN.containsKey("Content-Type")) {
                    String contentType = this.qI.getContentType();
                    if (!TextUtils.isEmpty(contentType)) {
                        this.qu.qN.put("Content-Type", contentType);
                    }
                }
                this.qu.qO = this.qI;
            }
            return this.qu;
        } catch (MalformedURLException e) {
            throw new HttpException(3, e);
        }
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFile(String str, String str2) {
        if (ak(null)) {
            ((m) this.qI).h(str, str2);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFile(String str, byte[] bArr) {
        if (ak(null)) {
            ((m) this.qI).a(str, bArr);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFormData(Map<String, Object> map) {
        if (map != null && eM()) {
            b bVar = (b) this.qI;
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
        if (!TextUtils.isEmpty(str) && obj != null && eM()) {
            ((b) this.qI).f(str, obj.toString());
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addHeader(String str) {
        String[] an = j.an(str);
        if (an == null) {
            this.qu.am(String.format("Header 格式必须是： \\\"Name: Value\\\". Found: \\\"%s\\\"", str));
        } else {
            addHeader(an[0], an[1]);
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
        if (obj != null && ak(null)) {
            ((m) this.qI).g(str, obj.toString());
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addPartMap(Map<String, Object> map) {
        if (map != null && ak(null)) {
            m mVar = (m) this.qI;
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
            this.qH.i(str, obj.toString());
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addQueryMap(Map<String, Object> map) {
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    this.qH.i(entry.getKey(), entry.getValue().toString());
                }
            }
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public void cancel() {
        this.qx = null;
        if (this.qJ != null) {
            this.qJ.cancel();
        }
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public void enqueue(com.baidu.ar.ihttp.a aVar) {
        if (this.qJ != null) {
            this.qJ.cancel();
        }
        e executor = this.qG.getExecutor();
        try {
            g eN = eN();
            if (eN != null) {
                this.qJ = executor.a(eN, aVar, this.qx);
            }
        } catch (HttpException e) {
            this.qJ = executor.a(e, aVar);
        }
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpResponse execute() {
        if (this.qJ != null) {
            this.qJ.cancel();
        }
        this.qJ = this.qG.getExecutor().a(eN(), this.qx);
        return this.qJ.eI();
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setAsMultipart() {
        return (this.qI == null || !(this.qI instanceof m)) ? setAsMultipart(d.MULTIPART_BOUNDARY) : this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setAsMultipart(String str) {
        if (ak(str)) {
            ((m) this.qI).aq(str);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setBody(String str) {
        if (!TextUtils.isEmpty(str)) {
            a(str.getBytes(this.qu.qL), "application/x-www-form-urlencoded");
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setBody(JSONObject jSONObject) {
        if (jSONObject != null) {
            a(jSONObject.toString().getBytes(this.qu.qL), HttpHelper.CONTENT_JSON);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setBody(byte[] bArr) {
        return a(bArr, null);
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setCharset(Charset charset) {
        this.qu.qL = charset;
        this.qH.a(charset);
        if (this.qI != null) {
            this.qI.a(charset);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setConnectionTimeout(int i) {
        this.qu.qM.qQ = i;
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setMethod(String str) {
        if (str != null) {
            this.qu.method = str.toUpperCase();
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public void setProgressCallback(IProgressCallback iProgressCallback) {
        this.qx = iProgressCallback;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setReadTimeout(int i) {
        this.qu.qM.qR = i;
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setUrl(String str) {
        this.qH.ar(str);
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setUseCache(boolean z) {
        this.qu.qM.qS = z;
        return this;
    }
}
