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
/* loaded from: classes9.dex */
public class a extends EventTargetImpl {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final Set<String> cJD = i.R("REFERER", "USER-AGENT");
    protected static final Set<String> cJO = i.R("localhost", "127.0.0.1");
    public int elw;
    protected com.baidu.swan.games.binding.model.c elx;
    private com.baidu.swan.games.f.b ely;
    protected String mTaskId;

    public a(@NonNull com.baidu.swan.games.f.b bVar, com.baidu.swan.games.binding.model.c cVar) {
        super(bVar);
        this.elw = 0;
        this.ely = bVar;
        this.mTaskId = bbh();
        this.elx = cVar;
    }

    @JavascriptInterface
    public void abort() {
        if (this.elx != null && e.aMl() != null) {
            e.aMl().aMA().cancelTag(this.mTaskId);
        }
    }

    public void start() {
    }

    protected HttpUrl lJ(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (com.baidu.swan.apps.runtime.d.aMh().aMf() == null) {
            if (a(parse)) {
                return parse;
            }
            return null;
        } else if ((DEBUG && com.baidu.swan.apps.ad.a.a.aIE()) || a(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String bbg() {
        String optString = this.elx.optString("url");
        if (this.elx == null || TextUtils.isEmpty(this.mTaskId)) {
            onError("", 0, "request:swanApp is null");
            return null;
        } else if (TextUtils.isEmpty(optString)) {
            onError("", -1, "request:url is invalid");
            return null;
        } else if (e.aMl() == null) {
            onError("", -1, "request:swanApp is null");
            return null;
        } else {
            HttpUrl lJ = lJ(optString);
            if (lJ == null) {
                onError(optString, -1, "request:url scheme is invalid");
                return null;
            }
            String url = lJ.url().toString();
            switch (com.baidu.swan.apps.af.a.b.Y("request", url, "")) {
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
        return (httpUrl == null || cJO.contains(httpUrl.host().toLowerCase())) ? false : true;
    }

    protected String bbh() {
        String aMn = e.aMn();
        return TextUtils.isEmpty(aMn) ? "" : aMn + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis();
    }

    public String anB() {
        e aMl = e.aMl();
        return aMl != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", aMl.getAppKey(), aMl.aMH()) : "";
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
        if (cVar != null && this.elx != null) {
            this.elx.put("success", cVar.xf("success"));
            this.elx.put(com.baidu.pass.biometrics.face.liveness.c.a.p, cVar.xf(com.baidu.pass.biometrics.face.liveness.c.a.p));
            this.elx.put(com.baidu.mobads.openad.c.b.COMPLETE, cVar.xf(com.baidu.mobads.openad.c.b.COMPLETE));
        }
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(final JSEvent jSEvent) {
        this.ely.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.super.dispatchEvent(jSEvent);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSuccess(final Object obj) {
        this.ely.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.utils.b.a(a.this.elx, true, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onError(String str, final int i, final String str2) {
        this.ely.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
                bVar.errMsg = str2;
                bVar.statusCode = i;
                com.baidu.swan.games.utils.b.a(a.this.elx, false, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map, boolean z) {
        a(builder, cVar, map);
        if (z) {
            builder.header("Referer", anB());
        }
    }

    protected static void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map) {
        if (cVar != null && cVar.length() >= 1) {
            for (String str : cVar.keySet()) {
                if (!TextUtils.isEmpty(str) && !cJD.contains(str.toUpperCase())) {
                    String uZ = ak.uZ(cVar.toString(str));
                    if (!TextUtils.isEmpty(uZ)) {
                        if (map != null) {
                            map.put(str.toLowerCase(), uZ);
                        }
                        builder.header(str, uZ);
                    }
                }
            }
        }
    }
}
