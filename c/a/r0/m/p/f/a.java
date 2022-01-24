package c.a.r0.m.p.f;

import android.content.Context;
import android.text.TextUtils;
import c.a.r0.a.d2.e;
import c.a.r0.a.i1.b;
import c.a.r0.a.k;
import c.a.r0.m.l.f.d;
import c.a.r0.m.p.a;
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
/* loaded from: classes6.dex */
public class a extends c.a.r0.m.l.a<c.a.r0.a.i1.c.a> implements a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.a.i1.c.a f11550b;

    /* renamed from: c.a.r0.m.p.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0798a implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11551b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f11552c;

        public C0798a(a aVar, b bVar, String str) {
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
            this.f11552c = aVar;
            this.a = bVar;
            this.f11551b = str;
        }

        @Override // c.a.r0.m.l.f.d.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.e0.d.o("map", "location permission fail");
                this.a.b(this.f11551b, 1003, "location permission fail");
            }
        }

        @Override // c.a.r0.m.l.f.d.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.r0.a.e0.d.o("map", "location permission success");
                this.f11552c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-10933713, "Lc/a/r0/m/p/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-10933713, "Lc/a/r0/m/p/f/a;");
                return;
            }
        }
        boolean z = k.a;
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

    @Override // c.a.r0.m.p.a.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        b bVar;
        c.a.r0.a.i1.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) || (bVar = this.a) == null || (aVar = this.f11550b) == null) {
            return;
        }
        bVar.c(aVar.D, selectedLocationInfo.toJson());
    }

    public final boolean e(Context context, c.a.r0.a.i1.c.a aVar, b bVar, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, aVar, bVar, eVar)) == null) {
            c.a.r0.a.e0.d.i("map", "ChooseLocationAction start");
            if (!aVar.isValid()) {
                c.a.r0.a.e0.d.c("map", "model is invalid");
                return false;
            }
            String str = aVar.D;
            if (TextUtils.isEmpty(str)) {
                c.a.r0.a.e0.d.c("map", "cb is empty");
                return false;
            }
            this.a = bVar;
            this.f11550b = aVar;
            d.b(context, new C0798a(this, bVar, str));
            c.a.r0.a.e0.d.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.m.l.a
    /* renamed from: f */
    public boolean b(Context context, c.a.r0.a.i1.c.a aVar, b bVar, e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, aVar, bVar, eVar, jSONObject)) == null) ? e(context, aVar, bVar, eVar) : invokeLLLLL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.r0.m.p.a V2 = c.a.r0.m.p.a.V2(null);
            V2.a3(this);
            V2.c3();
        }
    }

    @Override // c.a.r0.m.p.a.b
    public void onCancel() {
        c.a.r0.a.i1.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.r0.a.e0.d.i("map", "choose location cancel");
            b bVar = this.a;
            if (bVar == null || (aVar = this.f11550b) == null) {
                return;
            }
            bVar.b(aVar.D, 1002, "choose location canceled");
        }
    }

    @Override // c.a.r0.m.p.a.b
    public void onError() {
        c.a.r0.a.i1.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.r0.a.e0.d.i("map", "choose location fail");
            b bVar = this.a;
            if (bVar == null || (aVar = this.f11550b) == null) {
                return;
            }
            bVar.b(aVar.D, 1007, "choose location failed");
        }
    }
}
