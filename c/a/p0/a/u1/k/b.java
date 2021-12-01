package c.a.p0.a.u1.k;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
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

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f8525k;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public SimpleDateFormat f8526b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, List<c.a.p0.a.u1.k.a>> f8527c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f8528d;

    /* renamed from: e  reason: collision with root package name */
    public String f8529e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f8530f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8531g;

    /* renamed from: h  reason: collision with root package name */
    public long f8532h;

    /* renamed from: i  reason: collision with root package name */
    public long f8533i;

    /* renamed from: j  reason: collision with root package name */
    public volatile c.a.p0.a.u1.k.j.c f8534j;

    /* loaded from: classes.dex */
    public class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        @Override // c.a.p0.a.u1.k.c
        public boolean a(c.a.p0.a.u1.k.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (aVar == null || aVar.c() < 0) {
                    return false;
                }
                if (b.f8525k || aVar.b() == 0) {
                    return this.a.o(aVar.e());
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-231737031, "Lc/a/p0/a/u1/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-231737031, "Lc/a/p0/a/u1/k/b;");
                return;
            }
        }
        f8525k = k.a;
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
        this.f8528d = new Object();
    }

    @Override // c.a.p0.a.u1.k.e
    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            p();
            u();
            this.f8532h = j2;
            q("launch start time-" + j2);
        }
    }

    @Override // c.a.p0.a.u1.k.e
    public void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.f8531g = true;
            this.f8533i = j2;
            v(k());
            q("launch end time-" + (this.f8532h + this.f8533i));
        }
    }

    @Override // c.a.p0.a.u1.k.d
    public void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) && f.j().m()) {
            p();
            if (this.f8530f) {
                q("aiapp start finish");
                return;
            }
            q("ubcReport enter");
            if (jSONObject != null && jSONObject.length() > 0) {
                String m = m(jSONObject);
                q("Id " + m);
                if (TextUtils.equals(m, "786")) {
                    if (f8525k) {
                        jSONObject.toString();
                    }
                    JSONObject l = l(jSONObject);
                    if (l != null && l.length() > 0) {
                        JSONObject optJSONObject = l.optJSONObject("ext");
                        if (optJSONObject != null && optJSONObject.length() > 0) {
                            if (TextUtils.isEmpty(this.f8529e)) {
                                this.f8529e = optJSONObject.optString("swan");
                                q("current swan version " + this.f8529e);
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
            if (this.f8531g && this.f8526b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("----- ");
                sb.append("launch start time ");
                sb.append(this.f8526b.format(Long.valueOf(this.f8532h)));
                sb.append(StringUtils.LF);
                sb.append("----- ");
                sb.append("launch end time ");
                sb.append(this.f8526b.format(Long.valueOf(this.f8532h + this.f8533i)));
                sb.append(StringUtils.LF);
                sb.append("----- ");
                sb.append("swan js version ");
                sb.append(this.f8529e);
                sb.append(StringUtils.LF);
                synchronized (this.f8528d) {
                    i2 = 0;
                    i3 = 0;
                    for (Map.Entry<String, List<c.a.p0.a.u1.k.a>> entry : this.f8527c.entrySet()) {
                        List<c.a.p0.a.u1.k.a> value = entry.getValue();
                        if (value != null && value.size() > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            int i4 = 0;
                            for (c.a.p0.a.u1.k.a aVar : value) {
                                if (this.a == null || this.a.a(aVar)) {
                                    sb2.append("----- start time ");
                                    sb2.append(this.f8526b.format(Long.valueOf(aVar.e())));
                                    sb2.append(StringUtils.LF);
                                    sb2.append("----- end time ");
                                    sb2.append(this.f8526b.format(Long.valueOf(aVar.d())));
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
                c.a.p0.a.e0.d.b("ApiCalledMarker", sb3);
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
        if ((interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) && this.f8534j == null) {
            synchronized (this.f8528d) {
                if (this.f8534j == null) {
                    this.f8534j = jSONObject.has("caller") ? new c.a.p0.a.u1.k.j.b() : new c.a.p0.a.u1.k.j.a();
                }
            }
        }
    }

    public final boolean o(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
            long j3 = this.f8532h;
            return j2 >= j3 && j2 <= j3 + this.f8533i;
        }
        return invokeJ.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f8527c == null) {
            synchronized (this.f8528d) {
                if (this.f8527c == null) {
                    this.f8527c = new HashMap<>();
                    this.f8526b = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                    this.a = new a(this);
                }
            }
        }
    }

    public final void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            boolean z = f8525k;
        }
    }

    public final boolean r(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) ? this.f8531g && j2 > this.f8532h + this.f8533i : invokeJ.booleanValue;
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
            this.f8530f = z;
            q("start done " + this.f8530f);
        }
    }

    public final boolean t(JSONObject jSONObject) {
        InterceptResult invokeL;
        List<c.a.p0.a.u1.k.a> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, jSONObject)) == null) {
            n(jSONObject);
            String optString = jSONObject.optString(com.alipay.sdk.cons.c.n);
            if (TextUtils.isEmpty(optString) || (a2 = this.f8534j.a(jSONObject)) == null || a2.size() <= 0) {
                return true;
            }
            boolean z = a2.size() > 0;
            synchronized (this.f8528d) {
                List<c.a.p0.a.u1.k.a> list = this.f8527c.get(optString);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f8527c.put(optString, list);
                }
                list.addAll(a2);
                for (c.a.p0.a.u1.k.a aVar : a2) {
                    z &= r(aVar.e());
                }
            }
            if (f8525k) {
                String str = "api - " + optString + ", all after fmp - " + z;
            }
            return !z;
        }
        return invokeL.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.f8527c.size() > 0) {
                synchronized (this.f8528d) {
                    this.f8527c.clear();
                }
            }
            this.f8530f = false;
            this.f8531g = false;
            this.f8533i = 0L;
            this.f8532h = 0L;
            this.f8529e = null;
            v("===== loading... =====");
        }
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.p0.a.u2.d.f8626j.update((c.a.p0.a.u2.c<String>) str);
    }
}
