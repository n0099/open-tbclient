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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class e extends com.baidu.ar.e.a<String, String> {
    private IHttpRequest bR;
    private WeakReference<Context> wn;
    private ARCaseBundleInfo xx;
    private a xz;

    public e(Context context, ARCaseBundleInfo aRCaseBundleInfo, a aVar) {
        this.wn = new WeakReference<>(context);
        this.xx = aRCaseBundleInfo;
        this.xz = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aO(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getInt("errorNum") != 0) {
            throw new Exception(jSONObject.optString(TiebaInitialize.LogFields.ERROR_MESSAGE, "query res failed"));
        }
        String string = jSONObject.getString("data");
        if (TextUtils.isEmpty(string)) {
            throw new Exception("query res failed");
        }
        return string;
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
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.e.a
    public void a(String str, final ICallbackWith<String> iCallbackWith, final IError iError) {
        Context context = this.wn.get();
        if (context == null || this.xx == null) {
            return;
        }
        String str2 = this.xx.arKey;
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
            this.bR = HttpFactory.newRequest();
            this.bR.setUrl(gT).setMethod("POST").addQueryField("id", aN.xL).setBody(e(context, str2)).enqueue(new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.steploading.e.1
                @Override // com.baidu.ar.ihttp.a
                public void a(HttpException httpException) {
                    StatisticApi.onEvent(StatisticConstants.LOAD_QUERY_FAILURE);
                    if (iError != null) {
                        iError.onError(1, httpException.getMessage(), httpException);
                    }
                }

                @Override // com.baidu.ar.ihttp.a
                public void a(IHttpResponse iHttpResponse) {
                    String message;
                    JSONException jSONException;
                    int i = 0;
                    if (iHttpResponse.isSuccess()) {
                        try {
                            String aO = e.this.aO(iHttpResponse.getContent());
                            if (iCallbackWith != null) {
                                iCallbackWith.run(aO);
                            }
                            message = null;
                            jSONException = null;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            i = 3;
                            message = e.getMessage();
                            jSONException = e;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            i = 1;
                            message = e2.getMessage();
                            jSONException = e2;
                        }
                    } else {
                        message = null;
                        jSONException = null;
                    }
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    StatisticApi.onEvent(StatisticConstants.LOAD_QUERY_FAILURE);
                    if (iError != null) {
                        iError.onError(i, message, jSONException);
                    }
                }
            });
        }
    }

    @Override // com.baidu.ar.e.a
    protected void fp() {
        if (this.bR != null) {
            this.bR.cancel();
            this.bR = null;
        }
    }
}
