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
    private BearLayout dzp;
    private SwanAppBearInfo dzq;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.dzq = swanAppBearInfo;
        this.dzp = (BearLayout) view.findViewById(i);
        this.dzp.setVisibility(0);
        this.dzp.a(activity, swanAppBearInfo, this);
    }

    public void aKW() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.dzq.bearId);
            linkedHashMap.put("op_type", "add");
            String aeS = com.baidu.swan.apps.t.a.aum().aeS();
            if (!TextUtils.isEmpty(aeS)) {
                com.baidu.swan.a.c.a.aYk().getRequest().url(aeS).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.t.a.auz().afJ()).build().executeAsyncOnUIBack(new C0481a(this.dzp.getCallback(), false));
                return;
            }
            return;
        }
        com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, a.h.aiapps_net_error).showToast();
    }

    public void aKX() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.dzq.bearId);
            String aeR = com.baidu.swan.apps.t.a.aum().aeR();
            if (!TextUtils.isEmpty(aeR)) {
                com.baidu.swan.a.c.a.aYk().getRequest().url(aeR).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.t.a.auz().afJ()).build().executeAsyncOnUIBack(new C0481a(this.dzp.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0481a extends ResponseCallback<String> {
        private BearLayout.a dzr;
        private boolean dzs;

        C0481a(BearLayout.a aVar, boolean z) {
            this.dzr = aVar;
            this.dzs = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            if (this.dzr != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
                    if (optInt == 0) {
                        if (this.dzs) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.dzr.gJ(false);
                                } else {
                                    this.dzr.gJ(true);
                                }
                            }
                        } else {
                            this.dzr.gJ(true);
                        }
                    } else if (800200 == optInt) {
                        this.dzr.us("errNo:" + optInt + ",errMsg:" + jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    } else {
                        this.dzr.us("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.dzr.us(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.dzr.us(exc.getMessage());
            }
        }
    }
}
