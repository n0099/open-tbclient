package b.a.p0.a.u1.k;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f9008a;

    /* renamed from: b  reason: collision with root package name */
    public SimpleDateFormat f9009b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, List<b.a.p0.a.u1.k.a>> f9010c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f9011d;

    /* renamed from: e  reason: collision with root package name */
    public String f9012e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9013f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9014g;

    /* renamed from: h  reason: collision with root package name */
    public long f9015h;

    /* renamed from: i  reason: collision with root package name */
    public long f9016i;
    public volatile b.a.p0.a.u1.k.j.c j;

    /* loaded from: classes.dex */
    public class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f9017a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9017a = bVar;
        }

        @Override // b.a.p0.a.u1.k.c
        public boolean a(b.a.p0.a.u1.k.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (aVar == null || aVar.c() < 0) {
                    return false;
                }
                if (b.k || aVar.b() == 0) {
                    return this.f9017a.o(aVar.e());
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(278797146, "Lb/a/p0/a/u1/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(278797146, "Lb/a/p0/a/u1/k/b;");
                return;
            }
        }
        k = k.f6863a;
    }

    public b() {
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
        this.f9011d = new Object();
    }

    @Override // b.a.p0.a.u1.k.e
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            p();
            u();
            this.f9015h = j;
            q("launch start time-" + j);
        }
    }

    @Override // b.a.p0.a.u1.k.e
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f9014g = true;
            this.f9016i = j;
            v(k());
            q("launch end time-" + (this.f9015h + this.f9016i));
        }
    }

    @Override // b.a.p0.a.u1.k.d
    public void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) && f.j().m()) {
            p();
            if (this.f9013f) {
                q("aiapp start finish");
                return;
            }
            q("ubcReport enter");
            if (jSONObject != null && jSONObject.length() > 0) {
                String m = m(jSONObject);
                q("Id " + m);
                if (TextUtils.equals(m, "786")) {
                    if (k) {
                        jSONObject.toString();
                    }
                    JSONObject l = l(jSONObject);
                    if (l != null && l.length() > 0) {
                        JSONObject optJSONObject = l.optJSONObject("ext");
                        if (optJSONObject != null && optJSONObject.length() > 0) {
                            if (TextUtils.isEmpty(this.f9012e)) {
                                this.f9012e = optJSONObject.optString("swan");
                                q("current swan version " + this.f9012e);
                            }
                            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                s(optJSONArray);
                                q("ubcReport over");
                                v(k());
                                return;
                            }
                            q("value-ext-list is empty");
                            return;
                        }
                        q("value-ext is empty");
                        return;
                    }
                    q("value is empty");
                    return;
                }
                return;
            }
            q("json data is empty");
        }
    }

    public String k() {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f9014g && this.f9009b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("----- ");
                sb.append("launch start time ");
                sb.append(this.f9009b.format(Long.valueOf(this.f9015h)));
                sb.append(StringUtils.LF);
                sb.append("----- ");
                sb.append("launch end time ");
                sb.append(this.f9009b.format(Long.valueOf(this.f9015h + this.f9016i)));
                sb.append(StringUtils.LF);
                sb.append("----- ");
                sb.append("swan js version ");
                sb.append(this.f9012e);
                sb.append(StringUtils.LF);
                synchronized (this.f9011d) {
                    i2 = 0;
                    i3 = 0;
                    for (Map.Entry<String, List<b.a.p0.a.u1.k.a>> entry : this.f9010c.entrySet()) {
                        List<b.a.p0.a.u1.k.a> value = entry.getValue();
                        if (value != null && value.size() > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            int i4 = 0;
                            for (b.a.p0.a.u1.k.a aVar : value) {
                                if (this.f9008a == null || this.f9008a.a(aVar)) {
                                    sb2.append("----- start time ");
                                    sb2.append(this.f9009b.format(Long.valueOf(aVar.e())));
                                    sb2.append(StringUtils.LF);
                                    sb2.append("----- end time ");
                                    sb2.append(this.f9009b.format(Long.valueOf(aVar.d())));
                                    sb2.append(StringUtils.LF);
                                    sb2.append("----- cost time ");
                                    sb2.append(aVar.c());
                                    sb2.append("ms\n");
                                    sb2.append("----------------------------\n");
                                    i3++;
                                    i4++;
                                }
                            }
                            if (i4 > 0) {
                                sb.append("\n===== ");
                                sb.append(entry.getKey());
                                sb.append(" ");
                                sb.append(i4);
                                sb.append(" times\n");
                                sb.append((CharSequence) sb2);
                                i2++;
                            }
                        }
                    }
                }
                sb.append("===== total: ");
                sb.append(i2);
                sb.append(" apis, ");
                sb.append(i3);
                sb.append(" times");
                String sb3 = sb.toString();
                b.a.p0.a.e0.d.b("ApiCalledMarker", sb3);
                return sb3;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final JSONObject l(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            return optJSONObject == null ? jSONObject.optJSONObject("value") : optJSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final String m(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONObject)) == null) {
            String optString = jSONObject.optString("ubcId");
            return TextUtils.isEmpty(optString) ? jSONObject.optString("actionId") : optString;
        }
        return (String) invokeL.objValue;
    }

    public final void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) && this.j == null) {
            synchronized (this.f9011d) {
                if (this.j == null) {
                    this.j = jSONObject.has("caller") ? new b.a.p0.a.u1.k.j.b() : new b.a.p0.a.u1.k.j.a();
                }
            }
        }
    }

    public final boolean o(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            long j2 = this.f9015h;
            return j >= j2 && j <= j2 + this.f9016i;
        }
        return invokeJ.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f9010c == null) {
            synchronized (this.f9011d) {
                if (this.f9010c == null) {
                    this.f9010c = new HashMap<>();
                    this.f9009b = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                    this.f9008a = new a(this);
                }
            }
        }
    }

    public final void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            boolean z = k;
        }
    }

    public final boolean r(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) ? this.f9014g && j > this.f9015h + this.f9016i : invokeJ.booleanValue;
    }

    public final void s(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jSONArray) == null) {
            q("start parse api info");
            int length = jSONArray.length();
            boolean z = length > 0;
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null && optJSONObject.length() > 0 && optJSONObject.optInt("success") == 1) {
                    z &= !t(optJSONObject);
                }
            }
            this.f9013f = z;
            q("start done " + this.f9013f);
        }
    }

    public final boolean t(JSONObject jSONObject) {
        InterceptResult invokeL;
        List<b.a.p0.a.u1.k.a> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, jSONObject)) == null) {
            n(jSONObject);
            String optString = jSONObject.optString(com.alipay.sdk.cons.c.n);
            if (TextUtils.isEmpty(optString) || (a2 = this.j.a(jSONObject)) == null || a2.size() <= 0) {
                return true;
            }
            boolean z = a2.size() > 0;
            synchronized (this.f9011d) {
                List<b.a.p0.a.u1.k.a> list = this.f9010c.get(optString);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f9010c.put(optString, list);
                }
                list.addAll(a2);
                for (b.a.p0.a.u1.k.a aVar : a2) {
                    z &= r(aVar.e());
                }
            }
            if (k) {
                String str = "api - " + optString + ", all after fmp - " + z;
            }
            return !z;
        }
        return invokeL.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.f9010c.size() > 0) {
                synchronized (this.f9011d) {
                    this.f9010c.clear();
                }
            }
            this.f9013f = false;
            this.f9014g = false;
            this.f9016i = 0L;
            this.f9015h = 0L;
            this.f9012e = null;
            v("===== loading... =====");
        }
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        b.a.p0.a.u2.d.j.update((b.a.p0.a.u2.c<String>) str);
    }
}
