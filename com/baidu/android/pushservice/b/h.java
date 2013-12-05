package com.baidu.android.pushservice.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.w;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.loctp.str.BDLocManager;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends k {
    private static int d = 4;
    private static h e = null;
    private String c;

    public h(Context context) {
        super(context);
        this.c = "LbsSender";
        this.b = w.h;
    }

    public static h a(Context context) {
        if (e == null) {
            e = new h(context);
        }
        return e;
    }

    private String h() {
        String bssid = ((WifiManager) this.f703a.getSystemService("wifi")).getConnectionInfo().getBSSID();
        if (TextUtils.isEmpty(bssid)) {
            TelephonyManager telephonyManager = (TelephonyManager) this.f703a.getSystemService("phone");
            CellLocation cellLocation = telephonyManager.getCellLocation();
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                return gsmCellLocation.getCid() + "" + gsmCellLocation.getLac();
            } else if (cellLocation instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
                cdmaCellLocation.getNetworkId();
                int baseStationId = cdmaCellLocation.getBaseStationId();
                int networkId = cdmaCellLocation.getNetworkId();
                return baseStationId + "" + networkId + "" + cdmaCellLocation.getSystemId();
            } else {
                return "";
            }
        }
        return bssid;
    }

    @Override // com.baidu.android.pushservice.b.k
    void a(String str, List list) {
        list.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "uploadGeo"));
        if (com.baidu.android.pushservice.b.a(this.f703a)) {
            Log.d(this.c, "Sending LBS data: " + str);
        }
        list.add(new BasicNameValuePair("data", str));
    }

    @Override // com.baidu.android.pushservice.b.k
    boolean a() {
        return true;
    }

    @Override // com.baidu.android.pushservice.b.k
    String b() {
        String a2 = PushSettings.a();
        if (!TextUtils.isEmpty(a2)) {
            String locString = new BDLocManager(this.f703a.getApplicationContext()).getLocString(d);
            String h = h();
            if (!TextUtils.isEmpty(locString)) {
                String string = Settings.System.getString(this.f703a.getContentResolver(), "com.baidu.android.pushservice.lac");
                if (!TextUtils.isEmpty(h)) {
                    if (TextUtils.equals(h, string)) {
                        if (com.baidu.android.pushservice.b.a(this.f703a)) {
                            Log.i(this.c, "lbsinfo equals");
                        }
                        PushSettings.b(System.currentTimeMillis());
                        return null;
                    }
                    if (com.baidu.android.pushservice.b.a(this.f703a)) {
                        Log.i(this.c, "lbsinfo not the same");
                    }
                    Settings.System.putString(this.f703a.getContentResolver(), "com.baidu.android.pushservice.lac", h);
                }
                String f = f();
                int indexOf = f.indexOf(37);
                if (f != null && indexOf != -1) {
                    f = f.substring(0, indexOf);
                }
                String str = f == null ? "" : f;
                com.baidu.android.pushservice.a a3 = com.baidu.android.pushservice.a.a(this.f703a);
                new ArrayList();
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                ArrayList arrayList = a3.b;
                for (int i = 0; i < arrayList.size(); i++) {
                    if (!TextUtils.isEmpty(((com.baidu.android.pushservice.d) arrayList.get(i)).b)) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("userid", com.baidu.android.pushservice.util.m.b(((com.baidu.android.pushservice.d) arrayList.get(i)).c));
                            jSONObject2.put("appid", ((com.baidu.android.pushservice.d) arrayList.get(i)).b);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        jSONArray.put(jSONObject2);
                    }
                }
                ArrayList arrayList2 = a3.f693a;
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    String str2 = ((com.baidu.android.pushservice.d) arrayList2.get(i2)).b;
                    if (!TextUtils.isEmpty(str2) && !a3.c(str2)) {
                        Log.d(this.c, ((com.baidu.android.pushservice.d) arrayList2.get(i2)).c + ":" + ((com.baidu.android.pushservice.d) arrayList2.get(i2)).b);
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put("userid", com.baidu.android.pushservice.util.m.b(((com.baidu.android.pushservice.d) arrayList2.get(i2)).c));
                            jSONObject3.put("appid", ((com.baidu.android.pushservice.d) arrayList2.get(i2)).b);
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        jSONArray.put(jSONObject3);
                    }
                }
                if (jSONArray.length() > 0) {
                    try {
                        jSONObject.put("channelid", a2);
                        jSONObject.put(SocialConstants.PARAM_CUID, CommonParam.getCUID(this.f703a));
                        jSONObject.put("nettype", com.baidu.android.pushservice.util.m.r(this.f703a.getApplicationContext()));
                        jSONObject.put("clients", jSONArray);
                        jSONObject.put("apinfo", locString);
                        jSONObject.put("cip", str);
                        jSONObject.put("model", Build.MODEL);
                        jSONObject.put("version", Build.VERSION.RELEASE);
                        jSONObject.put("sdkversion", 13);
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                    return jSONObject.toString();
                }
            }
        }
        return null;
    }

    @Override // com.baidu.android.pushservice.b.k
    void c() {
        if (com.baidu.android.pushservice.b.a(this.f703a)) {
            Log.i(this.c, "<<< Location info send result return OK!");
        }
        PushSettings.b(System.currentTimeMillis());
    }

    @Override // com.baidu.android.pushservice.b.k
    void d() {
        if (com.baidu.android.pushservice.b.a(this.f703a)) {
            Log.i(this.c, "<<< Location info send result failed!");
        }
    }

    @Override // com.baidu.android.pushservice.b.k
    boolean e() {
        return true;
    }

    public String f() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException e2) {
            Log.e(this.c, e2.toString());
        }
        return "";
    }
}
