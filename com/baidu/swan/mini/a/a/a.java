package com.baidu.swan.mini.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.aq.aj;
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
public abstract class a extends EventTargetImpl {
    int deY;
    protected com.baidu.swan.games.binding.model.c deZ;
    private com.baidu.swan.games.f.b dfa;
    protected String mTaskId;
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> bQw = i.O("REFERER", "USER-AGENT");
    private static final Set<String> bQF = i.O("localhost", "127.0.0.1");

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.games.f.b bVar, com.baidu.swan.games.binding.model.c cVar) {
        super(bVar);
        this.deY = 0;
        this.dfa = bVar;
        this.mTaskId = aCd();
        this.deZ = cVar;
    }

    @JavascriptInterface
    public void abort() {
        if (this.deZ != null) {
            b.aGt().cancelTag(this.mTaskId);
        }
    }

    protected HttpUrl hU(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if ((e.apM() == null ? null : e.apM().getActivity()) == null) {
            if (a(parse)) {
                return parse;
            }
            return null;
        } else if ((DEBUG && com.baidu.swan.apps.af.a.a.anq()) || a(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String aCc() {
        String optString = this.deZ.optString("url");
        if (this.deZ == null || TextUtils.isEmpty(this.mTaskId)) {
            i("", 0, "request:jsObj is null");
            return null;
        } else if (TextUtils.isEmpty(optString)) {
            i("", -1, "request:url is invalid");
            return null;
        } else {
            HttpUrl hU = hU(optString);
            if (hU == null) {
                i(optString, -1, "request:url scheme is invalid");
                return null;
            }
            return hU.url().toString();
        }
    }

    protected boolean a(@Nullable HttpUrl httpUrl) {
        return (httpUrl == null || bQF.contains(httpUrl.host().toLowerCase())) ? false : true;
    }

    protected String aCd() {
        return "mini" + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis();
    }

    public String Vp() {
        return "";
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

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(final JSEvent jSEvent) {
        this.dfa.postOnJSThread(new Runnable() { // from class: com.baidu.swan.mini.a.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.super.dispatchEvent(jSEvent);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSuccess(final Object obj) {
        this.dfa.postOnJSThread(new Runnable() { // from class: com.baidu.swan.mini.a.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.utils.b.a(a.this.deZ, true, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(String str, final int i, final String str2) {
        this.dfa.postOnJSThread(new Runnable() { // from class: com.baidu.swan.mini.a.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
                bVar.errMsg = str2;
                bVar.statusCode = i;
                com.baidu.swan.games.utils.b.a(a.this.deZ, false, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map, boolean z) {
        a(builder, cVar, map);
        if (z) {
            builder.header("Referer", Vp());
        }
    }

    protected static void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map) {
        if (cVar != null && cVar.length() >= 1) {
            for (String str : cVar.keySet()) {
                if (!TextUtils.isEmpty(str) && !bQw.contains(str.toUpperCase())) {
                    String pX = aj.pX(cVar.toString(str));
                    if (!TextUtils.isEmpty(pX)) {
                        if (map != null) {
                            map.put(str.toLowerCase(), pX);
                        }
                        builder.header(str, pX);
                    }
                }
            }
        }
    }
}
