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
    private BearLayout bZn;
    private SwanAppBearInfo bZo;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.bZo = swanAppBearInfo;
        this.bZn = (BearLayout) view.findViewById(i);
        this.bZn.setVisibility(0);
        this.bZn.a(activity, swanAppBearInfo, this);
    }

    public void ahq() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.bZo.bearId);
            linkedHashMap.put("op_type", "add");
            String Io = com.baidu.swan.apps.w.a.Ui().Io();
            if (!TextUtils.isEmpty(Io)) {
                HttpManager.getDefault(com.baidu.swan.apps.w.a.TW()).getRequest().url(Io).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.w.a.Uu().Iu()).build().executeAsyncOnUIBack(new C0303a(this.bZn.getCallback(), false));
                return;
            }
            return;
        }
        d.q(this.mActivity, a.h.aiapps_net_error).showToast();
    }

    public void ahr() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.bZo.bearId);
            String In = com.baidu.swan.apps.w.a.Ui().In();
            if (!TextUtils.isEmpty(In)) {
                HttpManager.getDefault(com.baidu.swan.apps.w.a.TW()).getRequest().url(In).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.w.a.Uu().Iu()).build().executeAsyncOnUIBack(new C0303a(this.bZn.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0303a extends ResponseCallback<String> {
        private BearLayout.a bZp;
        private boolean bZq;

        C0303a(BearLayout.a aVar, boolean z) {
            this.bZp = aVar;
            this.bZq = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            if (this.bZp != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno");
                    if (optInt == 0) {
                        if (this.bZq) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.bZp.ec(false);
                                } else {
                                    this.bZp.ec(true);
                                }
                            }
                        } else {
                            this.bZp.ec(true);
                        }
                    } else if (800200 == optInt) {
                        this.bZp.mZ("errNo:" + optInt + ",errMsg:" + jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    } else {
                        this.bZp.mZ("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.bZp.mZ(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.bZp.mZ(exc.getMessage());
            }
        }
    }
}
