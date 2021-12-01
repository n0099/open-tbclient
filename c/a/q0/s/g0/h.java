package c.a.q0.s.g0;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ImageView imageView, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, imageView, i2) == null) && imageView != null && c.a.q0.b.d.n()) {
            WebPManager.setPureDrawable(imageView, i2, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = c.a.d.f.p.l.f(TbadkApplication.getInst(), R.dimen.tbds52);
                layoutParams.height = c.a.d.f.p.l.f(TbadkApplication.getInst(), R.dimen.tbds52);
                imageView.setLayoutParams(layoutParams);
            }
        }
    }

    public static void b(ViewGroup viewGroup) {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, viewGroup) == null) || viewGroup == null || !c.a.q0.b.d.n() || (layoutParams = viewGroup.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = c.a.d.f.p.l.f(TbadkApplication.getInst(), R.dimen.tbds120);
        viewGroup.setLayoutParams(layoutParams);
    }

    public static void c(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, textView) == null) && textView != null && c.a.q0.b.d.n()) {
            c.a.q0.s.u.c.d(textView).v(R.color.CAM_X0107);
        }
    }

    public static void d(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, textView) == null) && textView != null && c.a.q0.b.d.n()) {
            c.a.q0.s.u.c.d(textView).z(R.dimen.tbds36);
        }
    }

    public static void e(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, textView) == null) && textView != null && c.a.q0.b.d.n()) {
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(textView);
            d2.z(R.dimen.tbds36);
            d2.v(R.color.CAM_X0107);
        }
    }

    public static void f(TBLottieAnimationView tBLottieAnimationView, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65541, null, tBLottieAnimationView, i2) == null) && tBLottieAnimationView != null && c.a.q0.b.d.n()) {
            if (i2 != 1 && i2 != 4) {
                SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.lottie_agree_day);
            } else {
                SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.lottie_agree_night);
            }
            tBLottieAnimationView.setColorFilter(SkinManager.getColor(R.color.CAM_X0107));
        }
    }
}
