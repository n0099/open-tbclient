package com.baidu.swan.facade.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidubce.http.Headers;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String cby = SchemeConfig.getSchemeHead() + "://";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void nf(final String str) {
        HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().setHeader("Swan-Accept", "swan/json").userAgent(com.baidu.swan.apps.aq.a.aea()).url(str).build().executeAsyncOnUIBack(new StringResponseCallback() { // from class: com.baidu.swan.facade.b.a.1
            private Response cbz;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.StringResponseCallback, com.baidu.searchbox.http.callback.ResponseCallback
            public String parseResponse(Response response, int i) throws Exception {
                this.cbz = response;
                return super.parseResponse(response, i);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(String str2, int i) {
                if (a.DEBUG) {
                    Log.d("SwanAppExchanger", "startLaunchAction onSuccess result: " + str2);
                    Log.d("SwanAppExchanger", "startLaunchAction onSuccess status: " + i);
                }
                if (i != 200) {
                    String b = a.b(this.cbz);
                    if (TextUtils.isEmpty(b)) {
                        a.d("get launch scheme fail: request fail with code " + i, str, str2, true);
                        return;
                    } else {
                        b.ni(b);
                        return;
                    }
                }
                try {
                    b.ni(new JSONObject(str2).optString("data"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    a.d("get launch scheme fail: " + e.getMessage(), str, str2, false);
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                a.d("get launch scheme fail: network err with exception: " + exc.getMessage(), str, "", true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, String str2, String str3, boolean z) {
        if (z) {
            d.a(AppRuntime.getAppContext(), "打开失败，请检查网络设置").showToast();
        }
        e.adY().f(new com.baidu.swan.apps.ap.a().aE(1L).aF(12L).mk(str));
        if (DEBUG) {
            Log.w("SwanAppExchanger", "open aiapp fail, url : " + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Response response) {
        if (response == null) {
            return null;
        }
        String header = response.header(Headers.LOCATION);
        if (TextUtils.isEmpty(header) || !header.startsWith("baiduboxapp://")) {
            return null;
        }
        return header.replace("baiduboxapp://", cby);
    }
}
