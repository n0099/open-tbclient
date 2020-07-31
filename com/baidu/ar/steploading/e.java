package com.baidu.ar.steploading;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.bean.ARCaseBundleInfo;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
import com.baidu.ar.f.m;
import com.baidu.ar.f.q;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
class e extends com.baidu.ar.d.a<String, String> {
    private IHttpRequest bX;
    private WeakReference<Context> uW;
    private ARCaseBundleInfo wg;
    private a wi;

    public e(Context context, ARCaseBundleInfo aRCaseBundleInfo, a aVar) {
        this.uW = new WeakReference<>(context);
        this.wg = aRCaseBundleInfo;
        this.wi = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aH(String str) {
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

    private JSONObject d(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            m.g(jSONObject);
            m.b(context, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.d.a
    public void a(String str, final ICallbackWith<String> iCallbackWith, final IError iError) {
        Context context = this.uW.get();
        if (context == null) {
            return;
        }
        String str2 = this.wg.arKey;
        f aG = this.wi.aG(str);
        if (aG == null) {
            iError.onError(1, "资源不存在", null);
        } else if (TextUtils.isEmpty(aG.wu)) {
            iError.onError(1, "资源id不存在", null);
        } else if (RecentlyVisitedForumModel.LOCAL_ACCOUNT.equals(aG.wu)) {
            iCallbackWith.run(RecentlyVisitedForumModel.LOCAL_ACCOUNT);
        } else if (TextUtils.isEmpty(aG.wv)) {
            iError.onError(1, "编码不正确", null);
        } else {
            StatisticApi.onEvent(StatisticConstants.LOAD_START_QUERY);
            String fE = q.fE();
            this.bX = HttpFactory.newRequest();
            this.bX.setUrl(fE).setMethod("POST").addQueryField("id", aG.wu).setBody(d(context, str2)).enqueue(new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.steploading.e.1
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
                            String aH = e.this.aH(iHttpResponse.getContent());
                            if (iCallbackWith != null) {
                                iCallbackWith.run(aH);
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

    @Override // com.baidu.ar.d.a
    protected void ee() {
        if (this.bX != null) {
            this.bX.cancel();
            this.bX = null;
        }
    }
}
