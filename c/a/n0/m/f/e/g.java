package c.a.n0.m.f.e;

import android.content.Context;
import android.text.TextUtils;
import c.a.n0.m.i.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends c.a.n0.m.f.a<c.a.n0.a.y0.c.f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a implements b.InterfaceC0747b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.y0.c.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.y0.b f9028b;

        public a(g gVar, c.a.n0.a.y0.c.f fVar, c.a.n0.a.y0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, fVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.f9028b = bVar;
        }

        @Override // c.a.n0.m.i.b.InterfaceC0747b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.f9028b.c(this.a.y, null);
                }
                c.a.n0.a.u.d.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1699383984, "Lc/a/n0/m/f/e/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1699383984, "Lc/a/n0/m/f/e/g;");
                return;
            }
        }
        boolean z = c.a.n0.a.a.a;
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static g e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new g() : (g) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.m.f.a
    /* renamed from: d */
    public boolean b(Context context, c.a.n0.a.y0.c.f fVar, c.a.n0.a.y0.b bVar, c.a.n0.a.t1.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fVar, bVar, eVar, jSONObject)) == null) ? f(context, fVar, bVar, eVar) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, c.a.n0.a.y0.c.f fVar, c.a.n0.a.y0.b bVar, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, fVar, bVar, eVar)) == null) {
            c.a.n0.a.u.d.i("map", "TranslateMarkerAction start");
            c.a.n0.a.f.e.d A = c.a.n0.a.w0.f.U().A(fVar.f6097c);
            if (!(A instanceof c.a.n0.a.f.e.b)) {
                c.a.n0.a.u.d.c("map", "WebViewManager is null");
                return false;
            }
            c.a.n0.m.i.c d2 = c.a.n0.m.c.b().c((c.a.n0.a.f.e.b) A).d(fVar.f6096b);
            if (d2 == null) {
                c.a.n0.a.u.d.c("map", "can not find map by id " + fVar.f6096b);
                return false;
            }
            return g(fVar, d2, bVar);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(c.a.n0.a.y0.c.f fVar, c.a.n0.m.i.c cVar, c.a.n0.a.y0.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, fVar, cVar, bVar)) == null) {
            if (fVar.isValid()) {
                c.a.n0.a.y0.c.h.c cVar2 = fVar.A;
                LatLng latLng = new LatLng(cVar2.a, cVar2.f7704b);
                List<c.a.n0.m.i.b> I = cVar.I(fVar.z);
                c.a.n0.a.u.d.i("map", "TranslateMarkerAction animation start");
                if (I != null) {
                    for (c.a.n0.m.i.b bVar2 : I) {
                        bVar2.c(cVar, latLng, fVar, new a(this, fVar, bVar));
                    }
                }
                c.a.n0.a.u.d.i("map", "TranslateMarkerAction end");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
