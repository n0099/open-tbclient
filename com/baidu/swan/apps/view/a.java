package com.baidu.swan.apps.view;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
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
    private BearLayout buv;
    private SwanAppBearInfo buw;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.buw = swanAppBearInfo;
        this.buv = (BearLayout) view.findViewById(i);
        this.buv.setVisibility(0);
        this.buv.a(activity, swanAppBearInfo, this);
    }

    public void UN() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.buw.aXw);
            linkedHashMap.put("op_type", IMTrack.DbBuilder.ACTION_ADD);
            String Ce = com.baidu.swan.apps.u.a.Ju().Ce();
            if (!TextUtils.isEmpty(Ce)) {
                HttpManager.getDefault(com.baidu.swan.apps.u.a.Ji()).getRequest().url(Ce).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.u.a.JF().Kd()).build().executeAsyncOnUIBack(new C0230a(this.buv.getCallback(), false));
                return;
            }
            return;
        }
        d.i(this.mActivity, a.h.aiapps_net_error).QN();
    }

    public void UO() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.buw.aXw);
            String Cd = com.baidu.swan.apps.u.a.Ju().Cd();
            if (!TextUtils.isEmpty(Cd)) {
                HttpManager.getDefault(com.baidu.swan.apps.u.a.Ji()).getRequest().url(Cd).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.u.a.JF().Kd()).build().executeAsyncOnUIBack(new C0230a(this.buv.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0230a extends ResponseCallback<String> {
        private BearLayout.a bux;
        private boolean buy;

        C0230a(BearLayout.a aVar, boolean z) {
            this.bux = aVar;
            this.buy = z;
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
            if (this.bux != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno");
                    if (optInt == 0) {
                        if (this.buy) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray(DpStatConstants.KEY_ITEMS);
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.bux.cW(false);
                                } else {
                                    this.bux.cW(true);
                                }
                            }
                        } else {
                            this.bux.cW(true);
                        }
                    } else if (800200 == optInt) {
                        this.bux.jh("errNo:" + optInt + ",errMsg:" + jSONObject.optString("errmsg"));
                    } else {
                        this.bux.jh("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.bux.jh(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.bux.jh(exc.getMessage());
            }
        }
    }
}
