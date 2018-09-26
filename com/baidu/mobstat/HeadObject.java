package com.baidu.mobstat;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class HeadObject {
    JSONObject A;
    JSONObject B;
    String C;
    String b;
    String c;
    String h;
    String i;
    int j;
    int k;
    String m;
    String n;
    String o;
    String p;
    String q;
    String r;
    String s;
    String t;
    String u;
    String v;
    String w;
    String x;
    String y;
    String z;
    boolean a = false;
    String d = "0";
    String e = null;
    String f = null;
    int g = -1;
    String l = null;

    public synchronized void installHeader(Context context, JSONObject jSONObject) {
        a(context);
        if (jSONObject.length() <= 10) {
            updateHeader(context, jSONObject);
        }
    }

    private synchronized void a(Context context) {
        if (!this.a) {
            bv.e(context, "android.permission.READ_PHONE_STATE");
            bv.e(context, "android.permission.INTERNET");
            bv.e(context, "android.permission.ACCESS_NETWORK_STATE");
            bv.e(context, "android.permission.WRITE_SETTINGS");
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            this.b = CooperService.instance().getOSVersion();
            this.c = CooperService.instance().getOSSysVersion();
            this.n = CooperService.instance().getPhoneModel();
            this.o = CooperService.instance().getManufacturer();
            this.z = CooperService.instance().getUUID();
            this.A = CooperService.instance().getHeaderExt(context);
            this.B = CooperService.instance().getPushId(context);
            this.i = CooperService.instance().getDeviceId(telephonyManager, context);
            this.d = BasicStoreTools.getInstance().getForTV(context) ? "1" : "0";
            if (cc.w(context)) {
                this.d = "2";
            }
            this.d += "-0";
            try {
                this.s = CooperService.instance().getMacAddress(context, CooperService.instance().isDeviceMacEnabled(context));
            } catch (Exception e) {
            }
            try {
                this.u = cc.f(1, context);
            } catch (Exception e2) {
            }
            try {
                this.v = cc.a(context, 1);
            } catch (Exception e3) {
            }
            this.f = CooperService.instance().getCUID(context, true);
            try {
                this.m = CooperService.instance().getOperator(telephonyManager);
            } catch (Exception e4) {
            }
            try {
                this.j = cc.c(context);
                this.k = cc.d(context);
                if (context.getResources().getConfiguration().orientation == 2) {
                    this.j ^= this.k;
                    this.k = this.j ^ this.k;
                    this.j ^= this.k;
                }
            } catch (Exception e5) {
            }
            this.l = CooperService.instance().getAppChannel(context);
            this.e = CooperService.instance().getAppKey(context);
            try {
                this.g = CooperService.instance().getAppVersionCode(context);
                this.h = CooperService.instance().getAppVersionName(context);
            } catch (Exception e6) {
            }
            try {
                if (CooperService.instance().checkCellLocationSetting(context)) {
                    this.p = cc.i(context);
                } else {
                    this.p = "0_0_0";
                }
            } catch (Exception e7) {
            }
            try {
                if (CooperService.instance().checkGPSLocationSetting(context)) {
                    this.q = cc.j(context);
                } else {
                    this.q = "";
                }
            } catch (Exception e8) {
            }
            try {
                this.r = CooperService.instance().getLinkedWay(context);
            } catch (Exception e9) {
            }
            this.w = cc.b();
            this.x = android.os.Build.BOARD;
            this.y = android.os.Build.BRAND;
            this.C = CooperService.instance().getUserId(context);
            this.a = true;
        }
    }

    public synchronized void updateHeader(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(Config.OS, "Android" == 0 ? "" : "Android");
            jSONObject.put("st", 0);
            jSONObject.put("s", this.b == null ? "" : this.b);
            jSONObject.put("sv", this.c == null ? "" : this.c);
            jSONObject.put(Config.APP_KEY, this.e == null ? "" : this.e);
            jSONObject.put(Config.PLATFORM_TYPE, this.d == null ? "0" : this.d);
            jSONObject.put("i", "");
            jSONObject.put("v", "3.9.2.0");
            jSONObject.put(Config.STAT_SDK_CHANNEL, 0);
            jSONObject.put(Config.APP_VERSION_CODE, this.g);
            jSONObject.put("n", this.h == null ? "" : this.h);
            jSONObject.put("d", "");
            jSONObject.put(Config.DEVICE_MAC_ID, this.s == null ? "" : this.s);
            jSONObject.put(Config.DEVICE_BLUETOOTH_MAC, this.u == null ? "" : this.u);
            jSONObject.put(Config.DEVICE_ID_SEC, this.i == null ? "" : this.i);
            jSONObject.put(Config.CUID_SEC, this.f == null ? "" : this.f);
            jSONObject.put(Config.SDK_TAG, 1);
            jSONObject.put(Config.DEVICE_WIDTH, this.j);
            jSONObject.put("h", this.k);
            jSONObject.put(Config.DEVICE_NAME, this.v == null ? "" : this.v);
            jSONObject.put("c", this.l == null ? "" : this.l);
            jSONObject.put("op", this.m == null ? "" : this.m);
            jSONObject.put(Config.MODEL, this.n == null ? "" : this.n);
            jSONObject.put(Config.MANUFACTURER, this.o == null ? "" : this.o);
            jSONObject.put(Config.CELL_LOCATION, this.p);
            jSONObject.put(Config.GPS_LOCATION, this.q == null ? "" : this.q);
            jSONObject.put("l", this.r == null ? "" : this.r);
            jSONObject.put("t", System.currentTimeMillis());
            jSONObject.put(Config.PACKAGE_NAME, cc.h(1, context));
            jSONObject.put(Config.ROM, this.w == null ? "" : this.w);
            jSONObject.put(Config.DEVICE_BOARD, this.x == null ? "" : this.x);
            jSONObject.put(Config.DEVICE_BRAND, this.y == null ? "" : this.y);
            jSONObject.put("td", cc.b(context));
            jSONObject.put("at", "0");
            String u = cc.u(context);
            jSONObject.put(Config.PROCESS_LABEL, u);
            Object obj = null;
            if (!TextUtils.isEmpty(u)) {
                obj = cc.v(context);
            }
            if (obj == null) {
                obj = "";
            }
            jSONObject.put(Config.PROCESS_CLASS, obj);
            jSONObject.put("sign", this.z == null ? "" : this.z);
            if (this.A != null && this.A.length() != 0) {
                jSONObject.put("ext", this.A);
            } else {
                jSONObject.remove("ext");
            }
            if (this.B == null) {
                this.B = new JSONObject();
            }
            jSONObject.put(Config.PUSH, this.B);
            jSONObject.put("uid", this.C);
        } catch (Exception e) {
        }
    }

    public void setHeaderExt(JSONObject jSONObject) {
        this.A = jSONObject;
    }

    public void setPushInfo(JSONObject jSONObject) {
        this.B = jSONObject;
    }

    public void setUserId(String str) {
        this.C = str;
    }
}
