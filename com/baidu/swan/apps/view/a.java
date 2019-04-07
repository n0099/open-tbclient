package com.baidu.swan.apps.view;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.view.BearLayout;
import java.util.LinkedHashMap;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private BearLayout aWT;
    private SwanAppBearInfo axS;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.axS = swanAppBearInfo;
        this.aWT = (BearLayout) view.findViewById(i);
        this.aWT.setVisibility(0);
        this.aWT.a(activity, swanAppBearInfo, this);
    }

    public void Mt() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.axS.aBv);
            linkedHashMap.put("op_type", "add");
            String vO = com.baidu.swan.apps.u.a.CI().vO();
            if (!TextUtils.isEmpty(vO)) {
                HttpManager.getDefault(com.baidu.swan.apps.u.a.Cw()).getRequest().url(vO).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.u.a.CT().Dr()).build().executeAsyncOnUIBack(new C0179a(this.aWT.getCallback(), false));
                return;
            }
            return;
        }
        d.l(this.mActivity, a.h.aiapps_net_error).II();
    }

    public void Mu() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.axS.aBv);
            String vN = com.baidu.swan.apps.u.a.CI().vN();
            if (!TextUtils.isEmpty(vN)) {
                HttpManager.getDefault(com.baidu.swan.apps.u.a.Cw()).getRequest().url(vN).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.u.a.CT().Dr()).build().executeAsyncOnUIBack(new C0179a(this.aWT.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0179a extends ResponseCallback<String> {
        private BearLayout.a aWU;
        private boolean aWV;

        C0179a(BearLayout.a aVar, boolean z) {
            this.aWU = aVar;
            this.aWV = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: I */
        public void onSuccess(String str, int i) {
            if (this.aWU != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno");
                    if (optInt == 0) {
                        if (this.aWV) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.aWU.cn(false);
                                } else {
                                    this.aWU.cn(true);
                                }
                            }
                        } else {
                            this.aWU.cn(true);
                        }
                    } else if (800200 == optInt) {
                        this.aWU.hQ("errNo:" + optInt + ",errMsg:" + jSONObject.optString("errmsg"));
                    } else {
                        this.aWU.hQ("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.aWU.hQ(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.aWU.hQ(exc.getMessage());
            }
        }
    }
}
