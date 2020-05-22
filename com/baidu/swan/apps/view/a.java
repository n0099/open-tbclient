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
    private BearLayout cLr;
    private SwanAppBearInfo cLs;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.cLs = swanAppBearInfo;
        this.cLr = (BearLayout) view.findViewById(i);
        this.cLr.setVisibility(0);
        this.cLr.a(activity, swanAppBearInfo, this);
    }

    public void auh() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.cLs.bearId);
            linkedHashMap.put("op_type", "add");
            String Sc = com.baidu.swan.apps.u.a.afd().Sc();
            if (!TextUtils.isEmpty(Sc)) {
                com.baidu.swan.c.c.a.aFx().getRequest().url(Sc).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.u.a.afo().SM()).build().executeAsyncOnUIBack(new C0397a(this.cLr.getCallback(), false));
                return;
            }
            return;
        }
        d.k(this.mActivity, a.h.aiapps_net_error).showToast();
    }

    public void aui() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.cLs.bearId);
            String Sb = com.baidu.swan.apps.u.a.afd().Sb();
            if (!TextUtils.isEmpty(Sb)) {
                com.baidu.swan.c.c.a.aFx().getRequest().url(Sb).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.u.a.afo().SM()).build().executeAsyncOnUIBack(new C0397a(this.cLr.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0397a extends ResponseCallback<String> {
        private BearLayout.a cLt;
        private boolean cLu;

        C0397a(BearLayout.a aVar, boolean z) {
            this.cLt = aVar;
            this.cLu = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            if (this.cLt != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
                    if (optInt == 0) {
                        if (this.cLu) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.cLt.fu(false);
                                } else {
                                    this.cLt.fu(true);
                                }
                            }
                        } else {
                            this.cLt.fu(true);
                        }
                    } else if (800200 == optInt) {
                        this.cLt.pU("errNo:" + optInt + ",errMsg:" + jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    } else {
                        this.cLt.pU("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.cLt.pU(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.cLt.pU(exc.getMessage());
            }
        }
    }
}
