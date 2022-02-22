package c.a.t0.s.l0;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ImageView imageView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65536, null, imageView, i2) == null) || imageView == null) {
            return;
        }
        WebPManager.setPureDrawable(imageView, i2, c.a.u0.a4.d.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = n.f(TbadkApplication.getInst(), c.a.u0.a4.e.tbds52);
            layoutParams.height = n.f(TbadkApplication.getInst(), c.a.u0.a4.e.tbds52);
            imageView.setLayoutParams(layoutParams);
        }
    }

    public static void b(ViewGroup viewGroup) {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, viewGroup) == null) || viewGroup == null || (layoutParams = viewGroup.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = n.f(TbadkApplication.getInst(), c.a.u0.a4.e.tbds120);
        viewGroup.setLayoutParams(layoutParams);
    }

    public static void c(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, textView) == null) || textView == null) {
            return;
        }
        c.a.t0.s.v.c.d(textView).v(c.a.u0.a4.d.CAM_X0107);
    }

    public static void d(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, textView) == null) || textView == null) {
            return;
        }
        c.a.t0.s.v.c.d(textView).z(c.a.u0.a4.e.tbds36);
    }

    public static void e(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, textView) == null) || textView == null) {
            return;
        }
        c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(textView);
        d2.z(c.a.u0.a4.e.tbds36);
        d2.v(c.a.u0.a4.d.CAM_X0107);
    }

    public static void f(TBLottieAnimationView tBLottieAnimationView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, tBLottieAnimationView, i2) == null) || tBLottieAnimationView == null) {
            return;
        }
        if (i2 != 1 && i2 != 4) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, c.a.u0.a4.i.lottie_agree_day);
        } else {
            SkinManager.setLottieAnimation(tBLottieAnimationView, c.a.u0.a4.i.lottie_agree_night);
        }
        tBLottieAnimationView.setColorFilter(SkinManager.getColor(c.a.u0.a4.d.CAM_X0107));
    }
}
