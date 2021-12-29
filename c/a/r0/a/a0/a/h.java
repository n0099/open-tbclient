package c.a.r0.a.a0.a;

import android.content.Context;
import android.text.TextUtils;
import c.a.r0.a.z2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends c.a.r0.a.a0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.a0.b.f f5172e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f5173f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5174g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5175h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f5176i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5177j;

        public a(h hVar, c.a.r0.a.a0.b.f fVar, CanvasView canvasView, String str, UnitedSchemeEntity unitedSchemeEntity, c.a.r0.a.d2.e eVar, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, fVar, canvasView, str, unitedSchemeEntity, eVar, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5172e = fVar;
            this.f5173f = canvasView;
            this.f5174g = str;
            this.f5175h = unitedSchemeEntity;
            this.f5176i = eVar;
            this.f5177j = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean j2 = this.f5172e.j(this.f5173f, this.f5174g);
                HashMap<String, String> params = this.f5175h.getParams();
                if (params == null || params.isEmpty()) {
                    return;
                }
                String str = params.get("params");
                String str2 = null;
                JSONObject jSONObject = new JSONObject();
                if (str != null) {
                    try {
                        str2 = new JSONObject(str).optString("cb");
                        jSONObject.putOpt("tempFilePath", c.a.r0.a.o2.b.J(this.f5174g, this.f5176i.f5660f));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f5177j.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, j2 ? 0 : 1001).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(c.a.r0.a.f2.e eVar) {
        super(eVar, "/swanAPI/canvas/toTempFilePath");
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
        String str;
        c.a.r0.a.h0.g.f H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            c.a.r0.a.a0.b.f m = m(unitedSchemeEntity);
            if (m == null) {
                c.a.r0.a.e0.d.c("SwanAppCanvas", "CanvasToTempFilePath action parse model is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            String x = c.a.r0.a.o2.b.x(eVar.f5660f);
            if (TextUtils.isEmpty(x)) {
                c.a.r0.a.e0.d.c("SwanAppCanvas", "CanvasToTempFilePath cache path is empty");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            String str2 = x + File.separator + Calendar.getInstance().getTimeInMillis();
            if (m.i()) {
                str = str2 + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
            } else {
                str = str2 + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
            }
            String str3 = str;
            if (TextUtils.isEmpty(m.f5422g) && (H = c.a.r0.a.g1.f.U().H()) != null) {
                m.f5422g = H.n3();
            }
            if (!TextUtils.isEmpty(m.f5422g) && !TextUtils.isEmpty(m.f5421f)) {
                CanvasView a2 = c.a.r0.a.c0.c.d.b.a.a(m);
                if (a2 == null) {
                    c.a.r0.a.e0.d.c("SwanAppCanvas", "CanvasToTempFilePath canvas view is null");
                    unitedSchemeEntity.result = l(201);
                    return false;
                }
                q.k(new a(this, m, a2, str3, unitedSchemeEntity, eVar, callbackHandler), "tempFilePath");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            c.a.r0.a.e0.d.c("SwanAppCanvas", "CanvasToTempFilePath slave id = " + m.f5422g + " ; canvas id = " + m.f5421f);
            unitedSchemeEntity.result = l(201);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public c.a.r0.a.a0.b.f m(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity)) == null) {
            String str = unitedSchemeEntity.getParams().get("params");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new c.a.r0.a.a0.b.f(str);
        }
        return (c.a.r0.a.a0.b.f) invokeL.objValue;
    }
}
