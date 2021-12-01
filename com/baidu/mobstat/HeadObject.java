package com.baidu.mobstat;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class HeadObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject A;
    public JSONObject B;
    public String C;
    public int D;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f36895b;

    /* renamed from: c  reason: collision with root package name */
    public String f36896c;

    /* renamed from: d  reason: collision with root package name */
    public String f36897d;

    /* renamed from: e  reason: collision with root package name */
    public String f36898e;

    /* renamed from: f  reason: collision with root package name */
    public String f36899f;

    /* renamed from: g  reason: collision with root package name */
    public int f36900g;

    /* renamed from: h  reason: collision with root package name */
    public String f36901h;

    /* renamed from: i  reason: collision with root package name */
    public String f36902i;

    /* renamed from: j  reason: collision with root package name */
    public int f36903j;

    /* renamed from: k  reason: collision with root package name */
    public int f36904k;
    public String l;
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
    public String y;
    public String z;

    public HeadObject() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f36897d = "0";
        this.f36898e = null;
        this.f36899f = null;
        this.f36900g = -1;
        this.l = null;
    }

    private synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, context) == null) {
            synchronized (this) {
                if (this.a) {
                    return;
                }
                bo.e(context, com.kuaishou.weapon.un.s.f56838c);
                bo.e(context, com.kuaishou.weapon.un.s.a);
                bo.e(context, "android.permission.ACCESS_NETWORK_STATE");
                bo.e(context, "android.permission.WRITE_SETTINGS");
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                this.f36895b = CooperService.instance().getOSVersion();
                this.f36896c = CooperService.instance().getOSSysVersion();
                this.n = CooperService.instance().getPhoneModel();
                this.o = CooperService.instance().getManufacturer();
                this.z = CooperService.instance().getUUID();
                this.A = CooperService.instance().getHeaderExt(context);
                this.B = CooperService.instance().getPushId(context);
                this.f36902i = CooperService.instance().getDeviceId(telephonyManager, context);
                this.f36897d = bq.a().i(context) ? "1" : "0";
                if (bw.w(context)) {
                    this.f36897d = "2";
                }
                this.f36897d += EventType.PayEventID.QUERY_USER_YB_DETAIL_FAIL;
                try {
                    this.s = CooperService.instance().getMacAddress(context, CooperService.instance().isDeviceMacEnabled(context));
                } catch (Exception unused) {
                }
                try {
                    this.u = bw.f(1, context);
                } catch (Exception unused2) {
                }
                try {
                    this.v = bw.a(context, 1);
                } catch (Exception unused3) {
                }
                this.f36899f = CooperService.instance().getCUID(context, true);
                try {
                    this.m = CooperService.instance().getOperator(telephonyManager);
                } catch (Exception unused4) {
                }
                try {
                    this.f36903j = bw.c(context);
                    this.f36904k = bw.d(context);
                    if (context.getResources().getConfiguration().orientation == 2) {
                        int i2 = this.f36903j ^ this.f36904k;
                        this.f36903j = i2;
                        int i3 = this.f36904k ^ i2;
                        this.f36904k = i3;
                        this.f36903j = i2 ^ i3;
                    }
                } catch (Exception unused5) {
                }
                this.l = CooperService.instance().getAppChannel(context);
                this.f36898e = CooperService.instance().getAppKey(context);
                try {
                    this.f36900g = CooperService.instance().getAppVersionCode(context);
                    this.f36901h = CooperService.instance().getAppVersionName(context);
                } catch (Exception unused6) {
                }
                try {
                    if (CooperService.instance().checkCellLocationSetting(context)) {
                        this.p = bw.i(context);
                    } else {
                        this.p = "0_0_0";
                    }
                } catch (Exception unused7) {
                }
                try {
                    if (CooperService.instance().checkGPSLocationSetting(context)) {
                        this.q = bw.j(context);
                    } else {
                        this.q = "";
                    }
                } catch (Exception unused8) {
                }
                try {
                    this.r = CooperService.instance().getLinkedWay(context);
                } catch (Exception unused9) {
                }
                this.w = bw.b();
                this.x = android.os.Build.BOARD;
                this.y = android.os.Build.BRAND;
                this.C = CooperService.instance().getUserId(context);
                this.a = true;
            }
        }
    }

    public synchronized void installHeader(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, jSONObject) == null) {
            synchronized (this) {
                a(context);
                if (jSONObject.length() > 10) {
                    return;
                }
                updateHeader(context, jSONObject);
            }
        }
    }

    public void setHeaderExt(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            this.A = jSONObject;
        }
    }

    public void setPushInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            this.B = jSONObject;
        }
    }

    public void setStartType(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.D = 1;
            } else {
                this.D = 0;
            }
        }
    }

    public void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.C = str;
        }
    }

    public synchronized void updateHeader(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, jSONObject) == null) {
            synchronized (this) {
                try {
                    jSONObject.put("o", "Android");
                    int i2 = 0;
                    jSONObject.put("st", 0);
                    jSONObject.put("s", this.f36895b == null ? "" : this.f36895b);
                    jSONObject.put("sv", this.f36896c == null ? "" : this.f36896c);
                    jSONObject.put("k", this.f36898e == null ? "" : this.f36898e);
                    jSONObject.put("pt", this.f36897d == null ? "0" : this.f36897d);
                    jSONObject.put("i", "");
                    jSONObject.put("v", "3.9.5.1");
                    jSONObject.put("sc", 14);
                    jSONObject.put("a", this.f36900g);
                    jSONObject.put("n", this.f36901h == null ? "" : this.f36901h);
                    jSONObject.put("d", "");
                    jSONObject.put("mc", this.s == null ? "" : this.s);
                    jSONObject.put("bm", this.u == null ? "" : this.u);
                    jSONObject.put("dd", this.f36902i == null ? "" : this.f36902i);
                    jSONObject.put("ii", this.f36899f == null ? "" : this.f36899f);
                    jSONObject.put("tg", 1);
                    jSONObject.put("w", this.f36903j);
                    jSONObject.put("h", this.f36904k);
                    jSONObject.put("dn", this.v == null ? "" : this.v);
                    jSONObject.put("c", this.l == null ? "" : this.l);
                    jSONObject.put("op", this.m == null ? "" : this.m);
                    jSONObject.put("m", this.n == null ? "" : this.n);
                    jSONObject.put("ma", this.o == null ? "" : this.o);
                    jSONObject.put("cl", this.p);
                    jSONObject.put("gl", this.q == null ? "" : this.q);
                    jSONObject.put("l", this.r == null ? "" : this.r);
                    jSONObject.put("t", System.currentTimeMillis());
                    jSONObject.put("pn", bw.h(1, context));
                    jSONObject.put("rom", this.w == null ? "" : this.w);
                    jSONObject.put("bo", this.x == null ? "" : this.x);
                    jSONObject.put("bd", this.y == null ? "" : this.y);
                    jSONObject.put("td", bw.b(context));
                    if (context != null && context.getApplicationInfo() != null) {
                        i2 = context.getApplicationInfo().targetSdkVersion;
                    }
                    jSONObject.put("tv", i2);
                    jSONObject.put("at", "0");
                    String u = bw.u(context);
                    jSONObject.put("pl", u);
                    Object v = TextUtils.isEmpty(u) ? null : bw.v(context);
                    if (v == null) {
                        v = "";
                    }
                    jSONObject.put("scl", v);
                    jSONObject.put("sign", this.z == null ? "" : this.z);
                    if (this.A != null && this.A.length() != 0) {
                        jSONObject.put("ext", this.A);
                    } else {
                        jSONObject.remove("ext");
                    }
                    if (this.B == null) {
                        this.B = new JSONObject();
                    }
                    jSONObject.put("push", this.B);
                    jSONObject.put("uid", this.C);
                    jSONObject.put("startType", String.valueOf(this.D));
                } catch (Exception unused) {
                }
            }
        }
    }
}
