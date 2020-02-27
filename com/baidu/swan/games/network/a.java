package com.baidu.swan.games.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.runtime.e;
import com.facebook.common.internal.i;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends EventTargetImpl {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final Set<String> beF = i.K("REFERER", "USER-AGENT");
    protected static final Set<String> beR = i.K("localhost", "127.0.0.1");
    public int cqd;
    protected com.baidu.swan.games.binding.model.c cqe;
    private com.baidu.swan.games.e.b cqf;
    protected String mTaskId;

    public a(@NonNull com.baidu.swan.games.e.b bVar, com.baidu.swan.games.binding.model.c cVar) {
        super(bVar);
        this.cqd = 0;
        this.cqf = bVar;
        this.mTaskId = aoO();
        this.cqe = cVar;
    }

    @JavascriptInterface
    public void abort() {
        if (this.cqe != null && e.acD() != null) {
            e.acD().acQ().cancelTag(this.mTaskId);
        }
    }

    public void start() {
    }

    protected HttpUrl fJ(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (com.baidu.swan.apps.runtime.d.acA().acz() == null) {
            if (a(parse)) {
                return parse;
            }
            return null;
        } else if ((DEBUG && com.baidu.swan.apps.ah.a.a.aau()) || a(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String aoN() {
        String optString = this.cqe.optString("url");
        if (this.cqe == null || TextUtils.isEmpty(this.mTaskId)) {
            i("", 0, "request:swanApp is null");
            return null;
        } else if (TextUtils.isEmpty(optString)) {
            i("", -1, "request:url is invalid");
            return null;
        } else if (e.acD() == null) {
            i("", -1, "request:swanApp is null");
            return null;
        } else {
            HttpUrl fJ = fJ(optString);
            if (fJ == null) {
                i(optString, -1, "request:url scheme is invalid");
                return null;
            }
            String url = fJ.url().toString();
            switch (com.baidu.swan.apps.aj.a.b.D("request", url, "")) {
                case 0:
                    return url;
                case 1:
                    i(url, -1, "request:host not in white list");
                    return null;
                case 2:
                    i(url, -1, "request:url header must be https or wss");
                    return null;
                default:
                    i(url, -1, "request:host not in white list");
                    return null;
            }
        }
    }

    protected boolean a(@Nullable HttpUrl httpUrl) {
        return (httpUrl == null || beR.contains(httpUrl.host().toLowerCase())) ? false : true;
    }

    protected String aoO() {
        String acF = e.acF();
        return TextUtils.isEmpty(acF) ? "" : acF + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis();
    }

    public String JR() {
        e acD = e.acD();
        return acD != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", acD.getAppKey(), acD.acX()) : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject a(Headers headers) throws JSONException {
        List<String> values;
        JSONObject jSONObject = new JSONObject();
        if (headers == null) {
            return jSONObject;
        }
        for (String str : headers.names()) {
            if (!TextUtils.isEmpty(str) && (values = headers.values(str)) != null) {
                StringBuilder sb = new StringBuilder();
                int size = values.size();
                for (int i = 0; i < size; i++) {
                    sb.append(values.get(i));
                    if (i == size - 1) {
                        break;
                    }
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                jSONObject.put(str, sb.toString());
            }
        }
        return jSONObject;
    }

    public void j(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar != null && this.cqe != null) {
            this.cqe.put("success", cVar.oF("success"));
            this.cqe.put(LivenessStat.TYPE_FACE_MATCH_FAIL, cVar.oF(LivenessStat.TYPE_FACE_MATCH_FAIL));
            this.cqe.put(com.baidu.mobads.openad.c.b.COMPLETE, cVar.oF(com.baidu.mobads.openad.c.b.COMPLETE));
        }
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(final JSEvent jSEvent) {
        this.cqf.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.super.dispatchEvent(jSEvent);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSuccess(final Object obj) {
        this.cqf.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.utils.b.a(a.this.cqe, true, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(String str, final int i, final String str2) {
        this.cqf.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
                bVar.errMsg = str2;
                bVar.statusCode = i;
                com.baidu.swan.games.utils.b.a(a.this.cqe, false, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map, boolean z) {
        a(builder, cVar, map);
        if (z) {
            builder.header("Referer", JR());
        }
    }

    protected static void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map) {
        if (cVar != null && cVar.length() >= 1) {
            for (String str : cVar.keySet()) {
                if (!TextUtils.isEmpty(str) && !beF.contains(str.toUpperCase())) {
                    String mU = ai.mU(cVar.toString(str));
                    if (!TextUtils.isEmpty(mU)) {
                        if (map != null) {
                            map.put(str.toLowerCase(), mU);
                        }
                        builder.header(str, mU);
                    }
                }
            }
        }
    }
}
