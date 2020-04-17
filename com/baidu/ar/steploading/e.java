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
/* loaded from: classes3.dex */
class e extends com.baidu.ar.d.a<String, String> {
    private IHttpRequest bK;
    private WeakReference<Context> uw;
    private ARCaseBundleInfo vG;
    private a vI;

    public e(Context context, ARCaseBundleInfo aRCaseBundleInfo, a aVar) {
        this.uw = new WeakReference<>(context);
        this.vG = aRCaseBundleInfo;
        this.vI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aG(String str) {
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
            m.f(jSONObject);
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
        Context context = this.uw.get();
        if (context == null) {
            return;
        }
        String str2 = this.vG.arKey;
        f aF = this.vI.aF(str);
        if (aF == null) {
            iError.onError(1, "资源不存在", null);
        } else if (TextUtils.isEmpty(aF.vU)) {
            iError.onError(1, "资源id不存在", null);
        } else if (RecentlyVisitedForumModel.LOCAL_ACCOUNT.equals(aF.vU)) {
            iCallbackWith.run(RecentlyVisitedForumModel.LOCAL_ACCOUNT);
        } else if (TextUtils.isEmpty(aF.vV)) {
            iError.onError(1, "编码不正确", null);
        } else {
            StatisticApi.onEvent(StatisticConstants.LOAD_START_QUERY);
            String fo = q.fo();
            this.bK = HttpFactory.newRequest();
            this.bK.setUrl(fo).setMethod("POST").addQueryField("id", aF.vU).setBody(d(context, str2)).enqueue(new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.steploading.e.1
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
                            String aG = e.this.aG(iHttpResponse.getContent());
                            if (iCallbackWith != null) {
                                iCallbackWith.run(aG);
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
    protected void dO() {
        if (this.bK != null) {
            this.bK.cancel();
            this.bK = null;
        }
    }
}
