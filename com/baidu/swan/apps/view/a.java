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
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private BearLayout dKy;
    private SwanAppBearInfo dKz;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.dKz = swanAppBearInfo;
        this.dKy = (BearLayout) view.findViewById(i);
        this.dKy.setVisibility(0);
        this.dKy.a(activity, swanAppBearInfo, this);
    }

    public void aPU() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.dKz.bearId);
            linkedHashMap.put("op_type", "add");
            String ajS = com.baidu.swan.apps.t.a.azm().ajS();
            if (!TextUtils.isEmpty(ajS)) {
                com.baidu.swan.a.c.a.bdi().getRequest().url(ajS).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.t.a.azz().akJ()).build().executeAsyncOnUIBack(new C0503a(this.dKy.getCallback(), false));
                return;
            }
            return;
        }
        com.baidu.swan.apps.res.widget.b.d.t(this.mActivity, a.h.aiapps_net_error).showToast();
    }

    public void aPV() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.dKz.bearId);
            String ajR = com.baidu.swan.apps.t.a.azm().ajR();
            if (!TextUtils.isEmpty(ajR)) {
                com.baidu.swan.a.c.a.bdi().getRequest().url(ajR).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.t.a.azz().akJ()).build().executeAsyncOnUIBack(new C0503a(this.dKy.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public class C0503a extends ResponseCallback<String> {
        private BearLayout.a dKA;
        private boolean dKB;

        C0503a(BearLayout.a aVar, boolean z) {
            this.dKA = aVar;
            this.dKB = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            if (this.dKA != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
                    if (optInt == 0) {
                        if (this.dKB) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.dKA.hk(false);
                                } else {
                                    this.dKA.hk(true);
                                }
                            }
                        } else {
                            this.dKA.hk(true);
                        }
                    } else if (800200 == optInt) {
                        this.dKA.vi("errNo:" + optInt + ",errMsg:" + jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    } else {
                        this.dKA.vi("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.dKA.vi(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.dKA.vi(exc.getMessage());
            }
        }
    }
}
