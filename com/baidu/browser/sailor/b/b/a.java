package com.baidu.browser.sailor.b.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.browser.sailor.a.n;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.webkit.internal.daemon.ZeusThreadPoolUtil;
import com.baidu.webkit.sdk.Log;
import java.io.File;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    private static BroadcastReceiver a;
    private static final SparseArray<n> b = new SparseArray<>();

    public static String a() {
        return Locale.getDefault().getLanguage();
    }

    public static void a(String str, String str2, n.a aVar) {
        File externalStorageDirectory;
        n nVar = new n(str, str2);
        nVar.a(aVar);
        nVar.cz("device_info");
        final com.baidu.browser.sailor.util.d dVar = new com.baidu.browser.sailor.util.d();
        Context appContext = com.baidu.browser.sailor.b.a.qS().getAppContext();
        final c cVar = new c(nVar);
        final Context applicationContext = appContext.getApplicationContext();
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", ((TelephonyManager) applicationContext.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getDeviceId());
            jSONObject.put(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE);
            jSONObject.put(SapiContext.KEY_SDK_VERSION, Build.VERSION.SDK_INT);
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("serial_number", Settings.Secure.getString(appContext.getContentResolver(), "android_id"));
            jSONObject.put("ip", com.baidu.browser.sailor.util.d.a());
            WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
            jSONObject.put("wifi_mac", connectionInfo != null ? connectionInfo.getMacAddress() : "");
            long[] jArr = new long[2];
            if (Environment.getExternalStorageState().equals("mounted") && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                int blockSize = statFs.getBlockSize();
                jArr[0] = statFs.getBlockCount() * blockSize;
                jArr[1] = statFs.getAvailableBlocks() * blockSize;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("total", jArr[0]);
            jSONObject2.put("available", jArr[1]);
            jSONObject.put("memory", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        applicationContext.registerReceiver(new BroadcastReceiver() { // from class: com.baidu.browser.sailor.util.BdDeviceInfo$1
            /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IGET]}, finally: {[IGET, INVOKE, IGET, IGET, IGET, INVOKE, IF] complete} */
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    try {
                        jSONObject3.put("level", intent.getIntExtra("level", -1));
                        jSONObject3.put("scale", intent.getIntExtra("scale", -1));
                        jSONObject.put("battery", jSONObject3);
                        applicationContext.unregisterReceiver(this);
                        if (cVar != null) {
                            cVar.a(jSONObject);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        applicationContext.unregisterReceiver(this);
                        if (cVar != null) {
                            cVar.a(jSONObject);
                        }
                    }
                } catch (Throwable th) {
                    applicationContext.unregisterReceiver(this);
                    if (cVar != null) {
                        cVar.a(jSONObject);
                    }
                    throw th;
                }
            }
        }, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public static void a(String str, String str2, String str3, String str4, n.a aVar, String str5, String str6) {
        n nVar = new n(str3, str4);
        nVar.a(aVar);
        Log.i("BdWebappNativeAbility", "post file params:" + str2);
        ZeusThreadPoolUtil.execute(new b(str, str6, nVar, str2, str5));
    }

    public static void b(String str, String str2, n.a aVar) {
        String str3;
        n nVar = new n(str, str2);
        nVar.a(aVar);
        ConnectivityManager connectivityManager = (ConnectivityManager) com.baidu.browser.sailor.b.a.qS().getAppContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            nVar.c("net_result", "lightapp.device.CONNECT_UNKNOWN", false);
            return;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            switch (activeNetworkInfo.getType()) {
                case 0:
                    str3 = "lightapp.device.CONNECT_MOBILE";
                    break;
                case 1:
                    str3 = "lightapp.device.CONNECT_WIFI";
                    break;
                default:
                    if (activeNetworkInfo.isAvailable()) {
                        str3 = "lightapp.device.CONNECT_CONNECTED";
                        break;
                    }
                    break;
            }
            nVar.c("net_result", str3, true);
        }
        str3 = "lightapp.device.CONNECT_NONE";
        nVar.c("net_result", str3, true);
    }

    public static void c(String str, String str2, n.a aVar) {
        n nVar = new n(str, str2);
        nVar.a(aVar);
        b.put(10, nVar);
        if (a == null) {
            a = new d();
        }
        com.baidu.browser.sailor.b.a.qS().getAppContext().registerReceiver(a, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public static void d(String str, String str2, n.a aVar) {
        n nVar = new n(str, str2);
        nVar.a(aVar);
        if (b.get(10) == null) {
            nVar.cB("not start yet");
            return;
        }
        b.remove(10);
        if (a == null) {
            nVar.cB("not start yet");
            return;
        }
        com.baidu.browser.sailor.b.a.qS().getAppContext().unregisterReceiver(a);
        a = null;
        nVar.qR();
    }

    public static void e(String str, String str2, n.a aVar) {
        n nVar = new n(str, str2);
        nVar.a(aVar);
        final com.baidu.browser.sailor.util.d dVar = new com.baidu.browser.sailor.util.d();
        Context appContext = com.baidu.browser.sailor.b.a.qS().getAppContext();
        final e eVar = new e(nVar);
        final Context applicationContext = appContext.getApplicationContext();
        applicationContext.registerReceiver(new BroadcastReceiver() { // from class: com.baidu.browser.sailor.util.BdDeviceInfo$2
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                JSONObject jSONObject = new JSONObject();
                try {
                    try {
                        jSONObject.put("level", intent.getIntExtra("level", -1));
                        jSONObject.put("scale", intent.getIntExtra("scale", -1));
                        jSONObject.put("plugged", intent.getIntExtra("plugged", 0));
                        applicationContext.unregisterReceiver(this);
                        if (eVar != null) {
                            eVar.a(jSONObject);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        applicationContext.unregisterReceiver(this);
                        if (eVar != null) {
                            eVar.a(jSONObject);
                        }
                    }
                } catch (Throwable th) {
                    applicationContext.unregisterReceiver(this);
                    if (eVar != null) {
                        eVar.a(jSONObject);
                    }
                    throw th;
                }
            }
        }, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }
}
