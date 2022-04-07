package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.mobstat.bk;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class be implements bk.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public be() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.mobstat.bk.b
    public void a(View view2, boolean z, Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Boolean.valueOf(z), activity}) == null) || activity == null || view2 == null) {
            return;
        }
        ar.a(view2, activity);
        if (bd.c().b() && z) {
            bd c = bd.c();
            c.a("OnEvent view:" + view2.getClass().getName() + "; content:" + bj.h(view2) + "; activity:" + activity.getClass().getName());
        }
        if (bh.c().b()) {
            bh c2 = bh.c();
            c2.a("OnEvent view:" + view2.getClass().getName() + "; content:" + bj.h(view2) + "; activity:" + activity.getClass().getName());
        }
        JSONArray a = bj.a(activity, view2);
        String f = bj.f(view2);
        Map<String, String> g = bj.g(view2);
        String a2 = bj.a(view2);
        Context applicationContext = activity.getApplicationContext();
        long currentTimeMillis = System.currentTimeMillis();
        JSONArray jSONArray = new JSONArray();
        String name = activity.getClass().getName();
        if (z) {
            BDStatCore.instance().onEvent(applicationContext, "", a2, 1, currentTimeMillis, a, jSONArray, name, "", f, g);
        }
        aw.a().a(applicationContext, "", bj.k(view2), 1, currentTimeMillis, name, a, "", jSONArray, f, g, a(activity, view2, az.a().b()), a(activity, view2));
    }

    private JSONObject a(Activity activity, View view2, PointF pointF) {
        InterceptResult invokeLLL;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, activity, view2, pointF)) == null) {
            if (pointF == null) {
                return null;
            }
            view2.getLocationOnScreen(new int[2]);
            float f = pointF.x - iArr[0];
            float f2 = pointF.y - iArr[1];
            if (f < 0.0f) {
                f = 0.0f;
            }
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            float b = ah.b(activity, f);
            float b2 = ah.b(activity, f2);
            float a = ah.a(activity, bj.o(view2));
            float a2 = ah.a(activity, bj.p(view2));
            if (a == 0.0f || a2 == 0.0f) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
                decimalFormatSymbols.setDecimalSeparator(IStringUtil.EXTENSION_SEPARATOR);
                decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
                jSONObject.put("x", decimalFormat.format(b));
                jSONObject.put("y", decimalFormat.format(b2));
                jSONObject.put(Config.EVENT_HEAT_XP, decimalFormat.format((b * 100.0f) / a));
                jSONObject.put(Config.EVENT_HEAT_YP, decimalFormat.format((b2 * 100.0f) / a2));
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    private String a(Activity activity, View view2) {
        InterceptResult invokeLL;
        View a;
        View n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, activity, view2)) == null) {
            if (activity == null || view2 == null || (n = bj.n((a = bj.a(view2, activity)))) == null) {
                return "";
            }
            String a2 = at.a().a(activity, a, n);
            return !TextUtils.isEmpty(a2) ? a2 : "";
        }
        return (String) invokeLL.objValue;
    }
}
