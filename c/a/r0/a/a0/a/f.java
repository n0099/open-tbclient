package c.a.r0.a.a0.a;

import android.content.Context;
import android.text.TextUtils;
import c.a.r0.a.z2.q;
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
public class f extends c.a.r0.a.a0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.a0.b.e f5202e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f5203f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5204g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f5205h;

        public a(f fVar, c.a.r0.a.a0.b.e eVar, CanvasView canvasView, CallbackHandler callbackHandler) {
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
            this.f5205h = fVar;
            this.f5202e = eVar;
            this.f5203f = canvasView;
            this.f5204g = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f5202e.i();
                if (i2 != 0) {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(i2, this.f5205h.n(i2));
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0);
                    this.f5203f.addDrawActionList(this.f5202e.j(), this.f5202e.k());
                    this.f5203f.postInvalidate();
                }
                String str = this.f5202e.f5453i;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f5204g.handleSchemeDispatchCallback(str, wrapCallbackParams.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.r0.a.f2.e eVar) {
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
                super((c.a.r0.a.f2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        c.a.r0.a.h0.g.f H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            c.a.r0.a.a0.b.e o = o(unitedSchemeEntity);
            if (o == null) {
                c.a.r0.a.e0.d.c("SwanAppCanvas", "CanvasPutImageData action parse model is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            if (TextUtils.isEmpty(o.f5451g) && (H = c.a.r0.a.g1.f.U().H()) != null) {
                o.f5451g = H.n3();
            }
            if (!TextUtils.isEmpty(o.f5451g) && !TextUtils.isEmpty(o.f5450f)) {
                CanvasView a2 = c.a.r0.a.c0.c.d.b.a.a(o);
                if (a2 == null) {
                    c.a.r0.a.e0.d.c("SwanAppCanvas", "CanvasPutImageData canvas view is null");
                    unitedSchemeEntity.result = l(201);
                    return false;
                }
                q.k(new a(this, o, a2, callbackHandler), "CanvasPutImageDataAction");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            c.a.r0.a.e0.d.c("SwanAppCanvas", "CanvasPutImageData slave id = " + o.f5451g + " ; canvas id = " + o.f5450f);
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

    public c.a.r0.a.a0.b.e o(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) {
            String str = unitedSchemeEntity.getParams().get("params");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new c.a.r0.a.a0.b.e(str);
        }
        return (c.a.r0.a.a0.b.e) invokeL.objValue;
    }
}
