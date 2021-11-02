package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
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
/* loaded from: classes7.dex */
public class be implements bk.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public be() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.mobstat.bk.b
    public void a(View view, boolean z, Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Boolean.valueOf(z), activity}) == null) || activity == null || view == null) {
            return;
        }
        ar.a(view, activity);
        if (bd.c().b() && z) {
            bd c2 = bd.c();
            c2.a("OnEvent view:" + view.getClass().getName() + "; content:" + bj.h(view) + "; activity:" + activity.getClass().getName());
        }
        if (bh.c().b()) {
            bh c3 = bh.c();
            c3.a("OnEvent view:" + view.getClass().getName() + "; content:" + bj.h(view) + "; activity:" + activity.getClass().getName());
        }
        JSONArray a2 = bj.a(activity, view);
        String f2 = bj.f(view);
        Map<String, String> g2 = bj.g(view);
        String a3 = bj.a(view);
        Context applicationContext = activity.getApplicationContext();
        long currentTimeMillis = System.currentTimeMillis();
        JSONArray jSONArray = new JSONArray();
        String name = activity.getClass().getName();
        if (z) {
            BDStatCore.instance().onEvent(applicationContext, "", a3, 1, currentTimeMillis, a2, jSONArray, name, "", f2, g2);
        }
        aw.a().a(applicationContext, "", bj.k(view), 1, currentTimeMillis, name, a2, "", jSONArray, f2, g2, a(activity, view, az.a().b()), a(activity, view));
    }

    private JSONObject a(Activity activity, View view, PointF pointF) {
        InterceptResult invokeLLL;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, activity, view, pointF)) == null) {
            if (pointF == null) {
                return null;
            }
            view.getLocationOnScreen(new int[2]);
            float f2 = pointF.x - iArr[0];
            float f3 = pointF.y - iArr[1];
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            float b2 = ah.b(activity, f2);
            float b3 = ah.b(activity, f3);
            float a2 = ah.a(activity, bj.o(view));
            float a3 = ah.a(activity, bj.p(view));
            if (a2 == 0.0f || a3 == 0.0f) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                DecimalFormat decimalFormat = new DecimalFormat(XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT);
                DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
                decimalFormatSymbols.setDecimalSeparator('.');
                decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
                jSONObject.put("x", decimalFormat.format(b2));
                jSONObject.put("y", decimalFormat.format(b3));
                jSONObject.put("xp", decimalFormat.format((b2 * 100.0f) / a2));
                jSONObject.put("yp", decimalFormat.format((b3 * 100.0f) / a3));
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    private String a(Activity activity, View view) {
        InterceptResult invokeLL;
        View a2;
        View n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, activity, view)) == null) {
            if (activity == null || view == null || (n = bj.n((a2 = bj.a(view, activity)))) == null) {
                return "";
            }
            String a3 = at.a().a(activity, a2, n);
            return !TextUtils.isEmpty(a3) ? a3 : "";
        }
        return (String) invokeLL.objValue;
    }
}
