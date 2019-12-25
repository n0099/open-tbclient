package com.baidu.swan.apps.c.a;

import android.support.v4.app.NotificationCompat;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.swan.apps.adaptation.a.ae;
import com.baidu.swan.apps.as.ag;
import com.baidubce.AbstractBceClient;
import java.io.IOException;
import kotlin.jvm.internal.p;
import kotlin.text.l;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class g {
    private static final String TAG;
    public static final g aXn = new g();

    static {
        String simpleName = aXn.getClass().getSimpleName();
        p.i(simpleName, "SwanAppAllianceLoginMaBd…ager.javaClass.simpleName");
        TAG = simpleName;
    }

    private g() {
    }

    public final void GG() {
        if (e.aXk.GC()) {
            if (f.GF() == null) {
                f.c(GJ());
            }
            if (e.aXk.isLogin()) {
                String GH = GH();
                if (!(GH == null || l.isBlank(GH))) {
                    String uid = h.aXp.getUid();
                    if (!(uid == null || l.isBlank(uid))) {
                        Long GF = f.GF();
                        if (GF != null && GF.longValue() != 0) {
                            OkHttpClient okHttpClient = new OkHttpClient();
                            Request.Builder builder = new Request.Builder();
                            ae RV = com.baidu.swan.apps.w.a.RV();
                            p.i(RV, "SwanAppRuntime.getConfig()");
                            String addParam = ag.addParam("https://ossapi.baidu.com/oss/mabdussrefresh", "host_name", RV.getHostName());
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("ma_bduss", aXn.GH());
                            okHttpClient.newCall(builder.url(addParam).post(FormBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build()).enqueue(new a());
                            return;
                        }
                        return;
                    }
                }
                e.aXk.GB();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class a implements Callback {
        a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            p.j(call, NotificationCompat.CATEGORY_CALL);
            p.j(iOException, "e");
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            p.j(call, NotificationCompat.CATEGORY_CALL);
            p.j(response, IIntercepter.TYPE_RESPONSE);
            if (response.code() == 200) {
                ResponseBody body = response.body();
                JSONObject jSONObject = new JSONObject((body == null || (r0 = body.string()) == null) ? "" : "");
                if (jSONObject.optInt("errno") == 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (!p.h(optJSONObject.optString("uk"), h.aXp.getUid())) {
                        e.aXk.GB();
                        return;
                    }
                    h hVar = h.aXp;
                    p.i(optJSONObject, "responseData");
                    hVar.d(0, optJSONObject);
                    com.baidu.swan.apps.c.a.a.ac(com.baidu.swan.apps.w.a.Rk(), optJSONObject.optString("ma_bduss"));
                    return;
                }
                e.aXk.GB();
            }
        }
    }

    public final String GH() {
        return ag.getCookieValue(new com.baidu.swan.apps.j.b().getCookie(".baidu.com"), "MABDUSS");
    }

    public final void GI() {
        com.baidu.swan.apps.storage.c.h.acE().putLong("ma_bduss_refresh_time", 0L);
        com.baidu.swan.apps.c.a.a.ac(com.baidu.swan.apps.w.a.Rk(), "");
    }

    private final Long GJ() {
        com.baidu.swan.apps.storage.c.b acE = com.baidu.swan.apps.storage.c.h.acE();
        if (acE != null) {
            return Long.valueOf(acE.getLong("ma_bduss_refresh_time", 0L));
        }
        return null;
    }
}
