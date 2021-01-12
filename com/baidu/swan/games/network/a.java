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
    public static final Set<String> cER = i.R("REFERER", "USER-AGENT");
    protected static final Set<String> cFc = i.R("localhost", "127.0.0.1");
    public int egK;
    protected com.baidu.swan.games.binding.model.c egL;
    private com.baidu.swan.games.f.b egM;
    protected String mTaskId;

    public a(@NonNull com.baidu.swan.games.f.b bVar, com.baidu.swan.games.binding.model.c cVar) {
        super(bVar);
        this.egK = 0;
        this.egM = bVar;
        this.mTaskId = aXn();
        this.egL = cVar;
    }

    @JavascriptInterface
    public void abort() {
        if (this.egL != null && e.aIr() != null) {
            e.aIr().aIG().cancelTag(this.mTaskId);
        }
    }

    public void start() {
    }

    protected HttpUrl ky(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (com.baidu.swan.apps.runtime.d.aIn().aIl() == null) {
            if (a(parse)) {
                return parse;
            }
            return null;
        } else if ((DEBUG && com.baidu.swan.apps.ad.a.a.aEK()) || a(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String aXm() {
        String optString = this.egL.optString("url");
        if (this.egL == null || TextUtils.isEmpty(this.mTaskId)) {
            onError("", 0, "request:swanApp is null");
            return null;
        } else if (TextUtils.isEmpty(optString)) {
            onError("", -1, "request:url is invalid");
            return null;
        } else if (e.aIr() == null) {
            onError("", -1, "request:swanApp is null");
            return null;
        } else {
            HttpUrl ky = ky(optString);
            if (ky == null) {
                onError(optString, -1, "request:url scheme is invalid");
                return null;
            }
            String url = ky.url().toString();
            switch (com.baidu.swan.apps.af.a.b.X("request", url, "")) {
                case 0:
                    return url;
                case 1:
                    onError(url, -1, "request:host not in white list");
                    return null;
                case 2:
                    onError(url, -1, "request:url header must be https or wss");
                    return null;
                default:
                    onError(url, -1, "request:host not in white list");
                    return null;
            }
        }
    }

    protected boolean a(@Nullable HttpUrl httpUrl) {
        return (httpUrl == null || cFc.contains(httpUrl.host().toLowerCase())) ? false : true;
    }

    protected String aXn() {
        String aIt = e.aIt();
        return TextUtils.isEmpty(aIt) ? "" : aIt + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis();
    }

    public String ajH() {
        e aIr = e.aIr();
        return aIr != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", aIr.getAppKey(), aIr.aIN()) : "";
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
        if (cVar != null && this.egL != null) {
            this.egL.put("success", cVar.vU("success"));
            this.egL.put(com.baidu.pass.biometrics.face.liveness.c.a.p, cVar.vU(com.baidu.pass.biometrics.face.liveness.c.a.p));
            this.egL.put(com.baidu.mobads.openad.c.b.COMPLETE, cVar.vU(com.baidu.mobads.openad.c.b.COMPLETE));
        }
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(final JSEvent jSEvent) {
        this.egM.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.super.dispatchEvent(jSEvent);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSuccess(final Object obj) {
        this.egM.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.utils.b.a(a.this.egL, true, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onError(String str, final int i, final String str2) {
        this.egM.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
                bVar.errMsg = str2;
                bVar.statusCode = i;
                com.baidu.swan.games.utils.b.a(a.this.egL, false, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map, boolean z) {
        a(builder, cVar, map);
        if (z) {
            builder.header("Referer", ajH());
        }
    }

    protected static void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map) {
        if (cVar != null && cVar.length() >= 1) {
            for (String str : cVar.keySet()) {
                if (!TextUtils.isEmpty(str) && !cER.contains(str.toUpperCase())) {
                    String tO = ak.tO(cVar.toString(str));
                    if (!TextUtils.isEmpty(tO)) {
                        if (map != null) {
                            map.put(str.toLowerCase(), tO);
                        }
                        builder.header(str, tO);
                    }
                }
            }
        }
    }
}
