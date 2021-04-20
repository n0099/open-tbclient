package com.baidu.swan.apps.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.g.w.d;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppNetworkUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f12050a = k.f45443a;

    /* loaded from: classes2.dex */
    public enum NetType {
        NONE("no"),
        WIFI("wifi"),
        _2G("2g"),
        _3G("3g"),
        _4G("4g"),
        _5G("5g"),
        UNKOWN("unknow");
        
        public final String type;

        NetType(String str) {
            this.type = str;
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends d.b.g0.a.n1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f12051c;

        public a(b bVar) {
            this.f12051c = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.n1.a.b.c.b, d.b.g0.a.n1.a.b.c.c, d.b.g0.a.n1.a.b.c.a
        public void onEvent(@NonNull d.b.g0.a.n1.a.b.a.b bVar) {
            int i = bVar.a() != null ? bVar.a().getInt("net_quality") : -1;
            b bVar2 = this.f12051c;
            if (bVar2 != null) {
                bVar2.onResult(i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onResult(int i);
    }

    public static boolean a(OkHttpClient okHttpClient, String str) {
        boolean z = false;
        if (okHttpClient != null && !TextUtils.isEmpty(str) && okHttpClient.dispatcher() != null) {
            for (Call call : okHttpClient.dispatcher().queuedCalls()) {
                if (call != null && call.request() != null && call.request().tag() != null && call.request().tag().equals(str)) {
                    call.cancel();
                    z = true;
                }
            }
            for (Call call2 : okHttpClient.dispatcher().runningCalls()) {
                if (call2 != null && call2.request() != null && call2.request().tag() != null && call2.request().tag().equals(str)) {
                    call2.cancel();
                    z = true;
                }
            }
        }
        return z;
    }

    public static void b(@NonNull b bVar) {
        d.b.g0.a.n1.c.e.a.C().J(null, d.class, new a(bVar));
    }

    public static NetworkInfo c(Context context) {
        ConnectivityManager connectivityManager;
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null || (connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity")) == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String d(int i, String str) {
        if (f12050a) {
            Log.d("NetWorkUtils", "——> getNetworkType: netType " + i + " subTypeName " + str);
        }
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3g";
            case 13:
            case 18:
            case 19:
                break;
            default:
                if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("LTE_CA")) {
                    return "unknown";
                }
                break;
        }
        return "4g";
    }

    public static String e() {
        NetworkInfo c2 = c(AppRuntime.getAppContext());
        return (c2 == null || !c2.isConnected()) ? "no" : c2.getType() == 1 ? "wifi" : c2.getType() == 0 ? d(c2.getSubtype(), c2.getSubtypeName()) : "unknown";
    }

    public static NetType f() {
        char c2;
        String e2 = e();
        int hashCode = e2.hashCode();
        if (hashCode == -840472412) {
            if (e2.equals("unknow")) {
                c2 = 5;
            }
            c2 = 65535;
        } else if (hashCode == 1653) {
            if (e2.equals("2g")) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode == 1684) {
            if (e2.equals("3g")) {
                c2 = 1;
            }
            c2 = 65535;
        } else if (hashCode == 1715) {
            if (e2.equals("4g")) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != 3521) {
            if (hashCode == 3649301 && e2.equals("wifi")) {
                c2 = 3;
            }
            c2 = 65535;
        } else {
            if (e2.equals("no")) {
                c2 = 4;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    if (c2 != 3) {
                        if (c2 != 4) {
                            return NetType.UNKOWN;
                        }
                        return NetType.NONE;
                    }
                    return NetType.WIFI;
                }
                return NetType._4G;
            }
            return NetType._3G;
        }
        return NetType._2G;
    }

    public static String g() {
        String g2 = k0.g(d.b.g0.a.e0.w.d.L().W());
        return TextUtils.isEmpty(g2) ? "" : g2;
    }

    public static boolean h(Context context) {
        NetworkInfo c2 = c(AppRuntime.getAppContext());
        return c2 != null && c2.isConnectedOrConnecting();
    }

    public static boolean i(Context context) {
        NetworkInfo c2 = c(AppRuntime.getAppContext());
        return c2 != null && c2.isAvailable() && c2.getType() == 1;
    }

    public static void j(Context context, CallbackHandler callbackHandler, String str) {
        if (context == null || TextUtils.isEmpty(str) || callbackHandler == null) {
            return;
        }
        boolean h2 = h(context);
        String e2 = e();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isConnected", h2);
            if (TextUtils.equals(e2, "no")) {
                e2 = "none";
            }
            jSONObject.put("networkType", e2);
            if (f12050a) {
                Log.d("SwanAppNetworkUtils", "——> notifyNetworkStatus: isConnected " + jSONObject.get("isConnected") + " , networkType " + jSONObject.get("networkType"));
            }
        } catch (JSONException e3) {
            if (f12050a) {
                e3.printStackTrace();
            }
        }
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
        if (f12050a) {
            Log.d("SwanAppNetworkUtils", "——> notifyNetworkStatus: post success ");
        }
    }

    public static <T> void k(String str, String str2, ResponseCallback<T> responseCallback) {
        if (f12050a) {
            Log.d("postJsonRequest", HttpRetryStatistic.RETRY_URL + str + "\nbody:" + str2);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.b.g0.k.e.a.f().postStringRequest().url(str).cookieManager(d.b.g0.a.w0.a.m().a()).mediaType("application/json;charset=utf-8").content(str2).build().executeAsync(responseCallback);
    }
}
