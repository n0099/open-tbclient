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
    private BearLayout btD;
    private SwanAppBearInfo btE;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.btE = swanAppBearInfo;
        this.btD = (BearLayout) view.findViewById(i);
        this.btD.setVisibility(0);
        this.btD.a(activity, swanAppBearInfo, this);
    }

    public void UL() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.btE.aXe);
            linkedHashMap.put("op_type", IMTrack.DbBuilder.ACTION_ADD);
            String Cf = com.baidu.swan.apps.u.a.Jv().Cf();
            if (!TextUtils.isEmpty(Cf)) {
                HttpManager.getDefault(com.baidu.swan.apps.u.a.Jj()).getRequest().url(Cf).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.u.a.JG().Ke()).build().executeAsyncOnUIBack(new C0225a(this.btD.getCallback(), false));
                return;
            }
            return;
        }
        d.i(this.mActivity, a.h.aiapps_net_error).QO();
    }

    public void UM() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.btE.aXe);
            String Ce = com.baidu.swan.apps.u.a.Jv().Ce();
            if (!TextUtils.isEmpty(Ce)) {
                HttpManager.getDefault(com.baidu.swan.apps.u.a.Jj()).getRequest().url(Ce).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.u.a.JG().Ke()).build().executeAsyncOnUIBack(new C0225a(this.btD.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0225a extends ResponseCallback<String> {
        private BearLayout.a btF;
        private boolean btG;

        C0225a(BearLayout.a aVar, boolean z) {
            this.btF = aVar;
            this.btG = z;
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
            if (this.btF != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno");
                    if (optInt == 0) {
                        if (this.btG) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray(DpStatConstants.KEY_ITEMS);
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.btF.cW(false);
                                } else {
                                    this.btF.cW(true);
                                }
                            }
                        } else {
                            this.btF.cW(true);
                        }
                    } else if (800200 == optInt) {
                        this.btF.jh("errNo:" + optInt + ",errMsg:" + jSONObject.optString("errmsg"));
                    } else {
                        this.btF.jh("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.btF.jh(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.btF.jh(exc.getMessage());
            }
        }
    }
}
