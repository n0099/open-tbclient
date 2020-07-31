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
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private BearLayout cTC;
    private SwanAppBearInfo cTD;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.cTD = swanAppBearInfo;
        this.cTC = (BearLayout) view.findViewById(i);
        this.cTC.setVisibility(0);
        this.cTC.a(activity, swanAppBearInfo, this);
    }

    public void axB() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.cTD.bearId);
            linkedHashMap.put("op_type", "add");
            String TD = com.baidu.swan.apps.t.a.ahv().TD();
            if (!TextUtils.isEmpty(TD)) {
                com.baidu.swan.b.c.a.aKu().getRequest().url(TD).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.t.a.ahH().Us()).build().executeAsyncOnUIBack(new C0409a(this.cTC.getCallback(), false));
                return;
            }
            return;
        }
        com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, a.h.aiapps_net_error).showToast();
    }

    public void axC() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.cTD.bearId);
            String TC = com.baidu.swan.apps.t.a.ahv().TC();
            if (!TextUtils.isEmpty(TC)) {
                com.baidu.swan.b.c.a.aKu().getRequest().url(TC).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.t.a.ahH().Us()).build().executeAsyncOnUIBack(new C0409a(this.cTC.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0409a extends ResponseCallback<String> {
        private BearLayout.a cTE;
        private boolean cTF;

        C0409a(BearLayout.a aVar, boolean z) {
            this.cTE = aVar;
            this.cTF = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            if (this.cTE != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
                    if (optInt == 0) {
                        if (this.cTF) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.cTE.fI(false);
                                } else {
                                    this.cTE.fI(true);
                                }
                            }
                        } else {
                            this.cTE.fI(true);
                        }
                    } else if (800200 == optInt) {
                        this.cTE.qR("errNo:" + optInt + ",errMsg:" + jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    } else {
                        this.cTE.qR("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.cTE.qR(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.cTE.qR(exc.getMessage());
            }
        }
    }
}
