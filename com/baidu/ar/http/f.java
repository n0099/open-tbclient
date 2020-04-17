package com.baidu.ar.http;

import android.text.TextUtils;
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
    private HttpRequestFactory pC;
    private l pF;
    private IProgressCallback pt;
    private o pD = new o();
    private k pE = null;
    private g pq = new g();

    public f(HttpRequestFactory httpRequestFactory) {
        this.pC = httpRequestFactory;
        this.pq.method = "GET";
        this.pq.pJ = new HashMap();
        this.pq.pI = new h();
        this.pF = null;
    }

    private IHttpRequest a(byte[] bArr, String str) {
        if (ag(str)) {
            ((n) this.pE).setData(bArr);
        }
        return this;
    }

    private String a(k kVar) {
        return kVar instanceof n ? "该请求已通过setBody设置请求体数据，不能再使用其他方式添加数据" : kVar instanceof b ? "该请求是FormData方式传输数据，请使用addFormData或addFormField添加请求体数据" : kVar instanceof m ? "该请求是Multipart方式传输数据，请使用addPart、addPartMap或addFile添加请求体数据" : "";
    }

    private void addHeader(String str, String str2) {
        this.pq.pJ.put(str, str2);
    }

    private boolean af(String str) {
        if (this.pE != null && !(this.pE instanceof m)) {
            this.pq.ah(a(this.pE));
            return false;
        }
        if (this.pE == null) {
            this.pE = new m();
            this.pE.a(this.pq.pH);
            m mVar = (m) this.pE;
            if (!TextUtils.isEmpty(str)) {
                mVar.al(str);
            }
        } else if (!TextUtils.isEmpty(str)) {
            m mVar2 = (m) this.pE;
            if (!mVar2.isEmpty() && !str.equals(mVar2.getBoundary())) {
                this.pq.ah("已经添加请求体内容，不能再更改boundary");
                return false;
            }
        }
        return true;
    }

    private boolean ag(String str) {
        if (this.pE != null && !(this.pE instanceof n)) {
            this.pq.ah(a(this.pE));
            return false;
        }
        if (this.pE == null) {
            this.pE = new n();
            this.pE.a(this.pq.pH);
        }
        if (!TextUtils.isEmpty(str) && !this.pq.pJ.containsKey("Content-Type")) {
            addHeader("Content-Type", str);
        }
        return true;
    }

    private boolean dm() {
        if (this.pE != null && !(this.pE instanceof b)) {
            this.pq.ah(a(this.pE));
            return false;
        }
        if (this.pE == null) {
            this.pE = new b();
            this.pE.a(this.pq.pH);
        }
        return true;
    }

    private g dn() {
        if (this.pq.hasError()) {
            throw new HttpException(3, this.pq.m19do());
        }
        if (this.pq.pH != null) {
            addHeader("charset", this.pq.pH.name());
        }
        try {
            this.pq.url = this.pD.dp();
            if (this.pE != null) {
                if (!this.pq.pJ.containsKey("Content-Type")) {
                    String contentType = this.pE.getContentType();
                    if (!TextUtils.isEmpty(contentType)) {
                        this.pq.pJ.put("Content-Type", contentType);
                    }
                }
                this.pq.pK = this.pE;
            }
            return this.pq;
        } catch (MalformedURLException e) {
            throw new HttpException(3, e);
        }
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFile(String str, String str2) {
        if (af(null)) {
            ((m) this.pE).f(str, str2);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFile(String str, byte[] bArr) {
        if (af(null)) {
            ((m) this.pE).a(str, bArr);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFormData(Map<String, Object> map) {
        if (map != null && dm()) {
            b bVar = (b) this.pE;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    bVar.d(entry.getKey(), entry.getValue().toString());
                }
            }
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFormField(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null && dm()) {
            ((b) this.pE).d(str, obj.toString());
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addHeader(String str) {
        String[] ai = j.ai(str);
        if (ai == null) {
            this.pq.ah(String.format("Header 格式必须是： \\\"Name: Value\\\". Found: \\\"%s\\\"", str));
        } else {
            addHeader(ai[0], ai[1]);
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
        if (obj != null && af(null)) {
            ((m) this.pE).e(str, obj.toString());
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addPartMap(Map<String, Object> map) {
        if (map != null && af(null)) {
            m mVar = (m) this.pE;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    mVar.e(entry.getKey(), entry.getValue().toString());
                }
            }
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addQueryField(String str, Object obj) {
        if (obj != null) {
            this.pD.g(str, obj.toString());
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addQueryMap(Map<String, Object> map) {
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    this.pD.g(entry.getKey(), entry.getValue().toString());
                }
            }
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public void cancel() {
        this.pt = null;
        if (this.pF != null) {
            this.pF.cancel();
        }
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public void enqueue(com.baidu.ar.ihttp.a aVar) {
        if (this.pF != null) {
            this.pF.cancel();
        }
        e executor = this.pC.getExecutor();
        try {
            g dn = dn();
            if (dn != null) {
                this.pF = executor.a(dn, aVar, this.pt);
            }
        } catch (HttpException e) {
            this.pF = executor.a(e, aVar);
        }
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpResponse execute() {
        if (this.pF != null) {
            this.pF.cancel();
        }
        this.pF = this.pC.getExecutor().a(dn(), this.pt);
        return this.pF.di();
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setAsMultipart() {
        return (this.pE == null || !(this.pE instanceof m)) ? setAsMultipart(d.MULTIPART_BOUNDARY) : this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setAsMultipart(String str) {
        if (af(str)) {
            ((m) this.pE).al(str);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setBody(String str) {
        if (!TextUtils.isEmpty(str)) {
            a(str.getBytes(this.pq.pH), "application/x-www-form-urlencoded");
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setBody(JSONObject jSONObject) {
        if (jSONObject != null) {
            a(jSONObject.toString().getBytes(this.pq.pH), "application/json");
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setBody(byte[] bArr) {
        return a(bArr, null);
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setCharset(Charset charset) {
        this.pq.pH = charset;
        this.pD.a(charset);
        if (this.pE != null) {
            this.pE.a(charset);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setConnectionTimeout(int i) {
        this.pq.pI.pM = i;
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setMethod(String str) {
        if (str != null) {
            this.pq.method = str.toUpperCase();
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public void setProgressCallback(IProgressCallback iProgressCallback) {
        this.pt = iProgressCallback;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setReadTimeout(int i) {
        this.pq.pI.pN = i;
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setUrl(String str) {
        this.pD.am(str);
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setUseCache(boolean z) {
        this.pq.pI.pO = z;
        return this;
    }
}
