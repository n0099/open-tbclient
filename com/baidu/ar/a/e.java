package com.baidu.ar.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.f.m;
import com.baidu.ar.f.q;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private IHttpRequest bK;
    private ICallbackWith<String> bL;

    private JSONObject a(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            m.f(jSONObject);
            m.b(context, jSONObject);
            m.a(context, jSONObject);
            jSONObject.put("device_platform", "");
            jSONObject.put("os_version", Build.VERSION.SDK_INT);
            jSONObject.put(HttpConstants.DEVICE_TYPE, Build.BRAND);
            jSONObject.put("device_id", m.u(context));
            jSONObject.put("app_version", com.baidu.ar.f.c.getVersionCode());
            jSONObject.put("manufacture", Build.MANUFACTURER);
            jSONObject.put(HttpConstants.HTTP_HARDWARE, Build.HARDWARE);
            jSONObject.put(HttpConstants.HTTP_BOARD, Build.BOARD);
            jSONObject.put("classification_id", str);
            com.baidu.ar.f.b.c(TAG, "params: " + jSONObject.toString());
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    private boolean c(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || !jSONObject.has("common") || (optJSONObject = jSONObject.optJSONObject("common")) == null || !optJSONObject.has("cpu_score")) {
            return false;
        }
        Object opt = optJSONObject.opt("cpu_score");
        if (opt instanceof String) {
            return Integer.parseInt((String) opt) > 0;
        } else if (opt instanceof Number) {
            return Integer.parseInt(opt.toString()) > 0;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a q(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.bL != null) {
                r("response is empty");
                return null;
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                int optInt = jSONObject.optInt("err_num", -1);
                if (optInt != 0 || !jSONObject.has("data")) {
                    if (this.bL != null) {
                        r("err_num: " + optInt + " " + (jSONObject.has("err_msg") ? jSONObject.getString("err_msg") : ""));
                        return null;
                    }
                    return null;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null || !optJSONObject.has("classification")) {
                    return null;
                }
                a aVar = new a();
                aVar.bC = optJSONObject.getJSONObject("classification");
                aVar.bB = optJSONObject.optString("classification_id", "default");
                if (!c(aVar.bC) && this.bL != null) {
                    com.baidu.ar.f.b.b(TAG, str);
                    r("config format is error. see Logcat filter: " + TAG);
                }
                return aVar;
            }
            return null;
        } catch (JSONException e) {
            if (this.bL != null) {
                r(e.getMessage());
            }
            e.printStackTrace();
            return null;
        }
    }

    private void r(String str) {
        this.bL.run("fetch ability scheme config fail. " + str);
    }

    public void a(Context context, String str, final ICallbackWith<a> iCallbackWith) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest == null) {
            return;
        }
        newRequest.setMethod("POST").setUrl(q.fp()).setBody(a(context, str));
        newRequest.enqueue(new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.a.e.1
            @Override // com.baidu.ar.ihttp.a
            public void a(HttpException httpException) {
                com.baidu.ar.f.b.c(e.TAG, "" + httpException.getMessage());
            }

            @Override // com.baidu.ar.ihttp.a
            public void a(IHttpResponse iHttpResponse) {
                if (!iHttpResponse.isSuccess() || iCallbackWith == null) {
                    return;
                }
                try {
                    String content = iHttpResponse.getContent();
                    com.baidu.ar.f.b.c(e.TAG, "response: " + content);
                    a q = e.this.q(content);
                    if (q != null) {
                        iCallbackWith.run(q);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        this.bK = newRequest;
    }

    public void c(ICallbackWith<String> iCallbackWith) {
        this.bL = iCallbackWith;
    }

    public void cancel() {
        this.bL = null;
        if (this.bK != null) {
            this.bK.cancel();
            this.bK = null;
        }
    }
}
