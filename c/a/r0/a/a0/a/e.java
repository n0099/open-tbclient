package c.a.r0.a.a0.a;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import c.a.r0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.r0.a.f2.e eVar) {
        super(eVar, "/swanAPI/canvas/measureTextSync");
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
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            unitedSchemeEntity.result = l(201);
            c.a.r0.a.a0.b.d m = m(unitedSchemeEntity);
            if (m == null) {
                return false;
            }
            String str = m.o;
            if (str == null || str.length() <= 0) {
                i2 = 0;
            } else {
                if (m.r && m.s) {
                    i3 = 3;
                } else if (m.r) {
                    i3 = 1;
                } else {
                    i3 = m.s ? 2 : 0;
                }
                TextPaint textPaint = new TextPaint();
                textPaint.setTypeface(Typeface.create(m.p, i3));
                textPaint.setTextSize(m.q);
                Rect rect = new Rect();
                String str2 = m.o;
                textPaint.getTextBounds(str2, 0, str2.length(), rect);
                i2 = n0.P(rect.width());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("width", Integer.valueOf(i2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public c.a.r0.a.a0.b.d m(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity)) == null) {
            String str = unitedSchemeEntity.getParams().get("params");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new c.a.r0.a.a0.b.d(str);
        }
        return (c.a.r0.a.a0.b.d) invokeL.objValue;
    }
}
