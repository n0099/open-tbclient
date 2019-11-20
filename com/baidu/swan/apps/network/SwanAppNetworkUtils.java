package com.baidu.swan.apps.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.Iterator;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
            String MP = MP();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("isConnected", isNetworkConnected);
                if (TextUtils.equals(MP, "no")) {
                    MP = IXAdSystemUtils.NT_NONE;
                }
                jSONObject.put("networkType", MP);
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

    public static String s(int i, String str) {
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
                return BdNetTypeUtil.NET_TYPENAME_2G;
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
                return BdNetTypeUtil.NET_TYPENAME_3G;
            case 13:
            case 18:
            case 19:
                return BdNetTypeUtil.NET_TYPENAME_4G;
            default:
                if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("LTE_CA")) {
                    return BdNetTypeUtil.NET_TYPENAME_4G;
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

    public static String MP() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(AppRuntime.getAppContext());
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo.getType() == 0) {
            return s(activeNetworkInfo.getSubtype(), activeNetworkInfo.getSubtypeName());
        }
        return "unknown";
    }

    public static NetType MQ() {
        String MP = MP();
        char c = 65535;
        switch (MP.hashCode()) {
            case -840472412:
                if (MP.equals("unknow")) {
                    c = 5;
                    break;
                }
                break;
            case 1653:
                if (MP.equals(BdNetTypeUtil.NET_TYPENAME_2G)) {
                    c = 0;
                    break;
                }
                break;
            case 1684:
                if (MP.equals(BdNetTypeUtil.NET_TYPENAME_3G)) {
                    c = 1;
                    break;
                }
                break;
            case 1715:
                if (MP.equals(BdNetTypeUtil.NET_TYPENAME_4G)) {
                    c = 2;
                    break;
                }
                break;
            case 3521:
                if (MP.equals("no")) {
                    c = 4;
                    break;
                }
                break;
            case 3649301:
                if (MP.equals("wifi")) {
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

    /* loaded from: classes2.dex */
    public enum NetType {
        NONE("no"),
        WIFI("wifi"),
        _2G(BdNetTypeUtil.NET_TYPENAME_2G),
        _3G(BdNetTypeUtil.NET_TYPENAME_3G),
        _4G(BdNetTypeUtil.NET_TYPENAME_4G),
        UNKOWN("unknow");
        
        public final String type;

        NetType(String str) {
            this.type = str;
        }
    }
}
