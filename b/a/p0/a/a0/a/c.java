package b.a.p0.a.a0.a;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.v2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends b.a.p0.a.a0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a0.b.c f3785e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f3786f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f3787g;

        public a(c cVar, b.a.p0.a.a0.b.c cVar2, CanvasView canvasView, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2, canvasView, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3785e = cVar2;
            this.f3786f = canvasView;
            this.f3787g = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject j = this.f3785e.j(this.f3786f);
                String str = this.f3785e.f4059i;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f3787g.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(j, 0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/canvas/getImageData");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b.a.p0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        b.a.p0.a.h0.g.f H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            b.a.p0.a.a0.b.c m = m(unitedSchemeEntity);
            if (m == null) {
                b.a.p0.a.e0.d.b("SwanAppCanvas", "CanvasGetImageData action parse model is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            if (TextUtils.isEmpty(m.f4057g) && (H = b.a.p0.a.g1.f.T().H()) != null) {
                m.f4057g = H.a3();
            }
            if (!TextUtils.isEmpty(m.f4057g) && !TextUtils.isEmpty(m.f4056f)) {
                CanvasView a2 = b.a.p0.a.c0.c.d.b.a.a(m);
                if (a2 == null) {
                    b.a.p0.a.e0.d.b("SwanAppCanvas", "CanvasGetImageData canvas view is null");
                    unitedSchemeEntity.result = l(201);
                    return false;
                }
                q.j(new a(this, m, a2, callbackHandler), "CanvasGetImageDataAction");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            b.a.p0.a.e0.d.b("SwanAppCanvas", "CanvasGetImageData slave id = " + m.f4057g + " ; canvas id = " + m.f4056f);
            unitedSchemeEntity.result = l(201);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public b.a.p0.a.a0.b.c m(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity)) == null) {
            String str = unitedSchemeEntity.getParams().get("params");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new b.a.p0.a.a0.b.c(str);
        }
        return (b.a.p0.a.a0.b.c) invokeL.objValue;
    }
}
