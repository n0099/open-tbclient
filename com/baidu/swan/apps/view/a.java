package com.baidu.swan.apps.view;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.view.BearLayout;
import java.util.LinkedHashMap;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private BearLayout dFh;
    private SwanAppBearInfo dFi;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.dFi = swanAppBearInfo;
        this.dFh = (BearLayout) view.findViewById(i);
        this.dFh.setVisibility(0);
        this.dFh.a(activity, swanAppBearInfo, this);
    }

    public void aNw() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.dFi.bearId);
            linkedHashMap.put("op_type", "add");
            String ahs = com.baidu.swan.apps.t.a.awM().ahs();
            if (!TextUtils.isEmpty(ahs)) {
                com.baidu.swan.a.c.a.baK().getRequest().url(ahs).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.t.a.awZ().aij()).build().executeAsyncOnUIBack(new C0493a(this.dFh.getCallback(), false));
                return;
            }
            return;
        }
        com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, a.h.aiapps_net_error).showToast();
    }

    public void aNx() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.dFi.bearId);
            String ahr = com.baidu.swan.apps.t.a.awM().ahr();
            if (!TextUtils.isEmpty(ahr)) {
                com.baidu.swan.a.c.a.baK().getRequest().url(ahr).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.t.a.awZ().aij()).build().executeAsyncOnUIBack(new C0493a(this.dFh.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0493a extends ResponseCallback<String> {
        private BearLayout.a dFj;
        private boolean dFk;

        C0493a(BearLayout.a aVar, boolean z) {
            this.dFj = aVar;
            this.dFk = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            if (this.dFj != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
                    if (optInt == 0) {
                        if (this.dFk) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.dFj.gS(false);
                                } else {
                                    this.dFj.gS(true);
                                }
                            }
                        } else {
                            this.dFj.gS(true);
                        }
                    } else if (800200 == optInt) {
                        this.dFj.uG("errNo:" + optInt + ",errMsg:" + jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    } else {
                        this.dFj.uG("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.dFj.uG(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.dFj.uG(exc.getMessage());
            }
        }
    }
}
