package b.a.p0.n.i.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import b.a.p0.n.i.m.b;
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
/* loaded from: classes4.dex */
public class e extends b.a.p0.n.i.m.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f11175a;

        /* renamed from: b  reason: collision with root package name */
        public String f11176b;

        /* renamed from: c  reason: collision with root package name */
        public long f11177c;

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
            this.f11177c = 0L;
            this.f11175a = str;
        }

        @NonNull
        public static List<a> e(@Nullable List<b.a.p0.n.h.g> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
                ArrayList arrayList = new ArrayList();
                if (list != null && !list.isEmpty()) {
                    for (b.a.p0.n.h.g gVar : list) {
                        if (gVar != null) {
                            a aVar = new a(gVar.f11076g);
                            aVar.c(gVar.r ? "independent" : "normal");
                            aVar.d(gVar.f11078i);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11175a : (String) invokeV.objValue;
        }

        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11177c : invokeV.longValue;
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f11176b = str;
            }
        }

        public void d(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
                this.f11177c = j;
            }
        }

        public String getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f11176b : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public String[] f11178e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public List<a> f11179f;

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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11178e : (String[]) invokeV.objValue;
        }

        @Nullable
        public List<a> i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11179f : (List) invokeV.objValue;
        }

        public void j(@Nullable String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr) == null) {
                this.f11178e = strArr;
            }
        }

        public void k(@Nullable List<a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.f11179f = list;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @WorkerThread
    public e(List<b> list, @Nullable b.a.p0.n.o.a aVar) {
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
                super((List<? extends b.a>) objArr2[0], (b.a.p0.n.o.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.n.i.m.b
    public void g(@NonNull Map<String, PMSAppInfo> map, @NonNull Map<String, b.a.p0.n.h.f> map2, @NonNull b.a aVar, @Nullable b.a.p0.n.o.a aVar2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, map, map2, aVar, aVar2) == null) {
            super.g(map, map2, aVar, aVar2);
            if (aVar instanceof b) {
                b bVar = (b) aVar;
                if (bVar.h() == null || bVar.i() != null || (i2 = b.a.p0.n.g.a.h().i(bVar.b())) < 0) {
                    return;
                }
                bVar.k(a.e(b.a.p0.n.g.a.h().j(bVar.b(), i2)));
            }
        }
    }
}
