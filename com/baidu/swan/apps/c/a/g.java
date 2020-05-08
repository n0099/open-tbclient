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
    public static final g bAX = new g();

    static {
        String simpleName = bAX.getClass().getSimpleName();
        q.i(simpleName, "SwanAppAllianceLoginMaBd…ager.javaClass.simpleName");
        TAG = simpleName;
    }

    private g() {
    }

    public final void Rh() {
        if (e.bAU.Rd()) {
            if (f.Rg() == null) {
                f.c(Rk());
            }
            if (e.bAU.isLogin()) {
                String Ri = Ri();
                if (!(Ri == null || l.isBlank(Ri))) {
                    String uid = h.bAZ.getUid();
                    if (!(uid == null || l.isBlank(uid))) {
                        Long Rg = f.Rg();
                        if (Rg != null && Rg.longValue() != 0) {
                            OkHttpClient okHttpClient = new OkHttpClient();
                            Request.Builder builder = new Request.Builder();
                            ae acy = com.baidu.swan.apps.w.a.acy();
                            q.i(acy, "SwanAppRuntime.getConfig()");
                            String addParam = ag.addParam("https://ossapi.baidu.com/oss/mabdussrefresh", "host_name", acy.getHostName());
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("ma_bduss", bAX.Ri());
                            okHttpClient.newCall(builder.url(addParam).post(FormBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build()).enqueue(new a());
                            return;
                        }
                        return;
                    }
                }
                e.bAU.Rc();
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
                    if (!q.k(optJSONObject.optString("uk"), h.bAZ.getUid())) {
                        e.bAU.Rc();
                        return;
                    }
                    h hVar = h.bAZ;
                    q.i(optJSONObject, "responseData");
                    hVar.d(0, optJSONObject);
                    com.baidu.swan.apps.c.a.a.M(com.baidu.swan.apps.w.a.abN(), optJSONObject.optString("ma_bduss"));
                    return;
                }
                e.bAU.Rc();
            }
        }
    }

    public final String Ri() {
        return ag.getCookieValue(new com.baidu.swan.apps.j.b().getCookie(".baidu.com"), "MABDUSS");
    }

    public final void Rj() {
        com.baidu.swan.apps.storage.c.h.any().putLong("ma_bduss_refresh_time", 0L);
        com.baidu.swan.apps.c.a.a.M(com.baidu.swan.apps.w.a.abN(), "");
    }

    private final Long Rk() {
        com.baidu.swan.apps.storage.c.b any = com.baidu.swan.apps.storage.c.h.any();
        if (any != null) {
            return Long.valueOf(any.getLong("ma_bduss_refresh_time", 0L));
        }
        return null;
    }
}
