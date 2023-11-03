package com.baidu.ar.steploading;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.bean.ARCaseBundleInfo;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
import com.baidu.ar.h.o;
import com.baidu.ar.h.s;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends com.baidu.ar.e.a<String, String> {
    public IHttpRequest bR;
    public WeakReference<Context> wn;
    public ARCaseBundleInfo xx;
    public a xz;

    public e(Context context, ARCaseBundleInfo aRCaseBundleInfo, a aVar) {
        this.wn = new WeakReference<>(context);
        this.xx = aRCaseBundleInfo;
        this.xz = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aO(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getInt("errorNum") == 0) {
            String string = jSONObject.getString("data");
            if (TextUtils.isEmpty(string)) {
                throw new Exception("query res failed");
            }
            return string;
        }
        throw new Exception(jSONObject.optString("errorMsg", "query res failed"));
    }

    private JSONObject e(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            o.g(jSONObject);
            o.b(context, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.e.a
    public void a(String str, final ICallbackWith<String> iCallbackWith, final IError iError) {
        ARCaseBundleInfo aRCaseBundleInfo;
        Context context = this.wn.get();
        if (context == null || (aRCaseBundleInfo = this.xx) == null) {
            return;
        }
        String str2 = aRCaseBundleInfo.arKey;
        f aN = this.xz.aN(str);
        if (aN == null) {
            iError.onError(1, "资源不存在", null);
        } else if (TextUtils.isEmpty(aN.xL)) {
            iError.onError(1, "资源id不存在", null);
        } else if ("local".equals(aN.xL)) {
            iCallbackWith.run("local");
        } else if (TextUtils.isEmpty(aN.xM)) {
            iError.onError(1, "编码不正确", null);
        } else {
            StatisticApi.onEvent(StatisticConstants.LOAD_START_QUERY);
            String gT = s.gT();
            IHttpRequest newRequest = HttpFactory.newRequest();
            this.bR = newRequest;
            newRequest.setUrl(gT).setMethod("POST").addQueryField("id", aN.xL).setBody(e(context, str2)).enqueue(new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.steploading.e.1
                @Override // com.baidu.ar.ihttp.a
                public void a(HttpException httpException) {
                    StatisticApi.onEvent(StatisticConstants.LOAD_QUERY_FAILURE);
                    IError iError2 = iError;
                    if (iError2 != null) {
                        iError2.onError(1, httpException.getMessage(), httpException);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
                /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
                @Override // com.baidu.ar.ihttp.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void a(IHttpResponse iHttpResponse) {
                    int i;
                    String message;
                    JSONException jSONException;
                    Exception exc;
                    String str3 = null;
                    if (iHttpResponse.isSuccess()) {
                        try {
                            String aO = e.this.aO(iHttpResponse.getContent());
                            if (iCallbackWith != null) {
                                iCallbackWith.run(aO);
                            }
                        } catch (JSONException e) {
                            JSONException jSONException2 = e;
                            jSONException2.printStackTrace();
                            i = 3;
                            message = jSONException2.getMessage();
                            jSONException = jSONException2;
                            Exception exc2 = jSONException;
                            str3 = message;
                            exc = exc2;
                            if (TextUtils.isEmpty(str3)) {
                            }
                        } catch (Exception e2) {
                            Exception exc3 = e2;
                            exc3.printStackTrace();
                            i = 1;
                            message = exc3.getMessage();
                            jSONException = exc3;
                            Exception exc22 = jSONException;
                            str3 = message;
                            exc = exc22;
                            if (TextUtils.isEmpty(str3)) {
                            }
                        }
                    }
                    i = 0;
                    exc = null;
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    StatisticApi.onEvent(StatisticConstants.LOAD_QUERY_FAILURE);
                    IError iError2 = iError;
                    if (iError2 != null) {
                        iError2.onError(i, str3, exc);
                    }
                }
            });
        }
    }

    @Override // com.baidu.ar.e.a
    public void fp() {
        IHttpRequest iHttpRequest = this.bR;
        if (iHttpRequest != null) {
            iHttpRequest.cancel();
            this.bR = null;
        }
    }
}
