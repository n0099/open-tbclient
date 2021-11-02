package b.a.p0.a.a0.a;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.v2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
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
public class h extends b.a.p0.a.a0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a0.b.f f3792e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CanvasView f3793f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f3794g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f3795h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f3796i;
        public final /* synthetic */ CallbackHandler j;

        public a(h hVar, b.a.p0.a.a0.b.f fVar, CanvasView canvasView, String str, UnitedSchemeEntity unitedSchemeEntity, b.a.p0.a.a2.e eVar, CallbackHandler callbackHandler) {
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
            this.f3792e = fVar;
            this.f3793f = canvasView;
            this.f3794g = str;
            this.f3795h = unitedSchemeEntity;
            this.f3796i = eVar;
            this.j = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean j = this.f3792e.j(this.f3793f, this.f3794g);
                HashMap<String, String> params = this.f3795h.getParams();
                if (params == null || params.isEmpty()) {
                    return;
                }
                String str = params.get("params");
                String str2 = null;
                JSONObject jSONObject = new JSONObject();
                if (str != null) {
                    try {
                        str2 = new JSONObject(str).optString("cb");
                        jSONObject.putOpt("tempFilePath", b.a.p0.a.k2.b.J(this.f3794g, this.f3796i.f3961f));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.j.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, j ? 0 : 1001).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(b.a.p0.a.c2.e eVar) {
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
        String str;
        b.a.p0.a.h0.g.f H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            b.a.p0.a.a0.b.f m = m(unitedSchemeEntity);
            if (m == null) {
                b.a.p0.a.e0.d.b("SwanAppCanvas", "CanvasToTempFilePath action parse model is null");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            String x = b.a.p0.a.k2.b.x(eVar.f3961f);
            if (TextUtils.isEmpty(x)) {
                b.a.p0.a.e0.d.b("SwanAppCanvas", "CanvasToTempFilePath cache path is empty");
                unitedSchemeEntity.result = l(201);
                return false;
            }
            String str2 = x + File.separator + Calendar.getInstance().getTimeInMillis();
            if (m.i()) {
                str = str2 + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
            } else {
                str = str2 + ".png";
            }
            String str3 = str;
            if (TextUtils.isEmpty(m.f4057g) && (H = b.a.p0.a.g1.f.T().H()) != null) {
                m.f4057g = H.a3();
            }
            if (!TextUtils.isEmpty(m.f4057g) && !TextUtils.isEmpty(m.f4056f)) {
                CanvasView a2 = b.a.p0.a.c0.c.d.b.a.a(m);
                if (a2 == null) {
                    b.a.p0.a.e0.d.b("SwanAppCanvas", "CanvasToTempFilePath canvas view is null");
                    unitedSchemeEntity.result = l(201);
                    return false;
                }
                q.j(new a(this, m, a2, str3, unitedSchemeEntity, eVar, callbackHandler), "tempFilePath");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            b.a.p0.a.e0.d.b("SwanAppCanvas", "CanvasToTempFilePath slave id = " + m.f4057g + " ; canvas id = " + m.f4056f);
            unitedSchemeEntity.result = l(201);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public b.a.p0.a.a0.b.f m(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity)) == null) {
            String str = unitedSchemeEntity.getParams().get("params");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new b.a.p0.a.a0.b.f(str);
        }
        return (b.a.p0.a.a0.b.f) invokeL.objValue;
    }
}
