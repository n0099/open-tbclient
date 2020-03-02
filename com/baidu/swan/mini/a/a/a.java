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
/* loaded from: classes11.dex */
public abstract class a extends EventTargetImpl {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> beG = i.K("REFERER", "USER-AGENT");
    private static final Set<String> beS = i.K("localhost", "127.0.0.1");
    int cqe;
    protected com.baidu.swan.games.binding.model.c cqf;
    private com.baidu.swan.games.e.b cqg;
    protected String mTaskId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.games.e.b bVar, com.baidu.swan.games.binding.model.c cVar) {
        super(bVar);
        this.cqe = 0;
        this.cqg = bVar;
        this.mTaskId = aoQ();
        this.cqf = cVar;
    }

    @JavascriptInterface
    public void abort() {
        if (this.cqf != null) {
            b.ati().cancelTag(this.mTaskId);
        }
    }

    protected HttpUrl fJ(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if ((e.acF() == null ? null : e.acF().getActivity()) == null) {
            if (a(parse)) {
                return parse;
            }
            return null;
        } else if ((DEBUG && com.baidu.swan.apps.ah.a.a.aaw()) || a(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String aoP() {
        String optString = this.cqf.optString("url");
        if (this.cqf == null || TextUtils.isEmpty(this.mTaskId)) {
            i("", 0, "request:jsObj is null");
            return null;
        } else if (TextUtils.isEmpty(optString)) {
            i("", -1, "request:url is invalid");
            return null;
        } else {
            HttpUrl fJ = fJ(optString);
            if (fJ == null) {
                i(optString, -1, "request:url scheme is invalid");
                return null;
            }
            return fJ.url().toString();
        }
    }

    protected boolean a(@Nullable HttpUrl httpUrl) {
        return (httpUrl == null || beS.contains(httpUrl.host().toLowerCase())) ? false : true;
    }

    protected String aoQ() {
        return "mini" + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis();
    }

    public String JT() {
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
        this.cqg.postOnJSThread(new Runnable() { // from class: com.baidu.swan.mini.a.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.super.dispatchEvent(jSEvent);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSuccess(final Object obj) {
        this.cqg.postOnJSThread(new Runnable() { // from class: com.baidu.swan.mini.a.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.utils.b.a(a.this.cqf, true, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(String str, final int i, final String str2) {
        this.cqg.postOnJSThread(new Runnable() { // from class: com.baidu.swan.mini.a.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
                bVar.errMsg = str2;
                bVar.statusCode = i;
                com.baidu.swan.games.utils.b.a(a.this.cqf, false, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map, boolean z) {
        a(builder, cVar, map);
        if (z) {
            builder.header("Referer", JT());
        }
    }

    protected static void a(@NonNull Request.Builder builder, com.baidu.swan.games.binding.model.c cVar, Map<String, String> map) {
        if (cVar != null && cVar.length() >= 1) {
            for (String str : cVar.keySet()) {
                if (!TextUtils.isEmpty(str) && !beG.contains(str.toUpperCase())) {
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
