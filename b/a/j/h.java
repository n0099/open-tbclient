package b.a.j;

import android.util.LruCache;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f2988a;

    /* renamed from: b  reason: collision with root package name */
    public final LruCache<String, a> f2989b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2990c;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f2991a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<String> f2992b;

        /* renamed from: c  reason: collision with root package name */
        public long f2993c;

        /* renamed from: d  reason: collision with root package name */
        public long f2994d;

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

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f2993c = j;
            }
        }

        public void b(ArrayList<String> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
                this.f2991a = arrayList;
            }
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? i() + this.f2993c < System.currentTimeMillis() / 1000 : invokeV.booleanValue;
        }

        public ArrayList<String> d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f2991a : (ArrayList) invokeV.objValue;
        }

        public void e(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
                this.f2994d = j;
            }
        }

        public void f(ArrayList<String> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
                this.f2992b = arrayList;
            }
        }

        public ArrayList<String> g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2992b : (ArrayList) invokeV.objValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f2993c : invokeV.longValue;
        }

        public long i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f2994d : invokeV.longValue;
        }
    }

    public h(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2990c = false;
        this.f2989b = new LruCache<>(((int) Runtime.getRuntime().maxMemory()) / 16);
        this.f2988a = str;
        this.f2990c = z;
    }

    public a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            a aVar = this.f2989b.get(str);
            if (aVar != null && aVar.c() && this.f2990c) {
                this.f2989b.remove(str);
                k.a("Remove expired entry from %s cache while reading, host(%s)", this.f2988a, str);
                return null;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f2989b.evictAll();
            k.a("Clear %s cache", this.f2988a);
        }
    }

    public void c(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, aVar) == null) {
            ArrayList<String> d2 = aVar.d();
            ArrayList<String> g2 = aVar.g();
            if ((d2 == null || d2.isEmpty()) && (g2 == null || g2.isEmpty())) {
                return;
            }
            this.f2989b.put(str, aVar);
            Object[] objArr = new Object[5];
            objArr[0] = this.f2988a;
            objArr[1] = str;
            objArr[2] = d2 != null ? d2.toString() : null;
            objArr[3] = g2 != null ? g2.toString() : null;
            objArr[4] = Long.valueOf(aVar.h());
            k.a("Set entry to %s cache, host(%s), ipv4List(%s), ipv6List(%s), ttl(%d)", objArr);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f2990c = z;
        }
    }

    public ArrayList<String> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str : this.f2989b.snapshot().keySet()) {
                arrayList.add(str);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void f(String str) {
        a a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && (a2 = a(str)) != null && a2.c()) {
            this.f2989b.remove(str);
            k.a("Remove expired entry from %s cache, host(%s)", this.f2988a, str);
        }
    }
}
