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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private BearLayout dSd;
    private SwanAppBearInfo dSe;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.dSe = swanAppBearInfo;
        this.dSd = (BearLayout) view.findViewById(i);
        this.dSd.setVisibility(0);
        this.dSd.a(activity, swanAppBearInfo, this);
    }

    public void aOQ() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.dSe.bearId);
            linkedHashMap.put("op_type", IMTrack.DbBuilder.ACTION_ADD);
            String ahI = com.baidu.swan.apps.t.a.axl().ahI();
            if (!TextUtils.isEmpty(ahI)) {
                com.baidu.swan.a.c.a.bca().getRequest().url(ahI).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.t.a.axy().aiB()).build().executeAsyncOnUIBack(new C0482a(this.dSd.getCallback(), false));
                return;
            }
            return;
        }
        com.baidu.swan.apps.res.widget.b.d.u(this.mActivity, a.h.aiapps_net_error).aIv();
    }

    public void aOR() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.dSe.bearId);
            String ahH = com.baidu.swan.apps.t.a.axl().ahH();
            if (!TextUtils.isEmpty(ahH)) {
                com.baidu.swan.a.c.a.bca().getRequest().url(ahH).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.t.a.axy().aiB()).build().executeAsyncOnUIBack(new C0482a(this.dSd.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0482a extends ResponseCallback<String> {
        private BearLayout.a dSf;
        private boolean dSg;

        C0482a(BearLayout.a aVar, boolean z) {
            this.dSf = aVar;
            this.dSg = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: V */
        public void onSuccess(String str, int i) {
            if (this.dSf != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
                    if (optInt == 0) {
                        if (this.dSg) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.dSf.hA(false);
                                } else {
                                    this.dSf.hA(true);
                                }
                            }
                        } else {
                            this.dSf.hA(true);
                        }
                    } else if (800200 == optInt) {
                        this.dSf.uw("errNo:" + optInt + ",errMsg:" + jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    } else {
                        this.dSf.uw("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.dSf.uw(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.dSf.uw(exc.getMessage());
            }
        }
    }
}
