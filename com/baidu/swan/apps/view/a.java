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
    private SwanAppBearInfo bZA;
    private BearLayout bZz;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.bZA = swanAppBearInfo;
        this.bZz = (BearLayout) view.findViewById(i);
        this.bZz.setVisibility(0);
        this.bZz.a(activity, swanAppBearInfo, this);
    }

    public void aht() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.bZA.bearId);
            linkedHashMap.put("op_type", "add");
            String Ir = com.baidu.swan.apps.w.a.Ul().Ir();
            if (!TextUtils.isEmpty(Ir)) {
                HttpManager.getDefault(com.baidu.swan.apps.w.a.TZ()).getRequest().url(Ir).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.w.a.Ux().Ix()).build().executeAsyncOnUIBack(new C0303a(this.bZz.getCallback(), false));
                return;
            }
            return;
        }
        d.q(this.mActivity, a.h.aiapps_net_error).showToast();
    }

    public void ahu() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.bZA.bearId);
            String Iq = com.baidu.swan.apps.w.a.Ul().Iq();
            if (!TextUtils.isEmpty(Iq)) {
                HttpManager.getDefault(com.baidu.swan.apps.w.a.TZ()).getRequest().url(Iq).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.w.a.Ux().Ix()).build().executeAsyncOnUIBack(new C0303a(this.bZz.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0303a extends ResponseCallback<String> {
        private BearLayout.a bZB;
        private boolean bZC;

        C0303a(BearLayout.a aVar, boolean z) {
            this.bZB = aVar;
            this.bZC = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            if (this.bZB != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno");
                    if (optInt == 0) {
                        if (this.bZC) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.bZB.ed(false);
                                } else {
                                    this.bZB.ed(true);
                                }
                            }
                        } else {
                            this.bZB.ed(true);
                        }
                    } else if (800200 == optInt) {
                        this.bZB.mY("errNo:" + optInt + ",errMsg:" + jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    } else {
                        this.bZB.mY("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.bZB.mY(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.bZB.mY(exc.getMessage());
            }
        }
    }
}
