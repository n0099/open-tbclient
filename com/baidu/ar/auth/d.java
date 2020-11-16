package com.baidu.ar.auth;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.auth.m;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.g.s;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
class d implements m {
    private boolean jc;
    private m.a jf;

    public d(g gVar) {
        this.jc = gVar.jt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar, HttpException httpException) {
        if (kVar != null) {
            if (this.jc && httpException.getCode() == 1) {
                kVar.onSuccess();
            } else {
                kVar.onError(httpException.getMessage(), 0);
            }
        }
    }

    private JSONObject j(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.ar.g.o.g(jSONObject);
            com.baidu.ar.g.o.b(context, jSONObject);
            jSONObject.put(HttpConstants.SDK_TYPE, com.baidu.ar.g.c.gx());
            jSONObject.put(HttpConstants.FUNCTION_TYPE, com.baidu.ar.g.c.gy());
            jSONObject.put(HttpConstants.SDK_VERSION_CODE, com.baidu.ar.g.c.getVersionCode());
            jSONObject.put(HttpConstants.SDK_VERSION_NAME, com.baidu.ar.g.c.getVersionName());
            jSONObject.put(HttpConstants.HTTP_OS_TYPE, "android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_id", Build.MODEL.toLowerCase());
            jSONObject.put("ar_key", ARConfig.getARKey());
            jSONObject.put("ar_type", ARConfig.getARType());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private String k(Context context) {
        try {
            String k = e.k(context);
            if (TextUtils.isEmpty(k) || !k.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                return k;
            }
            return k.substring(0, k.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + DuMixARConfig.getAipAppId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.ar.auth.m
    public void a(m.a aVar) {
        this.jf = aVar;
    }

    @Override // com.baidu.ar.auth.m
    public void doAuth(Context context, final k kVar) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest == null) {
            return;
        }
        newRequest.setMethod("POST").setUrl(s.gO()).addQueryField("access_token", k(context)).setBody(j(context));
        newRequest.enqueue(new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.auth.d.1
            @Override // com.baidu.ar.ihttp.a
            public void a(HttpException httpException) {
                d.this.a(kVar, httpException);
            }

            @Override // com.baidu.ar.ihttp.a
            public void a(IHttpResponse iHttpResponse) {
                JSONObject jSONObject;
                String message;
                if (iHttpResponse.isSuccess()) {
                    try {
                        jSONObject = new JSONObject(iHttpResponse.getContent());
                    } catch (Exception e) {
                        d.this.a(kVar, new HttpException(4, e.getMessage()));
                        jSONObject = null;
                    }
                } else {
                    d.this.a(kVar, new HttpException(1, iHttpResponse.getMessage()));
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    return;
                }
                if (jSONObject != null && jSONObject.has("error_msg")) {
                    try {
                        message = jSONObject.getString("error_msg");
                    } catch (JSONException e2) {
                        message = e2.getMessage();
                    }
                    if (kVar != null) {
                        kVar.onError(message, 0);
                        return;
                    }
                    return;
                }
                if (d.this.jf != null) {
                    HashSet hashSet = new HashSet();
                    hashSet.addAll(FeatureCodes.getAll());
                    d.this.jf.a(hashSet);
                }
                if (kVar != null) {
                    kVar.onSuccess();
                }
            }
        });
    }
}
