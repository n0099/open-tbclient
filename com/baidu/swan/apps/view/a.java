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
    private BearLayout baX;
    private SwanAppBearInfo baY;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.baY = swanAppBearInfo;
        this.baX = (BearLayout) view.findViewById(i);
        this.baX.setVisibility(0);
        this.baX.a(activity, swanAppBearInfo, this);
    }

    public void PT() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.baY.aDJ);
            linkedHashMap.put("op_type", "add");
            String xg = com.baidu.swan.apps.u.a.Ew().xg();
            if (!TextUtils.isEmpty(xg)) {
                HttpManager.getDefault(com.baidu.swan.apps.u.a.Ek()).getRequest().url(xg).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.u.a.EH().Ff()).build().executeAsyncOnUIBack(new C0189a(this.baX.getCallback(), false));
                return;
            }
            return;
        }
        d.k(this.mActivity, a.h.aiapps_net_error).LQ();
    }

    public void PU() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.baY.aDJ);
            String xf = com.baidu.swan.apps.u.a.Ew().xf();
            if (!TextUtils.isEmpty(xf)) {
                HttpManager.getDefault(com.baidu.swan.apps.u.a.Ek()).getRequest().url(xf).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.u.a.EH().Ff()).build().executeAsyncOnUIBack(new C0189a(this.baX.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0189a extends ResponseCallback<String> {
        private BearLayout.a baZ;
        private boolean bba;

        C0189a(BearLayout.a aVar, boolean z) {
            this.baZ = aVar;
            this.bba = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: x */
        public void onSuccess(String str, int i) {
            if (this.baZ != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno");
                    if (optInt == 0) {
                        if (this.bba) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.baZ.cF(false);
                                } else {
                                    this.baZ.cF(true);
                                }
                            }
                        } else {
                            this.baZ.cF(true);
                        }
                    } else if (800200 == optInt) {
                        this.baZ.iC("errNo:" + optInt + ",errMsg:" + jSONObject.optString("errmsg"));
                    } else {
                        this.baZ.iC("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.baZ.iC(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.baZ.iC(exc.getMessage());
            }
        }
    }
}
