package b.a.p0.m.l.e;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.k;
import b.a.p0.m.o.b;
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
/* loaded from: classes4.dex */
public class g extends b.a.p0.m.l.a<b.a.p0.a.i1.c.f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements b.InterfaceC0638b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.i1.c.f f11599a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.i1.b f11600b;

        public a(g gVar, b.a.p0.a.i1.c.f fVar, b.a.p0.a.i1.b bVar) {
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
            this.f11599a = fVar;
            this.f11600b = bVar;
        }

        @Override // b.a.p0.m.o.b.InterfaceC0638b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.f11599a.C)) {
                    this.f11600b.c(this.f11599a.C, null);
                }
                b.a.p0.a.e0.d.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1960870987, "Lb/a/p0/m/l/e/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1960870987, "Lb/a/p0/m/l/e/g;");
                return;
            }
        }
        boolean z = k.f6863a;
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
    @Override // b.a.p0.m.l.a
    /* renamed from: d */
    public boolean b(Context context, b.a.p0.a.i1.c.f fVar, b.a.p0.a.i1.b bVar, b.a.p0.a.d2.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fVar, bVar, eVar, jSONObject)) == null) ? f(context, fVar, bVar, eVar) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, b.a.p0.a.i1.c.f fVar, b.a.p0.a.i1.b bVar, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, fVar, bVar, eVar)) == null) {
            b.a.p0.a.e0.d.i("map", "TranslateMarkerAction start");
            b.a.p0.a.p.e.d A = b.a.p0.a.g1.f.U().A(fVar.f4197g);
            if (!(A instanceof b.a.p0.a.p.e.b)) {
                b.a.p0.a.e0.d.c("map", "WebViewManager is null");
                return false;
            }
            b.a.p0.m.o.c d2 = b.a.p0.m.c.b().c((b.a.p0.a.p.e.b) A).d(fVar.f4196f);
            if (d2 == null) {
                b.a.p0.a.e0.d.c("map", "can not find map by id " + fVar.f4196f);
                return false;
            }
            return g(fVar, d2, bVar);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(b.a.p0.a.i1.c.f fVar, b.a.p0.m.o.c cVar, b.a.p0.a.i1.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, fVar, cVar, bVar)) == null) {
            if (fVar.isValid()) {
                b.a.p0.a.i1.c.h.c cVar2 = fVar.E;
                LatLng latLng = new LatLng(cVar2.f6486e, cVar2.f6487f);
                List<b.a.p0.m.o.b> I = cVar.I(fVar.D);
                b.a.p0.a.e0.d.i("map", "TranslateMarkerAction animation start");
                if (I != null) {
                    for (b.a.p0.m.o.b bVar2 : I) {
                        bVar2.c(cVar, latLng, fVar, new a(this, fVar, bVar));
                    }
                }
                b.a.p0.a.e0.d.i("map", "TranslateMarkerAction end");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
