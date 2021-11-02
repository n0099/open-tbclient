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
public class f extends b.a.p0.a.a0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a0.b.e f3788e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f3789f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f3790g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f3791h;

        public a(f fVar, b.a.p0.a.a0.b.e eVar, CanvasView canvasView, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, eVar, canvasView, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3791h = fVar;
            this.f3788e = eVar;
            this.f3789f = canvasView;
            this.f3790g = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f3788e.i();
                if (i2 != 0) {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(i2, this.f3791h.n(i2));
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0);
                    this.f3789f.addDrawActionList(this.f3788e.j(), this.f3788e.k());
                    this.f3789f.postInvalidate();
                }
                String str = this.f3788e.f4059i;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f3790g.handleSchemeDispatchCallback(str, wrapCallbackParams.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(b.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/canvas/putImageData");
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
            b.a.p0.a.a0.b.e o = o(unitedSchemeEntity);
            if (o == null) {
                b.a.p0.a.e0.d.b("SwanAppCanvas", "CanvasPutImageData action parse model is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            if (TextUtils.isEmpty(o.f4057g) && (H = b.a.p0.a.g1.f.T().H()) != null) {
                o.f4057g = H.a3();
            }
            if (!TextUtils.isEmpty(o.f4057g) && !TextUtils.isEmpty(o.f4056f)) {
                CanvasView a2 = b.a.p0.a.c0.c.d.b.a.a(o);
                if (a2 == null) {
                    b.a.p0.a.e0.d.b("SwanAppCanvas", "CanvasPutImageData canvas view is null");
                    unitedSchemeEntity.result = l(201);
                    return false;
                }
                q.j(new a(this, o, a2, callbackHandler), "CanvasPutImageDataAction");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            b.a.p0.a.e0.d.b("SwanAppCanvas", "CanvasPutImageData slave id = " + o.f4057g + " ; canvas id = " + o.f4056f);
            unitedSchemeEntity.result = l(201);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i2 != 2001 ? i2 != 2002 ? "error draw on canvas" : "width / height must > 0" : "data length invalid" : (String) invokeI.objValue;
    }

    public b.a.p0.a.a0.b.e o(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) {
            String str = unitedSchemeEntity.getParams().get("params");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new b.a.p0.a.a0.b.e(str);
        }
        return (b.a.p0.a.a0.b.e) invokeL.objValue;
    }
}
