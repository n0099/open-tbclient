package b.a.e.f.d;

import b.a.e.f.d.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f1686a;

        /* renamed from: b  reason: collision with root package name */
        public LinkedList<g<?>> f1687b;

        public a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1686a = i2;
        }

        @Override // b.a.e.f.d.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // b.a.e.f.d.e.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f1687b.clear();
                this.f1687b = null;
            }
        }

        @Override // b.a.e.f.d.e.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f1687b = new LinkedList<>();
            }
        }

        @Override // b.a.e.f.d.e
        public int getMaxSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1686a : invokeV.intValue;
        }

        @Override // b.a.e.f.d.e.a
        public String h(g<?> gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gVar)) == null) {
                if (gVar.f1695f < System.currentTimeMillis()) {
                    return gVar.f1690a;
                }
                this.f1687b.add(gVar);
                String str = null;
                if (this.f1687b.size() > getMaxSize()) {
                    long j = 0;
                    int i2 = -1;
                    for (int i3 = 0; i3 < this.f1687b.size(); i3++) {
                        g<?> gVar2 = this.f1687b.get(i3);
                        if (i2 == -1 || gVar2.f1694e < j) {
                            str = gVar2.f1690a;
                            j = gVar2.f1694e;
                            i2 = i3;
                        }
                    }
                    this.f1687b.remove(i2);
                }
                return str;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f1688a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Long> f1689b;

        public b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1689b = new HashMap<>();
            this.f1688a = i2;
        }

        @Override // b.a.e.f.d.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // b.a.e.f.d.e.b
        public String d(g<?> gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar)) == null) {
                String i2 = i(gVar.f1690a);
                synchronized (this) {
                    this.f1689b.put(gVar.f1690a, Long.valueOf(gVar.f1694e));
                }
                return i2;
            }
            return (String) invokeL.objValue;
        }

        @Override // b.a.e.f.d.e.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // b.a.e.f.d.e.b
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // b.a.e.f.d.e.b
        public String g(g<?> gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gVar)) == null) {
                if (gVar.f1695f < System.currentTimeMillis()) {
                    return gVar.f1690a;
                }
                return d(gVar);
            }
            return (String) invokeL.objValue;
        }

        @Override // b.a.e.f.d.e
        public int getMaxSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1688a : invokeV.intValue;
        }

        public String i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                String str2 = null;
                if (!this.f1689b.containsKey(str) && this.f1689b.size() >= this.f1688a) {
                    synchronized (this) {
                        long j = -1;
                        for (Map.Entry<String, Long> entry : this.f1689b.entrySet()) {
                            long longValue = entry.getValue().longValue();
                            if (j == -1 || j > longValue) {
                                str2 = entry.getKey();
                                j = longValue;
                            }
                        }
                        if (str2 != null) {
                            this.f1689b.remove(str2);
                        }
                    }
                    return str2;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // b.a.e.f.d.e.b
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                synchronized (this) {
                    this.f1689b.clear();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // b.a.e.f.d.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // b.a.e.f.d.e
        public int getMaxSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }
    }

    public static e a(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return new b(i2);
            }
            return new a(i2);
        }
        return (e) invokeCommon.objValue;
    }

    public static e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new c() : (e) invokeV.objValue;
    }
}
