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
    private BearLayout dDA;
    private SwanAppBearInfo dDB;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.dDB = swanAppBearInfo;
        this.dDA = (BearLayout) view.findViewById(i);
        this.dDA.setVisibility(0);
        this.dDA.a(activity, swanAppBearInfo, this);
    }

    public void aMO() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.dDB.bearId);
            linkedHashMap.put("op_type", "add");
            String agK = com.baidu.swan.apps.t.a.awe().agK();
            if (!TextUtils.isEmpty(agK)) {
                com.baidu.swan.a.c.a.bad().getRequest().url(agK).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.t.a.awr().ahB()).build().executeAsyncOnUIBack(new C0491a(this.dDA.getCallback(), false));
                return;
            }
            return;
        }
        com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, a.h.aiapps_net_error).showToast();
    }

    public void aMP() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.dDB.bearId);
            String agJ = com.baidu.swan.apps.t.a.awe().agJ();
            if (!TextUtils.isEmpty(agJ)) {
                com.baidu.swan.a.c.a.bad().getRequest().url(agJ).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.t.a.awr().ahB()).build().executeAsyncOnUIBack(new C0491a(this.dDA.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0491a extends ResponseCallback<String> {
        private BearLayout.a dDC;
        private boolean dDD;

        C0491a(BearLayout.a aVar, boolean z) {
            this.dDC = aVar;
            this.dDD = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            if (this.dDC != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
                    if (optInt == 0) {
                        if (this.dDD) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.dDC.gV(false);
                                } else {
                                    this.dDC.gV(true);
                                }
                            }
                        } else {
                            this.dDC.gV(true);
                        }
                    } else if (800200 == optInt) {
                        this.dDC.uB("errNo:" + optInt + ",errMsg:" + jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    } else {
                        this.dDC.uB("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.dDC.uB(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.dDC.uB(exc.getMessage());
            }
        }
    }
}
