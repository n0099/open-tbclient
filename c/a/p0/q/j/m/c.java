package c.a.p0.q.j.m;

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
/* loaded from: classes5.dex */
public class c extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Set<a> f10792d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(List<? extends a> list, @Nullable c.a.p0.q.p.b bVar) {
        super(-1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f10792d = new LinkedHashSet();
        Map<String, PMSAppInfo> v = c.a.p0.q.g.a.i().v();
        Map<String, c.a.p0.q.i.g> p = c.a.p0.q.g.a.i().p();
        for (a aVar : list) {
            if (aVar != null && !TextUtils.isEmpty(aVar.b())) {
                g(v, p, aVar, bVar);
                this.f10792d.add(aVar);
            }
        }
    }

    @Nullable
    public Set<a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f10792d : (Set) invokeV.objValue;
    }

    public void g(@NonNull Map<String, PMSAppInfo> map, @NonNull Map<String, c.a.p0.q.i.g> map2, @NonNull a aVar, @Nullable c.a.p0.q.p.b bVar) {
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
                c.a.p0.q.i.g gVar = map2.get(aVar.b());
                if (gVar != null) {
                    aVar.h(gVar.f10719i);
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

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f10793b;

        /* renamed from: c  reason: collision with root package name */
        public long f10794c;

        /* renamed from: d  reason: collision with root package name */
        public long f10795d;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10793b = -1;
            this.f10794c = 0L;
            this.f10795d = 0L;
            this.a = str;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f10795d : invokeV.longValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f10793b : invokeV.intValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f10794c : invokeV.longValue;
        }

        public void e(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
                this.f10795d = j2;
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
                    return TextUtils.equals(aVar.b(), this.a) && aVar.c() == this.f10793b;
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

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
                this.f10793b = i2;
            }
        }

        public void h(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
                this.f10794c = j2;
            }
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Objects.hash(this.a, Integer.valueOf(this.f10793b)) : invokeV.intValue;
        }

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f10793b = -1;
            this.f10794c = 0L;
            this.f10795d = 0L;
            this.a = str;
            this.f10793b = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Collection<String> collection, @Nullable c.a.p0.q.p.b bVar) {
        super(-1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collection, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (collection == null || collection.isEmpty()) {
            return;
        }
        this.f10792d = new LinkedHashSet();
        Map<String, PMSAppInfo> v = c.a.p0.q.g.a.i().v();
        Map<String, c.a.p0.q.i.g> p = c.a.p0.q.g.a.i().p();
        for (String str : collection) {
            if (!TextUtils.isEmpty(str)) {
                a aVar = new a(str);
                g(v, p, aVar, bVar);
                this.f10792d.add(aVar);
            }
        }
    }
}
