package com.baidu.swan.apps.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.upload.action.IMTrack;
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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private BearLayout dTi;
    private SwanAppBearInfo dTj;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.dTj = swanAppBearInfo;
        this.dTi = (BearLayout) view.findViewById(i);
        this.dTi.setVisibility(0);
        this.dTi.a(activity, swanAppBearInfo, this);
    }

    public void aSn() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.dTj.bearId);
            linkedHashMap.put("op_type", IMTrack.DbBuilder.ACTION_ADD);
            String ala = com.baidu.swan.apps.t.a.aAD().ala();
            if (!TextUtils.isEmpty(ala)) {
                com.baidu.swan.a.c.a.bfE().getRequest().url(ala).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.t.a.aAQ().alT()).build().executeAsyncOnUIBack(new C0496a(this.dTi.getCallback(), false));
                return;
            }
            return;
        }
        com.baidu.swan.apps.res.widget.b.d.u(this.mActivity, a.h.aiapps_net_error).aLS();
    }

    public void aSo() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.dTj.bearId);
            String akZ = com.baidu.swan.apps.t.a.aAD().akZ();
            if (!TextUtils.isEmpty(akZ)) {
                com.baidu.swan.a.c.a.bfE().getRequest().url(akZ).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.t.a.aAQ().alT()).build().executeAsyncOnUIBack(new C0496a(this.dTi.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0496a extends ResponseCallback<String> {
        private BearLayout.a dTk;
        private boolean dTl;

        C0496a(BearLayout.a aVar, boolean z) {
            this.dTk = aVar;
            this.dTl = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: S */
        public void onSuccess(String str, int i) {
            if (this.dTk != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
                    if (optInt == 0) {
                        if (this.dTl) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.dTk.hC(false);
                                } else {
                                    this.dTk.hC(true);
                                }
                            }
                        } else {
                            this.dTk.hC(true);
                        }
                    } else if (800200 == optInt) {
                        this.dTk.vh("errNo:" + optInt + ",errMsg:" + jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    } else {
                        this.dTk.vh("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.dTk.vh(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.dTk.vh(exc.getMessage());
            }
        }
    }
}
