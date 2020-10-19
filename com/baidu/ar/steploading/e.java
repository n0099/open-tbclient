package com.baidu.ar.steploading;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.bean.ARCaseBundleInfo;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
import com.baidu.ar.g.o;
import com.baidu.ar.g.s;
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
/* loaded from: classes14.dex */
class e extends com.baidu.ar.e.a<String, String> {
    private IHttpRequest bO;
    private WeakReference<Context> vz;
    private ARCaseBundleInfo wJ;
    private a wL;

    public e(Context context, ARCaseBundleInfo aRCaseBundleInfo, a aVar) {
        this.vz = new WeakReference<>(context);
        this.wJ = aRCaseBundleInfo;
        this.wL = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aL(String str) {
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
        Context context = this.vz.get();
        if (context == null || this.wJ == null) {
            return;
        }
        String str2 = this.wJ.arKey;
        f aK = this.wL.aK(str);
        if (aK == null) {
            iError.onError(1, "资源不存在", null);
        } else if (TextUtils.isEmpty(aK.wX)) {
            iError.onError(1, "资源id不存在", null);
        } else if ("local".equals(aK.wX)) {
            iCallbackWith.run("local");
        } else if (TextUtils.isEmpty(aK.wY)) {
            iError.onError(1, "编码不正确", null);
        } else {
            StatisticApi.onEvent(StatisticConstants.LOAD_START_QUERY);
            String gT = s.gT();
            this.bO = HttpFactory.newRequest();
            this.bO.setUrl(gT).setMethod("POST").addQueryField("id", aK.wX).setBody(e(context, str2)).enqueue(new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.steploading.e.1
                @Override // com.baidu.ar.ihttp.a
                public void a(HttpException httpException) {
                    StatisticApi.onEvent(StatisticConstants.LOAD_QUERY_FAILURE);
                    if (iError != null) {
                        iError.onError(1, httpException.getMessage(), httpException);
                    }
                }

                @Override // com.baidu.ar.ihttp.a
                public void a(IHttpResponse iHttpResponse) {
                    int i;
                    JSONException jSONException;
                    String str3 = null;
                    if (iHttpResponse.isSuccess()) {
                        try {
                            String aL = e.this.aL(iHttpResponse.getContent());
                            if (iCallbackWith != null) {
                                iCallbackWith.run(aL);
                            }
                            i = 0;
                            jSONException = null;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            i = 3;
                            str3 = e.getMessage();
                            jSONException = e;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            i = 1;
                            str3 = e2.getMessage();
                            jSONException = e2;
                        }
                    } else {
                        i = 0;
                        jSONException = null;
                    }
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    StatisticApi.onEvent(StatisticConstants.LOAD_QUERY_FAILURE);
                    if (iError != null) {
                        iError.onError(i, str3, jSONException);
                    }
                }
            });
        }
    }

    @Override // com.baidu.ar.e.a
    protected void fq() {
        if (this.bO != null) {
            this.bO.cancel();
            this.bO = null;
        }
    }
}
