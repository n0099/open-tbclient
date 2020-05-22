package com.baidu.swan.apps.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aq.aj;
import java.util.Iterator;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class SwanAppNetworkUtils {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean a(OkHttpClient okHttpClient, String str) {
        boolean z;
        boolean z2 = false;
        if (okHttpClient == null || TextUtils.isEmpty(str) || okHttpClient.dispatcher() == null) {
            return false;
        }
        Iterator<Call> it = okHttpClient.dispatcher().queuedCalls().iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            Call next = it.next();
            if (next == null || next.request() == null || next.request().tag() == null || !next.request().tag().equals(str)) {
                z2 = z;
            } else {
                next.cancel();
                z2 = true;
            }
        }
        for (Call call : okHttpClient.dispatcher().runningCalls()) {
            if (call != null && call.request() != null && call.request().tag() != null && call.request().tag().equals(str)) {
                call.cancel();
                z = true;
            }
        }
        return z;
    }

    public static void a(Context context, CallbackHandler callbackHandler, String str) {
        if (context != null && !TextUtils.isEmpty(str) && callbackHandler != null) {
            boolean isNetworkConnected = isNetworkConnected(context);
            String networkClass = getNetworkClass();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("isConnected", isNetworkConnected);
                if (TextUtils.equals(networkClass, NetWorkUtils.NETWORK_TYPE_CELL_UN_CONNECTED)) {
                    networkClass = "none";
                }
                jSONObject.put("networkType", networkClass);
                if (DEBUG) {
                    Log.d("SwanAppNetworkUtils", "——> notifyNetworkStatus: isConnected " + jSONObject.get("isConnected") + " , networkType " + jSONObject.get("networkType"));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
            if (DEBUG) {
                Log.d("SwanAppNetworkUtils", "——> notifyNetworkStatus: post success ");
            }
        }
    }

    public static String getMobileNetworkType(int i, String str) {
        if (DEBUG) {
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
            default:
                if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("LTE_CA")) {
                    return "4g";
                }
                return "unknown";
        }
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(AppRuntime.getAppContext());
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static boolean isWifiNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(AppRuntime.getAppContext());
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 1;
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        Context appContext = AppRuntime.getAppContext();
        if (appContext != null && (connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity")) != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static String getNetworkClass() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(AppRuntime.getAppContext());
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return NetWorkUtils.NETWORK_TYPE_CELL_UN_CONNECTED;
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo.getType() == 0) {
            return getMobileNetworkType(activeNetworkInfo.getSubtype(), activeNetworkInfo.getSubtypeName());
        }
        return "unknown";
    }

    public static NetType akA() {
        String networkClass = getNetworkClass();
        char c = 65535;
        switch (networkClass.hashCode()) {
            case -840472412:
                if (networkClass.equals("unknow")) {
                    c = 5;
                    break;
                }
                break;
            case 1653:
                if (networkClass.equals("2g")) {
                    c = 0;
                    break;
                }
                break;
            case 1684:
                if (networkClass.equals("3g")) {
                    c = 1;
                    break;
                }
                break;
            case 1715:
                if (networkClass.equals("4g")) {
                    c = 2;
                    break;
                }
                break;
            case 3521:
                if (networkClass.equals(NetWorkUtils.NETWORK_TYPE_CELL_UN_CONNECTED)) {
                    c = 4;
                    break;
                }
                break;
            case 3649301:
                if (networkClass.equals("wifi")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return NetType._2G;
            case 1:
                return NetType._3G;
            case 2:
                return NetType._4G;
            case 3:
                return NetType.WIFI;
            case 4:
                return NetType.NONE;
            default:
                return NetType.UNKOWN;
        }
    }

    /* loaded from: classes11.dex */
    public enum NetType {
        NONE(NetWorkUtils.NETWORK_TYPE_CELL_UN_CONNECTED),
        WIFI("wifi"),
        _2G("2g"),
        _3G("3g"),
        _4G("4g"),
        UNKOWN("unknow");
        
        public final String type;

        NetType(String str) {
            this.type = str;
        }
    }

    public static String akB() {
        String pP = aj.pP(com.baidu.swan.apps.core.turbo.d.abl().abJ());
        if (TextUtils.isEmpty(pP)) {
            return "";
        }
        return pP;
    }

    public static <T> void a(String str, String str2, ResponseCallback<T> responseCallback) {
        if (DEBUG) {
            Log.d("postJsonRequest", "url:" + str + "\nbody:" + str2);
        }
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.c.c.a.aFx().postStringRequest().url(str).cookieManager(com.baidu.swan.apps.u.a.afo().SM()).mediaType("application/json;charset=utf-8").content(str2).build().executeAsync(responseCallback);
        }
    }
}
