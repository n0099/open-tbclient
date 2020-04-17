package com.baidu.swan.apps.c.a;

import android.support.v4.app.NotificationCompat;
import com.baidu.android.util.io.BaseJsonData;
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
    public static final g bAS = new g();

    static {
        String simpleName = bAS.getClass().getSimpleName();
        q.i(simpleName, "SwanAppAllianceLoginMaBd…ager.javaClass.simpleName");
        TAG = simpleName;
    }

    private g() {
    }

    public final void Ri() {
        if (e.bAP.Re()) {
            if (f.Rh() == null) {
                f.c(Rl());
            }
            if (e.bAP.isLogin()) {
                String Rj = Rj();
                if (!(Rj == null || l.isBlank(Rj))) {
                    String uid = h.bAU.getUid();
                    if (!(uid == null || l.isBlank(uid))) {
                        Long Rh = f.Rh();
                        if (Rh != null && Rh.longValue() != 0) {
                            OkHttpClient okHttpClient = new OkHttpClient();
                            Request.Builder builder = new Request.Builder();
                            ae acz = com.baidu.swan.apps.w.a.acz();
                            q.i(acz, "SwanAppRuntime.getConfig()");
                            String addParam = ag.addParam("https://ossapi.baidu.com/oss/mabdussrefresh", "host_name", acz.getHostName());
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("ma_bduss", bAS.Rj());
                            okHttpClient.newCall(builder.url(addParam).post(FormBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build()).enqueue(new a());
                            return;
                        }
                        return;
                    }
                }
                e.bAP.Rd();
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
                if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) == 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (!q.k(optJSONObject.optString("uk"), h.bAU.getUid())) {
                        e.bAP.Rd();
                        return;
                    }
                    h hVar = h.bAU;
                    q.i(optJSONObject, "responseData");
                    hVar.d(0, optJSONObject);
                    com.baidu.swan.apps.c.a.a.Y(com.baidu.swan.apps.w.a.abO(), optJSONObject.optString("ma_bduss"));
                    return;
                }
                e.bAP.Rd();
            }
        }
    }

    public final String Rj() {
        return ag.getCookieValue(new com.baidu.swan.apps.j.b().getCookie(".baidu.com"), "MABDUSS");
    }

    public final void Rk() {
        com.baidu.swan.apps.storage.c.h.anz().putLong("ma_bduss_refresh_time", 0L);
        com.baidu.swan.apps.c.a.a.Y(com.baidu.swan.apps.w.a.abO(), "");
    }

    private final Long Rl() {
        com.baidu.swan.apps.storage.c.b anz = com.baidu.swan.apps.storage.c.h.anz();
        if (anz != null) {
            return Long.valueOf(anz.getLong("ma_bduss_refresh_time", 0L));
        }
        return null;
    }
}
