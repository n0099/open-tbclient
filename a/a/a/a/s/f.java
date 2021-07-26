package a.a.a.a.s;

import a.a.a.a.s.d;
import a.a.a.a.s.e;
import a.a.a.a.s.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Deque<c>> f1351a;

    /* loaded from: classes.dex */
    public static class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final e f1352a;

        /* renamed from: b  reason: collision with root package name */
        public final HashSet<h.a> f1353b;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1352a = eVar;
            this.f1353b = new HashSet<>();
            for (e.b bVar : eVar.f1344f) {
                for (e.a aVar : bVar.f1350c) {
                    this.f1353b.add(aVar.f1347d);
                }
            }
        }

        @Override // a.a.a.a.s.f.c
        public Set<h.a> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1353b : (Set) invokeV.objValue;
        }

        @Override // a.a.a.a.s.f.c
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1352a.f1343e : invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d f1354a;

        /* renamed from: b  reason: collision with root package name */
        public final HashSet<h.a> f1355b;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1354a = dVar;
            this.f1355b = new HashSet<>();
            for (d.b bVar : dVar.f1333c) {
                for (d.a aVar : bVar.f1339c) {
                    this.f1355b.add(aVar.f1337d);
                }
            }
        }

        @Override // a.a.a.a.s.f.c
        public Set<h.a> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1355b : (Set) invokeV.objValue;
        }

        @Override // a.a.a.a.s.f.c
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1354a.f1334d : invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        Set<h.a> a();

        int b();
    }

    public f() {
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
        this.f1351a = new HashMap<>();
    }

    public final Deque<c> a(String str) {
        InterceptResult invokeL;
        Deque<c> deque;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this.f1351a) {
                deque = this.f1351a.get(str);
                if (deque == null) {
                    deque = new ArrayDeque<>();
                    this.f1351a.put(str, deque);
                }
            }
            return deque;
        }
        return (Deque) invokeL.objValue;
    }
}
