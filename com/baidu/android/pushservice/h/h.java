package com.baidu.android.pushservice.h;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.loctp.str.BDLocManager;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private static int a = 4;

    public static String a() {
        String str;
        try {
            String str2 = "";
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (!inetAddresses.hasMoreElements()) {
                        str = str2;
                        break;
                    }
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        str = nextElement.getHostAddress().toString();
                        break;
                    }
                }
                str2 = str;
            }
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            int indexOf = str2.indexOf(37);
            String substring = indexOf != -1 ? str2.substring(0, indexOf) : str2;
            return substring == null ? "" : substring;
        } catch (SocketException e) {
            com.baidu.android.pushservice.e.a.a("LbsUtils", e);
            return "";
        }
    }

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        return m.a(context, "com.baidu.android.pushservice.lbscache");
    }

    public static String a(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONObject.has("cityCode")) {
                jSONObject2.put("city_code", jSONObject.optString("cityCode"));
            }
            if (jSONObject.has("location")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("location");
                JSONObject jSONObject4 = new JSONObject();
                if (jSONObject3 != null) {
                    jSONObject4.put("latitude", jSONObject3.getString("lat"));
                    jSONObject4.put("longitude", jSONObject3.getString("lng"));
                }
                if (jSONObject.has("accuracy")) {
                    jSONObject4.put("accuracy", jSONObject.optString("accuracy"));
                }
                jSONObject2.put("location", jSONObject4);
            }
            if (jSONObject2 != null) {
                m.a(context, "com.baidu.android.pushservice.lbscache", jSONObject2.toString());
            }
            return jSONObject2.toString();
        } catch (JSONException e) {
            com.baidu.android.pushservice.e.a.a("LbsUtils", e);
            return null;
        }
    }

    public static String a(Context context, boolean z) {
        String a2 = PushSettings.a(context);
        if (!TextUtils.isEmpty(a2)) {
            String d = d(context);
            if (!TextUtils.isEmpty(d)) {
                if (!z && b(context) && !TextUtils.isEmpty(a(context))) {
                    return null;
                }
                String a3 = a();
                com.baidu.android.pushservice.b.b a4 = com.baidu.android.pushservice.b.b.a(context);
                new ArrayList();
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                ArrayList arrayList = (ArrayList) a4.a.clone();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    if (!TextUtils.isEmpty(((com.baidu.android.pushservice.b.f) arrayList.get(i2)).a())) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("userid", u.a(((com.baidu.android.pushservice.b.f) arrayList.get(i2)).f));
                            jSONObject2.put("appid", ((com.baidu.android.pushservice.b.f) arrayList.get(i2)).a());
                        } catch (Exception e) {
                            com.baidu.android.pushservice.e.a.a("LbsUtils", e);
                        }
                        jSONArray.put(jSONObject2);
                    }
                    i = i2 + 1;
                }
                if (jSONArray.length() > 0) {
                    try {
                        jSONObject.put("channelid", a2);
                        jSONObject.put("cuid", com.baidu.android.pushservice.i.e.a(context));
                        jSONObject.put("nettype", u.s(context.getApplicationContext()));
                        jSONObject.put("clients", jSONArray);
                        jSONObject.put("apinfo", d);
                        jSONObject.put("cip", a3);
                        jSONObject.put("model", Build.MODEL);
                        jSONObject.put("version", Build.VERSION.RELEASE);
                        jSONObject.put("sdkversion", (int) com.baidu.android.pushservice.a.a());
                        if (u.E(context)) {
                            jSONObject.put("connect_version", 3);
                        }
                    } catch (JSONException e2) {
                        com.baidu.android.pushservice.e.a.a("LbsUtils", e2);
                    }
                    return jSONObject.toString();
                }
            }
        }
        return null;
    }

    public static void a(Context context, long j) {
        m.a(context, "com.baidu.pushservice.clt", j);
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        String e = e(context);
        String a2 = m.a(context, "com.baidu.android.pushservice.lac");
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        if (TextUtils.equals(e, a2)) {
            a(context, System.currentTimeMillis());
            return true;
        }
        m.a(context, "com.baidu.android.pushservice.lac", e);
        return false;
    }

    public static long c(Context context) {
        if (context == null) {
            com.baidu.android.pushservice.e.a.e("LbsUtils", "getLastSendLbsTime mContext == null");
            return 0L;
        }
        return m.c(context, "com.baidu.pushservice.clt");
    }

    public static String d(Context context) {
        return new BDLocManager(context.getApplicationContext()).getLocString(a);
    }

    private static String e(Context context) {
        String bssid = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getBSSID();
        if (TextUtils.isEmpty(bssid)) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            CellLocation cellLocation = telephonyManager.getCellLocation();
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                return gsmCellLocation.getCid() + "" + gsmCellLocation.getLac();
            } else if (cellLocation instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
                int baseStationId = cdmaCellLocation.getBaseStationId();
                int networkId = cdmaCellLocation.getNetworkId();
                return baseStationId + "" + networkId + "" + cdmaCellLocation.getSystemId();
            } else {
                return "";
            }
        }
        return bssid;
    }
}
