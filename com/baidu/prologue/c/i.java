package com.baidu.prologue.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.prologue.service.network.Als;
import com.vivo.push.PushClientConstants;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class i extends e {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.bKm.get().UU();
    private static final String[] bMl = {"deeplink", "open"};

    @Override // com.baidu.prologue.c.e
    public void addRedirectScheme(HashMap<String, String> hashMap) {
        String[] strArr;
        for (String str : bMl) {
            hashMap.put("splash/ad/" + str, "splash_ad/" + str);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
        if (r3.equals("open") != false) goto L15;
     */
    @Override // com.baidu.prologue.c.e
    @SuppressLint({"LongLogTag"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(Context context, g gVar, a aVar) {
        boolean z = true;
        String path = gVar.getPath(true);
        if (TextUtils.isEmpty(path) || context == null) {
            gVar.result = j.wrapCallbackParams(201);
            return false;
        } else if (gVar.isOnlyVerify()) {
            return true;
        } else {
            if (DEBUG) {
                Log.e("UnitedSchemeSplashDispatcher", "invoke: " + gVar.getUri().toString());
            }
            switch (path.hashCode()) {
                case 3417674:
                    break;
                case 629233382:
                    if (path.equals("deeplink")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    return d(context, gVar, aVar);
                case true:
                    return a(gVar, aVar);
                default:
                    if (DEBUG) {
                        throw new IllegalStateException("scheme action 不支持错误");
                    }
                    return false;
            }
        }
    }

    private boolean a(g gVar, a aVar) {
        String str = gVar.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new IllegalStateException("action deeplink 没有params参数");
            }
            return false;
        }
        try {
            return a(new JSONObject(str).optString("webUrl"), aVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean a(@NonNull String str, final a aVar) {
        return com.baidu.prologue.a.b.a.bKm.get().a(str, new b() { // from class: com.baidu.prologue.c.i.1
        });
    }

    private boolean d(@NonNull Context context, @NonNull g gVar, a aVar) {
        boolean z;
        String str = gVar.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new IllegalStateException("action deeplink 没有params参数");
            }
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appUrl");
            String optString2 = jSONObject.optString("webUrl");
            String optString3 = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
            if (!TextUtils.isEmpty(optString) && com.baidu.prologue.a.c.j.I(context, optString)) {
                a(Als.Area.DEEPLINK_RESULT_APP);
                z = true;
            } else if (!TextUtils.isEmpty(optString3) && com.baidu.prologue.a.c.j.H(context, optString3)) {
                a(Als.Area.DEEPLINK_RESULT_APP);
                z = true;
            } else if (TextUtils.isEmpty(optString2)) {
                z = false;
            } else {
                a(Als.Area.DEEPLINK_RESULT_H5);
                z = a(optString2, aVar);
            }
            return z;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void a(Als.Area area) {
        if (!TextUtils.isEmpty(com.baidu.prologue.business.data.c.bKE)) {
            Als.a aVar = new Als.a(Als.Type.DEEP_LINK);
            aVar.a(Als.Page.NA_DEEPLINK);
            aVar.b(area);
            aVar.im(com.baidu.prologue.business.data.c.bKE);
            Als.a(aVar);
        } else if (DEBUG) {
            throw new IllegalStateException("全局数据仓库获取数据失败，打点失败...");
        }
    }
}
