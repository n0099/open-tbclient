package com.baidu.swan.apps.view;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
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
    private BearLayout bbv;
    private SwanAppBearInfo bbw;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.bbw = swanAppBearInfo;
        this.bbv = (BearLayout) view.findViewById(i);
        this.bbv.setVisibility(0);
        this.bbv.a(activity, swanAppBearInfo, this);
    }

    public void PX() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.bbw.aEh);
            linkedHashMap.put("op_type", "add");
            String xk = com.baidu.swan.apps.u.a.EA().xk();
            if (!TextUtils.isEmpty(xk)) {
                HttpManager.getDefault(com.baidu.swan.apps.u.a.Eo()).getRequest().url(xk).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.u.a.EL().Fj()).build().executeAsyncOnUIBack(new C0198a(this.bbv.getCallback(), false));
                return;
            }
            return;
        }
        d.k(this.mActivity, a.h.aiapps_net_error).LU();
    }

    public void PY() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.bbw.aEh);
            String xj = com.baidu.swan.apps.u.a.EA().xj();
            if (!TextUtils.isEmpty(xj)) {
                HttpManager.getDefault(com.baidu.swan.apps.u.a.Eo()).getRequest().url(xj).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.u.a.EL().Fj()).build().executeAsyncOnUIBack(new C0198a(this.bbv.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0198a extends ResponseCallback<String> {
        private BearLayout.a bbx;
        private boolean bby;

        C0198a(BearLayout.a aVar, boolean z) {
            this.bbx = aVar;
            this.bby = z;
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
            if (this.bbx != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno");
                    if (optInt == 0) {
                        if (this.bby) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray(DpStatConstants.KEY_ITEMS);
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.bbx.cF(false);
                                } else {
                                    this.bbx.cF(true);
                                }
                            }
                        } else {
                            this.bbx.cF(true);
                        }
                    } else if (800200 == optInt) {
                        this.bbx.iE("errNo:" + optInt + ",errMsg:" + jSONObject.optString("errmsg"));
                    } else {
                        this.bbx.iE("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.bbx.iE(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.bbx.iE(exc.getMessage());
            }
        }
    }
}
