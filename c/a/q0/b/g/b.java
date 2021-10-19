package c.a.q0.b.g;

import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.b.d;
import c.a.q0.s.q.d2;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return 3.0f;
        }
        return invokeV.floatValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? UtilHelper.getDimenPixelSize(R.dimen.M_W_X005) : invokeV.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public static void d(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65539, null, view, i2, i3) == null) || view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (d.k0()) {
            marginLayoutParams.topMargin = l.g(TbadkCoreApplication.getInst(), i3);
        } else {
            marginLayoutParams.topMargin = l.g(TbadkCoreApplication.getInst(), i2);
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static int e(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3)) == null) ? d.k0() ? i3 : i2 : invokeII.intValue;
    }

    public static void f(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, textView) == null) || textView == null) {
            return;
        }
        if (d.k0()) {
            textView.setTypeface(Typeface.DEFAULT);
            textView.setTextSize(0, textView.getResources().getDimension(R.dimen.tbds39));
            return;
        }
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(0, textView.getResources().getDimension(R.dimen.tbds42));
    }

    public static void g(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, textView) == null) || textView == null) {
            return;
        }
        if (d.k0()) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        } else {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
        }
    }

    public static void h(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65543, null, view, i2) == null) || view == null) {
            return;
        }
        if (d.k0()) {
            view.setBackgroundResource(R.drawable.bg_img_mask);
        } else if (i2 > 0) {
            view.setBackgroundResource(i2);
        } else {
            view.setBackgroundDrawable(null);
        }
    }

    public static void i(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, view) == null) || view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = 0;
        marginLayoutParams.rightMargin = 0;
        marginLayoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        view.setLayoutParams(marginLayoutParams);
    }

    public static void j(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, view) == null) || view == null) {
            return;
        }
        SkinManager.setBackgroundColor(view, R.color.CAM_X0202);
    }

    public static void k(d2 d2Var, int[] iArr) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, null, d2Var, iArr) == null) && iArr != null && iArr.length == 2 && d2Var != null && d.k0()) {
            int size = View.MeasureSpec.getSize(l.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
            int c2 = (c() * ((int) ((size - (dimensionPixelSize * 2)) / a()))) + dimensionPixelSize;
            MediaData mediaData = (MediaData) ListUtils.getItem(d2Var.E0(), 0);
            if (mediaData == null || (i2 = mediaData.picWidth) <= 0 || (i3 = mediaData.picHeight) <= 0) {
                return;
            }
            if (i2 == i3) {
                iArr[0] = c2;
                iArr[1] = c2;
            } else if (i2 > i3) {
                iArr[0] = c2;
                iArr[1] = (c2 * 3) / 4;
            } else {
                iArr[0] = c2;
                iArr[1] = (c2 * 4) / 3;
            }
        }
    }

    public static int[] l(MediaData mediaData) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, mediaData)) == null) {
            int[] iArr = new int[2];
            if (mediaData != null && d.k0()) {
                int size = View.MeasureSpec.getSize(l.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
                int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
                int c2 = (c() * ((int) ((size - (dimensionPixelSize * 2)) / a()))) + dimensionPixelSize;
                int i3 = mediaData.picWidth;
                if (i3 > 0 && (i2 = mediaData.picHeight) > 0) {
                    if (i3 == i2) {
                        iArr[0] = c2;
                        iArr[1] = c2;
                    } else if (i3 > i2) {
                        iArr[0] = c2;
                        iArr[1] = (c2 * 3) / 4;
                    } else {
                        iArr[0] = c2;
                        iArr[1] = (c2 * 4) / 3;
                    }
                }
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static void m(TextView textView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65548, null, textView, i2, i3) == null) || textView == null || Build.VERSION.SDK_INT < 16) {
            return;
        }
        if (d.k0()) {
            textView.setLineSpacing(l.g(textView.getContext(), i3), textView.getLineSpacingMultiplier());
        } else {
            textView.setLineSpacing(l.g(textView.getContext(), i2), textView.getLineSpacingMultiplier());
        }
    }

    public static boolean n(ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{layoutParams, layoutParams2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (layoutParams == null || layoutParams2 == null || !d.k0()) {
                return z;
            }
            int size = View.MeasureSpec.getSize(l.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
            int c2 = (c() * ((int) ((size - (dimensionPixelSize * 2)) / a()))) + dimensionPixelSize;
            layoutParams2.width = (l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44) * 2) + c2;
            int g2 = ((c2 * 4) / 3) + l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
            layoutParams2.height = g2;
            layoutParams.height = g2;
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean o(ViewGroup.LayoutParams layoutParams, boolean z, c.a.r0.q2.q.a aVar, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{layoutParams, Boolean.valueOf(z), aVar, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (layoutParams == null || !d.k0()) {
                return z;
            }
            int size = View.MeasureSpec.getSize(l.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
            int c2 = (c() * ((int) ((size - (dimensionPixelSize * 2)) / a()))) + dimensionPixelSize;
            layoutParams.width = c2;
            int i4 = (c2 * 4) / 3;
            layoutParams.height = i4;
            boolean z2 = (c2 == i2 && i4 == i3) ? false : true;
            if (aVar != null) {
                aVar.E(0);
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }
}
