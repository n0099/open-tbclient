package c.a.p0.s3;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Activity activity, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, activity, i2, str)) == null) {
            if (c(i2)) {
                d(activity, str);
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static String b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view)) == null) {
            if (view == null) {
                return null;
            }
            Object tag = view.getTag();
            if (tag instanceof PostData) {
                PostData postData = (PostData) tag;
                if (postData.t() != null) {
                    return postData.t().getUserId();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 == 1990059 : invokeI.booleanValue;
    }

    public static void d(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, activity, str) == null) || activity == null || TextUtils.isEmpty(str)) {
            return;
        }
        f((ViewGroup) activity.findViewById(16908290), str, false);
    }

    public static void e(View view, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, view, postData) == null) || view == null) {
            return;
        }
        view.setTag(postData);
    }

    public static void f(ViewGroup viewGroup, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(AdIconUtil.AD_TEXT_ID, null, viewGroup, str, z) == null) || viewGroup == null || TextUtils.isEmpty(str)) {
            return;
        }
        new BdTopToast(viewGroup.getContext()).setIcon(z).setContent(str).show(viewGroup);
    }
}
