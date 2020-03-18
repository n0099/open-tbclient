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
    public static final g bcE = new g();

    static {
        String simpleName = bcE.getClass().getSimpleName();
        q.i(simpleName, "SwanAppAllianceLoginMaBd…ager.javaClass.simpleName");
        TAG = simpleName;
    }

    private g() {
    }

    public final void Jw() {
        if (e.bcB.Js()) {
            if (f.Jv() == null) {
                f.c(Jz());
            }
            if (e.bcB.isLogin()) {
                String Jx = Jx();
                if (!(Jx == null || l.isBlank(Jx))) {
                    String uid = h.bcG.getUid();
                    if (!(uid == null || l.isBlank(uid))) {
                        Long Jv = f.Jv();
                        if (Jv != null && Jv.longValue() != 0) {
                            OkHttpClient okHttpClient = new OkHttpClient();
                            Request.Builder builder = new Request.Builder();
                            ae UK = com.baidu.swan.apps.w.a.UK();
                            q.i(UK, "SwanAppRuntime.getConfig()");
                            String addParam = ag.addParam("https://ossapi.baidu.com/oss/mabdussrefresh", "host_name", UK.getHostName());
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("ma_bduss", bcE.Jx());
                            okHttpClient.newCall(builder.url(addParam).post(FormBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build()).enqueue(new a());
                            return;
                        }
                        return;
                    }
                }
                e.bcB.Jr();
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
                    if (!q.h(optJSONObject.optString("uk"), h.bcG.getUid())) {
                        e.bcB.Jr();
                        return;
                    }
                    h hVar = h.bcG;
                    q.i(optJSONObject, "responseData");
                    hVar.d(0, optJSONObject);
                    com.baidu.swan.apps.c.a.a.ae(com.baidu.swan.apps.w.a.TZ(), optJSONObject.optString("ma_bduss"));
                    return;
                }
                e.bcB.Jr();
            }
        }
    }

    public final String Jx() {
        return ag.getCookieValue(new com.baidu.swan.apps.j.b().getCookie(".baidu.com"), "MABDUSS");
    }

    public final void Jy() {
        com.baidu.swan.apps.storage.c.h.afu().putLong("ma_bduss_refresh_time", 0L);
        com.baidu.swan.apps.c.a.a.ae(com.baidu.swan.apps.w.a.TZ(), "");
    }

    private final Long Jz() {
        com.baidu.swan.apps.storage.c.b afu = com.baidu.swan.apps.storage.c.h.afu();
        if (afu != null) {
            return Long.valueOf(afu.getLong("ma_bduss_refresh_time", 0L));
        }
        return null;
    }
}
