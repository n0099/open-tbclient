package c.a.q0.s.f0;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ImageView imageView, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, imageView, i2) == null) && imageView != null && c.a.q0.b.d.m()) {
            WebPManager.setPureDrawable(imageView, i2, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = c.a.e.e.p.l.g(TbadkApplication.getInst(), R.dimen.tbds52);
                layoutParams.height = c.a.e.e.p.l.g(TbadkApplication.getInst(), R.dimen.tbds52);
                imageView.setLayoutParams(layoutParams);
            }
        }
    }

    public static void b(ViewGroup viewGroup) {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, viewGroup) == null) || viewGroup == null || !c.a.q0.b.d.m() || (layoutParams = viewGroup.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = c.a.e.e.p.l.g(TbadkApplication.getInst(), R.dimen.tbds120);
        viewGroup.setLayoutParams(layoutParams);
    }

    public static void c(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, textView) == null) && textView != null && c.a.q0.b.d.m()) {
            c.a.q0.s.u.c.d(textView).w(R.color.CAM_X0107);
        }
    }

    public static void d(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, textView) == null) && textView != null && c.a.q0.b.d.m()) {
            c.a.q0.s.u.c.d(textView).A(R.dimen.tbds36);
        }
    }

    public static void e(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, textView) == null) && textView != null && c.a.q0.b.d.m()) {
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(textView);
            d2.A(R.dimen.tbds36);
            d2.w(R.color.CAM_X0107);
        }
    }

    public static void f(TBLottieAnimationView tBLottieAnimationView, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, tBLottieAnimationView, i2) == null) && tBLottieAnimationView != null && c.a.q0.b.d.m()) {
            if (i2 != 1 && i2 != 4) {
                SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.lottie_agree_day);
            } else {
                SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.lottie_agree_night);
            }
            tBLottieAnimationView.setColorFilter(SkinManager.getColor(R.color.CAM_X0107));
        }
    }
}
