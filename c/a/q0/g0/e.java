package c.a.q0.g0;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static d a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view)) == null) {
            if (view == null) {
                return null;
            }
            if (view instanceof LinearLayout) {
                return new f();
            }
            if (view instanceof RelativeLayout) {
                return new i();
            }
            if (view instanceof FrameLayout) {
                return new b();
            }
            return null;
        }
        return (d) invokeL.objValue;
    }

    public static d b(View view, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, view, z)) == null) {
            if (view == null) {
                return null;
            }
            if (view instanceof LinearLayout) {
                return new f();
            }
            if (view instanceof RelativeLayout) {
                return new i();
            }
            if (view instanceof FrameLayout) {
                return z ? new j() : new b();
            }
            return null;
        }
        return (d) invokeLZ.objValue;
    }
}
