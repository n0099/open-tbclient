package com.baidu.sapi2;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.pass.http.HttpHashMap;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.utils.Log;
import java.net.HttpCookie;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class A implements com.baidu.sapi2.callback.a.a {
    final /* synthetic */ OneKeyLoginCallback a;
    final /* synthetic */ com.baidu.sapi2.callback.a.b b;
    final /* synthetic */ L c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(L l, OneKeyLoginCallback oneKeyLoginCallback, com.baidu.sapi2.callback.a.b bVar) {
        this.c = l;
        this.a = oneKeyLoginCallback;
        this.b = bVar;
    }

    @Override // com.baidu.sapi2.callback.a.a
    public void a(String str) {
        SapiConfiguration sapiConfiguration;
        SapiConfiguration sapiConfiguration2;
        List<HttpCookie> a;
        String x;
        String str2;
        JSONObject jSONObject = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                Log.e(e);
            }
            HttpHashMap httpHashMap = new HttpHashMap();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    httpHashMap.put(next, jSONObject.optString(next));
                }
            }
            L l = this.c;
            sapiConfiguration = l.d;
            Context context = sapiConfiguration.context;
            sapiConfiguration2 = this.c.d;
            a = l.a(context, sapiConfiguration2);
            HttpClientWrap httpClientWrap = new HttpClientWrap();
            String l2 = this.c.l();
            x = this.c.x();
            httpClientWrap.post(l2, httpHashMap, a, x, new z(this, Looper.getMainLooper()));
            return;
        }
        str2 = L.a;
        Log.e(str2, "oneKeyLogin execute JavaScript failed, it only support after KitKat version");
        new com.baidu.sapi2.outsdk.c().a(this.a, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_EXECUTE_JS_FAIL, (String) null);
    }
}
