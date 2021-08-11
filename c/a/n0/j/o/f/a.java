package c.a.n0.j.o.f;

import android.content.Context;
import android.text.TextUtils;
import c.a.n0.a.a2.e;
import c.a.n0.a.h1.b;
import c.a.n0.a.k;
import c.a.n0.j.k.f.d;
import c.a.n0.j.o.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends c.a.n0.j.k.a<c.a.n0.a.h1.c.a> implements a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f11510a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.a.h1.c.a f11511b;

    /* renamed from: c.a.n0.j.o.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0606a implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f11512a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11513b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f11514c;

        public C0606a(a aVar, b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11514c = aVar;
            this.f11512a = bVar;
            this.f11513b = str;
        }

        @Override // c.a.n0.j.k.f.d.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.e0.d.l("map", "location permission fail");
                this.f11512a.b(this.f11513b, 1003, "location permission fail");
            }
        }

        @Override // c.a.n0.j.k.f.d.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.n0.a.e0.d.l("map", "location permission success");
                this.f11514c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1919811567, "Lc/a/n0/j/o/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1919811567, "Lc/a/n0/j/o/f/a;");
                return;
            }
        }
        boolean z = k.f6803a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    @Override // c.a.n0.j.o.a.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        b bVar;
        c.a.n0.a.h1.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) || (bVar = this.f11510a) == null || (aVar = this.f11511b) == null) {
            return;
        }
        bVar.c(aVar.D, selectedLocationInfo.toJson());
    }

    public final boolean e(Context context, c.a.n0.a.h1.c.a aVar, b bVar, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, aVar, bVar, eVar)) == null) {
            c.a.n0.a.e0.d.g("map", "ChooseLocationAction start");
            if (!aVar.isValid()) {
                c.a.n0.a.e0.d.b("map", "model is invalid");
                return false;
            }
            String str = aVar.D;
            if (TextUtils.isEmpty(str)) {
                c.a.n0.a.e0.d.b("map", "cb is empty");
                return false;
            }
            this.f11510a = bVar;
            this.f11511b = aVar;
            d.b(context, new C0606a(this, bVar, str));
            c.a.n0.a.e0.d.g("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.j.k.a
    /* renamed from: f */
    public boolean b(Context context, c.a.n0.a.h1.c.a aVar, b bVar, e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, aVar, bVar, eVar, jSONObject)) == null) ? e(context, aVar, bVar, eVar) : invokeLLLLL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.n0.j.o.a M2 = c.a.n0.j.o.a.M2(null);
            M2.R2(this);
            M2.T2();
        }
    }

    @Override // c.a.n0.j.o.a.b
    public void onCancel() {
        c.a.n0.a.h1.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.n0.a.e0.d.g("map", "choose location cancel");
            b bVar = this.f11510a;
            if (bVar == null || (aVar = this.f11511b) == null) {
                return;
            }
            bVar.b(aVar.D, 1002, "choose location canceled");
        }
    }

    @Override // c.a.n0.j.o.a.b
    public void onError() {
        c.a.n0.a.h1.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.n0.a.e0.d.g("map", "choose location fail");
            b bVar = this.f11510a;
            if (bVar == null || (aVar = this.f11511b) == null) {
                return;
            }
            bVar.b(aVar.D, 1007, "choose location failed");
        }
    }
}
