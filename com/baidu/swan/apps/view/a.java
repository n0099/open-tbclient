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
    private BearLayout aWU;
    private SwanAppBearInfo axT;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.axT = swanAppBearInfo;
        this.aWU = (BearLayout) view.findViewById(i);
        this.aWU.setVisibility(0);
        this.aWU.a(activity, swanAppBearInfo, this);
    }

    public void Mt() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.axT.aBw);
            linkedHashMap.put("op_type", "add");
            String vO = com.baidu.swan.apps.u.a.CI().vO();
            if (!TextUtils.isEmpty(vO)) {
                HttpManager.getDefault(com.baidu.swan.apps.u.a.Cw()).getRequest().url(vO).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.u.a.CT().Dr()).build().executeAsyncOnUIBack(new C0179a(this.aWU.getCallback(), false));
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
            linkedHashMap.put("third_id", this.axT.aBw);
            String vN = com.baidu.swan.apps.u.a.CI().vN();
            if (!TextUtils.isEmpty(vN)) {
                HttpManager.getDefault(com.baidu.swan.apps.u.a.Cw()).getRequest().url(vN).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.u.a.CT().Dr()).build().executeAsyncOnUIBack(new C0179a(this.aWU.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0179a extends ResponseCallback<String> {
        private BearLayout.a aWV;
        private boolean aWW;

        C0179a(BearLayout.a aVar, boolean z) {
            this.aWV = aVar;
            this.aWW = z;
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
            if (this.aWV != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno");
                    if (optInt == 0) {
                        if (this.aWW) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.aWV.cn(false);
                                } else {
                                    this.aWV.cn(true);
                                }
                            }
                        } else {
                            this.aWV.cn(true);
                        }
                    } else if (800200 == optInt) {
                        this.aWV.hQ("errNo:" + optInt + ",errMsg:" + jSONObject.optString("errmsg"));
                    } else {
                        this.aWV.hQ("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.aWV.hQ(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.aWV.hQ(exc.getMessage());
            }
        }
    }
}
