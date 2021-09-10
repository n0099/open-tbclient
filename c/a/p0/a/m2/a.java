package c.a.p0.a.m2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.g1.f;
import c.a.p0.a.k;
import c.a.p0.a.k2.g.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.m2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0296a implements Comparator<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0296a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cVar, cVar2)) == null) {
                if (cVar == null) {
                    return -1;
                }
                if (cVar2 == null) {
                    return 1;
                }
                return String.valueOf(cVar.f7375a).compareTo(String.valueOf(cVar2.f7375a));
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f7374a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1286488783, "Lc/a/p0/a/m2/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1286488783, "Lc/a/p0/a/m2/a$b;");
                    return;
                }
            }
            f7374a = new a(null);
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f7375a;

        /* renamed from: b  reason: collision with root package name */
        public long f7376b;

        public c(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7375a = j2;
            this.f7376b = j3;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("time", this.f7375a);
                    jSONObject.put("version", this.f7376b);
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    if (k.f7077a) {
                        e2.printStackTrace();
                    }
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }

        @NonNull
        public String toString() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                try {
                    str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(this.f7375a));
                } catch (Exception e2) {
                    if (k.f7077a) {
                        e2.printStackTrace();
                    }
                    str = null;
                }
                return str + " ---> " + this.f7376b;
            }
            return (String) invokeV.objValue;
        }
    }

    public /* synthetic */ a(C0296a c0296a) {
        this();
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 == 1 ? "aigames_core_ver_list_key" : "aiapps_core_ver_list_key" : (String) invokeI.objValue;
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f7374a : (a) invokeV.objValue;
    }

    public static String d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? i2 == 1 ? "installed_game_swan_js_md5" : "installed_swan_js_md5" : (String) invokeI.objValue;
    }

    public static void h(List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, list) == null) {
            Collections.sort(list, new C0296a());
        }
    }

    public void a(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            List<c> f2 = f(i2);
            boolean z = false;
            if (f2.size() >= 10) {
                f2.remove(0);
            }
            Iterator<c> it = f2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c next = it.next();
                if (next != null && next.f7376b == j2) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            f2.add(new c(Calendar.getInstance().getTimeInMillis(), j2));
            HashSet hashSet = new HashSet();
            for (c cVar : f2) {
                if (cVar != null) {
                    hashSet.add(cVar.a());
                }
            }
            h.a().putStringSet(b(i2), hashSet);
        }
    }

    public String e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            StringBuilder sb = new StringBuilder();
            String string = h.a().getString(d(i2), "");
            if (!TextUtils.isEmpty(string)) {
                sb.append("md5: ");
                sb.append(string);
                sb.append(StringUtils.LF);
                sb.append(StringUtils.LF);
            }
            List<c> f2 = f(i2);
            int size = f2.size();
            boolean z = false;
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = f2.get(i3);
                if (cVar != null) {
                    sb.append(cVar.toString());
                    if (i3 < size - 1) {
                        sb.append(StringUtils.LF);
                    }
                    z = true;
                }
            }
            if (!z) {
                sb.append(new c(System.currentTimeMillis(), c.a.p0.a.m2.e.a.f(i2)).toString());
            } else {
                SwanCoreVersion N = f.V().N();
                c cVar2 = f2.get(size - 1);
                if (cVar2 != null && N != null && N.swanCoreVersionCode > cVar2.f7376b) {
                    sb.append(StringUtils.LF);
                    sb.append(new c(System.currentTimeMillis(), N.swanCoreVersionCode).toString());
                }
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public final List<c> f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            Set<String> stringSet = h.a().getStringSet(b(i2), null);
            if (stringSet != null && stringSet.size() != 0) {
                for (String str : stringSet) {
                    c g2 = g(str);
                    if (g2 != null) {
                        arrayList.add(g2);
                    }
                }
                h(arrayList);
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public final c g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new c(jSONObject.optLong("time"), jSONObject.optLong("version"));
            } catch (JSONException e2) {
                if (k.f7077a) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (c) invokeL.objValue;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
