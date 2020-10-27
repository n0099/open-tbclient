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
    public static final Set<String> ctK = i.N("REFERER", "USER-AGENT");
    protected static final Set<String> ctV = i.N("localhost", "127.0.0.1");
    protected com.baidu.swan.games.binding.model.c dRr;
    private com.baidu.swan.games.f.b dRs;
    protected String mTaskId;
    public int requestType;

    public a(@NonNull com.baidu.swan.games.f.b bVar, com.baidu.swan.games.binding.model.c cVar) {
        super(bVar);
        this.requestType = 0;
        this.dRs = bVar;
        this.mTaskId = aTP();
        this.dRr = cVar;
    }

    @JavascriptInterface
    public void abort() {
        if (this.dRr != null && e.aEU() != null) {
            e.aEU().aFj().cancelTag(this.mTaskId);
        }
    }

    public void start() {
    }

    protected HttpUrl la(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (com.baidu.swan.apps.runtime.d.aEQ().aEO() == null) {
            if (a(parse)) {
                return parse;
            }
            return null;
        } else if ((DEBUG && com.baidu.swan.apps.ad.a.a.aCk()) || a(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String aTO() {
        String optString = this.dRr.optString("url");
        if (this.dRr == null || TextUtils.isEmpty(this.mTaskId)) {
            k("", 0, "request:swanApp is null");
            return null;
        } else if (TextUtils.isEmpty(optString)) {
            k("", -1, "request:url is invalid");
            return null;
        } else if (e.aEU() == null) {
            k("", -1, "request:swanApp is null");
            return null;
        } else {
            HttpUrl la = la(optString);
            if (la == null) {
                k(optString, -1, "request:url scheme is invalid");
                return null;
            }
            String url = la.url().toString();
            switch (com.baidu.swan.apps.ag.a.b.S("request", url, "")) {
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
        return (httpUrl == null || ctV.contains(httpUrl.host().toLowerCase())) ? false : true;
    }

    protected String aTP() {
        String aEW = e.aEW();
        return TextUtils.isEmpty(aEW) ? "" : aEW + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis();
    }

    public String ahq() {
        e aEU = e.aEU();
        return aEU != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", aEU.getAppKey(), aEU.aFq()) : "";
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
        if (cVar != null && this.dRr != null) {
            this.dRr.put("success", cVar.wq("success"));
            this.dRr.put("fail", cVar.wq("fail"));
            this.dRr.put(com.baidu.mobads.openad.c.b.COMPLETE, cVar.wq(com.baidu.mobads.openad.c.b.COMPLETE));
        }
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(final JSEvent jSEvent) {
        this.dRs.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.super.dispatchEvent(jSEvent);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSuccess(final Object obj) {
        this.dRs.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.utils.b.a(a.this.dRr, true, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(String str, final int i, final String str2) {
        this.dRs.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
                bVar.errMsg = str2;
                bVar.statusCode = i;
                com.baidu.swan.games.utils.b.a(a.this.dRr, false, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map, boolean z) {
        a(builder, cVar, map);
        if (z) {
            builder.header("Referer", ahq());
        }
    }

    protected static void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map) {
        if (cVar != null && cVar.length() >= 1) {
            for (String str : cVar.keySet()) {
                if (!TextUtils.isEmpty(str) && !ctK.contains(str.toUpperCase())) {
                    String uk = ak.uk(cVar.toString(str));
                    if (!TextUtils.isEmpty(uk)) {
                        if (map != null) {
                            map.put(str.toLowerCase(), uk);
                        }
                        builder.header(str, uk);
                    }
                }
            }
        }
    }
}
