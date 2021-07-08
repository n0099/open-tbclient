package com.baidu.apollon.statistics;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f3985a = "wifi";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3986b = "3G";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3987c = "time";

    /* renamed from: d  reason: collision with root package name */
    public static final String f3988d = "count";

    /* renamed from: e  reason: collision with root package name */
    public static final String f3989e = "now";

    /* renamed from: f  reason: collision with root package name */
    public static final String f3990f = "never";

    /* renamed from: g  reason: collision with root package name */
    public static final String f3991g = "now";

    /* renamed from: h  reason: collision with root package name */
    public static final String f3992h = "strategy_timestamp";

    /* renamed from: i  reason: collision with root package name */
    public static final int f3993i = 0;
    public static final int j = 200;
    public static final String k = "g";
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 3;
    public static final int o = 1;
    public static final int p = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public Context q;
    public JSONObject r;
    public JSONObject s;
    public boolean t;
    public byte[] u;
    public volatile int v;
    public volatile int w;
    public String[] x;
    public String[] y;
    public final String z;

    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final g f3994a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2081993573, "Lcom/baidu/apollon/statistics/g$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2081993573, "Lcom/baidu/apollon/statistics/g$a;");
                    return;
                }
            }
            f3994a = new g();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1906211262, "Lcom/baidu/apollon/statistics/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1906211262, "Lcom/baidu/apollon/statistics/g;");
        }
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.z = "{data:{disable:0,3G:5,wifi:1,now:[\"abandonPay\",\"schemePayEnter\",\"resultClickBtn\"],kf:{now:[],time:0,count:200}}}";
        this.u = new byte[0];
        this.v = 1;
        this.w = 5;
        this.t = true;
    }

    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f3994a : (g) invokeV.objValue;
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
            jSONObject.put(f3992h, System.currentTimeMillis());
            BasicStoreTools.getInstance().setStrategy(this.q, jSONObject.toString());
            this.r = jSONObject;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void f() {
        StatisticsSettings a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || (a2 = PayStatisticsUtil.getInstance().a()) == null) {
            return;
        }
        c(a2.getStrategy());
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            JSONObject jSONObject = this.r;
            if (jSONObject != null && jSONObject.has(f3992h)) {
                synchronized (this.u) {
                    JSONObject optJSONObject = this.r.optJSONObject("data");
                    if (optJSONObject == null) {
                        optJSONObject = this.r;
                    }
                    boolean z = true;
                    if (optJSONObject != null) {
                        this.v = optJSONObject.optInt("wifi", 1);
                        this.w = optJSONObject.optInt(f3986b, 5);
                        if (1 == optJSONObject.optInt(PackageTable.DISABLE, 0)) {
                            z = false;
                        }
                        this.t = z;
                        JSONArray optJSONArray = optJSONObject.optJSONArray("now");
                        this.x = optJSONArray == null ? new String[0] : new String[optJSONArray.length()];
                        if (optJSONArray != null) {
                            for (int i2 = 0; i2 < this.x.length; i2++) {
                                this.x[i2] = optJSONArray.optString(i2);
                            }
                        }
                        Arrays.sort(this.x);
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray(f3990f);
                        this.y = optJSONArray2 == null ? new String[0] : new String[optJSONArray2.length()];
                        for (int i3 = 0; i3 < this.y.length; i3++) {
                            this.y[i3] = optJSONArray2.optString(i3);
                        }
                        Arrays.sort(this.y);
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject(CustomerService.sMarkString);
                        if (optJSONObject2 != null) {
                            CustomerService.getInstance().setConfig(optJSONObject2.optInt("time", 0) * 1000, optJSONObject2.optInt("count", 200));
                            this.s = optJSONObject2.optJSONObject("now");
                        } else {
                            a(2);
                        }
                    } else {
                        a(1);
                        a(2);
                    }
                }
                return;
            }
            a(3);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = this.r;
            if (jSONObject == null || !jSONObject.has(f3992h)) {
                return true;
            }
            try {
                j2 = this.r.getLong(f3992h);
            } catch (Exception e2) {
                e2.printStackTrace();
                j2 = 0;
            }
            long currentTimeMillis = System.currentTimeMillis() - j2;
            return 86400000 < currentTimeMillis || 0 > currentTimeMillis;
        }
        return invokeV.booleanValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.w : invokeV.intValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.t : invokeV.booleanValue;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            synchronized (this.u) {
                if ((i2 & 1) != 0) {
                    this.x = new String[]{"abandonPay", StatServiceEvent.SCHEME_PAY_ENTER, StatServiceEvent.RESULT_CLICK_BTN};
                    this.y = new String[0];
                    this.t = true;
                    this.w = 5;
                    this.v = 1;
                }
                if ((i2 & 2) != 0) {
                    this.s = null;
                    CustomerService.getInstance().setConfig(0, 200);
                }
            }
            if (3 == (i2 & 3)) {
                try {
                    this.r = (JSONObject) new JSONTokener("{data:{disable:0,3G:5,wifi:1,now:[\"abandonPay\",\"schemePayEnter\",\"resultClickBtn\"],kf:{now:[],time:0,count:200}}}").nextValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            synchronized (this.u) {
                z = false;
                if (this.y != null && this.y.length > 0) {
                    try {
                        z = Arrays.binarySearch(this.y, str) >= 0;
                    } catch (Exception unused) {
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.v : invokeV.intValue;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            if (this.q == null && context != null) {
                this.q = context.getApplicationContext();
            }
            if (this.q == null) {
                return;
            }
            String strategy = BasicStoreTools.getInstance().getStrategy(this.q);
            if (TextUtils.isEmpty(strategy)) {
                strategy = "{data:{disable:0,3G:5,wifi:1,now:[\"abandonPay\",\"schemePayEnter\",\"resultClickBtn\"],kf:{now:[],time:0,count:200}}}";
            }
            try {
                this.r = (JSONObject) new JSONTokener(strategy).nextValue();
                if (com.baidu.apollon.statistics.a.a(this.q) && b()) {
                    f();
                }
            } catch (Exception unused) {
            }
            g();
            LogSender.getInstance().triggerSending("normal_log");
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this.u) {
                z = false;
                if (!TextUtils.isEmpty(str) && this.x != null && this.x.length > 0) {
                    try {
                        if (Arrays.binarySearch(this.x, str) >= 0) {
                            z = true;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public boolean a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
            if (this.s != null && eVar != null && !TextUtils.isEmpty(eVar.f3981h)) {
                synchronized (this.u) {
                    if (this.s.has(eVar.f3981h)) {
                        try {
                            JSONObject optJSONObject = this.s.optJSONObject(eVar.f3981h);
                            if (optJSONObject == null) {
                                return true;
                            }
                            Iterator<String> keys = optJSONObject.keys();
                            if (!keys.hasNext()) {
                                return true;
                            }
                            JSONArray jSONArray = (JSONArray) new JSONTokener(eVar.j).nextValue();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                int intValue = Integer.valueOf(next).intValue() - 1;
                                if (intValue >= 0 && jSONArray.length() > intValue) {
                                    JSONArray jSONArray2 = (JSONArray) new JSONTokener(optJSONObject.getString(next)).nextValue();
                                    String str = (String) jSONArray.get(intValue);
                                    int length = jSONArray2.length();
                                    for (int i2 = 0; i2 < length; i2++) {
                                        String optString = jSONArray2.optString(i2, "");
                                        if (optString != null && optString.equals(str)) {
                                            return true;
                                        }
                                    }
                                    continue;
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
