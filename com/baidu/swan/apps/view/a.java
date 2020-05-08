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
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private BearLayout cyy;
    private SwanAppBearInfo cyz;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.cyz = swanAppBearInfo;
        this.cyy = (BearLayout) view.findViewById(i);
        this.cyy.setVisibility(0);
        this.cyy.a(activity, swanAppBearInfo, this);
    }

    public void apA() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.cyz.bearId);
            linkedHashMap.put("op_type", "add");
            String Qc = com.baidu.swan.apps.w.a.abZ().Qc();
            if (!TextUtils.isEmpty(Qc)) {
                HttpManager.getDefault(com.baidu.swan.apps.w.a.abN()).getRequest().url(Qc).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.w.a.acl().Qi()).build().executeAsyncOnUIBack(new C0354a(this.cyy.getCallback(), false));
                return;
            }
            return;
        }
        d.k(this.mActivity, a.h.aiapps_net_error).showToast();
    }

    public void apB() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.cyz.bearId);
            String Qb = com.baidu.swan.apps.w.a.abZ().Qb();
            if (!TextUtils.isEmpty(Qb)) {
                HttpManager.getDefault(com.baidu.swan.apps.w.a.abN()).getRequest().url(Qb).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.w.a.acl().Qi()).build().executeAsyncOnUIBack(new C0354a(this.cyy.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0354a extends ResponseCallback<String> {
        private BearLayout.a cyA;
        private boolean cyB;

        C0354a(BearLayout.a aVar, boolean z) {
            this.cyA = aVar;
            this.cyB = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            if (this.cyA != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
                    if (optInt == 0) {
                        if (this.cyB) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.cyA.eZ(false);
                                } else {
                                    this.cyA.eZ(true);
                                }
                            }
                        } else {
                            this.cyA.eZ(true);
                        }
                    } else if (800200 == optInt) {
                        this.cyA.om("errNo:" + optInt + ",errMsg:" + jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    } else {
                        this.cyA.om("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.cyA.om(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.cyA.om(exc.getMessage());
            }
        }
    }
}
