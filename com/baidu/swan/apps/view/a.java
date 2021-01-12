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
    private BearLayout dOw;
    private SwanAppBearInfo dOx;
    private Activity mActivity;

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.mActivity = activity;
        this.dOx = swanAppBearInfo;
        this.dOw = (BearLayout) view.findViewById(i);
        this.dOw.setVisibility(0);
        this.dOw.a(activity, swanAppBearInfo, this);
    }

    public void aOu() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.dOx.bearId);
            linkedHashMap.put("op_type", IMTrack.DbBuilder.ACTION_ADD);
            String ahh = com.baidu.swan.apps.t.a.awK().ahh();
            if (!TextUtils.isEmpty(ahh)) {
                com.baidu.swan.a.c.a.bbL().getRequest().url(ahh).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.t.a.awX().aia()).build().executeAsyncOnUIBack(new C0479a(this.dOw.getCallback(), false));
                return;
            }
            return;
        }
        com.baidu.swan.apps.res.widget.b.d.u(this.mActivity, a.h.aiapps_net_error).aHZ();
    }

    public void aOv() {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mActivity)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", "media");
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.dOx.bearId);
            String ahg = com.baidu.swan.apps.t.a.awK().ahg();
            if (!TextUtils.isEmpty(ahg)) {
                com.baidu.swan.a.c.a.bbL().getRequest().url(ahg).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(com.baidu.swan.apps.t.a.awX().aia()).build().executeAsyncOnUIBack(new C0479a(this.dOw.getCallback(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0479a extends ResponseCallback<String> {
        private BearLayout.a dOy;
        private boolean dOz;

        C0479a(BearLayout.a aVar, boolean z) {
            this.dOy = aVar;
            this.dOz = z;
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
            if (this.dOy != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
                    if (optInt == 0) {
                        if (this.dOz) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    this.dOy.hy(false);
                                } else {
                                    this.dOy.hy(true);
                                }
                            }
                        } else {
                            this.dOy.hy(true);
                        }
                    } else if (800200 == optInt) {
                        this.dOy.tW("errNo:" + optInt + ",errMsg:" + jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    } else {
                        this.dOy.tW("errNo:" + optInt);
                    }
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        this.dOy.tW(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.DEBUG) {
                exc.printStackTrace();
                this.dOy.tW(exc.getMessage());
            }
        }
    }
}
