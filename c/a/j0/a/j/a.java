package c.a.j0.a.j;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import c.a.f0.b.g.e;
import c.a.j0.a.k.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f3650a;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3650a = context;
    }

    public final void a(RelativeLayout.LayoutParams layoutParams, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(1048576, this, layoutParams, i2, i3, i4) == null) && (i2 & i3) == i3) {
            layoutParams.addRule(i4);
        }
    }

    public final int b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? jSONObject.optInt("l_gravity") : invokeL.intValue;
    }

    public final int[] c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            int[] iArr = {0, 0, 0, 0};
            String optString = jSONObject.optString("margin");
            boolean z = jSONObject.optInt("is_equal_bottom_logo", 0) == 1;
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split("_");
                if (split.length == 4) {
                    for (int i2 = 0; i2 < 4; i2++) {
                        try {
                            iArr[i2] = Integer.parseInt(split[i2]);
                        } catch (Exception unused) {
                            iArr[i2] = 0;
                        }
                        if (i2 == 3 && z) {
                            iArr[i2] = iArr[i2] + e.b();
                        }
                    }
                }
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public final void d(RelativeLayout.LayoutParams layoutParams, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, layoutParams, i2) == null) || i2 <= 0) {
            return;
        }
        a(layoutParams, i2, 1, 10);
        a(layoutParams, i2, 2, 12);
        a(layoutParams, i2, 4, 9);
        a(layoutParams, i2, 8, 11);
        a(layoutParams, i2, 16, 14);
        a(layoutParams, i2, 32, 15);
    }

    public final void e(ViewGroup.MarginLayoutParams marginLayoutParams, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, marginLayoutParams, iArr) == null) && iArr != null && iArr.length == 4) {
            marginLayoutParams.setMargins(h.a(this.f3650a, iArr[0]), h.a(this.f3650a, iArr[1]), h.a(this.f3650a, iArr[2]), h.a(this.f3650a, iArr[3]));
        }
    }

    public final void f(RelativeLayout.LayoutParams layoutParams, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, layoutParams, jSONObject) == null) || jSONObject == null) {
            return;
        }
        d(layoutParams, b(jSONObject));
        e(layoutParams, c(jSONObject));
    }

    public void g(ViewGroup.LayoutParams layoutParams, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, layoutParams, jSONObject) == null) || layoutParams == null || jSONObject == null || !(layoutParams instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        f((RelativeLayout.LayoutParams) layoutParams, jSONObject);
    }
}
