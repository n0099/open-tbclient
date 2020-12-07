package com.baidu.swan.games.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.runtime.e;
import com.facebook.common.internal.i;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a extends EventTargetImpl {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final Set<String> cEN = i.N("REFERER", "USER-AGENT");
    protected static final Set<String> cEY = i.N("localhost", "127.0.0.1");
    protected com.baidu.swan.games.binding.model.c ecA;
    private com.baidu.swan.games.f.b ecB;
    public int ecz;
    protected String mTaskId;

    public a(@NonNull com.baidu.swan.games.f.b bVar, com.baidu.swan.games.binding.model.c cVar) {
        super(bVar);
        this.ecz = 0;
        this.ecB = bVar;
        this.mTaskId = aYM();
        this.ecA = cVar;
    }

    @JavascriptInterface
    public void abort() {
        if (this.ecA != null && e.aJU() != null) {
            e.aJU().aKj().cancelTag(this.mTaskId);
        }
    }

    public void start() {
    }

    protected HttpUrl lQ(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (com.baidu.swan.apps.runtime.d.aJQ().aJO() == null) {
            if (a(parse)) {
                return parse;
            }
            return null;
        } else if ((DEBUG && com.baidu.swan.apps.ad.a.a.aHk()) || a(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String aYL() {
        String optString = this.ecA.optString("url");
        if (this.ecA == null || TextUtils.isEmpty(this.mTaskId)) {
            l("", 0, "request:swanApp is null");
            return null;
        } else if (TextUtils.isEmpty(optString)) {
            l("", -1, "request:url is invalid");
            return null;
        } else if (e.aJU() == null) {
            l("", -1, "request:swanApp is null");
            return null;
        } else {
            HttpUrl lQ = lQ(optString);
            if (lQ == null) {
                l(optString, -1, "request:url scheme is invalid");
                return null;
            }
            String url = lQ.url().toString();
            switch (com.baidu.swan.apps.ag.a.b.V("request", url, "")) {
                case 0:
                    return url;
                case 1:
                    l(url, -1, "request:host not in white list");
                    return null;
                case 2:
                    l(url, -1, "request:url header must be https or wss");
                    return null;
                default:
                    l(url, -1, "request:host not in white list");
                    return null;
            }
        }
    }

    protected boolean a(@Nullable HttpUrl httpUrl) {
        return (httpUrl == null || cEY.contains(httpUrl.host().toLowerCase())) ? false : true;
    }

    protected String aYM() {
        String aJW = e.aJW();
        return TextUtils.isEmpty(aJW) ? "" : aJW + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis();
    }

    public String amq() {
        e aJU = e.aJU();
        return aJU != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", aJU.getAppKey(), aJU.aKq()) : "";
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
                    sb.append(",");
                }
                jSONObject.put(str, sb.toString());
            }
        }
        return jSONObject;
    }

    public void j(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar != null && this.ecA != null) {
            this.ecA.put("success", cVar.xg("success"));
            this.ecA.put("fail", cVar.xg("fail"));
            this.ecA.put(com.baidu.mobads.openad.c.b.COMPLETE, cVar.xg(com.baidu.mobads.openad.c.b.COMPLETE));
        }
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(final JSEvent jSEvent) {
        this.ecB.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.super.dispatchEvent(jSEvent);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSuccess(final Object obj) {
        this.ecB.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.utils.b.a(a.this.ecA, true, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(String str, final int i, final String str2) {
        this.ecB.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
                bVar.errMsg = str2;
                bVar.statusCode = i;
                com.baidu.swan.games.utils.b.a(a.this.ecA, false, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map, boolean z) {
        a(builder, cVar, map);
        if (z) {
            builder.header("Referer", amq());
        }
    }

    protected static void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map) {
        if (cVar != null && cVar.length() >= 1) {
            for (String str : cVar.keySet()) {
                if (!TextUtils.isEmpty(str) && !cEN.contains(str.toUpperCase())) {
                    String va = ak.va(cVar.toString(str));
                    if (!TextUtils.isEmpty(va)) {
                        if (map != null) {
                            map.put(str.toLowerCase(), va);
                        }
                        builder.header(str, va);
                    }
                }
            }
        }
    }
}
