package com.baidu.ar.auth;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.auth.l;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.f.q;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class c implements l {
    private boolean jq;
    private l.a jt;

    public c(f fVar) {
        this.jq = fVar.jD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, HttpException httpException) {
        if (jVar != null) {
            if (this.jq && httpException.getCode() == 1) {
                jVar.onSuccess();
            } else {
                jVar.onError(httpException.getMessage(), 0);
            }
        }
    }

    private JSONObject j(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.ar.f.m.g(jSONObject);
            com.baidu.ar.f.m.b(context, jSONObject);
            jSONObject.put(HttpConstants.SDK_TYPE, com.baidu.ar.f.c.fj());
            jSONObject.put(HttpConstants.FUNCTION_TYPE, com.baidu.ar.f.c.fk());
            jSONObject.put(HttpConstants.SDK_VERSION_CODE, com.baidu.ar.f.c.getVersionCode());
            jSONObject.put(HttpConstants.SDK_VERSION_NAME, com.baidu.ar.f.c.getVersionName());
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
            String k = d.k(context);
            if (TextUtils.isEmpty(k) || !k.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                return k;
            }
            return k.substring(0, k.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + DuMixARConfig.getAipAppId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.ar.auth.l
    public void a(l.a aVar) {
        this.jt = aVar;
    }

    @Override // com.baidu.ar.auth.l
    public void doAuth(Context context, final j jVar) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest == null) {
            return;
        }
        newRequest.setMethod("POST").setUrl(q.fz()).addQueryField("access_token", k(context)).setBody(j(context));
        newRequest.enqueue(new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.auth.c.1
            @Override // com.baidu.ar.ihttp.a
            public void a(HttpException httpException) {
                c.this.a(jVar, httpException);
            }

            @Override // com.baidu.ar.ihttp.a
            public void a(IHttpResponse iHttpResponse) {
                JSONObject jSONObject;
                String message;
                if (iHttpResponse.isSuccess()) {
                    try {
                        jSONObject = new JSONObject(iHttpResponse.getContent());
                    } catch (Exception e) {
                        c.this.a(jVar, new HttpException(4, e.getMessage()));
                        jSONObject = null;
                    }
                } else {
                    c.this.a(jVar, new HttpException(1, iHttpResponse.getMessage()));
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
                    if (jVar != null) {
                        jVar.onError(message, 0);
                        return;
                    }
                    return;
                }
                if (c.this.jt != null) {
                    HashSet hashSet = new HashSet();
                    hashSet.addAll(FeatureCodes.getAll());
                    c.this.jt.a(hashSet);
                }
                if (jVar != null) {
                    jVar.onSuccess();
                }
            }
        });
    }
}
