package com.baidu.swan.games.network;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.ao.ak;
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
/* loaded from: classes8.dex */
public class a extends EventTargetImpl {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final Set<String> cIN = i.Q("REFERER", "USER-AGENT");
    protected static final Set<String> cIX = i.Q("localhost", "127.0.0.1");
    public int eks;
    protected com.baidu.swan.games.binding.model.c ekt;
    private com.baidu.swan.games.f.b eku;
    protected String mTaskId;

    public a(@NonNull com.baidu.swan.games.f.b bVar, com.baidu.swan.games.binding.model.c cVar) {
        super(bVar);
        this.eks = 0;
        this.eku = bVar;
        this.mTaskId = aXC();
        this.ekt = cVar;
    }

    @JavascriptInterface
    public void abort() {
        if (this.ekt != null && e.aIN() != null) {
            e.aIN().aJc().cancelTag(this.mTaskId);
        }
    }

    public void start() {
    }

    protected HttpUrl kX(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (com.baidu.swan.apps.runtime.d.aIJ().aIH() == null) {
            if (a(parse)) {
                return parse;
            }
            return null;
        } else if ((DEBUG && com.baidu.swan.apps.ad.a.a.aFi()) || a(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String aXB() {
        String optString = this.ekt.optString("url");
        if (this.ekt == null || TextUtils.isEmpty(this.mTaskId)) {
            l("", 0, "request:swanApp is null");
            return null;
        } else if (TextUtils.isEmpty(optString)) {
            l("", -1, "request:url is invalid");
            return null;
        } else if (e.aIN() == null) {
            l("", -1, "request:swanApp is null");
            return null;
        } else {
            HttpUrl kX = kX(optString);
            if (kX == null) {
                l(optString, -1, "request:url scheme is invalid");
                return null;
            }
            String url = kX.url().toString();
            switch (com.baidu.swan.apps.af.a.b.Y("request", url, "")) {
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
        return (httpUrl == null || cIX.contains(httpUrl.host().toLowerCase())) ? false : true;
    }

    protected String aXC() {
        String aIP = e.aIP();
        return TextUtils.isEmpty(aIP) ? "" : aIP + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis();
    }

    public String aki() {
        e aIN = e.aIN();
        return aIN != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", aIN.getAppKey(), aIN.aJj()) : "";
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
        if (cVar != null && this.ekt != null) {
            this.ekt.put("success", cVar.wu("success"));
            this.ekt.put(com.baidu.pass.biometrics.face.liveness.c.a.p, cVar.wu(com.baidu.pass.biometrics.face.liveness.c.a.p));
            this.ekt.put("complete", cVar.wu("complete"));
        }
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(final JSEvent jSEvent) {
        this.eku.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.super.dispatchEvent(jSEvent);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSuccess(final Object obj) {
        this.eku.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.utils.b.a(a.this.ekt, true, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(String str, final int i, final String str2) {
        this.eku.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
                bVar.errMsg = str2;
                bVar.statusCode = i;
                com.baidu.swan.games.utils.b.a(a.this.ekt, false, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map, boolean z) {
        a(builder, cVar, map);
        if (z) {
            builder.header("Referer", aki());
        }
    }

    protected static void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map) {
        if (cVar != null && cVar.length() >= 1) {
            for (String str : cVar.keySet()) {
                if (!TextUtils.isEmpty(str) && !cIN.contains(str.toUpperCase())) {
                    String uo = ak.uo(cVar.toString(str));
                    if (!TextUtils.isEmpty(uo)) {
                        if (map != null) {
                            map.put(str.toLowerCase(), uo);
                        }
                        builder.header(str, uo);
                    }
                }
            }
        }
    }
}
