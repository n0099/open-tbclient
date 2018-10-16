package com.baidu.searchbox.ng.ai.apps.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.Iterator;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppNetworkUtils {
    protected static final boolean DEBUG = false;
    public static final String ENABLE_HTTP_AND_PORT = "enable_http_and_port";
    private static final String KEY_IS_CONNECTED = "isConnected";
    private static final String KEY_NETWORK_TYPE = "networkType";
    public static final String NETWORK_TYPE_CELL_2G = "2g";
    public static final String NETWORK_TYPE_CELL_3G = "3g";
    public static final String NETWORK_TYPE_CELL_4G = "4g";
    public static final String NETWORK_TYPE_CELL_UNKNOWN = "unknown";
    public static final String NETWORK_TYPE_CELL_UN_CONNECTED = "no";
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final String NETWORK_TYPE_WIFI = "wifi";
    private static final String NO_NETWORK_CONNECTION = "none";

    public static boolean cancelCallWithTag(OkHttpClient okHttpClient, String str) {
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

    public static boolean getHttpEnable(Context context) {
        return AiAppsRuntime.getAiAppAccountRuntime().enableHttpAndPort(context);
    }

    public static void notifyNetworkStatus(Context context, CallbackHandler callbackHandler, String str) {
        if (context != null && !TextUtils.isEmpty(str) && callbackHandler != null) {
            boolean isNetworkConnected = isNetworkConnected(context);
            String networkClass = getNetworkClass();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(KEY_IS_CONNECTED, isNetworkConnected);
                if (TextUtils.equals(networkClass, NETWORK_TYPE_CELL_UN_CONNECTED)) {
                    networkClass = NO_NETWORK_CONNECTION;
                }
                jSONObject.put(KEY_NETWORK_TYPE, networkClass);
            } catch (JSONException e) {
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
        }
    }

    public static String getMobileNetworkType(int i, String str) {
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
            return NETWORK_TYPE_CELL_UN_CONNECTED;
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo.getType() == 0) {
            return getMobileNetworkType(activeNetworkInfo.getSubtype(), activeNetworkInfo.getSubtypeName());
        }
        return "unknown";
    }

    public static NetType getNetworkType() {
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
                if (networkClass.equals(NETWORK_TYPE_CELL_UN_CONNECTED)) {
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

    /* loaded from: classes2.dex */
    public enum NetType {
        NONE(AiAppNetworkUtils.NETWORK_TYPE_CELL_UN_CONNECTED),
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
}
