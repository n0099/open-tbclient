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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private BearLayout dcD;
    private SwanAppBearInfo dcE;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.dcE = swanAppBearInfo;
        this.dcD = (BearLayout) view.findViewById(i);
        this.dcD.setVisibility(0);
        this.dcD.a(activity, swanAppBearInfo, this);
    }

    public void aFJ() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.dcE.bearId);
            linkedHashMap.put("op_type", "add");
            String ZD = com.baidu.swan.apps.t.a.aoV().ZD();
            if (!TextUtils.isEmpty(ZD)) {
                com.baidu.swan.a.c.a.aSW().getRequest().url(ZD).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.t.a.apj().aau()).build().executeAsyncOnUIBack(new C0455a(this.dcD.getCallback(), false));
                return;
            }
            return;
        }
        com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, a.h.aiapps_net_error).showToast();
    }

    public void aFK() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.dcE.bearId);
            String ZC = com.baidu.swan.apps.t.a.aoV().ZC();
            if (!TextUtils.isEmpty(ZC)) {
                com.baidu.swan.a.c.a.aSW().getRequest().url(ZC).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.t.a.apj().aau()).build().executeAsyncOnUIBack(new C0455a(this.dcD.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0455a extends ResponseCallback<String> {
        private BearLayout.a dcF;
        private boolean dcG;

        C0455a(BearLayout.a aVar, boolean z) {
            this.dcF = aVar;
            this.dcG = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            if (this.dcF != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
                    if (optInt == 0) {
                        if (this.dcG) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.dcF.gb(false);
                                } else {
                                    this.dcF.gb(true);
                                }
                            }
                        } else {
                            this.dcF.gb(true);
                        }
                    } else if (800200 == optInt) {
                        this.dcF.sT("errNo:" + optInt + ",errMsg:" + jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    } else {
                        this.dcF.sT("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.dcF.sT(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.dcF.sT(exc.getMessage());
            }
        }
    }
}
