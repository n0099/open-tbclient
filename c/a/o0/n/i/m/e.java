package c.a.o0.n.i.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import c.a.o0.n.i.m.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class e extends c.a.o0.n.i.m.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f11959a;

        /* renamed from: b  reason: collision with root package name */
        public String f11960b;

        /* renamed from: c  reason: collision with root package name */
        public long f11961c;

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
            this.f11961c = 0L;
            this.f11959a = str;
        }

        @NonNull
        public static List<a> f(@Nullable List<c.a.o0.n.h.g> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
                ArrayList arrayList = new ArrayList();
                if (list != null && !list.isEmpty()) {
                    for (c.a.o0.n.h.g gVar : list) {
                        if (gVar != null) {
                            a aVar = new a(gVar.f11857g);
                            aVar.d(gVar.r ? "independent" : "normal");
                            aVar.e(gVar.f11859i);
                            arrayList.add(aVar);
                        }
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11959a : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11960b : (String) invokeV.objValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f11961c : invokeV.longValue;
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f11960b = str;
            }
        }

        public void e(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
                this.f11961c = j2;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public String[] f11962e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public List<a> f11963f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Nullable
        public String[] h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11962e : (String[]) invokeV.objValue;
        }

        @Nullable
        public List<a> i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11963f : (List) invokeV.objValue;
        }

        public void j(@Nullable String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr) == null) {
                this.f11962e = strArr;
            }
        }

        public void k(@Nullable List<a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.f11963f = list;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @WorkerThread
    public e(List<b> list, @Nullable c.a.o0.n.o.a aVar) {
        super((List<? extends b.a>) list, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((List<? extends b.a>) objArr2[0], (c.a.o0.n.o.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.n.i.m.b
    public void g(@NonNull Map<String, PMSAppInfo> map, @NonNull Map<String, c.a.o0.n.h.f> map2, @NonNull b.a aVar, @Nullable c.a.o0.n.o.a aVar2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, map, map2, aVar, aVar2) == null) {
            super.g(map, map2, aVar, aVar2);
            if (aVar instanceof b) {
                b bVar = (b) aVar;
                if (bVar.h() == null || bVar.i() != null || (i2 = c.a.o0.n.g.a.h().i(bVar.b())) < 0) {
                    return;
                }
                bVar.k(a.f(c.a.o0.n.g.a.h().j(bVar.b(), i2)));
            }
        }
    }
}
