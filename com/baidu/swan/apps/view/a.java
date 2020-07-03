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
    private BearLayout cQb;
    private SwanAppBearInfo cQc;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.cQc = swanAppBearInfo;
        this.cQb = (BearLayout) view.findViewById(i);
        this.cQb.setVisibility(0);
        this.cQb.a(activity, swanAppBearInfo, this);
    }

    public void avn() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.cQc.bearId);
            linkedHashMap.put("op_type", "add");
            String Ti = com.baidu.swan.apps.u.a.agj().Ti();
            if (!TextUtils.isEmpty(Ti)) {
                com.baidu.swan.c.c.a.aGD().getRequest().url(Ti).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.u.a.agu().TS()).build().executeAsyncOnUIBack(new C0403a(this.cQb.getCallback(), false));
                return;
            }
            return;
        }
        d.k(this.mActivity, a.h.aiapps_net_error).showToast();
    }

    public void avo() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.cQc.bearId);
            String Th = com.baidu.swan.apps.u.a.agj().Th();
            if (!TextUtils.isEmpty(Th)) {
                com.baidu.swan.c.c.a.aGD().getRequest().url(Th).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.u.a.agu().TS()).build().executeAsyncOnUIBack(new C0403a(this.cQb.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0403a extends ResponseCallback<String> {
        private BearLayout.a cQd;
        private boolean cQe;

        C0403a(BearLayout.a aVar, boolean z) {
            this.cQd = aVar;
            this.cQe = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            if (this.cQd != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
                    if (optInt == 0) {
                        if (this.cQe) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.cQd.fz(false);
                                } else {
                                    this.cQd.fz(true);
                                }
                            }
                        } else {
                            this.cQd.fz(true);
                        }
                    } else if (800200 == optInt) {
                        this.cQd.qc("errNo:" + optInt + ",errMsg:" + jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    } else {
                        this.cQd.qc("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.cQd.qc(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.cQd.qc(exc.getMessage());
            }
        }
    }
}
