package com.baidu.ar.auth;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ar.auth.k;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.h.o;
import com.baidu.ar.h.s;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class c implements k {
    private boolean jr;
    private k.a ju;

    public c(f fVar) {
        this.jr = fVar.jI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IAuthCallback iAuthCallback, HttpException httpException) {
        if (iAuthCallback != null) {
            if (this.jr && httpException.getCode() == 1) {
                iAuthCallback.onSuccess();
            } else {
                iAuthCallback.onError(httpException.getMessage(), 0);
            }
        }
    }

    private JSONObject k(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            o.g(jSONObject);
            o.b(context, jSONObject);
            jSONObject.put(HttpConstants.SDK_TYPE, com.baidu.ar.h.c.gx());
            jSONObject.put(HttpConstants.FUNCTION_TYPE, com.baidu.ar.h.c.gy());
            jSONObject.put(HttpConstants.SDK_VERSION_CODE, com.baidu.ar.h.c.getVersionCode());
            jSONObject.put(HttpConstants.SDK_VERSION_NAME, com.baidu.ar.h.c.getVersionName());
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

    private String l(Context context) {
        try {
            String l = d.l(context);
            if (TextUtils.isEmpty(l) || !l.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                return l;
            }
            return l.substring(0, l.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + DuMixARConfig.getAipAppId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.ar.auth.k
    public void a(k.a aVar) {
        this.ju = aVar;
    }

    @Override // com.baidu.ar.auth.k
    public void doAuth(Context context, final IAuthCallback iAuthCallback) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest == null) {
            return;
        }
        newRequest.setMethod("POST").setUrl(s.gO()).addQueryField("access_token", l(context)).setBody(k(context));
        newRequest.enqueue(new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.auth.c.1
            @Override // com.baidu.ar.ihttp.a
            public void a(HttpException httpException) {
                c.this.a(iAuthCallback, httpException);
            }

            @Override // com.baidu.ar.ihttp.a
            public void a(IHttpResponse iHttpResponse) {
                JSONObject jSONObject;
                String message;
                if (iHttpResponse.isSuccess()) {
                    try {
                        jSONObject = new JSONObject(iHttpResponse.getContent());
                    } catch (Exception e) {
                        c.this.a(iAuthCallback, new HttpException(4, e.getMessage()));
                        jSONObject = null;
                    }
                } else {
                    c.this.a(iAuthCallback, new HttpException(1, iHttpResponse.getMessage()));
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    return;
                }
                if (jSONObject != null && jSONObject.has(AlaRecorderLog.KEY_ERROR_MSG)) {
                    try {
                        message = jSONObject.getString(AlaRecorderLog.KEY_ERROR_MSG);
                    } catch (JSONException e2) {
                        message = e2.getMessage();
                    }
                    if (iAuthCallback != null) {
                        iAuthCallback.onError(message, 0);
                        return;
                    }
                    return;
                }
                if (c.this.ju != null) {
                    HashSet hashSet = new HashSet();
                    hashSet.addAll(FeatureCodes.getAll());
                    c.this.ju.a(hashSet);
                }
                if (iAuthCallback != null) {
                    iAuthCallback.onSuccess();
                }
            }
        });
    }
}
