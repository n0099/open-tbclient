package c.a.n0.q.i.m;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes2.dex */
public class c extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Set<a> f9211d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(List<? extends a> list, @Nullable c.a.n0.q.o.b bVar) {
        super(-1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f9211d = new LinkedHashSet();
        Map<String, PMSAppInfo> v = c.a.n0.q.f.a.i().v();
        Map<String, c.a.n0.q.h.g> p = c.a.n0.q.f.a.i().p();
        for (a aVar : list) {
            if (aVar != null && !TextUtils.isEmpty(aVar.b())) {
                g(v, p, aVar, bVar);
                this.f9211d.add(aVar);
            }
        }
    }

    @Nullable
    public Set<a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f9211d : (Set) invokeV.objValue;
    }

    public void g(@NonNull Map<String, PMSAppInfo> map, @NonNull Map<String, c.a.n0.q.h.g> map2, @NonNull a aVar, @Nullable c.a.n0.q.o.b bVar) {
        PMSAppInfo pMSAppInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, map2, aVar, bVar) == null) && map.containsKey(aVar.b()) && (pMSAppInfo = map.get(aVar.b())) != null) {
            if (aVar.c() == -1) {
                aVar.g(pMSAppInfo.appCategory);
            }
            if (!map2.containsKey(aVar.b())) {
                aVar.h(0L);
            } else if (bVar != null && pMSAppInfo.versionCode != 0 && !bVar.a(aVar.b(), aVar.c())) {
                aVar.h(0L);
            } else {
                c.a.n0.q.h.g gVar = map2.get(aVar.b());
                if (gVar != null) {
                    aVar.h(gVar.i);
                } else {
                    aVar.h(0L);
                }
            }
            if (pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                aVar.e(pMSAppInfo.appSign);
            } else {
                aVar.e(0L);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f9212b;

        /* renamed from: c  reason: collision with root package name */
        public long f9213c;

        /* renamed from: d  reason: collision with root package name */
        public long f9214d;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9212b = -1;
            this.f9213c = 0L;
            this.f9214d = 0L;
            this.a = str;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f9214d : invokeV.longValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f9212b : invokeV.intValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f9213c : invokeV.longValue;
        }

        public void e(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
                this.f9214d = j;
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (super.equals(obj)) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return TextUtils.equals(aVar.b(), this.a) && aVar.c() == this.f9212b;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.a = str;
            }
        }

        public void g(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                this.f9212b = i;
            }
        }

        public void h(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
                this.f9213c = j;
            }
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Objects.hash(this.a, Integer.valueOf(this.f9212b)) : invokeV.intValue;
        }

        public a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f9212b = -1;
            this.f9213c = 0L;
            this.f9214d = 0L;
            this.a = str;
            this.f9212b = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Collection<String> collection, @Nullable c.a.n0.q.o.b bVar) {
        super(-1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collection, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (collection == null || collection.isEmpty()) {
            return;
        }
        this.f9211d = new LinkedHashSet();
        Map<String, PMSAppInfo> v = c.a.n0.q.f.a.i().v();
        Map<String, c.a.n0.q.h.g> p = c.a.n0.q.f.a.i().p();
        for (String str : collection) {
            if (!TextUtils.isEmpty(str)) {
                a aVar = new a(str);
                g(v, p, aVar, bVar);
                this.f9211d.add(aVar);
            }
        }
    }
}
