package com.baidu.mobstat.dxmpay;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class HeadObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public JSONObject B;
    public JSONObject C;
    public String D;
    public int E;
    public String F;
    public String G;

    /* renamed from: a  reason: collision with root package name */
    public boolean f41466a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f41467b;

    /* renamed from: c  reason: collision with root package name */
    public String f41468c;

    /* renamed from: d  reason: collision with root package name */
    public String f41469d;

    /* renamed from: e  reason: collision with root package name */
    public String f41470e;

    /* renamed from: f  reason: collision with root package name */
    public String f41471f;

    /* renamed from: g  reason: collision with root package name */
    public String f41472g;

    /* renamed from: h  reason: collision with root package name */
    public int f41473h;

    /* renamed from: i  reason: collision with root package name */
    public String f41474i;
    public String j;
    public int k;
    public int l;
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
        this.f41466a = false;
        this.f41467b = false;
        this.f41470e = "0";
        this.f41471f = null;
        this.f41472g = null;
        this.f41473h = -1;
        this.m = null;
        this.F = "";
    }

    private synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, context) == null) {
            synchronized (this) {
                if (this.f41466a) {
                    return;
                }
                o.e(context, "android.permission.READ_PHONE_STATE");
                o.e(context, "android.permission.INTERNET");
                o.e(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION);
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                this.f41468c = CooperService.instance().getOSVersion();
                this.f41469d = CooperService.instance().getOSSysVersion();
                this.o = CooperService.instance().getPhoneModel();
                this.p = CooperService.instance().getManufacturer();
                this.A = CooperService.instance().getUUID();
                this.B = CooperService.instance().getHeaderExt(context);
                this.C = CooperService.instance().getPushId(context);
                this.j = CooperService.instance().getDeviceId(telephonyManager, context);
                this.f41470e = q.a().g(context) ? "1" : "0";
                if (w.m(context)) {
                    this.f41470e = "2";
                }
                this.f41470e += "-28";
                if (this.f41467b) {
                    try {
                        this.t = CooperService.instance().getMacAddress(context, CooperService.instance().isDeviceMacEnabled(context));
                    } catch (Exception unused) {
                    }
                    try {
                        this.v = w.k(2, context);
                    } catch (Exception unused2) {
                    }
                }
                this.f41472g = CooperService.instance().getCUID(context, true);
                try {
                    this.n = CooperService.instance().getOperator(telephonyManager);
                } catch (Exception unused3) {
                }
                try {
                    this.k = w.c(context);
                    this.l = w.d(context);
                    if (context.getResources().getConfiguration().orientation == 2) {
                        int i2 = this.k ^ this.l;
                        this.k = i2;
                        int i3 = this.l ^ i2;
                        this.l = i3;
                        this.k = i2 ^ i3;
                    }
                } catch (Exception unused4) {
                }
                this.m = CooperService.instance().getAppChannel(context);
                this.f41471f = CooperService.instance().getAppKey(context);
                try {
                    this.f41473h = CooperService.instance().getAppVersionCode(context);
                    this.f41474i = CooperService.instance().getAppVersionName(context);
                } catch (Exception unused5) {
                }
                try {
                    this.s = CooperService.instance().getLinkedWay(context);
                } catch (Exception unused6) {
                }
                this.x = w.b();
                this.y = android.os.Build.BOARD;
                this.z = android.os.Build.BRAND;
                this.D = CooperService.instance().getUserId(context);
                this.f41466a = true;
                this.F = q.a().n(context);
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

    public void setAuthorizedState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f41467b = z;
        }
    }

    public void setHeaderExt(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            this.B = jSONObject;
        }
    }

    public void setPushInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            this.C = jSONObject;
        }
    }

    public void setStartType(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.E = 1;
            } else {
                this.E = 0;
            }
        }
    }

    public void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.D = str;
        }
    }

    public void setUserProperty(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.F = str;
        }
    }

    public void setZid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.G = str;
        }
    }

    public synchronized void updateHeader(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, jSONObject) == null) {
            synchronized (this) {
                try {
                    jSONObject.put("o", "Android");
                    int i2 = 0;
                    jSONObject.put("st", 0);
                    jSONObject.put("s", this.f41468c == null ? "" : this.f41468c);
                    jSONObject.put("sv", this.f41469d == null ? "" : this.f41469d);
                    jSONObject.put("k", this.f41471f == null ? "" : this.f41471f);
                    jSONObject.put("pt", this.f41470e == null ? "0" : this.f41470e);
                    jSONObject.put("i", "");
                    jSONObject.put("v", "4.0.0.0");
                    jSONObject.put("sc", 28);
                    jSONObject.put("a", this.f41473h);
                    jSONObject.put("n", this.f41474i == null ? "" : this.f41474i);
                    jSONObject.put("d", "");
                    jSONObject.put("mc", this.t == null ? "" : this.t);
                    jSONObject.put("bm", this.v == null ? "" : this.v);
                    jSONObject.put("dd", this.j == null ? "" : this.j);
                    jSONObject.put("ii", this.f41472g == null ? "" : this.f41472g);
                    jSONObject.put("tg", 2);
                    jSONObject.put("w", this.k);
                    jSONObject.put("h", this.l);
                    jSONObject.put("dn", this.w == null ? "" : this.w);
                    jSONObject.put("c", this.m == null ? "" : this.m);
                    jSONObject.put("op", this.n == null ? "" : this.n);
                    jSONObject.put("m", this.o == null ? "" : this.o);
                    jSONObject.put("ma", this.p == null ? "" : this.p);
                    jSONObject.put("cl", this.q == null ? "" : this.q);
                    jSONObject.put("gl", this.r == null ? "" : this.r);
                    jSONObject.put("l", this.s == null ? "" : this.s);
                    jSONObject.put("t", System.currentTimeMillis());
                    jSONObject.put("pn", w.l(2, context));
                    jSONObject.put("rom", this.x == null ? "" : this.x);
                    jSONObject.put("bo", this.y == null ? "" : this.y);
                    jSONObject.put("bd", this.z == null ? "" : this.z);
                    jSONObject.put("td", w.b(context));
                    if (context != null && context.getApplicationInfo() != null) {
                        i2 = context.getApplicationInfo().targetSdkVersion;
                    }
                    jSONObject.put("tv", i2);
                    jSONObject.put(Config.USER_PROPERTY, this.F);
                    jSONObject.put(Config.OAID, w.a(2, context));
                    jSONObject.put(Config.OUT_OAID, w.b(2, context));
                    jSONObject.put("from", "0");
                    jSONObject.put(Config.GAID, w.d(2, context));
                    jSONObject.put("iid", w.c(2, context));
                    jSONObject.put(Config.CUID3, w.e(2, context));
                    jSONObject.put(Config.SSAID, w.f(2, context));
                    if (!TextUtils.isEmpty(this.D)) {
                        if (!TextUtils.isEmpty(this.F)) {
                            jSONObject2 = new JSONObject(this.F);
                        } else {
                            jSONObject2 = new JSONObject();
                        }
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(this.D);
                        jSONArray.put("1");
                        jSONObject2.put("uid_", jSONArray);
                        jSONObject.put(Config.USER_PROPERTY, jSONObject2.toString());
                    }
                    jSONObject.put(Config.UID_CHANGE, "");
                    jSONObject.put("at", "0");
                    String k = w.k(context);
                    jSONObject.put("pl", k);
                    Object l = TextUtils.isEmpty(k) ? null : w.l(context);
                    if (l == null) {
                        l = "";
                    }
                    jSONObject.put("scl", l);
                    jSONObject.put("sign", this.A == null ? "" : this.A);
                    if (this.B != null && this.B.length() != 0) {
                        jSONObject.put("ext", this.B);
                    } else {
                        jSONObject.remove("ext");
                    }
                    if (this.C == null) {
                        this.C = new JSONObject();
                    }
                    jSONObject.put("push", this.C);
                    jSONObject.put("uid", this.D);
                    jSONObject.put("startType", String.valueOf(this.E));
                } catch (Exception unused) {
                }
            }
        }
    }
}
