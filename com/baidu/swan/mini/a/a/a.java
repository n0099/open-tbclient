package com.baidu.swan.mini.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
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
/* loaded from: classes10.dex */
public abstract class a extends EventTargetImpl {
    int cma;
    protected com.baidu.swan.games.binding.model.c cmb;
    private com.baidu.swan.games.e.b cmc;
    protected String mTaskId;
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> bat = i.K("REFERER", "USER-AGENT");
    private static final Set<String> baF = i.K("localhost", "127.0.0.1");

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.games.e.b bVar, com.baidu.swan.games.binding.model.c cVar) {
        super(bVar);
        this.cma = 0;
        this.cmc = bVar;
        this.mTaskId = amB();
        this.cmb = cVar;
    }

    @JavascriptInterface
    public void abort() {
        if (this.cmb != null) {
            b.aqS().cancelTag(this.mTaskId);
        }
    }

    protected HttpUrl fu(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if ((e.aap() == null ? null : e.aap().getActivity()) == null) {
            if (a(parse)) {
                return parse;
            }
            return null;
        } else if ((DEBUG && com.baidu.swan.apps.ah.a.a.Yg()) || a(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String amA() {
        String optString = this.cmb.optString("url");
        if (this.cmb == null || TextUtils.isEmpty(this.mTaskId)) {
            h("", 0, "request:jsObj is null");
            return null;
        } else if (TextUtils.isEmpty(optString)) {
            h("", -1, "request:url is invalid");
            return null;
        } else {
            HttpUrl fu = fu(optString);
            if (fu == null) {
                h(optString, -1, "request:url scheme is invalid");
                return null;
            }
            return fu.url().toString();
        }
    }

    protected boolean a(@Nullable HttpUrl httpUrl) {
        return (httpUrl == null || baF.contains(httpUrl.host().toLowerCase())) ? false : true;
    }

    protected String amB() {
        return "mini" + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis();
    }

    public String HC() {
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
        this.cmc.postOnJSThread(new Runnable() { // from class: com.baidu.swan.mini.a.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.super.dispatchEvent(jSEvent);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSuccess(final Object obj) {
        this.cmc.postOnJSThread(new Runnable() { // from class: com.baidu.swan.mini.a.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.utils.b.a(a.this.cmb, true, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(String str, final int i, final String str2) {
        this.cmc.postOnJSThread(new Runnable() { // from class: com.baidu.swan.mini.a.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
                bVar.errMsg = str2;
                bVar.statusCode = i;
                com.baidu.swan.games.utils.b.a(a.this.cmb, false, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map, boolean z) {
        a(builder, cVar, map);
        if (z) {
            builder.header("Referer", HC());
        }
    }

    protected static void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map) {
        if (cVar != null && cVar.length() >= 1) {
            for (String str : cVar.keySet()) {
                if (!TextUtils.isEmpty(str) && !bat.contains(str.toUpperCase())) {
                    String mF = ai.mF(cVar.toString(str));
                    if (!TextUtils.isEmpty(mF)) {
                        if (map != null) {
                            map.put(str.toLowerCase(), mF);
                        }
                        builder.header(str, mF);
                    }
                }
            }
        }
    }
}
