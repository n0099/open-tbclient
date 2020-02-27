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
@kotlin.h
/* loaded from: classes11.dex */
public final class g {
    private static final String TAG;
    public static final g bcp = new g();

    static {
        String simpleName = bcp.getClass().getSimpleName();
        q.i(simpleName, "SwanAppAllianceLoginMaBd…ager.javaClass.simpleName");
        TAG = simpleName;
    }

    private g() {
    }

    public final void Jr() {
        if (e.bcm.Jn()) {
            if (f.Jq() == null) {
                f.c(Ju());
            }
            if (e.bcm.isLogin()) {
                String Js = Js();
                if (!(Js == null || l.isBlank(Js))) {
                    String uid = h.bcr.getUid();
                    if (!(uid == null || l.isBlank(uid))) {
                        Long Jq = f.Jq();
                        if (Jq != null && Jq.longValue() != 0) {
                            OkHttpClient okHttpClient = new OkHttpClient();
                            Request.Builder builder = new Request.Builder();
                            ae UF = com.baidu.swan.apps.w.a.UF();
                            q.i(UF, "SwanAppRuntime.getConfig()");
                            String addParam = ag.addParam("https://ossapi.baidu.com/oss/mabdussrefresh", "host_name", UF.getHostName());
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("ma_bduss", bcp.Js());
                            okHttpClient.newCall(builder.url(addParam).post(FormBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build()).enqueue(new a());
                            return;
                        }
                        return;
                    }
                }
                e.bcm.Jm();
            }
        }
    }

    @kotlin.h
    /* loaded from: classes11.dex */
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
                    if (!q.h(optJSONObject.optString("uk"), h.bcr.getUid())) {
                        e.bcm.Jm();
                        return;
                    }
                    h hVar = h.bcr;
                    q.i(optJSONObject, "responseData");
                    hVar.d(0, optJSONObject);
                    com.baidu.swan.apps.c.a.a.ae(com.baidu.swan.apps.w.a.TU(), optJSONObject.optString("ma_bduss"));
                    return;
                }
                e.bcm.Jm();
            }
        }
    }

    public final String Js() {
        return ag.getCookieValue(new com.baidu.swan.apps.j.b().getCookie(".baidu.com"), "MABDUSS");
    }

    public final void Jt() {
        com.baidu.swan.apps.storage.c.h.afp().putLong("ma_bduss_refresh_time", 0L);
        com.baidu.swan.apps.c.a.a.ae(com.baidu.swan.apps.w.a.TU(), "");
    }

    private final Long Ju() {
        com.baidu.swan.apps.storage.c.b afp = com.baidu.swan.apps.storage.c.h.afp();
        if (afp != null) {
            return Long.valueOf(afp.getLong("ma_bduss_refresh_time", 0L));
        }
        return null;
    }
}
