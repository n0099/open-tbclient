package c.a.o0.a.a0.a;

import android.content.Context;
import android.text.TextUtils;
import c.a.o0.a.v2.q;
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
public class h extends c.a.o0.a.a0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a0.b.f f4356e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f4357f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4358g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4359h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f4360i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4361j;

        public a(h hVar, c.a.o0.a.a0.b.f fVar, CanvasView canvasView, String str, UnitedSchemeEntity unitedSchemeEntity, c.a.o0.a.a2.e eVar, CallbackHandler callbackHandler) {
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
            this.f4356e = fVar;
            this.f4357f = canvasView;
            this.f4358g = str;
            this.f4359h = unitedSchemeEntity;
            this.f4360i = eVar;
            this.f4361j = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean k = this.f4356e.k(this.f4357f, this.f4358g);
                HashMap<String, String> params = this.f4359h.getParams();
                if (params == null || params.isEmpty()) {
                    return;
                }
                String str = params.get("params");
                String str2 = null;
                JSONObject jSONObject = new JSONObject();
                if (str != null) {
                    try {
                        str2 = new JSONObject(str).optString("cb");
                        jSONObject.putOpt("tempFilePath", c.a.o0.a.k2.b.J(this.f4358g, this.f4360i.f4530f));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f4361j.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, k ? 0 : 1001).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(c.a.o0.a.c2.e eVar) {
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
                super((c.a.o0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        String str;
        c.a.o0.a.h0.g.f J;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            c.a.o0.a.a0.b.f m = m(unitedSchemeEntity);
            if (m == null) {
                c.a.o0.a.e0.d.b("SwanAppCanvas", "CanvasToTempFilePath action parse model is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            String x = c.a.o0.a.k2.b.x(eVar.f4530f);
            if (TextUtils.isEmpty(x)) {
                c.a.o0.a.e0.d.b("SwanAppCanvas", "CanvasToTempFilePath cache path is empty");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            String str2 = x + File.separator + Calendar.getInstance().getTimeInMillis();
            if (m.j()) {
                str = str2 + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
            } else {
                str = str2 + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
            }
            String str3 = str;
            if (TextUtils.isEmpty(m.f4630g) && (J = c.a.o0.a.g1.f.V().J()) != null) {
                m.f4630g = J.e3();
            }
            if (!TextUtils.isEmpty(m.f4630g) && !TextUtils.isEmpty(m.f4629f)) {
                CanvasView a2 = c.a.o0.a.c0.c.d.b.a.a(m);
                if (a2 == null) {
                    c.a.o0.a.e0.d.b("SwanAppCanvas", "CanvasToTempFilePath canvas view is null");
                    unitedSchemeEntity.result = l(201);
                    return false;
                }
                q.j(new a(this, m, a2, str3, unitedSchemeEntity, eVar, callbackHandler), "tempFilePath");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            c.a.o0.a.e0.d.b("SwanAppCanvas", "CanvasToTempFilePath slave id = " + m.f4630g + " ; canvas id = " + m.f4629f);
            unitedSchemeEntity.result = l(201);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public c.a.o0.a.a0.b.f m(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity)) == null) {
            String str = unitedSchemeEntity.getParams().get("params");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new c.a.o0.a.a0.b.f(str);
        }
        return (c.a.o0.a.a0.b.f) invokeL.objValue;
    }
}
