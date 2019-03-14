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
    private BearLayout aWQ;
    private SwanAppBearInfo axP;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.axP = swanAppBearInfo;
        this.aWQ = (BearLayout) view.findViewById(i);
        this.aWQ.setVisibility(0);
        this.aWQ.a(activity, swanAppBearInfo, this);
    }

    public void Mv() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.axP.aBs);
            linkedHashMap.put("op_type", "add");
            String vP = com.baidu.swan.apps.u.a.CK().vP();
            if (!TextUtils.isEmpty(vP)) {
                HttpManager.getDefault(com.baidu.swan.apps.u.a.Cy()).getRequest().url(vP).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.u.a.CV().Dt()).build().executeAsyncOnUIBack(new C0179a(this.aWQ.getCallback(), false));
                return;
            }
            return;
        }
        d.l(this.mActivity, a.h.aiapps_net_error).IK();
    }

    public void Mw() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.axP.aBs);
            String vO = com.baidu.swan.apps.u.a.CK().vO();
            if (!TextUtils.isEmpty(vO)) {
                HttpManager.getDefault(com.baidu.swan.apps.u.a.Cy()).getRequest().url(vO).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.u.a.CV().Dt()).build().executeAsyncOnUIBack(new C0179a(this.aWQ.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0179a extends ResponseCallback<String> {
        private BearLayout.a aWR;
        private boolean aWS;

        C0179a(BearLayout.a aVar, boolean z) {
            this.aWR = aVar;
            this.aWS = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: I */
        public void onSuccess(String str, int i) {
            if (this.aWR != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno");
                    if (optInt == 0) {
                        if (this.aWS) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.aWR.cn(false);
                                } else {
                                    this.aWR.cn(true);
                                }
                            }
                        } else {
                            this.aWR.cn(true);
                        }
                    } else if (800200 == optInt) {
                        this.aWR.hP("errNo:" + optInt + ",errMsg:" + jSONObject.optString("errmsg"));
                    } else {
                        this.aWR.hP("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.aWR.hP(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.aWR.hP(exc.getMessage());
            }
        }
    }
}
