package com.baidu.ar.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.h.o;
import com.baidu.ar.h.s;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.searchbox.pms.constants.PmsConstant;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public static final String TAG = "e";
    public IHttpRequest bR;
    public ICallbackWith<String> bS;

    private JSONObject a(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            o.g(jSONObject);
            o.b(context, jSONObject);
            o.a(context, jSONObject);
            jSONObject.put("device_platform", "");
            jSONObject.put(HttpConstants.OS_VERSION, Build.VERSION.SDK_INT);
            jSONObject.put(HttpConstants.DEVICE_TYPE, Build.BRAND);
            jSONObject.put("device_id", o.y(context));
            jSONObject.put("app_version", com.baidu.ar.h.c.getVersionCode());
            jSONObject.put("manufacture", Build.MANUFACTURER);
            jSONObject.put(HttpConstants.HTTP_HARDWARE, Build.HARDWARE);
            jSONObject.put(HttpConstants.HTTP_BOARD, Build.BOARD);
            jSONObject.put("classification_id", str);
            String str2 = TAG;
            com.baidu.ar.h.b.c(str2, "params: " + jSONObject.toString());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private boolean d(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || !jSONObject.has("common") || (optJSONObject = jSONObject.optJSONObject("common")) == null || !optJSONObject.has("cpu_score")) {
            return false;
        }
        Object opt = optJSONObject.opt("cpu_score");
        return opt instanceof String ? Integer.parseInt((String) opt) > 0 : (opt instanceof Number) && Integer.parseInt(opt.toString()) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a t(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.bS != null) {
                u("response is empty");
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("err_num", -1);
            if (optInt == 0 && jSONObject.has("data")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.has("classification")) {
                    a aVar = new a();
                    aVar.bI = optJSONObject.getJSONObject("classification");
                    aVar.bH = optJSONObject.optString("classification_id", "default");
                    if (!d(aVar.bI) && this.bS != null) {
                        com.baidu.ar.h.b.b(TAG, str);
                        u("config format is error. see Logcat filter: " + TAG);
                    }
                    return aVar;
                }
            } else if (this.bS != null) {
                String string = jSONObject.has(PmsConstant.Statistic.STATISTIC_ERRMSG) ? jSONObject.getString(PmsConstant.Statistic.STATISTIC_ERRMSG) : "";
                u("err_num: " + optInt + " " + string);
            }
        } catch (JSONException e) {
            if (this.bS != null) {
                u(e.getMessage());
            }
            e.printStackTrace();
        }
        return null;
    }

    private void u(String str) {
        ICallbackWith<String> iCallbackWith = this.bS;
        iCallbackWith.run("fetch ability scheme config fail. " + str);
    }

    public void a(Context context, String str, final ICallbackWith<a> iCallbackWith) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest == null) {
            return;
        }
        newRequest.setMethod("POST").setUrl(s.gU()).setBody(a(context, str));
        newRequest.enqueue(new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.a.e.1
            @Override // com.baidu.ar.ihttp.a
            public void a(HttpException httpException) {
                String str2 = e.TAG;
                com.baidu.ar.h.b.c(str2, "" + httpException.getMessage());
            }

            @Override // com.baidu.ar.ihttp.a
            public void a(IHttpResponse iHttpResponse) {
                if (!iHttpResponse.isSuccess() || iCallbackWith == null) {
                    return;
                }
                try {
                    String content = iHttpResponse.getContent();
                    String str2 = e.TAG;
                    com.baidu.ar.h.b.c(str2, "response: " + content);
                    a t = e.this.t(content);
                    if (t != null) {
                        iCallbackWith.run(t);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        this.bR = newRequest;
    }

    public void c(ICallbackWith<String> iCallbackWith) {
        this.bS = iCallbackWith;
    }

    public void cancel() {
        this.bS = null;
        IHttpRequest iHttpRequest = this.bR;
        if (iHttpRequest != null) {
            iHttpRequest.cancel();
            this.bR = null;
        }
    }
}
