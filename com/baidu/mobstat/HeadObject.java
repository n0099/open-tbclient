package com.baidu.mobstat;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class HeadObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject A;
    public JSONObject B;
    public String C;
    public int D;

    /* renamed from: a  reason: collision with root package name */
    public boolean f43060a;

    /* renamed from: b  reason: collision with root package name */
    public String f43061b;

    /* renamed from: c  reason: collision with root package name */
    public String f43062c;

    /* renamed from: d  reason: collision with root package name */
    public String f43063d;

    /* renamed from: e  reason: collision with root package name */
    public String f43064e;

    /* renamed from: f  reason: collision with root package name */
    public String f43065f;

    /* renamed from: g  reason: collision with root package name */
    public int f43066g;

    /* renamed from: h  reason: collision with root package name */
    public String f43067h;

    /* renamed from: i  reason: collision with root package name */
    public String f43068i;

    /* renamed from: j  reason: collision with root package name */
    public int f43069j;
    public int k;
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
        this.f43060a = false;
        this.f43063d = "0";
        this.f43064e = null;
        this.f43065f = null;
        this.f43066g = -1;
        this.l = null;
    }

    private synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, context) == null) {
            synchronized (this) {
                if (this.f43060a) {
                    return;
                }
                bo.e(context, "android.permission.READ_PHONE_STATE");
                bo.e(context, "android.permission.INTERNET");
                bo.e(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION);
                bo.e(context, "android.permission.WRITE_SETTINGS");
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                this.f43061b = CooperService.instance().getOSVersion();
                this.f43062c = CooperService.instance().getOSSysVersion();
                this.n = CooperService.instance().getPhoneModel();
                this.o = CooperService.instance().getManufacturer();
                this.z = CooperService.instance().getUUID();
                this.A = CooperService.instance().getHeaderExt(context);
                this.B = CooperService.instance().getPushId(context);
                this.f43068i = CooperService.instance().getDeviceId(telephonyManager, context);
                this.f43063d = bq.a().i(context) ? "1" : "0";
                if (bw.w(context)) {
                    this.f43063d = "2";
                }
                this.f43063d += EventType.PayEventID.QUERY_USER_YB_DETAIL_FAIL;
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
                this.f43065f = CooperService.instance().getCUID(context, true);
                try {
                    this.m = CooperService.instance().getOperator(telephonyManager);
                } catch (Exception unused4) {
                }
                try {
                    this.f43069j = bw.c(context);
                    this.k = bw.d(context);
                    if (context.getResources().getConfiguration().orientation == 2) {
                        int i2 = this.f43069j ^ this.k;
                        this.f43069j = i2;
                        int i3 = this.k ^ i2;
                        this.k = i3;
                        this.f43069j = i2 ^ i3;
                    }
                } catch (Exception unused5) {
                }
                this.l = CooperService.instance().getAppChannel(context);
                this.f43064e = CooperService.instance().getAppKey(context);
                try {
                    this.f43066g = CooperService.instance().getAppVersionCode(context);
                    this.f43067h = CooperService.instance().getAppVersionName(context);
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
                this.f43060a = true;
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
                    jSONObject.put("s", this.f43061b == null ? "" : this.f43061b);
                    jSONObject.put("sv", this.f43062c == null ? "" : this.f43062c);
                    jSONObject.put("k", this.f43064e == null ? "" : this.f43064e);
                    jSONObject.put("pt", this.f43063d == null ? "0" : this.f43063d);
                    jSONObject.put("i", "");
                    jSONObject.put("v", "3.9.5.1");
                    jSONObject.put("sc", 14);
                    jSONObject.put("a", this.f43066g);
                    jSONObject.put("n", this.f43067h == null ? "" : this.f43067h);
                    jSONObject.put("d", "");
                    jSONObject.put("mc", this.s == null ? "" : this.s);
                    jSONObject.put("bm", this.u == null ? "" : this.u);
                    jSONObject.put("dd", this.f43068i == null ? "" : this.f43068i);
                    jSONObject.put("ii", this.f43065f == null ? "" : this.f43065f);
                    jSONObject.put("tg", 1);
                    jSONObject.put("w", this.f43069j);
                    jSONObject.put("h", this.k);
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
