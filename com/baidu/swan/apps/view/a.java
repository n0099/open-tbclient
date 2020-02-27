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
    private BearLayout bZm;
    private SwanAppBearInfo bZn;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.bZn = swanAppBearInfo;
        this.bZm = (BearLayout) view.findViewById(i);
        this.bZm.setVisibility(0);
        this.bZm.a(activity, swanAppBearInfo, this);
    }

    public void aho() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.bZn.bearId);
            linkedHashMap.put("op_type", "add");
            String Im = com.baidu.swan.apps.w.a.Ug().Im();
            if (!TextUtils.isEmpty(Im)) {
                HttpManager.getDefault(com.baidu.swan.apps.w.a.TU()).getRequest().url(Im).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.w.a.Us().Is()).build().executeAsyncOnUIBack(new C0303a(this.bZm.getCallback(), false));
                return;
            }
            return;
        }
        d.q(this.mActivity, a.h.aiapps_net_error).showToast();
    }

    public void ahp() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.bZn.bearId);
            String Il = com.baidu.swan.apps.w.a.Ug().Il();
            if (!TextUtils.isEmpty(Il)) {
                HttpManager.getDefault(com.baidu.swan.apps.w.a.TU()).getRequest().url(Il).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.w.a.Us().Is()).build().executeAsyncOnUIBack(new C0303a(this.bZm.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0303a extends ResponseCallback<String> {
        private BearLayout.a bZo;
        private boolean bZp;

        C0303a(BearLayout.a aVar, boolean z) {
            this.bZo = aVar;
            this.bZp = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            if (this.bZo != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno");
                    if (optInt == 0) {
                        if (this.bZp) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.bZo.ec(false);
                                } else {
                                    this.bZo.ec(true);
                                }
                            }
                        } else {
                            this.bZo.ec(true);
                        }
                    } else if (800200 == optInt) {
                        this.bZo.mZ("errNo:" + optInt + ",errMsg:" + jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    } else {
                        this.bZo.mZ("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.bZo.mZ(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.bZo.mZ(exc.getMessage());
            }
        }
    }
}
