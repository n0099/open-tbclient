package c.a.p0.x;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.d.f.p.n;
import c.a.p0.l3.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public final class b implements l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f20576d;

    /* renamed from: e  reason: collision with root package name */
    public static b f20577e;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<l.a> a;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap<String, l.b> f20578b;

    /* renamed from: c  reason: collision with root package name */
    public l.c f20579c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f20580b;

        public a(b bVar, l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20580b = bVar;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20580b.f(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1885302233, "Lc/a/p0/x/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1885302233, "Lc/a/p0/x/b;");
                return;
            }
        }
        f20576d = Pattern.compile(UrlManager.patternText, 2);
        f20577e = new b();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new LinkedList();
        this.f20578b = new ConcurrentHashMap<>();
        this.f20579c = null;
    }

    public static b l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f20577e : (b) invokeV.objValue;
    }

    @Override // c.a.p0.l3.l
    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? !TextUtils.isEmpty(str) && f20576d.matcher(str).find() : invokeL.booleanValue;
    }

    @Override // c.a.p0.l3.l
    public void b(Context context, String[] strArr, boolean z, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, strArr, Boolean.valueOf(z), bundle}) == null) {
            h(context, strArr, false, null, z, bundle);
        }
    }

    @Override // c.a.p0.l3.l
    public boolean c(Context context, String[] strArr, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, strArr, bundle)) == null) ? h(context, strArr, false, null, false, bundle) : invokeLLL.booleanValue;
    }

    public void e(l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (n.B()) {
                f(aVar);
            } else {
                e.a().post(new a(this, aVar));
            }
        }
    }

    public final void f(l.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || this.a.contains(aVar)) {
            return;
        }
        this.a.add(aVar);
    }

    public boolean g(Context context, String str, String[] strArr, boolean z, l.d dVar, boolean z2, Bundle bundle) {
        InterceptResult invokeCommon;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{context, str, strArr, Boolean.valueOf(z), dVar, Boolean.valueOf(z2), bundle})) == null) {
            if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(strArr[0])) {
                return false;
            }
            String str2 = strArr[0];
            l.b bVar = this.f20578b.get(m(str2));
            if (bVar != null) {
                bVar.a(context, j(k(str2)));
                return true;
            }
            Iterator<l.a> it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z3 = false;
                    break;
                }
                l.a next = it.next();
                if (next != null && next.a(context, strArr) != 3) {
                    z3 = true;
                    break;
                }
            }
            if (!z3 && this.f20579c != null) {
                if (str2.contains("nohead:url") || str2.contains("booktown") || str2.contains("bookreader")) {
                    return true;
                }
                n(context, str, strArr[0], z, dVar, z2, bundle);
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    public boolean h(Context context, String[] strArr, boolean z, l.d dVar, boolean z2, Bundle bundle) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{context, strArr, Boolean.valueOf(z), dVar, Boolean.valueOf(z2), bundle})) == null) ? g(context, "", strArr, z, dVar, z2, bundle) : invokeCommon.booleanValue;
    }

    public int i(Context context, String[] strArr) {
        InterceptResult invokeLL;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, strArr)) == null) {
            if (strArr != null && strArr.length != 0) {
                for (l.a aVar : this.a) {
                    if (aVar != null && (a2 = aVar.a(context, strArr)) != 3) {
                        return a2;
                    }
                }
            }
            return 3;
        }
        return invokeLL.intValue;
    }

    public final Map<String, String> j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            String[] split = str.split("[&]");
            if (split == null) {
                hashMap.put(UrlManager.DEFAULT_PARAM, str);
                return hashMap;
            }
            for (String str2 : split) {
                String[] split2 = str2.split("[=]");
                if (split2.length > 1) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final String k(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (!StringUtils.isNull(str) && (lastIndexOf = str.lastIndexOf(":")) >= 0) {
                return str.substring(lastIndexOf + 1);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return str.contains(":") ? str.substring(0, str.lastIndexOf(":")) : str;
        }
        return (String) invokeL.objValue;
    }

    public final void n(Context context, String str, String str2, boolean z, l.d dVar, boolean z2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, str2, Boolean.valueOf(z), dVar, Boolean.valueOf(z2), bundle}) == null) && f20576d.matcher(str2).find()) {
            this.f20579c.a(context, str, str2, z, dVar, z2, bundle);
        }
    }

    public void o(l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.f20579c = cVar;
        }
    }
}
