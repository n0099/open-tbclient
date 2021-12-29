package c.a.h0.t.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import c.a.h0.c;
import c.a.h0.g;
import c.a.h0.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static Toast a;
    public transient /* synthetic */ FieldHolder $fh;

    public static View a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            View inflate = LayoutInflater.from(context).inflate(h.layout_poly_sdk_simple_toast, (ViewGroup) null);
            ((TextView) inflate.findViewById(g.poly_sdk_toast_msg_tv)).setText(str);
            return inflate;
        }
        return (View) invokeLL.objValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            Toast toast = new Toast(context.getApplicationContext());
            a = toast;
            toast.setGravity(17, 0, 0);
            a.setDuration(0);
        }
    }

    public static View c(Context context, int i2, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i2), str, Boolean.valueOf(z)})) == null) {
            View inflate = LayoutInflater.from(context).inflate(h.layout_poly_sdk_common_toast, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(g.poly_sdk_toast_msg_icon);
            TextView textView = (TextView) inflate.findViewById(g.poly_sdk_toast_msg_tv);
            if (-1 == i2) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                imageView.setImageResource(i2);
                if (z) {
                    imageView.startAnimation(AnimationUtils.loadAnimation(context, c.loading_rotate));
                }
            }
            textView.setText(str);
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    public static void d(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65539, null, context, i2, str) == null) || context == null) {
            return;
        }
        Toast toast = a;
        if (toast != null) {
            toast.cancel();
        }
        b(context);
        a.setView(c(context, i2, str, false));
        a.show();
    }

    public static void e(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i2, str) == null) || context == null) {
            return;
        }
        Toast toast = a;
        if (toast != null) {
            toast.cancel();
        }
        b(context);
        a.setView(c(context, i2, str, true));
        a.show();
    }

    public static void f(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, context, str) == null) || context == null) {
            return;
        }
        Toast toast = a;
        if (toast != null) {
            toast.cancel();
        }
        b(context);
        a.setView(a(context, str));
        a.show();
    }
}
