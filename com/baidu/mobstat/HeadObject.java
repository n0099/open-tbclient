package com.baidu.mobstat;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class HeadObject {
    public String A;
    public int B;
    public String D;
    public String b;
    public String c;
    public String h;
    public String i;
    public int j;
    public int k;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public JSONObject y;
    public JSONObject z;
    public boolean a = false;
    public String d = "0";
    public String e = null;
    public String f = null;
    public int g = -1;
    public String l = null;
    public String C = "";
    public String E = "";

    private synchronized void a(Context context) {
        String str;
        if (this.a) {
            return;
        }
        bn.e(context, com.kuaishou.weapon.p0.h.c);
        bn.e(context, com.kuaishou.weapon.p0.h.a);
        bn.e(context, "android.permission.ACCESS_NETWORK_STATE");
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        this.b = CooperService.instance().getOSVersion();
        this.c = CooperService.instance().getOSSysVersion();
        this.n = CooperService.instance().getPhoneModel();
        this.o = CooperService.instance().getManufacturer();
        this.x = CooperService.instance().getUUID();
        this.y = CooperService.instance().getHeaderExt(context);
        this.z = CooperService.instance().getPushId(context);
        this.f = CooperService.instance().getCUID(context, true);
        this.i = CooperService.instance().getDeviceId(telephonyManager, context);
        if (bp.a().i(context)) {
            str = "1";
        } else {
            str = "0";
        }
        this.d = str;
        if (bw.u(context)) {
            this.d = "2";
        }
        this.d += "-26";
        if (bu.a().d()) {
            try {
                this.q = CooperService.instance().getPhoneAddress(context, CooperService.instance().isDeviceMacEnabled(context));
            } catch (Exception unused) {
            }
            try {
                this.s = bw.l(2, context);
            } catch (Exception unused2) {
            }
        }
        try {
            this.t = bw.a(context, 2);
        } catch (Exception unused3) {
        }
        try {
            this.m = CooperService.instance().getOperator(telephonyManager);
        } catch (Exception unused4) {
        }
        try {
            this.j = bw.c(context);
            this.k = bw.d(context);
            if (context.getResources().getConfiguration().orientation == 2) {
                int i = this.j ^ this.k;
                this.j = i;
                int i2 = this.k ^ i;
                this.k = i2;
                this.j = i ^ i2;
            }
        } catch (Exception unused5) {
        }
        this.l = CooperService.instance().getAppChannel(context);
        this.e = CooperService.instance().getAppKey(context);
        try {
            this.g = CooperService.instance().getAppVersionCode(context);
            this.h = CooperService.instance().getAppVersionName(context);
        } catch (Exception unused6) {
        }
        try {
            this.p = CooperService.instance().getLinkedWay(context);
        } catch (Exception unused7) {
        }
        this.u = bw.b();
        this.v = android.os.Build.BOARD;
        this.w = android.os.Build.BRAND;
        this.A = CooperService.instance().getUserId(context);
        this.a = true;
        this.C = bp.a().u(context);
    }

    public synchronized void installHeader(Context context, JSONObject jSONObject) {
        a(context);
        if (jSONObject.length() > 10) {
            return;
        }
        updateHeader(context, jSONObject);
    }

    public void setHeaderExt(JSONObject jSONObject) {
        this.y = jSONObject;
    }

    public void setHeaderPy(String str) {
        this.E = str;
    }

    public void setPushInfo(JSONObject jSONObject) {
        this.z = jSONObject;
    }

    public void setStartType(boolean z) {
        if (z) {
            this.B = 1;
        } else {
            this.B = 0;
        }
    }

    public void setUserId(String str) {
        this.A = str;
    }

    public void setUserProperty(String str) {
        this.C = str;
    }

    public void setZid(String str) {
        this.D = str;
    }

    public synchronized void updateHeader(Context context, JSONObject jSONObject) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        Object obj12;
        Object obj13;
        Object obj14;
        Object obj15;
        Object obj16;
        Object obj17;
        Object obj18;
        Object obj19;
        JSONObject jSONObject2;
        try {
            jSONObject.put("o", "Android");
            int i = 0;
            jSONObject.put("st", 0);
            if (this.b == null) {
                obj = "";
            } else {
                obj = this.b;
            }
            jSONObject.put("s", obj);
            if (this.c == null) {
                obj2 = "";
            } else {
                obj2 = this.c;
            }
            jSONObject.put("sv", obj2);
            if (this.e == null) {
                obj3 = "";
            } else {
                obj3 = this.e;
            }
            jSONObject.put("k", obj3);
            if (this.d == null) {
                obj4 = "0";
            } else {
                obj4 = this.d;
            }
            jSONObject.put("pt", obj4);
            jSONObject.put("i", "");
            jSONObject.put("v", "4.0.9.7");
            jSONObject.put(Config.STAT_SDK_CHANNEL, 26);
            jSONObject.put("a", this.g);
            if (this.h == null) {
                obj5 = "";
            } else {
                obj5 = this.h;
            }
            jSONObject.put("n", obj5);
            jSONObject.put("d", "");
            if (this.q == null) {
                obj6 = "";
            } else {
                obj6 = this.q;
            }
            jSONObject.put(Config.DEVICE_MAC_ID, obj6);
            if (this.s == null) {
                obj7 = "";
            } else {
                obj7 = this.s;
            }
            jSONObject.put(Config.DEVICE_BLUETOOTH_MAC, obj7);
            if (this.i == null) {
                obj8 = "";
            } else {
                obj8 = this.i;
            }
            jSONObject.put(Config.DEVICE_ID_SEC, obj8);
            if (this.f == null) {
                obj9 = "";
            } else {
                obj9 = this.f;
            }
            jSONObject.put(Config.CUID_SEC, obj9);
            jSONObject.put(Config.SDK_TAG, 2);
            jSONObject.put("w", this.j);
            jSONObject.put("h", this.k);
            if (this.t == null) {
                obj10 = "";
            } else {
                obj10 = this.t;
            }
            jSONObject.put("dn", obj10);
            if (this.l == null) {
                obj11 = "";
            } else {
                obj11 = this.l;
            }
            jSONObject.put("c", obj11);
            if (this.m == null) {
                obj12 = "";
            } else {
                obj12 = this.m;
            }
            jSONObject.put("op", obj12);
            if (this.n == null) {
                obj13 = "";
            } else {
                obj13 = this.n;
            }
            jSONObject.put("m", obj13);
            if (this.o == null) {
                obj14 = "";
            } else {
                obj14 = this.o;
            }
            jSONObject.put("ma", obj14);
            if (this.p == null) {
                obj15 = "";
            } else {
                obj15 = this.p;
            }
            jSONObject.put("l", obj15);
            jSONObject.put("t", System.currentTimeMillis());
            jSONObject.put("pn", bw.n(2, context));
            if (this.u == null) {
                obj16 = "";
            } else {
                obj16 = this.u;
            }
            jSONObject.put(Config.ROM, obj16);
            if (this.v == null) {
                obj17 = "";
            } else {
                obj17 = this.v;
            }
            jSONObject.put(Config.DEVICE_BOARD, obj17);
            if (this.w == null) {
                obj18 = "";
            } else {
                obj18 = this.w;
            }
            jSONObject.put(Config.DEVICE_BRAND, obj18);
            jSONObject.put("td", bw.b(context));
            if (context != null && context.getApplicationInfo() != null) {
                i = context.getApplicationInfo().targetSdkVersion;
            }
            jSONObject.put(Config.TARGET_SDK_VERSION, i);
            jSONObject.put(Config.USER_PROPERTY, this.C);
            jSONObject.put(Config.OAID, bw.b(2, context));
            jSONObject.put(Config.OUT_OAID, bw.c(2, context));
            jSONObject.put("from", "0");
            jSONObject.put(Config.GAID, bw.e(2, context));
            jSONObject.put("iid", bw.d(2, context));
            jSONObject.put(Config.CUID3, bw.f(2, context));
            jSONObject.put(Config.SSAID, bw.g(2, context));
            jSONObject.put(Config.PY, this.E);
            jSONObject.put(Config.PLT, CooperService.instance().getPlatformType());
            jSONObject.put("im", bw.w(context));
            if (!TextUtils.isEmpty(this.A)) {
                if (!TextUtils.isEmpty(this.C)) {
                    jSONObject2 = new JSONObject(this.C);
                } else {
                    jSONObject2 = new JSONObject();
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(this.A);
                jSONArray.put("1");
                jSONObject2.put("uid_", jSONArray);
                jSONObject.put(Config.USER_PROPERTY, jSONObject2.toString());
            }
            jSONObject.put(Config.UID_CHANGE, "");
            jSONObject.put("at", "0");
            String s = bw.s(context);
            jSONObject.put(Config.PROCESS_LABEL, s);
            Object obj20 = null;
            if (!TextUtils.isEmpty(s)) {
                obj20 = bw.t(context);
            }
            if (obj20 == null) {
                obj20 = "";
            }
            jSONObject.put(Config.PROCESS_CLASS, obj20);
            if (this.x == null) {
                obj19 = "";
            } else {
                obj19 = this.x;
            }
            jSONObject.put("sign", obj19);
            if (this.y != null && this.y.length() != 0) {
                jSONObject.put("ext", this.y);
            } else {
                jSONObject.remove("ext");
            }
            if (this.z == null) {
                this.z = new JSONObject();
            }
            jSONObject.put("push", this.z);
            jSONObject.put("uid", this.A);
            jSONObject.put(Config.START_TYPE, String.valueOf(this.B));
        } catch (Exception unused) {
        }
    }
}
