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
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends EventTargetImpl {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final Set<String> clh = i.N("REFERER", "USER-AGENT");
    protected static final Set<String> cls = i.N("localhost", "127.0.0.1");
    protected com.baidu.swan.games.binding.model.c dIU;
    private com.baidu.swan.games.f.b dIV;
    protected String mTaskId;
    public int requestType;

    public a(@NonNull com.baidu.swan.games.f.b bVar, com.baidu.swan.games.binding.model.c cVar) {
        super(bVar);
        this.requestType = 0;
        this.dIV = bVar;
        this.mTaskId = aRV();
        this.dIU = cVar;
    }

    @JavascriptInterface
    public void abort() {
        if (this.dIU != null && e.aDa() != null) {
            e.aDa().aDp().cancelTag(this.mTaskId);
        }
    }

    public void start() {
    }

    protected HttpUrl kH(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (com.baidu.swan.apps.runtime.d.aCW().aCU() == null) {
            if (a(parse)) {
                return parse;
            }
            return null;
        } else if ((DEBUG && com.baidu.swan.apps.ad.a.a.aAq()) || a(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String aRU() {
        String optString = this.dIU.optString("url");
        if (this.dIU == null || TextUtils.isEmpty(this.mTaskId)) {
            k("", 0, "request:swanApp is null");
            return null;
        } else if (TextUtils.isEmpty(optString)) {
            k("", -1, "request:url is invalid");
            return null;
        } else if (e.aDa() == null) {
            k("", -1, "request:swanApp is null");
            return null;
        } else {
            HttpUrl kH = kH(optString);
            if (kH == null) {
                k(optString, -1, "request:url scheme is invalid");
                return null;
            }
            String url = kH.url().toString();
            switch (com.baidu.swan.apps.ag.a.b.L("request", url, "")) {
                case 0:
                    return url;
                case 1:
                    k(url, -1, "request:host not in white list");
                    return null;
                case 2:
                    k(url, -1, "request:url header must be https or wss");
                    return null;
                default:
                    k(url, -1, "request:host not in white list");
                    return null;
            }
        }
    }

    protected boolean a(@Nullable HttpUrl httpUrl) {
        return (httpUrl == null || cls.contains(httpUrl.host().toLowerCase())) ? false : true;
    }

    protected String aRV() {
        String aDc = e.aDc();
        return TextUtils.isEmpty(aDc) ? "" : aDc + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis();
    }

    public String afw() {
        e aDa = e.aDa();
        return aDa != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", aDa.getAppKey(), aDa.aDw()) : "";
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
        if (cVar != null && this.dIU != null) {
            this.dIU.put("success", cVar.vX("success"));
            this.dIU.put("fail", cVar.vX("fail"));
            this.dIU.put(com.baidu.mobads.openad.c.b.COMPLETE, cVar.vX(com.baidu.mobads.openad.c.b.COMPLETE));
        }
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(final JSEvent jSEvent) {
        this.dIV.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.super.dispatchEvent(jSEvent);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSuccess(final Object obj) {
        this.dIV.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.utils.b.a(a.this.dIU, true, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(String str, final int i, final String str2) {
        this.dIV.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
                bVar.errMsg = str2;
                bVar.statusCode = i;
                com.baidu.swan.games.utils.b.a(a.this.dIU, false, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map, boolean z) {
        a(builder, cVar, map);
        if (z) {
            builder.header("Referer", afw());
        }
    }

    protected static void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map) {
        if (cVar != null && cVar.length() >= 1) {
            for (String str : cVar.keySet()) {
                if (!TextUtils.isEmpty(str) && !clh.contains(str.toUpperCase())) {
                    String tR = ak.tR(cVar.toString(str));
                    if (!TextUtils.isEmpty(tR)) {
                        if (map != null) {
                            map.put(str.toLowerCase(), tR);
                        }
                        builder.header(str, tR);
                    }
                }
            }
        }
    }
}
