package com.baidu.browser.sailor.platform.nativeability;

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
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.browser.sailor.lightapp.BdLightappKernelJsCallback;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.sapi2.SapiContext;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.webkit.internal.daemon.ZeusThreadPoolUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {
    private static BroadcastReceiver acY;
    private static final SparseArray<BdLightappKernelJsCallback> b = new SparseArray<>();

    public static String a() {
        return Locale.getDefault().getLanguage();
    }

    public static void a(String str, String str2, BdLightappKernelJsCallback.a aVar) {
        File externalFilesDir;
        BdLightappKernelJsCallback bdLightappKernelJsCallback = new BdLightappKernelJsCallback(str, str2);
        bdLightappKernelJsCallback.setCallbackListener(aVar);
        bdLightappKernelJsCallback.setParam("device_info");
        final com.baidu.browser.sailor.util.c cVar = new com.baidu.browser.sailor.util.c();
        Context appContext = BdSailorPlatform.getInstance().getAppContext();
        final c cVar2 = new c(bdLightappKernelJsCallback);
        final Context applicationContext = appContext.getApplicationContext();
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", ((TelephonyManager) applicationContext.getSystemService("phone")).getDeviceId());
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put(SapiContext.KEY_SDK_VERSION, Build.VERSION.SDK_INT);
            jSONObject.put(HttpConstants.HTTP_MANUFACTURER, Build.MANUFACTURER);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("serial_number", Settings.Secure.getString(appContext.getContentResolver(), "android_id"));
            jSONObject.put(TableDefine.UserInfoColumns.COLUMN_IP, com.baidu.browser.sailor.util.c.a());
            WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
            jSONObject.put("wifi_mac", connectionInfo != null ? connectionInfo.getMacAddress() : "");
            long[] jArr = new long[2];
            if (Environment.getExternalStorageState().equals("mounted") && WebKitFactory.getContext() != null && (externalFilesDir = WebKitFactory.getContext().getExternalFilesDir("")) != null) {
                StatFs statFs = new StatFs(externalFilesDir.getPath());
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
                        jSONObject3.put(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, -1));
                        jSONObject3.put("scale", intent.getIntExtra("scale", -1));
                        jSONObject.put("battery", jSONObject3);
                        applicationContext.unregisterReceiver(this);
                        if (cVar2 != null) {
                            cVar2.a(jSONObject);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        applicationContext.unregisterReceiver(this);
                        if (cVar2 != null) {
                            cVar2.a(jSONObject);
                        }
                    }
                } catch (Throwable th) {
                    applicationContext.unregisterReceiver(this);
                    if (cVar2 != null) {
                        cVar2.a(jSONObject);
                    }
                    throw th;
                }
            }
        }, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public static void a(String str, String str2, String str3, String str4, BdLightappKernelJsCallback.a aVar, String str5, String str6) {
        BdLightappKernelJsCallback bdLightappKernelJsCallback = new BdLightappKernelJsCallback(str3, str4);
        bdLightappKernelJsCallback.setCallbackListener(aVar);
        Log.i("BdWebappNativeAbility", "post file params:" + str2);
        ZeusThreadPoolUtil.execute(new b(str, str6, bdLightappKernelJsCallback, str2, str5));
    }

    public static void b() {
        if (acY != null) {
            BdSailorPlatform.getInstance().getAppContext().unregisterReceiver(acY);
            acY = null;
        }
    }

    public static void b(String str, String str2, BdLightappKernelJsCallback.a aVar) {
        String str3;
        BdLightappKernelJsCallback bdLightappKernelJsCallback = new BdLightappKernelJsCallback(str, str2);
        bdLightappKernelJsCallback.setCallbackListener(aVar);
        ConnectivityManager connectivityManager = (ConnectivityManager) BdSailorPlatform.getInstance().getAppContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            bdLightappKernelJsCallback.sendCallBack("net_result", "lightapp.device.CONNECT_UNKNOWN", false);
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
            bdLightappKernelJsCallback.sendCallBack("net_result", str3, true);
        }
        str3 = "lightapp.device.CONNECT_NONE";
        bdLightappKernelJsCallback.sendCallBack("net_result", str3, true);
    }

    public static void c(String str, String str2, BdLightappKernelJsCallback.a aVar) {
        BdLightappKernelJsCallback bdLightappKernelJsCallback = new BdLightappKernelJsCallback(str, str2);
        bdLightappKernelJsCallback.setCallbackListener(aVar);
        b.put(10, bdLightappKernelJsCallback);
        if (acY == null) {
            acY = new d();
        }
        BdSailorPlatform.getInstance().getAppContext().registerReceiver(acY, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public static void d(String str, String str2, BdLightappKernelJsCallback.a aVar) {
        BdLightappKernelJsCallback bdLightappKernelJsCallback = new BdLightappKernelJsCallback(str, str2);
        bdLightappKernelJsCallback.setCallbackListener(aVar);
        if (b.get(10) == null) {
            bdLightappKernelJsCallback.sendFailCallBack("not start yet");
            return;
        }
        b.remove(10);
        if (acY == null) {
            bdLightappKernelJsCallback.sendFailCallBack("not start yet");
            return;
        }
        BdSailorPlatform.getInstance().getAppContext().unregisterReceiver(acY);
        acY = null;
        bdLightappKernelJsCallback.sendSuccCallBack();
    }

    public static void e(String str, String str2, BdLightappKernelJsCallback.a aVar) {
        BdLightappKernelJsCallback bdLightappKernelJsCallback = new BdLightappKernelJsCallback(str, str2);
        bdLightappKernelJsCallback.setCallbackListener(aVar);
        final com.baidu.browser.sailor.util.c cVar = new com.baidu.browser.sailor.util.c();
        Context appContext = BdSailorPlatform.getInstance().getAppContext();
        final e eVar = new e(bdLightappKernelJsCallback);
        final Context applicationContext = appContext.getApplicationContext();
        applicationContext.registerReceiver(new BroadcastReceiver() { // from class: com.baidu.browser.sailor.util.BdDeviceInfo$2
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                JSONObject jSONObject = new JSONObject();
                try {
                    try {
                        jSONObject.put(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, -1));
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
