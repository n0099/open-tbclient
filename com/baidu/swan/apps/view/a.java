package com.baidu.swan.apps.view;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.util.io.BaseJsonData;
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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private BearLayout bUW;
    private SwanAppBearInfo bUX;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.bUX = swanAppBearInfo;
        this.bUW = (BearLayout) view.findViewById(i);
        this.bUW.setVisibility(0);
        this.bUW.a(activity, swanAppBearInfo, this);
    }

    public void aeH() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.bUX.bearId);
            linkedHashMap.put("op_type", "add");
            String FB = com.baidu.swan.apps.w.a.Rw().FB();
            if (!TextUtils.isEmpty(FB)) {
                HttpManager.getDefault(com.baidu.swan.apps.w.a.Rk()).getRequest().url(FB).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.w.a.RI().FH()).build().executeAsyncOnUIBack(new C0291a(this.bUW.getCallback(), false));
                return;
            }
            return;
        }
        d.q(this.mActivity, a.h.aiapps_net_error).showToast();
    }

    public void aeI() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.bUX.bearId);
            String FA = com.baidu.swan.apps.w.a.Rw().FA();
            if (!TextUtils.isEmpty(FA)) {
                HttpManager.getDefault(com.baidu.swan.apps.w.a.Rk()).getRequest().url(FA).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.w.a.RI().FH()).build().executeAsyncOnUIBack(new C0291a(this.bUW.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0291a extends ResponseCallback<String> {
        private BearLayout.a bUY;
        private boolean bUZ;

        C0291a(BearLayout.a aVar, boolean z) {
            this.bUY = aVar;
            this.bUZ = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            if (this.bUY != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno");
                    if (optInt == 0) {
                        if (this.bUZ) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.bUY.dQ(false);
                                } else {
                                    this.bUY.dQ(true);
                                }
                            }
                        } else {
                            this.bUY.dQ(true);
                        }
                    } else if (800200 == optInt) {
                        this.bUY.mH("errNo:" + optInt + ",errMsg:" + jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    } else {
                        this.bUY.mH("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.bUY.mH(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.bUY.mH(exc.getMessage());
            }
        }
    }
}
