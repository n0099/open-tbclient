package c.a.p0.m.l.e;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.k;
import c.a.p0.m.o.b;
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
/* loaded from: classes5.dex */
public class g extends c.a.p0.m.l.a<c.a.p0.a.i1.c.f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements b.InterfaceC0694b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.i1.c.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.i1.b f10572b;

        public a(g gVar, c.a.p0.a.i1.c.f fVar, c.a.p0.a.i1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, fVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.f10572b = bVar;
        }

        @Override // c.a.p0.m.o.b.InterfaceC0694b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.C)) {
                    this.f10572b.c(this.a.C, null);
                }
                c.a.p0.a.e0.d.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-826544500, "Lc/a/p0/m/l/e/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-826544500, "Lc/a/p0/m/l/e/g;");
                return;
            }
        }
        boolean z = k.a;
    }

    public g() {
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

    public static g e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new g() : (g) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.m.l.a
    /* renamed from: d */
    public boolean b(Context context, c.a.p0.a.i1.c.f fVar, c.a.p0.a.i1.b bVar, c.a.p0.a.d2.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fVar, bVar, eVar, jSONObject)) == null) ? f(context, fVar, bVar, eVar) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, c.a.p0.a.i1.c.f fVar, c.a.p0.a.i1.b bVar, c.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, fVar, bVar, eVar)) == null) {
            c.a.p0.a.e0.d.i("map", "TranslateMarkerAction start");
            c.a.p0.a.p.e.d A = c.a.p0.a.g1.f.U().A(fVar.f4378g);
            if (!(A instanceof c.a.p0.a.p.e.b)) {
                c.a.p0.a.e0.d.c("map", "WebViewManager is null");
                return false;
            }
            c.a.p0.m.o.c d2 = c.a.p0.m.c.b().c((c.a.p0.a.p.e.b) A).d(fVar.f4377f);
            if (d2 == null) {
                c.a.p0.a.e0.d.c("map", "can not find map by id " + fVar.f4377f);
                return false;
            }
            return g(fVar, d2, bVar);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(c.a.p0.a.i1.c.f fVar, c.a.p0.m.o.c cVar, c.a.p0.a.i1.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, fVar, cVar, bVar)) == null) {
            if (fVar.isValid()) {
                c.a.p0.a.i1.c.h.c cVar2 = fVar.E;
                LatLng latLng = new LatLng(cVar2.f6330e, cVar2.f6331f);
                List<c.a.p0.m.o.b> I = cVar.I(fVar.D);
                c.a.p0.a.e0.d.i("map", "TranslateMarkerAction animation start");
                if (I != null) {
                    for (c.a.p0.m.o.b bVar2 : I) {
                        bVar2.c(cVar, latLng, fVar, new a(this, fVar, bVar));
                    }
                }
                c.a.p0.a.e0.d.i("map", "TranslateMarkerAction end");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
