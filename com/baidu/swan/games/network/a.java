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
/* loaded from: classes7.dex */
public class a extends EventTargetImpl {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final Set<String> cxV = i.N("REFERER", "USER-AGENT");
    protected static final Set<String> cyg = i.N("localhost", "127.0.0.1");
    protected com.baidu.swan.games.binding.model.c dVB;
    private com.baidu.swan.games.f.b dVC;
    protected String mTaskId;
    public int requestType;

    public a(@NonNull com.baidu.swan.games.f.b bVar, com.baidu.swan.games.binding.model.c cVar) {
        super(bVar);
        this.requestType = 0;
        this.dVC = bVar;
        this.mTaskId = aVH();
        this.dVB = cVar;
    }

    @JavascriptInterface
    public void abort() {
        if (this.dVB != null && e.aGM() != null) {
            e.aGM().aHb().cancelTag(this.mTaskId);
        }
    }

    public void start() {
    }

    protected HttpUrl lj(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (com.baidu.swan.apps.runtime.d.aGI().aGG() == null) {
            if (a(parse)) {
                return parse;
            }
            return null;
        } else if ((DEBUG && com.baidu.swan.apps.ad.a.a.aEc()) || a(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String aVG() {
        String optString = this.dVB.optString("url");
        if (this.dVB == null || TextUtils.isEmpty(this.mTaskId)) {
            l("", 0, "request:swanApp is null");
            return null;
        } else if (TextUtils.isEmpty(optString)) {
            l("", -1, "request:url is invalid");
            return null;
        } else if (e.aGM() == null) {
            l("", -1, "request:swanApp is null");
            return null;
        } else {
            HttpUrl lj = lj(optString);
            if (lj == null) {
                l(optString, -1, "request:url scheme is invalid");
                return null;
            }
            String url = lj.url().toString();
            switch (com.baidu.swan.apps.ag.a.b.S("request", url, "")) {
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
        return (httpUrl == null || cyg.contains(httpUrl.host().toLowerCase())) ? false : true;
    }

    protected String aVH() {
        String aGO = e.aGO();
        return TextUtils.isEmpty(aGO) ? "" : aGO + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis();
    }

    public String aji() {
        e aGM = e.aGM();
        return aGM != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", aGM.getAppKey(), aGM.aHi()) : "";
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
        if (cVar != null && this.dVB != null) {
            this.dVB.put("success", cVar.wz("success"));
            this.dVB.put("fail", cVar.wz("fail"));
            this.dVB.put(com.baidu.mobads.openad.c.b.COMPLETE, cVar.wz(com.baidu.mobads.openad.c.b.COMPLETE));
        }
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(final JSEvent jSEvent) {
        this.dVC.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.super.dispatchEvent(jSEvent);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSuccess(final Object obj) {
        this.dVC.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.utils.b.a(a.this.dVB, true, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(String str, final int i, final String str2) {
        this.dVC.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.network.a.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
                bVar.errMsg = str2;
                bVar.statusCode = i;
                com.baidu.swan.games.utils.b.a(a.this.dVB, false, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map, boolean z) {
        a(builder, cVar, map);
        if (z) {
            builder.header("Referer", aji());
        }
    }

    protected static void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map) {
        if (cVar != null && cVar.length() >= 1) {
            for (String str : cVar.keySet()) {
                if (!TextUtils.isEmpty(str) && !cxV.contains(str.toUpperCase())) {
                    String ut = ak.ut(cVar.toString(str));
                    if (!TextUtils.isEmpty(ut)) {
                        if (map != null) {
                            map.put(str.toLowerCase(), ut);
                        }
                        builder.header(str, ut);
                    }
                }
            }
        }
    }
}
