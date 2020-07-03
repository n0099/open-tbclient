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
    private IProgressCallback pS;
    private HttpRequestFactory qb;
    private l qe;
    private o qc = new o();
    private k qd = null;
    private g pP = new g();

    public f(HttpRequestFactory httpRequestFactory) {
        this.qb = httpRequestFactory;
        this.pP.method = "GET";
        this.pP.qi = new HashMap();
        this.pP.qh = new h();
        this.qe = null;
    }

    private IHttpRequest a(byte[] bArr, String str) {
        if (ah(str)) {
            ((n) this.qd).setData(bArr);
        }
        return this;
    }

    private String a(k kVar) {
        return kVar instanceof n ? "该请求已通过setBody设置请求体数据，不能再使用其他方式添加数据" : kVar instanceof b ? "该请求是FormData方式传输数据，请使用addFormData或addFormField添加请求体数据" : kVar instanceof m ? "该请求是Multipart方式传输数据，请使用addPart、addPartMap或addFile添加请求体数据" : "";
    }

    private void addHeader(String str, String str2) {
        this.pP.qi.put(str, str2);
    }

    private boolean ag(String str) {
        if (this.qd != null && !(this.qd instanceof m)) {
            this.pP.ai(a(this.qd));
            return false;
        }
        if (this.qd == null) {
            this.qd = new m();
            this.qd.a(this.pP.qg);
            m mVar = (m) this.qd;
            if (!TextUtils.isEmpty(str)) {
                mVar.am(str);
            }
        } else if (!TextUtils.isEmpty(str)) {
            m mVar2 = (m) this.qd;
            if (!mVar2.isEmpty() && !str.equals(mVar2.getBoundary())) {
                this.pP.ai("已经添加请求体内容，不能再更改boundary");
                return false;
            }
        }
        return true;
    }

    private boolean ah(String str) {
        if (this.qd != null && !(this.qd instanceof n)) {
            this.pP.ai(a(this.qd));
            return false;
        }
        if (this.qd == null) {
            this.qd = new n();
            this.qd.a(this.pP.qg);
        }
        if (!TextUtils.isEmpty(str) && !this.pP.qi.containsKey("Content-Type")) {
            addHeader("Content-Type", str);
        }
        return true;
    }

    private boolean dC() {
        if (this.qd != null && !(this.qd instanceof b)) {
            this.pP.ai(a(this.qd));
            return false;
        }
        if (this.qd == null) {
            this.qd = new b();
            this.qd.a(this.pP.qg);
        }
        return true;
    }

    private g dD() {
        if (this.pP.hasError()) {
            throw new HttpException(3, this.pP.dE());
        }
        if (this.pP.qg != null) {
            addHeader("charset", this.pP.qg.name());
        }
        try {
            this.pP.url = this.qc.dF();
            if (this.qd != null) {
                if (!this.pP.qi.containsKey("Content-Type")) {
                    String contentType = this.qd.getContentType();
                    if (!TextUtils.isEmpty(contentType)) {
                        this.pP.qi.put("Content-Type", contentType);
                    }
                }
                this.pP.qj = this.qd;
            }
            return this.pP;
        } catch (MalformedURLException e) {
            throw new HttpException(3, e);
        }
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFile(String str, String str2) {
        if (ag(null)) {
            ((m) this.qd).f(str, str2);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFile(String str, byte[] bArr) {
        if (ag(null)) {
            ((m) this.qd).a(str, bArr);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFormData(Map<String, Object> map) {
        if (map != null && dC()) {
            b bVar = (b) this.qd;
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
        if (!TextUtils.isEmpty(str) && obj != null && dC()) {
            ((b) this.qd).d(str, obj.toString());
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addHeader(String str) {
        String[] aj = j.aj(str);
        if (aj == null) {
            this.pP.ai(String.format("Header 格式必须是： \\\"Name: Value\\\". Found: \\\"%s\\\"", str));
        } else {
            addHeader(aj[0], aj[1]);
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
        if (obj != null && ag(null)) {
            ((m) this.qd).e(str, obj.toString());
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addPartMap(Map<String, Object> map) {
        if (map != null && ag(null)) {
            m mVar = (m) this.qd;
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
            this.qc.g(str, obj.toString());
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addQueryMap(Map<String, Object> map) {
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    this.qc.g(entry.getKey(), entry.getValue().toString());
                }
            }
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public void cancel() {
        this.pS = null;
        if (this.qe != null) {
            this.qe.cancel();
        }
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public void enqueue(com.baidu.ar.ihttp.a aVar) {
        if (this.qe != null) {
            this.qe.cancel();
        }
        e executor = this.qb.getExecutor();
        try {
            g dD = dD();
            if (dD != null) {
                this.qe = executor.a(dD, aVar, this.pS);
            }
        } catch (HttpException e) {
            this.qe = executor.a(e, aVar);
        }
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpResponse execute() {
        if (this.qe != null) {
            this.qe.cancel();
        }
        this.qe = this.qb.getExecutor().a(dD(), this.pS);
        return this.qe.dy();
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setAsMultipart() {
        return (this.qd == null || !(this.qd instanceof m)) ? setAsMultipart(d.MULTIPART_BOUNDARY) : this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setAsMultipart(String str) {
        if (ag(str)) {
            ((m) this.qd).am(str);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setBody(String str) {
        if (!TextUtils.isEmpty(str)) {
            a(str.getBytes(this.pP.qg), "application/x-www-form-urlencoded");
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setBody(JSONObject jSONObject) {
        if (jSONObject != null) {
            a(jSONObject.toString().getBytes(this.pP.qg), HttpHelper.CONTENT_JSON);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setBody(byte[] bArr) {
        return a(bArr, null);
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setCharset(Charset charset) {
        this.pP.qg = charset;
        this.qc.a(charset);
        if (this.qd != null) {
            this.qd.a(charset);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setConnectionTimeout(int i) {
        this.pP.qh.ql = i;
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setMethod(String str) {
        if (str != null) {
            this.pP.method = str.toUpperCase();
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public void setProgressCallback(IProgressCallback iProgressCallback) {
        this.pS = iProgressCallback;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setReadTimeout(int i) {
        this.pP.qh.qm = i;
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setUrl(String str) {
        this.qc.an(str);
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setUseCache(boolean z) {
        this.pP.qh.qn = z;
        return this;
    }
}
