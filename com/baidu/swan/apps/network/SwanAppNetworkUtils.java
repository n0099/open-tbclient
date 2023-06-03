package com.baidu.swan.apps.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.h83;
import com.baidu.tieba.is1;
import com.baidu.tieba.l33;
import com.baidu.tieba.l83;
import com.baidu.tieba.si2;
import com.baidu.tieba.sp3;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SwanAppNetworkUtils {
    public static final boolean a = is1.a;

    /* loaded from: classes4.dex */
    public interface b {
        void onResult(int i);
    }

    /* loaded from: classes4.dex */
    public static class a implements h83<Bundle> {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h83
        /* renamed from: a */
        public void onResult(Bundle bundle) {
            b bVar = this.a;
            if (bVar != null) {
                bVar.onResult(bundle.getInt("net_quality"));
            }
        }
    }

    public static String g() {
        String f = sp3.f(si2.U().g0());
        if (TextUtils.isEmpty(f)) {
            return "";
        }
        return f;
    }

    public static boolean h() {
        NetworkInfo c = c(AppRuntime.getAppContext());
        if (c != null && c.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    /* loaded from: classes4.dex */
    public enum NetType {
        NONE("no"),
        WIFI("wifi"),
        _2G("2g"),
        _3G("3g"),
        _4G("4g"),
        _5G("5g"),
        UNKOWN(DownloadStatisticConstants.UBC_VALUE_UNKNOW);
        
        public final String type;

        NetType(String str) {
            this.type = str;
        }
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

    public static String d(int i, String str) {
        if (a) {
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
                return "4g";
            case 20:
                return "5g";
            default:
                if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("LTE_CA")) {
                    return "4g";
                }
                return "unknown";
        }
    }

    public static void b(@NonNull b bVar) {
        l83.a(l33.class, null, new a(bVar));
    }

    public static NetworkInfo c(Context context) {
        ConnectivityManager connectivityManager;
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null || (connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity")) == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static boolean i(Context context) {
        return h();
    }

    public static boolean j(Context context) {
        NetworkInfo c = c(AppRuntime.getAppContext());
        if (c != null && c.isAvailable() && c.getType() == 1) {
            return true;
        }
        return false;
    }

    public static String e() {
        NetworkInfo c = c(AppRuntime.getAppContext());
        if (c != null && c.isConnected()) {
            if (c.getType() == 1) {
                return "wifi";
            }
            if (c.getType() == 0) {
                return d(c.getSubtype(), c.getSubtypeName());
            }
            return "unknown";
        }
        return "no";
    }

    public static NetType f() {
        char c;
        String e = e();
        int hashCode = e.hashCode();
        if (hashCode != -840472412) {
            if (hashCode != 1653) {
                if (hashCode != 1684) {
                    if (hashCode != 1715) {
                        if (hashCode != 1746) {
                            if (hashCode != 3521) {
                                if (hashCode == 3649301 && e.equals("wifi")) {
                                    c = 4;
                                }
                                c = 65535;
                            } else {
                                if (e.equals("no")) {
                                    c = 5;
                                }
                                c = 65535;
                            }
                        } else {
                            if (e.equals("5g")) {
                                c = 3;
                            }
                            c = 65535;
                        }
                    } else {
                        if (e.equals("4g")) {
                            c = 2;
                        }
                        c = 65535;
                    }
                } else {
                    if (e.equals("3g")) {
                        c = 1;
                    }
                    c = 65535;
                }
            } else {
                if (e.equals("2g")) {
                    c = 0;
                }
                c = 65535;
            }
        } else {
            if (e.equals(DownloadStatisticConstants.UBC_VALUE_UNKNOW)) {
                c = 6;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c != 4) {
                            if (c != 5) {
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

    public static void k(Context context, CallbackHandler callbackHandler, String str) {
        if (context != null && !TextUtils.isEmpty(str) && callbackHandler != null) {
            boolean i = i(context);
            String e = e();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("isConnected", i);
                if (TextUtils.equals(e, "no")) {
                    e = "none";
                }
                jSONObject.put("networkType", e);
                if (a) {
                    Log.d("SwanAppNetworkUtils", "——> notifyNetworkStatus: isConnected " + jSONObject.get("isConnected") + " , networkType " + jSONObject.get("networkType"));
                }
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
            if (a) {
                Log.d("SwanAppNetworkUtils", "——> notifyNetworkStatus: post success ");
            }
        }
    }
}
