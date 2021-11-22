package b.a.p0.m.p.f;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.d2.e;
import b.a.p0.a.i1.b;
import b.a.p0.a.k;
import b.a.p0.m.l.f.d;
import b.a.p0.m.p.a;
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
/* loaded from: classes4.dex */
public class a extends b.a.p0.m.l.a<b.a.p0.a.i1.c.a> implements a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f11668a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.i1.c.a f11669b;

    /* renamed from: b.a.p0.m.p.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0640a implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f11670a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11671b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f11672c;

        public C0640a(a aVar, b bVar, String str) {
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
            this.f11672c = aVar;
            this.f11670a = bVar;
            this.f11671b = str;
        }

        @Override // b.a.p0.m.l.f.d.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.e0.d.o("map", "location permission fail");
                this.f11670a.b(this.f11671b, 1003, "location permission fail");
            }
        }

        @Override // b.a.p0.m.l.f.d.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.p0.a.e0.d.o("map", "location permission success");
                this.f11672c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2075417196, "Lb/a/p0/m/p/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2075417196, "Lb/a/p0/m/p/f/a;");
                return;
            }
        }
        boolean z = k.f6863a;
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

    @Override // b.a.p0.m.p.a.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        b bVar;
        b.a.p0.a.i1.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) || (bVar = this.f11668a) == null || (aVar = this.f11669b) == null) {
            return;
        }
        bVar.c(aVar.D, selectedLocationInfo.toJson());
    }

    public final boolean e(Context context, b.a.p0.a.i1.c.a aVar, b bVar, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, aVar, bVar, eVar)) == null) {
            b.a.p0.a.e0.d.i("map", "ChooseLocationAction start");
            if (!aVar.isValid()) {
                b.a.p0.a.e0.d.c("map", "model is invalid");
                return false;
            }
            String str = aVar.D;
            if (TextUtils.isEmpty(str)) {
                b.a.p0.a.e0.d.c("map", "cb is empty");
                return false;
            }
            this.f11668a = bVar;
            this.f11669b = aVar;
            d.b(context, new C0640a(this, bVar, str));
            b.a.p0.a.e0.d.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.m.l.a
    /* renamed from: f */
    public boolean b(Context context, b.a.p0.a.i1.c.a aVar, b bVar, e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, aVar, bVar, eVar, jSONObject)) == null) ? e(context, aVar, bVar, eVar) : invokeLLLLL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b.a.p0.m.p.a Y2 = b.a.p0.m.p.a.Y2(null);
            Y2.d3(this);
            Y2.f3();
        }
    }

    @Override // b.a.p0.m.p.a.b
    public void onCancel() {
        b.a.p0.a.i1.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a.p0.a.e0.d.i("map", "choose location cancel");
            b bVar = this.f11668a;
            if (bVar == null || (aVar = this.f11669b) == null) {
                return;
            }
            bVar.b(aVar.D, 1002, "choose location canceled");
        }
    }

    @Override // b.a.p0.m.p.a.b
    public void onError() {
        b.a.p0.a.i1.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b.a.p0.a.e0.d.i("map", "choose location fail");
            b bVar = this.f11668a;
            if (bVar == null || (aVar = this.f11669b) == null) {
                return;
            }
            bVar.b(aVar.D, 1007, "choose location failed");
        }
    }
}
