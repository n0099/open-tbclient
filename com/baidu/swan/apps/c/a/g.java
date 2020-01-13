package com.baidu.swan.apps.c.a;

import android.support.v4.app.NotificationCompat;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.swan.apps.adaptation.a.ae;
import com.baidu.swan.apps.as.ag;
import com.baidubce.AbstractBceClient;
import java.io.IOException;
import kotlin.jvm.internal.q;
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
/* loaded from: classes10.dex */
public final class g {
    private static final String TAG;
    public static final g aYf = new g();

    static {
        String simpleName = aYf.getClass().getSimpleName();
        q.i(simpleName, "SwanAppAllianceLoginMaBd…ager.javaClass.simpleName");
        TAG = simpleName;
    }

    private g() {
    }

    public final void Hc() {
        if (e.aYc.GY()) {
            if (f.Hb() == null) {
                f.c(Hf());
            }
            if (e.aYc.isLogin()) {
                String Hd = Hd();
                if (!(Hd == null || l.isBlank(Hd))) {
                    String uid = h.aYh.getUid();
                    if (!(uid == null || l.isBlank(uid))) {
                        Long Hb = f.Hb();
                        if (Hb != null && Hb.longValue() != 0) {
                            OkHttpClient okHttpClient = new OkHttpClient();
                            Request.Builder builder = new Request.Builder();
                            ae Sr = com.baidu.swan.apps.w.a.Sr();
                            q.i(Sr, "SwanAppRuntime.getConfig()");
                            String addParam = ag.addParam("https://ossapi.baidu.com/oss/mabdussrefresh", "host_name", Sr.getHostName());
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("ma_bduss", aYf.Hd());
                            okHttpClient.newCall(builder.url(addParam).post(FormBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build()).enqueue(new a());
                            return;
                        }
                        return;
                    }
                }
                e.aYc.GX();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class a implements Callback {
        a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            q.j(call, NotificationCompat.CATEGORY_CALL);
            q.j(iOException, "e");
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            q.j(call, NotificationCompat.CATEGORY_CALL);
            q.j(response, IIntercepter.TYPE_RESPONSE);
            if (response.code() == 200) {
                ResponseBody body = response.body();
                JSONObject jSONObject = new JSONObject((body == null || (r0 = body.string()) == null) ? "" : "");
                if (jSONObject.optInt("errno") == 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (!q.h(optJSONObject.optString("uk"), h.aYh.getUid())) {
                        e.aYc.GX();
                        return;
                    }
                    h hVar = h.aYh;
                    q.i(optJSONObject, "responseData");
                    hVar.d(0, optJSONObject);
                    com.baidu.swan.apps.c.a.a.ae(com.baidu.swan.apps.w.a.RG(), optJSONObject.optString("ma_bduss"));
                    return;
                }
                e.aYc.GX();
            }
        }
    }

    public final String Hd() {
        return ag.getCookieValue(new com.baidu.swan.apps.j.b().getCookie(".baidu.com"), "MABDUSS");
    }

    public final void He() {
        com.baidu.swan.apps.storage.c.h.adb().putLong("ma_bduss_refresh_time", 0L);
        com.baidu.swan.apps.c.a.a.ae(com.baidu.swan.apps.w.a.RG(), "");
    }

    private final Long Hf() {
        com.baidu.swan.apps.storage.c.b adb = com.baidu.swan.apps.storage.c.h.adb();
        if (adb != null) {
            return Long.valueOf(adb.getLong("ma_bduss_refresh_time", 0L));
        }
        return null;
    }
}
