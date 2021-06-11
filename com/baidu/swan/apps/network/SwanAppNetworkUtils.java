package com.baidu.swan.apps.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.k;
import d.a.l0.a.n1.m;
import d.a.l0.a.v2.q0;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanAppNetworkUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f11035a = k.f46875a;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static class a extends d.a.l0.a.v1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f11036c;

        public a(b bVar) {
            this.f11036c = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v1.a.b.c.b, d.a.l0.a.v1.a.b.c.c, d.a.l0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.l0.a.v1.a.b.a.b bVar) {
            int i2 = bVar.a() != null ? bVar.a().getInt("net_quality") : -1;
            b bVar2 = this.f11036c;
            if (bVar2 != null) {
                bVar2.onResult(i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onResult(int i2);
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
        d.a.l0.a.v1.c.e.a.E().L(null, m.class, new a(bVar));
    }

    public static NetworkInfo c(Context context) {
        ConnectivityManager connectivityManager;
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null || (connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity")) == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static String d(int i2, String str) {
        if (f11035a) {
            Log.d("NetWorkUtils", "——> getNetworkType: netType " + i2 + " subTypeName " + str);
        }
        switch (i2) {
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
                return "4g";
            case 20:
                return "5g";
            default:
                return (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("LTE_CA")) ? "unknown" : "4g";
        }
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
                c2 = 6;
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
        } else if (hashCode == 1746) {
            if (e2.equals("5g")) {
                c2 = 3;
            }
            c2 = 65535;
        } else if (hashCode != 3521) {
            if (hashCode == 3649301 && e2.equals("wifi")) {
                c2 = 4;
            }
            c2 = 65535;
        } else {
            if (e2.equals("no")) {
                c2 = 5;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    if (c2 != 3) {
                        if (c2 != 4) {
                            if (c2 != 5) {
                                return NetType.UNKOWN;
                            }
                            return NetType.NONE;
                        }
                        return NetType.WIFI;
                    }
                    return NetType._5G;
                }
                return NetType._4G;
            }
            return NetType._3G;
        }
        return NetType._2G;
    }

    public static String g() {
        String f2 = q0.f(g.N().Y());
        return TextUtils.isEmpty(f2) ? "" : f2;
    }

    public static boolean h() {
        NetworkInfo c2 = c(AppRuntime.getAppContext());
        return c2 != null && c2.isConnectedOrConnecting();
    }

    public static boolean i(Context context) {
        return h();
    }

    public static boolean j(Context context) {
        NetworkInfo c2 = c(AppRuntime.getAppContext());
        return c2 != null && c2.isAvailable() && c2.getType() == 1;
    }

    public static void k(Context context, CallbackHandler callbackHandler, String str) {
        if (context == null || TextUtils.isEmpty(str) || callbackHandler == null) {
            return;
        }
        boolean i2 = i(context);
        String e2 = e();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isConnected", i2);
            if (TextUtils.equals(e2, "no")) {
                e2 = "none";
            }
            jSONObject.put("networkType", e2);
            if (f11035a) {
                Log.d("SwanAppNetworkUtils", "——> notifyNetworkStatus: isConnected " + jSONObject.get("isConnected") + " , networkType " + jSONObject.get("networkType"));
            }
        } catch (JSONException e3) {
            if (f11035a) {
                e3.printStackTrace();
            }
        }
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
        if (f11035a) {
            Log.d("SwanAppNetworkUtils", "——> notifyNetworkStatus: post success ");
        }
    }
}
